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

import java.awt.*;
import java.awt.event.KeyEvent;
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
    public void String_233() throws Exception {
//        MockID: X7G
//        Core string: Press enter or spacebar to edit
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas
//        1. Login to Workfront 2. Go to Main Menu -> Reporting 3. Click New report 4. Drag&Drop Table block and click Edit 5. Click on New(field) button
//        6. Drag&Drop CONCAT function into content panel 7. Right click -> Inspect on a 'drop a field or enter text' panel (aria-label string)

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas");
        waitForPageToLoadCompletely(driver,30);
        clickToElement(driver, "//button[@data-testid='new-report-button']");
        sleepInSecond(1);
        doubleClickToElement(driver,"//li[@data-testid='builder-layout-table']");
        sleepInSecond(2);
        clickToElement(driver,"//button[@data-testid='empty-table-edit-icon']");
        clickToElement(driver,"(//div[@data-testid='fields-panel']//button)[1]");
        sleepInSecond(1);
        sendKeyToElement(driver,"//input[@id='configuration-search-input']","CONCAT");
        sleepInSecond(2);
        dragAndDropHTML5ByJS(driver,"//li[@id='CONCAT']","//div[@data-testid='dropzone-canvas']");
        sleepInSecond(2);
        inspectElement(driver,"//div[@data-testid='node-argument-drop-zone']/span");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTEXT_MENU);
        robot.keyRelease(KeyEvent.VK_CONTEXT_MENU);
        sleepInSecond(1);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        sleepInSecond(2);
        captureScreen(GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\233_X7G.png");

    }

    @Test
    public void String_237()  {
//        MockID: X7I
//        Core string: The copied {__mlm_low_results} are assigned to their original owner by default
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list
//        1. Login to Workfront 2. Go to Main Menu -> Goals 3. Click Create goal and confirm
//        4. On the Goals page expand created goal and add some dummy result to it. 5. Refresh details page of a created goal and click on 'Copy results' checkbox

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");

        // Create new Goal
        clickToElement(driver, "//button[@data-testid='add-goal-button']");
        sendKeyToElement(driver, "//input[@data-testid='name-input']", "Test goal_" + generateRandomNumber());
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='create-new-task']");

        // Open Progress indicator tab > Add New Indicator > Add result > Create
        clickToElement(driver,"//a[contains(@href,'/progress-indicators')]");
        clickToElement(driver,"//button[@data-testid='add-new-indicator-dropdown']");
        clickToElement(driver,"//li[@data-testid='option-0']");
        sendKeyToElement(driver, "//input[@id='name']", "Goal result" + generateRandomNumber());
        sendKeyToElement(driver, "//input[@id='targetValue']", "10");
        clickToElement(driver,"//button[@data-testid='create-new-task']");

        // Click on three dots button > Copy Goal
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//li[@data-testid='copy']");

        // Check to copy checkbox
        checkToCheckboxOrRadio(driver,"//input[@id='field-shouldCopyResults']");

        takeSnapShotWithHighlight(driver, "//div[@data-testid='alert-icon-container']/following-sibling::div",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\237_X7I.png");
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
    public void String_239() throws Exception {
//        MockID: X7J
//        Core string: This {__mlm_low_goal} does not have any {__mlm_low_results}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list 1. Login to Workfront 2. Go to Main Menu -> Goals 3. Click Create goal and confirm
//        4. Click on three dots near name -> Copy Goal 5. Mouse hover tooltip icon

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");
        // Create new Goal
        clickToElement(driver, "//button[@data-testid='add-goal-button']");
        sendKeyToElement(driver, "//input[@data-testid='name-input']", "Test goal_" + generateRandomNumber());
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='create-new-task']");

        // Click on three dots button > Copy Goal
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//li[@data-testid='copy']");

        // Mouse hover tooltip icon
        hoverToElement(driver,"//span[@data-testid='info-icon']");
        sleepInSecond(1);

        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']",GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\239_X7J.png");

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
        // Click on New filter
        clickToElement(driver,"//button[@data-testid='add-new-button']");

        // Right click -> Inspect on 'Include if all are true' dropdown (aria-label string)
        waitForElementVisible(driver,"//button[@data-testid='undefined-trigger-button']");
        inspectElement(driver,"//button[@data-testid='undefined-trigger-button']");

        captureScreen(GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\257_X7k.png");
    }

    @Test
    public void String_241() throws Exception {
//        MockID: X7K
//        Core string: Copy {__mlm_low_results}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list 1. Login to Workfront 2. Go to Main Menu -> Goals
//        3. Click Create goal and confirm 4. Click on three dots near name -> Copy Goal

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");
        // Create new Goal
        clickToElement(driver, "//button[@data-testid='add-goal-button']");
        sendKeyToElement(driver, "//input[@data-testid='name-input']", "Test goal_" + generateRandomNumber());
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='create-new-task']");

        // Click on three dots button > Copy Goal
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//li[@data-testid='copy']");

        takeSnapShotWithHighlight(driver,"//span[@data-testid='info-icon']/preceding-sibling::span",GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\241_X7K.png");
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
    public void String_243() throws Exception {
//        MockID: X7M
//        Core string: When enabled, the results from this goal are copied to the new goal
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list 1. Login to Workfront 2. Go to Main Menu -> Goals 3. Click Create goal and confirm
//        4. On the Goals page expand created goal and add some dummy result to it. 5. Refresh details page of a created goal and mouse hover tooltip icon

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");
        // Create new Goal
        clickToElement(driver, "//button[@data-testid='add-goal-button']");
        sendKeyToElement(driver, "//input[@data-testid='name-input']", "Test goal_" + generateRandomNumber());
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='create-new-task']");

        // Open Progress indicator tab > Add New Indicator > Add result > Create
        clickToElement(driver,"//a[contains(@href,'/progress-indicators')]");
        clickToElement(driver,"//button[@data-testid='add-new-indicator-dropdown']");
        clickToElement(driver,"//li[@data-testid='option-0']");
        sendKeyToElement(driver, "//input[@id='name']", "Goal result" + generateRandomNumber());
        sendKeyToElement(driver, "//input[@id='targetValue']", "10");
        clickToElement(driver,"//button[@data-testid='create-new-task']");

        // Click on three dots button > Copy Goal
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//li[@data-testid='copy']");

        // Hover mouse on the icon
        hoverToElement(driver,"//span[@data-testid='info-icon']");
        sleepInSecond(1);

        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']",GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\243_X7M.png");

    }

    @Test
    public void String_244() throws Exception {
//        MockID: X7N
//        Core string: This goal does not have any results
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list 1. Login to Workfront 2. Go to Main Menu -> Goals 3. Click Create goal and confirm
//        4. Click on three dots near name -> Copy Goal 5. Mouse hover tooltip icon

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");
        // Create new Goal
        clickToElement(driver, "//button[@data-testid='add-goal-button']");
        sendKeyToElement(driver, "//input[@data-testid='name-input']", "Test goal_" + generateRandomNumber());
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='create-new-task']");

        // Click on three dots button > Copy Goal
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//li[@data-testid='copy']");

        // Hover mouse on the icon
        hoverToElement(driver,"//span[@data-testid='info-icon']");
        sleepInSecond(1);

        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']",GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\244_X7N.png");

    }

    @Test
    public void String_245() throws Exception {
//        MockID: X7O
//        Core string: Copy results
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//       Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list 1. Login to Workfront 2. Go to Main Menu -> Goals
//       3. Click Create goal and confirm 4. Click on three dots near name -> Copy Goal

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");
        clickToElement(driver, "//button[@data-testid='add-goal-button']");
        sendKeyToElement(driver, "//input[@data-testid='name-input']", "Test goal_" + generateRandomNumber());
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='create-new-task']");

        // Click on three dots button > Copy Goal
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//li[@data-testid='copy']");

        takeSnapShotWithHighlight(driver,"//span[@data-testid='info-icon']/preceding-sibling::span",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\245_X7O.png");
    }

    @Test
    public void String_246() throws Exception {
//        MockID: X7P
//        Core string: The copied results are assigned to their original owner by default
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//       Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list 1. Login to Workfront 2. Go to Main Menu -> Goals 3. Click Create goal and confirm
//       4. On the Goals page expand created goal and add some dummy result to it. 5. Refresh details page of a created goal and click on 'Copy results' checkbox

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");
        // Create new Goal
        clickToElement(driver, "//button[@data-testid='add-goal-button']");
        sendKeyToElement(driver, "//input[@data-testid='name-input']", "Test goal_" + generateRandomNumber());
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='create-new-task']");

        // Open Progress indicator tab > Add New Indicator > Add result > Create
        clickToElement(driver,"//a[contains(@href,'/progress-indicators')]");
        clickToElement(driver,"//button[@data-testid='add-new-indicator-dropdown']");
        clickToElement(driver,"//li[@data-testid='option-0']");
        sendKeyToElement(driver, "//input[@id='name']", "Goal result" + generateRandomNumber());
        sendKeyToElement(driver, "//input[@id='targetValue']", "10");
        clickToElement(driver,"//button[@data-testid='create-new-task']");

        // Click on three dots button > Copy Goal
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//li[@data-testid='copy']");

        // Check to Copy result
        checkToCheckboxOrRadio(driver,"//input[@id='field-shouldCopyResults']");

        takeSnapShotWithHighlight(driver, "//div[@data-testid='alert-icon-container']/following-sibling::div",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\246_X7P.png");
    }

    @Test
    public void String_247() throws Exception {
//        MockID: X7Q
//        Core string: Edit goal
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//       Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list 1. Login to Workfront 2. Go to Main Menu -> Goals
//       3. Click Create goal and confirm 4. Click on three dots near name -> Edit

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");
        // Create new Goal
        clickToElement(driver, "//button[@data-testid='add-goal-button']");
        sendKeyToElement(driver, "//input[@data-testid='name-input']", "Test goal_" + generateRandomNumber());
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='create-new-task']");

        // Click on three dots button > Copy Edit
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//li[@data-testid='edit']");

        takeSnapShotWithHighlight(driver, "//h1//div[@data-testid='name-editor-element']/div",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\247_X7Q.png");
    }

    @Test
    public void String_248() throws Exception {
//        MockID: X7R
//        Core string: Copy of {name}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//       Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list 1. Login to Workfront 2. Go to Main Menu -> Goals
//       3. Click Create goal and confirm 4. Click on three dots near name -> Copy Goal

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");
        clickToElement(driver, "//button[@data-testid='add-goal-button']");
        sendKeyToElement(driver, "//input[@data-testid='name-input']", "Test goal_" + generateRandomNumber());
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='create-new-task']");

        // Click on three dots button > Copy Goal
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//li[@data-testid='copy']");

        takeSnapShotWithHighlight(driver,"//header//div[@data-testid='name-editor-wrapper']",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\248_X7R.png");
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
    public void String_249_250_255() throws Exception {
//        MockID: X7Y,X7T, X7S
//        Core string: Delete Campaigns, You cannot recover deleted {__mlm_low_campaigns}. Are you sure you want to delete this?
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/campaigns 1. Login to Workfront 2. Go to Main Menu -> Campaigns
//        3. Create some campaigns 4. Select two and click Delete

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/campaigns");
        // Select 2 Campaigns
        checkToCheckboxOrRadio(driver,"(//div[@data-test-id='row-checkbox'])[1]");
        checkToCheckboxOrRadio(driver,"(//div[@data-test-id='row-checkbox'])[2]");

        //Click Delete button
        clickToElement(driver,"//button[@data-testid='delete']");

        takeSnapShotWithHighlight(driver,"//h1[@id='confirm-dialog-dialog-header-text']",GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\249_X7S.png");
        takeSnapShotWithHighlight(driver,"//section",GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\250_X7T.png");
        takeSnapShotWithHighlight(driver,"//h1[@id='confirm-dialog-dialog-header-text']",GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\255_X7Y.png");

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
