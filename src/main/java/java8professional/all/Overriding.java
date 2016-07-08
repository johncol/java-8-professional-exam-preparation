package java8professional.all;

public class Overriding {
}

class ParentExample {
    void hi() {
        System.out.println("hi");
    }
}

abstract class ChildExample extends ParentExample {
    @Override
    abstract void hi();
}

interface Interface {

    /**
     * won't work:
    @Override
    public default String toString() {
        return "";
    }
     */

}