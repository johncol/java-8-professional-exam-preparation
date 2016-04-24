package java8professional.chapter02.designpatterns.sigleton.lazyinitialization.costly;

public class VisitorTicketTracker {

    private VisitorTicketTracker() {}

    private static VisitorTicketTracker instance;

    public static synchronized VisitorTicketTracker getInstance() {
        if (instance == null) {
            instance = new VisitorTicketTracker();
        }
        return instance;
    }

}
