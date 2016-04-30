package java8professional.chapter03.generics;

public class SizeLimitedCrate<T, U> {

    private final T first;
    private final U second;

    public SizeLimitedCrate(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}
