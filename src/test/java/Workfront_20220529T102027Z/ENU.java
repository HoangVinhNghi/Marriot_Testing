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
    public void String_234() throws Exception {
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
    public void String_253() throws Exception {
//        MockID: X7W
//        Core string: End date
//        Pre-condition: setup/task-issue > Allow user to delegate their tasks and issues
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/worklist 1. Login to Workfront 2. Go to Home page and click Delegate

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/home/worklist");
        clickToElement(driver, "//button[@data-testid='delegations-modal-button']");

        if (isElementDisplayed(driver, "//button[contains(@class,'stopDelegationButtonStyles')]")) {
            clickToElement(driver, "//button[contains(@class,'stopDelegationButtonStyles')]");
            clickToElement(driver, "//button[@data-testid='confirm-button-confirm-dialog']");
            clickToElement(driver, "//button[@data-testid='toast-close-btn']");
            sleepInSecond(2);
            clickToElement(driver, "//button[@data-testid='delegations-modal-button']");
        }

        sendKeyToElement(driver, "//input[@data-testid='dma-api-select-input']", "Admin Admin");
        clickToElement(driver, "//div[@data-testid='avatar']");
        sleepInSecond(1);
        waitForElementVisible(driver,"//label[@id='endDate-label']");
        takeSnapShotWithHighlight(driver,"//label[@id='endDate-label']",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\253_X7W.png");

    }

    @Test
    public void String_255() throws Exception {
//        MockID: X7Y
//        Core string: Delete Campaigns
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/campaigns 1. Login to Workfront 2. Go to Main Menu -> Campaigns
//        3. Create some campaigns 4. Select two and click Delete

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/campaigns");
        // Select 2 Campaigns
        checkToCheckboxOrRadio(driver,"(//div[@data-test-id='row-checkbox'])[1]");
        checkToCheckboxOrRadio(driver,"(//div[@data-test-id='row-checkbox'])[2]");

        //Click Delete button
        clickToElement(driver,"//button[@data-testid='delete']");

        takeSnapShotWithHighlight(driver,"//h1[@id='confirm-dialog-dialog-header-text']",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\255_X7Y.png");

    }

    @Test
    public void String_258() throws Exception {
//        MockID: Xuf
//        Core string: Destination {__mlm_up_project}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/projects/all
//        1. Login to Workfront 2. Go to Projects -> New Project 3. Switch to Issues tab and add any issue 4. Select created Issue 5. Click three dots -> Convert to task

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/projects/all");
        // Click to new Project
        clickToElement(driver,"//button[@id='dropdown-button']");
        clickToElement(driver,"//span[@data-testid='option__create-project']");

        // Switch to Issue Tab
        clickToElement(driver,"//a[contains(@href,'/issues')]");

        //Add any issue
        clickToElement(driver,"//button[@data-testid='add']");
        switchToIframeByElement(driver,"//iframe[@id='content-issue-add']");
        sendKeyToElement(driver,"//input[@name='name']","Test Issue" + generateRandomNumber());
        sleepInSecond(1);
        clickToElement(driver,"//button[@id='new-issue-button']");
        driver.switchTo().defaultContent();

        // click open Issue and then click on three dots > Convert to Task
        clickToElement(driver,"//a[@data-test-id='LinkSimple' and contains(@href,'/issue/')]");
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='convertToTask']");

        takeSnapShotWithHighlight(driver,"//h2[@data-testid='lightbox-text-section-destinationProjectSection']",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\258_Xuf.png");

    }




    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}
