package com.jsp.sevlet.carmanagementsystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteCar")
public class DeleteCarServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carId = Integer.parseInt(req.getParameter("carId"));
		
		Connection conn =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb?user=root&password=root");
			
			// Deleting the Car By Id 
			PreparedStatement pst1 = conn.prepareStatement("Delete from car where carId=?");
			pst1.setInt(1, carId);
			pst1.executeUpdate();
			
			// Display  Updated Car Table
			PreparedStatement pst2 = conn.prepareStatement("Select * from car");
			ResultSet rs = pst2.executeQuery();
			
			req.setAttribute("carList", rs);
			RequestDispatcher rd = req.getRequestDispatcher("DisplayAllCars.jsp");
			rd.forward(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
