import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by paulbaker on 2/17/17.
 */
public class MonolithPage extends AbstractPageObject<MonolithPage> {

    public static final File DEFAULT_SAVEFILE = new File("monolith.save");

    @FindBy(id = "beastButton")
    @CacheLookup
    private SelenideElement button;

    @FindBy(id = "btnStats")
    private SelenideElement statsButton;

    private final File savefile;

    public MonolithPage() {
        this(DEFAULT_SAVEFILE);
    }

    public MonolithPage(File savefile) {
        this.savefile = savefile;
        open("http://monolith.greenpixel.ca/");
    }

    public StatsContainer getStatsContainer() {
        return new StatsContainer();
    }

    public MonolithPage getStatsContainer(Consumer<StatsContainer> stats) {
        try (StatsContainer container = getStatsContainer()) {
            stats.accept(container);
        }
        return this;
    }

    public void attack() {
        button.click();
    }

    @Override
    public void close() {
        getStatsContainer(stats -> {
            String data = stats.saveGame().exportGame();
            try (OutputStream outputStream = new FileOutputStream(savefile)) {
                Properties properties = new Properties();
                properties.setProperty("data", data);
                properties.store(outputStream, null);
            } catch (IOException ignored) {
                System.err.println(String.format("COULDN'T SAVE: %s", data));
            }
        });
        Selenide.close();
    }
}
