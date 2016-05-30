package java8professional.chapter05.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;

public class WorkingWithDurations {

    public static void main(String[] args) {
        checkBaby(LocalTime.of(5, 30), LocalTime.of(12, 0), Duration.ofMinutes(30));
        System.out.println();

        System.out.println(Duration.ofDays(1));
        System.out.println(Duration.ofHours(12));
        System.out.println(Duration.ofMinutes(30));
        System.out.println(Duration.ofSeconds(20));
        System.out.println(Duration.ofMillis(100));
        System.out.println(Duration.ofNanos(500000000));
        System.out.println();

        System.out.println(Duration.ofSeconds(1, 500000000));
        System.out.println();

        System.out.println(Duration.of(1, ChronoUnit.DAYS));
        System.out.println(Duration.of(1, ChronoUnit.HALF_DAYS));
        System.out.println(Duration.of(1, ChronoUnit.HOURS));
        System.out.println(Duration.of(1, ChronoUnit.MINUTES));
        System.out.println(Duration.of(1, ChronoUnit.SECONDS));
        System.out.println(Duration.of(1, ChronoUnit.MILLIS));
        System.out.println(Duration.of(1, ChronoUnit.MICROS));
        System.out.println(Duration.of(1, ChronoUnit.NANOS));
        System.out.println();

        Duration duration = Duration.ofHours(12);
        System.out.println(duration);

        LocalDate date = LocalDate.of(2010, 1, 1);
        LocalTime time = LocalTime.of(10, 30);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime.minus(duration));
        System.out.println(time.minus(duration));
        try {
            System.out.println(date.minus(duration));
        } catch(UnsupportedTemporalTypeException e) {
            System.out.println("UnsupportedTemporalTypeException -> " + e.getMessage());
        }
        System.out.println();

        LocalTime one = LocalTime.of(1, 10, 10);
        LocalTime two = LocalTime.of(2, 20, 20);
        System.out.println(ChronoUnit.HOURS.between(one, two));
        System.out.println(ChronoUnit.MINUTES.between(one, two));
        System.out.println(ChronoUnit.SECONDS.between(one, two));
    }

    static void checkBaby(LocalTime start, LocalTime end, Duration duration){
        System.out.println("Start time: " + start);
        System.out.println("End time:   " + end);
        LocalTime time = start;
        while (time.isBefore(end)) {
            System.out.println("Checking baby at " + time);
            time = time.plus(duration);
        }
        System.out.println("End checking the baby");
    }
}
