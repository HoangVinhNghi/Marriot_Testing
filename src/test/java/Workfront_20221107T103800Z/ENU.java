package Workfront_20221107T103800Z;

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
    String folder = "\\Workfront_20221107T103800Z\\ENU\\"; // the path to store the captured images with  lang code can be changed accordingly
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
    public void String_001() throws Exception {
//        MockID: YRs	Are you sure you want to delete
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/63a01f089a30709d646d5680
//        1. Login to Workfront 2. Go to Boards and open a new board 3. Click three dots -> Delete

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/63e0f237c77c8222346e76a3");
        waitForPageToLoadCompletely(driver,60);

        // Open any existed Board
//        waitForElementVisible(driver,"(//div[@data-testid='dashboard-board-container']//h4)[1]");
//        clickToElement(driver,"(//div[@data-testid='dashboard-board-container']//h4)[1]");

        // Click three dots button > Delete
        sleepInSecond(1);
        waitForElementInvisible(driver,"//button[@data-testid='board-menu-button']");
        clickToElement(driver,"//button[@data-testid='board-menu-button']");

        waitForElementVisible(driver,"//li[@data-key='delete']");
        clickToElement(driver,"//li[@data-key='delete']");

        // Take SS: YQy	Custom Data
        takeSnapShotWithHighlight(driver,"//section[contains(@class,'spectrum-Dialog-content')]", GlobalConstants.SCREENSHOTS+folder+"001_YRs.png");

    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}
