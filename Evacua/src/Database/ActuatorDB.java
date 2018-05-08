package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Main.DataResource.Actuator;

public class ActuatorDB {
	
	public static void InsertUpdate(Actuator act) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Statement stmt = null;
   	    String queryInsert = "INSERT INTO actuator (actuator, edge, type) VALUES (?,?,?)";
   	    String queryUpdate = "UPDATE actuator SET edge=?, type=? WHERE actuator=?";
   	    String querySelect = "SELECT true FROM actuator WHERE actuator="+act.getActuator()+"";
   	    
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
				pst.setInt(1, act.getEdge());
				pst.setString(2, act.getType());
				pst.setInt(3, act.getActuator());
				pst.executeUpdate();
			}
			else if(conerr){
				pst = conn.prepareStatement(queryInsert);
				pst.setInt(1, act.getActuator());
				pst.setInt(2, act.getEdge());
				pst.setString(3, act.getType());
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

}
