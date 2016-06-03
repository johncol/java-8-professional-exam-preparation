package java8professional.chapter05.i18n_l10n.resourcebundle.formatting;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ParsingNumbers {
    public static void main(String[] args) throws ParseException {
        NumberFormat en = NumberFormat.getInstance(Locale.US);
        NumberFormat fr = NumberFormat.getInstance(Locale.FRANCE);

        String value = "40.45";

        System.out.println(en.parse(value));
        System.out.println(fr.parse(value));
        System.out.println();

        System.out.println(en.parse("123.456"));
        System.out.println(en.parse("123.456XXX"));
        System.out.println(en.parse("123.XXX456"));
        try {
            System.out.println(en.parse("XXX123.456"));
        } catch (ParseException e) {
            System.out.println("ParseException -> " + e.getMessage());
        }
        System.out.println();

        NumberFormat enCurrencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        String price = "$94,096.24";
        Number numberPrice = enCurrencyFormatter.parse(price);
        System.out.println(numberPrice);
    }
}
