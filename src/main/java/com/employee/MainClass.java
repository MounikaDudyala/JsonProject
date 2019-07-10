package com.employee;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainClass {

	public static void main(String args[]) {
		 Connection conn=null;
		   Statement statement=null;
		   String url       = "jdbc:mysql://localhost:3306/database2";
		   String user      = "root";
		   String password  = "root";
		   String driver="com.mysql.jdbc.Driver";
			 List<Employee> employeeList=new ArrayList<Employee>();

			try {
			  
				Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			 statement=conn.createStatement();
			String sql="select * from employee";
			 ResultSet rs = statement.executeQuery(sql);
			 while(rs.next())
			 {
				 String name=rs.getString("name");
				 int id=rs.getInt("id");
				 int managerId=rs.getInt("managerid");
				 Employee emp=new Employee(id,name,managerId);
				 employeeList.add(emp);
				 			 
			 }
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e){
		      
		      e.printStackTrace();
		   }finally{
		     
		      try{
		         if(statement!=null)
		            conn.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
			 ObjectMapper obj = new ObjectMapper();
			try {
				  
				obj.writeValue(new File("target/emp.json"), employeeList);
				List<Employee > empl=obj.readValue(new File("target/emp.json"),  new TypeReference<List<Employee>>(){});
				   for(Employee emp1:empl)
				System.out.println(emp1.empId+" "+emp1.empName+" "+emp1.managerId);
				
				
	}catch(IOException e) {
		e.printStackTrace();
	}
	}
}
	
