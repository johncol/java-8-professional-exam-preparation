package java8professional.chapter09.paths.methods;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Path3AbsoluteAndToAbsolute {

    public static void main(String[] args) {
        printAbsolutePath(Paths.get("c:/land/hippo/harry.happy"));
        printAbsolutePath(Paths.get("/land/hippo/harry.happy"));
        printAbsolutePath(Paths.get("land/hippo/harry.happy"));
    }

    static void printAbsolutePath(Path path) {
        System.out.println("-----------------------------------------");
        System.out.println("Path:          " + path);
        System.out.println("Is absolute:   " + path.isAbsolute());

        Path absolutePath = path.toAbsolutePath();
        System.out.println("Absolute path: " + absolutePath);
        System.out.println();
    }

}
