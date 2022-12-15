package Workfront_20220731T102854Z;

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
        waitForElementVisible(driver, "//div[@data-testid='user-page-title']");

    }

    @Test
    public void TC02_String_002_025() {
//        MockID: YAa, YAZ
//        Core string: NUMBER / Number
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting
//        3. Click New report
//        4. Drag&Drop Table block and click Edit
//        5. Click on New(field) button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas");

        //CLick New report
        waitForElementVisible(driver, "//button[@data-testid='new-report-button']");
        clickToElement(driver, "//button[@data-testid='new-report-button']");

        //Drag and Drop table block and click Edit
        waitForElementVisible(driver, "//li[@data-testid='builder-layout-table']");
        doubleClickToElement(driver,"//li[@data-testid='builder-layout-table']");
        waitForElementVisible(driver, "//button[@data-testid='empty-table-edit-icon']");
        clickToElement(driver,"//button[@data-testid='empty-table-edit-icon']");

        //Click on New(field) button
        clickToElement(driver,"(//div[@data-testid='fields-panel']//button)[1]");
        waitForElementVisible(driver, "//input[@id='configuration-search-input']");

        // Capture screenshots for string YAa
        sendKeyToElement(driver,"//input[@id='configuration-search-input']","NUMBER");
        waitForElementVisible(driver,"//li[@id='NUMBER']");
        takeSnapShotWithHighlight(driver,
                "//li[@id='NUMBER']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\002_YAa.png");

        // Capture screenshots for string YAZ
        dragAndDropHTML5ByJS(driver,"//li[@id='NUMBER']","//div[@data-testid='dropzone-canvas']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver,
                "//div[@type='formula']/div[2]/div/div[1]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\025_YAZ.png");

    }

    @Test
    public void TC03_String_003_023() {
//        003. YAb -  String
//        023. YAX - STRING
//        024. YAY - drop a field here
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting
//        3. Click New report
//        4. Drag&Drop Table block and click Edit
//        5. Click on New(field) button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas");

        //CLick New report
        waitForElementVisible(driver, "//button[@data-testid='new-report-button']");
        clickToElement(driver, "//button[@data-testid='new-report-button']");

        //Drag and Drop table block and click Edit
        waitForElementVisible(driver, "//li[@data-testid='builder-layout-table']");
        doubleClickToElement(driver,"//li[@data-testid='builder-layout-table']");
        waitForElementVisible(driver, "//button[@data-testid='empty-table-edit-icon']");
        clickToElement(driver,"//button[@data-testid='empty-table-edit-icon']");

        //Click on New(field) button
        clickToElement(driver,"(//div[@data-testid='fields-panel']//button)[1]");
        waitForElementVisible(driver, "//input[@id='configuration-search-input']");

        // Capture screenshots for string 023. YAX - STRING
        sendKeyToElement(driver,"//input[@id='configuration-search-input']","STRING");
        waitForElementVisible(driver,"//li[@id='STRING']");
        takeSnapShotWithHighlight(driver,
                "//li[@id='STRING']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\023_YAX.png");

        // Capture screenshots for string 003. YAb -  String
        dragAndDropHTML5ByJS(driver,"//li[@id='STRING']","//div[@data-testid='dropzone-canvas']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver,
                "//div[@type='formula']/div[2]/div/div[1]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\003_YAb.png");

        // Capture screenshots for string 024. YAY - drop a field here
        takeSnapShotWithHighlight(driver,
                "//div[@data-testid='node-argument-drop-zone']//span",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\024_YAY.png");

    }

    @Test
    public void TC04_String_004() {
//        MockID: YAe
//        Core string: Enable the
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/teamScheduling
//        1. Login to Workfront
//        2. Create a new project and go to Workload Balancer tab
//        3. Click on 'Show only users on this project'

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/teamScheduling");

        //Click on Show only users on this project
        waitForElementVisible(driver,"//div[@data-testid='people_workload']");
        if (isElementDisplayed(driver,"//button[@data-testid='workloadbalancer.show.project.usersPROJ']")) {
            clickToElement(driver,"//button[@data-testid='workloadbalancer.show.project.usersPROJ']");
        }

        // Capture screenshots
        takeSnapShotWithHighlight(
                driver, "//div[@data-testid='no-users-on-project-text']/following-sibling::div/span[1]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\004_YAe.png");


    }

    @Test
    public void TC05_String_005_006() {
//        MockID: YAi , YAg
//        Core string: Show only users on this {__mlm_low_project} / Show all users
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/teamScheduling
//        1. Login to Workfront
//        2. Create a new project and go to Workload Balancer tab
//        3. Mouse hover 'Show only users on this project'

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/teamScheduling");

        //Set string Show only users on this project to display first.
        waitForElementVisible(driver,"//div[@data-testid='people_workload']");
        if (!(isElementDisplayed(driver,"//button[@data-testid='workloadbalancer.show.project.usersPROJ']"))) {
        clickToElement(driver,"//button[@data-testid='workloadbalancer.show.all.usersPROJ']");
        }

        //Hover and capture Show only users on this project
        hoverToElement(driver,"//button[@data-testid='workloadbalancer.show.project.usersPROJ']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(
                driver, "//div[@data-testid='tooltip-styled']//span",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\006_YAi.png");

        //Hover and capture Show all users
        clickToElement(driver,"//button[@data-testid='workloadbalancer.show.project.usersPROJ']");
        sleepInSecond(2);
        hoverToElement(driver,"//div[@data-testid='status-widget-trigger']");
        sleepInSecond(1);
        hoverToElement(driver,"//button[@data-testid='workloadbalancer.show.all.usersPROJ']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(
                driver, "//div[@data-testid='tooltip-styled']//span",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\005_YAg.png");

    }

    @Test
    public void TC06_String_007_009() {
//        MockID: YAj / YAk
//        Core string: Current {__mlm_up_project} / Cross {__mlm_up_project}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks
//        1. Create a new project with 2 tasks
//        2. Set one task as a predecessor to another
//        3. Mouse hover predecessor icon(switch to Standart view to see this field)

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks");

        //capture screen for string Current {__mlm_up_project}
        waitForElementVisible(driver,"//button[@data-testid='Predecessor'][1]");
        hoverToElement(driver,"//button[@data-testid='Predecessor'][1]");
        sleepInSecond(2);
        takeSnapShotWithHighlight(
                driver, "(//button[contains(@data-testid,'-accordion_button')]//span)[1]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\007_YAj.png");

        //Capture screen for string Cross {__mlm_up_project}
        hoverToElement(driver,"//button[@data-testid='Predecessor'][2]");
        sleepInSecond(2);
        takeSnapShotWithHighlight(
                driver, "(//button[contains(@data-testid,'-accordion_button')]//span)[1]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\009_YAk.png");
    }

    @Test
    public void TC07_String_010_016_021() {
//        MockID: YAL / YAR / YAU
//        Core string:
//        10. YAL - Add all
//        16. YAR - Add {0} {__mlm_low_tasks}
//        21. YAU - The selected {__mlm_low_tasks} will be added and pinned to your timesheet. Consider manually selecting individual {__mlm_low_tasks} to avoid timesheet clutter.<br />Do you want to add all {__mlm_low_tasks}?
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/633d85e60003ab0036b350657e25f84c/overview
//        1. Login to Workfront
//        2. Go to Main Menu -> Timesheets
//        3. Click on Add item -> Tasks
//        4. Select all tasks and click 'add'

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/timesheet/633d85e60003ab0036b350657e25f84c/overview");

        //Click on Add item > Tasks
        waitForElementVisible(driver,"//button[@data-testid='target-button-for-dropdown']");
        clickToElement(driver,"//button[@data-testid='target-button-for-dropdown']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='option-1']");

        //Select all tasks and click add
        waitForElementVisible(driver,"//div[@data-testid='header-checkbox']");
        if (!(isElementSelected(driver,"//div[@data-testid='header-checkbox']"))){
            clickToElement(driver,"//div[@data-testid='header-checkbox']");
        }
        waitForElementClickable(driver,"//button[@data-testid='save']");
        clickToElement(driver,"//button[@data-testid='save']");
        sleepInSecond(2);

        //capture screen for string 10. YAL - Add all
        takeSnapShotWithHighlight(
                driver, "//button[@data-testid='confirm-button-add-objects-confirmation']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\010_YAL.png");

        //capture screen for string 16. YAR - Add {0} {__mlm_low_tasks}
        takeSnapShotWithHighlight(
                driver, "//section[@data-testid='add-objects-confirmation-dialog-body']//h2",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\016_YAR.png");

        //capture screen for string 21. YAU - The selected {__mlm_low_tasks} will be added and pinned to your timesheet. Consider manually selecting individual {__mlm_low_tasks} to avoid timesheet clutter.<br />Do you want to add all {__mlm_low_tasks}?
        takeSnapShotWithHighlight(
                driver, "//section[@data-testid='add-objects-confirmation-dialog-body']//div",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\021_YAU.png");

    }

    @Test
    public void TC08_String_011_12_13_14_15_17_19() {
//        MockID: , , YAp, YAq, YAr
//        Core string:
//        11. YAn - Hide groups
//        12. YAo - Add on tags
//        13. YAp - Override tags
//        14. YAq - When a card is moved to another group
//        15. YAr - None
//        17. YAs - Override assignees
//        19. YAt - Add on assignees

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/
//        1. Login to Workfront
//        2. Go to Main Menu -> Boards -> Create new
//        3. Click on Groups button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/");

        //Click to Create New button
        waitForElementVisible(driver,"//button[@data-testid='dashboard-create-board-button']");
        clickToElement(driver,"//button[@data-testid='dashboard-create-board-button']");

        //Click to Group button
        waitForElementClickable(driver,"//button[@data-testid='select-board-picker']");
        clickToElement(driver,"//div[@data-testid='group-by-button']/parent::button");
        sleepInSecond(2);

        // Capture screenshots for string 11. YAn - Hide groups
        takeSnapShotWithHighlight(
                driver, "//div[@role='radiogroup']/parent::div/parent::section/preceding-sibling::button",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\011_YAn.png");

        // Capture screenshots for string 15. YAr - None
        takeSnapShotWithHighlight(
                driver, "//input[@data-testid='group-by-NONE']/parent::label",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\015_YAr.png");

        //Select Tags
        if (!(isElementSelected(driver,"//input[@data-testid='group-by-TAGS']"))) {
            clickToElement(driver,"//input[@data-testid='group-by-TAGS']");
        }
        sleepInSecond(1);

        //Capture screenshots for string 14. YAq - When a card is moved to another group
        takeSnapShotWithHighlight(
                driver, "(//span[contains(@class,'spectrum-FieldLabel_')])[2]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\014_YAq.png");

        //Capture screenshots for string 12. YAo - Add on tags
        takeSnapShotWithHighlight(
                driver, "(//span[contains(@class,'spectrum-FieldLabel_')])[2]/following-sibling::div/label[1]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\012_YAo.png");

        //Capture screenshots for string 13. YAp - Override tags
        takeSnapShotWithHighlight(
                driver, "(//span[contains(@class,'spectrum-FieldLabel_')])[2]/following-sibling::div/label[2]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\012_YAo.png");

        //Select Assignees
        if (!(isElementSelected(driver,"//input[@data-testid='group-by-ASSIGNMENT']"))) {
            clickToElement(driver,"//input[@data-testid='group-by-ASSIGNMENT']");
        }
        sleepInSecond(1);
        //Capture screenshots for string 19. YAt - Add on assignees
        takeSnapShotWithHighlight(
                driver, "(//span[contains(@class,'spectrum-FieldLabel_')])[2]/following-sibling::div/label[1]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\019_YAt.png");

        //Capture screenshots for string 17. YAs - Override assignees
        takeSnapShotWithHighlight(
                driver, "(//span[contains(@class,'spectrum-FieldLabel_')])[2]/following-sibling::div/label[2]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\017_YAs.png");

    }

    @Test
    public void TC09_String_018_020() {
//        Core string:
//        18. YAS - The selected {__mlm_low_issues} will be added and pinned to your timesheet. Consider manually selecting individual {__mlm_low_issues} to avoid timesheet clutter.<br /> Do you want to add all {__mlm_low_issues}?
//        20. YAT - Add {0} {__mlm_low_issues}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/633d85e60003ab0036b350657e25f84c/overview
//        1. Login to Workfront
//        2. Go to Main Menu -> Timesheets
//        3. Click on Add item -> Issues
//        4. Select all Issues and click 'add'

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/timesheet/633d85e60003ab0036b350657e25f84c/overview");

        //Click on Add item > Issues
        waitForElementVisible(driver,"//button[@data-testid='target-button-for-dropdown']");
        clickToElement(driver,"//button[@data-testid='target-button-for-dropdown']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='option-2']");

        //Select all tasks and click add
        waitForElementVisible(driver,"//div[@data-testid='header-checkbox']");
        if (!(isElementSelected(driver,"//div[@data-testid='header-checkbox']"))){
            clickToElement(driver,"//div[@data-testid='header-checkbox']");
        }
        waitForElementClickable(driver,"//button[@data-testid='save']");
        clickToElement(driver,"//button[@data-testid='save']");
        sleepInSecond(2);


        //capture screen for string 20. YAT - Add {0} {__mlm_low_issues}
        takeSnapShotWithHighlight(
                driver, "//section[@data-testid='add-objects-confirmation-dialog-body']//h2",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\020_YAT.png");

        //capture screen for string 18. YAS - The selected {__mlm_low_issues} will be added and pinned to your timesheet. Consider manually selecting individual {__mlm_low_issues} to avoid timesheet clutter.<br /> Do you want to add all {__mlm_low_issues}?
        takeSnapShotWithHighlight(
                driver, "//section[@data-testid='add-objects-confirmation-dialog-body']//div",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\018_YAS.png");

    }

    @Test
    public void TC10_String_22() {
//        Core string:
//        22. YAV - Add {0} {__mlm_low_projects}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/633d85e60003ab0036b350657e25f84c/overview
//        1. Login to Workfront
//        2. Go to Main Menu -> Timesheets
//        3. Click on Add item -> Issues
//        4. Select all Issues and click 'add'

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/timesheet/633d85e60003ab0036b350657e25f84c/overview");

        //Click on Add item > Projects
        waitForElementVisible(driver,"//button[@data-testid='target-button-for-dropdown']");
        clickToElement(driver,"//button[@data-testid='target-button-for-dropdown']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='option-0']");

        //Select all tasks and click add
        waitForElementVisible(driver,"//div[@data-testid='header-checkbox']");
        if (!(isElementSelected(driver,"//div[@data-testid='header-checkbox']"))){
            clickToElement(driver,"//div[@data-testid='header-checkbox']");
        }
        waitForElementClickable(driver,"//button[@data-testid='save']");
        clickToElement(driver,"//button[@data-testid='save']");
        sleepInSecond(2);


        //capture screen for string 22. YAV - Add {0} {__mlm_low_projects}
        takeSnapShotWithHighlight(
                driver, "//section[@data-testid='add-objects-confirmation-dialog-body']//h2",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\022_YAV.png");


    }

    @Test
    public void TC11_String_001_008() throws Exception {
//        Core string:
//        001. Xpq- Start typing to search for projects
//        008. YAJ - Search for projects
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/
//        1. Login to Workfront
//        2. Go to Main Menu -> Boards -> Create new
//        3. Click Add card -> Connected card
//        4. Click on All tab

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/");

        //Click to Create New button
        waitForElementVisible(driver,"(//div[@data-testid='dashboard-board-container']//button)[1]");
        clickToElement(driver,"//button[@data-testid='dashboard-create-board-button']");

        //Click to Add card > Connected card
        waitForElementVisible(driver,"//h3[@class='two-line-truncate']");
        clickToElement(driver,"//button[@data-testid='add-card-button']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-key='workfront']");

        //Click to All tab
        waitForElementVisible(driver,"//div[contains(@class,'flex-container')]//button[contains(@class,'spectrum-ActionButton')][3]");
        clickToElement(driver,"//div[contains(@class,'flex-container')]//button[contains(@class,'spectrum-ActionButton')][3]");

        // Capture screenshots for string 001. Xpq- Start typing to search for projects
        sleepInSecond(2);
        takeSnapShotWithHighlight(
                driver, "//h3[contains(@class,'spectrum-IllustratedMessage')]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\001_Xpq.png");

        //Capture screenshots for string 008. YAJ - Search for projects
        inspectElement(driver,"//div[contains(@class,'spectrum-Search_')]/input");
        captureScreen(GlobalConstants.SCREENSHOTS + "\\Workfront_20220731T102854Z\\ENU\\008_YAJ.png");

    }




    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

}
