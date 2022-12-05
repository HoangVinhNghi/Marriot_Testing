package Workfront_20220905T112238Z_P2;

import common.AbstractPage;
import common.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ENU extends AbstractPage {
    WebDriver driver;
    Actions action;
    WebDriverWait explicitWait;

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
//        MockID: Xpa
//        Core string: Cards
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/633eb9cd5fa223ee5112728b
//        1. Login to Workfront
//        2. Go to Main Menu -> Boards
//        3. Create a new board
//        4. Click Configure and enable 'Automatically remove cards from the board' trigger

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/633eb9cd5fa223ee5112728b");

        waitForElementVisible(driver,"//div[@data-testid='board-configure-button']//button");
        clickToElement(driver,"//div[@data-testid='board-configure-button']//button");
        waitForElementVisible(driver,"//div[@data-testid='configure-board-accordion-card']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='configure-board-accordion-card']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\01_Xpa.png");
    }

    @Test
    public void String_002() {
//        MockID: XRX
//        Core string: installation status
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/blueprints
//        1. Login to Workfront
//        2. Go to Main Menu -> Blueprints
//        3. Expand filters panel

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/blueprints");

        waitForElementVisible(driver,"//div[@data-testid='filter-panel-layout']//h2");
        sleepInSecond(1);
        scrollToElement(driver,"//div[@id='installationStatus']//button");
        takeSnapShotWithHighlight(driver, "//div[@id='installationStatus']//button",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\02_XRX.png");
    }

    @Test
    public void String_003() {
//        MockID: Xsv
//        Core string: type
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/blueprints
//        1. Login to Workfront
//        2. Go to Main Menu -> Blueprints
//        3. Expand filters panel

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/blueprints");

        waitForElementVisible(driver,"//div[@data-testid='filter-panel-layout']//h2");
        sleepInSecond(1);
        scrollToElement(driver,"//div[@id='blueprintTypes']//button");
        takeSnapShotWithHighlight(driver, "//div[@id='blueprintTypes']//button",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\03_Xsv.png");
    }

    @Test
    public void String_004() {
//        MockID: YB/
//        Core string: Create {__mlm_low_activity}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list
//        1. Login to Workfront
//        2. Go to Main Menu -> Goals
//        3. Click Create goal and confirm
//        4. Switch to Progress Indicators tab
//        5. Click on 'New progress indicator' button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");

        // Click to new goal
        waitForElementVisible(driver,"//button[@data-testid='add-goal-button']");
        clickToElement(driver,"//button[@data-testid='add-goal-button']");

        // creating a new goal
        waitForElementVisible(driver,"//input[@data-testid='name-input']");
        sendKeyToElement(driver,"//input[@data-testid='name-input']","Test goal_" + generateRandomNumber());
        clickToElement(driver,"//button[@data-testid='create-new-task']");

        // Switch to Progress Indicators tab
        waitForElementVisible(driver,"//div[@data-testid='navitem-progress-indicators ']");
        clickToElement(driver,"//div[@data-testid='navitem-progress-indicators ']");

        //Click on 'New progress indicator' button
        waitForElementVisible(driver,"//button[@data-testid='add-new-indicator-dropdown']");
        clickToElement(driver,"//button[@data-testid='add-new-indicator-dropdown']");


        // Take screenshots
        waitForElementVisible(driver,"//li[@data-testid='option-1']");
        takeSnapShotWithHighlight(driver,"//li[@data-testid='option-1']",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220905T112238Z_P2\\ENU\\04_YB-.png");

        // Delete this goal
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='delete']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='confirm-button-confirm-dialog']");
    }

    @Test
    public void String_005() {
//        MockID: YB+
//        Core string: Add existing {__mlm_low_project}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list
//        1. Login to Workfront
//        2. Go to Main Menu -> Goals
//        3. Click Create goal and confirm
//        4. Switch to Progress Indicators tab
//        5. Click on 'New progress indicator' button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");

        // Click to new goal
        waitForElementVisible(driver,"//button[@data-testid='add-goal-button']");
        clickToElement(driver,"//button[@data-testid='add-goal-button']");

        // creating a new goal
        waitForElementVisible(driver,"//input[@data-testid='name-input']");
        sendKeyToElement(driver,"//input[@data-testid='name-input']","Test goal_" + generateRandomNumber());
        clickToElement(driver,"//button[@data-testid='create-new-task']");

        // Switch to Progress Indicators tab
        waitForElementVisible(driver,"//div[@data-testid='navitem-progress-indicators ']");
        clickToElement(driver,"//div[@data-testid='navitem-progress-indicators ']");

        //Click on 'New progress indicator' button
        waitForElementVisible(driver,"//button[@data-testid='add-new-indicator-dropdown']");
        clickToElement(driver,"//button[@data-testid='add-new-indicator-dropdown']");


        // Take screenshots
        waitForElementVisible(driver,"//li[@data-testid='option-2']");
        takeSnapShotWithHighlight(driver,"//li[@data-testid='option-2']",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220905T112238Z_P2\\ENU\\05_YB+.png");

        // Delete this goal
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='delete']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='confirm-button-confirm-dialog']");
    }

    @Test
    public void String_006() {
//        MockID: YC0
//        Core string: Save
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/633eb9cd5fa223ee5112728b
//        1. Login to Workfront
//        2. Go to Main Menu -> Boards
//        3. Create a new board
//        4. Click Configure and enable 'Automatically remove cards from the board' trigger
//        5. In the dropdown field select any Column

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/633eb9cd5fa223ee5112728b");

        //Click Configure button
        waitForElementVisible(driver,"//div[@data-testid='board-configure-button']//button");
        clickToElement(driver,"//div[@data-testid='board-configure-button']//button");

        //Click on Cards
        waitForElementVisible(driver,"//div[@data-testid='configure-board-accordion-card']");
        clickToElement(driver,"//div[@data-testid='configure-board-accordion-card']");

        // Enable "Automatically archive cards from the board
        waitForElementVisible(driver,"//input[@data-testid='card-falloff-switch']");
        if (!(isElementSelected(driver,"//input[@data-testid='card-falloff-switch']"))) {
            clickToElement(driver,"//input[@data-testid='card-falloff-switch']");
        }

        // Select any column in "In column" field
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='card-falloff-column']");
        sleepInSecond(1);
        clickToElement(driver,"(//div[@role='option'])[1]");

        //Take screenshots
        waitForElementVisible(driver,"//button[@data-testid='save-card-falloff-button']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//button[@data-testid='save-card-falloff-button']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\06_YC0.png");
    }

    @Test
    public void String_007() {
//        MockID: YC4
//        Core string: Assign to me
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/633eb9cd5fa223ee5112728b
//         1. Login to Workfront
//         2. Go to Main Menu -> Boards
//         3. Create a new board
//         4. Add a new card and open its details
//         5. Click on assignee field and enter 'a'

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/633eb9cd5fa223ee5112728b");

        //Add a new card
        waitForElementVisible(driver,"//button[@data-testid='add-card-button']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='add-card-button']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-key='details']");

        //enter 'a' on Assignee field
        waitForElementVisible(driver,"//div[@data-testid='assignee-search-combobox']//input[@data-testid='combobox-input']");
        sleepInSecond(1);
        removeAttributeInDOM(driver,"//div[@data-testid='assignee-search-combobox']//input[@data-testid='combobox-input']","disabled");
        sleepInSecond(1);
        sendKeyToElement(driver,"//div[@data-testid='assignee-search-combobox']//input[@data-testid='combobox-input']","a");

        //Take screenshots
        waitForElementVisible(driver,"//div[@data-testid='select-box']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='select-box']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\07_YC4.png");
    }

    @Test
    public void String_008() {
//        MockID: YC5
//        Core string: Not connected
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/633eb9cd5fa223ee5112728b
//        1. Login to Workfront
//        2. Go to Main Menu -> Boards
//        3. Create a new board
//        4. Click Add card -> Connected and add a new card
//        5. Open filters panel

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/633eb9cd5fa223ee5112728b");

        //click on filter button
        waitForElementVisible(driver,"(//div[@data-testid='board-rail-controls']//button)[1]");
        sleepInSecond(1);
        clickToElement(driver,"(//div[@data-testid='board-rail-controls']//button)[1]");

        //Take screenshots
        waitForElementVisible(driver,"//div[@data-testid='filter-group-heading-members']");
        sleepInSecond(1);
        scrollToElement(driver,"//span[@title='Not connected']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//span[@title='Not connected']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\08_YC5.png");
    }

    @Test
    public void String_009() {
//        MockID: YC6
//        Core string: Tagged
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/633eb9cd5fa223ee5112728b
//         1. Login to Workfront
//         2. Go to Main Menu -> Boards
//         3. Create a new board
//         4. Click Group -> by tags

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/633eb9cd5fa223ee5112728b");

        //click on group button
        waitForElementVisible(driver,"(//div[@data-testid='board-rail-controls']//button)[2]");
        sleepInSecond(1);
        clickToElement(driver,"(//div[@data-testid='board-rail-controls']//button)[2]");

        //Select Tags
        waitForElementVisible(driver,"//input[@data-testid='group-by-TAGS']");
        sleepInSecond(1);
        if (!(isElementSelected(driver,"//input[@data-testid='group-by-TAGS']"))) {
            clickToElement(driver,"//input[@data-testid='group-by-TAGS']");
        }

        //Take screenshots
        waitForElementVisible(driver,"//div[@data-testid='group-by-tittle']/div[1]");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='group-by-tittle']/div[1]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\09_YC6.png");
    }

    @Test
    public void String_010() {
//        MockID: YC7
//        Core string: Assigned to
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/633eb9cd5fa223ee5112728b
//         1. Login to Workfront
//         2. Go to Main Menu -> Boards
//         3. Create a new board
//         4. Click Group -> by assignees

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/633eb9cd5fa223ee5112728b");

        //click on group button
        waitForElementVisible(driver,"(//div[@data-testid='board-rail-controls']//button)[2]");
        sleepInSecond(1);
        clickToElement(driver,"(//div[@data-testid='board-rail-controls']//button)[2]");

        //Select Tags
        waitForElementVisible(driver,"//input[@data-testid='group-by-ASSIGNMENT']");
        sleepInSecond(1);
        if (!(isElementSelected(driver,"//input[@data-testid='group-by-ASSIGNMENT']"))) {
            clickToElement(driver,"//input[@data-testid='group-by-ASSIGNMENT']");
        }

        //Take screenshots
        waitForElementVisible(driver,"//div[@data-testid='group-by-tittle']/div[1]");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='group-by-tittle']/div[1]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\10_YC7.png");
    }

    @Test
    public void String_011() {
//        MockID: YC8
//        Core string: Remove me
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/
//         1. Login to Workfront
//         2. Go to Main Menu -> Boards
//         3. Create a new board
//         4. Add a new card and open its details
//         5. Click on assignee field and enter 'a'
//         6. Select 'Assign to me'
//         7. Repeat step 5

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/");

        //Click on create new
        waitForElementVisible(driver,"//button[@data-testid='dashboard-create-board-button']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='dashboard-create-board-button']");

        //CLick to Add card > New card
        waitForElementVisible(driver,"//button[@data-testid='add-card-button']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='add-card-button']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-key='details']");

        //Select Assign to me
        waitForElementVisible(driver,"//div[@data-testid='assignee-search-combobox']//button[@data-testid='combobox-button']");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='assignee-search-combobox']//button[@data-testid='combobox-button']");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='select-box']");


        //Take screenshots
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='select-box']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\11_YC8.png");

        //Close Card detail box
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='close-card-details-button']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='close-card-details-button']");

        //Delete created board
        sleepInSecond(2);
        clickToElement(driver,"//button[@data-testid='board-menu-button']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-key='delete']");
        waitForElementVisible(driver,"//div[@data-testid='modal']//button[@data-variant='accent']");
        clickToElement(driver,"//div[@data-testid='modal']//button[@data-variant='accent']");

    }

    @Test
    public void String_012() {
//        MockID: YC9
//        Core string: Group by
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/
//        1. Login to Workfront
//        2. Go to Main Menu -> Boards and create a new board
//        3. Click on Group button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/");

        //Click on create new
        waitForElementVisible(driver,"//button[@data-testid='dashboard-create-board-button']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='dashboard-create-board-button']");

        //click on group button
        waitForElementVisible(driver,"(//div[@data-testid='board-rail-controls']//button)[2]");
        sleepInSecond(1);
        clickToElement(driver,"(//div[@data-testid='board-rail-controls']//button)[2]");


        //Take screenshots
        waitForElementVisible(driver,"//input[@data-testid='group-by-ASSIGNMENT']/ancestor::div[@role='radiogroup']/preceding-sibling::span");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//input[@data-testid='group-by-ASSIGNMENT']/ancestor::div[@role='radiogroup']/preceding-sibling::span",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\12_YC9.png");

        //Delete created board
        sleepInSecond(2);
        clickToElement(driver,"//button[@data-testid='board-menu-button']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-key='delete']");
        waitForElementVisible(driver,"//div[@data-testid='modal']//button[@data-variant='accent']");
        clickToElement(driver,"//div[@data-testid='modal']//button[@data-variant='accent']");
    }

    @Test
    public void String_013() {
//        MockID: YCa
//        Core string: Work records
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/home
//        1. Login to Workfront
//        2. Click on Main Menu

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/home");

        //Click on Main Menu
        waitForElementVisible(driver,"//button[@data-testid='global-nav-drawer-toggle']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='global-nav-drawer-toggle']");

        //Take screenshots
        waitForElementVisible(driver,"//a[@data-testid='workrecords.plural']/span");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//a[@data-testid='workrecords.plural']/span",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\13_YCa.png");

    }

    @Test
    public void String_014() {
//        MockID: YCA
//        Core string: {__mlm_up_activity}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list
//        1. Login to Workfront
//        2. Go to Main Menu -> Goals
//        3. Click Create goal and confirm
//        4. Switch to Progress Indicators tab
//        5. Click on 'New progress indicator' button
//        6. Click on 'Add activity' and create new activity

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");

        // Click to new goal
        waitForElementVisible(driver,"//button[@data-testid='add-goal-button']");
        clickToElement(driver,"//button[@data-testid='add-goal-button']");

        // creating a new goal
        waitForElementVisible(driver,"//input[@data-testid='name-input']");
        sendKeyToElement(driver,"//input[@data-testid='name-input']","Test goal_" + generateRandomNumber());
        clickToElement(driver,"//button[@data-testid='create-new-task']");

        // Switch to Progress Indicators tab
        waitForElementVisible(driver,"//div[@data-testid='navitem-progress-indicators ']");
        clickToElement(driver,"//div[@data-testid='navitem-progress-indicators ']");

        //Click on 'New progress indicator' button > Create activity
        waitForElementVisible(driver,"//button[@data-testid='add-new-indicator-dropdown']");
        clickToElement(driver,"//button[@data-testid='add-new-indicator-dropdown']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='option-1']");

        //Creating a new activity
        waitForElementVisible(driver,"//input[@data-testid='name-input']");
        sleepInSecond(1);
        sendKeyToElement(driver,"//input[@data-testid='name-input']","1");
        clickToElement(driver,"//button[@data-testid='create-new-task']");


        // Take screenshots
        waitForElementVisible(driver,"(//div[@data-testid='BodyInnerCell'])[3]");
        takeSnapShotWithHighlight(driver,"(//div[@data-testid='BodyInnerCell'])[3]",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220905T112238Z_P2\\ENU\\14_YCA.png");

        // Delete this goal
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='delete']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='confirm-button-confirm-dialog']");
    }

    @Test
    public void String_015() {
//        MockID: YCB
//        Core string: Add the following {__mlm_low_projects} to the {0} {__mlm_low_goal}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list
//        1. Login to Workfront
//        2. Go to Main Menu -> Goals
//        3. Click Create goal and confirm
//        4. Switch to Progress Indicators tab
//        5. Click on 'New progress indicator' button
//        6. Click on 'Add existing proect'

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");

        // Click to new goal
        waitForElementVisible(driver,"//button[@data-testid='add-goal-button']");
        clickToElement(driver,"//button[@data-testid='add-goal-button']");

        // creating a new goal
        waitForElementVisible(driver,"//input[@data-testid='name-input']");
        sendKeyToElement(driver,"//input[@data-testid='name-input']","Test goal_" + generateRandomNumber());
        clickToElement(driver,"//button[@data-testid='create-new-task']");

        // Switch to Progress Indicators tab
        waitForElementVisible(driver,"//div[@data-testid='navitem-progress-indicators ']");
        clickToElement(driver,"//div[@data-testid='navitem-progress-indicators ']");

        //Click on 'New progress indicator' button > Add existing proect
        waitForElementVisible(driver,"//button[@data-testid='add-new-indicator-dropdown']");
        clickToElement(driver,"//button[@data-testid='add-new-indicator-dropdown']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='option-2']");

        // Take screenshots
        waitForElementVisible(driver,"//div[@data-testid='sliding-pane-header']/span");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='sliding-pane-header']/span",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20220905T112238Z_P2\\ENU\\15_YCB.png");

        // Closed add project window
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='close-dialog']");

        // Delete this goal
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='delete']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='confirm-button-confirm-dialog']");
    }

    @Test
    public void String_016() {
//        MockID: YCc
//        Core string: Work record templates
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/home
//        1. Login to Workfront
//        2. Click on Main Menu

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/home");

        //Click on Main Menu
        waitForElementVisible(driver,"//button[@data-testid='global-nav-drawer-toggle']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='global-nav-drawer-toggle']");

        //Take screenshots
        waitForElementVisible(driver,"//a[@data-testid='workrecord.templates.plural']/span");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//a[@data-testid='workrecord.templates.plural']/span",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\16_YCc.png");

    }

    @Test
    public void String_017() {
//        MockID: YCd
//        Core string: Marketing calendar
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/home
//        1. Login to Workfront
//        2. Click on Main Menu

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/home");

        //Click on Main Menu
        waitForElementVisible(driver,"//button[@data-testid='global-nav-drawer-toggle']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='global-nav-drawer-toggle']");

        //Take screenshots
        waitForElementVisible(driver,"//a[@data-testid='marketing.calendar']/span");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//a[@data-testid='marketing.calendar']/span",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\17_YCd.png");

    }

    @Test
    public void String_018() {
//        MockID: YCe
//        Core string: Projects
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/633eb9cd5fa223ee5112728b
//        1. Login to Workfront
//        2. Go to Main Menu -> Boards
//        3. Create a new board
//        4. Click Add card -> Connected

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/");

        //Click on create new
        waitForElementVisible(driver,"//button[@data-testid='dashboard-create-board-button']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='dashboard-create-board-button']");

        //CLick to Add card > Connected Card
        waitForElementVisible(driver,"//button[@data-testid='add-card-button']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='add-card-button']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-key='workfront']");

        //Take screenshots
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//li[contains(@class,'spectrum-Breadcrumbs-item_')]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\18_YCe.png");

        //Close search box
        sleepInSecond(1);
        clickToElement(driver,"//button[contains(@class,'spectrum-ButtonGroup-Button_')][1]");

        //Delete created board
        sleepInSecond(2);
        clickToElement(driver,"//button[@data-testid='board-menu-button']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-key='delete']");
        waitForElementVisible(driver,"//div[@data-testid='modal']//button[@data-variant='accent']");
        clickToElement(driver,"//div[@data-testid='modal']//button[@data-variant='accent']");
    }

    @Test
    public void String_019() {
//        MockID: YCf
//        Core string: Disable
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/
//        1. Login to Workfront
//        2. Go to Main Menu -> Boards
//        3. Click on 'Enable Early Feature Opt-in' button
//        4 Click Enable

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/");

        //Click on Feature Otp-in
        waitForElementVisible(driver,"//div[@data-testid='header']//button[1]");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='header']//button[1]");
        waitForElementVisible(driver,"//section[contains(@class,'spectrum-Dialog-content_')]");
        sleepInSecond(1);

        //Make the Disable button available
        if (!(isElementDisplayed(driver,"//div[@data-testid='modal']//*[local-name()='svg' and contains(@style,'color')]"))) {
            clickToElement(driver,"//div[@data-testid='modal']//button[@data-variant='accent']");
            sleepInSecond(10);
            clickToElement(driver,"//div[@data-testid='header']//button[1]");
        }

        //Take screenshots
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='modal']//button[@data-variant='accent']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\19_YCf.png");

    }

    @Test
    public void String_020() {
//        MockID: YCg
//        Core string: Enable
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/
//        1. Login to Workfront
//        2. Go to Main Menu -> Boards
//        3. Click on 'Enable Early Feature Opt-in' button
//        4 Click Enable

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/");

        //Click on Feature Otp-in
        waitForElementVisible(driver,"//div[@data-testid='header']//button[1]");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='header']//button[1]");
        waitForElementVisible(driver,"//section[contains(@class,'spectrum-Dialog-content_')]");
        sleepInSecond(1);

        //Make the Enable button available
        if ((isElementDisplayed(driver,"//div[@data-testid='modal']//*[local-name()='svg' and contains(@style,'color')]"))) {
            clickToElement(driver,"//div[@data-testid='modal']//button[@data-variant='accent']");
            sleepInSecond(10);
            clickToElement(driver,"//div[@data-testid='header']//button[1]");
        }

        //Take screenshots
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='modal']//button[@data-variant='accent']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\20_YCg.png");

    }

    @Test
    public void String_021() {
//        MockID: YCi
//        Core string: Supported file formats: GIF, JPG, JPEG, PNG, SVG
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/oauth2-apps/633eb136f10e5831b770b795
//        Steps:
//        1. Go to Workfront
//        2. Go to Setup > System > OAuth2 Applications > Create/Edit Single Page Web Application

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/setup/oauth2-apps");

        // Check if max New OAuth2 application items > delete one
        waitForElementInvisible(driver,"//div[@data-testid='spinner']");
        sleepInSecond(3);
        List<WebElement> listOauth2Items = getElements(driver,"//div[contains(@class,'mdc-layout-grid__inner')]");
        System.out.println(listOauth2Items.size());
        if (listOauth2Items.size()==11) {
            hoverToElement(driver,"(//div[contains(@class,'mdc-layout-grid__inner')])[2]");
            sleepInSecond(2);
            clickToElement(driver,"(//div[contains(@class,'mdc-layout-grid__inner')])[2]/div[5]/div/button");
            sleepInSecond(1);
            clickToElement(driver,"//footer[@data-testid='dialog-dialog-footer']/button[1]");
        }

        // Create New OAuth2 application with Single Page Web Application
        clickToElement(driver, "//button[@data-testid='create-button']");
        waitForElementVisible(driver,"//div[@data-testid='authorization-method-section']/fieldset/div[2]//span/span");
        clickToElement(driver,"//input[@data-testid='authorization-code-flow-pkce-radio-button']");
        sendKeyToElement(driver, "//input[@data-testid='phoenix-input-name']", "test_" + generateRandomNumber());
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='create-submit-button']");

        //Take screenshot
        waitForElementVisible(driver,"//div[@data-testid='redirect-uri-section']");
        sleepInSecond(1);
        scrollToElement(driver,"//div[@data-testid='logo-upload-section']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='logo-upload-section']//span[4]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\21_YCi.png");

    }

    @Test
    public void String_022() {
//        MockID: YCj
//        Core string: This displays a logo of your app.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/oauth2-apps/633eb136f10e5831b770b795
//        Steps:
//        1. Go to Workfront
//        2. Go to Setup > System > OAuth2 Applications > Create/Edit Single Page Web Application

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/setup/oauth2-apps");

        // Check if max New OAuth2 application items > delete one
        waitForElementInvisible(driver,"//div[@data-testid='spinner']");
        sleepInSecond(3);
        List<WebElement> listOauth2Items = getElements(driver,"//div[contains(@class,'mdc-layout-grid__inner')]");
        System.out.println(listOauth2Items.size());
        if (listOauth2Items.size()==11) {
            hoverToElement(driver,"(//div[contains(@class,'mdc-layout-grid__inner')])[2]");
            sleepInSecond(2);
            clickToElement(driver,"(//div[contains(@class,'mdc-layout-grid__inner')])[2]/div[5]/div/button");
            sleepInSecond(1);
            clickToElement(driver,"//footer[@data-testid='dialog-dialog-footer']/button[1]");
        }

        // Create New OAuth2 application with Single Page Web Application
        clickToElement(driver, "//button[@data-testid='create-button']");
        waitForElementVisible(driver,"//div[@data-testid='authorization-method-section']/fieldset/div[2]//span/span");
        clickToElement(driver,"//input[@data-testid='authorization-code-flow-pkce-radio-button']");
        sendKeyToElement(driver, "//input[@data-testid='phoenix-input-name']", "test_" + generateRandomNumber());
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='create-submit-button']");

        //Take screenshot
        waitForElementVisible(driver,"//div[@data-testid='redirect-uri-section']");
        sleepInSecond(1);
        scrollToElement(driver,"//div[@data-testid='logo-upload-section']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='logo-upload-section']//span[1]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\22_YCj.png");

    }

    @Test
    public void String_023() {
//        MockID: YCJ
//        Core string: Card Falloff
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/633eb9cd5fa223ee5112728b
//        1. Login to Workfront
//        2. Go to Main Menu -> Boards
//        3. Create a new board
//        4. Click Configure and enable 'Automatically remove cards from the board' trigger

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/");

        //Click on create new
        waitForElementVisible(driver,"//button[@data-testid='dashboard-create-board-button']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='dashboard-create-board-button']");

        //CLick to Configure
        waitForElementVisible(driver,"//div[@data-testid='board-configure-button']//button");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='board-configure-button']//button");

        //CLick to Cards
        waitForElementVisible(driver,"//div[@data-testid='configure-board-accordion-card']");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='configure-board-accordion-card']");

        //Take screenshots
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='configure-board-accordion-card']/following-sibling::div",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\23_YCJ.png");

        //Delete created board
        sleepInSecond(2);
        clickToElement(driver,"//button[@data-testid='board-menu-button']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-key='delete']");
        waitForElementVisible(driver,"//div[@data-testid='modal']//button[@data-variant='accent']");
        clickToElement(driver,"//div[@data-testid='modal']//button[@data-variant='accent']");
    }

    @Test
    public void String_024() {
//        MockID: YCk
//        Core string: You need to add code in your client app to generate the code verifier and code challenge
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/oauth2-apps/633eb136f10e5831b770b795
//        Steps:
//        1. Go to Workfront
//        2. Go to Setup > System > OAuth2 Applications > Create/Edit Single Page Web Application

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/setup/oauth2-apps");

        // Check if max New OAuth2 application items > delete one
        waitForElementInvisible(driver,"//div[@data-testid='spinner']");
        sleepInSecond(3);
        List<WebElement> listOauth2Items = getElements(driver,"//div[contains(@class,'mdc-layout-grid__inner')]");
        System.out.println(listOauth2Items.size());
        if (listOauth2Items.size()==11) {
            hoverToElement(driver,"(//div[contains(@class,'mdc-layout-grid__inner')])[2]");
            sleepInSecond(2);
            clickToElement(driver,"(//div[contains(@class,'mdc-layout-grid__inner')])[2]/div[5]/div/button");
            sleepInSecond(1);
            clickToElement(driver,"//footer[@data-testid='dialog-dialog-footer']/button[1]");
        }

        // Create New OAuth2 application with Single Page Web Application
        clickToElement(driver, "//button[@data-testid='create-button']");
        waitForElementVisible(driver,"//div[@data-testid='authorization-method-section']/fieldset/div[2]//span/span");
        clickToElement(driver,"//input[@data-testid='authorization-code-flow-pkce-radio-button']");
        sendKeyToElement(driver, "//input[@data-testid='phoenix-input-name']", "test_" + generateRandomNumber());
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='create-submit-button']");

        //Take screenshot
        waitForElementVisible(driver,"//div[@data-testid='redirect-uri-section']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='redirect-uri-section']/preceding-sibling::div[1]/div/span[2]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\24_YCk.png");

    }

    @Test
    public void String_025() {
//        MockID: YCK
//        Core string: In column
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/633eb9cd5fa223ee5112728b
//        1. Login to Workfront
//        2. Go to Main Menu -> Boards
//        3. Create a new board
//        4. Click Configure and enable 'Automatically remove cards from the board' trigger

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/");

        //Click on create new
        waitForElementVisible(driver,"//button[@data-testid='dashboard-create-board-button']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='dashboard-create-board-button']");

        //CLick to Configure
        waitForElementVisible(driver,"//div[@data-testid='board-configure-button']//button");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='board-configure-button']//button");

        //CLick to Cards
        waitForElementVisible(driver,"//div[@data-testid='configure-board-accordion-card']");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='configure-board-accordion-card']");

        //Enable Automatically archive cards from the board
        waitForElementVisible(driver,"//input[@data-testid='card-falloff-switch']");
        sleepInSecond(1);
        clickToElement(driver,"//input[@data-testid='card-falloff-switch']");

        //Take screenshots
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "(//div[@data-testid='configure-board-accordion-card']/following-sibling::div//span[contains(@class,'spectrum-FieldLabel_')])[2]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220905T112238Z_P2\\ENU\\25_YCK.png");

        //Delete created board
        sleepInSecond(2);
        clickToElement(driver,"//button[@data-testid='board-menu-button']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-key='delete']");
        waitForElementVisible(driver,"//div[@data-testid='modal']//button[@data-variant='accent']");
        clickToElement(driver,"//div[@data-testid='modal']//button[@data-variant='accent']");
    }



    @AfterClass(alwaysRun = true)
    public void afterClass() {

        driver.quit();
    }

}
