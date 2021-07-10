package com.higradius.internship;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertData
 */
@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			  
           
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		Connection conn = connection.getConnection();
        PreparedStatement st = conn
               .prepareStatement("INSERT INTO mytable (name_customer, cust_number, doc_id,total_open_amount,due_in_date,notes) VALUES (?,?,?,?,?,?)");
   
        st.setString(1, request.getParameter("name_customer"));
        st.setString(2, request.getParameter("cust_number"));
        st.setInt(3, Integer.valueOf( request.getParameter("doc_id")));
        st.setInt(4,Integer.valueOf(request.getParameter("total_open_amount")));
        LocalDate date = LocalDate.parse(request.getParameter("due_in_date"),DateTimeFormatter.ofPattern ( "yyyy-MM-dd" ));
		Date duedate = Date.valueOf(date);
		st.setDate(5, duedate);
        st.setString(6, request.getParameter("notes"));
        // Execute the insert command using executeUpdate()
        // to make changes in database
        st.executeUpdate();

        // Close all the connections
        st.close();
        conn.close();
    }
    catch (Exception e) {
        e.printStackTrace();
    }
	}

}
