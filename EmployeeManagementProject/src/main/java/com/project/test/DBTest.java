package com.project.test;

import java.util.List;

import com.project.beans.AttendenceBean;
import com.project.beans.EmployeeBean;
import com.project.dao.AttendanceDAO;
import com.project.dao.EmployeeDao;
import com.project.dao.SalaryManagementDAO;

public class DBTest{
public static void main(String[] args) {
	try {
		EmployeeBean e = EmployeeDao.showEmpAfterLogin("8103010392");
		System.out.println(e.getAddress() + e.getAddress()+ e.getPhoneno());
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
}
