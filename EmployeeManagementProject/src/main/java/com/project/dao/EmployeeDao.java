package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.beans.EmployeeBean;
import com.project.dba.ConnectionProvider;

public class EmployeeDao {
	private static final String  INSERT_EMPLOYEE_QUERY="INSERT INTO EMPLOYEE_REGISTRATION"
			+ " VALUES(?,?,?,?,?,?,?,?,?,?)";
	private static final String getEmployeeForDelete = "SELECT NAME ,FNAME , IDNO FROM EMPLOYEE_REGISTRATION";
	private static final String deleteEmpById = "DELETE FROM EMPLOYEE_REGISTRATION WHERE IDNO=(?)";
	private static final String GET_EMP_FOR_UPDATE = "SELECT NAME,FNAME, IDNO,EMAIL,PHONENO,ADDRESS,SALARY,DOJ,DESIGNATION,FACTORY FROM EMPLOYEE_REGISTRATION";
	private static final String UPDATE_EMPLOYEE = "UPDATE EMPLOYEE_REGISTRATION SET EMAIL=(?) , ADDRESS=(?) , SALARY=(?) , DESIGNATION=(?) , FACTORY=(?) WHERE IDNO=(?)";
	private static final String GET_EMP_FOR_SEARCH = "SELECT NAME,FNAME, IDNO,EMAIL,PHONENO,ADDRESS,SALARY,DOJ,DESIGNATION,FACTORY FROM EMPLOYEE_REGISTRATION WHERE NAME LIKE (?)	 ";
	private static final String SHOW_EMP_AFTER_LOGIN = "SELECT NAME,FNAME, IDNO,EMAIL,PHONENO,ADDRESS,SALARY,DOJ,DESIGNATION,FACTORY FROM EMPLOYEE_REGISTRATION WHERE  EMAIL=(?) OR PHONENO=(?)";
	private static final String VALIDATE_EMPLOYEE = "SELECT COUNT(*) FROM EMPLOYEE_REGISTRATION WHERE EMAIL =(?) OR PHONENO=(?)";

	public static void registerEmployee(EmployeeBean emp)
	{
		Connection con =null;
		PreparedStatement ps=null;
		try {
		con = ConnectionProvider.getConnection();

		ps =  con.prepareStatement(INSERT_EMPLOYEE_QUERY);
		ps.setString(1, emp.getName());
		ps.setString(2, emp.getFname());
		ps.setString(3,emp.getIdno());
		ps.setString(4,emp.getEmail());
		ps.setString(5, emp.getPhoneno());
        ps.setString(6,emp.getAddress());
        ps.setString(7,emp.getSalary());
        ps.setString(8,emp.getDoj());
        ps.setString(9,emp.getDesignation());
        ps.setString(10,emp.getFactory());
        
        // execute query
       int flag= ps.executeUpdate();
       if(flag>0)
    	   System.out.println("EmployeeDao.registerEmployee()"+" employee registration successfull!!");
       else
    	   System.out.println("EmployeeDao.registerEmployee()"+" Fail to register employee !!");
       
       // insert or deposite initial amount = 0;
       SalaryManagementDAO.insertSalary(emp.getIdno(), 0);
		}
		catch(Exception e)
		{
			// error page
			System.out.println("EmployeeDao.registerEmployee()"+e.getMessage());
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
		}
		
	}
	
	
	public static void updateEmployee(EmployeeBean e)
	{
		Connection con =null;
		PreparedStatement ps =null;
		try {
			con = ConnectionProvider.getConnection();
			ps =con.prepareStatement(UPDATE_EMPLOYEE);
			ps.setString(1, e.getEmail());
			ps.setString(2, e.getAddress());
			ps.setString(3, e.getSalary());
			ps.setString(4, e.getDesignation());
			ps.setString(5, e.getFactory());
			ps.setString(6, e.getIdno());
			
			int result = ps.executeUpdate();
			if(result>0)
			{
				System.out.println("EmployeeDao.updateEmployee() "+" Emp detailed Updated Successfully ");
			}
			else
			{
				System.out.println("EmployeeDao.updateEmployee() " + "Fail to update emp details");
			}
			
			}
		catch(Exception e1)
		{
			System.out.println("EmployeeDao.updateEmployee() "+e1.getMessage());
		}
		finally {
			try {
				con.close();
				ps.close();
			}
			catch(Exception e2)
			{
				System.out.println("EmployeeDao.updateEmployee()"+ e2.getMessage());
			}
		}
		
	}
	
	public static List<EmployeeBean> getAllEmployeeForDelete()
	{
		
		List empList = new ArrayList();
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
		con = ConnectionProvider.getConnection();
		ps =  con.prepareStatement(getEmployeeForDelete);
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
	
	public static int deleteEmployee(String id)
	{
		Connection con =null;
		PreparedStatement ps =null;
		int count = 0;
		try {
		con = ConnectionProvider.getConnection();
		ps =  con.prepareStatement(deleteEmpById);
		ps.setString(1, id);
		 count  =ps.executeUpdate();
		}
		catch(Exception e)
		{
			//error page
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
		}
		return count;
	}
	
	// get employee's complete data for update
	public static List<EmployeeBean> getEmpForUpdate()
	{
		List<EmployeeBean> empList = new ArrayList();
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(GET_EMP_FOR_UPDATE);
			rs = ps.executeQuery();
		    while(rs.next())
		    {
		    	EmployeeBean emp = new EmployeeBean();
		    	emp.setName(rs.getString(1));
		    	emp.setFname(rs.getString(2));
		    	emp.setIdno(rs.getString(3));
		    	emp.setEmail(rs.getString(4));
		    	emp.setPhoneno(rs.getString(5));
		    	emp.setAddress(rs.getString(6));
		    	emp.setSalary(rs.getString(7));
		    	emp.setDoj(rs.getString(8));
		    	emp.setDesignation(rs.getString(9));
		    	emp.setFactory(rs.getString(10));
		    	
		    	empList.add(emp);
	
		    }
		}
		    catch(Exception e)
		    {
		    	System.out.println("EmployeeDao.updateEmployee() "+e.getMessage());
		    }

		return empList;
	}
	
	// GET ALL EMP FOR SEARCH
	public static List<EmployeeBean> getEmpFoSearch(String name)
	{
		List<EmployeeBean> empList = new ArrayList();
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(GET_EMP_FOR_SEARCH);
			ps.setString(1, name);
			rs = ps.executeQuery();
		    while(rs.next())
		    {
		    	EmployeeBean emp = new EmployeeBean();
		    	emp.setName(rs.getString(1));
		    	emp.setFname(rs.getString(2));
		    	emp.setIdno(rs.getString(3));
		    	emp.setEmail(rs.getString(4));
		    	emp.setPhoneno(rs.getString(5));
		    	emp.setAddress(rs.getString(6));
		    	emp.setSalary(rs.getString(7));
		    	emp.setDoj(rs.getString(8));
		    	emp.setDesignation(rs.getString(9));
		    	emp.setFactory(rs.getString(10));
		    	
		    	empList.add(emp);
	
		    }
		}
		    catch(Exception e)
		    {
		    	System.out.println("EmployeeDao.getEmpFoSearch()"+e.getMessage());
		    }

		return empList;
	}
	
	/// date function
	public static List getEmpByJoiningDate(String d1 ,String d2)
	{
		String query = "select name , fname from employee_registration where doj > (?) and doj< (?) ";
		List<EmployeeBean> emplist = null;
		try {
		Connection con = ConnectionProvider.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		emplist = new ArrayList();
		ps.setString(1, d1);
		ps.setString(2, d2);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			EmployeeBean emp  = new EmployeeBean();
					emp.setName(rs.getString(1));
			        emp.setFname(rs.getString(2));
			        emplist.add(emp);
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	return emplist;
	}
	
	
	// validate employee
	public static int validateEmployee(String empDetail)
	{
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		int result =0;
		try {
			con = ConnectionProvider.getConnection();
			ps= con.prepareStatement(VALIDATE_EMPLOYEE);
			ps.setString(1, empDetail);
			ps.setString(2, empDetail);
			rs = ps.executeQuery();
			if(rs.next())
			{
				result = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("EmployeeDao.validateEmployee() "+e.getMessage());
		}
		finally {
			try {
				con.close();
				ps.close();
				rs.close();
			}
			catch(Exception e)
			{
				System.out.println("EmployeeDao.validateEmployee() "+e.getMessage());
			}
		}
		return result;
	}
	
	// SHOW EMPLOYEEE AFTER LOGIN
	public static EmployeeBean showEmpAfterLogin(String empDetail)
	{
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		EmployeeBean emp =new EmployeeBean();
		
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(SHOW_EMP_AFTER_LOGIN );
			ps.setString(1, empDetail);
			ps.setString(2, empDetail);
			
			rs = ps.executeQuery();
			while(rs.next())
			{
				emp.setName(rs.getString(1));
				emp.setFname(rs.getString(2));
				emp.setIdno(rs.getString(3));
				emp.setEmail(rs.getString(4));
				emp.setPhoneno(rs.getString(5));
				emp.setAddress(rs.getString(6));
				emp.setSalary(rs.getString(7));
				emp.setDoj(rs.getString(8));
				emp.setDesignation(rs.getString(9));
				emp.setFactory(rs.getString(10));
			}
				
			}
		catch(Exception e)
		{
			System.out.println("EmployeeDao.showEmpAfterLogin()"+e.getMessage());
		}
		finally {
			try {
				con.close();
				ps.close();
				rs.close();
			}
			catch(Exception e)
			{
				System.out.println("EmployeeDao.showEmpAfterLogin()"+e.getMessage());
			}
		}
		return emp;
	}
}
