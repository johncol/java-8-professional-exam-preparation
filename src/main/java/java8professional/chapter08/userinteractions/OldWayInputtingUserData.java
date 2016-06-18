package java8professional.chapter08.userinteractions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OldWayInputtingUserData {

    static final String EXIT_KEYWORD = "exit";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 1024);
        System.out.println("End app writing '" + EXIT_KEYWORD + "'");
        System.out.print("Now, write: ");
        String input;
        while(!(input = in.readLine()).equalsIgnoreCase(EXIT_KEYWORD)) {
            System.out.println(String.format("Your input: '%s'", input));
            System.out.print("And again: ");
        }
    }

}
