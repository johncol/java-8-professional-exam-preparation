package java8professional.chapter08.streams.examples;

import java.io.*;

public class BufferedInputStreamAndBufferedOutputStream {

    static final int BUFFER_SIZE = 1024;

    static final String SAMPLE_1 = "src/main/resources/iofiles/sample-1.txt";
    static final String SAMPLE_1_COPY = "src/main/resources/iofiles/sample-1-copy.txt";

    static void copyFile(File source, File destination) throws IOException {
        try (   InputStream in = new BufferedInputStream(new FileInputStream(source));
                OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File source = new File(SAMPLE_1);
        File destination = new File(SAMPLE_1_COPY);
        copyFile(source, destination);
    }

}
