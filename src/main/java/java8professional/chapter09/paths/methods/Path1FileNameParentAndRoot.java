package java8professional.chapter09.paths.methods;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Path1FileNameParentAndRoot {

    public static void main(String[] args) {
        printFileNameRootAndParents(Paths.get("/land/hippo/harry.happy"));
        printFileNameRootAndParents(Paths.get("c:/land/hippo/harry.happy"));
        printFileNameRootAndParents(Paths.get("land/hippo/harry.happy"));;
        printFileNameRootAndParents(Paths.get("/"));
    }

    static void printFileNameRootAndParents(Path path) {
        System.out.println("------------------------------------");
        System.out.println("Path:      " + path);

        Path fileName = path.getFileName();
        System.out.println("File name: " + fileName);

        Path root = path.getRoot();
        System.out.println("Root:      " + root);

        System.out.println("Parents: ");
        Path current = path;
        do {
            current = current.getParent();
            System.out.println("  -> " + current);
        } while(current != null);

        System.out.println();
    }

}
