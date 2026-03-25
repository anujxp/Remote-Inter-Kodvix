import java.sql.*;
public class ConnectionDemo {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String user = "root";
    private static final String password= "root";

        public static void main(String[] args) {
            // 1. Establish Connection
try{
    Class.forName("com.mysql.cj.jdbc.Driver");
} catch (ClassNotFoundException e) {
    throw new RuntimeException(e);
}
            try (Connection con = DriverManager.getConnection(
                    url,
                    user,
                    password
            );){


                // 2. Statement (simple query)
                Statement stmt = con.createStatement();
                ResultSet rs1 = stmt.executeQuery("SELECT * FROM students");

                while (rs1.next()) {
                    System.out.println("Statement: " + rs1.getString("name"));
                }

                // 3. PreparedStatement (safe query)
                PreparedStatement ps = con.prepareStatement(
                        "SELECT * FROM students WHERE id = ?"
                );
                ps.setInt(1, 1);

                ResultSet rs2 = ps.executeQuery();
                while (rs2.next()) {
                    System.out.println("PreparedStatement: " + rs2.getString("name"));
                }

                // 4. CallableStatement (stored procedure)
                CallableStatement cs = con.prepareCall("{call getStudent(?)}");
                cs.setInt(1, 1);

                ResultSet rs3 = cs.executeQuery();
                while (rs3.next()) {
                    System.out.println("CallableStatement: " + rs3.getString("name"));
                }

                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }