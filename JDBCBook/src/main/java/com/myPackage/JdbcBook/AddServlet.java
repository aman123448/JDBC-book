package com.myPackage.JdbcBook;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		float price = Float.parseFloat(request.getParameter("price"));

try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded.");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "9535");
			System.out.println("Connection is established.");

			Statement st = con.createStatement();
			int res = st.executeUpdate("insert into books values(" + id + ",'" + name + "'," + price + ")");
			out.print("<h2>Rows Inserted: " + res + "</h2>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
