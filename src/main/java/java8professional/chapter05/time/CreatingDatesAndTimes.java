package java8professional.chapter05.time;

import static java.time.Month.*;

import java.time.*;
import java.time.zone.ZoneRulesException;

public class CreatingDatesAndTimes {

    public static void main(String[] args) {
        // now()
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        System.out.println(zonedDateTime);
        System.out.println();


        // Local Date
        LocalDate date1 = LocalDate.of(2016, JANUARY, 25);
        LocalDate date2 = LocalDate.of(2016, 1, 25);

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date1.equals(date2));
        System.out.println();


        // Local Time
        LocalTime time1 = LocalTime.of(15, 30);
        LocalTime time2 = LocalTime.of(15, 30, 55);
        LocalTime time3 = LocalTime.of(15, 30, 55, 200);

        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);
        System.out.println();


        // Local Date and Time
        LocalDateTime dateTime1 = LocalDateTime.of(2016, JANUARY, 25, 15, 30, 55, 200);
        LocalDateTime dateTime2 = LocalDateTime.of(date1, time3);

        System.out.println(dateTime1);
        System.out.println(dateTime2);
        System.out.println(dateTime1.equals(dateTime2));
        System.out.println();


        // ZoneId
        try {
            ZoneId.of("who knows..");
        } catch (DateTimeException e) {
            System.out.println("DateTimeException: " + e.getMessage());
        }

        ZoneId zone5 = ZoneId.of("-05:00");
        System.out.println(zone5);
        System.out.println(ZoneId.systemDefault());
        System.out.println();


        // Zoned Date and Time
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(2016, 1, 25, 15, 30, 55, 200, zone5);
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(date1, time3, zone5);
        ZonedDateTime zonedDateTime3 = ZonedDateTime.of(dateTime1, zone5);

        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);
        System.out.println(zonedDateTime3);

        System.out.println(zonedDateTime1.equals(zonedDateTime2));
        System.out.println(zonedDateTime1.equals(zonedDateTime3));
        System.out.println();

        ZoneId zone7 = ZoneId.of("-07:00");
        ZonedDateTime zonedDateTime4 = ZonedDateTime.of(2016, 1, 25, 13, 30, 55, 200, zone7);
        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime4);
        System.out.println(zonedDateTime1.equals(zonedDateTime4));
        System.out.println();


        // All zones
        System.out.println(ZoneId.getAvailableZoneIds().size());
        ZoneId.getAvailableZoneIds().stream()
                .filter(zone -> zone.contains("Bogota"))
                .forEach(System.out::println);
        System.out.println();


        // Date Time Exception
        try {
            System.out.println(LocalTime.of(25, 10, 10));
        } catch(DateTimeException e) {
            System.out.println("DateTimeException: " + e.getMessage());
        }
        try {
            System.out.println(LocalTime.of(23, 66, 10));
        } catch(DateTimeException e) {
            System.out.println("DateTimeException: " + e.getMessage());
        }
        try {
            System.out.println(LocalTime.of(23, 7, 66));
        } catch(DateTimeException e) {
            System.out.println("DateTimeException: " + e.getMessage());
        }
        try {
            System.out.println(LocalTime.of(23, 7, 55, -1));
        } catch(DateTimeException e) {
            System.out.println("DateTimeException: " + e.getMessage());
        }
        try {
            System.out.println(LocalDate.of(2016, 10, 33));
        } catch(DateTimeException e) {
            System.out.println("DateTimeException: " + e.getMessage());
        }
        try {
            System.out.println(LocalDate.of(2016, 15, 5));
        } catch(DateTimeException e) {
            System.out.println("DateTimeException: " + e.getMessage());
        }
        try {
            System.out.println(LocalDate.of(0, 10, 5));
        } catch(DateTimeException e) {
            System.out.println("DateTimeException: " + e.getMessage());
        }

    }
}
