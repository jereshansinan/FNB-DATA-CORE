import java.sql.*;

public class DatabaseSelect {
    public static void main(String[] args) {
        // Path to your downloaded .db file
        String url = "jdbc:sqlite:../db/FNB_Data.db"; 

        // SQL Query to get the first 5 rows (All columns)
        // 1. Change the query to specific columns
        String sql = "SELECT EmployeeID, FirstName, LastName, Title FROM Employees LIMIT 5";

        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)) {

            System.out.println(String.format("%-5s | %-12s | %-12s | %-15s", "ID", "First", "Last", "Title"));
            System.out.println("------------------------------------------------------------");

            while (rs.next()) {
                // Fetching by column name is safer than by index
                int id = rs.getInt("EmployeeID");
                String fname = rs.getString("FirstName");
                String lname = rs.getString("LastName");
                String title = rs.getString("Title");

                System.out.println(String.format("%-5d | %-12s | %-12s | %-15s", id, fname, lname, title));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}