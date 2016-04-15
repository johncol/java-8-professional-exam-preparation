package java8professional.chapter01;

import static java8professional.util.Utils.*;

import java.util.Arrays;

public class Enums {

    public static void main(String[] args) {
        Arrays.stream(Day.values()).forEach(System.out::println);
        separator(1);

        try {
            print(Day.valueOf("MONDAY"));
            // not ok:
            print(Day.valueOf("monday"));
        } catch (IllegalArgumentException e) {
            print("Error getting day enum from 'monday' string");
        }
        separator(2);

        Day second = Day.TUESDAY;
        print(second);
        print(second == Day.TUESDAY);
        print(second.equals(Day.TUESDAY));
        separator(3);

        for (Day day: Day.values()) {
            print(day.ordinal() + ": " + day.name());
        }
        separator(4);

        Day any = Day.SUNDAY;
        switch (any) {
            case MONDAY:
                print("Ohh.. I'm sleepy, it is monday");
                break;
            case FRIDAY:
                print("Ohh.. finally! I'm so tired, it is friday");
                break;
            // case Day.SATURDAY: // does not compile
            default:
                print("Wololoo...");
        }
        separator(5);

        Season.WINTER.printExpectedVisitors();
        Season.SPRINT.printExpectedVisitors();
        Season.SUMMER.printExpectedVisitors();
        Season.FALL.printExpectedVisitors();
        separator(6);

        OtherSeason.WINTER.printExpectedVisitors();
        OtherSeason.SPRINT.printExpectedVisitors();
        OtherSeason.SUMMER.printExpectedVisitors();
        OtherSeason.FALL.printExpectedVisitors();
        separator(7);

        AnotherSeason.WINTER.printExpectedVisitors();
        AnotherSeason.SPRINT.printExpectedVisitors();
        AnotherSeason.SUMMER.printExpectedVisitors();
        AnotherSeason.FALL.printExpectedVisitors();
        separator(8);
    }

}

// doesn't compile:
//enum FunnyDays extends Day {}

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    // semicolon after values only required if there is nothing more besides values
}

enum Season {

    WINTER("Low"),
    SPRINT("Medium"),
    SUMMER("High"),
    FALL("Medium");

    private String expectedVisitors;

    Season() {
        // I can several constructors in an ENUM, but all of the MUST be private
        // (keyword inserted by default by the compiler if not done explicitly)
    }

    private Season(String expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }

    void printExpectedVisitors() {
        print("Expected visitors for " + name() + " is: " + expectedVisitors);
    }

}

enum OtherSeason {

    WINTER("Low") {
        void printExpectedVisitors() {
            print("Low visitors");
        }
    },
    SPRINT("Medium") {
        void printExpectedVisitors() {
            print("Some visitors");
        }
    },
    SUMMER("High") {
        void printExpectedVisitors() {
            print("A lot of visitors");
        }
    },
    FALL("Medium") {
        void printExpectedVisitors() {
            print("More or less visitors");
        }
    };

    private String expectedVisitors;

    OtherSeason(String expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }

    abstract void printExpectedVisitors();

}

enum AnotherSeason {

    WINTER {
        void printExpectedVisitors() {
            print("Low visitors");
        }
    },
    SPRINT {
        void printExpectedVisitors() {
            print("Some visitors");
        }
    },
    SUMMER,
    FALL;

    void printExpectedVisitors() {
        print("Default amount of visitors");
    }

}