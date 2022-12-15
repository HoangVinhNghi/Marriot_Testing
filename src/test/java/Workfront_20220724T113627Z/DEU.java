package Workfront_20220724T113627Z;

import common.AbstractPage;
import common.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DEU extends AbstractPage {
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Set language
        options.addArguments("--lang=de");

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
    public void TC_001_String_002() {
//        MockID: X/a
//        Core string: Document
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting -> New Report
//        3. Add table block and press Edit
//        4. In the field sidebar click on All objects dropdown

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit");

        waitForElementVisible(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        clickToElement(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//li[@data-testid='all-objects-document']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\02_X-a.png");

    }

    @Test
    public void TC_002_String_004() {
//        MockID: X/b
//        Core string: Expense
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting -> New Report
//        3. Add table block and press Edit
//        4. In the field sidebar click on All objects dropdown

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit");

        waitForElementVisible(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        clickToElement(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//li[@data-testid='all-objects-expense']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\04_X-b.png");

    }

    @Test
    public void TC_003_String_030() {
//        MockID: X/Z
//        Core string: Assignment
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting -> New Report
//        3. Add table block and press Edit
//        4. In the field sidebar click on All objects dropdown

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit");

        waitForElementVisible(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        clickToElement(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//li[@data-testid='all-objects-assignment']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\030_X-Z.png");

    }

    @Test
    public void TC_004_String_027() {
//        MockID: X/R
//        Core string: Assignment
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting -> New Report
//        3. Add table block and press Edit
//        4. In the field sidebar click on All objects dropdown

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit");

        waitForElementVisible(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        clickToElement(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//li[@data-testid='all-objects-all']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\027_X-R.png");

    }

    @Test
    public void TC_005_String_006() {
//        MockID: X/c
//        Core string: Document Approval
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting -> New Report
//        3. Add table block and press Edit
//        4. In the field sidebar click on All objects dropdown

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit");

        waitForElementVisible(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        clickToElement(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//li[@data-testid='all-objects-documentApproval']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\006_X-c.png");

    }

    @Test
    public void TC_006_String_008() {
//        MockID: X/d
//        Core string: Hour
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting -> New Report
//        3. Add table block and press Edit
//        4. In the field sidebar click on All objects dropdown

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit");

        waitForElementVisible(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        clickToElement(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//li[@data-testid='all-objects-hour']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\008_X-d.png");

    }

    @Test
    public void TC_007_String_009() {
//        MockID: X/e
//        Core string: Timesheet
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting -> New Report
//        3. Add table block and press Edit
//        4. In the field sidebar click on All objects dropdown

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit");

        waitForElementVisible(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        clickToElement(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        sleepInSecond(2);
        scrollToElement(driver,"//li[@data-testid='all-objects-timesheet']");
        takeSnapShotWithHighlight(driver, "//li[@data-testid='all-objects-timesheet']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\009_X-e.png");

    }

    @Test
    public void TC_008_String_011() {
//        MockID: X/g
//        Core string: {__mlm_up_program}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting -> New Report
//        3. Add table block and press Edit
//        4. In the field sidebar click on All objects dropdown

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit");

        waitForElementVisible(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        clickToElement(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        sleepInSecond(2);
        scrollToElement(driver,"//li[@data-testid='all-objects-program']");
        takeSnapShotWithHighlight(driver, "//li[@data-testid='all-objects-program']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\011_X-g.png");

    }

    @Test
    public void TC_009_String_013() {
//        MockID: X/h
//        Core string: {__mlm_up_task}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting -> New Report
//        3. Add table block and press Edit
//        4. In the field sidebar click on All objects dropdown

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit");

        waitForElementVisible(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        clickToElement(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        sleepInSecond(2);
        scrollToElement(driver,"//li[@data-testid='all-objects-task']");
        takeSnapShotWithHighlight(driver, "//li[@data-testid='all-objects-task']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\013_X-h.png");

    }

    @Test
    public void TC_010_String_014() {
//        MockID: X/i
//        Core string: {__mlm_up_issue}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting -> New Report
//        3. Add table block and press Edit
//        4. In the field sidebar click on All objects dropdown

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit");

        waitForElementVisible(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        clickToElement(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        sleepInSecond(2);
        scrollToElement(driver,"//li[@data-testid='all-objects-issue']");
        takeSnapShotWithHighlight(driver, "//li[@data-testid='all-objects-issue']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\014_X-i.png");

    }

    @Test
    public void TC_011_String_016() {
//        MockID: X/j
//        Core string: {__mlm_up_project}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting -> New Report
//        3. Add table block and press Edit
//        4. In the field sidebar click on All objects dropdown

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit");

        waitForElementVisible(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        clickToElement(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        sleepInSecond(2);
        scrollToElement(driver,"//li[@data-testid='all-objects-project']");
        takeSnapShotWithHighlight(driver, "//li[@data-testid='all-objects-project']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\016_X-j.png");

    }

    @Test
    public void TC_012_String_018() {
//        MockID: X/k
//        Core string: {__mlm_up_portfolio}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting -> New Report
//        3. Add table block and press Edit
//        4. In the field sidebar click on All objects dropdown

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit");

        waitForElementVisible(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        clickToElement(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        sleepInSecond(2);
        scrollToElement(driver,"//li[@data-testid='all-objects-portfolio']");
        takeSnapShotWithHighlight(driver, "//li[@data-testid='all-objects-portfolio']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\018_X-k.png");

    }

    @Test
    public void TC_013_String_029() {
//        MockID: X/Y
//        Core string: Work Item
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting -> New Report
//        3. Add table block and press Edit
//        4. In the field sidebar click on All objects dropdown

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d60f872001a28fb53a91f/table/633d60fca77503fa6fe4bb30/edit");

        waitForElementVisible(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        clickToElement(driver,"//div[@data-testid='all-objects-trigger-button-trigger']");
        sleepInSecond(2);
        scrollToElement(driver,"//li[@data-testid='all-objects-workItem']");
        takeSnapShotWithHighlight(driver, "//li[@data-testid='all-objects-workItem']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\029_X-Y.png");

    }

    @Test
    public void TC_014_String_033() {
//        MockID: Xl6
//        Core string: functions
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/633d6f6472001a28fb53a97c/table/633d6f6da77503fa6fe4bca4/edit
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting -> New Report
//        3. Add table block and press Edit
//        4. In the field sidebar click on New +

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas");
        waitForPageToLoadCompletely(driver,30);
        clickToElement(driver, "//button[@data-testid='new-report-button']");
        sleepInSecond(1);

        //3. Add table block and press Edit
        doubleClickToElement(driver,"//li[@data-testid='builder-layout-table']");
        sleepInSecond(2);
        clickToElement(driver,"//button[@data-testid='empty-table-edit-icon']");
        sleepInSecond(1);

        //4. In the field sidebar click on New +
        clickToElement(driver,"(//div[@data-testid='fields-panel']//button)[1]");
        sleepInSecond(1);

        //take screenshot
        takeSnapShotWithHighlight(driver, "(//section[@data-testid='field-builder-section']/h2)[1]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\033_Xl6.png");

    }

    @Test
    public void TC_015_String_010() {
//        MockID: X/E
//        Core string: Pln Start
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks
//        1. Create a new project with task
//        2. Create another project with task
//        3. In the second project open task details -> Predecessors tab
//        4. Add new predecessor - task from first project
//        5. Go to second project -> Tasks and mouse hover predecessor icon(switch to Standart view to see this field)
//        6. Expand the tooltip if neccessary

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks");

        waitForElementVisible(driver, "//button[@data-testid='Predecessor'][2]");

        // hover predecessor icon(switch to Standart view to see this field) and click to Cross Project
sleepInSecond(1);
        hoverToElement(driver,"//button[@data-testid='Predecessor'][2]");
        waitForElementVisible(driver,"//button[contains(@data-testid,'accordion_button')]");
        clickToElement(driver,"//button[contains(@data-testid,'accordion_button')]");

        //take screenshot
        waitForElementVisible(driver,"(//div[contains(@aria-labelledby,'accordion_button')]//h3)[1]");


        takeSnapShotWithHighlight(driver, "(//div[contains(@aria-labelledby,'accordion_button')]//h3)[1]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\010_X-E.png");

    }

    @Test
    public void TC_016_String_026() {
//        MockID: X/Q
//        Core string: Pln End
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks
//        1. Create a new project with task
//        2. Create another project with task
//        3. In the second project open task details -> Predecessors tab
//        4. Add new predecessor - task from first project
//        5. Go to second project -> Tasks and mouse hover predecessor icon(switch to Standart view to see this field)
//        6. Expand the tooltip if neccessary

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks");

        waitForElementVisible(driver, "//button[@data-testid='Predecessor'][2]");

        // hover predecessor icon(switch to Standart view to see this field) and click to Cross Project
        sleepInSecond(1);
        hoverToElement(driver,"//button[@data-testid='Predecessor'][2]");
        waitForElementVisible(driver,"//button[contains(@data-testid,'accordion_button')]");
        clickToElement(driver,"//button[contains(@data-testid,'accordion_button')]");

        //take screenshot
        waitForElementVisible(driver,"(//div[contains(@aria-labelledby,'accordion_button')]//h3)[2]");


        takeSnapShotWithHighlight(driver, "(//div[contains(@aria-labelledby,'accordion_button')]//h3)[2]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\026_X-Q.png");

    }

    @Test
    public void TC_017_String_024() {
//        MockID: X/N
//        Core string: Condition
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks
//        1. Create a new project with task
//        2. Create another project with task
//        3. In the second project open task details -> Predecessors tab
//        4. Add new predecessor - task from first project
//        5. Go to second project -> Tasks and mouse hover predecessor icon(switch to Standart view to see this field)
//        6. Expand the tooltip if neccessary

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks");

        waitForElementVisible(driver, "//button[@data-testid='Predecessor'][2]");

        // hover predecessor icon(switch to Standart view to see this field) and click to Cross Project
sleepInSecond(1);
        hoverToElement(driver,"//button[@data-testid='Predecessor'][2]");
        waitForElementVisible(driver,"//button[contains(@data-testid,'accordion_button')]");
        clickToElement(driver,"//button[contains(@data-testid,'accordion_button')]");

        //take screenshot
        waitForElementVisible(driver,"(//div[contains(@aria-labelledby,'accordion_button')]//h3)[3]");


        takeSnapShotWithHighlight(driver, "(//div[contains(@aria-labelledby,'accordion_button')]//h3)[3]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\024_X-N.png");

    }

    @Test
    public void TC_018_String_021() {
//        MockID: X/L
//        Core string: Status
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks
//        1. Create a new project with task
//        2. Create another project with task
//        3. In the second project open task details -> Predecessors tab
//        4. Add new predecessor - task from first project
//        5. Go to second project -> Tasks and mouse hover predecessor icon(switch to Standart view to see this field)
//        6. Expand the tooltip if neccessary

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks");

        waitForElementVisible(driver, "//button[@data-testid='Predecessor'][2]");

        // hover predecessor icon(switch to Standart view to see this field) and click to Cross Project
sleepInSecond(1);
        hoverToElement(driver,"//button[@data-testid='Predecessor'][2]");
        waitForElementVisible(driver,"//button[contains(@data-testid,'accordion_button')]");
        clickToElement(driver,"//button[contains(@data-testid,'accordion_button')]");

        //take screenshot
        waitForElementVisible(driver,"(//div[contains(@aria-labelledby,'accordion_button')]//h3)[6]");


        takeSnapShotWithHighlight(driver, "(//div[contains(@aria-labelledby,'accordion_button')]//h3)[4]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\021_X-L.png");

    }

    @Test
    public void TC_019_String_020() {
//        MockID: X/l
//        Core string: See {__mlm_up_project}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks
//        1. Create a new project with task
//        2. Create another project with task
//        3. In the second project open task details -> Predecessors tab
//        4. Add new predecessor - task from first project
//        5. Go to second project -> Tasks and mouse hover predecessor icon(switch to Standart view to see this field)
//        6. Expand the tooltip if neccessary

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks");

        waitForElementVisible(driver, "//button[@data-testid='Predecessor'][2]");

        // hover predecessor icon(switch to Standart view to see this field) and click to Cross Project
sleepInSecond(1);
        hoverToElement(driver,"//button[@data-testid='Predecessor'][2]");
        waitForElementVisible(driver,"//button[contains(@data-testid,'accordion_button')]");
        clickToElement(driver,"//button[contains(@data-testid,'accordion_button')]");

        //take screenshot
        waitForElementVisible(driver,"//a[@data-testid='see-project-link']");
        takeSnapShotWithHighlight(driver, "//a[@data-testid='see-project-link']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\020_X-l.png");

    }

    @Test
    public void TC_020_String_023() {
//        MockID: X/n
//        Core string: {__mlm_up_project} Owner
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks
//        1. Create a new project with task
//        2. Create another project with task
//        3. In the second project open task details -> Predecessors tab
//        4. Add new predecessor - task from first project
//        5. Go to second project -> Tasks and mouse hover predecessor icon(switch to Standart view to see this field)
//        6. Expand the tooltip if neccessary

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks");

        waitForElementVisible(driver, "//button[@data-testid='Predecessor'][2]");

        // hover predecessor icon(switch to Standart view to see this field) and click to Cross Project
sleepInSecond(1);
        hoverToElement(driver,"//button[@data-testid='Predecessor'][2]");
        waitForElementVisible(driver,"//button[contains(@data-testid,'accordion_button')]");
        clickToElement(driver,"//button[contains(@data-testid,'accordion_button')]");

        //take screenshot
        waitForElementVisible(driver,"(//div[contains(@aria-labelledby,'accordion_button')]//h3)[6]");
        takeSnapShotWithHighlight(driver, "(//div[contains(@aria-labelledby,'accordion_button')]//h3)[6]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\023_X-n.png");

    }

    @Test
    public void TC_021_String_019() {
//        MockID: X/K
//        Core string: % Complete
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks
//        1. Create a new project with task
//        2. Create another project with task
//        3. In the second project open task details -> Predecessors tab
//        4. Add new predecessor - task from first project
//        5. Go to second project -> Tasks and mouse hover predecessor icon(switch to Standart view to see this field)
//        6. Expand the tooltip if neccessary

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks");

        waitForElementVisible(driver, "//button[@data-testid='Predecessor'][2]");

        // hover predecessor icon(switch to Standart view to see this field) and click to Cross Project
sleepInSecond(1);
        hoverToElement(driver,"//button[@data-testid='Predecessor'][2]");
        waitForElementVisible(driver,"//button[contains(@data-testid,'accordion_button')]");
        clickToElement(driver,"//button[contains(@data-testid,'accordion_button')]");

        //take screenshot
        waitForElementVisible(driver,"(//div[contains(@aria-labelledby,'accordion_button')]//h3)[5]");
        takeSnapShotWithHighlight(driver, "(//div[contains(@aria-labelledby,'accordion_button')]//h3)[5]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\019_X-K.png");

    }

    @Test
    public void TC_022_String_012() {
//        MockID: X/G
//        Core string: Viewer
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/document/633d35170002acae54256338a66dc064/633d35170002acaf103abb5b7dc18bf2/details
//        1. Login to Workfront
//        2. Go to Main Menu -> Documents
//        3. Click details of any document

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/document/633d35170002acae54256338a66dc064/633d35170002acaf103abb5b7dc18bf2/details");


        //take screenshot
        waitForElementVisible(driver,"//a[contains(@href,'/viewer')]/div/span");
        takeSnapShotWithHighlight(driver, "//a[contains(@href,'/viewer')]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\012_X-G.png");

    }

    @Test
    public void TC_023_String_022() {
//        MockID: X/M
//        Core string: No current relationship with an external item
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/projects
//        1. Login to Workfront
//        2. Go to Main Menu -> Setup -> Interface -> Layot Templates
//        3. Open ag-default template and make sure that Integrations field is added to Project header
//        4. Open any project and mouse hover Integration field in the toolbar

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks");
        //take screenshot
        waitForElementVisible(driver,"//div[@data-testid='readonly-field-integrations']/span/span");
        sleepInSecond(1);
        hoverToElement(driver,"//div[@data-testid='readonly-field-integrations']/span/span");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='tooltip-styled']//span",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\022_X-M.png");

    }

    @Test
    public void TC_024_String_028() {
//        MockID: X/u
//        Core string: { count , plural , one {# {__mlm_up_task}} other {# {__mlm_up_tasks}} }
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks
//        1. Create a new project with task
//        2. Create another project with task
//        3. In the second project open task details -> Predecessors tab
//        4. Add new predecessor - task from first project
//        5. Go to second project -> Tasks and mouse hover predecessor icon(switch to Standart view to see this field)
//        6. Expand the tooltip if neccessary

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks");

        waitForElementVisible(driver, "//button[@data-testid='Predecessor'][2]");

        // hover predecessor icon(switch to Standart view to see this field) and click to Cross Project
sleepInSecond(1);
        hoverToElement(driver,"//button[@data-testid='Predecessor'][2]");
        waitForElementVisible(driver,"//button[contains(@data-testid,'accordion_button')]");
        clickToElement(driver,"//button[contains(@data-testid,'accordion_button')]");

        //take screenshot
        waitForElementVisible(driver,"(//div[contains(@aria-labelledby,'accordion_button')]/following-sibling::div//h2)[4]/following-sibling::div");
        takeSnapShotWithHighlight(driver, "(//div[contains(@aria-labelledby,'accordion_button')]/following-sibling::div//h2)[4]/following-sibling::div",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\028_X-u.png");
    }

    @Test
    public void TC_025_String_034() {
//        MockID: YAH
//        Core string: Early Feature Opt-in has been enabled for this organization.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//        1. Login to Workfront
//        2. Go to Main Menu -> Goals
//        3. Click on Early Feature Opt-in Enabled button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards");

        //3. Click on Early Feature Opt-in Enabled button
        waitForElementVisible(driver, "(//div[@data-testid='header']//button)[1]");
        clickToElement(driver,"(//div[@data-testid='header']//button)[1]");

        //take screenshot
        waitForElementVisible(driver,"//section[contains(@class,'spectrum-Dialog-conten')]/div");
        takeSnapShotWithHighlight(driver, "//section[contains(@class,'spectrum-Dialog-conten')]/div",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\034_YAH.png");
    }

    @Test
    public void TC_026_String_035() {
//        MockID: YAI
//        Core string: Are you sure you want to delete
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/63219255393eac11a82569d4
//        1. Login to Workfront
//        2. Go to Main Menu -> Boards -> New Board
//        3. Click on Configure button
//        4. Enable 'Dynamically intake items to board'
//        5. Create and apply any filter
//        6. On the leftmost column click on three dots -> Delete

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/63219255393eac11a82569d4");

        // click on three dots -> Delete
        waitForElementVisible(driver,"//div[contains(@data-testid,'column-intake-')]//button[@data-testid='column-options-button']");
        clickToElement(driver,"//div[contains(@data-testid,'column-intake-')]//button[@data-testid='column-options-button']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-key='delete']");

        //take screenshot
        waitForElementVisible(driver,"//section[contains(@class,'spectrum-Dialog-content')]");
        takeSnapShotWithHighlight(driver, "//section[contains(@class,'spectrum-Dialog-content')]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\035_YAI.png");
    }

    @Test
    public void TC_027_String_003() {
//        MockID: X/A
//        Core string: Radio buttons
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ
//         1. Login to Workfront
//         2. Open up the browser JavaScript console
//         3. In the JavaScript console, type: localStorage.setItem('devtools', true)
//         4. Refresh the page
//         5. You should now see a floating icon that when clicked will open the Workfront Inspector
//         6. Enable feature toggles: form-builder-redrock-data, form-builder-mfe
//         7. Open URL from direct link (Setup -> Custom Forms -> Switch to new view)

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ");
        sleepInSecond(3);

        //step 3 + 4. In the JavaScript console, type: localStorage.setItem('devtools', true) > Refresh the page
        executeForBrowser(driver,"localStorage.setItem('devtools', true)");
        sleepInSecond(2);
        refreshCurrentPage(driver);

        //click to floating icon
        waitForElementVisible(driver,"//div[@id='dev-tools']/button");
        clickToElement(driver,"//div[@id='dev-tools']/button");
        sleepInSecond(1);

        //Enable feature toggles: form-builder-redrock-data, form-builder-mfe
        clickToElement(driver,"//button[text()='Feature Toggles']");
        sendKeyToElement(driver,"//input[@name='toggles filter']","form-builder");
        selectDropdownByOptionsValue(driver,"//select[@name='toggle-split:form-builder-mfe']","on");
        selectDropdownByOptionsValue(driver,"//select[@name='toggle-split:form-builder-redrock-data']","on");

        //Capture screenshots
        refreshCurrentPage(driver);
        waitForElementVisible(driver,"//div[@data-testid='NewFieldComponent']/div[8]");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='NewFieldComponent']/div[8]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\03_X-A.png");

    }

    @Test
    public void TC_028_String_005() {
//        MockID: X/B
//        Core string: Text with formatting
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ
//         1. Login to Workfront
//         2. Open up the browser JavaScript console
//         3. In the JavaScript console, type: localStorage.setItem('devtools', true)
//         4. Refresh the page
//         5. You should now see a floating icon that when clicked will open the Workfront Inspector
//         6. Enable feature toggles: form-builder-redrock-data, form-builder-mfe
//         7. Open URL from direct link (Setup -> Custom Forms -> Switch to new view)

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ");
        sleepInSecond(3);

        //step 3 + 4. In the JavaScript console, type: localStorage.setItem('devtools', true) > Refresh the page
        executeForBrowser(driver,"localStorage.setItem('devtools', true)");
        sleepInSecond(2);
        refreshCurrentPage(driver);

        //click to floating icon
        waitForElementVisible(driver,"//div[@id='dev-tools']/button");
        clickToElement(driver,"//div[@id='dev-tools']/button");
        sleepInSecond(1);

        //Enable feature toggles: form-builder-redrock-data, form-builder-mfe
        clickToElement(driver,"//button[text()='Feature Toggles']");
        sendKeyToElement(driver,"//input[@name='toggles filter']","form-builder");
        selectDropdownByOptionsValue(driver,"//select[@name='toggle-split:form-builder-mfe']","on");
        selectDropdownByOptionsValue(driver,"//select[@name='toggle-split:form-builder-redrock-data']","on");

        //Capture screenshots
        refreshCurrentPage(driver);
        waitForElementVisible(driver,"//div[@data-testid='NewFieldComponent']/div[3]");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='NewFieldComponent']/div[3]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\005_X-B.png");

    }

    @Test
    public void TC_029_String_007() {
//        MockID: X/C
//        Core string: Single line text
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ
//         1. Login to Workfront
//         2. Open up the browser JavaScript console
//         3. In the JavaScript console, type: localStorage.setItem('devtools', true)
//         4. Refresh the page
//         5. You should now see a floating icon that when clicked will open the Workfront Inspector
//         6. Enable feature toggles: form-builder-redrock-data, form-builder-mfe
//         7. Open URL from direct link (Setup -> Custom Forms -> Switch to new view)

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ");
        sleepInSecond(3);

        //step 3 + 4. In the JavaScript console, type: localStorage.setItem('devtools', true) > Refresh the page
        executeForBrowser(driver,"localStorage.setItem('devtools', true)");
        sleepInSecond(2);
        refreshCurrentPage(driver);

        //click to floating icon
        waitForElementVisible(driver,"//div[@id='dev-tools']/button");
        clickToElement(driver,"//div[@id='dev-tools']/button");
        sleepInSecond(1);

        //Enable feature toggles: form-builder-redrock-data, form-builder-mfe
        clickToElement(driver,"//button[text()='Feature Toggles']");
        sendKeyToElement(driver,"//input[@name='toggles filter']","form-builder");
        selectDropdownByOptionsValue(driver,"//select[@name='toggle-split:form-builder-mfe']","on");
        selectDropdownByOptionsValue(driver,"//select[@name='toggle-split:form-builder-redrock-data']","on");

        //Capture screenshots
        refreshCurrentPage(driver);
        waitForElementVisible(driver,"//div[@data-testid='NewFieldComponent']/div[1]");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='NewFieldComponent']/div[1]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\007_X-C.png");

    }

    @Test
    public void TC_030_String_015() {
//        MockID: X/I
//        Core string: Paragraph text
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ
//         1. Login to Workfront
//         2. Open up the browser JavaScript console
//         3. In the JavaScript console, type: localStorage.setItem('devtools', true)
//         4. Refresh the page
//         5. You should now see a floating icon that when clicked will open the Workfront Inspector
//         6. Enable feature toggles: form-builder-redrock-data, form-builder-mfe
//         7. Open URL from direct link (Setup -> Custom Forms -> Switch to new view)

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ");
        sleepInSecond(3);

        //step 3 + 4. In the JavaScript console, type: localStorage.setItem('devtools', true) > Refresh the page
        executeForBrowser(driver,"localStorage.setItem('devtools', true)");
        sleepInSecond(2);
        refreshCurrentPage(driver);

        //click to floating icon
        waitForElementVisible(driver,"//div[@id='dev-tools']/button");
        clickToElement(driver,"//div[@id='dev-tools']/button");
        sleepInSecond(1);

        //Enable feature toggles: form-builder-redrock-data, form-builder-mfe
        clickToElement(driver,"//button[text()='Feature Toggles']");
        sendKeyToElement(driver,"//input[@name='toggles filter']","form-builder");
        selectDropdownByOptionsValue(driver,"//select[@name='toggle-split:form-builder-mfe']","on");
        selectDropdownByOptionsValue(driver,"//select[@name='toggle-split:form-builder-redrock-data']","on");

        //Capture screenshots
        refreshCurrentPage(driver);
        waitForElementVisible(driver,"//div[@data-testid='NewFieldComponent']/div[2]");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='NewFieldComponent']/div[2]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\015_X-I.png");

    }

    @Test
    public void TC_031_String_017() {
//        MockID: X/J
//        Core string: Descriptive text
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ
//         1. Login to Workfront
//         2. Open up the browser JavaScript console
//         3. In the JavaScript console, type: localStorage.setItem('devtools', true)
//         4. Refresh the page
//         5. You should now see a floating icon that when clicked will open the Workfront Inspector
//         6. Enable feature toggles: form-builder-redrock-data, form-builder-mfe
//         7. Open URL from direct link (Setup -> Custom Forms -> Switch to new view)

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ");
        sleepInSecond(3);

        //step 3 + 4. In the JavaScript console, type: localStorage.setItem('devtools', true) > Refresh the page
        executeForBrowser(driver,"localStorage.setItem('devtools', true)");
        sleepInSecond(2);
        refreshCurrentPage(driver);

        //click to floating icon
        waitForElementVisible(driver,"//div[@id='dev-tools']/button");
        clickToElement(driver,"//div[@id='dev-tools']/button");
        sleepInSecond(1);

        //Enable feature toggles: form-builder-redrock-data, form-builder-mfe
        clickToElement(driver,"//button[text()='Feature Toggles']");
        sendKeyToElement(driver,"//input[@name='toggles filter']","form-builder");
        selectDropdownByOptionsValue(driver,"//select[@name='toggle-split:form-builder-mfe']","on");
        selectDropdownByOptionsValue(driver,"//select[@name='toggle-split:form-builder-redrock-data']","on");

        //Capture screenshots
        refreshCurrentPage(driver);
        waitForElementVisible(driver,"//div[@data-testid='NewFieldComponent']/div[7]");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='NewFieldComponent']/div[7]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\017_X-J.png");

    }

    @Test
    public void TC_032_String_032() {
//        MockID: X+9
//        Core string: Text with formatting
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ
//         1. Login to Workfront
//         2. Open up the browser JavaScript console
//         3. In the JavaScript console, type: localStorage.setItem('devtools', true)
//         4. Refresh the page
//         5. You should now see a floating icon that when clicked will open the Workfront Inspector
//         6. Enable feature toggles: form-builder-redrock-data, form-builder-mfe
//         7. Open URL from direct link (Setup -> Custom Forms -> Switch to new view)

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ");
        sleepInSecond(3);

        //step 3 + 4. In the JavaScript console, type: localStorage.setItem('devtools', true) > Refresh the page
        executeForBrowser(driver,"localStorage.setItem('devtools', true)");
        sleepInSecond(2);
        refreshCurrentPage(driver);

        //click to floating icon
        waitForElementVisible(driver,"//div[@id='dev-tools']/button");
        clickToElement(driver,"//div[@id='dev-tools']/button");
        sleepInSecond(1);

        //Enable feature toggles: form-builder-redrock-data, form-builder-mfe
        clickToElement(driver,"//button[text()='Feature Toggles']");
        sendKeyToElement(driver,"//input[@name='toggles filter']","form-builder");
        selectDropdownByOptionsValue(driver,"//select[@name='toggle-split:form-builder-mfe']","on");
        selectDropdownByOptionsValue(driver,"//select[@name='toggle-split:form-builder-redrock-data']","on");

        //Capture screenshots
        refreshCurrentPage(driver);
        waitForElementVisible(driver,"//div[@data-testid='NewFieldComponent']/div[3]");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='NewFieldComponent']/div[3]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\032_X+9.png");

    }

    @Test
    public void TC_033_String_025() throws Exception {
//        MockID: X/P
//        Core string: unlock {0} for editing
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/projects
//         1. Login to Workfront
//         2. Go to Main Menu -> Setup -> Project Preferences -> Projects
//         3. RMB -> inspect on any unlocked option(blue tumbler)

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/setup/projects");
        waitForElementVisible(driver,"//label[@data-testid='project.preferences.allowcreatewithouttemplate']");

        //check if this button is disable > enable it
        if (!(isElementDisplayed(driver,"//button[contains(@class,'small active')]"))) {
            clickToElement(driver,"//button[@data-test-id='preference-toggle-allowCreateWithoutTemplate']");
            sleepInSecond(1);
            clickToElement(driver,"//button[@data-test-id='pref-save']");
            sleepInSecond(2);
            refreshCurrentPage(driver);
        }

       //Take screenshot
        waitForElementVisible(driver,"//button[@data-test-id='preference-toggle-allowCreateWithoutTemplate']");
        inspectElement(driver,"//button[@data-test-id='preference-toggle-allowCreateWithoutTemplate']");
        captureScreen(GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\025_X-P.png");

    }

    @Test
    public void TC_034_String_031() throws Exception {
//        MockID: X+8
//        Core string: lock {0} for editing
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/projects
//         1. Login to Workfront
//         2. Go to Main Menu -> Setup -> Project Preferences -> Projects
//         3. RMB -> inspect on any unlocked option(blue tumbler)

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/setup/projects");
        waitForElementVisible(driver,"//label[@data-testid='project.preferences.allowcreatewithouttemplate']");

        //check if this button is enable > disable it
        if (isElementDisplayed(driver,"//button[contains(@class,'small active')]")) {
            clickToElement(driver,"//button[@data-test-id='preference-toggle-allowCreateWithoutTemplate']");
            sleepInSecond(1);
            clickToElement(driver,"//button[@data-testid='confirm-button-confirm-dialog']");
            sleepInSecond(1);
            clickToElement(driver,"//button[@data-test-id='pref-save']");
            sleepInSecond(2);
            refreshCurrentPage(driver);
        }

        //Take screenshot
        waitForElementVisible(driver,"//button[@data-test-id='preference-toggle-allowCreateWithoutTemplate']");
        inspectElement(driver,"//button[@data-test-id='preference-toggle-allowCreateWithoutTemplate']");
        captureScreen(GlobalConstants.SCREENSHOTS + "\\Workfront_20220724T113627Z\\DEU\\031_X+8.png");

    }




    @AfterClass(alwaysRun = true)
    public void afterClass() {

      driver.quit();
    }

}
