import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;

/**
 * Created by paulbaker on 2/17/17.
 */
public class StatsContainer extends AbstractPageObject<StatsContainer> {

    @FindBy(id = "btnStats")
    private SelenideElement statsButton;

    @FindBy(xpath = "//*[@id=\"stats\"]/div[1]")
    private SelenideElement closeButton;

    @FindBy(id = "btnSave")
    private SelenideElement saveButton;

    @FindBy(id = "btnImport")
    private SelenideElement importButton;

    @FindBy(id = "btnExport")
    private SelenideElement exportButton;

    @FindBy(xpath = "//*[@id=\"export\"]/form/textarea")
    private SelenideElement dataTextArea;

    public StatsContainer() {
        statsButton.click();
    }

    public StatsContainer saveGame() {
        saveButton.click();
        return this;
    }

    public StatsContainer importGame(String data) {

//        String[] jsArray = new String[]{
//                "var obj = JSON.parse(Base64.decode(arguments[0]));",
//                "for(index in obj) {",
//                "  localStorage[index] = obj[index];",
//                "};",
//                "loadGame();",
//                "location.reload(true);"
//        };
//
//        String jsString = Arrays.stream(jsArray).reduce((a, b) -> a + b).get();
//
//        executeJavaScript(jsString, data);
//        refresh();

        importButton.click();
        Alert alert = switchTo().alert();
        alert.sendKeys(data);
        alert.accept();
        sleep(2 * 1000);
        switchTo().defaultContent();
        return this;
    }

    public String exportGame() {
        exportButton.click();
        return dataTextArea.getValue();
    }

    @Override
    public void close() {
        if (closeButton.isDisplayed())
            closeButton.waitUntil(Condition.enabled, 2 * 1000).click();
    }
}
