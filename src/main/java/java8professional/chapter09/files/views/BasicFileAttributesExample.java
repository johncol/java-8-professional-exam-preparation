package java8professional.chapter09.files.views;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class BasicFileAttributesExample {
    public static void main(String[] args) {
        Path path = Paths.get("src");
        try {
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("Attributes: " + attributes);
            System.out.println(ToStringBuilder.reflectionToString(attributes, ToStringStyle.MULTI_LINE_STYLE));
            System.out.println();

            System.out.println(" is directory:     " + attributes.isDirectory());
            System.out.println(" is file:          " + attributes.isRegularFile());
            System.out.println(" is symbolic link: " + attributes.isSymbolicLink());
            System.out.println(" is other:         " + attributes.isOther());
            System.out.println();

            System.out.println(" creation time:      " + attributes.creationTime());
            System.out.println(" last access time:   " + attributes.lastAccessTime());
            System.out.println(" last modified time: " + attributes.lastModifiedTime());
            System.out.println();

            System.out.println(" size:     " + attributes.size());
            System.out.println(" file key: " + attributes.fileKey());
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " -> " + e.getMessage());
        }
    }
}
