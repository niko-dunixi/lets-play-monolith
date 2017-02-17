import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by paulbaker on 2/17/17.
 */
public class MonolithPage extends AbstractPageObject<MonolithPage> {

    @FindBy(id = "beastButton")
    @CacheLookup
    private SelenideElement button;
    private File savefile;

    public MonolithPage() {
        this(new File("monolith.save"));
    }

    public MonolithPage(File savefile) {
        this.savefile = savefile;
        open("http://monolith.greenpixel.ca/");
        loadGame();
    }

    private void loadGame() {
        $("#btnStats").click();
        $("#btnImport").click();
//        Alert alert = WebDriverRunner.getWebDriver().switchTo().alert();
        Alert alert = switchTo().alert();
        alert.sendKeys(Keys.TAB.toString());
        alert.sendKeys(Keys.TAB.toString());
        alert.sendKeys("eyJEUFNNdWx0aXBsaWVyIjoiMy41MzAwMDAwMDAwMDAwMDAyIiwiRVBTIjoiMCIsIkVQUzIiOiI2ODEwIiwiRVBTTXVsdGlwbGllciI6IjUuMSIsImFjaGlldmUwMDFnb3QiOiIxIiwiYWNoaWV2ZTAwMmdvdCI6IjEiLCJhY2hpZXZlMDAzZ290IjoiMSIsImFjaGlldmUwMDRnb3QiOiIxIiwiYWNoaWV2ZTAwNWdvdCI6IjEiLCJhY2hpZXZlMDA2Z290IjoiMSIsImFjaGlldmUwMDdnb3QiOiIxIiwiYWNoaWV2ZTAwOGdvdCI6IjEiLCJhY2hpZXZlMDA5Z290IjoiMSIsImFjaGlldmUwMTBnb3QiOiIxIiwiYWNoaWV2ZTAxMWdvdCI6IjEiLCJhY2hpZXZlMDEyZ290IjoiMSIsImFjaGlldmUwMTNnb3QiOiIxIiwiYWNoaWV2ZTAxNGdvdCI6IjEiLCJhY2hpZXZlMDE1Z290IjoiMSIsImFjaGlldmUwMTZnb3QiOiIxIiwiYWNoaWV2ZTAxN2dvdCI6IjAiLCJhY2hpZXZlMDE4Z290IjoiMCIsImFjaGlldmUwMTlnb3QiOiIxIiwiYWNoaWV2ZTAyMGdvdCI6IjEiLCJhY2hpZXZlMDIxZ290IjoiMSIsImFjaGlldmUwMjJnb3QiOiIxIiwiYWNoaWV2ZTAyM2dvdCI6IjAiLCJhY2hpZXZlMDI0Z290IjoiMCIsImFjaGlldmUwMjVnb3QiOiIxIiwiYWNoaWV2ZTAyNmdvdCI6IjEiLCJhY2hpZXZlMDI3Z290IjoiMSIsImFjaGlldmUwMjhnb3QiOiIxIiwiYWNoaWV2ZTAyOWdvdCI6IjEiLCJhY2hpZXZlMDMwZ290IjoiMSIsImFjaGlldmUwMzFnb3QiOiIxIiwiYWNoaWV2ZTAzMmdvdCI6IjEiLCJhY2hpZXZlMDMzZ290IjoiMSIsImFjaGlldmUwMzRnb3QiOiIxIiwiYWNoaWV2ZTAzNWdvdCI6IjEiLCJhY2hpZXZlMDM2Z290IjoiMSIsImFjaGlldmUwMzdnb3QiOiIxIiwiYWNoaWV2ZTAzOGdvdCI6IjEiLCJhY2hpZXZlMDM5Z290IjoiMSIsImFjaGlldmUwNDBnb3QiOiIxIiwiYWNoaWV2ZTA0MWdvdCI6IjEiLCJhY2hpZXZlMDQyZ290IjoiMCIsImFjaGlldmUwNDNnb3QiOiIxIiwiYWNoaWV2ZTA0NGdvdCI6IjEiLCJhY2hpZXZlMDQ1Z290IjoiMSIsImFjaGlldmUwNDZnb3QiOiIxIiwiYWNoaWV2ZTA0N2dvdCI6IjEiLCJhY2hpZXZlMDQ4Z290IjoiMCIsImFjaGlldmUwNDlnb3QiOiIxIiwiYWNoaWV2ZTA1MGdvdCI6IjEiLCJhY2hpZXZlMDUxZ290IjoiMSIsImFjaGlldmUwNTJnb3QiOiIxIiwiYWNoaWV2ZTA1M2dvdCI6IjAiLCJhY2hpZXZlMDU0Z290IjoiMCIsImFjaGlldmUwNTVnb3QiOiIxIiwiYWNoaWV2ZTA1NmdvdCI6IjEiLCJhY2hpZXZlMDU3Z290IjoiMSIsImFjaGlldmUwNThnb3QiOiIwIiwiYWNoaWV2ZTA1OWdvdCI6IjAiLCJhY2hpZXZlMDYwZ290IjoiMCIsImFjaGlldmUwNjFnb3QiOiIxIiwiYWNoaWV2ZTA2MmdvdCI6IjEiLCJhY2hpZXZlMDYzZ290IjoiMCIsImFjaGlldmUwNjRnb3QiOiIwIiwiYWNoaWV2ZTA2NWdvdCI6IjAiLCJhY2hpZXZlMDY2Z290IjoiMCIsImFjaGlldmUwNjdnb3QiOiIxIiwiYWNoaWV2ZTA2OGdvdCI6IjEiLCJhY2hpZXZlMDY5Z290IjoiMSIsImFjaGlldmUwNzBnb3QiOiIxIiwiYWNoaWV2ZTA3MWdvdCI6IjEiLCJhY2hpZXZlMDcyZ290IjoiMCIsImFjaGlldmUwNzNnb3QiOiIwIiwiYWNoaWV2ZTA3NGdvdCI6IjAiLCJhY2hpZXZlMDc1Z290IjoiMCIsImFjaGlldmUwNzZnb3QiOiIwIiwiYWlyY3JhZnRVbmxvY2tlZCI6IjEiLCJhcm15MDAxVW5sb2NrZWQiOiIxIiwiYXJteTAwMlVubG9ja2VkIjoiMSIsImFybXkwMDNVbmxvY2tlZCI6IjEiLCJhcm15MDA0VW5sb2NrZWQiOiIxIiwiYXJteTAwNVVubG9ja2VkIjoiMSIsImFybXkwMDZVbmxvY2tlZCI6IjAiLCJhcm15MDA3VW5sb2NrZWQiOiIwIiwiYXJteTAwOFVubG9ja2VkIjoiMCIsImFybXkwMDlVbmxvY2tlZCI6IjAiLCJhcm15MDEwVW5sb2NrZWQiOiIwIiwiYmFycmFja3NVbmxvY2tlZCI6IjEiLCJib3VnaHRBaXJjcmFmdF8wN19hIjoiMSIsImJvdWdodEJhcnJhY2tzXzAyX2EiOiIxIiwiYm91Z2h0QmFycmFja3NfMDJfYiI6IjEiLCJib3VnaHRCYXJyYWNrc18wM19hIjoiMSIsImJvdWdodEJhcnJhY2tzXzAzX2IiOiIxIiwiYm91Z2h0QmFycmFja3NfMDNfYyI6IjEiLCJib3VnaHRCYXJyYWNrc18wNF9hIjoiMSIsImJvdWdodEJhcnJhY2tzXzA0X2IiOiIxIiwiYm91Z2h0QmFycmFja3NfMDRfYyI6IjEiLCJib3VnaHRCYXJyYWNrc18wNF9kIjoiMSIsImJvdWdodEJhcnJhY2tzXzA1X2EiOiIxIiwiYm91Z2h0QmFycmFja3NfMDVfYiI6IjEiLCJib3VnaHRCYXJyYWNrc18wNV9jIjoiMSIsImJvdWdodEJhcnJhY2tzXzA1X2QiOiIxIiwiYm91Z2h0QmFycmFja3NfMDZfYSI6IjEiLCJib3VnaHRCYXJyYWNrc18wNl9iIjoiMSIsImJvdWdodEJhcnJhY2tzXzA3X2EiOiIxIiwiYm91Z2h0QmFycmFja3NfMDdfYiI6IjEiLCJib3VnaHRCYXJyYWNrc18wN19jIjoiMSIsImJvdWdodE1vbm9saXRoXzAxX2EiOiIxIiwiYm91Z2h0TW9ub2xpdGhfMDFfYiI6IjEiLCJib3VnaHRNb25vbGl0aF8wMV9jIjoiMSIsImJvdWdodE1vbm9saXRoXzAxX2QiOiIxIiwiYm91Z2h0TW9ub2xpdGhfMDJfYSI6IjEiLCJib3VnaHRNb25vbGl0aF8wMl9iIjoiMSIsImJvdWdodE1vbm9saXRoXzAyX2MiOiIxIiwiYm91Z2h0TW9ub2xpdGhfMDNfYSI6IjEiLCJib3VnaHRNb25vbGl0aF8wM19iIjoiMSIsImJvdWdodE1vbm9saXRoXzAzX2MiOiIxIiwiYm91Z2h0TW9ub2xpdGhfMDNfZCI6IjEiLCJib3VnaHRNb25vbGl0aF8wM19lIjoiMSIsImJvdWdodE1vbm9saXRoXzA0X2EiOiIxIiwiYm91Z2h0TW9ub2xpdGhfMDRfYiI6IjEiLCJib3VnaHRNb25vbGl0aF8wNF9jIjoiMSIsImJvdWdodE1vbm9saXRoXzA0X2QiOiIxIiwiYm91Z2h0TW9ub2xpdGhfMDVfYSI6IjEiLCJib3VnaHRNb25vbGl0aF8wNV9iIjoiMSIsImJvdWdodE1vbm9saXRoXzA1X2MiOiIxIiwiYm91Z2h0TW9ub2xpdGhfMDVfZCI6IjEiLCJib3VnaHRNb25vbGl0aF8wNV9lIjoiMSIsImJvdWdodE1vbm9saXRoXzA2X2EiOiIxIiwiYm91Z2h0TW9ub2xpdGhfMDZfYiI6IjEiLCJib3VnaHRNb25vbGl0aF8wNl9jIjoiMSIsImJvdWdodE1vbm9saXRoXzA2X2QiOiIxIiwiYm91Z2h0TW9ub2xpdGhfMDZfZSI6IjEiLCJib3VnaHRNb25vbGl0aF8wN19hIjoiMSIsImJvdWdodE1vbm9saXRoXzA3X2IiOiIxIiwiYm91Z2h0TW9ub2xpdGhfMDdfYyI6IjEiLCJib3VnaHRNb25vbGl0aF8wN19kIjoiMSIsImJvdWdodE1vbm9saXRoXzA3X2UiOiIwIiwiYm91Z2h0U2llZ2VfMDRfYSI6IjEiLCJib3VnaHRTaWVnZV8wNV9hIjoiMSIsImJvdWdodFNpZWdlXzA2X2EiOiIxIiwiYm91Z2h0U2llZ2VfMDZfYiI6IjEiLCJib3VnaHRTaWVnZV8wN19hIjoiMSIsImJvdWdodFNpZWdlXzA3X2IiOiIxIiwiYm91Z2h0U3dvcmRfMDFfYSI6IjEiLCJib3VnaHRTd29yZF8wMl9hIjoiMSIsImJvdWdodFN3b3JkXzAyX2IiOiIxIiwiYm91Z2h0U3dvcmRfMDNfYSI6IjEiLCJib3VnaHRTd29yZF8wM19iIjoiMSIsImJvdWdodFN3b3JkXzA0X2EiOiIxIiwiYm91Z2h0U3dvcmRfMDRfYiI6IjEiLCJib3VnaHRTd29yZF8wNV9hIjoiMSIsImJvdWdodFN3b3JkXzA1X2IiOiIxIiwiYm91Z2h0U3dvcmRfMDZfYSI6IjEiLCJib3VnaHRTd29yZF8wNl9iIjoiMSIsImJvdWdodFN3b3JkXzA3X2EiOiIxIiwiYm91Z2h0U3dvcmRfMDdfYiI6IjEiLCJjb2xsaWRlclVubG9ja2VkIjoiMCIsImNvc3RBaXJjcmFmdCI6IjE3MDExMjQ0OSIsImNvc3RDaGFvcyI6IjAiLCJjb3N0TWVsZWUiOiI0OTY5MDc4NDciLCJjb3N0TWlzc2lsZSI6IjAiLCJjb3N0TW91bnRlZCI6IjIwODAxNjc5MDc1IiwiY29zdFJhbmdlZCI6IjQxNDA4OTg3MjYiLCJjb3N0U2F0ZWxsaXRlIjoiMCIsImNvc3RTY2hvbGFyIjoiODI4MTc5NzQ1MiIsImNvc3RTaWVnZSI6IjM2MzQyNTk5NjgiLCJjb3N0U3BhY2VzaGlwIjoiMCIsImNvc3RXaWxsIjoiMCIsImN1cnJlbnRBZ2UiOiI3IiwiZGFtYWdlIjoiNzE0MDEyMzMyOTgyLjkxMSIsImRhbWFnZVRvRXZvIjoiNCIsImV2b1BvaW50cyI6IjQzOTI1NTcyMjIuMzg1MTk0IiwibWlzc2lsZVVubG9ja2VkIjoiMCIsIm1vbm9saXRoVW5sb2NrZWQiOiIxIiwibmFtZUFpcmNyYWZ0IjoiNyIsIm5hbWVDaGFvcyI6IjEiLCJuYW1lTWVsZWUiOiI3IiwibmFtZU1pc3NpbGUiOiIxIiwibmFtZU1vdW50ZWQiOiI3IiwibmFtZVJhbmdlZCI6IjciLCJuYW1lU2F0ZWxsaXRlIjoiMSIsIm5hbWVTY2hvbGFyIjoiNyIsIm5hbWVTaWVnZSI6IjciLCJuYW1lU3BhY2VzaGlwIjoiMSIsIm5hbWVXaWxsIjoiMSIsIm93bmVkQWlyY3JhZnQiOiIzNyIsIm93bmVkQ2hhb3MiOiIwIiwib3duZWRNZWxlZSI6IjEwMSIsIm93bmVkTWlzc2lsZSI6IjAiLCJvd25lZE1vdW50ZWQiOiI5NCIsIm93bmVkUmFuZ2VkIjoiMTAwIiwib3duZWRTYXRlbGxpdGUiOiIwIiwib3duZWRTY2hvbGFyIjoiMTAwIiwib3duZWRTaWVnZSI6IjY4Iiwib3duZWRTcGFjZXNoaXAiOiIwIiwib3duZWRXaWxsIjoiMCIsInBvd2VyQWlyY3JhZnQiOiIyNTAwMCIsInBvd2VyQ2hhb3MiOiIxIiwicG93ZXJNZWxlZSI6IjE5MiIsInBvd2VyTWlzc2lsZSI6IjEiLCJwb3dlck1vdW50ZWQiOiIxODAwIiwicG93ZXJSYW5nZWQiOiI1NzYiLCJwb3dlclNhdGVsbGl0ZSI6IjEiLCJwb3dlclNjaG9sYXIiOiI0MzMiLCJwb3dlclNpZWdlIjoiMjgwMDAiLCJwb3dlclNwYWNlc2hpcCI6IjEiLCJwb3dlcldpbGwiOiIxIiwic2F2ZWQiOiIxIiwic2llZ2VVbmxvY2tlZCI6IjEiLCJzcGFjZWZhY3RvcnlVbmxvY2tlZCI6IjAiLCJzdGF0QnJlYWt0aHJvdWdoIjoiNCIsInN0YXRDcml0cyI6IjkiLCJzdGF0RG1nQWxsVGltZSI6IjcxNDAxMjMzMjk4Mi45MTEiLCJzdGF0RG1nU3dvcmQiOiI5NDUyNTM3MCIsInN0YXRFdm9BbGxUaW1lIjoiMTkyNTcwNTUyODExLjM4NzMzIiwic3RhdEV2b0dhbWUiOiIxOTI1NzA1NTI4MTEuMzg3MzMiLCJzdGF0U2hhcmRzIjoiMCIsInN0YXRTd29yZFN3aW5ncyI6IjI1MTciLCJzdGF0V2FyY3J5IjoiMyIsInN3b3JkUG93ZXIiOiI1NzExMiIsInVubG9ja2VkQWlyY3JhZnRfMDdfYSI6IjAiLCJ1bmxvY2tlZEJhcnJhY2tzXzAyX2EiOiIwIiwidW5sb2NrZWRCYXJyYWNrc18wMl9iIjoiMCIsInVubG9ja2VkQmFycmFja3NfMDNfYSI6IjAiLCJ1bmxvY2tlZEJhcnJhY2tzXzAzX2IiOiIwIiwidW5sb2NrZWRCYXJyYWNrc18wM19jIjoiMCIsInVubG9ja2VkQmFycmFja3NfMDRfYSI6IjAiLCJ1bmxvY2tlZEJhcnJhY2tzXzA0X2IiOiIwIiwidW5sb2NrZWRCYXJyYWNrc18wNF9jIjoiMCIsInVubG9ja2VkQmFycmFja3NfMDRfZCI6IjAiLCJ1bmxvY2tlZEJhcnJhY2tzXzA1X2EiOiIwIiwidW5sb2NrZWRCYXJyYWNrc18wNV9iIjoiMCIsInVubG9ja2VkQmFycmFja3NfMDVfYyI6IjAiLCJ1bmxvY2tlZEJhcnJhY2tzXzA1X2QiOiIwIiwidW5sb2NrZWRCYXJyYWNrc18wNl9hIjoiMCIsInVubG9ja2VkQmFycmFja3NfMDZfYiI6IjAiLCJ1bmxvY2tlZEJhcnJhY2tzXzA3X2EiOiIwIiwidW5sb2NrZWRCYXJyYWNrc18wN19iIjoiMCIsInVubG9ja2VkQmFycmFja3NfMDdfYyI6IjAiLCJ1bmxvY2tlZE1vbm9saXRoXzAxX2EiOiIxIiwidW5sb2NrZWRNb25vbGl0aF8wMV9iIjoiMSIsInVubG9ja2VkTW9ub2xpdGhfMDFfYyI6IjEiLCJ1bmxvY2tlZE1vbm9saXRoXzAxX2QiOiIxIiwidW5sb2NrZWRNb25vbGl0aF8wMl9hIjoiMCIsInVubG9ja2VkTW9ub2xpdGhfMDJfYiI6IjAiLCJ1bmxvY2tlZE1vbm9saXRoXzAyX2MiOiIwIiwidW5sb2NrZWRNb25vbGl0aF8wM19hIjoiMCIsInVubG9ja2VkTW9ub2xpdGhfMDNfYiI6IjAiLCJ1bmxvY2tlZE1vbm9saXRoXzAzX2MiOiIxIiwidW5sb2NrZWRNb25vbGl0aF8wM19kIjoiMSIsInVubG9ja2VkTW9ub2xpdGhfMDNfZSI6IjAiLCJ1bmxvY2tlZE1vbm9saXRoXzA0X2EiOiIwIiwidW5sb2NrZWRNb25vbGl0aF8wNF9iIjoiMCIsInVubG9ja2VkTW9ub2xpdGhfMDRfYyI6IjEiLCJ1bmxvY2tlZE1vbm9saXRoXzA0X2QiOiIwIiwidW5sb2NrZWRNb25vbGl0aF8wNV9hIjoiMCIsInVubG9ja2VkTW9ub2xpdGhfMDVfYiI6IjAiLCJ1bmxvY2tlZE1vbm9saXRoXzA1X2MiOiIwIiwidW5sb2NrZWRNb25vbGl0aF8wNV9kIjoiMCIsInVubG9ja2VkTW9ub2xpdGhfMDVfZSI6IjEiLCJ1bmxvY2tlZE1vbm9saXRoXzA2X2EiOiIwIiwidW5sb2NrZWRNb25vbGl0aF8wNl9iIjoiMCIsInVubG9ja2VkTW9ub2xpdGhfMDZfYyI6IjAiLCJ1bmxvY2tlZE1vbm9saXRoXzA2X2QiOiIwIiwidW5sb2NrZWRNb25vbGl0aF8wNl9lIjoiMSIsInVubG9ja2VkTW9ub2xpdGhfMDdfYSI6IjAiLCJ1bmxvY2tlZE1vbm9saXRoXzA3X2IiOiIwIiwidW5sb2NrZWRNb25vbGl0aF8wN19jIjoiMCIsInVubG9ja2VkTW9ub2xpdGhfMDdfZCI6IjAiLCJ1bmxvY2tlZE1vbm9saXRoXzA3X2UiOiIwIiwidW5sb2NrZWRTaWVnZV8wNF9hIjoiMCIsInVubG9ja2VkU2llZ2VfMDVfYSI6IjAiLCJ1bmxvY2tlZFNpZWdlXzA2X2EiOiIwIiwidW5sb2NrZWRTaWVnZV8wNl9iIjoiMCIsInVubG9ja2VkU2llZ2VfMDdfYSI6IjAiLCJ1bmxvY2tlZFNpZWdlXzA3X2IiOiIwIiwidW5sb2NrZWRTd29yZF8wMV9hIjoiMCIsInVubG9ja2VkU3dvcmRfMDJfYSI6IjAiLCJ1bmxvY2tlZFN3b3JkXzAyX2IiOiIwIiwidW5sb2NrZWRTd29yZF8wM19hIjoiMCIsInVubG9ja2VkU3dvcmRfMDNfYiI6IjAiLCJ1bmxvY2tlZFN3b3JkXzA0X2EiOiIwIiwidW5sb2NrZWRTd29yZF8wNF9iIjoiMCIsInVubG9ja2VkU3dvcmRfMDVfYSI6IjAiLCJ1bmxvY2tlZFN3b3JkXzA1X2IiOiIwIiwidW5sb2NrZWRTd29yZF8wNl9hIjoiMCIsInVubG9ja2VkU3dvcmRfMDZfYiI6IjAiLCJ1bmxvY2tlZFN3b3JkXzA3X2EiOiIwIiwidW5sb2NrZWRTd29yZF8wN19iIjoiMCIsIndoaWNoU3dvcmQiOiI3In0=");
        alert.accept();
        switchTo().defaultContent();
        $("#btnStats").click();
    }

    private void saveGame() {
        $("#btnStats").click();
        $("#btnSave").click();
        String data = $("#export > form > textarea").getValue();
        try (OutputStream outputStream = new FileOutputStream(savefile)) {
            Properties properties = new Properties();
            properties.setProperty("data", data);
            properties.store(outputStream, null);
        } catch (IOException ignored) {
            System.err.println(String.format("COULDN'T SAVE: %s", data));
        }
        $("#btnStats").click();
    }

    public void attack() {
        button.click();
    }

    @Override
    public void close() {
        saveGame();
        Selenide.close();
    }
}