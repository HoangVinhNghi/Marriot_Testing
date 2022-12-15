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
    public void beforeClass() throws Exception {
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
        waitForElementVisible(driver, "//div[@id='page-content']");
    }
    @Test
    public void String_253() throws Exception {
//        MockID: X7h
//        Core string: We could not add your {__mlm_low_project}. Try adding it again.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/campaigns
//        1. Login to Workfront 2. Go to Main Menu -> Campaigns -> New Campaign 3. Click New Project -> Existing Project
//        4. Turn off the internet 5. Select any project and proceed

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/campaigns");
        // Click Filter button
        clickToElement(driver,"//button[@data-testid='open-new-filter-selection-panel']");
        waitForElementVisible(driver,"//button[@data-testid='undefined-trigger-button']");
        inspectElement(driver,"//button[@data-testid='undefined-trigger-button']");

        captureScreen(GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\257_X7k.png");

    }
    @Test
    public void String_236_238()  {
//        MockID: X7j, X7i
//        Core string: drop a date field here, Month
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas
//        1. Login to Workfront 2. Go to Main Menu -> Reporting 3. Click New report 4. Drag&Drop Table block and click Edit
//        5. Click on New(field) button 6. Drag&Drop MONTH function into content panel

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas");
        clickToElement(driver, "//button[@data-testid='new-report-button']");
        sleepInSecond(1);
        doubleClickToElement(driver, "//li[@data-testid='builder-layout-table']");
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='empty-table-edit-icon']");
        clickToElement(driver, "(//div[@data-testid='fields-panel']//button)[1]");
        sleepInSecond(1);
        sendKeyToElement(driver, "//input[@id='configuration-search-input']", "Month");
        sleepInSecond(2);
        dragAndDropHTML5ByJS(driver, "//li[@id='MONTH']", "//div[@data-testid='dropzone-canvas']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='node-argument-drop-zone']", GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\256_X7j.png");
        takeSnapShotWithHighlight(driver, "//div[@type='formula']/div[2]/div/div/div", GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\255_X7j.png");
    }
    @Test
    public void String_240() throws Exception {
//        MockID: X7k
//        Core string: Filter statement connector
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/projects/all
//        1. Login to Workfront 2. Go to Projects 3. Click on Filter button 4. Click on New Filter
//        5. Right click -> Inspect on 'Include if all are true' dropdown (aria-label string)

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/projects/all");
        // Click Filter button
        clickToElement(driver,"//button[@data-testid='open-new-filter-selection-panel']");
        waitForElementVisible(driver,"//button[@data-testid='undefined-trigger-button']");
        inspectElement(driver,"//button[@data-testid='undefined-trigger-button']");

        captureScreen(GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\257_X7k.png");

    }
    @Test
    public void String_242() throws Exception {
//        MockID: X7m
//        Core string: Edit {__mlm_low_goal}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list
//        1. Login to Workfront 2. Go to Main Menu -> Goals 3. Click Create goal and confirm 4. Click on three dots near name -> Edit

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");
        // Click to new goal
        waitForElementVisible(driver,"//button[@data-testid='add-goal-button']");
        clickToElement(driver,"//button[@data-testid='add-goal-button']");

        // create a new goal
        waitForElementVisible(driver,"//input[@data-testid='name-input']");
        sendKeyToElement(driver,"//input[@data-testid='name-input']","Test goal_" + generateRandomNumber());
        clickToElement(driver,"//button[@data-testid='create-new-task']");

        // click on three dots > edit
        waitForElementVisible(driver,"//div[@data-testid='field-description']");
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='edit']");

        takeSnapShotWithHighlight(driver,"//h1[@data-testid='dialog-dialog-header-text']//div[@data-testid='name-editor-element']/div",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\258_X7m.png");

    }

    @Test
    public void String_258() throws Exception {
//        MockID: X7m
//        Core string: Edit {__mlm_low_goal}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/projects/all
//        1. Login to Workfront 2. Go to Projects -> New Project 3. Switch to Issues tab and add any issue 4. Select created Issue 5. Click three dots -> Convert to task

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");
        // Click to new goal
        waitForElementVisible(driver,"//button[@data-testid='add-goal-button']");
        clickToElement(driver,"//button[@data-testid='add-goal-button']");

        // create a new goal
        waitForElementVisible(driver,"//input[@data-testid='name-input']");
        sendKeyToElement(driver,"//input[@data-testid='name-input']","Test goal_" + generateRandomNumber());
        clickToElement(driver,"//button[@data-testid='create-new-task']");

        // click on three dots > edit
        waitForElementVisible(driver,"//div[@data-testid='field-description']");
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='edit']");

        takeSnapShotWithHighlight(driver,"//h1[@data-testid='dialog-dialog-header-text']//div[@data-testid='name-editor-element']/div",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\258_X7m.png");

    }




    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}
