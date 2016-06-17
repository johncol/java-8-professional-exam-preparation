package java8professional.chapter08.streams.examples;

import java.io.*;

public class FileReaderAndFileWriter {

    static final String SAMPLE_1 = "src/main/resources/iofiles/sample-1.txt";
    static final String SAMPLE_1_COPY = "src/main/resources/iofiles/sample-1-copy.txt";

    static void logAndCopy(File source, File destination) throws IOException {
        try (   Reader in = new FileReader(source);
                Writer out = new FileWriter(destination)) {
            int value;
            while ((value = in.read()) != -1) {
                char character = (char) value;
                System.out.print(character);
                out.write(character);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File source = new File(SAMPLE_1);
        File destination = new File(SAMPLE_1_COPY);
        logAndCopy(source, destination);
    }

}
