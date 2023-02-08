package Workfront_20221030T170213Z.Workfront_20221023T104747Z;

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
    String folder = "\\Workfront_20221023T104747Z\\FRA\\3508169\\FRA\\"; // the path to store the captured images with  lang code can be changed accordingly
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
        options.addArguments("--lang=fr"); //set browser language
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
    public void String_001_010() throws Exception {
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
    @Test
    public void String_011() throws Exception {
//        MockID: YQg	Yesterday at {date}
//        Core string: When this is selected, approvers can also submit, reopen, or edit the timesheet, unless your administrator restricts these actions in the Timesheet Preferences area of Setup.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/338ec68b-7854-45e3-a89f-1e6896dd9f1b/updates
//        1. Login to Workfront 2. Go to Goals and create a new goal 3. Go to Progress Indicators tab and create a new activity 4. Go to Updates -> System Activity

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/goal/961e6f96-3907-4168-b081-983320082cbe/updates");
        waitForPageToLoadCompletely(driver,30);

        // Open any project 3. Click on three dots in the toolbar > Copy
        clickToElement(driver, "//div[@class='header-item ']");
        sleepInSecond(1);

        // Take SS: YQg	Yesterday at {date}
        takeSnapShotWithHighlight(driver,"(//div[contains(@style,'color: var(--spectrum-gray-600);')])[1]", GlobalConstants.SCREENSHOTS+folder+"011_YQg.png");
    }
    @Test
    public void String_012() throws Exception {
//        MockID: YQh	Today at {date}
//        Core string: When this is selected, approvers can also submit, reopen, or edit the timesheet, unless your administrator restricts these actions in the Timesheet Preferences area of Setup.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/338ec68b-7854-45e3-a89f-1e6896dd9f1b/updates
//        1. Login to Workfront 2. Go to Goals and create a new goal 3. Go to Progress Indicators tab and create a new activity 4. Go to Updates -> System Activity

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/goal/ad96243c-e1ac-43df-9ce1-645e70b7d512/updates");
        waitForPageToLoadCompletely(driver,30);

        clickToElement(driver, "//div[@class='header-item ']");
        sleepInSecond(1);

        // Take SS: YQh	Today at {date}
        takeSnapShotWithHighlight(driver,"(//div[contains(@style,'color: var(--spectrum-gray-600);')])[1]", GlobalConstants.SCREENSHOTS+folder+"012_YQh.png");
    }
    @Test
    public void String_013_014() throws Exception {
//        MockID: YQW	{author} connected the {__mlm_low_project} {title}
//        Core string: When this is selected, approvers can also submit, reopen, or edit the timesheet, unless your administrator restricts these actions in the Timesheet Preferences area of Setup.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/338ec68b-7854-45e3-a89f-1e6896dd9f1b/updates
//        1. Login to Workfront 2. Go to Goals and create a new goal 3. Go to Progress Indicators tab and attach existing project ( New progress indicator -> Add existing project) 4. Go to Updates -> System Activity

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/goal/338ec68b-7854-45e3-a89f-1e6896dd9f1b/updates");
        waitForPageToLoadCompletely(driver,30);

        clickToElement(driver, "//div[@class='header-item ']");
        sleepInSecond(1);

        // Take SS: YQW	{author} connected the {__mlm_low_project} {title}
        takeSnapShotWithHighlight(driver,"(//div[contains(@style,'color: var(--spectrum-gray-600);')])[1]", GlobalConstants.SCREENSHOTS+folder+"013_YQW.png");

        // Take SS: YQY	{author} created {__mlm_low_activity} {title}
        takeSnapShotWithHighlight(driver,"(//div[contains(@style,'color: var(--spectrum-gray-600);')])[2]", GlobalConstants.SCREENSHOTS+folder+"014_YQY.png");
    }
    @Test
    public void String_015() throws Exception {
//        MockID: YQb	{author} created {__mlm_low_result} {title}
//        Core string: When this is selected, approvers can also submit, reopen, or edit the timesheet, unless your administrator restricts these actions in the Timesheet Preferences area of Setup.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/338ec68b-7854-45e3-a89f-1e6896dd9f1b/updates
//        1. Login to Workfront 2. Go to Goals and create a new goal 3. Go to Progress Indicators tab and create a new result 4. Go to Updates -> System Activity"

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/goal/efb295fa-efd7-4fb9-aae6-8e9d86d6268a/updates");
        waitForPageToLoadCompletely(driver,30);

        clickToElement(driver, "//div[@class='header-item ']");
        sleepInSecond(1);

        // Take SS: YQb	{author} created {__mlm_low_result} {title}
        takeSnapShotWithHighlight(driver,"(//div[contains(@style,'color: var(--spectrum-gray-600);')])[1]", GlobalConstants.SCREENSHOTS+folder+"015_YQb.png");
    }
    @Test
    public void String_016_017() throws Exception {
//        MockID: YQa	{author} updated the progress of the {__mlm_low_activity} {title} from {prevVal} to {newVal}	None
//        Core string: When this is selected, approvers can also submit, reopen, or edit the timesheet, unless your administrator restricts these actions in the Timesheet Preferences area of Setup.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/338ec68b-7854-45e3-a89f-1e6896dd9f1b/updates
//        1. Login to Workfront 2. Go to Goals and create a new goal 3. Go to Progress Indicators tab and create a new activity 4. Click on three dots near goal name -> Activate
//        5. Click on Actual Progress field and update the value to 20 6. Go to Updates -> System Activity"

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/goal/4c91bf9f-9160-4d80-8af1-f54d84c11f88/updates");
        waitForPageToLoadCompletely(driver,30);

        clickToElement(driver, "//div[@class='header-item ']");
        sleepInSecond(1);

        // Take SS: YQX	{author} updated the progress of the {__mlm_low_result} {title} from {prevVal} to {newVal}	None
        takeSnapShotWithHighlight(driver,"(//div[contains(@style,'color: var(--spectrum-gray-600);')])[1]", GlobalConstants.SCREENSHOTS+folder+"016_YQX.png");

        // Take SS: YQa	{author} updated the progress of the {__mlm_low_activity} {title} from {prevVal} to {newVal}
        takeSnapShotWithHighlight(driver,"(//div[contains(@style,'color: var(--spectrum-gray-600);')])[3]", GlobalConstants.SCREENSHOTS+folder+"017_YQa.png");
    }




    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

}
