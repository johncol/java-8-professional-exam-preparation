package java8professional.chapter08.file;

import java.io.File;

public class FileExists {
    public static void main(String[] args) {
        File file = new File("C:/Program Files/Java/jdk1.8.0_74");
        System.out.println("File: " + file.getAbsolutePath());
        System.out.println(" exists: " + file.exists());

        File root = new File("C:/");
        File file2 = new File(root, "/Program Files/Java/jdk1.8.0_74");
        System.out.println("File: " + file2.getAbsolutePath());
        System.out.println(" exists: " + file2.exists());
    }
}
