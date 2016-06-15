package java8professional.chapter08;

import java.io.File;

public class OSSeparatorSymbol {
    public static void main(String[] args) {
        System.out.println("OS path separator:");
        System.out.println(System.getProperty("file.separator"));
        System.out.println(File.separator);
    }
}
