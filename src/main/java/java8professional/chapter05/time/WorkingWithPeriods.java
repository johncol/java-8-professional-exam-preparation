package java8professional.chapter05.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.UnsupportedTemporalTypeException;

public class WorkingWithPeriods {

    public static void main(String[] args) {
        checkState(LocalDate.of(2012, 1, 1), LocalDate.of(2012, 6, 30), Period.ofMonths(1));
        System.out.println();

        System.out.println(Period.of(0, 0, 0));
        System.out.println(Period.of(1, 0, 0));
        System.out.println(Period.of(0, 1, 0));
        System.out.println(Period.of(0, 0, 1));
        System.out.println(Period.of(1, 1, 1));
        System.out.println();

        System.out.println(Period.ofYears(1));
        System.out.println(Period.ofMonths(1));
        System.out.println(Period.ofDays(1));
        System.out.println(Period.ofWeeks(1));
        System.out.println();

        System.out.println(Period.of(0, 24, 60));
        System.out.println();

        Period period = Period.of(1, 1, 1);

        LocalDate date = LocalDate.of(2010, 1, 1);
        System.out.println(date.plus(period));

        LocalDateTime dateTime = LocalDateTime.of(2010, 1, 1, 1, 0);
        System.out.println(dateTime.plus(period));

        try {
            LocalTime time = LocalTime.of(1, 1);
            System.out.println(time.plus(period));
        } catch (UnsupportedTemporalTypeException e) {
            System.out.println("UnsupportedTemporalTypeException -> " + e.getMessage());
        }



    }

    static void checkState(LocalDate startDate, LocalDate endDate, Period period) {
        System.out.println("Start: " + startDate);
        System.out.println("End:   " + endDate);
        LocalDate date = startDate;
        while (date.isBefore(endDate)) {
            System.out.println("Checking state: " + date);
            date = date.plus(period);
        }
        System.out.println("End of checks..");
    }
}
