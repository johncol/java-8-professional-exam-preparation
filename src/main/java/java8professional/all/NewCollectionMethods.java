package java8professional.all;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class NewCollectionMethods {

    void collection(Collection<String> collection) {
        collection.removeIf(String::isEmpty);
        collection.forEach(System.out::println);
    }

    void list(List<String> list) {
        list.replaceAll(string -> "- " + string + " -");
    }

    void map(Map<String, String> map) {
        map.putIfAbsent("key", "value");
        BiFunction<String, String, String> mergeFunction = (valueInMap, newValue) -> valueInMap + "/" + newValue;
        map.merge("key", "new-value", mergeFunction);
        BiFunction<String, String, String> executeIfPresent = (key, value) -> key + "[" + value + "]";
        map.computeIfPresent("key", executeIfPresent);
        Function<String, String> executeIfAbsent = key -> key + "[some value]";
        map.computeIfAbsent("key", executeIfAbsent);
    }
}
