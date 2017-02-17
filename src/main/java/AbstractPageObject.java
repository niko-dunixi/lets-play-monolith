import static com.codeborne.selenide.Selenide.page;

/**
 * Created by paulbaker on 2/17/17.
 */
public class AbstractPageObject<T extends AbstractPageObject<T>> implements AutoCloseable {

    protected AbstractPageObject() {
        page(this);
    }

    public void close() {
    }
}
