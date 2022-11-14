package Workfront_20220905T112238Z;

import common.AbstractPage;
import common.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ENU_ extends AbstractPage {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Set language
        options.addArguments("--lang=en");

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
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list
//        1. Login to Workfront
//        2. Go to Main Menu -> Goals
//        3. Click Create goal and confirm
//        4. Switch to Progress Indicators
//        5. Click on 'New progress indicator' button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");
        clickToElement(driver,"//button[@data-testid='add-goal-button']");
        sendKeyToElement(driver,"//input[@data-testid='name-input']","Test goal");
        sleepInSecond(2);
        clickToElement(driver,"//button[@data-testid='create-new-task']");
        sleepInSecond(2);
        clickToElement(driver,"//a[contains(@href,'progress-indicators')]");
        sleepInSecond(2);
        clickToElement(driver,"//button[@data-testid='add-new-indicator-dropdown']");
        sleepInSecond(2);
        clickToElement(driver,"//li[@data-testid='option-1']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver,"//div[@data-testid=\"dialog\"]//div[@data-testid=\"name-editor-element\"]", GlobalConstants.WORKFRONT_20221114+"\\ENU\\X9L.png");



    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }
}
