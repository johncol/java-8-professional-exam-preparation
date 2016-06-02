package java8professional.chapter05.i18n_l10n.resourcebundle;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DeterminingWhichResourceBundleToUse {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.out.println(Locale.getDefault());
        System.out.println();

        Locale colombia = new Locale.Builder()
                .setLanguage("es")
                .setRegion("CO")
                .build();
        ResourceBundle bundle = ResourceBundle.getBundle("Example", colombia);
        bundle.keySet().forEach(k -> System.out.println(" -> " + k + ": " + bundle.getString(k)));
        System.out.println();

        System.out.println(bundle.getString("property1"));
        System.out.println(bundle.getString("property2"));
        System.out.println(bundle.getString("property5"));
        try {
            System.out.println(bundle.getString("property3"));
        } catch (MissingResourceException e) {
            System.out.println("MissingResourceException -> " + e.getMessage());
        }
        try {
            System.out.println(bundle.getString("property4"));
        } catch (MissingResourceException e) {
            System.out.println("MissingResourceException -> " + e.getMessage());
        }

    }
}
