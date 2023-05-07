package Workfront_20230122T094050Z;

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
    String folder = "\\ENU\\Workfront_20230122T094050Z\\"; // the path to store the captured images with  lang code can be changed accordingly
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
//        MockID:   YYI	Maestro
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/06d4c2b8-3592-48fd-9d15-ea5cd21f0b4c/61b98b16-27e0-490a-9cbc-53672a46ccaa/table?view=31ab438a-f5a3-4ead-b36f-46b2ea17f690
// 1. Login to Workfront
// 2. Go to Main Menu

        // Go to Boards
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        waitForPageToLoadCompletely(driver,60);

        sleepInSecond(1);
        waitForElementVisible(driver,"//button[@data-testid='global-nav-drawer-toggle']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='global-nav-drawer-toggle']");
        waitForElementVisible(driver,"//a[@data-testid='workrecords.maestro']");

        // Take SS: YWY	Title is required
        takeSnapShotWithHighlight(driver,"//a[@data-testid='workrecords.maestro']",GlobalConstants.SCREENSHOTS+folder+"001_YYI.png");
    }
    @Test
    public void String_002() throws Exception {
//        MockID:   YVd	Tag people or teams
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/collection/63cfff24074a430a3f989996
//        1. Login to Workfront > Install Photoshop and WF plugin for it(use adobe ldap account)
// 2. Go to Issue > Updates"

        // Go to Boards
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/issue/62012f320001704354d4e1391949f5ff/updates");
        waitForPageToLoadCompletely(driver,60);

        sleepInSecond(1);
        waitForElementVisible(driver,"//input");
        sleepInSecond(1);
        clickToElement(driver,"//input");

        // Take SS: YVd	Tag people or teams
        takeSnapShotWithHighlight(driver,"(//input[@id='user-picker-1'])[1]",GlobalConstants.SCREENSHOTS+folder+"002_YVd.png");
    }
    @Test
    public void String_003() throws Exception {
//        MockID:   YVc	Determine what will happen to time logged on work items that users delete	None
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/timesheet-preferences
//        1. Login to Workfront
//         2. Go to Setup -> Timesheets & Hours -> Preferences

        // Go to Boards
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/setup/timesheet-preferences");
        waitForPageToLoadCompletely(driver,60);

        sleepInSecond(1);
        waitForElementVisible(driver,"(//h4)[4]");
        scrollToElement(driver,"(//h4)[4]");
        sleepInSecond(1);

        // Take SS: YVc	Determine what will happen to time logged on work items that users delete
        takeSnapShotWithHighlight(driver,"(//h4)[4]",GlobalConstants.SCREENSHOTS+folder+"003_YVc.png");

        sleepInSecond(1);
        waitForElementVisible(driver,"(//h4)[3]");
        scrollToElement(driver,"(//h4)[3]");
        sleepInSecond(1);

        // Take SS: YVb	Indicate where you want users to be able to log time	None
        takeSnapShotWithHighlight(driver,"(//h4)[3]",GlobalConstants.SCREENSHOTS+folder+"004_YVb.png");

        sleepInSecond(1);
        waitForElementVisible(driver,"(//h4)[2]");
        scrollToElement(driver,"(//h4)[2]");
        sleepInSecond(1);

        // Take SS: YVZ	Indicate what you want users to be able to include in timesheets
        takeSnapShotWithHighlight(driver,"(//h4)[2]",GlobalConstants.SCREENSHOTS+folder+"005_YVZ.png");

        sleepInSecond(1);
        waitForElementVisible(driver,"(//h4)[1]");
        scrollToElement(driver,"(//h4)[1]");
        sleepInSecond(1);

        // Take SS: YVY	Indicate what you want users to be able to do with timesheets and hours
        takeSnapShotWithHighlight(driver,"(//h4)[1]",GlobalConstants.SCREENSHOTS+folder+"006_YVY.png");
    }



    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}