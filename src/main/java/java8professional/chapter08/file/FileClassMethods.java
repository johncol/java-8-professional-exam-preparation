package java8professional.chapter08.file;

import java.io.File;
import java.text.NumberFormat;
import java.util.Arrays;

public class FileClassMethods {

    public static final NumberFormat NUMBER_FORMATTER = NumberFormat.getInstance();

    public static void main(String[] args) {
        File file = new File("D:\\eBooks\\Tech");
        System.out.println("File: " + file);

        System.out.println(" exists: " + file.exists());
        System.out.println(" name: " + file.getName());
        System.out.println(" absolute path: " + file.getAbsolutePath());
        System.out.println(" is directory: " + file.isDirectory());
        System.out.println(" is file: " + file.isFile());
        System.out.println(" length(bytes): " + file.length());
        System.out.println(" last modified(millis): " + NUMBER_FORMATTER.format(file.lastModified()));
        System.out.println(" parent: " + file.getParent());
        System.out.println(" files: " + (file.listFiles().length > 0));
        Arrays.stream(file.list()).map(f -> "  " + f).forEach(System.out::println);



    }
}
