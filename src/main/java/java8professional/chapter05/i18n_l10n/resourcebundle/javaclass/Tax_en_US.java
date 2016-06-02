package java8professional.chapter05.i18n_l10n.resourcebundle.javaclass;

import java.util.ListResourceBundle;

public class Tax_en_US extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"taxCode", new UsTaxCode()}
        };
    }
}

class UsTaxCode {}