package hscard;

public interface ConnectDB {
	public final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	public final String DB_USR = "pman";
	public final String DB_PASSWORD = "oracle";
	public final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	public void ConnectDB();
	public void closeDB();
}
