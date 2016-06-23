package java8professional.chapter10;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class CreatingAStatement {

    static void createDefaultStatement(Connection connection) {
        try {
            Statement statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void createStatementWithResultSetTypeAndConcurrencyMode(Connection connection) {
        try {
            Statement statement;

            statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,         ResultSet.CONCUR_READ_ONLY);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,   ResultSet.CONCUR_READ_ONLY);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,     ResultSet.CONCUR_READ_ONLY);

            statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,         ResultSet.CONCUR_UPDATABLE);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,   ResultSet.CONCUR_UPDATABLE);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,     ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
