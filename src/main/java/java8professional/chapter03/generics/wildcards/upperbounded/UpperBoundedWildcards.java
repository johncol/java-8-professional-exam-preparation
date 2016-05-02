package java8professional.chapter03.generics.wildcards.upperbounded;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpperBoundedWildcards {

    public static void main(String[] args) {

        // doesn't compile
        // List<Number> nums = new ArrayList<Integer>();

        List<? extends Number> nums = new ArrayList<Integer>();

        // doesn't compile, it becomes immutable
        // nums.add(new Integer(4));

        List<Integer> integers = Arrays.asList(1, 2, 3);
        sumNums(integers);

        List<Float> floats = Arrays.asList(10F, 2F, 3F);
        sumNums(floats);

    }

    static void sumNums(List<? extends Number> nums) {
        Result r = new Result();
        nums.stream().forEach(n -> r.add(n) );
        System.out.println(r.value);
    }

}

class Result {
    double value;
    void add(Number value) {
        this.value += value.doubleValue();
    }
}