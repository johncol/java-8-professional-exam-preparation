package java8professional.chapter02.designpatterns.builder;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class City {

    private final String name;
    private final String location;
    private final String country;
    private final String continent;
    private final String language;
    private final String currency;
    private final List<String> religions;

    private City(String name, String location, String country, String continent, String language, String currency,
            List<String> religions) {
        this.name = name;
        this.location = location;
        this.country = country;
        this.continent = continent;
        this.language = language;
        this.currency = currency;
        this.religions = religions != null ? new ArrayList<>(religions) : new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getCountry() {
        return country;
    }

    public String getContinent() {
        return continent;
    }

    public String getLanguage() {
        return language;
    }

    public String getCurrency() {
        return currency;
    }

    public List<String> getReligions() {
        return Collections.unmodifiableList(religions);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public static class CityBuilder {

        private String name;
        private String location;
        private String country;
        private String continent;
        private String language;
        private String currency;
        private List<String> religions;

        private CityBuilder() {}

        public static CityBuilder aCity() {
            return new CityBuilder();
        }

        public CityBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CityBuilder withLocation(String location) {
            this.location = location;
            return this;
        }

        public CityBuilder withCountry(String country) {
            this.country = country;
            return this;
        }

        public CityBuilder withContinent(String continent) {
            this.continent = continent;
            return this;
        }

        public CityBuilder withLanguage(String language) {
            this.language = language;
            return this;
        }

        public CityBuilder withCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public CityBuilder withReligions(List<String> religions) {
            this.religions = religions;
            return this;
        }

        public City build() {
            return new City(name, location, country, continent, language, currency, religions);
        }
    }

}


class SomeClientClass {

    public static void main(String[] args) {
        City city = City.CityBuilder.aCity()
                .withName("Bogota")
                .withCountry("Colombia")
                .withContinent("America")
                .withCurrency("COP")
                .withLanguage("Spanish")
                .build();
        System.out.println(city);
    }

}
