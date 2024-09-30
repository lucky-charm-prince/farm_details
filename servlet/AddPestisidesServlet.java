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

@WebServlet("/addpestisides")
public class AddPestisidesServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cropName = req.getParameter("cropName");

		String cropAge = req.getParameter("cropAge");

		String pestisidesName = req.getParameter("pestisidesName");

		int userId = Integer.parseInt(req.getParameter("userId"));

		AddPestisides ap = new AddPestisides(cropName, cropAge, pestisidesName, userId);

		UserDao dao = new UserDao(DbConnection.getConnection());
		HttpSession session = req.getSession();
		if (dao.addPestisides(ap)) {
			session.setAttribute("addMsg", "AddPestisides successfully");
			resp.sendRedirect("addpestiside.jsp");
		} else {
			session.setAttribute("naddMsg", "not AddPestisides");
			resp.sendRedirect("addpestiside.jsp");
		}
	}

}
