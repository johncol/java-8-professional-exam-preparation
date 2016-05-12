package java8professional.chapter04.functionalinterfaces;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaces {

    <T> void supplier(Supplier<T> supplier) {
        T t = supplier.get();
    }

    <T> void consumer(Consumer<T> consumer, T t) {
        consumer.accept(t);
    }

    <T, U> void biConsumer(BiConsumer<T, U> biConsumer, T t, U u) {
        biConsumer.accept(t, u);
    }

    <T> void predicate(Predicate<T> predicate, T t) {
        boolean test = predicate.test(t);
    }

    <T, U> void biPredicate(BiPredicate<T, U> biPredicate, T t, U u) {
        boolean test = biPredicate.test(t, u);
    }

    <T, R> void function(Function<T, R> function, T t) {
        R r = function.apply(t);
    }

    <T, U, R> void biFunction(BiFunction<T, U , R> biFunction, T t, U u) {
        R r = biFunction.apply(t, u);
    }

    <T> void unaryOperator(UnaryOperator<T> unaryOperator, T t) {
        T t2 = unaryOperator.apply(t);
    }

    <T> void binaryOperator(BinaryOperator<T> binaryOperator, T t1, T t2) {
        T t3 = binaryOperator.apply(t1, t2);
    }

}
