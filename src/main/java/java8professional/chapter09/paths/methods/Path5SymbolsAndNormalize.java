package java8professional.chapter09.paths.methods;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Path5SymbolsAndNormalize {
    public static void main(String[] args) {
        printPathWithSpecialSymbols(Paths.get("."));
        printPathWithSpecialSymbols(Paths.get("./some-file.txt"));
        printPathWithSpecialSymbols(Paths.get(".."));
        printPathWithSpecialSymbols(Paths.get("../"));
        printPathWithSpecialSymbols(Paths.get("../some-file-again.txt"));
        printPathWithSpecialSymbols(Paths.get("../../"));
        printPathWithSpecialSymbols(Paths.get("../../../../../../../../../../../../"));
    }

    static void printPathWithSpecialSymbols(Path path) {
        System.out.println("-----------------------------------------");
        System.out.println("Path:                     " + path);
        System.out.println("Absolute path:            " + path.toAbsolutePath());
        System.out.println("Normalized path:          " + path.normalize());
        System.out.println("Normalized absolute path: " + path.toAbsolutePath().normalize());
        System.out.println();
    }
}
