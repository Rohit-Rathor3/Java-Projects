package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.project.beans.AttendenceBean;
import com.project.beans.EmployeeBean;
import com.project.dba.ConnectionProvider;

public class AttendanceDAO {
	private static final String GET_EMPLOYEE_FOR_ATTENDANCE = "SELECT NAME ,FNAME , IDNO  FROM EMPLOYEE_REGISTRATION";
	private static final String GET_ALL_EMP_BY_ID_NO = "SELECT IDNO FROM EMPLOYEE_REGISTRATION";
	private static final String INSERT_ATTENDANCE  =" INSERT INTO ATTENDANCE_MANAGEMENT VALUES(?,?,?,?)";
    private static final String GET_ATTENDANCE_OF_PARTICULAR_DATE ="SELECT NAME, IDNO,ATTENDANCE FROM  ATTENDANCE_MANAGEMENT WHERE DATE=(?)";
    private static final String UPDATE_ATTENDANCE = "UPDATE ATTENDANCE_MANAGEMENT SET ATTENDANCE=(?) WHERE IDNO=(?) AND DATE=(?)";
	
    
    public static String getInsertingDate()
	{
		LocalDateTime date = LocalDateTime.now();
		String requiredDate = date.getYear()+"-"+date.getMonthValue()+"-"+date.getDayOfMonth();
		return requiredDate;		
	}
    
    public static List<EmployeeBean> getAllEmployeeForAttendance()
	{
		
		List empList = new ArrayList();
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
		con = ConnectionProvider.getConnection();
		ps =  con.prepareStatement(GET_EMPLOYEE_FOR_ATTENDANCE);
		rs  =ps.executeQuery();
		while(rs.next())
		{
			EmployeeBean emp = new EmployeeBean();
			emp.setName(rs.getString(1));
			emp.setFname(rs.getString(2));
			emp.setIdno(rs.getString(3));
			
			empList.add(emp);
			
		}		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			try {
				con.close();
				}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
			try {
				ps.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			try {
				rs.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		return empList;
	}
	
	// GET ATTENDANCE OF PARTICULAR DATE
	public static List<AttendenceBean> getAttendanceOfParticularDay(String date)
	{
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		List<AttendenceBean> empList = new ArrayList();
		try {
		con = ConnectionProvider.getConnection();
		ps =con.prepareStatement(GET_ATTENDANCE_OF_PARTICULAR_DATE);
		ps.setString(1, date);
		rs= ps.executeQuery();
		while(rs.next())
		{
			AttendenceBean attend = new AttendenceBean();
			attend.setName(rs.getString(1));
			attend.setIdno(rs.getString(2));
			attend.setAttendence(rs.getFloat(3));
			
			empList.add(attend);
		}
		}
		catch(Exception e)
		{
			System.out.println("AttendanceDAO.getAttendanceOfParticularDay()"+e.getMessage());
		}
		finally {
			try {
				con.close();
				rs.close();
				ps.close();
			}
			catch(Exception e1)
			{
				System.out.println("AttendanceDAO.getAttendanceOfParticularDay() "+e1.getMessage());
			}
		}
		return empList;
		
	}
	
	//         get all id number 
	public static List<EmployeeBean> getAllIdNo()
	{
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		List<EmployeeBean> empList = new ArrayList();
		try {
		con = ConnectionProvider.getConnection();
		ps =  con.prepareStatement(GET_ALL_EMP_BY_ID_NO);
		rs  =ps.executeQuery();
		while(rs.next())
		{
			EmployeeBean emp = new EmployeeBean();
			emp.setIdno(rs.getString(1));
			
			
			empList.add(emp);
			
		}		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			try {
				con.close();
				}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
			try {
				ps.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			try {
				rs.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		return empList;
		
	}
	
	public static int insertAttendance(AttendenceBean e)
	{
		Connection con =null;
		PreparedStatement ps =null;
		int result =0;
		try {
		con = ConnectionProvider.getConnection();
		ps =  con.prepareStatement(INSERT_ATTENDANCE);
		ps.setString(1, e.getName());
		ps.setString(2, e.getIdno());
		ps.setFloat(3, e.getAttendence());
		ps.setString(4, e.getDate());
		result =ps.executeUpdate();
		}
		catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
		finally {
			try {
				con.close();
				}
			catch(SQLException e2)
			{
				System.out.println(e2.getMessage());
			}
			try {
				ps.close();
			}
			catch(Exception e3)
			{
				System.out.println(e3.getMessage());
			}
			
		}
		return result;
		
	}
	
	// UPDATE ATTENDANCE
	public static int updateAttendance(String id , Float attendance , String date)
	{
		Connection con =null;
		PreparedStatement ps =null;
		int result =0;
		try {
			con = ConnectionProvider.getConnection();
			ps =con.prepareStatement(UPDATE_ATTENDANCE);
			ps.setFloat(1,attendance);
			ps.setString(2, id);
			ps.setString(3, date);
			result = ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("AttendanceDAO.updateAttendance() "+e.getMessage());
		}
		return result;
	}
	
	public static void getTotalAttendance(String id)
	{
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		int result =0;
		try {
		con = ConnectionProvider.getConnection();
		ps =  con.prepareStatement("SELECT SUM(ATTENDANCE) FROM ATTENDANCE_MANAGEMENT WHERE IDNO =(?)");
	    ps.setString(1, id);
	     rs = ps.executeQuery();
	    if(rs.next())
	    {
	    	System.out.println(rs.getFloat(1));
	    }
		
	}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			try {
				con.close();
				}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
			try {
				ps.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			try {
				rs.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}
