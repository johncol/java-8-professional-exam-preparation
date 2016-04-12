package java8professional.outofscope;

import static java8professional.util.Utils.*;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class ApacheEqualsBuilder {

    public static void main(String[] args) {
        SomeA a1 = new SomeA();
        SomeA a2 = new SomeA();
        print(a1.equals(a2));
        a2.valid = true;
        print(a1.equals(a2));
        separator();

        SomeB b1 = new SomeB();
        SomeB b2 = new SomeB();
        print(b1.equals(b2));
        b2.valid = true;
        print(b1.equals(b2));
        b2.id = 10;
        print(b1.equals(b2));
        separator();
    }

}

class SomeA {
    int id;
    String name;
    boolean valid;
    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
}

class SomeB {
    int id;
    String name = "true";
    boolean valid;
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SomeB)) {
            return false;
        }
        SomeB other = (SomeB) obj;
        return new EqualsBuilder().appendSuper(super.equals(obj))
                .append(id, other.id)
                .append(name, other.name)
                .isEquals();
    }
}
