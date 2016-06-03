package java8professional.chapter05.i18n_l10n.resourcebundle.formatting;

import java.text.NumberFormat;
import java.util.Locale;

public class FormattingNumbers {

    public static void main(String[] args) {
        numbers();
        System.out.println();
        currencies();
    }

    private static void numbers() {
        int attendeesPerYear = 3_200_000;
        int attendeesPerMonth = attendeesPerYear / 12;

        NumberFormat nmUS = NumberFormat.getInstance(Locale.US);
        System.out.println(nmUS.format(attendeesPerMonth));

        NumberFormat nmGE = NumberFormat.getInstance(Locale.GERMANY);
        System.out.println(nmGE.format(attendeesPerMonth));

        NumberFormat nmCF = NumberFormat.getInstance(Locale.CANADA_FRENCH);
        System.out.println(nmCF.format(attendeesPerMonth));

        NumberFormat nmCO = NumberFormat.getInstance(new Locale("es", "CO"));
        System.out.println(nmCO.format(attendeesPerMonth));
    }

    private static void currencies() {
        double price = 12_000.5;

        NumberFormat fcUS = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(fcUS.format(price));

        NumberFormat fcGE = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.println(fcGE.format(price));

        NumberFormat fcCF = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH);
        System.out.println(fcCF.format(price));

        NumberFormat fcCO = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        System.out.println(fcCO.format(price));
    }
}
