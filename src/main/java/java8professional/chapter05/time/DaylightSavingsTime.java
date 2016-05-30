package java8professional.chapter05.time;

import java.time.*;

public class DaylightSavingsTime {

    public static void main(String[] args) {
        savingTimePlusOneHour();
        System.out.println();
        savingTimeMinusOneHour();
        System.out.println();
        creatingAnHourThatDoesNotExist();
    }

    static void savingTimePlusOneHour() {
        LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zoneId = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zoneId);
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.plusHours(1));
    }

    static void savingTimeMinusOneHour() {
        LocalDate date = LocalDate.of(2016, Month.NOVEMBER, 6);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zoneId = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zoneId);
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.plusHours(1));
    }

    static void creatingAnHourThatDoesNotExist() {
        LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time = LocalTime.of(2, 30);
        ZoneId zoneId = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zoneId);
        System.out.println(zonedDateTime);
    }
}
