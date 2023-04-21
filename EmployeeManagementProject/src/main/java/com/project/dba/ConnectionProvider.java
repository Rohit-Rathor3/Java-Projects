package com.project.dba;


// This class is providing the DB connection
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	public static Connection getConnection()
	{
		Connection con =null;
		try {
			// loading the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_project","root","root");
		}
		catch(SQLException e)
		{
			System.out.println("---> "+ e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println("----> "+e.getMessage());
		}
		return con;
	}
}
