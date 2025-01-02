package feedback_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import feedback_app.ConnectionProviders;

public class FeedbackDao {

    public static boolean saveFeedback(String email, String phone, String feedbackMessage) {
        boolean isSaved = false;
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            // Establish the database connection
            con = ConnectionProviders.createConnection();

            // SQL query to insert feedback data
            String query = "INSERT INTO feedback (email, phone, feedback_message) VALUES (?, ?, ?)";

            // Prepare the statement
            stmt = con.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, phone);
            stmt.setString(3, feedbackMessage);

            // Execute the query
            int rowsAffected = stmt.executeUpdate();

            // Check if the feedback was saved successfully
            if (rowsAffected > 0) {
                isSaved = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources to prevent memory leaks
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isSaved;
    }
}
