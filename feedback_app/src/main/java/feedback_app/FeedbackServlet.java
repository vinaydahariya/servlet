package feedback_app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // Form data: retrieve from request
	    String email = req.getParameter("email");
	    String phone = req.getParameter("phone");
	    String feedbackMessage = req.getParameter("feedback_message");

	    // Process the data (save to database)
	    boolean isSaved = FeedbackDao.saveFeedback(email, phone, feedbackMessage);

	    // Set response type to HTML
	    resp.setContentType("text/html");
	    PrintWriter writer = resp.getWriter();
	    
	    // Check if feedback was saved successfully
	    if (isSaved) {
	        writer.println("""
	            <h2>Your feedback has been successfully submitted!</h2>
	            <h3>Email address: %s</h3>
	            <h3>Phone number: %s</h3>
	            <h3>Feedback message: %s</h3>
	            """.formatted(email, phone, feedbackMessage));
	    } else {
	        writer.println("<h2>Sorry, there was an error saving your feedback. Please try again later.</h2>");
	    }

	    // Optionally, you can redirect to another page after feedback submission
	    // resp.sendRedirect("/home");
	}

	
}
