package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("processing do get request by third servlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // Retrieve parameter from the request
	    String parameter = req.getParameter("message");

	    // Log to the console
	    System.out.println("Form submitted using POST method");
	    System.out.println("Message: " + parameter);

	    // Send response to the browser
	    resp.setContentType("text/html");
	    PrintWriter writer = resp.getWriter();
	    writer.print("<h1>Form Submitted</h1>");
	    String date = new java.util.Date().toString(); // Example date
	    writer.print("<h2>Message: %s</h2><h3>Date: %s</h3>".formatted(parameter, date));
	    
	    resp.setStatus(401);

	}

	
}
