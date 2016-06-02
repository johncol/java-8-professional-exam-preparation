package java8professional.chapter05.i18n_l10n.resourcebundle.javaclass;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.ResourceBundle;

public class JavaClassResourceBundle {

    public static void main(String[] args) {
        Locale en = Locale.ENGLISH;
        ResourceBundle school = ResourceBundle.getBundle("java8professional.chapter05.i18n_l10n.resourcebundle.javaclass.School", en);
        System.out.println(school.getString("hello"));
        System.out.println(school.getString("open"));
        int day = (int) school.getObject("day");
        System.out.println(day);
        LocalDateTime someDate = (LocalDateTime) school.getObject("someDate");
        System.out.println(someDate);
    }
}

