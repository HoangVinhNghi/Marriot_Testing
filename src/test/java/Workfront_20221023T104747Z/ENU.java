package Workfront_20221023T104747Z;

import common.AbstractPage;
import common.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ENU extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20221021T194141Z\\ENU\\"; // the path to store the captured images with  lang code can be changed accordingly
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
//        MockID: YQy	Custom Data
//        Core string: When this is selected, approvers can also submit, reopen, or edit the timesheet, unless your administrator restricts these actions in the Timesheet Preferences area of Setup.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/61fa7236000ab6512a9c112c329d7211/overview
//        1. Login to Workfront 2. Open any project 3. Click on three dots in the toolbar -> Copy"

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/projects/all");
        waitForPageToLoadCompletely(driver,30);

        // Open any project 3. Click on three dots in the toolbar > Copy
        clickToElement(driver, "(//a[@data-test-id='LinkSimple'])[1]");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//li[@data-testid='copy']");

        // Take SS: YQy	Custom Data
        takeSnapShotWithHighlight(driver,"//label[@for='clearCustomData']", GlobalConstants.SCREENSHOTS+folder+"001_YQy.png");
        // Take SS: YQx	Progress
        takeSnapShotWithHighlight(driver,"//label[@for='clearProgress']", GlobalConstants.SCREENSHOTS+folder+"002_YQx.png");
        // Take SS: YQw	Approval Processes
        takeSnapShotWithHighlight(driver,"//label[@for='clearApprovers']", GlobalConstants.SCREENSHOTS+folder+"003_YQw.png");
        // Take SS: YQv	Permissions
        takeSnapShotWithHighlight(driver,"//label[@for='clearPermissions']", GlobalConstants.SCREENSHOTS+folder+"004_YQv.png");
        // Take SS: YQu	Reminder Notifications
        takeSnapShotWithHighlight(driver,"//label[@for='clearTimedNotifications']", GlobalConstants.SCREENSHOTS+folder+"005_YQu.png");
        // Take SS: YQt	Documents
        takeSnapShotWithHighlight(driver,"//label[@for='clearDocuments']", GlobalConstants.SCREENSHOTS+folder+"006_YQt.png");
        // Take SS: YQs	Assignments
        takeSnapShotWithHighlight(driver,"//label[@for='clearAssignments']", GlobalConstants.SCREENSHOTS+folder+"007_YQs.png");
        // Take SS: YQr	Expenses
        takeSnapShotWithHighlight(driver,"//label[@for='clearExpenses']", GlobalConstants.SCREENSHOTS+folder+"008_YQr.png");
        // Take SS: YQq	Predecessors
        takeSnapShotWithHighlight(driver,"//label[@for='clearPredecessors']", GlobalConstants.SCREENSHOTS+folder+"009_YQq.png");
        // Take SS: YQp	Financial Information
        takeSnapShotWithHighlight(driver,"//label[@for='clearFinancials']", GlobalConstants.SCREENSHOTS+folder+"010_YQp.png");

    }



    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}
