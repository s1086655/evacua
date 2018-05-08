package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList; 

import javax.swing.JOptionPane;

import Main.DataResource.Edge;

public class EdgeDB {
	
	public static void InsertUpdate(Edge edge) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Statement stmt = null;
		String queryInsert = "INSERT INTO edge (edge, floor_start, floor_end, x_start, y_start, x_end, y_end, distance, area) VALUES (?,?,?,?,?,?,?,?,?)";
   	    String queryUpdate = "UPDATE edge SET floor_start=?, floor_end=?, x_start=?, y_start=?, x_end=?, y_end=?, distance=?, area=? WHERE edge=?";
   	    String querySelect = "SELECT true FROM edge WHERE edge="+edge.getEdge()+"";
   	    
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
				pst.setInt(1, edge.getFloor_start());
				pst.setInt(2, edge.getFloor_end());
				pst.setFloat(3, edge.getX_start());
				pst.setFloat(4, edge.getY_start());
				pst.setFloat(5, edge.getX_end());
				pst.setFloat(6, edge.getY_end());
				pst.setFloat(7, edge.getDistance());
				pst.setFloat(8, edge.getArea());
				pst.setInt(9, edge.getEdge());
				pst.executeUpdate();
			}
			else if(conerr){
				pst = conn.prepareStatement(queryInsert);
				pst.setInt(1, edge.getEdge());
				pst.setInt(2, edge.getFloor_start());
				pst.setInt(3, edge.getFloor_end());
				pst.setFloat(4, edge.getX_start());
				pst.setFloat(5, edge.getY_start());
				pst.setFloat(6, edge.getX_end());
				pst.setFloat(7, edge.getY_end());
				pst.setFloat(8, edge.getDistance());
				pst.setFloat(9, edge.getArea());
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
	
	public static List<Edge> Select (List<Integer> floor){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =null;
		//String query = "SELECT * FROM edge WHERE floor_start="+floor.get(i)+"";
		List<Edge> edge = new ArrayList<>();
		try {
			conn = ConfigDB.connettidb();
			for(int i=0; i<floor.size(); i++) {
				String query = "SELECT * FROM edge WHERE floor_start="+floor.get(i)+"";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				Edge ed = new Edge();
				while(rs.next()) {
					ed.setEdge(rs.getInt("edge"));
					ed.setFloor_start(rs.getInt("floor_start"));
					ed.setFloor_end(rs.getInt("floor_end"));
					ed.setX_start(rs.getFloat("x_start"));
					ed.setY_start(rs.getFloat("y_start"));
					ed.setX_end(rs.getFloat("x_end"));
					ed.setY_end(rs.getFloat("y_end"));
					ed.setDistance(rs.getFloat("distance"));
					ed.setArea(rs.getFloat("area"));
					edge.add(ed);
					ConfigDB.close(stmt);
				}
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		finally {
			ConfigDB.close(stmt);
			ConfigDB.close(conn);
		}
		return edge;
	}

}
