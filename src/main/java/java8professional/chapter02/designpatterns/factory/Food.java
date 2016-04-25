package java8professional.chapter02.designpatterns.factory;

abstract class Food {

    private int quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract void describe();
}

class Hay extends Food {

    public Hay(int quantity) {
        super(quantity);
    }

    @Override
    public void describe() {
        System.out.println("Hay quantity: " + getQuantity());
    }
}

class Pellets extends Food {

    public Pellets(int quantity) {
        super(quantity);
    }

    @Override
    public void describe() {
        System.out.println("Pellets quantity: " + getQuantity());
    }
}

class Fish extends Food {

    public Fish(int quantity) {
        super(quantity);
    }

    @Override
    public void describe() {
        System.out.println("Fish quantity: " + getQuantity());
    }
}

enum Animal { ZEBRA, RABBIT, GOAT, POLAR_BEAR }

class FoodFactory {

    private FoodFactory() {}

    public static Food getFood(Animal animal) {
        switch (animal) {
            case ZEBRA:
                return new Hay(500);
            case RABBIT:
                return new Pellets(5);
            case GOAT:
                return new Pellets(30);
            case POLAR_BEAR:
                return new Fish(10);
        }
        throw new UnsupportedOperationException("Animal not supported: " + animal);
    }

}

class ZooKeeper {

    public static void main(String[] args) {
        Food food = FoodFactory.getFood(Animal.POLAR_BEAR);
        food.describe();
        food = FoodFactory.getFood(Animal.GOAT);
        food.describe();
        food = FoodFactory.getFood(Animal.ZEBRA);
        food.describe();
    }
}
