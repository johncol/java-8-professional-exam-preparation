package java8professional.chapter03.generics.wildcards.upperbounded;

import java.util.ArrayList;
import java.util.List;

public class Interfaces {

    public static void main(String[] args) {
        List<Flayer> flayers = new ArrayList<>();
        anyFlayer(flayers);
        onlyFlayer(flayers);

        List<Goose> gooses = new ArrayList<>();
        anyFlayer(gooses);
        // onlyFlayer(gooses); // doesn't compile
    }


    static void anyFlayer(List<? extends Flayer> fliers) {}
    static void onlyFlayer(List<Flayer> flayers) {}

}

interface Flayer {}
class HangGlider implements Flayer {}
class Goose implements Flayer {}
