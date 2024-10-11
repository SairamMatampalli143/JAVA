package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Demo {
	private static Connection con;
	private static Statement stmt;
	private static ResultSet resultSet;
	private static ResultSetMetaData metadata;

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/sairam";
		String userName = "root";
		String password = "3624";
		String select = "select * from employee";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			con = DriverManager.getConnection(url,userName,password);
			System.out.println("Connection Established");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,0);
			resultSet = stmt.executeQuery(select);
//			
//			resultSet.next();
//			System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2));
//					
//			resultSet.absolute(1);
//			System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2));

			metadata = resultSet.getMetaData();
			for(int i=1;i<=metadata.getColumnCount();i++) {
				System.out.print(metadata.getColumnTypeName(i)+"   ");
			}
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"   "+
									resultSet.getString(2));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
