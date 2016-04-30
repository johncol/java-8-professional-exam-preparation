package java8professional.chapter02.interfaces;

public class Interfaces {

}

interface Fly {

    int MAX_SPEED = 100;

    int getWingSpan() throws Exception;

    default void land() {
        System.out.println("Animal is landing");
    }

    static double calculateSpeed(float distance, double time) {
        return distance/time;
    }

}

class Eagle implements Fly {

    public int getWingSpan() {
        return 15;
    }

}

interface Ia { default void a() {} }
interface Ib { default void a() {} }
//interface Ic extends Ia, Ib {} // does not compile
