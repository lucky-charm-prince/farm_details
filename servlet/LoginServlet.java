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
import com.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hello prince");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		System.out.println(email+"  "+password+".....................");
		User u= new User();
		u.setEmail(email);
		u.setPassword(password);
		UserDao dao= new UserDao(DbConnection.getConnection());
		HttpSession session= req.getSession();
		u=dao.login(u);
		if(u.getId()!=0 )
		{
		      session.setAttribute("user", u); 
		      resp.sendRedirect("index.jsp");
		}
		else 
		{
		      session.setAttribute("notLogin", "invalid email or password");
		      resp.sendRedirect("login.jsp");
		}
		
	}
  
	
}
