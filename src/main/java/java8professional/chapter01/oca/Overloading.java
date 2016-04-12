package java8professional.chapter01.oca;

interface IA {}
interface IB {}
class ClassAB implements IA, IB {}

public class Overloading {

    void some(ClassAB classAB) { System.out.println("ClassAB"); }
    void some(IA ia) { System.out.println("IA"); }
    void some(IB ib) { System.out.println("IB"); }

    public static void main(String[] args) {
        Overloading test = new Overloading();

        ClassAB classAB = new ClassAB();
        test.some(classAB);

        IA ia = new ClassAB();
        test.some(ia);

        IB ib = new ClassAB();
        test.some(ib);
    }

}
