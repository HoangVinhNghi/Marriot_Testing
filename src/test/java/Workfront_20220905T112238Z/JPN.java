package Workfront_20220905T112238Z;

import common.AbstractPage;
import common.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JPN extends AbstractPage {
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Set language
        options.addArguments("--lang=ja-JP");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(GlobalConstants.APP_URL);
        sendKeyToElement(driver, "//input[@id='username']", GlobalConstants.ACCOUNT);
        sendKeyToElement(driver, "//input[@id='password']", GlobalConstants.PASSWORD);
        clickToElement(driver, "//button[@type='submit']");
        waitForElementVisible(driver, "//img[@data-testid='empty-state-child-img']");

    }

    @Test
    public void String_001_X9L() {
//        Core string: New {__mlm_low_activity}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list
//        1. Login to Workfront
//        2. Go to Main Menu -> Goals
//        3. Click Create goal and confirm
//        4. Switch to Progress Indicators
//        5. Click on 'New progress indicator' button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");
        clickToElement(driver, "//button[@data-testid='add-goal-button']");
        sendKeyToElement(driver, "//input[@data-testid='name-input']", "Test goal_" + generateRandomNumber());
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='create-new-task']");
        sleepInSecond(2);
        clickToElement(driver, "//a[contains(@href,'progress-indicators')]");
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='add-new-indicator-dropdown']");
        sleepInSecond(2);
        clickToElement(driver, "//li[@data-testid='option-1']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//div[@data-testid=\"dialog\"]//div[@data-testid=\"name-editor-element\"]", GlobalConstants.WORKFRONT_20221114 + "\\JPN\\01_X9L.png");

    }

    @Test
    public void String_002_YBL() {
//        Core string: Remove pin
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/worklist
//        1. Login to Workfront
//        2. Go to any page
//        3. In the top navbar pin the page mouse hover any pinned tab
//        4. Click on dropdown button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/home/worklist");



        if (isElementDisplayed(driver,"//button[@data-testid='pin-current-page']")) {
            clickToElement(driver, "//button[@data-testid='pin-current-page']");
        }

        action = new Actions(driver);
        hoverToElement(driver, "//div[@data-testid='pin-actions-trigger']");
        clickToElement(driver, "//div[@data-testid='pin-actions-trigger']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//li[@data-testid='option-1']", GlobalConstants.WORKFRONT_20221114 + "\\JPN\\02_YBL.png");
        clickToElement(driver,"//li[@data-testid='option-1']");
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

}
