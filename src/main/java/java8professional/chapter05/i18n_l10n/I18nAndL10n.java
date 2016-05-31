package java8professional.chapter05.i18n_l10n;

import java.util.Locale;

public class I18nAndL10n {

    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println(locale);
        System.out.println();

        System.out.println(Locale.ITALIAN);
        System.out.println(Locale.ITALY);
        System.out.println();

        System.out.println(new Locale("es"));
        System.out.println(new Locale("es", "CO"));
        System.out.println();

        System.out.println(new Locale("JHDSJKDgHD"));
        System.out.println(new Locale("esdasdas", "CDCO"));
        System.out.println();

        Locale locale1 = new Locale.Builder()
                .setLanguage("en")
                .setRegion("US")
                .build();
        System.out.println(locale1);
        System.out.println();

        Locale.setDefault(Locale.FRANCE);
        System.out.println(Locale.getDefault());
        System.out.println();




    }
}
