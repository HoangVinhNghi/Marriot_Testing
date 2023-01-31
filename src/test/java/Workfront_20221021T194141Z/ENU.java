package Workfront_20221021T194141Z;

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
    public void String_001() throws Exception {
//        MockID: YE+
//        Core string: When this is selected, approvers can also submit, reopen, or edit the timesheet, unless your administrator restricts these actions in the Timesheet Preferences area of Setup.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheets
//        1. Login to Workfront 2. Go to Timesheets and click New Timesheet 3. Mouse hover info icon

        openPageUrl(driver, " https://adobeloctesting.devtest.workfront-dev.com/timesheets");
        waitForPageToLoadCompletely(driver,30);

        // click New Timesheet
        clickToElement(driver, "//button[@data-testid='add']");
        sleepInSecond(1);

        //Mouse hover info icon
        hoverToElement(driver,"//span[@data-testid='approver-can-edit-hours-tooltip']");
        sleepInSecond(1);

        // Take SS
        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\001_YE+.png");

    }

    @Test
    public void String_002()  {
        // MockID: YE8
//        Core string: When this option is disabled, the following users can also edit the timesheets: users with administrative access to timesheets and hours, timesheet approvers allowed to edit time, and timesheet owners' managers.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/timesheet-preferences
//        1. Login to Workfront 2. Go to Setup -> Timesheet & Hours -> Preferences 3. Mouse hover icon near "Restrict timesheet editing to owners and admins."

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/timesheet-preferences");
        waitForPageToLoadCompletely(driver,60);

        //Mouse hover info icon
        hoverToElement(driver,"(//*[name()='svg'][@class='helpIcon'])");
        sleepInSecond(1);

        // Take SS
        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\002_YE8.png");
    }

    @Test
    public void String_003()  {
        // MockID: YE9
//        Core string: Select a milestone path for the template in order to attach milestones to template {__mlm_low_tasks}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/templates
//        1. Login to Workfront 2. Go to Templates and select any template 3. Click Edit in the toolbar and scroll down 4. Mouse hover info icon near "Milestone Path" option

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/templates");
        waitForPageToLoadCompletely(driver,30);

        //Select any template
        clickToElement(driver,"(//a[@data-test-id='LinkSimple'])[1]");

        //Click on three dots > Edit
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//li[@data-testid='edit']");

        //Scroll down > Mouse hover info icon near "Milestone Path" option
        scrollToElement(driver,"//div[@data-testid='field-milestonePath']");
        sleepInSecond(2);
        hoverToElement(driver,"//div[@data-testid='field-milestonePath-label']/following-sibling::span");
        sleepInSecond(1);

        // Take SS
        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\003_YE9.png");
    }

    @Test
    public void String_004() throws Exception {
        // String: YFC	Import files by clicking below
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/worklist
//        1. Login to Workfront 2. Open up the browser JavaScript console 3. In the JavaScript console, type: localStorage.setItem('devtools', true)
//        4. Refresh the page 5. You should now see a floating icon that when clicked will open the Workfront Inspector 6. Enable feature toggles: home-workspaces
//        7. Open home page and click on "Try out the new home" 8. Click "Go back to current home" 9. Click on "Add widget" and add "My Tasks" panel if there isn't any
//        10. Click on any Upload File icon in the table 11. Upload any txt file 12. Right click -> Inspect on a file icon (aria-label string)
        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        clickToElement(driver,"(//button[@data-tracking-id='tasks-upload-document'])[1]");
        clickToElementByJS(driver,"//section[contains(@class,'spectrum-IllustratedMessage-description')]//button");
        clickToElement(driver,"//li[@data-key='BROWSE']");
        uploadFileByRobot(GlobalConstants.TOUPLOAD+"test_txt.txt");
        sleepInSecond(1);
        inspectElement(driver,"(//figure//*[name()='svg'])[1]");
        sleepInSecond(1);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_RIGHT);        robot.keyRelease(KeyEvent.VK_RIGHT);
        sleepInSecond(1);
        robot.keyPress(KeyEvent.VK_DOWN);        robot.keyRelease(KeyEvent.VK_DOWN);
        sleepInSecond(1);
        captureScreen(GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\004_YFC.png");


    }
    @Test
    public void String_005_012() throws AWTException {
        // NOTE: Click on "Add widget" and add "My Tasks" panel if there isn't any first to run this
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/worklist
//        1. Login to Workfront 2. Open up the browser JavaScript console 3. In the JavaScript console, type: localStorage.setItem('devtools', true) 4. Refresh the page
//        5. You should now see a floating icon that when clicked will open the Workfront Inspector 6. Enable feature toggles: home-workspaces
//        7. Open home page and click on "Try out the new home" 8. Click "Go back to current home" 9. Click on "Add widget" and add "My Tasks" panel if there isn't any
//        10. Click on any Upload File icon in the table 11. Click on Select Folder button

        // YFD	Select folder...
        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        clickToElement(driver,"(//button[@data-tracking-id='tasks-upload-document'])[1]");
        takeSnapShotWithHighlight(driver,"//span[contains(@class,'is-placeholder')]", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\005_YFD.png");

        // YFA	-- No folder --	None
        clickToElement(driver,"//button[contains(@class,'Dropdown-trigger')]");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"//div[contains(@class,'Menu-itemGrid')]", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\006_YFA.png");

        // YFJ	Drag and drop your file or Cmd/Ctrl + V to paste from your clipboard
        takeSnapShotWithHighlight(driver,"//h3[contains(@class,'spectrum-IllustratedMessage-heading')]", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\007_YFJ.png");

        // YFB	Import from
        clickToElementByJS(driver,"//section[contains(@class,'spectrum-IllustratedMessage-description')]//button");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"//span[contains(@class,'Menu-sectionHeading')]", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\008_YFB.png");

        // YFI	Browse files
        takeSnapShotWithHighlight(driver,"//li[@data-key='BROWSE']", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\009_YFB.png");

        // YFE	Add an update
        // YFF	Start a new update...
        clickToElementByJS(driver,"//section[contains(@class,'spectrum-IllustratedMessage-description')]//button");
        clickToElement(driver,"//button[contains(@style,'margin-right: var(--spectrum-global-dimension-size-25, var(--spectrum-alias-size-25));')]");
        clickToElement(driver,"(//button[@data-tracking-id='tasks-upload-document'])[1]");
        waitForElementVisible(driver,"//h3[contains(@class,'spectrum-IllustratedMessage')]");
        sleepInSecond(1);
        copyImageToClipboard(GlobalConstants.TOUPLOAD+"img01.jpg");
        sleepInSecond(1);
        pasteByRobot(driver);
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"//div[contains(@class,'relative transition-all')]//h3", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\010_YFE.png");
        takeSnapShotWithHighlight(driver,"//div[contains(@class,'public-DraftStyleDefault')]", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\011_YFE.png");

        // YFG	Drop here to add files
        dragAndHoldOverHTML5ByJS(driver,"//figure/img","//figure/img");
        takeSnapShotWithHighlight(driver,"//div[contains(@class,'inset-1/2 text-white')]", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\012_YFG.png");

    }

    @Test
    public void String_013_014()  {
        // MockID: YIb	Display a column card count
        // MockID: YIc	Column card counter
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/637e191e4f73720121b4e562
//        1. Login to Workfront 2. Go to Boards and create a new board 3. In the configure panel expand Column section

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/boards/");
        waitForPageToLoadCompletely(driver,30);

        //Select any board
        clickToElement(driver,"(//div[@data-testid='dashboard-board-container']/div/button)[1]");
        sleepInSecond(2);

        //Click on config button > Expand Column
        clickToElement(driver,"//div[@data-testid='board-configure-button']//button");
        clickToElement(driver,"//div[@data-testid='configure-board-accordion-column']");
        sleepInSecond(2);

        // Take SS
        takeSnapShotWithHighlight(driver,"//input[@data-testid='card-count-switch']/parent::label", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\013_YIb.png");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"//div[@data-testid='configure-board-accordion-column']/following-sibling::div/h5", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\014_YIc.png");
    }

    @Test
    public void String_015_016()  {
        // MockID: YIj	We cannot access this timesheet at this time.
        // MockID: YIl	We cannot access this timesheet
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63621403000b45e98ec80e9e1d27907e/overview
//        1. Login to Workfront 2. Go to Timesheets 3. Create and open new timesheet and copy its URL 4. Delete the timesheet and try to access it via URL OR go to URL from direct link above

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/timesheet/63621403000b45e98ec80e9e1d27907e/overview");
        waitForPageToLoadCompletely(driver,60);

        // Take SS
        takeSnapShotWithHighlight(driver,"//div[@data-testid='error-page']/h2", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\015_YIj.png");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='error-page']/h1", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\016_YIl.png");
    }

    @Test
    public void String_017_018()  {
        // MockID: YIk	You don't have access to this timesheet
        // MockID: YIm	Contact your system administrator to request access to other users' timesheets.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/62d8d29e00098eab36b9f4646b38a03d/overview
//        1. Login to Workfront 2. Go to Timesheets and open any admin timesheet 3. In new tab go to Setup -> Login As and login as any user 4. Refresh the timesheet tab

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/log-in-as");
        waitForPageToLoadCompletely(driver,60);
        waitForElementVisible(driver,"//div[@data-testid='setup-header-container']//h2");
        switchToIframeByElement(driver,"//iframe[@data-testid='kamino-shim']");
        sleepInSecond(1);

        // Login as other user > Select
        sendKeyToElement(driver,"//input[@class='ta-input']", "aa bb");
        sleepInSecond(1);
        clickToElement(driver,"//li[contains(@class,'pick-list-item pickable selected highlighted')]");
        clickToElement(driver,"//button[contains(@class,'submit primary login btn')]");

        //Switch to default content > open any admin timesheet
        switchToDefaultContent(driver);
        waitForElementVisible(driver,"//h2[@data-testid='logged-in-as']");
        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/timesheet/62d8d29e00098eab36b9f4646b38a03d/overview");
        waitForPageToLoadCompletely(driver,60);

        // Take SS
        takeSnapShotWithHighlight(driver,"//h1[@data-testid='error-title']", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\017_YIk.png");
        takeSnapShotWithHighlight(driver,"//h1[@data-testid='error-title']", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\018_YIm.png");
    }

    @Test
    public void String_019()  {
        // MockID: YIn	This blueprint contains objects that do not currently have mapping preferences available
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/blueprints
//        1. Login to Workfront 2. Go to Blueprints 3. Click on Install button of a "Add/Delete/Edit Employee IT Setup Project Details" blueprint

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/blueprints");
        waitForPageToLoadCompletely(driver,60);
        clickToElement(driver,"//div[@class='pb-6']/button[@data-testid='blueprints-card-install-button']");
        clickToElement(driver,"//button[@data-testid='install-continue-button']");

        // Take SS
        takeSnapShotWithHighlight(driver,"//div[@id='wf-mfe__blueprints']//h3", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\019_YIn.png");
    }

    @Test
    public void String_020_021()  {
        // String:
        // YIX	Blank project
        // YIY	From template
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/worklist
//        1. Login to Workfront 2. Open up the browser JavaScript console 3. In the JavaScript console, type: localStorage.setItem('devtools', true) 4. Refresh the page
//        5. You should now see a floating icon that when clicked will open the Workfront Inspector 6. Enable feature toggles: home-workspaces
//        7. Open home page and click on "Try out the new home" 8. Click "Go back to current home" 9. Click on "Add widget" and add My Projects panel 10. Click on New button there

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        clickToElement(driver,"//div[@id='widget-projects-list']//button[@data-variant='secondary']"); //Click on New button
        takeSnapShotWithHighlight(driver,"//li[@data-key='BLANK']", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\020_YIX.png");
        takeSnapShotWithHighlight(driver,"//li[@data-key='TEMPLATE']", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\021_YIY.png");
    }

    @Test
    public void String_022_025()  {
        // String:
        // YM0	Updates I've Been Mentioned In
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/worklist
//        1. Login to Workfront 2. Open up the browser JavaScript console 3. In the JavaScript console, type: localStorage.setItem('devtools', true) 4. Refresh the page
//        5. You should now see a floating icon that when clicked will open the Workfront Inspector 6. Enable feature toggles: home-workspaces
//        7. Open home page and click on "Try out the new home" 8. Click "Go back to current home" 9. Click on "Add widget"

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        clickToElement(driver,"//div[contains(@class,'border-bottom')]/div[contains(@class,'flex gap')]/button"); //Click on Manage widgets
        clickToElement(driver,"//button[@data-tracking-id='add-widget']"); //Click on Add Widget

        // YM2	Mentions
        takeSnapShotWithHighlight(driver,"//*[name()='path' and contains(@d,'M13 2.1a8.')]/ancestor::div[@class='spectrum-Card-preview']/following-sibling::div//div[contains(@class,'spectrum-Card-title')]",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\022_YM2.png");

        // YM0	Updates I've Been Mentioned In
        takeSnapShotWithHighlight(driver,"//*[name()='path' and contains(@d,'M13 2.1a8.')]/ancestor::div[@class='spectrum-Card-preview']/following-sibling::div//div[contains(@id,'subtitle')]",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\023_YM0.png");

        // YM1	My Projects
        takeSnapShotWithHighlight(driver,"//*[name()='path' and contains(@d,'M14,8H2V5A1')]/ancestor::div[@class='spectrum-Card-preview']/following-sibling::div//div[contains(@class,'spectrum-Card-title')]",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\024_YM1.png");

        // YM3	Projects I Own And Projects I'm On
        takeSnapShotWithHighlight(driver,"//*[name()='path' and contains(@d,'M14,8H2V5A1')]/ancestor::div[@class='spectrum-Card-preview']/following-sibling::div//div[contains(@id,'subtitle')]",
                GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\025_YM3.png");

    }

    @Test
    public void String_025()  {
//      MockID: YMb	Add new field
//      Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//      Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ
//      1. Login to Workfront 2. Open up the browser JavaScript console 3. In the JavaScript console, type: localStorage.setItem('devtools', true) 4. Refresh the page
//      5. You should now see a floating icon that when clicked will open the Workfront Inspector 6. Enable feature toggles: form-builder-redrock-data, form-builder-mfe
//      7. Open URL from direct link above (Setup -> Custom Forms -> Switch to new view)

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ");
        sleepInSecond(5);

        if(isElementDisplayed(driver,"//iframe[@data-testid='kamino-shim']")){
            switchToIframeByElement(driver,"//iframe[@data-testid='kamino-shim']");
            clickToElement(driver,"//button[@data-test-id='switch-to-new']");
        }

        takeSnapShotWithHighlight(driver,"//div[@data-testid='Add new field']", GlobalConstants.SCREENSHOTS+"\\Workfront_20221021T194141Z\\ENU\\025_YMb.png");

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}
