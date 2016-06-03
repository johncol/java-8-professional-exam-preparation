package java8professional.chapter05.i18n_l10n.resourcebundle.propertyfile;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertyFileBundleResources {

    public static final String ZOO = "Zoo";

    public static void main(String[] args) {
        Locale us = Locale.US;
        Locale fr = Locale.FRANCE;
        printProperty(us, "hello");
        printProperty(fr, "open");
        System.out.println();

        printAllProperties(us);
        System.out.println();
        printAllProperties(fr);
        System.out.println();

        Properties usProperties = getProperties(us);
        System.out.println(usProperties.get("what!!"));
        System.out.println(usProperties.getProperty("what!!"));
        System.out.println(usProperties.getProperty("what!!", "DEFAULT VALUE FOR 'what!!' KEY"));
        System.out.println(usProperties.getProperty("hello", "hola paisanos"));
        System.out.println();
    }

    static void printProperty(Locale locale, String property) {
        ResourceBundle zooBundle = ResourceBundle.getBundle(ZOO, locale);
        System.out.println(zooBundle.getString(property));
    }

    static void printAllProperties(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle(ZOO, locale);
        bundle.keySet().stream()
                .map(k -> k + ": " + bundle.getString(k))
                .forEach(System.out::println);
    }

    static Properties getProperties(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle(ZOO, locale);
        Properties properties = new Properties();
        bundle.keySet().forEach(k -> properties.put(k, bundle.getString(k)));
        return properties;
    }

}
