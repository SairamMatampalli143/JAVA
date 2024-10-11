package Connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectorFactory {
	static Connection con=null;
	static String url = "jdbc:mysql://localhost:3306/employee";
	static String userName = "root";
	static String password = "3624";

	
	public static Connection requestConnection() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,userName,password);
		return con;
	}
}
