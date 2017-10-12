package hscard.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SuperDao {
	//Instance
	protected Connection conn = null;
	private final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private final String DB_USR = "pman";
	private final String DB_PASSWORD = "oracle";
	private final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	//Constructor
	public SuperDao() {
		try {
			Class.forName(DB_DRIVER);
			this.conn = getConnection();
			if (conn != null) {
				//System.out.println("DB_OKAY");
			} else {
				System.out.println("DB_ERROR");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("check oracle jar file");
			e.printStackTrace();
		}
	}
	
	//Method
	protected Connection getConnection(){
		try {
			return DriverManager.getConnection(DB_URL, DB_USR, DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void closeConnection(){
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
	}	
	
}
