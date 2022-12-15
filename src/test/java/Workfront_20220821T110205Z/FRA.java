package Workfront_20220821T110205Z;

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

public class FRA extends AbstractPage {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Set language
        options.addArguments("--lang=fr");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(GlobalConstants.APP_URL);
        sendKeyToElement(driver, "//input[@id='username']", GlobalConstants.ACCOUNT);
        sendKeyToElement(driver, "//input[@id='password']", GlobalConstants.PASSWORD);
        clickToElement(driver, "//button[@type='submit']");
        waitForElementVisible(driver, "//div[@data-testid='user-page-title']");

    }

    @Test
    public void TC01_String_001_002() {
//        MockID: X/q
//        Core string: Operating models
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/work-objects
//        1. Login to Workfront
//        2. Go to Main Menu -> Setup
//        3. Click on 'Operating models'

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/setup/operational-models");

        waitForElementVisible(driver,"//a[contains(@href,'operational-models')]");
        takeSnapShotWithHighlight(
                driver, "//a[contains(@href,'operational-models')]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220821T110205Z\\FRA\\01_X-q.png");

        takeSnapShotWithHighlight(driver,
                "//a[contains(@href,'work-objects')]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220821T110205Z\\FRA\\02_X-r.png");

    }


    @Test
    public void TC_02_String_003_006() {
//        MockID: YB2
//        Core string: Date modified
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/
//        1. Login to Workfront
//        2. Go to Boards
//        3. Click on Sort button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/");
        waitForElementVisible(driver,"//button[@data-testid='dashboard-sort-button']");
        clickToElement(driver,"//button[@data-testid='dashboard-sort-button']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,
                "//li[@data-key='lastModified']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220821T110205Z\\FRA\\03_YB2.png");
        takeSnapShotWithHighlight(driver,
                "//li[@data-key='ascending']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220821T110205Z\\FRA\\06_YB5.png");
    }

    @Test

    public void TC_03_String_008_009() throws Exception {
//        MockID: YBN
//        Core string: Search board names
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/
//        1. Login to Workfront
//        2. Go to Boards
//        3. Click on Search field

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/");
        waitForElementVisible(driver, "//button[@data-testid='dashboard-sort-button']/following-sibling::div[1]");
        clickToElement(driver, "//button[@data-testid='dashboard-sort-button']/following-sibling::div[1]");
        takeSnapShotWithHighlight(driver,
                "//button[@data-testid='dashboard-sort-button']/following-sibling::div[1]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220821T110205Z\\FRA\\09_YBn.png");

        waitForElementVisible(driver,"(//div[@data-testid='dashboard-board-container']//button)[1]");
        inspectElement(driver,"//button[@data-testid='dashboard-sort-button']");
        captureScreen(GlobalConstants.SCREENSHOTS + "\\Workfront_20220821T110205Z\\FRA\\08_YB7.png");

    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

}
