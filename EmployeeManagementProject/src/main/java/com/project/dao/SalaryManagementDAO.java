package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.beans.SalaryBean;
import com.project.dba.ConnectionProvider;

public class SalaryManagementDAO {

	private final static String  GET_TOTAL_ATTENDANCE = "SELECT SUM(ATTENDANCE) FROM ATTENDANCE_MANAGEMENT WHERE IDNO = (?)";
	private final static String GET_SALARY = "SELECT SALARY FROM EMPLOYEE_REGISTRATION WHERE IDNO = (?)";
	private final static String GET_DEPOSITED_SALARY = "SELECT DEPOSITEDSALARY FROM SALARY_MANAGEMENT WHERE IDNO =(?)";
	private final static String DEPOSITE_SALARY_IF_NOT_REGISTERED = "INSERT INTO SALARY_MANAGEMENT VALUES(?,?)";
	private final static String DEPOSITE_SALARY_IF_REGISTERED = "UPDATE SALARY_MANAGEMENT SET DEPOSITEDSALARY = DEPOSITEDSALARY+(?) WHERE IDNO =(?)";
	private final static String DELETE_DEPOSITED_ON_EMP_DELETE = "DELETE FROM SALARY_MANAGEMENT WHERE IDNO =(?)";
//	private final static String CHECK_EMP_REGISTERED_OR_NOT = "SELECT IDNO FROM SALARY_MANAGEMENT WHERE IDNO =(?)";
	
	
	// generate total salary
	public static float getTotalAttendanceCount(String id)
	{
		Connection con = null;
		ResultSet rs =null;
		PreparedStatement ps =null;
		float attendanceCount = 0;
		try {
			con= ConnectionProvider.getConnection();
			ps = con.prepareStatement(GET_TOTAL_ATTENDANCE);
			ps.setString(1, id);
		     rs = ps.executeQuery();
		     if(rs.next())
		     {
		    	 attendanceCount = rs.getFloat(1);
		    	 
		     }				
		}
		catch(Exception e)
		{
			System.out.println("SalaryManagementDAO.getTotalAttendanceCount()"+e.getMessage());
		}
		finally {
			try {
				con.close();
				ps.close();
				rs.close();
			}
			catch(Exception e)
			{
				System.out.println("generateTotalAttendance().generateTotalAttendance() " + e.getMessage());
			}
		}
		return attendanceCount;
		
	}
	
	
	
	// get salary
	// generate total salary
		public static float getSalary(String id)
		{
			Connection con = null;
			ResultSet rs =null;
			PreparedStatement ps =null;
			float salary = 0;
			try {
				con= ConnectionProvider.getConnection();
				ps = con.prepareStatement(GET_SALARY);
				ps.setString(1, id);
			     rs = ps.executeQuery();
			     if(rs.next())
			     {
			    	 salary = rs.getFloat(1);
			    	 
			     }				
			}
			catch(Exception e)
			{
				System.out.println("SalaryManagementDAO.getSalary()" + e.getMessage());
			}
			finally {
				try {
					con.close();
					ps.close();
					rs.close();
				}
				catch(Exception e)
				{
					System.out.println("SalaryManagementDAO.getSalary()" + e.getMessage());
				}
			}
			return salary;
			
		}
	
		
		// generate totalSalary
		
		public static float generateTotalSalary(String id)
		{
			float attendance = getTotalAttendanceCount(id);
			float salary = getSalary(id);
			float totalSalary = attendance*((12*salary)/365);
			return totalSalary;
		}
	
	// geT deposited salary
	
	public static float getDepositedSalary(String id)
	{
		Connection con = null;
		ResultSet rs =null;
		PreparedStatement ps =null;
		float depositedSalary =0;
		try {
			con= ConnectionProvider.getConnection();
			ps = con.prepareStatement(GET_DEPOSITED_SALARY);
			ps.setString(1, id);
		     rs = ps.executeQuery(); 
		     if(rs!=null)
		     {
		    	 rs.next();
		    	 depositedSalary = rs.getFloat(1);
		     }
		     else
		     {
		    	 depositedSalary =0;
		     }
				
		}
		catch(Exception e)
		{
		
			System.out.println("SalaryManagementDAO.getDepositedSalary() "+e.getMessage());
		}
		finally {
			try {
				con.close();
				ps.close();
				rs.close();
			}
			catch(Exception e)
			{
				System.out.println("SalaryManagementDAO.getDepositedSalary() " + e.getMessage());
			}
		}
		return depositedSalary;
		
	}
	
	
	// generate final or payable salary
	public static float generateFinalSalary(String id) 
	{
		float finalSalary= generateTotalSalary(id)-getDepositedSalary(id);
		return finalSalary;
		
	}
	
	public static void insertSalary(String id , float sal)
	{
		Connection con =null;
		PreparedStatement ps =null;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(DEPOSITE_SALARY_IF_NOT_REGISTERED);
			ps.setString(1,id);
			ps.setFloat(2, sal);
			int result = ps.executeUpdate();
			if(result >0)
			{
				System.out.println("SalaryManagementDAO.insertSalary() "+"Initial Salary deposited successfully !!");
			}
			else
				System.out.println("SalaryManagementDAO.insertSalary() "+"Fail to insert Initial Salary !!");
			
		}
		catch(Exception e)
		{
			System.out.println("SalaryManagementDAO.insertSalary() "+e.getMessage());
		}
		finally {
			try {
				con.close();
				ps.close();
			}
			catch(Exception e)
			{
				System.out.println("SalaryManagementDAO.insertSalary() "+e.getMessage());
			}
		}
		
	}
	
	// update salary
	public static int updateSalary(String id,float depositeSal)
	{
		Connection con = null;
		PreparedStatement ps = null;
		int result =0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(DEPOSITE_SALARY_IF_REGISTERED);
			ps.setFloat(1, depositeSal);
			ps.setString(2, id);
			 result = ps.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			System.out.println("SalaryManagementDAO.updateSalary() "+ e.getMessage());
		}
		finally {
			try {
				con.close();
				ps.close();
			}
			catch(Exception e)
			{
				System.out.println("SalaryManagementDAO.updateSalary() "+ e.getMessage() );
			}
		}
		return result;
	}
	
	public static void deleteEmpFromSalaryMgmt(String id)
	{
		Connection con= null;
		PreparedStatement ps =null;
		try {
			con = ConnectionProvider.getConnection();
		     ps = con.prepareStatement(DELETE_DEPOSITED_ON_EMP_DELETE);	
		     ps.setString(1, id);
		     int result = ps.executeUpdate();
		    if(result>0)
		    	System.out.println("SalaryManagementDAO.deleteEmpFromSalaryMgmt() "+" Employee details deleted from Salary_Mgmt successfully");
		    else
		    	System.out.println("SalaryManagementDAO.deleteEmpFromSalaryMgmt() "+"Fail to delete Employee details from Salary_Mgmt");
		}
		catch(Exception e)
		{
			System.out.println("SalaryManagementDAO.deleteEmpFromSalaryMgmt() "+e.getMessage());
		}
		finally {
			try {
				con.close();
				ps.close();
			}
			catch(Exception e)
			{
				System.out.println("SalaryManagementDAO.deleteEmpFromSalaryMgmt() "+e.getMessage());
			}
		}
	}
	
}
