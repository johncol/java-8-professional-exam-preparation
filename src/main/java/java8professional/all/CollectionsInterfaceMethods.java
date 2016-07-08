package java8professional.all;

import java.util.*;
import java.lang.Comparable;
import java.util.Comparator;

public class CollectionsInterfaceMethods {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add(null);
        set.add("b");
        set.add("a");
        set.add(null);
        System.out.println(set);
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put(null, "b");
        map.put("c", null);
        System.out.println(map);
    }
}

class CollectionInterfaceMethods {
    void method(Collection<String> collection) {
        boolean add = collection.add("");
        boolean remove = collection.remove("");
        boolean empty = collection.isEmpty();
        int size = collection.size();
        collection.clear();
        boolean contains = collection.contains("");
    }
}

class ListInterfaceMethods {
    void method(List<String> list) {
        int index = 10;
        list.add(index, "");
        String set = list.set(index, "");
        String get = list.get(index);
        String remove = list.remove(index);
        int indexOf = list.indexOf("");
        int lastIndexOf = list.lastIndexOf("");
    }
}

class NavigableSetInterfaceMethods {
    void method(NavigableSet<String> navigableSet) {
        String lower = navigableSet.lower("");
        String floor = navigableSet.floor("");
        String ceiling = navigableSet.ceiling("");
        String higher = navigableSet.higher("");
    }
}

class QueueInterfaceMethods {
    void method(Queue<String> queue) {
        // see the element in the front of the queue
        String element = queue.element();   // NoSuchElementException
        String peek = queue.peek();

        // process the element in the front of the queue
        String remove = queue.remove();     // NoSuchElementException
        String poll = queue.poll();

        // add an element to the end of the queue
        boolean add = queue.add("");        // IllegalStateException
        boolean offer = queue.offer("");
    }
}

class ArrayDequeMethods {
    void method(ArrayDeque<String> arrayDeque) {
        // see the element in the top of the stack
        String element = arrayDeque.element();   // NoSuchElementException
        String peek = arrayDeque.peek();

        // process the element in the top of the stack
        String remove = arrayDeque.remove();     // NoSuchElementException
        String pop = arrayDeque.pop();

        // add an element to the top of the stack
        arrayDeque.push("");
    }
}

class MapInterfaceMethods {
    void method(Map<String, String> map) {
        String put = map.put("", "");
        String get = map.get("");
        String remove = map.remove("");
        boolean empty = map.isEmpty();
        int size = map.size();
        boolean containsKey = map.containsKey("");
        boolean containsValue = map.containsValue("");
        map.clear();
        Set<String> keySet = map.keySet();
        Collection<String> values = map.values();
    }
}