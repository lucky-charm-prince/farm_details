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
import com.entity.AddPestisides;

@WebServlet("/edit")
public class EditServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("id"));
		String cropName = req.getParameter("cropName");
		String cropAge = req.getParameter("cropAge");
		String pestisidesName = req.getParameter("pestisidesName");
		System.out.println(cropName+" "+cropAge+" "+pestisidesName+" "+id);
        AddPestisides ad = new AddPestisides();
        ad.setId(id);
        ad.setCropName(cropName);
        ad.setCropAge(cropAge);
        ad.setPestisidesName(pestisidesName);
        UserDao dao = new UserDao(DbConnection.getConnection());
        HttpSession session=req.getSession();
        if(dao.editAddPestisides( ad))
        {
        	session.setAttribute("editMsg","edit Successfull");
            resp.sendRedirect("ourfarm.jsp");	
        }
        else 
        {
        	session.setAttribute("neditMsg","not edit someThing went wrong");
        	resp.sendRedirect("edit.jsp");
        }
        
		
	}

	
}
