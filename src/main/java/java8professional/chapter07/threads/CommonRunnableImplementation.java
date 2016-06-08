package java8professional.chapter07.threads;

public class CommonRunnableImplementation implements Runnable {

    private final SomeImportantData data;

    public CommonRunnableImplementation(SomeImportantData data) {
        this.data = data;
    }

    @Override
    public void run() {
        // use data here!
    }
}

class SomeImportantData {}
