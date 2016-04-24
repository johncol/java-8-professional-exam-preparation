package java8professional.chapter02.designpatterns.sigleton.lazyinitialization.doublecheck;

public class VisitorTicketTracker {

    private VisitorTicketTracker() {}

    private static volatile VisitorTicketTracker instance;

    public static VisitorTicketTracker getInstance() {
        if (instance == null) {
            synchronized (VisitorTicketTracker.class) {
                if (instance == null) {
                    instance = new VisitorTicketTracker();
                }
            }
        }
        return instance;
    }

}
