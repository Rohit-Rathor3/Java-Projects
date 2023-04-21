package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.beans.AnnouncementBean;
import com.project.dba.ConnectionProvider;

public class AnnouncementDAO {

	private static final String GET_ANNOUNCEMENT_DETALIS = "SELECT TITLE , MESSAGE , DATE FROM ANNOUNCEMENTS_MANAGEMENTS";
	private static final String INSERT_ANNOUCEMENT ="INSERT INTO ANNOUNCEMENTS_MANAGEMENTS VALUES(?,?,?)";
	private static final String DELETE_ANNOUNCEMNT = "DELETE FROM ANNOUNCEMENTS_MANAGEMENTS WHERE TITLE =(?)";
	
	public static List<AnnouncementBean> getAnnouncementDetails()
	{
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		List<AnnouncementBean> annList = new ArrayList();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(GET_ANNOUNCEMENT_DETALIS);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				AnnouncementBean ann = new AnnouncementBean();
				ann.setTitle(rs.getString(1));
				ann.setMessage(rs.getString(2));
				ann.setDate(rs.getString(3));
				annList.add(ann);	
			}	
		}
		catch(Exception e)
		{
			System.out.println("AnnouncementDAO.getAnnouncementDetails()"+ e.getMessage());
		}
		finally {
			try {
				con.close();
				rs.close();
				ps.close();
			}
			catch(Exception e)
			{
				System.out.println("AnnouncementDAO.getAnnouncementDetails()"+e.getMessage());
			}
		}
		return annList;
	}
	
	public static int insertAnnoucement(AnnouncementBean ann)
	{
		Connection con = null;
		PreparedStatement ps =null;
		int result =0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(INSERT_ANNOUCEMENT);
			ps.setString(1, ann.getTitle());
			ps.setString(2, ann.getMessage());
			ps.setString(3,ann.getDate());
			
			result = ps.executeUpdate();
	}
		catch(Exception e)
		{
			System.out.println("AnnouncementDAO.insertAnnoucement() "+e.getMessage());
		}
		finally {
			try {
				con.close();
				ps.close();
			}
			catch(Exception e)
			{
				System.out.println("AnnouncementDAO.getAnnouncementDetails()"+e.getMessage());
			}
		}
		return result;
}
	
	
	public static int deleteAnnoucement(String title)
	{
		Connection con = null;
		PreparedStatement ps =null;
		int result =0;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(DELETE_ANNOUNCEMNT);
			ps.setString(1, title);
			
			result = ps.executeUpdate();
	}
		catch(Exception e)
		{
			System.out.println("AnnouncementDAO.deleteAnnoucement() "+ e.getMessage());
		}
		finally {
			try {
				con.close();
				ps.close();
			}
			catch(Exception e)
			{
				System.out.println("AnnouncementDAO.deleteAnnoucement() "+ e.getMessage());
			}
		}
		return result;
}
}
