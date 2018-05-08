 package Database;

import java.sql.*;

import javax.swing.JOptionPane;


public class ConfigDB {
	 private static  Connection conn = null;		
    private static String USERNAME="eva"; // Nome utente utilizzato per la connessione al Database
	private static String PASSWORD="eva"; // Password usata per la connessione al Database
	private static String CONN_STRING="jdbc:mysql://localhost:3306/";
	private static String DBNAME = "evacua";
	private static final String DRIVER_STRING = "com.mysql.jdbc.Driver";

	/**
	* Inizializza la connessione al DB.
	* @return
	*
	*,PASSWORD
	*/
	
	public static Connection connettidb(){
	try{
		
	Class.forName(DRIVER_STRING);
	conn = DriverManager.getConnection(CONN_STRING+DBNAME,USERNAME,PASSWORD);
	return conn;
	}catch (ClassNotFoundException | SQLException e){
		JOptionPane.showMessageDialog(null,e);
	return null;
	}
	
	}
	/**
	* Chiude la connessione al DB.
	* @param conn
	*/
	public static void close(Connection conn) {
	if (conn != null) {
	try{
	conn.close();
	}
	catch(SQLException e){
	System.err.println(e);
	}
	}
	}
	/**
	* Chiude la Statement utilizzata.
	* @param stmt
	*/
	public static void close(Statement stmt) {
	if (stmt != null) {
	try{
	stmt.close();
	}
	catch (SQLException e){
	System.err.println(e);
	}
	}
	}
	/**
	* Chiude la PreparedStatement utilizzata.
	* @param pst
	*/
	public static void close(PreparedStatement pst) {
	if (pst != null) {
		try{
			pst.close();
			}
		catch (SQLException e){
		System.err.println(e);
	}
	}
}

}
