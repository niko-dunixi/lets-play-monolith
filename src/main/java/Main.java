import com.codeborne.selenide.Configuration;

/**
 * Created by paulbaker on 2/17/17.
 */
public class Main {

    public static void main(String[] args) {
        Configuration.browser = "chrome";

        try (MonolithPage monolithPage = new MonolithPage()) {
            for (int i = 0; i < 27; i++)
                monolithPage.attack();
        }
    }
}
