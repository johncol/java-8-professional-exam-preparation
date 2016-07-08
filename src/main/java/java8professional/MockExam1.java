package java8professional;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class MockExam1 {}

class Generics {

    static void method(List<String> list) {}

    public static void main(String[] args) {
        List list = new ArrayList();
        method(list);
    }

}

class FileToURI {
    void method() {
        File file = new File("");
        URI uriFromFile = file.toURI();

        Path path = Paths.get("");
        URI uriFromPath = path.toUri();
    }
}

class PathMethodRelativize {
    public static void main(String[] args) {
        Path relativePath = Paths.get("zoo");
        Path absolutePath = Paths.get("c:/zoo");

        try {
            absolutePath.relativize(relativePath);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException -> " + e.getMessage());
        }

        try {
            relativePath.relativize(absolutePath);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException -> " + e.getMessage());
        }
    }
}

class ConstructorsCannotBeFinal {
    // final ConstructorsCannotBeFinal() {} // Modifier 'final' not allowed here
}

class PropertiesHasAMethodCalledKeySet {
    void method() {
        Properties properties = new Properties();
        Set<Object> objects = properties.keySet();
    }
}

class ResourceBundleHasAMethodCalledGetString {
    void method(){
        ResourceBundle bundle = ResourceBundle.getBundle("");
        String string = bundle.getString("");
    }
}

class StringHasAMethodCalledCompareToIgnoreCase {
    public static void main(String[] args) {
        System.out.println("a".compareToIgnoreCase("B"));
    }
}

class GetMethodFromMapInterfaceExpectsAnObjectNotAGenericTypeK {
    public static void main(String[] args) {
        Map<Integer, String> treeSet = new TreeMap<>();
        for (Number number: treeSet.keySet()) {
            System.out.println(treeSet.get(number));
        }
    }
}

class WhereAreTheAtomicClasses {
    void method(java.util.concurrent.atomic.AtomicInteger atomicInteger) {}
}
