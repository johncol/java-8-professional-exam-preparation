package java8professional.tests;

import java.util.ArrayList;
import java.util.List;

public class LegacyCollection {

    public static void main(String[] args) {

        List nums = new ArrayList();
        nums.add(45);

        Integer o = (Integer) nums.get(0);
        System.out.println(o);

    }

}
