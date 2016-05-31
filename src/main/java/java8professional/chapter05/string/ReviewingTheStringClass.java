package java8professional.chapter05.string;

public class ReviewingTheStringClass {

    public static void main(String[] args) {
        String s1 = "bunny";
        String s2 = "bunny";
        String s3 = new String("bunny");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
        System.out.println();

        System.out.println(1 + 2 + "3");
        System.out.println("1" + 2 + 3);
        System.out.println();

        String abc = "snow ";
        System.out.println(abc.trim().length());
        System.out.println(abc.charAt(2));
        System.out.println(abc.indexOf('b'));
        System.out.println(abc.indexOf(98));
        System.out.println(abc.indexOf("de"));
        System.out.println(abc.indexOf("def"));
        System.out.println();

        StringBuilder b = new StringBuilder();
        b.append(1234).append("-").append(false);
        System.out.println(b);
        System.out.println(b.length());
        System.out.println(b.indexOf("-"));
        System.out.println(b.charAt(2));

        StringBuilder b2 = b.reverse();
        System.out.println(b);
        System.out.println(b == b2);
        System.out.println(new StringBuilder("a").equals(new StringBuilder("a")));
        b.insert(1, "SNOW").delete(5, 6);
        System.out.println(b);
    }
}
