package _Test_Pass_2;

import common.AbstractPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AEM_Test extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20221121T103817Z\\ENU\\"; // the path to store the captured images with  lang code can be changed accordingly
    // Select the lang code accordingly
    String lang_EN ="--lang=en\"";
    String lang_DE ="de";
    String lang_ES ="--lang=es";
    String lang_FR ="--lang=fr";
    String lang_IT ="--lang=it";
    String lang_JP ="--lang=ja-JP";
    String lang_PB ="--lang=pt-BR";

    @BeforeClass
    public void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Set language
        options.addArguments("--lang=en"); //set browser language
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://experience-stage.adobe.com/#/@screensinternalstage/screens/displays");
        sendKeyToElement(driver, "//input[@id='EmailPage-EmailField']", "exc-locuser-en+T2E@adobetest.com");
        clickToElement(driver,"//button[@data-id='EmailPage-ContinueButton']");
        sendKeyToElement(driver, "//input[@id='PasswordPage-PasswordField']", "1qaz@WSX");
        clickToElement(driver, "//button[@data-id='PasswordPage-ContinueButton']");
    }

    @Test
    public void String_001() throws Exception {
//        1. Login to AEM (https://experience-stage.adobe.com/#/@cm-north-star-stage/screens/displays)
//        2. From left rail select 'Displays'3. Click 'Create' button4. Pick a 'Display' option 5. Create new display
//        6. Click on newly create display link7. Click on 'Assign channel' button8. Click on 'Add recurrence' button

        waitForElementVisible(driver,"//iframe[contains(@src,'/displays')]");
        // Switch to Iframe main
        switchToIframeByElement(driver,"//iframe[contains(@src,'/displays')]");

        // 3. Click 'Create' button
        clickToElement(driver,"//button[contains(@class,'spectrum-Button--cta')]");

        // 4. Pick a 'Display' option
        clickToElement(driver,"//li[@data-key='playlist']");

        // 5. Create new display
        String displayName = "New_display_"+getRandomNumber();
        sendKeyToElement(driver,"//input[@aria-errormessage=\"screens-aria-name-error\"]", displayName);
        sleepInSecond(1);
        clickToElement(driver,"//div[contains(@class,'Dialog-buttonGroup')]//button[contains(@class,'spectrum-Button--cta')]");
        waitForElementInvisible(driver,"//div[contains(@class,'Dialog-buttonGroup')]");

        // 6. Click on newly create display link
        sendKeyToElement(driver,"//input[contains(@class,'Search-input')]",displayName);
        sleepInSecond(1);
        clickToElement(driver,"//div[@class='screens-Playlist-name']/span");
        waitForElementInvisible(driver,"//div[contains(@class,'spectrum-CircleLoader']");

        // 7. Click on 'Assign channel' button
        waitForElementVisible(driver,"//div[contains(@class,'spectrum-Dialog')]");
        sleepInSecond(1);
        clickToElement(driver,"//div[@class='screens-Dashboard-actions']//button[contains(@class,'cta')]");

        // 8. Click on 'Add recurrence' button
        clickToElement(driver,"//*[name()='path' and contains(@d,'M29 16h-9V7a1')]");

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}
