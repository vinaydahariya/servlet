package feedback_app;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProviders {
	
	public static Connection con;
	
	public static Connection createConnection() {
	    try {
	        // Load the MySQL driver
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // Database connection details
	        String user = "root";
	        String password = "";
	        String url = "jdbc:mysql://localhost:3306/feedback-app";
	        con = DriverManager.getConnection(url, user, password);

	        if (con != null) {
	            System.out.println("Connection successful");
	        }
	    } catch (Exception e) {
	        // Improved logging
	        System.out.println("Error establishing database connection:");
	        e.printStackTrace();
	    }
	    return con;
	}

}