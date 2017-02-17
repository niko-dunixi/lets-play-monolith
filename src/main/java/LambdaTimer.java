import java.util.function.Supplier;

/**
 * Created by paulbaker on 2/17/17.
 */
public class LambdaTimer {

    private final Runnable action;

    Supplier<Long> expirationDateSupplier;

    private long expireDate;

    public LambdaTimer(long intervalInMillis, Runnable action) {
        this.action = action;
        expirationDateSupplier = () -> System.currentTimeMillis() + intervalInMillis;
        expireDate = expirationDateSupplier.get();
    }


    public void runIfExpired() {
        if (System.currentTimeMillis() >= expireDate) {
            expireDate = expirationDateSupplier.get();
            action.run();
        }
    }
}
