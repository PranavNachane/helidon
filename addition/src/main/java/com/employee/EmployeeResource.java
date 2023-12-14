package com.employee;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hr")
public class EmployeeResource {
	
	@Inject
	EmployeeRepository database;
	
	@Path("/employees")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Employee> getAllEmployees() {
		return database.getAllEmployees();
	}
	
	@Path("/employees/{paramEmpId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getSingleEmployee(@PathParam("paramEmpId") Integer empId) {
		return database.getEmployeeById(empId);
	}
	



}
