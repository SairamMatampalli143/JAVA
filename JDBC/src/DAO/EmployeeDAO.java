package DAO;

import java.util.List;

import DTO.Employee;



public interface EmployeeDAO {
	List getEmployees() throws Exception;
	
	Employee getEmployee(int id);
	
	boolean insertEmployee(int id,String name, String designation, int salary);
	
	boolean updateEmployee(Employee e);
	
	boolean deleteEmployee(int id);
	
	
	
	
}
