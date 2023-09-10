package com.soumya.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginForm")
public class Login extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		PrintWriter out = resp.getWriter();
		
		String myname = req.getParameter("name1");
		String mypass = req.getParameter("pass1");
		
		//Database connectivity
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_signup","root","Soumya@7001");
			
			PreparedStatement ps = con.prepareStatement("Select * from register where fullname=? and password=?");
			ps.setString(1, myname);
			ps.setString(2, mypass);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				resp.setContentType("text/html");
				RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
				rd.include(req, resp);
			}else {
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'>Username and password didn't match</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.include(req,  resp);
			}
		}catch(Exception e) {
			e.printStackTrace();
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>Exception Occured : "+e.getMessage()+"</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.include(req,  resp);
		}
	}

}
