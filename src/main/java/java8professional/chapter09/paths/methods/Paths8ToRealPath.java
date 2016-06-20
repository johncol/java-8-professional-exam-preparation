package java8professional.chapter09.paths.methods;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Paths8ToRealPath {
    public static void main(String[] args) {
        printToRealPathResult(Paths.get("README.md"));
        printToRealPathResult(Paths.get("./././././README.md"));
        printToRealPathResult(Paths.get("D:\\Workspace\\java8professional\\README.md"));
        printToRealPathResult(Paths.get("/Workspace/java8professional/README.md"));

        printToRealPathResult(Paths.get("."));
        printToRealPathResult(Paths.get("../../"));
        printToRealPathResult(Paths.get("../../../../../../../../"));

        printToRealPathResult(Paths.get("does-not-exist-file.txt"));
    }

    static void printToRealPathResult(Path path) {
        System.out.println("-------------------------------------------");
        try {
            System.out.println("Path:         " + path);
            Path readmeFile = path.toRealPath();
            System.out.println("To real path: " + readmeFile);
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " -> " + e.getMessage());
        }
    }
}
