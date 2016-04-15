package java8professional.chapter01.innerclasses.staticinnerclasses.package1;

// 1:
// import java8professional.chapter01.innerclasses.staticinnerclasses.package2.OuterClass;

// 2:
// import java8professional.chapter01.innerclasses.staticinnerclasses.package2.OuterClass.InnerStaticClass;

// 3:
// import static java8professional.chapter01.innerclasses.staticinnerclasses.package2.OuterClass.InnerStaticClass;

// 4:
import static java8professional.chapter01.innerclasses.staticinnerclasses.package2.OuterClass.*;

public class ImportingClass {

    public static void main(String[] args) {

        // 1:
        // new OuterClass.InnerStaticClass().hello();

        // 2 ,3 y 4:
        new InnerStaticClass().hello();
    }

}
