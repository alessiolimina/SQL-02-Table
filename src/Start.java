import java.sql.*;

/**
 * This is a Tester class
 * @author alessiolimina
 */

public class Start {
    public static void main(String[] args) throws SQLException {

        /** Creating a null Connection conn */
        Connection conn = null;

        /** Creating a try/catch statement */
        try {

            /** Getting the connection 'conn' using Driver Manager and 3 parameters
             * @param url is the url of the database newdb
             * @param user is the MySQL developer user
             * @param password is the password used for MySQL developer account
             */
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer", "developerpass1");

            /** Creating a new 'conn' statement using Statement */
            Statement statement = conn.createStatement();

            /** Using a String 'createTable',
             * Creating a new table 'students' (if not already existing) with 3 columns and one constraint, as follows:
             * @column 'student_id' with type int, max 10 digits long, and not null, auto-incremented value
             * @column 'last_name' with type String, max 30 characters long
             * @column 'first_name' with type String, max 30 characters long
             * @constraint 'students_pk' as Primary Key, using column 'student_id' only
             */
            String createTable = "CREATE TABLE IF NOT EXISTS students (student_id INT (10) NOT NULL AUTO_INCREMENT, last_name VARCHAR (30), first_name VARCHAR (30), CONSTRAINT students_pk PRIMARY KEY (student_id));";

            /** Executing the statement */
            statement.executeUpdate(createTable);

            /** Inserting 4 new students in the previous table 'students', using the String 'insertStudents'
             *  Pay extreme attention: inserting only 'last_name' and 'first_name': in fact, primary key 'student_id' is AUTO-INCREMENTED!
             */
            String insertStudents = "INSERT INTO students (last_name, first_name) VALUES ('Limina','Alessio'), ('Torelli', 'Alberto'), ('Siniscalco', 'Giorgio'), ('Federico', 'Sacchi');";

            /** Executing the statement */
            statement.executeUpdate(insertStudents);

        } catch (SQLException e) {System.out.println(e.getMessage());
        } finally {
            try { if (conn != null) {conn.close();}
            } catch (SQLException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }
}
