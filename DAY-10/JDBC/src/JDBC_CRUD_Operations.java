import java.sql.*;

public class JDBC_CRUD_Operations {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb1";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = con.createStatement()) {

            // --- 1. INSERT DATA (Approx. 50:00 - 51:00) ---
            String name = "Rahul";
            int age = 23;
            double marks = 74.5;

            // Using String.format to build the query dynamically
            String insertQuery = String.format(
                    "INSERT INTO students (name, age, marks) VALUES ('%s', %d, %f)",name, age, marks);

            int rowsInserted = stmt.executeUpdate(insertQuery);
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully!");
            }

            // --- 2. UPDATE DATA (Approx. 51:00 - 53:00) ---
            double newMarks = 85.0;
            int studentId = 2; // Target ID to update

            String updateQuery = String.format(
                    "UPDATE students SET marks = %f WHERE id = %d",
                    newMarks, studentId
            );

            int rowsUpdated = stmt.executeUpdate(updateQuery);
            if (rowsUpdated > 0) {
                System.out.println("Data updated successfully!");
            }

            // --- 3. DELETE DATA (Approx. 54:00 - 55:00) ---
            int deleteId = 2;

            String deleteQuery = String.format(
                    "DELETE FROM students WHERE id = %d",
                    deleteId
            );

            int rowsDeleted = stmt.executeUpdate(deleteQuery);
            if (rowsDeleted > 0) {
                System.out.println("Data deleted successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}