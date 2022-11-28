package Workfront_20220814T105556Z;

import common.AbstractPage;
import common.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class ENU extends AbstractPage {
    WebDriver driver;
    Actions action;

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
        sleepInSecond(5);

    }

    @Test
    public void String_001() {
//        MockID: UyA
//        Core string: Add multiple forms and arrange them in the order you would like them to appear
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/61fbb8bb0014f01cbcc8051a8f6bfcce/overview
//        1. Login to Workfront
//        2. Go to Main Menu -> Projects
//        3. Open any project
//        4. Click on three dots -> Edit

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/projects");
        waitForElementVisible(driver, "//div[@data-testid='button-options-trigger']");
        clickToElement(driver,"//div[@data-testid='table-row'][1]//div[@data-testid='row-checkbox']");
        waitForElementVisible(driver,"//button[@data-testid='edit']");
        clickToElement(driver,"//button[@data-testid='edit']");
        waitForElementVisible(driver,"//div[@data-testid='section-nav-item-customforms']");
        clickToElement(driver,"//div[@data-testid='section-nav-item-customforms']");
        waitForElementVisible(driver,"//div[@data-testid='lightbox-section-customforms']//span[2]");
        takeSnapShotWithHighlight(driver, "//div[@data-testid='lightbox-section-customforms']//span[2]", GlobalConstants.SCREENSHOTS + "\\Workfront_20220814T105556Z\\ENU\\001_UyA.png");

    }

    @Test
    public void String_003() {
//        MockID: YBd
//        Core string: 	No owner
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks
//        1. Create a new project with 2 tasks
//        2. Switch to Standard view and set 1 task as a predecessor to another
//        3. Remove Project Owner of this project
//        4. Mouse hover link numbe in the Predecessor field

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/tasks");

        waitForElementVisible(driver, "//button[@data-testid='Predecessor'][2]");
        hoverToElement(driver,"//button[@data-testid='Predecessor'][2]");
        waitForElementVisible(driver,"//button[contains(@data-testid,'accordion_button')]");
        clickToElement(driver,"//button[contains(@data-testid,'accordion_button')]");
        waitForElementVisible(driver,"//a[@data-testid='see-project-link']/parent::div/preceding-sibling::div/div[2]/div");
        takeSnapShotWithHighlight(driver, "//a[@data-testid='see-project-link']/parent::div/preceding-sibling::div/div[2]/div", GlobalConstants.SCREENSHOTS + "\\Workfront_20220814T105556Z\\ENU\\03_YBd.png");
    }

    @Test
    public void String_006() {
//        MockID: YBh
//        Core string: 	FLOOR
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

        sendKeyToElement(driver,"//input[@id='configuration-search-input']","FLOOR");
        waitForElementVisible(driver,"//li[@id='FLOOR']");
        takeSnapShotWithHighlight(driver, "//li[@id='FLOOR']", GlobalConstants.SCREENSHOTS + "\\Workfront_20220814T105556Z\\ENU\\06_YBh.png");

    }

    @Test
    public void String_008_009() {
//        MockID: YBR, YBS
//        Core string:
//        1. Cleartime
//        2.CLEARTIME
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

        sendKeyToElement(driver,"//input[@id='configuration-search-input']","CLEARTIME");
        waitForElementVisible(driver,"//li[@id='CLEARTIME']");
        takeSnapShotWithHighlight(driver, "//li[@id='CLEARTIME']", GlobalConstants.SCREENSHOTS + "\\Workfront_20220814T105556Z\\ENU\\09_YBS.png");

        dragAndDropHTML5ByJS(driver,"//li[@id='CLEARTIME']","//div[@data-testid='dropzone-canvas']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//div[@type='formula']/div[2]/div/div[1]", GlobalConstants.SCREENSHOTS + "\\Workfront_20220814T105556Z\\ENU\\08_YBR.png");
    }

    @Test
    public void String_007_002() throws Exception {
//        MockID: YA+
//        Core string: Hide configure
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/63219255393eac11a82569d4
//         1. Login to Workfront
//         2. Go to Main Menu -> Boards -> New Board
//         3. Click on Configure button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/63219255393eac11a82569d4");

        waitForElementVisible(driver, "//div[@data-testid='board-configure-button']//button");
        clickToElement(driver,"//div[@data-testid='board-configure-button']//button");
        waitForElementVisible(driver,"//div[contains(@class,'module_positionRight__3lKJB')]/following-sibling::div//button[contains(@style,'hideButton')]");
        takeSnapShotWithHighlight(driver, "//div[contains(@class,'module_positionRight__3lKJB')]/following-sibling::div//button[contains(@style,'hideButton')]", GlobalConstants.SCREENSHOTS + "\\Workfront_20220814T105556Z\\ENU\\02_YA+.png");
        sleepInSecond(2);
        clickToElement(driver,"//div[@data-testid='configure-board-accordion-board']");
        waitForElementVisible(driver,"//button[contains(@data-testid,'remove-intake-filter-button')]");
        inspectElement(driver,"//button[contains(@data-testid,'remove-intake-filter-button')]");
        captureScreen(GlobalConstants.SCREENSHOTS + "\\Workfront_20220814T105556Z\\ENU\\07_YBm.png");

    }

    @Test
    public void String_010() throws Exception {
//        MockID: YBT
//        Core string: 	Select color theme as {__mlm_low_project}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/resourcemanagement/scheduling
//        1. Go to Main Menu -> Resourcing -> Workload Balancer
//        2. Click on Setting button
//        3. Select 'Project' radio button and RMB -> Inspect it (SR string)

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/resourcemanagement/scheduling");

        waitForElementVisible(driver, "//button[@data-testid='setting-icon']");
        clickToElement(driver,"//button[@data-testid='setting-icon']");

        waitForElementVisible(driver,"//label[@data-testid='project_theme_button']//input");
        if (!(isElementSelected(driver,"//label[@data-testid='project_theme_button']//input")))
        {
            clickToElement(driver,"//label[@data-testid='project_theme_button']//input");
        }


        sleepInSecond(3);
        inspectElement(driver,"//label[@data-testid='project_theme_button']//input");
        captureScreen(GlobalConstants.SCREENSHOTS + "/Workfront_20220814T105556Z/ENU/10_YBT.png");

    }

    @Test
    public void String_011() throws Exception {
//        MockID: YBU
//        Core string: 	Select color theme as {__mlm_low_project} status
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/resourcemanagement/scheduling
//        1. Go to Main Menu -> Resourcing -> Workload Balancer
//        2. Click on Setting button
//        3. Select 'Project' radio button and RMB -> Inspect it (SR string)

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/resourcemanagement/scheduling");

        waitForElementVisible(driver, "//button[@data-testid='setting-icon']");
        clickToElement(driver,"//button[@data-testid='setting-icon']");

        waitForElementVisible(driver,"//label[@data-testid='projectstatus_theme_button']//input");
        if (!(isElementSelected(driver,"//label[@data-testid='projectstatus_theme_button']//input")))
        {
            clickToElement(driver,"//label[@data-testid='projectstatus_theme_button']//input");
        }


        sleepInSecond(3);
        inspectElement(driver,"//label[@data-testid='projectstatus_theme_button']//input");
        captureScreen(GlobalConstants.SCREENSHOTS + "\\Workfront_20220814T105556Z\\ENU\\11_YBU.png");
        sleepInSecond(1);



    }

    @Test
    public void String_012() throws Exception {
//        MockID: YBX
//        Core string: 	Select color theme as default
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/resourcemanagement/scheduling
//        1. Go to Main Menu -> Resourcing -> Workload Balancer
//        2. Click on Setting button
//        3. Select 'Project' radio button and RMB -> Inspect it (SR string)

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/resourcemanagement/scheduling");

        waitForElementVisible(driver, "//button[@data-testid='setting-icon']");
        clickToElement(driver,"//button[@data-testid='setting-icon']");

        waitForElementVisible(driver,"//label[@data-testid='default_theme_button']//input");
        if (!(isElementSelected(driver,"//label[@data-testid='default_theme_button']//input")))
        {
            clickToElement(driver,"//label[@data-testid='default_theme_button']//input");
        }


        sleepInSecond(3);
        inspectElement(driver,"//label[@data-testid='default_theme_button']//input");
        captureScreen(GlobalConstants.SCREENSHOTS + "\\Workfront_20220814T105556Z\\ENU\\12_YBX.png");

    }



    @AfterClass(alwaysRun = true)
    public void afterClass() {

//        driver.quit();
    }

}
