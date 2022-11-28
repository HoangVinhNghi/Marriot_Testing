package Workfront_20220529T102027Z;

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
    public void String_001() {
//        MockID: X7m
//        Core string: Edit {__mlm_low_goal}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list
//        1. Login to Workfront 2. Go to Main Menu -> Goals 3. Click Create goal and confirm 4. Click on three dots near name -> Edit

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");
        clickToElement(driver, "//button[@data-testid='add-goal-button']");
        sendKeyToElement(driver, "//input[@id='name']", "Test Goal_"+getRandomNumber());
        sleepInSecond(1);
        clickToElement(driver, "//button[@data-testid='create-new-task']");
        clickToElement(driver, "//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//li[@data-testid='edit']");
        takeSnapShotWithHighlight(driver,"//header[@id='dialog-dialog-header']//div[@data-testid='name-editor-element']/div",GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\X7m.png");


    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}
