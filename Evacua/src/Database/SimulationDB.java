package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Main.DataResource.Simulation;

public class SimulationDB {
	
	public static void InsertUpdate(Simulation sim) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Statement stmt = null;
		String queryInsert = "INSERT INTO simulation (edge, ostruzione_tronco, stato_pericolo, vulnerabilita_edif, illuminamento) VALUES (?,?,?,?,?)";
   	    String queryUpdate = "UPDATE simulation SET ostruzione_tronco=?, stato_pericolo=?, vulnerabilita_edif=?, illuminamento=? WHERE edge=?";
   	    String querySelect = "SELECT true FROM simulation WHERE edge="+sim.getEdge()+"";
   	    
   	    try {
   	    	boolean trovato = false;
   	    	boolean conerr =true;
   	    	conn = ConfigDB.connettidb();
   	    	try {
   	    		stmt = conn.createStatement();
   				rs = stmt.executeQuery(querySelect);
   				trovato = rs.getBoolean("true");
   	    	}
   	    	catch(SQLException e) {
   	    		JOptionPane.showMessageDialog(null, e);
   	    		conerr = false;
   	    	}
   	    	finally {
   	    		ConfigDB.close(stmt);
   	    	}
   	    	
			if(trovato && conerr) {
				pst = conn.prepareStatement(queryUpdate);
				pst.setFloat(1, sim.getOstruzione_tronco());
				pst.setFloat(2, sim.getStato_pericolo());
				pst.setFloat(3, sim.getVulnerabilita_edif());
				pst.setFloat(4, sim.getIlluminamento());
				pst.setInt(5, sim.getEdge());
				pst.executeUpdate();
			}
			else if(conerr){
				pst = conn.prepareStatement(queryInsert);
				pst.setInt(1, sim.getEdge());
				pst.setFloat(2, sim.getOstruzione_tronco());
				pst.setFloat(3, sim.getStato_pericolo());
				pst.setFloat(4, sim.getVulnerabilita_edif());
				pst.setFloat(5, sim.getIlluminamento());
				pst.executeUpdate();
			}
   	    }
   	    catch(SQLException e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
    	finally {
    		ConfigDB.close(pst);
    		ConfigDB.close(conn);
    	}
	}
	
	public static List<Simulation> Select (){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =null;
		String query = "SELECT * FROM simulation WHERE 1";
		List<Simulation> simulation = new ArrayList<>();
		try {
			conn = ConfigDB.connettidb();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			Simulation sim = new Simulation();
			while(rs.next()) {
				sim.setEdge(rs.getInt("edge"));
				sim.setOstruzione_tronco(rs.getFloat("ostruzione_tronco"));
				sim.setStato_pericolo(rs.getFloat("stato_pericolo"));
				sim.setVulnerabilita_edif(rs.getFloat("vulnerabilita_edif"));
				sim.setIlluminamento(rs.getFloat("illuminamento"));
				
				simulation.add(sim);
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		finally {
			ConfigDB.close(stmt);
			ConfigDB.close(conn);
		}
		return simulation;
	}

}
