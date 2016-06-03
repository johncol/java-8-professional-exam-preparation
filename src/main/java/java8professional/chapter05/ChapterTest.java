package java8professional.chapter05;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import java.util.Set;

public class ChapterTest {
    public static void main(String[] args) {
        // LocalDate has getDayOfMonth method
        LocalDate localDate = LocalDate.of(2016, 6, 6);
        System.out.println(localDate.getDayOfMonth());

        System.out.println();

        // DateTimeFormatter.ISO_LOCAL_DATE expects something like 2018-06-25
        localDate = LocalDate.parse("2018-06-25", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));

        System.out.println();

        // daylight savings, ChronoUnit between method
        LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zoneId = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(date, time, zoneId);
        ZonedDateTime zonedDateTime2 = zonedDateTime1.plus(1, ChronoUnit.HOURS);

        long hours = ChronoUnit.HOURS.between(zonedDateTime1, zonedDateTime2);
        int clock1 = zonedDateTime1.getHour();
        int clock2 = zonedDateTime2.getHour();
        System.out.println(hours);      // 1
        System.out.println(clock1);     // 1
        System.out.println(clock2);     // 3

        System.out.println();

        // string representation of Periods and Durations
        String m1 = Duration.of(1, ChronoUnit.MINUTES).toString();
        String m2 = Duration.ofMinutes(1).toString();
        String s = Duration.of(60, ChronoUnit.SECONDS).toString();

        String d = Duration.ofDays(1).toString();
        String p = Period.ofDays(1).toString();

        System.out.println(m1);     // PT1M
        System.out.println(m2);     // PT1M
        System.out.println(s);      // PT60S X -> PT1M
        System.out.println(d);      // PT24H
        System.out.println(p);      // P1D

        System.out.println();

        System.out.println(Duration.ofSeconds(59));
        System.out.println(Duration.ofSeconds(61));
        System.out.println(Duration.ofSeconds(121));
        System.out.println(Duration.ofSeconds(3601));
        System.out.println(Duration.ofSeconds(3661));

        System.out.println();

        // ways of obtaining an instance of Instant
        System.out.println(Instant.now());
        System.out.println(Instant.ofEpochSecond(0));
        System.out.println(ZonedDateTime.now().toInstant());

        System.out.println();

        // properties also has a method called keySet for getting the keys
        Set<Object> keys = new Properties().keySet();
        System.out.println(keys);
    }
}
