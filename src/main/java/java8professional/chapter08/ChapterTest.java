package java8professional.chapter08;

import java.io.*;

public class ChapterTest implements Serializable {
    public static void main(String[] args) {
        /**
         * 01-AD ✓
         * 02-BF ✗
         * 03-CD ✓
         ! 04-CD ✗
         ! 05-BD ✗
         * 06-AE ✓
         * 07-D ✓
         ! 08-A ✓
         * 09-A ✓
         ! 10-B ✗
         ! 11-CG ✗
         * 12-BC ✓
         * 13-ACE ✓
         * 14-E ✓
         * 15-A ✓
         * 16-DF ✓
         * 17-ABDG ✓
         * 18-ABCDE ✗
         * 19-BCD ✓
         * 20-ABC ✗
         * 21-ABCD ✗
         * 22-E ✓
         * 23-H ✓
         *
         * 15/23 -> 65.22%
         *
         */

        Console console = System.console();

        // Console.read() does not exist AND console.readPassword() return char[]
        String string = console.readLine();
        char[] arrayOfChars = console.readPassword();


        // PrintWriter.append() does not throw an IOException, but Writer.append() does
        PrintWriter printWriter = console.writer();
        printWriter.append('a');

        Writer writer = console.writer();
        try {
            writer.append('a');
        } catch (IOException e) {
            e.printStackTrace();
        }

        // File.renameTo() exists
        File file = new File("/whatever.txt");
        boolean b = file.renameTo(new File("/some-folder/whatever.txt"));

        file.mkdir();
        file.mkdirs();
        file.canExecute();
        file.canRead();
        file.canWrite();

        // Console.println() does not exist!!
        console.printf("");
        console.format("");
    }
}
