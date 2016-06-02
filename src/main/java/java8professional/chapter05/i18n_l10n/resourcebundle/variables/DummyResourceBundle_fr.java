package java8professional.chapter05.i18n_l10n.resourcebundle.variables;

import java.util.ListResourceBundle;

public class DummyResourceBundle_fr extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"welcome", "Welcome {0}!!"}
        };
    }
}
