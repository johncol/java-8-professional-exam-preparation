package java8professional.chapter05.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class ManipulatingDatesAndTimes {
    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2010, Month.JANUARY, 10);
        System.out.println(date);

        date = date.plusDays(12);
        System.out.println(date);

        date = date.plusWeeks(1);
        System.out.println(date);

        date = date.plusMonths(1);
        System.out.println(date);

        date = date.plusYears(20);
        System.out.println(date);

        System.out.println();


        LocalTime time = LocalTime.of(15, 30);
        System.out.println(time);

        time = time.minusHours(1);
        System.out.println(time);

        time = time.minusMinutes(70);
        System.out.println(time);

        time = time.minusSeconds(30);
        System.out.println(time);

        time = time.minusNanos(500000000);
        System.out.println(time);

        System.out.println();


        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime);

        dateTime = dateTime.plusNanos(500000000)
                .plusSeconds(30)
                .plusMinutes(70)
                .plusHours(1)
                .minusYears(20)
                .minusMonths(1)
                .plusDays(1)
                .minusWeeks(1)
                .minusDays(12);
        System.out.println(dateTime);
    }
}
