package java8professional.all;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Times {

    public static void main(String[] args) {
        System.out.println(LocalDate.now()); // 2016-07-01
        System.out.println(LocalTime.now()); // 10:07:50.702
        System.out.println(LocalDateTime.now()); // 2016-07-01T10:07:50.702
        System.out.println(ZonedDateTime.now()); // 2016-07-01T10:07:50.702-05:00[America/Bogota]
        System.out.println();

        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(
                LocalDate.now(),
                LocalTime.now(),
                ZoneId.of("America/Bogota")
        );
        System.out.println(zonedDateTime1);

        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(
                LocalDateTime.now(),
                ZoneId.of("US/Eastern")
        );
        System.out.println(zonedDateTime2);

        ZonedDateTime zonedDateTime3 = ZonedDateTime.of(2016, 06, 24, 13, 30, 0, 0, ZoneId.of("Europe/Paris"));
        System.out.println(zonedDateTime3);

        System.out.println(Period.of(14, 0, 66));
        System.out.println(Duration.ofDays(1));


        System.out.println(ChronoUnit.MONTHS.between(LocalDateTime.of(2016, 1, 1, 0, 0), LocalDateTime.of(2016, 1, 2, 0, 0)));

        Instant start = Instant.now();
        System.out.println("start: " + start);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();
        System.out.println("end: " + end);
        System.out.println("Diff: " + ChronoUnit.MILLIS.between(start, end) + " millis");
        System.out.println("Diff: " + Duration.between(start, end).toMillis()    + " millis");
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(end, ZoneId.of("+2"));
        System.out.println(zonedDateTime);
        StringBuilder stringBuilder = new StringBuilder();
    }

}
