package java8professional.chapter05.i18n_l10n.resourcebundle.javaclass;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ListResourceBundle;

public class School_en extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"hello", "Welcome to school!"},
                {"open", "The school is open!"},
                {"day", 1},
                {"someDate", LocalDateTime.of(2016, Month.JUNE, 15, 10, 25)}
        };
    }

}