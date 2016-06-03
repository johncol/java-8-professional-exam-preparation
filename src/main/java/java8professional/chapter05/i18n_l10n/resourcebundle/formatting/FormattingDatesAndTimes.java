package java8professional.chapter05.i18n_l10n.resourcebundle.formatting;

import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import java.time.format.DateTimeFormatter;

import java.text.MessageFormat;

public class FormattingDatesAndTimes {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2016, Month.FEBRUARY, 10);
        LocalTime localTime = LocalTime.of(10, 30);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        System.out.println();

        System.out.println(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(localTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println();

        DateTimeFormatter localizedDateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        DateTimeFormatter localizedTimeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        DateTimeFormatter localizedDateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

        System.out.println(localDate.format(localizedDateFormatter));
        System.out.println(localTime.format(localizedTimeFormatter));
        System.out.println(localDateTime.format(localizedDateTimeFormatter));
        System.out.println("---same---");
        System.out.println(localizedDateFormatter.format(localDate));
        System.out.println(localizedTimeFormatter.format(localTime));
        System.out.println(localizedDateTimeFormatter.format(localDateTime));
        System.out.println();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d MMM yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy MMMM d, hh:mm");
        System.out.println(dateFormatter.format(localDate));
        System.out.println(timeFormatter.format(localTime));
        System.out.println(dateTimeFormatter.format(localDateTime));
        System.out.println();

        // --------------------------- PARSING DATES AND TIMES

        localDateTime = LocalDateTime.parse("2016-06-15T20:40"); // expects the default format
        System.out.println(localDateTime);
        System.out.println();

        DateTimeFormatter dateParser = DateTimeFormatter.ofPattern("yyyy dd MMMM");
        localDate = LocalDate.parse("1989 24 June", dateParser);
        System.out.println(localDate);
        System.out.println();

        DateTimeFormatter timeParser = DateTimeFormatter.ofPattern("H:m:s");
        localTime = LocalTime.parse("15:4:59", timeParser);
        System.out.println(localTime);
    }
}
