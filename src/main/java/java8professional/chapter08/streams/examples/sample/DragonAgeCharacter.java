package java8professional.chapter08.streams.examples.sample;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

public class DragonAgeCharacter implements Serializable {

    private static final long serialVersionUID = 2831947045961027717L;

    private final String name;
    private final DragonAgeCharacterType type;
    private final String description;

    public DragonAgeCharacter(String name, DragonAgeCharacterType type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public static class Builder {

        private String name;
        private DragonAgeCharacterType type;
        private String description;

        public DragonAgeCharacter.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public DragonAgeCharacter.Builder withType(DragonAgeCharacterType type) {
            this.type = type;
            return this;
        }

        public DragonAgeCharacter.Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public DragonAgeCharacter build() {
            return new DragonAgeCharacter(name, type, description);
        }
    }

}
