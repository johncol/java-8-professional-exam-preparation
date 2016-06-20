package java8professional.chapter09.paths.methods;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Path7JoiningPaths {

    public static void main(String[] args) {
        Path path1;
        Path path2;

        path1 = Paths.get("folder1/folder2/");
        path2 = Paths.get("folder3/folder4");
        printJoiningResult(path1, path2);

        path1 = Paths.get("/folder1/folder2/");
        path2 = Paths.get("/folder3/folder4/");
        printJoiningResult(path1, path2);

        path1 = Paths.get("c:/folder1/folder2/");
        path2 = Paths.get("c:/folder3/folder4/");
        printJoiningResult(path1, path2);

        path1 = Paths.get("c:/folder1/folder2/");
        path2 = Paths.get("/folder3/folder4/");
        printJoiningResult(path1, path2);

        path1 = Paths.get("c:/folder1/folder2/");
        path2 = Paths.get("folder3/folder4/");
        printJoiningResult(path1, path2);

        path1 = Paths.get("folder1/folder2/");
        path2 = Paths.get("c:/folder3/folder4/");
        printJoiningResult(path1, path2);

        path1 = Paths.get("d:/folder1/folder2/");
        path2 = Paths.get("c:/folder3/folder4/");
        printJoiningResult(path1, path2);

    }

    static void printJoiningResult(Path path1, Path path2) {
        System.out.println("-----------------------------------------");
        System.out.println("Path 1:        " + path1);
        System.out.println("  is absolute? " + path1.isAbsolute());
        System.out.println("Path 2:        " + path2);
        System.out.println("  is absolute? " + path2.isAbsolute());
        Path joinedPath = path1.resolve(path2);
        System.out.println("Joined path:   " + joinedPath);
        System.out.println(".equals to path2: " + (joinedPath.equals(path2)));
        System.out.println("== to path2: " + (joinedPath == path2));
        System.out.println();
    }

}
