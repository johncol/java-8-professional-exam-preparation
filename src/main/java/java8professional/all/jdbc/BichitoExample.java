package java8professional.all.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BichitoExample {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("java8professional.all.jdbc.implementations.BichitoDriver");
        try {
            Connection connection = DriverManager.getConnection("jdbc:bichito:localhost/books");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
