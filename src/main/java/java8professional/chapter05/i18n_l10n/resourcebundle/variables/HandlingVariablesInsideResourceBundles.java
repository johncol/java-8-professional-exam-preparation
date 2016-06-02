package java8professional.chapter05.i18n_l10n.resourcebundle.variables;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class HandlingVariablesInsideResourceBundles {

    public static void main(String[] args) {
        String bundleFullyQualifiedName = "java8professional.chapter05.i18n_l10n.resourcebundle.variables.DummyResourceBundle";
        ResourceBundle bundle = ResourceBundle.getBundle(bundleFullyQualifiedName, Locale.FRENCH);

        String welcome = bundle.getString("welcome");
        System.out.println(welcome);

        String formattedWelcome = MessageFormat.format(welcome, "John");
        System.out.println(formattedWelcome);
    }
}

