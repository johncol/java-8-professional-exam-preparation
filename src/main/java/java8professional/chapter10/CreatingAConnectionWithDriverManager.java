package java8professional.chapter10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreatingAConnectionWithDriverManager {

    static void createAConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql:localhost:5220/books");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void createAConnectionWithUserAndPassword() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql:localhost:5220/books", "user", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void createAConnectionAndUseClassForNameMethod() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql:localhost:5220/books", "user", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
