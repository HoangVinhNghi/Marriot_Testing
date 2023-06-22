package Workfront_20230018T105148Z.P2;

import common.AbstractPage;
import common.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ENU extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20230018T105148Z\\ENU\\"; // the path to store the captured images with  lang code can be changed accordingly
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
        driver.get(GlobalConstants.APP_URL);
        sendKeyToElement(driver, "//input[@id='username']", GlobalConstants.ACCOUNT);
        sendKeyToElement(driver, "//input[@id='password']", GlobalConstants.PASSWORD);
        clickToElement(driver, "//button[@type='submit']");
        waitForElementVisible(driver, "//div[@id='page-content']");
    }
    @Test
    public void String_01() throws Exception {
//        MockID: YS8	Iteration Process
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome Test User: alp02c@alp.ee / Alp123
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64748be923daf4127e590372
//        1. Go to Boards and create a Workstream 2. Click Add Board

        // Go to Boards
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64575dd5fd92681780115d53");
        waitForPageToLoadCompletely(driver,60);

        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='dashboard-create-board-button']");
        waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M32,18.5a3.49643,3.49643')]/ancestor::div[contains(@style,'height: 100%; width: 100%; flex-direction: column;')]");

        // Take SS: YTA	Team policies, planning, and a recurring time-cycle board to measure efficiency over time
        takeSnapShotWithHighlight(driver,"(//*[name()='path' and contains(@d,'M33.174,16.724A13')]/ancestor::div[contains(@style,'height: 100%; width: 100%; flex-direction: column;')]//span)[1]/preceding-sibling::h4",
                GlobalConstants.SCREENSHOTS+folder+"01_YS8.png");
    }
    @Test
    public void String_02() throws Exception {
//        MockID: YS8	Iteration Process
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome Test User: alp02c@alp.ee / Alp123
//        1. Go to CC and install XD with WF plugin 2. Go to Edit --> Preferences -> Languages and change to your target language
//        3. Open some task and go to Documents tab 4. Click New File 5. Click Create a Proof 6. Enter a lot of characters into Updates fied

        // Go to Boards
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64575dd5fd92681780115d53");
        waitForPageToLoadCompletely(driver,60);

        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='dashboard-create-board-button']");
        waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M32,18.5a3.49643,3.49643')]/ancestor::div[contains(@style,'height: 100%; width: 100%; flex-direction: column;')]");

        // Take SS: YTA	Team policies, planning, and a recurring time-cycle board to measure efficiency over time
        takeSnapShotWithHighlight(driver,"(//*[name()='path' and contains(@d,'M33.174,16.724A13')]/ancestor::div[contains(@style,'height: 100%; width: 100%; flex-direction: column;')]//span)[1]/preceding-sibling::h4",
                GlobalConstants.SCREENSHOTS+folder+"01_YS8.png");
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}