package com.srccodes.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IllegalStateException {
		response.setContentType("text/html");
		PrintWriter printWriter  = response.getWriter();
		printWriter.println("<h1>Hello World!</h1>");
		
		Statement statement = null;
		
		try {
			printWriter.println("Database tutorial");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test123","root","test");
			printWriter.println("connection succesful");
			
			statement = c.createStatement();
			String query = "SELECT * FROM T1";
			
			ResultSet rs = statement.executeQuery(query);
			
			printWriter.println("<h2>Query successful </h2>");
			
			while(rs.next()) {
				String n = rs.getString("name");
				int a = rs.getInt("age");
				
				printWriter.println("<h3> Name: " + n + " Age: " + a +  " </h3>");
			}
			
		} catch(Exception e) {
			e.printStackTrace(printWriter);
			System.out.println("catch block");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
