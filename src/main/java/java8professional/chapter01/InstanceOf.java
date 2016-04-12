package java8professional.chapter01;

import static java8professional.util.Utils.*;

public class InstanceOf {

    public static void main(String[] args) {
        HeavyAnimal hippo1 = new Hippo();
        print(hippo1 instanceof HeavyAnimal);
        print(hippo1 instanceof Hippo);
        print(hippo1 instanceof Elephant);
        separator();

        Hippo hippo2 = new Hippo();
        print(hippo2 instanceof HeavyAnimal);
        print(hippo2 instanceof Hippo);
        // print(hippo2 instanceof Elephant); // incompatible types, doesn't compile
        separator();

        HeavyAnimal hippo3 = null;
        print(hippo3 instanceof HeavyAnimal);
        print(hippo3 instanceof Hippo);
        print(hippo3 instanceof Elephant);
        separator();
    }

}

class HeavyAnimal {}
class Hippo extends HeavyAnimal {}
class Elephant extends HeavyAnimal {}
