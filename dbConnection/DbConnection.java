package com.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static Connection conn=null;
	private static String name="root";
	private static  String password="";
	private static String url="jdbc:mysql://localhost:3306/farm"; 
	
	public static Connection getConnection()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,name,password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args)
	{
		DbConnection db= new DbConnection();
		System.out.println(db.getConnection());
	}

}
