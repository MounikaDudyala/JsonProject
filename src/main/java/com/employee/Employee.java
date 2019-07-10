package com.employee;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName(value = "Employee")
public class Employee {

	public String empName;
	public int empId;
	public int managerId;
	public Employee()
	{
		
	}
	
	public Employee(int empId,String empName,int managerId)
	{
		this.empName=empName;
		this.empId=empId;
		this.managerId=managerId;
		
	}
	
	@JsonGetter("empName")
	public String getEmployeeName()
	{
		return empName;
	}
	@JsonGetter("empId")
	public int getEmployeeId()
	{
		return empId;
	}
	@JsonGetter("managerId")
	public int getManagerId()
	{
		return managerId;
	}
	 
}
