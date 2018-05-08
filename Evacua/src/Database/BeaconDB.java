package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Main.DataResource.Beacon;

public class BeaconDB {
	
	public static void InsertUpdate(Beacon beac) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Statement stmt = null;
   	    String queryInsert = "INSERT INTO beacon (beacon, floor, x, y, uuid, major, minor) VALUES (?,?,?,?,?,?,?)";
   	    String queryUpdate = "UPDATE beacon SET floor=?, x=?, y=?, uuid=?, major=?, minor=? WHERE beacon=?";
   	    String querySelect = "SELECT true FROM beacon WHERE beacon="+beac.getBeacon()+"";
   	    
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
				pst.setInt(1, beac.getFloor());
				pst.setFloat(2, beac.getX());
				pst.setFloat(3, beac.getY());
				pst.setString(4, beac.getUuid());
				pst.setString(5, beac.getMajor());
				pst.setString(6, beac.getMinor());
				pst.setInt(7, beac.getBeacon());
				pst.executeUpdate();
			}
			else if(conerr){
				pst = conn.prepareStatement(queryInsert);
				pst.setInt(1, beac.getBeacon());
				pst.setInt(2, beac.getFloor());
				pst.setFloat(3, beac.getX());
				pst.setFloat(4, beac.getY());
				pst.setString(5, beac.getUuid());
				pst.setString(6, beac.getMajor());
				pst.setString(7, beac.getMinor());
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
