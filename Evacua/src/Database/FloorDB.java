package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Main.DataResource.Floor;

public class FloorDB {
	
	public static void InsertUpdate(Floor floor) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Statement stmt = null;
		String queryInsert = "INSERT INTO floor (floor, building, floor_number) VALUES (?,?,?)";
   	    String queryUpdate = "UPDATE floor SET building=?, floor_number=? WHERE floor=?";
   	    String querySelect = "SELECT true FROM floor WHERE floor="+floor.getFloor()+"";
   	    
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
				pst.setInt(1, floor.getBuilding());
				pst.setInt(2, floor.getFloor_number());
				pst.setInt(3, floor.getFloor());
				pst.executeUpdate();
			}
			else if(conerr){
				pst = conn.prepareStatement(queryInsert);
				pst.setInt(1, floor.getFloor());
				pst.setInt(2, floor.getBuilding());
				pst.setInt(3, floor.getFloor_number());
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
	
	public static List<Integer> SelectFloor(int building) {
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		String querySelect = "SELECT floor FROM floor WHERE building="+building+"";
		List<Integer> floor = new ArrayList<>();
		try {
			conn = ConfigDB.connettidb();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(querySelect);
			while(rs.next()) {
				floor.add(rs.getInt("floor"));
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		finally {
			ConfigDB.close(stmt);
    		ConfigDB.close(conn);
		}
		return floor;
	}

}
