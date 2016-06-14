package java8professional.chapter07.chaptertest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class PrintCounter {
    static int counter = 0;

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        List<Future<?>> results = new ArrayList<>();
        IntStream.iterate(0, i -> i + 1).limit(5).forEach(
                i -> {
                    // ExecutorService.execute returns void, not Future<T>
                    //results.add(service.execute(() -> counter++))
                }
        );
    }
}
