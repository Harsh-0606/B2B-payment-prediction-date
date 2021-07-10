
package com.higradius.internship;

import java.sql.*;
import java.util.ArrayList;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class connection {
	
	public static Connection getConnection() 
	{
		Connection conn = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//			 Database credentials
			final String DB_URL = "jdbc:mysql://localhost/project";
			final String USER = "root";
			final String PASS = "harsh";
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return conn;		
	}
	
	public static ArrayList<invoice> getRecords(int start, int total){
		ArrayList<invoice> list = new ArrayList<>();
		try {
			Connection conn=getConnection();
			String s=String.format("SELECT * from mytable limit %d, %d",(start-1),total);
			System.out.println(s);
			PreparedStatement stmt = conn.prepareStatement(s); 
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				invoice ob= new invoice();
				ob.setCustomerName(rs.getString("name_customer"));
				ob.setCustomerNO(rs.getString("cust_number"));
				ob.setInvoiceNO(rs.getLong("doc_id"));
				ob.setInvoiceAmount(rs.getInt("total_open_amount"));
				ob.setDueDate(rs.getDate("due_in_date"));
				ob.setPreddictedPaymentDate(rs.getDate("paymentPredictedDate"));
				ob.setNotes(rs.getString("notes"));
				list.add(ob);
			}
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		return list;
	} 
}

	
