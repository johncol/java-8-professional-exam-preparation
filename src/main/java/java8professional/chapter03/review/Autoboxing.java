package java8professional.chapter03.review;

public class Autoboxing {

    public static void main(String[] args) {
        System.out.println(new Boolean("true"));
        System.out.println(new Boolean(null));
        System.out.println(new Byte("4"));
        System.out.println(new Short("4"));
        System.out.println(new Integer("4"));
        System.out.println(new Long("4"));
        System.out.println(new Float("4"));
        System.out.println(new Double("4"));
        System.out.println(new Character('c'));

        try {
            Integer a = null;
            System.out.println(a * 3);
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
