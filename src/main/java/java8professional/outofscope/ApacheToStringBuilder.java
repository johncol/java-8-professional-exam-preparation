package java8professional.outofscope;

import static java8professional.util.Utils.*;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ApacheToStringBuilder {

    public static void main(String[] args) {
        print(new ToStringStyleDEFAULT_STYLE());
        separator();
        print(new ToStringStyleSHORT_PREFIX_STYLE());
        separator();
        print(new ToStringStyleSIMPLE_STYLE());
        separator();
        print(new ToStringStyleNO_CLASS_NAME_STYLE());
        separator();
        print(new ToStringStyleNO_FIELD_NAMES_STYLE());
        separator();
        print(new ToStringStyleJSON_STYLE());
        separator();
        print(new ToStringStyleMULTI_LINE_STYLE());
    }

}

class ToStringStyleDEFAULT_STYLE {
    int integer;
    boolean bool;
    String name;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}

class ToStringStyleSHORT_PREFIX_STYLE {
    int integer;
    boolean bool;
    String name;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

class ToStringStyleSIMPLE_STYLE {
    int integer;
    boolean bool;
    String name;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}

class ToStringStyleNO_CLASS_NAME_STYLE {
    int integer;
    boolean bool;
    String name;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
    }
}

class ToStringStyleNO_FIELD_NAMES_STYLE {
    int integer;
    boolean bool;
    String name;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_FIELD_NAMES_STYLE);
    }
}

class ToStringStyleJSON_STYLE {
    int integer;
    boolean bool;
    String name;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

class ToStringStyleMULTI_LINE_STYLE {
    int integer;
    boolean bool;
    String name;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}

