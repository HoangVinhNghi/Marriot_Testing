package Workfront_20220529T102027Z_P1;

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

import java.util.List;
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
        waitForElementVisible(driver, "//div[@id='page-content']");
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
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\001_VNb.png");
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
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\002_X1e.png");

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
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\003_X1P.png");

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
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\004_X1t.png");
        clickToElement(driver,"//button[@data-testid='confirm-button-confirm-dialog']");

        selectDropdownByOptionsValue(driver,"//section[@data-testid='dropdown-menu-dialog']","3" );


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
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\005_X1x.png");
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
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\006_X2-.png");
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
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\008_X23.png");

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

        // creating a new goal
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
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\009_X24.png");

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
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220529T102027Z\\ENU\\010_X25.png");
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
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220529T102027Z\\ENU\\011_X27.png");
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
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220529T102027Z\\ENU\\012_X28.png");
    }

    @Test
    public void String_014() {
//        MockID: X2a
//        Core string: Select Destination {__mlm_up_project}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/projects/all
//        1. Login to Workfront
//        2. Go to Projects -> New Project
//        3. Switch to Issues tab and add any issue
//        4. Select created Issue
//        5. Click three dots -> Convert to task

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/projects/all");

        //Create new project
        waitForElementVisible(driver,"//div[@data-testid='button-options-trigger']//button");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='button-options-trigger']//button");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='option-0']");

        //Switch to Issues tab
        waitForElementVisible(driver,"//div[@data-testid='navitem-qs-tab-project-optasks ']");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='navitem-qs-tab-project-optasks ']");

        // Click to New Issue button
        waitForElementVisible(driver,"//button[@data-testid='add']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='add']");


        // Creating a new issue
        switchToIframeByElement(driver,"//iframe[@id='content-issue-add']");
        waitForElementVisible(driver,"//li[@name='name']/div[@class='edit']/input");
        sendKeyToElement(driver,"//li[@name='name']/div[@class='edit']/input","a");
        waitForElementClickable(driver,"//button[@id='new-issue-button']");
        clickToElement(driver,"//button[@id='new-issue-button']");
        switchToDefaultContent(driver);

        // Select created issues
        waitForElementVisible(driver,"//div[@data-testid='row-checkbox']");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='row-checkbox']");

        // Click three dots button > Convert to task
        waitForElementVisible(driver,"//button[@data-testid='issue-more-dropdown']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='issue-more-dropdown']");
        sleepInSecond(2);
        clickToElement(driver,"//li[@data-testid='option-4']");

        //Take screenshot
        waitForElementVisible(driver,"//div[@data-testid='field-destinationProject-label']");
        takeSnapShotWithHighlight(driver, "//div[@data-testid='field-destinationProject-label']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220529T102027Z\\ENU\\014_X2a.png");

        //CLick to cancel
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='cancel-button']");

        //Delete this project
        waitForElementVisible(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='delete']");
        waitForElementVisible(driver,"//button[@data-testid='confirm-button-confirm-dialog']");
        clickToElement(driver,"//button[@data-testid='confirm-button-confirm-dialog']");
    }

    @Test
    public void String_015() {
//        MockID: X2a
//        Core string: Destination {__mlm_up_project}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/projects/all
//        1. Login to Workfront
//        2. Go to Projects -> New Project
//        3. Switch to Issues tab and add any issue
//        4. Select created Issue
//        5. Click three dots -> Convert to task

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/projects/all");

        //Create new project
        waitForElementVisible(driver,"//div[@data-testid='button-options-trigger']//button");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='button-options-trigger']//button");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='option-0']");

        //Switch to Issues tab
        waitForElementVisible(driver,"//div[@data-testid='navitem-qs-tab-project-optasks ']");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='navitem-qs-tab-project-optasks ']");

        // Click to New Issue button
        waitForElementVisible(driver,"//button[@data-testid='add']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='add']");


        // Creating a new issue
        switchToIframeByElement(driver,"//iframe[@id='content-issue-add']");
        waitForElementVisible(driver,"//li[@name='name']/div[@class='edit']/input");
        sendKeyToElement(driver,"//li[@name='name']/div[@class='edit']/input","a");
        waitForElementClickable(driver,"//button[@id='new-issue-button']");
        clickToElement(driver,"//button[@id='new-issue-button']");
        switchToDefaultContent(driver);

        // Select created issues
        waitForElementVisible(driver,"//div[@data-testid='row-checkbox']");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='row-checkbox']");

        // Click three dots button > Convert to task
        waitForElementVisible(driver,"//button[@data-testid='issue-more-dropdown']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='issue-more-dropdown']");
        sleepInSecond(2);
        clickToElement(driver,"//li[@data-testid='option-4']");

        //Take screenshot
        waitForElementVisible(driver,"//div[@data-testid='lightbox-section-destinationProjectSection']/h2");
        takeSnapShotWithHighlight(driver, "//div[@data-testid='lightbox-section-destinationProjectSection']/h2",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220529T102027Z\\ENU\\015_X2d.png");

        //CLick to cancel
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='cancel-button']");

        //Delete this project
        waitForElementVisible(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='delete']");
        waitForElementVisible(driver,"//button[@data-testid='confirm-button-confirm-dialog']");
        clickToElement(driver,"//button[@data-testid='confirm-button-confirm-dialog']");
    }

    @Test
    public void String_016() {
//        MockID: X2e
//        Core string: Select Destination {__mlm_up_project}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/projects/all
//        1. Login to Workfront
//        2. Go to Projects -> New Project
//        3. Switch to Issues tab and add any issue
//        4. Select created Issue
//        5. Click three dots -> Copy to...

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/projects/all");

        //Create new project
        waitForElementVisible(driver,"//div[@data-testid='button-options-trigger']//button");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='button-options-trigger']//button");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='option-0']");

        //Switch to Issues tab
        waitForElementVisible(driver,"//div[@data-testid='navitem-qs-tab-project-optasks ']");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='navitem-qs-tab-project-optasks ']");

        // Click to New Issue button
        waitForElementVisible(driver,"//button[@data-testid='add']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='add']");


        // Creating a new issue
        switchToIframeByElement(driver,"//iframe[@id='content-issue-add']");
        waitForElementVisible(driver,"//li[@name='name']/div[@class='edit']/input");
        sendKeyToElement(driver,"//li[@name='name']/div[@class='edit']/input","a");
        waitForElementClickable(driver,"//button[@id='new-issue-button']");
        clickToElement(driver,"//button[@id='new-issue-button']");
        switchToDefaultContent(driver);

        // Select created issues
        waitForElementVisible(driver,"//div[@data-testid='row-checkbox']");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='row-checkbox']");

        // Click three dots button > Convert to task
        waitForElementVisible(driver,"//button[@data-testid='issue-more-dropdown']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='issue-more-dropdown']");
        sleepInSecond(2);
        clickToElement(driver,"//li[@data-testid='option-2']");

        //Take screenshot
        waitForElementVisible(driver,"//div[@data-testid='field-destinationProject-label']");
        takeSnapShotWithHighlight(driver, "//div[@data-testid='field-destinationProject-label']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220529T102027Z\\ENU\\016_X2e.png");

        //CLick to cancel
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='cancel-button']");

        //Delete this project
        waitForElementVisible(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='delete']");
        waitForElementVisible(driver,"//button[@data-testid='confirm-button-confirm-dialog']");
        clickToElement(driver,"//button[@data-testid='confirm-button-confirm-dialog']");
    }

    @Test
    public void String_017() {
//        MockID: X2w
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
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\017_X2w.png");

        // Delete this goal
        waitForElementVisible(driver,"//div[@data-testid='field-description']");
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='delete']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='confirm-button-confirm-dialog']");
    }

    @Test
    public void String_018() {
//        MockID: X2x
//        Core string: You copied the <b>{name}</b> {__mlm_low_goal}
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

        // creating a new goal
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
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\018_X2x.png");

        // Delete this goal
        waitForElementVisible(driver,"//div[@data-testid='field-description']");
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='delete']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='confirm-button-confirm-dialog']");
    }

    @Test
    public void String_025() {
//        MockID: X38
//        Core string: All Actions
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//        1. Login to Workfront
//        2. Go to Setup -> System -> Audit Logs

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");


        // Take screenshots
        waitForElementVisible(driver,"//button[@data-name='action-type-filter-button']");
        takeSnapShotWithHighlight(driver,"//button[@data-name='action-type-filter-button']",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\025_X38.png");

    }

    @Test
    public void String_038() {
//        MockID: X3h
//        Core string: From
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//        1. Login to Workfront
//        2. Go to Setup -> System -> Audit Logs

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");

        // Take screenshots
        waitForElementVisible(driver,"//div[@data-name='date-from']/div");
        takeSnapShotWithHighlight(driver,"//div[@data-name='date-from']/div",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\038_X3h.png");

    }

    @Test
    public void String_041() {
//        MockID: X3k
//        Core string: All Users
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//        1. Login to Workfront
//        2. Go to Setup -> System -> Audit Logs

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");

        // Take screenshots
        waitForElementVisible(driver,"//button[@data-name='users-button']");
        takeSnapShotWithHighlight(driver,"//button[@data-name='users-button']",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\041_X3k.png");

    }

    @Test
    public void String_048() {
//        MockID: X3o
//        Core string: Object
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//        1. Login to Workfront
//        2. Go to Setup -> System -> Audit Logs

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");

        // Take screenshots
        waitForElementVisible(driver,"//div[@data-name='header-cell'][5]");
        takeSnapShotWithHighlight(driver,"//div[@data-name='header-cell'][5]",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\048_X3o.png");

    }

    @Test
    public void String_055() {
//        MockID: X3o
//        Core string: Object
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//        1. Login to Workfront
//        2. Go to Setup -> System -> Audit Logs

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");

        // Take screenshots
        waitForElementVisible(driver,"//div[@data-name='header-cell'][1]");
        takeSnapShotWithHighlight(driver,"//div[@data-name='header-cell'][1]",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\055_X3s.png");
    }

    @Test
    public void String_066() {
//        MockID: X3z
//        Core string: Start typing name
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//        1. Login to Workfront
//        2. Go to Setup -> System -> Audit Logs
//        3. Click on 'Users' textfield

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");

        waitForElementVisible(driver,"//button[@data-name='users-button']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-name='users-button']");

        // Take screenshots
        waitForElementVisible(driver,"//input[contains(@class,'ta-input typeAheadInput_')]");
        takeSnapShotWithHighlight(driver,"//input[contains(@class,'ta-input typeAheadInput_')]",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\066_X3z.png");
    }

    @Test
    public void String_077() {
//        MockID: X48
//        Core string: Action Type
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//        1. Login to Workfront
//        2. Go to Setup -> System -> Audit Logs

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");

        // Take screenshots
        waitForElementVisible(driver,"//button[@data-name='action-type-filter-button']/preceding-sibling::div");
        takeSnapShotWithHighlight(driver,"//button[@data-name='action-type-filter-button']/preceding-sibling::div",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\077_X48.png");
    }

    @Test
    public void String_097() {
//        MockID: X4K
//        Core string: All Log Types
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//        1. Login to Workfront
//        2. Go to Setup -> System -> Audit Logs

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");

        // Take screenshots
        waitForElementVisible(driver,"//button[@data-name='log-filter-button']");
        takeSnapShotWithHighlight(driver,"//button[@data-name='log-filter-button']",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\097_X4K.png");
    }

    @Test
    public void String_116() {
//        MockID: X4X
//        Core string: Audit Logs
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//        1. Login to Workfront
//        2. Go to Setup -> System -> Audit Logs

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");

        // Take screenshots
        waitForElementVisible(driver,"//div[@data-testid='setup-header-container']//h2");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='setup-header-container']//h2",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\116_X4X.png");
    }

    @Test
    public void String_131() {
//        MockID: X5b
//        Core string: Details
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//        1. Login to Workfront
//        2. Go to Setup -> System -> Audit Logs

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");

        // Take screenshots
        waitForElementVisible(driver,"//div[@data-name='header-cell'][6]");
        takeSnapShotWithHighlight(driver,"//div[@data-name='header-cell'][6]",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\131_X5b.png");
    }

    @Test
    public void String_134() {
//        MockID: X5C
//        Core string: Action
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//        1. Login to Workfront
//        2. Go to Setup -> System -> Audit Logs

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");

        // Take screenshots
        waitForElementVisible(driver,"//div[@data-name='header-cell'][4]");
        takeSnapShotWithHighlight(driver,"//div[@data-name='header-cell'][4]",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\134_X5C.png");
    }

    @Test
    public void String_137() {
//        MockID: X5E
//        Core string: User name
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//        1. Login to Workfront
//        2. Go to Setup -> System -> Audit Logs

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");

        // Take screenshots
        waitForElementVisible(driver,"//div[@data-name='header-cell'][3]");
        takeSnapShotWithHighlight(driver,"//div[@data-name='header-cell'][3]",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\137_X5E.png");
    }

    @Test
    public void String_141() {
//        MockID: X5G
//        Core string: Apply
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//        1. Login to Workfront
//        2. Go to Setup -> System -> Audit Logs

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");

        // Take screenshots
        waitForElementVisible(driver,"(//button[@data-name='apply-button'])[1]");
        takeSnapShotWithHighlight(driver,"(//button[@data-name='apply-button'])[1]",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\141_X5G.png");
    }

    @Test
    public void String_142() {
//        MockID: X5h
//        Core string: logs
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//        1. Login to Workfront
//        2. Go to Setup -> System -> Audit Logs

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");

        // Take screenshots
        waitForElementVisible(driver,"//div[@data-name='count-picker-container']/parent::div");
        takeSnapShotWithHighlight(driver,"//div[@data-name='count-picker-container']/parent::div",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\142_X5h.png");
    }

    @Test
    public void String_144() {
//        MockID: X5I
//        Core string: Showing
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//        1. Login to Workfront
//        2. Go to Setup -> System -> Audit Logs

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");

        // Take screenshots
        waitForElementVisible(driver,"//div[@data-name='count-picker-container']/parent::div");
        takeSnapShotWithHighlight(driver,"//div[@data-name='count-picker-container']/parent::div",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\144_X5I.png");
    }

    @Test
    public void String_146() {
//        MockID: X5J
//        Core string: Users
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//        1. Login to Workfront
//        2. Go to Setup -> System -> Audit Logs

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");

        // Take screenshots
        waitForElementVisible(driver,"//button[@data-name='users-button']/parent::span/preceding-sibling::div");
        takeSnapShotWithHighlight(driver,"//button[@data-name='users-button']/parent::span/preceding-sibling::div",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\146_X5J.png");
    }

    @Test
    public void String_167() {
//        MockID: X5W
//        Core string: IP address
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//        1. Login to Workfront
//        2. Go to Setup -> System -> Audit Logs

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");

        // Take screenshots
        waitForElementVisible(driver,"//div[@data-name='header-cell'][7]");
        takeSnapShotWithHighlight(driver,"//div[@data-name='header-cell'][7]",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\167_X5W.png");
    }

    @Test
    public void String_173() {
//        MockID: X6/
//        Core string: Action
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//         1. Login to Workfront
//         2. Go to Setup -> System -> Audit Logs
//         3. In the Action Type select exactly 1 action

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");

        //Click to action filter button
        waitForElementVisible(driver,"//button[@data-name='action-type-filter-button']");
        clickToElement(driver,"//button[@data-name='action-type-filter-button']");

        // Remove to all item selected
        List<WebElement> listActionItem = getElements(driver,"//div[@class='css-6peed7']/div[@class=' css-16ovyoc']");
        if (listActionItem.size() > 0) {
            for (WebElement item : listActionItem) {
                item.click();
            }
        }
        // Take screenshots
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"//button[@data-name='action-type-filter-button']",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\173_X6-.png");
    }

    @Test
    public void String_179() {
//        MockID: X64
//        Core string: To
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//         1. Login to Workfront
//         2. Go to Setup -> System -> Audit Logs

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");

        // Take screenshots
        waitForElementVisible(driver,"//div[@data-name='date-to']/div");
        takeSnapShotWithHighlight(driver,"//div[@data-name='date-to']/div",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\179_X64.png");
    }

    @Test
    public void String_196() {
//        MockID: X6i
//        Core string: Clear Filters
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//         1. Login to Workfront
//         2. Go to Setup -> System -> Audit Logs

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");

        waitForElementVisible(driver,"//button[@data-name='log-filter-button']");
        clickToElement(driver,"//button[@data-name='log-filter-button']");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-name='ACCESS_LEVEL']");

        // Take screenshots
        waitForElementVisible(driver,"//a[@data-name='clear-filters']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"//a[@data-name='clear-filters']",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\196_X6i.png");
    }



    @Test
    public void String_258() throws Exception {
//        MockID: X7m
//        Core string: Edit {__mlm_low_goal}
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
