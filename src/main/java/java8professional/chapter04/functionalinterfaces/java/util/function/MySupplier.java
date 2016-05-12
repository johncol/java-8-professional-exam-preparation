package java8professional.chapter04.functionalinterfaces.java.util.function;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@FunctionalInterface
public interface MySupplier<T> {
    T get();
}

class TestSupplier {

    public static void main(String[] args) {
        Supplier<LocalDate> now1 = LocalDate::now;
        Supplier<LocalDate> now2 = () -> LocalDate.now();

        System.out.println(now1);
        System.out.println(now2);
        System.out.println(now1.get());
        System.out.println(now2.get());

        Supplier<? extends List> newList1 = (ArrayList::new);
        Supplier<? extends List> newList2 = () -> new ArrayList();

        System.out.println(newList1);
        System.out.println(newList2);
        System.out.println(newList1.get());
        System.out.println(newList2.get());
    }

}