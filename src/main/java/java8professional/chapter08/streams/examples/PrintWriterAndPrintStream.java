package java8professional.chapter08.streams.examples;

import java8professional.chapter08.streams.examples.sample.DragonAgeCharacter;

import java.io.*;

import static java8professional.chapter08.streams.examples.sample.DragonAgeCharacterType.WARRIOR;

public class PrintWriterAndPrintStream {

    static final String OUTPUT_FILE = "src/main/resources/iofiles/sample-2.txt";
    static final String OUTPUT_FILE_2 = "src/main/resources/iofiles/sample-3.txt";

    public static void main(String[] args) throws IOException {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT_FILE)))) {
            out.println("Awesome! It works!");
            out.println("Look! The hero of Ferelden!");
            out.println(createWarden());
        }
        try (   StringWriter stringWriter = new StringWriter(1000);
                PrintWriter out = new PrintWriter(stringWriter)) {
            out.println("Awesome! It works!");
            out.println("Look! The hero of Ferelden!");
            out.println(createWarden());
            System.out.println(stringWriter.toString());
        }
        try (PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(OUTPUT_FILE_2)))) {
            out.println("Awesome! It works!");
            out.println("Look! The hero of Ferelden!");
            out.println(createWarden());
        }
    }

    static DragonAgeCharacter createWarden() {
        return new DragonAgeCharacter.Builder()
                .withName("The Warden")
                .withType(WARRIOR)
                .withDescription("The main protagonist of the game. You become a Grey Warden after going " +
                        "through a unique origin story tailored to your race and background. Afterwards, " +
                        "you go to Ostagar in order to join King Cailan in a supposedly final battle against " +
                        "the Darkspawn. You also need to undergo The Joining, a ceremony in which you are " +
                        "initiated into the Grey Wardens.")
                .build();
    }
}
