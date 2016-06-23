package java8professional.chapter10;

import java.sql.*;

import static java.sql.ResultSet.*;

public class ManagingTheSQLException {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:oracle:localhost/books");
             Statement statement = connection.createStatement(TYPE_SCROLL_INSENSITIVE, CONCUR_READ_ONLY);
             ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
        ) {
            while (resultSet.next()) {
                System.out.println(resultSet.getLong(4));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
        }

    }

}
