package java8professional.chapter10;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecutingAStatement {

    static void executeUpdateStatement(Statement statement) {
        try {
            String insert = "INSERT INTO books VALUES (1, 'Christine', 'Stephen King')";
            int numberOfRowsInserted = statement.executeUpdate(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String update = "UPDATE books SET name='Dead Zone' WHERE id=1";
            int numberOfRowsUpdated = statement.executeUpdate(update);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String delete = "DELETE FROM books WHERE name='Dead Zone'";
            int numberOfRowsDeleted = statement.executeUpdate(delete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void executeQueryStatement(Statement statement) {
        String select = "SELECT * FROM books";
        try {
            ResultSet resultSet = statement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void executeAnyStatement(Statement statement, String sql) {
        try {
            boolean isThereAResultSet = statement.execute(sql);
            if (isThereAResultSet) {
                ResultSet resultSet = statement.getResultSet();
            } else {
                int numberOfRowsUpdated = statement.getUpdateCount();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
