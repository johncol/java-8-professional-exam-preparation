package java8professional.chapter10;

import java.sql.*;

public class ReadingDataFromAScrollableResultSet {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql:localhost:5230/books", "user", "pass");
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

            resultSet.beforeFirst();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
            }

            resultSet.afterLast();
            while (resultSet.previous()) {
                System.out.println(resultSet.getInt("id"));
            }

            System.out.println(resultSet.first());
            System.out.println(resultSet.last());

            boolean isTheCursorPointingToAValidRow;

            isTheCursorPointingToAValidRow = resultSet.absolute(0); // goes to before first (and isTheCursorPointingToAValidRow = false)
            isTheCursorPointingToAValidRow = resultSet.absolute(3); // goes to row 3 (and isTheCursorPointingToAValidRow = true)
            isTheCursorPointingToAValidRow = resultSet.absolute(-1); // goes to the last row (and isTheCursorPointingToAValidRow = true)

            isTheCursorPointingToAValidRow = resultSet.relative(0); // stays in the same row
            isTheCursorPointingToAValidRow = resultSet.relative(3); // goes 3 rows forward
            isTheCursorPointingToAValidRow = resultSet.relative(-1); // goes 1 row backward
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
