package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.AddPestisides;
import com.entity.User;
import com.mysql.cj.protocol.Resultset;

public class UserDao {

	private Connection conn;

	public UserDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public  boolean userRegister(User u)
	{
		boolean f=false;
		try {
			String sql="insert into users(name, email,contact ,password)values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3,u.getContact());
			ps.setString(4, u.getPassword());
			int i=ps.executeUpdate();
			if(i!=0)
			{
				f=true;
			}
		}
		
		catch(Exception e )
		{
			e.printStackTrace();
		}
		
	   	return f;
	}
	
	public User login(User u)
	{
		try {
			String sql="select * from users where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getEmail());
			ps.setString(2,u.getPassword());
			ResultSet rs= ps.executeQuery();
		    
		    while(rs.next())
		    {
		          u.setId(rs.getInt(1));
		          u.setName(rs.getString(2));
		          u.setEmail(rs.getString(3));
		          u.setContact(rs.getString(4));
		          u.setPassword(rs.getString(5));
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;
	}
	
	public boolean addPestisides(AddPestisides ap)
	{
		boolean f=false;
		try
		{
			String sql="Insert into addpestisides(cropName,cropAge,pestisidesName,userId)values(?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, ap.getCropName());
			ps.setString(2, ap.getCropAge());
			ps.setString(3,ap.getPestisidesName());
			ps.setInt(4, ap.getUserId());
			int i=ps.executeUpdate();
			if(i!=0)
			{
				f=true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public List<AddPestisides> getAllAddpestisides(int userId)
	{
		 System.out.println("hy prince ......................");
		List<AddPestisides> list= new ArrayList<AddPestisides>();
		 AddPestisides ad=null;
	     try
	     {
	    	 String sql="select * from  addpestisides where userId=?";
	    	 PreparedStatement ps = conn.prepareStatement(sql);
	    
	    	 ps.setInt(1, userId);
	    	 ResultSet rs= ps.executeQuery();
	    	 while(rs.next())
	    	 {
	    		 ad= new  AddPestisides();
	    		 ad.setId(rs.getInt(1) );
	    		 ad.setCropName(rs.getString(2));
	    		 ad.setCropAge(rs.getString(3));
	    		 ad.setPestisidesName(rs.getString(4));
	    		 ad.setUserId(rs.getInt(5));
	    	   list.add(ad);	 
	    	 }
	     }
	     catch(Exception e )
	     {
	    	 e.printStackTrace();
	     }
		return list;
		
	}
	
	 public AddPestisides  getAllourfarm(int id)
	 {
		 AddPestisides ad= new AddPestisides();
		 try {
			 String sql="select * from   addpestisides where id=?";
			 PreparedStatement ps=conn.prepareStatement(sql);
			 ps.setInt(1, id);
			 ResultSet rs= ps.executeQuery();
			 while(rs.next())
			 {
				 ad.setId(rs.getInt(1));
				 ad.setCropName(rs.getString(2));
				 ad.setCropAge(rs.getString(3));
				 ad.setPestisidesName(rs.getString(4));
				 ad.setUserId(rs.getInt(5));
			 }
		 }
		 catch(Exception e )
		 {
			 e.printStackTrace();
		 }
		 
		 return ad;
	 }
	 
	 public boolean editAddPestisides(AddPestisides ad)
	 {
		 boolean f=false;
		 try {
			 String sql="update addpestisides set cropName=?, cropAge=? , pestisidesName=? where id=?";
			 PreparedStatement ps= conn.prepareStatement(sql);
			 ps.setString(1, ad.getCropName());
			 ps.setString(2, ad.getCropAge());
			 ps.setString(3, ad.getPestisidesName());
			 ps.setInt(4, ad.getId());
			 int i=ps.executeUpdate();
			 if(i!=0)
			 {
				 f=true;
			 }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return f;
	 }
	 public boolean delectdetails(int id)
	 {
		 boolean f=false;
		 try {
			 String sql="delete from  addpestisides where id=?";
			 PreparedStatement ps= conn.prepareStatement(sql);
			 ps.setInt(1, id);
			 int i=ps.executeUpdate();
			 if(i!=0)
			 {
				 f=true;
			 }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return f;
		 
	 }
	 public List<AddPestisides> searchName(String cropName, int userId)
	 {
		 AddPestisides ad= null;
		 System.out.println("The User Dao crop Name"+cropName);
		 List<AddPestisides> list=new ArrayList<AddPestisides>();
		 try {
			 String sql="select * from  addpestisides where userid=? and cropName like ?";
			 PreparedStatement ps=conn.prepareStatement(sql);
			 ps.setInt(1, userId);
			 ps.setString(2, "%"+cropName+"%");
			 ResultSet rs= ps.executeQuery();
			 while(rs.next())
			 {
				ad=new AddPestisides();
				ad.setId(rs.getInt(1));
				String s=rs.getString(2);
				System.out.println("The name of the crop is in userDao sql=  "+s);
				ad.setCropName(s);
				
				ad.setCropAge(rs.getString(3));
				ad.setPestisidesName(rs.getString(4));
				ad.setUserId(rs.getInt(5));
				list.add(ad);
			 }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return list;
		 
	 }
	 
	 public List<AddPestisides> getAllotherAddpestisides(int usreId)
	 {
		 List<AddPestisides> list= new ArrayList<AddPestisides>();
		 AddPestisides ad=null;
		 try {
			   String sql = "select * from addpestisides where userId !=?";
			   PreparedStatement ps= conn.prepareStatement(sql);
			   ps.setInt(1, usreId);
			   ResultSet rs= ps.executeQuery();
			   while(rs.next())
				 {
					ad=new AddPestisides();
					ad.setId(rs.getInt(1));
					
					
					ad.setCropName(rs.getString(2));
					
					ad.setCropAge(rs.getString(3));
					ad.setPestisidesName(rs.getString(4));
					ad.setUserId(rs.getInt(5));
					list.add(ad);
				 }
		 }
		 catch(Exception e )
		 {
			 e.printStackTrace();
		 }
		 return list;
	 }
	 public List<AddPestisides> searchOtherName(String cropName, int userId)
	 {
		 AddPestisides ad= null;
		 System.out.println("The User Dao crop Name"+cropName);
		 List<AddPestisides> list=new ArrayList<AddPestisides>();
		 try {
			 String sql="select * from  addpestisides where userid !=? and cropName like ?";
			 PreparedStatement ps=conn.prepareStatement(sql);
			 ps.setInt(1, userId);
			 ps.setString(2, "%"+cropName+"%");
			 ResultSet rs= ps.executeQuery();
			 while(rs.next())
			 {
				ad=new AddPestisides();
				ad.setId(rs.getInt(1));
				String s=rs.getString(2);
				System.out.println("The name of the crop is in userDao sql=  "+s);
				ad.setCropName(s);
				
				ad.setCropAge(rs.getString(3));
				ad.setPestisidesName(rs.getString(4));
				ad.setUserId(rs.getInt(5));
				list.add(ad);
			 }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return list;
		 
	 }
	 
	 
	
}
