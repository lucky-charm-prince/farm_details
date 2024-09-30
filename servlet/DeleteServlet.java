package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dbConnection.DbConnection;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("cid"));
		UserDao dao= new UserDao(DbConnection.getConnection());
		HttpSession session=req.getSession();
		if(dao.delectdetails(id))
		{
		    session.setAttribute("dMsg", "Delete Sucuessfully");
		    resp.sendRedirect("ourfarm.jsp");
	   	}
		else
		{
		    session.setAttribute("ndMsg", "not delete Something went wrong ");
		    resp.sendRedirect("ourfarm.jsp");
		}
		
	}
  
	
}
