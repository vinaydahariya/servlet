package feedback_app.session.manage;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebServlet("/servlet2")
public class Request2Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8"); // Added charset for compatibility
        var writer = resp.getWriter();
        Cookie[] cookies = req.getCookies();

        var flag = false;

        StringBuilder content = new StringBuilder();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName() != null) { // Added null check for cookie name
                    String name = c.getName();
                    if (name.equals("userName")) {
                        System.out.println("userName : " + c.getValue());
                        content.append("""
                                <h1>Welcome : %s
                                
                                """.formatted(c.getValue() != null ? c.getValue() : "Unknown")); // Handle null values
                        flag = true;
                    } else if (name.equals("userid")) {
                        System.out.println("userName : " + c.getValue());
                        content.append("""
                                <h1>Userid : %s
                                
                                """.formatted(c.getValue() != null ? c.getValue() : "Unknown")); // Handle null values
                        flag = true;
                    }
                }
            }
        }
        
        // 
        ServletConfig servletConfig = getServletConfig();
        ServletContext servletContext = servletConfig.getServletContext();
        String appName = servletContext.getInitParameter("app_name");
        String userEmail = servletConfig.getInitParameter("userEmail");

        HttpSession session = req.getSession(false); // Avoid creating a session if it doesn't exist
        if (session != null) {
            String secret = (String) session.getAttribute("userSecret");
            content.append("""
                    <h1>Session Secret : %s </h1>
                    """.formatted(secret != null ? secret : "No Secret Found")); // Handle null session attribute
        } else {
            content.append("""
                    <h1>Session Secret : No session available</h1>
                    """);
        }

        if (flag) {
            writer.println("<h1>User is present</h1>");
            writer.println(content);
        } else {
            writer.println("<h1>No userName found in cookies</h1>");
            writer.println("<h1>UserName cookie is not there in request</h1>");
        }
        
        resp.getWriter().print("""
        		<h1>Context Params : %s </h1>
        		<h1>Init Params : %s </h1>
        		""".formatted(appName, userEmail));
    }
}
