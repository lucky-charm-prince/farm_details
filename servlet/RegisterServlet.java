package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbConnection.*;
import com.dao.UserDao;
import com.dbConnection.DbConnection;
import com.entity.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String contact=req.getParameter("contact");
		String password=req.getParameter("password");
		User u= new User(name, email,contact,password);
		UserDao dao= new UserDao(DbConnection.getConnection());
		HttpSession session = req.getSession();
	  if(dao.userRegister(u))
	  {
		session.setAttribute("regMsg", "UserRegister Successfully");
		resp.sendRedirect("register.jsp");
		  
	  }
	  else
	  {
		  session.setAttribute("nregMsg", "User not Register");
			resp.sendRedirect("register.jsp");
	  }
		
		
	}
    
}
