package java8professional.chapter09.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BufferedReaderWriterAndReadAllLines {

    static final String FILE = "src\\main\\java\\java8professional\\responses.txt";

    public static void main(String[] args) throws java.io.IOException {
        readLinesWithBufferedReaderExample();
        System.out.println("---------------------------------");
        readLinesFilesMethodExample();
    }

    static void readLinesWithBufferedReaderExample() throws IOException {
        Charset charset = Charset.defaultCharset();
        Path path = Paths.get(FILE);
        try (BufferedReader in = Files.newBufferedReader(path, charset)) {
            String line;
            while((line = in.readLine()) != null) {
                System.out.println("Line read: " + line);
            }
        }
    }

    static void readLinesFilesMethodExample() {
        Path path = Paths.get(FILE);
        Charset charset = Charset.defaultCharset();
        try {
            List<String> lines = Files.readAllLines(path, charset);
            lines.forEach(line -> System.out.println("Line read: " + line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
