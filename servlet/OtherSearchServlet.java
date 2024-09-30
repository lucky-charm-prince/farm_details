package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dbConnection.DbConnection;
import com.entity.AddPestisides;

@WebServlet("/search")
public class OtherSearchServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("We inter in the search servlet");
		String cropName=req.getParameter("searchName");
		int userId=Integer.parseInt(req.getParameter("userId"));
		System.out.println("cropname"+cropName+".........................");
		UserDao dao=new UserDao(DbConnection.getConnection());
		 List<AddPestisides> list=dao.searchOtherName(cropName,userId);
		 System.out.println("list"+list);
		 HttpSession session =req.getSession();
		 if(list!=null)
		 {
			 System.out.println("Search  perform");
			 session.setAttribute("listt",list);
			 resp.sendRedirect("searchh.jsp");
		 }
		 else
		 {
			 System.out.println("Search not perform");
			 session.setAttribute("nsMsg","Something went wrong not able to search");
			 resp.sendRedirect("addpestisides.jsp");
		 }
		 
		 
		
	}

	
	
}
