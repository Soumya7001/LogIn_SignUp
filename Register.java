package com.soumya.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/regForm")
public class Register extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		
		PrintWriter out = resp.getWriter();
		
		//Collect user details by req.getParameter
		String myname = req.getParameter("name1");
		String myemail = req.getParameter("email");
		String mypass = req.getParameter("pass1");
		String myphone = req.getParameter("mob1");
		String mygender = req.getParameter("gender");
		
		//DataBase connectivity
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_signup","root","Soumya@7001");
			
			PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");
			ps.setString(1, myname);
			ps.setString(2, myemail);
			ps.setString(3, mypass);
			ps.setString(4, myphone);
			ps.setString(5, mygender);
			
			int count = ps.executeUpdate();
			if(count>0) {
				resp.setContentType("text/html");
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
			}else {
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'>Error! Try again </h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
			}
		}catch(Exception e) {
			e.printStackTrace();
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>Exception Occured : "+e.getMessage()+"</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			rd.include(req, resp);
		}
		
	}
}
