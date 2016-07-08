package java8professional.all;

import java.io.*;

public class IOStreams {

    public static void main(String[] args)  throws IOException {
        try (   Writer writer = new FileWriter("");
                Reader reader = new FileReader("");
                BufferedWriter bw = new BufferedWriter(writer);
                BufferedReader br = new BufferedReader(reader);
                ) {
        }
    }

    void print(PrintStream out) {
        out.write(99);
        out.println();
        out.print("");
        out.printf("");
        out.format("");
        out.checkError();
    }
}
