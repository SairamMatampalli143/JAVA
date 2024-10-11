package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertData {
	private static Connection con;
	private static PreparedStatement pstmt;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sairam","root","3624");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String insertData= "insert into employee(`E_name`,`E_Age`,`salary`,`gender`) values(?,?,?,?);";
		try {
			pstmt = con.prepareStatement(insertData);
			System.out.println("Enter name: ");
			String name= sc.nextLine();
			System.out.println("Enter Age: ");
			int age = sc.nextInt();
			System.out.println("Enter salary: ");
			int salary = sc.nextInt();
			System.out.println("Enter Department: ");
			String dept = sc.next();
			System.out.println("Enter Gender: ");
			String gender =sc.next();
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setInt(3, salary);
			pstmt.setString(4, gender);
			pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
