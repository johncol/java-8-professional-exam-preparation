package java8professional.chapter01.oca;

import static java.util.Collections.sort;

import java.util.List;
import java.util.ArrayList;

public class Imports {

    public List<String> copyAndSort(List<String> original) {
        List<String> list = new ArrayList<String>(original);
        sort(list);
        return list;
    }

}
