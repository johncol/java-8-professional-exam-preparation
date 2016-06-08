package java8professional.chapter07.executors;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TimeUnits {
    public static void main(String[] args) {
        Arrays.stream(TimeUnit.values()).forEach(System.out::println);
    }
}
