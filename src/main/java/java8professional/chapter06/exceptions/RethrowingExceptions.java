package java8professional.chapter06.exceptions;

import java.sql.SQLException;
import java.time.format.DateTimeParseException;

public class RethrowingExceptions {

    static void multiCatch() throws SQLException, DateTimeParseException {
        try {
            parseData();
        } catch (Exception e) {
            System.out.println(e);
            throw e;
            // although I'm throwing what is defined as an Exception, in the method signature I say:
            // I'm only throwing a SQLException or a DateTimeParseException
        }
    }

    static void parseData() throws SQLException, DateTimeParseException {}
}
