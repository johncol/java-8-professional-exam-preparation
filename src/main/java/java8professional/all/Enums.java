package java8professional.all;

public class Enums {
}

enum Season {

    SUMMER("SUMMER TIME!"),
    WINTER("WINTER IS COMING") {
        @Override
        public void doSome() {
            //System.out.println(this.legend);
        }
    },
    ;

    private final String legend;

    private Season(String legend) {
        this.legend = legend;
    }

    public void doSome() {
    };

 }