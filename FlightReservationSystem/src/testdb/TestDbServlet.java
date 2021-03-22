package testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import java.sql.*;
import java.util.Properties;
import java.util.logging.FileHandler;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection myConn;

    /**
     * Default constructor. 
     */
    public TestDbServlet() {
        // TODO Auto-generated constructor stub
    	 super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public boolean isDbConnected(Connection con) {
        try {
            return con != null || !con.isClosed();
        } catch (SQLException ignored) {}

        return false;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		// setup connection variables
		String user = "user";
		String pass = "password";
		
		//String jdbcUrl = "jdbc:mysql://localhost:3306/reservation_system_flight_helper?useSSL=false";
		String jdbcUrl = "jdbc:mysql://mysql3000.mochahost.com:3306/rafalokr_airlane?autoReconnect=true";
		String driver = "com.mysql.jdbc.Driver";
		
		Properties prop = new Properties();
		prop.setProperty("username", user);
		prop.setProperty("password", pass);
		prop.setProperty("testOnBorrow", "true");
		prop.setProperty("validationQuery", "SELECT 1");
		prop.setProperty("validationInterval", "60000");
		
		
		
		//get connection to database
		try {  
			
			Class.forName(driver);
			
			myConn = DriverManager.getConnection(jdbcUrl, prop);
			
			myConn.close();
			
			
		} catch (Exception exc) {
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
