package java8professional.util;

public class Utils {

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void separator() {
        System.out.println("---------------------");
        System.out.println();
    }

    public static void separator(int position) {
        System.out.println("--------------------- " + position);
        System.out.println();
    }

}
