package java8professional.chapter09.paths.methods;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Path2NameCountAndNames {

    public static void main(String[] args) {
        printNameCountAndNames(Paths.get("/land/hippo/harry.happy"));
        printNameCountAndNames(Paths.get("land/hippo/harry.happy"));
        printNameCountAndNames(Paths.get("/harry.happy"));
        printNameCountAndNames(Paths.get("/"));
        printInvalidNameIndexResult(Paths.get("/land/hippo/harry.happy"));
    }

    static void printNameCountAndNames(Path path) {
        System.out.println("------------------------------------");
        System.out.println("Path:       " + path);

        int nameCount = path.getNameCount();
        System.out.println("Name count: " + nameCount);

        if (nameCount > 0) {
            System.out.println("Names: ");
            for (int i = 0; i < nameCount; i++) {
                System.out.println("  -> " + path.getName(i));
            }
        }

        System.out.println();
    }

    static void printInvalidNameIndexResult(Path path) {
        System.out.println("------------------------------------");
        System.out.println("Path:       " + path);

        int nameCount = path.getNameCount();
        System.out.println("Name count: " + nameCount);

        System.out.println("Trying to get name with index " + nameCount);
        try {
            path.getName(nameCount);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException -> " + e.getMessage());
        }
    }

}
