package Workfront_20220529T102027Z_P1;

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
//        MockID: VNb
//        Core string: User is the administrator of {0} group and cannot be removed from the group
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/user/61f9b69800061c20bc107fe06c49e6ce/updates
//        1. Login to Workfront
//        2. Go to Main Menu -> Admin User
//        3. Click on three dots -> Edit
//        4. Try removing groups where this user is an administrator

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/user/61f9b69800061c20bc107fe06c49e6ce/updates");

        // Click on three dots -> Edit
        waitForElementVisible(driver,"//div[@data-testid='more-testid-trigger']");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='more-testid-trigger']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='edit-user']");
        sleepInSecond(1);

        // Switch to Edit Person form
        switchToIframeByElement(driver,"//iframe[@id='form-user-settings']");
        clickToElement(driver,"//ul[@class='scrollNav']//li[5]");

        // Go to Other group and remove a user
        scrollToElementBotton(driver,"//li[@name='timeboxUser']");
        sleepInSecond(1);
        clickToElement(driver,"//label[text()='bu']/following-sibling::a");
        takeSnapShotWithHighlight(driver,"//div[@class='ContextMessagePanel warning otherGroupsRemoveInfoPanel']",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z_P1\\ENU\\001_VNb.png");
    }

    @Test
    public void String_002() {
//        MockID: X1e
//        Core string: Add projects to the <b>{campaignName}</b> campaign
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/campaigns
//        1. Login to Workfront
//        2. Go to Main Menu -> Campaigns -> New Campaign
//        3. Click New Project -> Existing Project

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/campaigns");

        // Go to Main Menu -> Campaigns -> New Campaign
        waitForElementVisible(driver,"//div[@data-testid='toolbar-primary-area__PROJ']");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='toolbar-primary-area__PROJ']");

        // Click New Project -> Existing Project
        waitForElementVisible(driver,"//button[@data-testid='import-project-button-dropdown']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='import-project-button-dropdown']");
        sleepInSecond(1);
        clickToElement(driver,"//span[@data-testid='option__add-existing-project']");

        //take screenshots
        waitForElementVisible(driver,"//div[@data-testid='sliding-pane-header']/span");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"//div[@data-testid='sliding-pane-header']/span",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z_P1\\ENU\\002_X1e.png");

        // Close and delete created Campaign
        clickToElement(driver,"//button[@data-testid='close-dialog']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='delete']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='confirm-button-confirm-dialog']");
    }

    @Test
    public void String_003() {
//        MockID: X1P
//        Core string: Add {__mlm_low_projects} to the <b>{campaignName}</b> {__mlm_low_campaign}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/campaigns
//         1. Login to Workfront
//         2. Go to Main Menu -> Campaigns -> New Campaign
//         3. Click New Project -> Existing Project

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/campaigns");

        // Go to Main Menu -> Campaigns -> New Campaign
        waitForElementVisible(driver,"//div[@data-testid='toolbar-primary-area__PROJ']");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='toolbar-primary-area__PROJ']");

        // Click New Project -> Existing Project
        waitForElementVisible(driver,"//button[@data-testid='import-project-button-dropdown']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='import-project-button-dropdown']");
        sleepInSecond(1);
        clickToElement(driver,"//span[@data-testid='option__add-existing-project']");

        // Take screenshots
        waitForElementVisible(driver,"//div[@data-testid='sliding-pane-header']/span");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"//div[@data-testid='sliding-pane-header']/span",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z_P1\\ENU\\003_X1P.png");

        // Close and delete created Campaign
        clickToElement(driver,"//button[@data-testid='close-dialog']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='delete']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='confirm-button-confirm-dialog']");
    }

    @Test
    public void String_004() {
//        MockID: X1t
//        Core string: You cannot recover deleted {__mlm_low_campaign}. Are you sure you want to delete this?
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/campaigns
//        1. Login to Workfront
//        2. Go to Main Menu -> Campaigns -> New Campaign
//        3. Add any project to it
//        4. In the first tab click on three dots near campaign name -> Delete

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/campaigns");

        // Go to Main Menu -> Campaigns -> New Campaign
        waitForElementVisible(driver,"//div[@data-testid='toolbar-primary-area__PROJ']");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='toolbar-primary-area__PROJ']");

        // Click three dots near campaign name -> Delete
        waitForElementVisible(driver,"//button[@data-testid='import-project-button-dropdown']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='import-project-button-dropdown']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='delete']");

        //take screenshots
        waitForElementVisible(driver,"//section[@data-testid='confirm-dialog-dialog-body']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"//section[@data-testid='confirm-dialog-dialog-body']",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z_P1\\ENU\\004_X1t.png");
        clickToElement(driver,"//button[@data-testid='confirm-button-confirm-dialog']");


    }

    @Test
    public void String_005() {
//        MockID: X1x
//        Core string: You cannot recover deleted campaign. Are you sure you want to delete this?
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/campaigns
//        1. Login to Workfront
//        2. Go to Main Menu -> Campaigns -> New Campaign
//        3. Add any project to it
//        4. In the first tab click on three dots near campaign name -> Delete

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/campaigns");

        // Go to Main Menu -> Campaigns -> New Campaign
        waitForElementVisible(driver,"//div[@data-testid='toolbar-primary-area__PROJ']");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='toolbar-primary-area__PROJ']");

        // Click three dots near campaign name -> Delete
        waitForElementVisible(driver,"//button[@data-testid='import-project-button-dropdown']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='import-project-button-dropdown']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='delete']");

        //take screenshots
        waitForElementVisible(driver,"//section[@data-testid='confirm-dialog-dialog-body']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"//section[@data-testid='confirm-dialog-dialog-body']",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z_P1\\ENU\\005_X1x.png");
        clickToElement(driver,"//button[@data-testid='confirm-button-confirm-dialog']");
    }

    @Test
    public void String_006() {
//        MockID: X2/
//        Core string: There is no data to display.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//        1. Login to Workfront
//        2. Go to Setup -> System -> Audit Logs
//        3. Filter the logs in a way that no results appear

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");

        switchToIframeByElement(driver,"//iframe[@id='main-frame']");

        // Filter the logs in a way that no results appear
        waitForElementVisible(driver,"//button[@data-name='apply-button'][1]");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-name='users-button']");
        sleepInSecond(1);
        sendKeyToElement(driver,"//input[contains(@class,'ta-input typeAheadInput_')]","a a1");
        sleepInSecond(1);
        clickToElement(driver,"//li[contains(@class,'pick-list-item-USER')]");

        // Click to Apply button
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-name='apply-button'][1]");

        //take screenshots
        waitForElementVisible(driver,"//div[@data-name='header-cell']/parent::div/following-sibling::div");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"//div[@data-name='header-cell']/parent::div/following-sibling::div",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z_P1\\ENU\\006_X2-.png");
    }

    @Test
    public void String_008() {
//        MockID: X23
//        Core string: You edited the <b>{name}</b> goal
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list
//        1. Login to Workfront
//        2. Go to Main Menu -> Goals
//        3. Click Create goal and confirm
//        4. Click on three dots near name -> Edit goal -> Save

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");

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

        // Click Save button
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='create-new-task']");

        // Take screenshots
        waitForElementVisible(driver,"//div[@data-testid='toast-notification']");
        takeSnapShotWithHighlight(driver,"//span[@data-testid='body']",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z_P1\\ENU\\008_X23.png");

        // Delete this goal
        waitForElementVisible(driver,"//div[@data-testid='field-description']");
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='delete']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='confirm-button-confirm-dialog']");
    }

    @Test
    public void String_009() {
//        MockID: X24
//        Core string: You copied the <b>{name}</b> goal
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list
//        1. Login to Workfront
//        2. Go to Main Menu -> Goals
//        3. Click Create goal and confirm
//        4. Click on three dots near name -> Copy Goal -> Copy goal

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");

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
        clickToElement(driver,"//li[@data-testid='copy']");

        // Click Save button
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='create-new-task']");

        // Take screenshots
        waitForElementVisible(driver,"//div[@data-testid='toast-notification']");
        takeSnapShotWithHighlight(driver,"//span[@data-testid='body']",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z_P1\\ENU\\009_X24.png");

        // Delete this goal
        waitForElementVisible(driver,"//div[@data-testid='field-description']");
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='delete']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='confirm-button-confirm-dialog']");
    }

    @Test
    public void String_010() {
//        MockID: X25
//        Core string: RIGHT
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting
//        3. Click New report
//        4. Drag&Drop Table block and click Edit
//        5. Click on New(field) button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas");
        waitForElementVisible(driver, "//button[@data-testid='new-report-button']");
        clickToElement(driver, "//button[@data-testid='new-report-button']");

        waitForElementVisible(driver, "//li[@data-testid='builder-layout-table']");
        doubleClickToElement(driver,"//li[@data-testid='builder-layout-table']");

        waitForElementVisible(driver, "//button[@data-testid='empty-table-edit-icon']");
        clickToElement(driver,"//button[@data-testid='empty-table-edit-icon']");

        clickToElement(driver,"(//div[@data-testid='fields-panel']//button)[1]");
        waitForElementVisible(driver, "//input[@id='configuration-search-input']");

        sendKeyToElement(driver,"//input[@id='configuration-search-input']","RIGHT");
        waitForElementVisible(driver,"//li[@id='RIGHT']");
        takeSnapShotWithHighlight(driver, "//li[@id='RIGHT']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220529T102027Z_P1\\ENU\\010_X25.png");
    }

    @Test
    public void String_011() {
//        MockID: X27
//        Core string: MONTH
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting
//        3. Click New report
//        4. Drag&Drop Table block and click Edit
//        5. Click on New(field) button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas");
        waitForElementVisible(driver, "//button[@data-testid='new-report-button']");
        clickToElement(driver, "//button[@data-testid='new-report-button']");

        waitForElementVisible(driver, "//li[@data-testid='builder-layout-table']");
        doubleClickToElement(driver,"//li[@data-testid='builder-layout-table']");

        waitForElementVisible(driver, "//button[@data-testid='empty-table-edit-icon']");
        clickToElement(driver,"//button[@data-testid='empty-table-edit-icon']");

        clickToElement(driver,"(//div[@data-testid='fields-panel']//button)[1]");
        waitForElementVisible(driver, "//input[@id='configuration-search-input']");

        sendKeyToElement(driver,"//input[@id='configuration-search-input']","MONTH");
        waitForElementVisible(driver,"//li[@id='MONTH']");
        takeSnapShotWithHighlight(driver, "//li[@id='MONTH']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220529T102027Z_P1\\ENU\\011_X27.png");
    }

    @Test
    public void String_012() {
//        MockID: X28
//        Core string: LEFT
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting
//        3. Click New report
//        4. Drag&Drop Table block and click Edit
//        5. Click on New(field) button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas");
        waitForElementVisible(driver, "//button[@data-testid='new-report-button']");
        clickToElement(driver, "//button[@data-testid='new-report-button']");

        waitForElementVisible(driver, "//li[@data-testid='builder-layout-table']");
        doubleClickToElement(driver,"//li[@data-testid='builder-layout-table']");

        waitForElementVisible(driver, "//button[@data-testid='empty-table-edit-icon']");
        clickToElement(driver,"//button[@data-testid='empty-table-edit-icon']");

        clickToElement(driver,"(//div[@data-testid='fields-panel']//button)[1]");
        waitForElementVisible(driver, "//input[@id='configuration-search-input']");

        sendKeyToElement(driver,"//input[@id='configuration-search-input']","LEFT");
        waitForElementVisible(driver,"//li[@id='LEFT']");
        takeSnapShotWithHighlight(driver, "//li[@id='LEFT']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220529T102027Z_P1\\ENU\\012_X28.png");
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}
