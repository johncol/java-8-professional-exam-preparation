package java8professional.chapter10;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class ReadingDataFromAResultSet {

    static void readResultSetByColumnsName(Statement statement) {
        Map<Integer, String> map = new HashMap<>();
        try {
            ResultSet books = statement.executeQuery("SELECT id, name FROM books");
            while (books.next()) {
                int id = books.getInt("id");
                String name = books.getString("name");
                map.put(id, name);
            }
            System.out.println("Books: " + books);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void readResultSetByColumnsIndex(Statement statement) {
        Map<Integer, String> map = new HashMap<>();
        try {
            ResultSet books = statement.executeQuery("SELECT id, name FROM books");
            while (books.next()) {
                int id = books.getInt(1);
                String name = books.getString(2);
                map.put(id, name);
            }
            System.out.println("Books: " + books);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void readOneRowResult(Statement statement) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM books");
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                System.out.println("Number of books: " + count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void errors(Statement statement) {
        try {
            ResultSet resultSet = statement.executeQuery("");
            String id = resultSet.getString(0); // BAD INDEX, it's NOT zero-based
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void typesOfGet(ResultSet resultSet) {
        try {
            boolean aBoolean = resultSet.getBoolean(1);
            byte aByte = resultSet.getByte(1);
            short aShort = resultSet.getShort(1);
            int anInt = resultSet.getInt(1);
            long aLong = resultSet.getLong(1);
            float aFloat = resultSet.getFloat(1);
            double aDouble = resultSet.getDouble(1);
            String string = resultSet.getString(1);
            Object object = resultSet.getObject(1);
            java.sql.Date date = resultSet.getDate(1);
            java.sql.Time time = resultSet.getTime(1);
            java.sql.Timestamp timestamp = resultSet.getTimestamp(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void getLocalDate(ResultSet resultSet) {
        try {
            Date date = resultSet.getDate(1);
            LocalDate localDate = date.toLocalDate();
            System.out.println("LocalDate: " + localDate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void getLocalTime(ResultSet resultSet) {
        try {
            Time time = resultSet.getTime(1);
            LocalTime localTime = time.toLocalTime();
            System.out.println("LocalTime: " + localTime);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void getLocalDateTime(ResultSet resultSet) {
        try {
            Timestamp timestamp = resultSet.getTimestamp(1);
            LocalDateTime localDateTime = timestamp.toLocalDateTime();
            System.out.println("LocalDateTime: " + localDateTime);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void getObject(ResultSet resultSet) {
        Map<Integer, String> map = new HashMap<>();
        try {
            if (resultSet.next()) {
                Object id = resultSet.getObject("id");
                Object name = resultSet.getObject("name");
                if (id instanceof Integer && name instanceof String) {
                    map.put((Integer) id, (String) name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
