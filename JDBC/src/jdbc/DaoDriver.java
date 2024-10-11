package jdbc;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import DAO.EmployeeDAOImpl;
import DTO.Employee;

public class DaoDriver {
	Connection con;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeDAOImpl emplDAOImpl = new EmployeeDAOImpl();
		
		System.out.println("<--------------Welcome to Employee DataBase-------------->");
		System.out.println("Select Operation to perform\n");
		System.out.println("1.Select All Employees Data\n2.Select Employee With Employee ID\n3.Insert Data to the Employee Database\n4.Update details of employee\n5.Delete Data with Employee ID");
		int operation=sc.nextInt();
		switch (operation) {
		case 1:
			List<Employee> employee =emplDAOImpl.getEmployees();
			for(Employee e : employee) {
				System.out.println(e);
							
			}
			break;
		case 2:
			System.out.println("Enter the employee Id to update: ");
			int id = sc.nextInt();
			Employee e = emplDAOImpl.getEmployee(id);
			System.out.println(e);
			break;
		case 3:
			System.out.println("Enter how Many employees you want to enter: ");
			int count =sc.nextInt();
			for(int i=0;i<count;i++) {
				System.out.println("Enter Employee ID: ");
				int eId =sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Employee Name:");
				String name = sc.nextLine();
				System.out.println("Enter Employee Designation:");
				String designation = sc.nextLine();
				System.out.println("Enter Employee salary: ");
				int salary =sc.nextInt();
				emplDAOImpl.insertEmployee(eId, name, designation, salary);
			}
			System.out.println(count+"Rows Inserted into Employee Database");
			break;
			
		case 4:
			List<Employee> emp =emplDAOImpl.getEmployees();
			for(Employee emp1 : emp) {
				System.out.println(emp1);
							
			}
			System.out.println("Enter ID");
			int eid=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Updated Name:");
			String uname=sc.nextLine();
			System.out.println("Enter Updated Designation: ");
			String udesignation = sc.next();
			System.out.println("Enter Updated Salary");
			int usalary = sc.nextInt();
			Employee employee1=new Employee();
			employee1.setName(uname);
			employee1.setDesignation(udesignation);
			employee1.setSalary(usalary);
			
			Employee emp1 = emplDAOImpl.getEmployee(eid);
			System.out.println(emp1);
			
			System.out.println(emplDAOImpl.updateEmployee(emp1));
			break;
		case 5:
			List<Employee> emp11 =emplDAOImpl.getEmployees();
			for(Employee emp111 : emp11) {
				System.out.println(emp111);
							
			}
			System.out.println("Enter Employee id to delete");
			int delId = sc.nextInt();
			System.out.println(emplDAOImpl.deleteEmployee(delId));
			break;
		default:
			break;
		}
		
		
	}
}
