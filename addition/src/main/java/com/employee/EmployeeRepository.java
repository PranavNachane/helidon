package com.employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.enterprise.context.Dependent;

@Dependent
public class EmployeeRepository {
	
private static Map<Integer, Employee> database;
	
	static {
		database = new HashMap<>();
		database.put(100, new Employee(100, "James Cooper", 2134));
		database.put(200, new Employee(200, "Steven King", 1234));
		database.put(300, new Employee(300, "Neena Kocchar", 1234));
	}

	public Collection<Employee> getAllEmployees(){
		return database.values();
	}
	
	public Employee getEmployeeById(Integer empId) {
		return database.get(empId);
	}
	
	public void createEmployee(Employee emp) {
		System.out.println("EmployeeRepository.createEmployee: Employee Id - " + emp.getId());
		database.put(emp.getId(), emp);
	}
	
	public Collection<Employee> getAllEmployeesWithGivenSalary(Integer salary){
		ArrayList employees = new ArrayList();
		Iterator<Employee> it = database.values().iterator();
		while(it.hasNext()) {
			Employee emp = it.next();
			if(emp.getSalary().equals(salary))
				employees.add(emp);
		}
		return employees;
	}
	
	public void updateEmployee(Integer empId, Employee emp) {
		database.put(empId, emp);
	}
	
	public void deleteEmployee(Integer empId) {
		database.remove(empId);
	}


}
