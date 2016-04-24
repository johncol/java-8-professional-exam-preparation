package java8professional.chapter02.designpatterns.sigleton.staticinitialization;

public class HayStorage {

    private int quantity;

    private HayStorage() {}

    private static final HayStorage instance = new HayStorage();

    public static HayStorage getInstance() {
        return instance;
    }

    public synchronized void addHay(int amount) {
        if (amount > 0) {
            quantity += amount;
        }
    }

    public synchronized boolean removeHay(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
            return true;
        }
        return false;
    }

    public synchronized int getHayQuantity() {
        return quantity;
    }

}
