package java8professional.chapter08.streams;

import java.io.*;

public class ByteStreamsAndCharacterStreams {

    // abstract ones
    InputStream inputStream;
    OutputStream outputStream;
    Reader reader;
    Writer writer;

    // low-level
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;
    FileReader fileReader;
    FileWriter fileWriter;

    // high-level
    BufferedInputStream bufferedInputStream;
    BufferedOutputStream bufferedOutputStream;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    // serialize and deserialize objects
    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;

    // read characters from an input stream
    InputStreamReader inputStreamReader;
    OutputStreamWriter outputStreamWriter;

    // write characters to an output stream
    PrintStream printStream;
    PrintWriter printWriter;

}
