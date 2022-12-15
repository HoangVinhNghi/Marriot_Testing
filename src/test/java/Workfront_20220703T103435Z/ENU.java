package Workfront_20220703T103435Z;

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
    public void String_001() {
//        MockID: X+o
//        Core string: Condition
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list
//        1. Login to Workfront 2. Go to Main Menu -> Goals 3. Click Create goal and confirm 4. Click on Progress Indicators

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");
        clickToElement(driver, "//button[@data-testid='add-goal-button']");
        sendKeyToElement(driver, "//input[@data-testid='name-input']", "Test goal_" + generateRandomNumber());
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='create-new-task']");
        sleepInSecond(2);
        clickToElement(driver, "//a[contains(@href,'progress-indicators')]");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//div[@data-colindex='6']", GlobalConstants.WF_20220703T103435Z + "/ENU/01_X+i_X+Z.png");

    }

    @Test
    public void String_002() {
//        MockID: X+k
//        Core string: Associated {__mlm_low_results}, {__mlm_low_activities}, and aligned {__mlm_low_goals} calculate the {__mlm_low_goal} progress.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/alignment/list
//        1. Login to Workfront 2. Go to Main Menu -> Goals 3. Click Create goal and confirm 4. Mouse hover 'Progress' icon

        clickToElement(driver, "//a[contains(@href,'/overview')]");
        sleepInSecond(1);
        hoverToElement(driver, "//div[@data-testid='field-progress-label']/following-sibling::span");
        takeSnapShotWithHighlight(driver, "//div[@data-testid='tooltip-styled']", GlobalConstants.WF_20220703T103435Z + "/ENU/02_X+k.png");

    }

    @Test
    public void String_003() {
//        MockID: X+S
//        Core string: Go to delegated items
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/worklist
//        1. Login to Workfront 2. Go to Home -> Edit delegation - Delegate tasks and issues 3. Enter any delegate name and click Save

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
        clickToElement(driver, "//button[@data-testid='save-btn']");
        takeSnapShotWithHighlight(driver, "//button[@data-testid='go-to-work-delegations']", GlobalConstants.WF_20220703T103435Z + "/ENU/03_X+S.png");

    }

    @Test
    public void String_004() {
//        MockID: X+M
//        Core string: Year
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas
//        1. Login to Workfront 2. Go to Main Menu -> Reporting 3. Click New report 4. Drag&Drop Table block and click Edit
//        5. Click on New(field) button 6. Drag&Drop YEAR function into the content panel

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas");
        clickToElement(driver, "//button[@data-testid='new-report-button']");
        sleepInSecond(1);
        doubleClickToElement(driver, "//li[@data-testid='builder-layout-table']");
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='empty-table-edit-icon']");
        clickToElement(driver, "(//div[@data-testid='fields-panel']//button)[1]");
        sleepInSecond(1);
        sendKeyToElement(driver, "//input[@id='configuration-search-input']", "Year");
        sleepInSecond(2);
        dragAndDropHTML5ByJS(driver, "//li[@id='YEAR']", "//div[@data-testid='dropzone-canvas']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//div[@type='formula']/div[2]/div/div/div", GlobalConstants.WF_20220703T103435Z + "/ENU/04_X+M.png");

    }

    @Test
    public void String_005() {
//        MockID: X+L
//        Core string: YEAR
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas
//        1. Login to Workfront 2. Go to Main Menu -> Reporting 3. Click New report 4. Drag&Drop Table block and click Edit 5. Click on New(field) button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas");
        clickToElement(driver, "//button[@data-testid='new-report-button']");
        sleepInSecond(1);
        doubleClickToElement(driver, "//li[@data-testid='builder-layout-table']");
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='empty-table-edit-icon']");
        clickToElement(driver, "(//div[@data-testid='fields-panel']//button)[1]");
        sleepInSecond(2);
        scrollToElement(driver, "//li[@id='YEAR']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//li[@id='YEAR']", GlobalConstants.WF_20220703T103435Z + "/ENU/05_X+L.png");
    }

    @Test
    public void String_006() throws Exception {
//        MockID: Xb3
//        Core string: Delegate approvals
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/worklist
//        1. Login to Workfront 2. Go to Home -> Edit delegation - Delegate tasks and issues 3. Right click -> Inspect on any delegation dialogue (aria-label string)

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
        inspectElement(driver, "//div[@data-testid='delegate-work-container']//div[@role='dialog']");
        sleepInSecond(1);
        captureScreen(GlobalConstants.WF_20220703T103435Z + "/ENU/06_Xb3.png");
        sleepInSecond(1);
        closeChromeDevTool();
    }

    @Test
    public void String_007() {
//        MockID: R/w
//        Core string: so that everyone in Workfront can edit it.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/custom-forms
//        1. Login to Workfront 2. Go to Main Menu -> Setup -> Custom Forms -> Fields
//        3. Select 'share.make.editable.system.wide.sublabel' field and press 'Share' button 4. Click on cog icon

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/setup/custom-forms");
        switchToIframeByElement(driver, "//iframe[@data-testid='kamino-shim']");

        clickToElement(driver, "//a[@data-name='list-custom-fields']");
        sleepInSecond(2);
        checkToCheckboxOrRadio(driver, "//a[text()='share.make.editable.system.wide.sublabel']/ancestor::div[@data-valuefield='name']/preceding-sibling::div/descendant::div[@data-test-id='row-checkbox']");
        clickToElement(driver, "//button[@id='shareLucidToolbar']");

        driver.switchTo().defaultContent();
        sleepInSecond(1);

        switchToIframeByElement(driver, "//iframe[@id='content-lucid-share']");
        clickToElement(driver, "//button[@aria-haspopup='listbox']");
        takeSnapShotWithHighlight(driver, "//li[@data-value='editableSystemWide']//div[@class='sublabel']", GlobalConstants.WF_20220703T103435Z + "/ENU/07_R-w.png");

    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}
