package java8professional.chapter02.designpatterns.sigleton.staticinitialization;

public class StaffRegister {

    private StaffRegister() {}

    private static final StaffRegister instance;

    static {
        instance = new StaffRegister();
    }

    public static StaffRegister getInstance() {
        return instance;
    }

}
