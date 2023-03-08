import java.sql.*;

/**
 * This is a Tester class
 * @author alessiolimina
 */

public class Start {
    public static void main(String[] args) throws SQLException {
        //TODO Javadoc to be generated and completed

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer", "**********");
            Statement statement = conn.createStatement();
            String createTable = "CREATE TABLE IF NOT EXISTS students (student_id INT (10) NOT NULL AUTO_INCREMENT, last_name VARCHAR (30), first_name VARCHAR (30), CONSTRAINT students_pk PRIMARY KEY (student_id));";
            statement.executeUpdate(createTable);
            /** Need to remember to not insert the student_id: is auto-incremented! */
            String insertStudents = "INSERT INTO students (last_name, first_name) VALUES ('Limina','Alessio'), ('Torelli', 'Alberto'), ('Siniscalco', 'Giorgio'), ('Federico', 'Sacchi');";
            statement.executeUpdate(insertStudents);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }
}
