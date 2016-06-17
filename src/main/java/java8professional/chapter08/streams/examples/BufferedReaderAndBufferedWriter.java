package java8professional.chapter08.streams.examples;

import java.io.*;

public class BufferedReaderAndBufferedWriter {

    static final String SAMPLE_1 = "src/main/resources/iofiles/sample-1.txt";
    static final String SAMPLE_1_COPY = "src/main/resources/iofiles/sample-1-copy.txt";

    static void logAndCopy(File source, File destination) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             BufferedWriter out = new BufferedWriter(new FileWriter(destination))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.print(line);
                out.write(line);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File source = new File(SAMPLE_1);
        File destination = new File(SAMPLE_1_COPY);
        logAndCopy(source, destination);
    }

}
