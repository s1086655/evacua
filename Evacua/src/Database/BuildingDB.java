package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Main.DataResource.Building;

public class BuildingDB {
	
	public static void InsertUpdate(Building buil) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Statement stmt = null;
		String queryInsert = "INSERT INTO building (building, name, address) VALUES (?,?,?)";
   	    String queryUpdate = "UPDATE building SET name=?, address=? WHERE bulding=?";
   	    String querySelect = "SELECT true FROM building WHERE building="+buil.getBuilding()+"";
   	    
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
				pst.setString(1, buil.getName());
				pst.setString(2, buil.getAddress());
				pst.setInt(3, buil.getBuilding());
				pst.executeUpdate();
			}
			else if(conerr){
				pst = conn.prepareStatement(queryInsert);
				pst.setInt(1, buil.getBuilding());
				pst.setString(2, buil.getName());
				pst.setString(3, buil.getAddress());
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
	
	public static boolean SearchBuilding(int build) {
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		String querySelect = "SELECT true FROM building WHERE building="+build+"";
		boolean trovato =false;
		try {
			conn = ConfigDB.connettidb();
	    	stmt = conn.createStatement();
			rs = stmt.executeQuery(querySelect);
			trovato = rs.getBoolean("true");
	    }
	    catch(SQLException e) {
	    		JOptionPane.showMessageDialog(null, e);
	    		
	    }
	    finally {
	    	ConfigDB.close(stmt);
	    	ConfigDB.close(conn);
	    }
		return trovato;
	}

}
