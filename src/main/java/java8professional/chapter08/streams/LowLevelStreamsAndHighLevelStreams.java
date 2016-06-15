package java8professional.chapter08.streams;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class LowLevelStreamsAndHighLevelStreams {

    public static final String FILE_NAME = "object-test.txt";

    public void writeToFile() throws IOException {
        try (OutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
             OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
             ObjectOutputStream outputStream = new ObjectOutputStream(bufferedOutputStream)
        ) {
            outputStream.writeObject(DummyObject.createSample());
        }
    }

    public void readFromFile() throws IOException, ClassNotFoundException {
        try (InputStream fileInputStream = new FileInputStream(FILE_NAME);
             InputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             ObjectInputStream inputStream = new ObjectInputStream(bufferedInputStream)
        ) {
            DummyObject dummyObject = (DummyObject) inputStream.readObject();
            System.out.println(dummyObject);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LowLevelStreamsAndHighLevelStreams test = new LowLevelStreamsAndHighLevelStreams();
        test.readFromFile();
    }
}

class DummyObject implements Serializable {

    private static final long serialVersionUID = -6219387405922122202L;

    private int id;
    private String name;
    private List<String> properties;

    public static DummyObject createSample() {
        DummyObject object = new DummyObject();
        object.id = 101052;
        object.name = "Resource";
        object.properties = Arrays.asList("deprecated", "useless");
        return object;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}