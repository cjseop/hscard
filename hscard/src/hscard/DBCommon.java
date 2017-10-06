package hscard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCommon implements ConnectDB {
	
	Connection conn = null;
	
	public DBCommon() {
		ConnectDB();
	}
	
	@Override
	public void ConnectDB() {
		try {
			Class.forName(ConnectDB.DB_DRIVER);
			conn = DriverManager.getConnection(ConnectDB.DB_URL, ConnectDB.DB_USR,	ConnectDB.DB_PASSWORD);
			if(conn != null){
				System.out.println("DB_okay");
			}else{
				System.out.println("DB_fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void closeDB() {
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
