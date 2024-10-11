package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Connector.ConnectorFactory;
import DTO.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{


	public List getEmployees() {
		ArrayList<Employee> empList=null;
		try {
			Connection con =ConnectorFactory.requestConnection();
			String query = "select * from emp";
			Statement stmt = con.createStatement();
			ResultSet res=stmt.executeQuery(query);
			empList = new ArrayList<Employee>();
			
			while(res.next()==true) {
				int id =res.getInt(1);
				String name = res.getString(2);
				String designation =res.getString(3);
				int salary = res.getInt(4);
				Employee e =new Employee(id,name,designation,salary);
				empList.add(e);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	public Employee getEmployee(int id) {
		Employee e = null;
		try {
			Connection con =ConnectorFactory.requestConnection();
			String query = "select * from emp where id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			res.next();
			e = new Employee(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4));
			
		}
		catch(Exception e2) {
			e2.printStackTrace();
		}
		return e;
		
	}

	public boolean insertEmployee(int id, String name, String designation, int salary) {
		int i=0;
		try {
			Connection con =ConnectorFactory.requestConnection();
			String query = "insert into emp(`id`,`name`,`designation`,`salary`) values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, designation);
			pstmt.setInt(4, salary);
			i=pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(i==0) {
			return false;
		}
		else {
			return true;
		}
	}

	public boolean updateEmployee(Employee e) {
		Employee emp=new Employee();
		int i=0;
		try {
			Connection con =ConnectorFactory.requestConnection();
			Scanner sc = new Scanner(System.in);
			
			String query = "update emp set name=?, designation=?,salary =? where id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, emp.getName());
			pstmt.setString(2, emp.getDesignation());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setInt(4, emp.getId());
			i = pstmt.executeUpdate();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		if(i==1) {
			return true;
		}
		else {
			return false;
		}
		
	}
			
		

	public boolean deleteEmployee(int id) {
		int i=0;
		try {
			Connection con =ConnectorFactory.requestConnection();
			System.out.println("Select which one you want to Delete:");
			String query = "delete from emp where id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			i = pstmt.executeUpdate();
			
		}
		catch(Exception e2) {
			e2.printStackTrace();
		}
		if(i==0) {
			return false;
		}
		else {
			return true;
		}
	}

	
	
	
	
}
