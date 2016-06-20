package java8professional.chapter09.paths.methods;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;

public class Path4SubPath {

    public static void main(String[] args) {
        Path path = Paths.get("c:/land/hippo/harry.happy");

        System.out.println("Path:           " + path);
        System.out.println("subpath (0, 1): " + path.subpath(0, 1));
        System.out.println("subpath (0, 2): " + path.subpath(0, 2));
        System.out.println("subpath (0, 3): " + path.subpath(0, 3));
        System.out.println("subpath (1, 2): " + path.subpath(1, 2));
        System.out.println("subpath (1, 3): " + path.subpath(1, 3));
        System.out.println("subpath (2, 3): " + path.subpath(2, 3));
        System.out.println();

        printInvalidSubpathResult(path, 0, 4);
        printInvalidSubpathResult(path, 4, 9);
        printInvalidSubpathResult(path, 1, 1);
        printInvalidSubpathResult(path, 2, 1);

    }

    static void printInvalidSubpathResult(Path path, int start, int end) {
        System.out.print(MessageFormat.format("Trying to subpath from {0} to {1} : ", start, end));
        try {
            path.subpath(start, end);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException -> " + e.getMessage());
        }
    }

}
