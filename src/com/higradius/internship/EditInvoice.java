package com.higradius.internship;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditInvoice
 */
@WebServlet("/EditInvoice")
public class EditInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditInvoice() {
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
		  
				Connection conn = connection.getConnection();
		        PreparedStatement st = conn.prepareStatement("update mytable set total_open_amount=? , notes=? where doc_id= ?");
		        System.out.println(request.getParameter("total_open_amount"));
		        System.out.println(request.getParameter("notes"));
		        System.out.println(request.getParameter("doc_id"));
		        st.setFloat(1,Float.valueOf(request.getParameter("total_open_amount"))); 
		        st.setString(2,request.getParameter("notes")); 
		        st.setInt(3,Integer.valueOf(request.getParameter("doc_id"))); 
		        st.executeUpdate();
		        System.out.println(st);
		        st.close();
		        conn.close();
	    	}
	    	catch (Exception e) {
	    		System.out.print(e);	 
	    	}
		}

	}
