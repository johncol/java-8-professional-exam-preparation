package java8professional.chapter10;

import java.sql.*;

public class ClosingTheResources {

    public static void main(String[] args) throws SQLException {
        try (
                Connection connection = DriverManager.getConnection("");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("");
        ) {
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
            }
        }
    }

}
