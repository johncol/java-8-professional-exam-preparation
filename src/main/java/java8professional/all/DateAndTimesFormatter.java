package java8professional.all;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateAndTimesFormatter {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.format(now));
        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(now);

        System.out.println();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(dateFormatter.format(now));


    }
}
