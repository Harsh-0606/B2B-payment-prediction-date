package com.higradius.internship;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteData
 */
@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	         // Create a SQL query to insert data into demo table
	        // demo table consists of two columns, so two '?' is used
	        Connection conn= connection.getConnection();
	        PreparedStatement st = conn
	               .prepareStatement("delete from mytable where doc_id= ?");
	        System.out.print("inside delete function");
	        String s= request.getParameter("doc_id");
	        String [] s1= s.split(",");
	        for( int i=0; i< s1.length;i++)
	        {
	        	st.setString(1, s1[i]);
	        	st.executeUpdate();
	        	System.out.println();
	        	
	        }
	        // Close all the connections
	        st.close();
	        conn.close();
	    }
	    catch (Exception e) {
	        System.out.print(e);	    }
	}
}
