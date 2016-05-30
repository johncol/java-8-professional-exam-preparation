package java8professional.chapter05.time;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Date;

public class WorkingWithInstants {
    public static void main(String[] args) {
        Instant start = Instant.now();
        System.out.println("Start: " + start);
        Instant end = Instant.now();
        System.out.println("End: " + end);
        Duration duration = Duration.between(start, end);
        System.out.println("Duration: " + duration);
        System.out.println();

        LocalDate date = LocalDate.of(2016, 6, 20);
        LocalTime time = LocalTime.of(12, 0);
        ZoneId zone = ZoneId.of("-05:00");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zone);
        Instant instant = zonedDateTime.toInstant();
        System.out.println("ZonedDateTime: " + zonedDateTime);
        System.out.println("Instant:       " + instant);
        System.out.println();

        long millisSince1970 = new Date().getTime();
        Instant nowInGMT0 = Instant.ofEpochMilli(millisSince1970);
        System.out.println(nowInGMT0);
        System.out.println();

        System.out.println(nowInGMT0.plus(1, ChronoUnit.NANOS));
        System.out.println(nowInGMT0.plus(1, ChronoUnit.MICROS));
        System.out.println(nowInGMT0.plus(1, ChronoUnit.MILLIS));
        System.out.println(nowInGMT0.plus(1, ChronoUnit.SECONDS));
        System.out.println(nowInGMT0.plus(1, ChronoUnit.MINUTES));
        System.out.println(nowInGMT0.plus(1, ChronoUnit.HOURS));
        System.out.println(nowInGMT0.plus(1, ChronoUnit.HALF_DAYS));
        System.out.println(nowInGMT0.plus(1, ChronoUnit.DAYS));
        try { System.out.println(nowInGMT0.plus(1, ChronoUnit.WEEKS)); }
        catch (UnsupportedTemporalTypeException e) { System.out.println("UnsupportedTemporalTypeException -> " + e.getMessage()); }
        try { System.out.println(nowInGMT0.plus(1, ChronoUnit.MONTHS)); }
        catch (UnsupportedTemporalTypeException e) { System.out.println("UnsupportedTemporalTypeException -> " + e.getMessage()); }
        try { System.out.println(nowInGMT0.plus(1, ChronoUnit.YEARS)); }
        catch (UnsupportedTemporalTypeException e) { System.out.println("UnsupportedTemporalTypeException -> " + e.getMessage()); }
        try { System.out.println(nowInGMT0.plus(1, ChronoUnit.DECADES)); }
        catch (UnsupportedTemporalTypeException e) { System.out.println("UnsupportedTemporalTypeException -> " + e.getMessage()); }
        try { System.out.println(nowInGMT0.plus(1, ChronoUnit.CENTURIES)); }
        catch (UnsupportedTemporalTypeException e) { System.out.println("UnsupportedTemporalTypeException -> " + e.getMessage()); }
        try { System.out.println(nowInGMT0.plus(1, ChronoUnit.MILLENNIA)); }
        catch (UnsupportedTemporalTypeException e) { System.out.println("UnsupportedTemporalTypeException -> " + e.getMessage()); }
        try { System.out.println(nowInGMT0.plus(1, ChronoUnit.ERAS)); }
        catch (UnsupportedTemporalTypeException e) { System.out.println("UnsupportedTemporalTypeException -> " + e.getMessage()); }

    }
}
