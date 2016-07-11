package java8professional;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MockExam2 {}

abstract interface InterfacesCanBeMarkedAsAbstract {}

interface InterfaceStaticMethodsCannotBeFinal {
    //static final void some() {}
}

class AStreamCanOnlyBeUseOnce {
    public static void main(String[] args) {
        try {
            Stream<String> empty = Stream.empty();
            Map<Boolean, List<String>> p = empty.collect(Collectors.partitioningBy(s -> s.startsWith("n")));
            Map<Boolean, List<String>> g = empty.collect(Collectors.groupingBy(s -> s.startsWith("n")));
            System.out.println(p + " " + g);
        } catch (IllegalStateException e) {
            System.out.println("IllegalStateException -> " + e.getMessage());
        }
    }
}

class HorribleGenerics {
    public static void main(String[] args) {
        List<? extends Statement> list1 = new ArrayList<>();
        List<? extends Statement> list2 = new ArrayList();
    }
}

class StatementExecuteQueryReturnsAResultSet {
    void method(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("");
    }
}

class WriterDoesHaveAMethodCalledAppendWhichDoesNotPrintAnythingUntilFlushMethodIsCalled {
    void method() {
        Console console = System.console();
        Writer writer = console.writer();
        try {
            writer.append("");
        } catch (IOException e) {}
    }
}

class HorribleGenericsAndObject<A> {
    // TODO: if they were called the same way it would NOT compile because of the type erasure at compile time
    void methodXXX(Object o) { System.out.println("a"); }
    void method(A a) { System.out.println("a"); }
}

class ConsumerTest {
    // TODO: will not compile
    // Consumer<Integer> consumer = () -> true;
}

class ResourceBundleSearchLogic {
    /**
     *
     */
}

class TimeUnitConstants {
    {
        System.out.println(java.util.concurrent.TimeUnit.class);
        System.out.println(TimeUnit.NANOSECONDS);
        System.out.println(TimeUnit.MICROSECONDS);
        System.out.println(TimeUnit.MILLISECONDS);
        System.out.println(TimeUnit.SECONDS);
        System.out.println(TimeUnit.MINUTES);
        System.out.println(TimeUnit.HOURS);
        System.out.println(TimeUnit.DAYS);
    }
}

class ChronoUnitConstants {
    {
        System.out.println(java.time.temporal.ChronoUnit.class);
        System.out.println(ChronoUnit.NANOS);
        System.out.println(ChronoUnit.MICROS);
        System.out.println(ChronoUnit.MILLIS);
        System.out.println(ChronoUnit.SECONDS);
        System.out.println(ChronoUnit.MINUTES);
        System.out.println(ChronoUnit.HOURS);
        System.out.println(ChronoUnit.HALF_DAYS);
        System.out.println(ChronoUnit.DAYS);
        System.out.println(ChronoUnit.WEEKS);
        System.out.println(ChronoUnit.MONTHS);
        System.out.println(ChronoUnit.YEARS);
        System.out.println(ChronoUnit.DECADES);
        System.out.println(ChronoUnit.CENTURIES);
        System.out.println(ChronoUnit.MILLENNIA);
        System.out.println(ChronoUnit.FOREVER);
    }
}

class StaticModifierInInnerInterfaceIsAllowed {
    static interface Interface {}
}

class LocalInnerClassDefinedAnywhere {
    void method() {
        for (int i = 0; i < 10; i++) {
            if (i % 3 == 0) {
                class InnerClass {}
            }
        }
    }
}

class MyTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("").resolve("");
        Files.find(path, 1, (p, a) -> a.isDirectory())
                .map(p -> {
                    try {
                        return p.toRealPath(LinkOption.NOFOLLOW_LINKS).toString();
                    } catch (IOException e) {
                        return "";
                    }
                })
                .map((String p) -> p.toString())
                .forEach(System.out::println);
    }
}
