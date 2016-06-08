package java8professional.chapter06.assertions;

public class AssertionFlowInvariantExample {

    public static void main(String[] args) {
        testSeason(Season.WINTER);
    }

    static void testSeason(Season season) {
        switch (season) {
            case SUMMER:
                System.out.println("Nice it's summer!");
                break;
            case SPRINT:
                System.out.println("Very cool!!! It's sprint");
                break;
            case FALL:
                System.out.println("It's fall...");
                break;
            default:
                assert false: "What is this..? (" + season + ")";
        }
    }

}

enum Season {
    SUMMER, SPRINT, FALL, WINTER
}
