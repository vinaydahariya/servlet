package feedback_app.session.manage;

import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebServlet("/servlet1")
public class Request1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Define user details
        String userName = "vinay";
        String userid = "12341";

        // Create cookies for userName and userid
        Cookie userNameCookie = new Cookie("userName", userName);
        Cookie userIdCookie = new Cookie("userid", userid);

        // Set MaxAge for cookies
        userNameCookie.setMaxAge(10 * 60); // 10 minutes
        userIdCookie.setMaxAge(5 * 60);    // 5 minutes

        // Add cookies to the response
        resp.addCookie(userNameCookie);
        resp.addCookie(userIdCookie);

        // Create and configure HTTP session
        HttpSession session = req.getSession();
        String userSecret = UUID.randomUUID().toString();
        session.setAttribute("userSecret", userSecret);
        session.setMaxInactiveInterval(10 * 60); // Session timeout set to 10 minutes
        
        // 
        ServletConfig servletConfig = getServletConfig();
        ServletContext servletContext = servletConfig.getServletContext();
        String appName = servletContext.getInitParameter("app_name");
        String userName = servletConfig.getInitParameter("userName");

        // Set content type with encoding
        resp.setContentType("text/html; charset=UTF-8");

        // Write response
        var writer = resp.getWriter();
        writer.println("<h1>Cookie set successfully</h1>");
        writer.flush(); // Ensure the response is sent to the client
        
        resp.getWriter().print("""
        		<h1>Context Params : %s </h1>
        		<h1>Init Params : %s </h1>
        		""".formatted(appName, userName));
        
        
    }
}
