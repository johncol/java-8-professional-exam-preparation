package java8professional.chapter09.paths.methods;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Path6Relativize {

    public static void main(String[] args) {
        Path path1;
        Path path2;

        path1 = Paths.get("folder/folder/file1.txt");
        path2 = Paths.get("folder/folder/file2.txt");
        printRelativizeResult(path1, path2);

        path1 = Paths.get("folder1/folder2/file1.txt");
        path2 = Paths.get("folder3/file2.txt");
        printRelativizeResult(path1, path2);

        path1 = Paths.get("folder1/folder2/file1.txt");
        path2 = Paths.get("folder1/file2.txt");
        printRelativizeResult(path1, path2);

        path1 = Paths.get("c:/folder/folder/file1.txt");
        path2 = Paths.get("c:/folder/folder/file2.txt");
        printRelativizeResult(path1, path2);

        path1 = Paths.get("c:/folder1/folder2/file1.txt");
        path2 = Paths.get("c:/folder3/file2.txt");
        printRelativizeResult(path1, path2);

        path1 = Paths.get("c:/folder1/folder2/file1.txt");
        path2 = Paths.get("c:/folder1/file2.txt");
        printRelativizeResult(path1, path2);

        path1 = Paths.get("c:/folder/folder/file1.txt");
        path2 = Paths.get("C:/folder/folder/file2.txt");
        printRelativizeResult(path1, path2);

        path1 = Paths.get("c:/folder/folder/file1.txt");
        path2 = Paths.get("d:/folder/folder/file2.txt");
        printRelativizeResult(path1, path2);

        path1 = Paths.get("folder/folder/file1.txt");
        path2 = Paths.get("c:/folder/folder/file2.txt");
        printRelativizeResult(path1, path2);


    }

    static void printRelativizeResult(Path origin, Path target) {
        System.out.println("-----------------------------------------");
        try {
            System.out.println("Path 1:        " + origin);
            System.out.println("  is absolute? " + origin.isAbsolute());
            System.out.println("Path 2:        " + target);
            System.out.println("  is absolute? " + target.isAbsolute());
            Path relativePath = origin.relativize(target);
            System.out.println("Relative path: " + relativePath);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException -> " + e.getMessage());
        }
        System.out.println();
    }

}
