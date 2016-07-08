package java8professional.tests;

public class PSLAlgorithm {

    static Node create(String... values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("At least one node is needed");
        }
        Node first = new Node(values[0]);
        Node node = first;
        for (int i = 1; i < values.length; i++) {
            node.next = new Node(values[i]);
            node = node.next;
        }
        return first;
    }

    static void print(Node node) {
        do {
            System.out.print(node + " -> ");
        } while ((node = node.next) != null);
        System.out.println("null");
    }

    static Node reverse(Node node) {
        Node prev = null;
        Node next;
        while ((next = node.next) != null) {
            node.next = prev;
            prev = node;
            node = next;
        }
        node.next = prev;
        return node;
    }

    public static void main(String[] args) {
        Node node = create("a", "b", "c", "d");
        print(node);
        node = reverse(node);
        print(node);
    }

}

class Node {

    Node next;
    String value;

    public Node(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}