package java8professional.chapter01;

import static java8professional.util.Utils.*;

abstract class Animal {
    void careFor() {
        play();
    }
    void play() {
        print("pet animal");
    }
}

class Lion extends Animal {
    void play() {
        print("toss in meat");
    }
}

public class VirtualMethods {

    public static void main(String[] args) {
        Animal animal = new Lion();
        animal.careFor();
    }
}
