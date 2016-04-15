package java8professional.chapter01.innerclasses.memberinnerclasses;

import static java8professional.util.Utils.*;

public class SeveralInnerClasses {

    public static void main(String[] args) {
        ClassA classA = new ClassA();
        ClassA.ClassB classB = classA.new ClassB();
        ClassA.ClassB.ClassC classC = classB.new ClassC();
        classC.printNames();
    }
}

class ClassA {

    private String name = "Class A";

    protected class ClassB {

        private String name = "Class B";

        class ClassC {

            private String name = "Class C";

            public void printNames() {
                print(name);
                print(this.name);
                print(ClassC.this.name);
                print(ClassB.this.name);
                print(ClassA.this.name);
            }

        }

    }

}