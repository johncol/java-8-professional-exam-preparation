package java8professional.chapter01;

public class HashCode {

    int id;
    String name;
    boolean ready;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof HashCode)) {
            return false;
        }
        HashCode other = (HashCode) obj;
        return id == other.id && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return 5 * id + 7 * name.hashCode();
    }
}
