package com.higradius.internship;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class table
 */
@WebServlet("/table")
public class table extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public table() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			PrintWriter out = response.getWriter();
			int spageid=Integer.parseInt(request.getParameter("page"));
			int pageid=spageid;
			int total=11;
			if(pageid==1) {}
			else {
				pageid--;
				pageid=pageid*total+1;
			}
			ArrayList<invoice> list = connection.getRecords(pageid, total);
			Gson json= new Gson();
			String data=json.toJson(list);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(data);
			out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

