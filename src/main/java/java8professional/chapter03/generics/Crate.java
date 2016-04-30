package java8professional.chapter03.generics;

public class Crate<T> {

    private T content;

    void packageCrate(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public static void main(String[] args) {
        Crate<String> crate1 = new Crate<>();
        crate1.packageCrate("test");
        String content1 = crate1.getContent();
        System.out.println(content1);

        Crate<Integer> crate2 = new Crate<>();
        crate2.packageCrate(7);
        Integer content2 = crate2.getContent();
        System.out.println(content2);
    }

}
