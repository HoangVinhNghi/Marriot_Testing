package Workfront_20230025T104055Z;

import com.github.javafaker.HowIMetYourMother;
import common.AbstractPage;
import common.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


import java.util.concurrent.TimeUnit;

public class ENU extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20230025T104055Z\\ENU\\"; // the path to store the captured images with  lang code can be changed accordingly
    // Select the lang code accordingly
    String lang_EN ="--lang=en\"";
    String lang_DE ="de";
    String lang_ES ="--lang=es";
    String lang_FR ="--lang=fr";
    String lang_IT ="--lang=it";
    String lang_JP ="--lang=ja-JP";
    String lang_PB ="--lang=pt-BR";

    @BeforeClass
    public void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Set language
        options.addArguments("--lang=en"); //set browser language
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(GlobalConstants.APP_URL);
        sendKeyToElement(driver, "//input[@id='username']", GlobalConstants.ACCOUNT);
        sendKeyToElement(driver, "//input[@id='password']", GlobalConstants.PASSWORD);
        clickToElement(driver, "//button[@type='submit']");
        waitForElementVisible(driver, "//div[@id='page-content']");
    }

    //board
    @Test
    public void String_001() throws Exception {
//        Board
//        MockID: YT+	Search text input field
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/63ea36fc94a5005667f58c53
//        1. Login to Workfront 2. Go to Boards and open any board 3. Click on Search field 4. Click on info icon near search field

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/63ea36fc94a5005667f58c53");
        waitForPageToLoadCompletely(driver,60);

        //3. Click on Search field
        waitForElementVisible(driver,"//div[@data-testid='board-rail-controls']//*[name()='path' and contains(@d,'M33.173,30.215,25.4,22.443A12.826,12.826')]/ancestor::button");
        clickToElement(driver,"//div[@data-testid='board-rail-controls']//*[name()='path' and contains(@d,'M33.173,30.215,25.4,22.443A12.826,12.826')]/ancestor::button");

        //4. Click on info icon near search field
        waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M20.18127,25.932a1.83345,1.83345,0,0,1-1.95444')]/ancestor::button");
        clickToElement(driver,"//*[name()='path' and contains(@d,'M20.18127,25.932a1.83345,1.83345,0,0,1-1.95444')]/ancestor::button");

        // Take SS: YT+
        waitForElementVisible(driver,"//div[@data-testid='popover']//h2[contains(@id,'react-aria')]");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='popover']//h2[contains(@id,'react-aria')]", GlobalConstants.SCREENSHOTS+folder+"001_YT+.png");

    }

    //form-builder
    @Test
    public void String_002() throws Exception {
//        MockID: YUT	This object type doesn't support the Limited Edit permission, which is selected for one or more section breaks in the custom form. Confirm that you want those section breaks to use the Edit permission instead.
//              YUS	This will also affect any custom fields that are not placed below a section break in the form.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ
//        1. Login to Workfront 2. Go to Setup -> Custom Forms -> New Custom Form -> Switch to new view
//        3. Click on Default Custom Form Section and select "Limited Edit" in all dropdowns 4. Click on + near Object Type and select Group

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ");
        waitForPageToLoadCompletely(driver,60);

        //step 3
        clickToElement(driver,"//div[@data-testid='section-container']");
        waitForElementVisible(driver,"(//button[@aria-haspopup='listbox'])[2]");
        clickToElement(driver,"(//button[@aria-haspopup='listbox'])[2]");
        clickToElement(driver,"(//div[@role='listbox']//div[@role='option'])[2]");

        waitForElementVisible(driver,"(//button[@aria-haspopup='listbox'])[3]");
        clickToElement(driver,"(//button[@aria-haspopup='listbox'])[3]");
        clickToElement(driver,"(//div[@role='listbox']//div[@role='option'])[1]");

        //step 4
        clickToElement(driver,"//button[contains(@aria-haspopup,'true')]");
        clickToElement(driver,"//li[@data-key='GROUP']");

        // Take SS: YUT YUS
        waitForElementVisible(driver,"//div[@data-testid='modal']//section[contains(@class,'spectrum-Dialog-content')]");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='modal']//section[contains(@class,'spectrum-Dialog-content')]", GlobalConstants.SCREENSHOTS+folder+"002_YUT_YUS.png");

    }
    @Test
    public void String_003() throws Exception {
//        MockID: YUR	No boards added yet
        // YUO Grant Access
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/
//        1. Login to Workfront 2. Go to Setup -> Custom Forms -> New Custom Form -> Switch to new view 3. Click on "Default Custom Form Section" field

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ");
        waitForPageToLoadCompletely(driver,60);
        //step3
        clickToElement(driver,"//div[@data-testid='section-container']");
        //Take YUR
        takeSnapShotWithHighlight(driver,"//div[@style='margin-top: 8px;']", GlobalConstants.SCREENSHOTS+folder+"003_YUR_YUO.png");

    }
    @Test
    public void String_004() throws Exception {
//        MockID: YUP	Add object type
        // YUO Grant Access
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ
//        1. Login to Workfront 2. Go to Setup -> Custom Forms -> New Custom Form -> Switch to new view 3. Right click on "+" button and select inspect (aria-label string)

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ");
        waitForPageToLoadCompletely(driver,60);
        //step3
        //rightClickToElement(driver,"//button[contains(@aria-haspopup,'true')]");

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_F12);
        robot.keyRelease(KeyEvent.VK_F12);
        inspectElement(driver,"//button[contains(@aria-haspopup,'true')]");

        //Take YUP
        captureScreen(GlobalConstants.SCREENSHOTS+folder+"004_YUP.png");


    }
    @Test
    public void String_005() throws Exception {
//        MockID: YUQ	{0} copy
        // YUO Grant Access
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ
//        1. Login to Workfront 2. Go to Setup -> Custom Forms -> New Custom Form -> Switch to new view 3. Add any field and name it 123 4. Click on Copy button on the field

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ");
        waitForPageToLoadCompletely(driver,60);
        //step3
        waitForElementVisible(driver,"//img[@alt='customform.single.line.new']");
        clickToElement(driver,"//img[@alt='customform.single.line.new']");
        sendKeyToElement(driver,"(//input[@type='text'])[3]","123" + getRandomNumber());
        //step 4
        clickToElement(driver,"//button[@data-tracking-id='copy-field']");

        //Take YUQ
        takeSnapShotWithHighlight(driver,"(//label[contains(@id,'field')])[2]",GlobalConstants.SCREENSHOTS+folder+"005_YUP.png");


    }
    @Test
    public void String_006() throws Exception {
//        MockID: YUJ	Label
    //          YUD Name
    //          YUG	Instructions

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ
//        1. Login to Workfront 2. Go to Setup -> Custom Forms -> New Custom Form -> Switch to new view 3. Add any field and name it 123

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ");
        waitForPageToLoadCompletely(driver,60);
        //step3
        waitForElementVisible(driver,"//img[@alt='customform.single.line.new']");
        clickToElement(driver,"//img[@alt='customform.single.line.new']");

        //Take YUJ
        takeSnapShotWithHighlight(driver,"(//label[contains(@id,'react-aria')])[1]",GlobalConstants.SCREENSHOTS+folder+"006_YUJ.png");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"(//label[contains(@id,'react-aria')])[2]",GlobalConstants.SCREENSHOTS+folder+"006_YUD.png");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"(//label[contains(@id,'react-aria')])[3]",GlobalConstants.SCREENSHOTS+folder+"006_YUG.png");


    }
    @Test
    public void String_007() throws Exception {
//        MockID: YT2	This choice doesn’t match the selected format. Change your choice value or change the format.

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ
//        1. Login to Workfront 2. Go to Setup -> Custom Forms -> New Custom Form -> Switch to new view 3. Add a dropdown field and set the choice vaues to "a'' 4. Change drodown format to "Currency"

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ");
        waitForPageToLoadCompletely(driver,60);
        //step3
        waitForElementVisible(driver,"//img[@alt='customform.dropdown']");
        clickToElement(driver,"//img[@alt='customform.dropdown']");

        clickToElement(driver,"(//div[contains(@class,'spectrum-Dropdown')])[2]");
        clickToElement(driver,"(//div[@role='option'])[2]");
        sleepInSecond(1);
        //Take YUJ
        waitForElementVisible(driver,"(//div[contains(@class,'spectrum-HelpText')])[6]");
        takeSnapShotWithHighlight(driver,"(//div[contains(@class,'spectrum-HelpText')])[6]",GlobalConstants.SCREENSHOTS+folder+"007_YT2.png");

    }

    //Template
    @Test
    public void String_008() throws Exception {
//        MockID: YTm	Start typing template name, Reference Number, or enter the template ID

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/template/63f75d2c00007794d1f2e2bfa7a7f9cb/tasks
//        1. Login to Workfront 2. Go to Templates 3. Open any template with tasks 4. Select all template tsks and click on 3 dots (...) 5. Select 'Move to..'

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/template/6241ab1e00001921338f03c34ec79beb/tasks");
        waitForPageToLoadCompletely(driver,60);

        // Click three dots button > Move to
        sleepInSecond(1);
        checkToCheckboxOrRadio(driver,"//div[@data-test-id='header-checkbox']");
        clickToElement(driver,"//button[@data-testid='templatetask-more-dropdown']");
        clickToElement(driver,"(//li[contains(@data-testid,'option')])[1]");

        //Take YTm
        waitForElementVisible(driver,"//div[@data-testid='destinationTemplate-input-wrapper']");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='destinationTemplate-input-wrapper']",GlobalConstants.SCREENSHOTS+folder+"008_YTm.png");
    }
    @Test
    public void String_009() throws Exception {
//        MockID: YTu	You must select a destination template to view more options

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/template/63f75d2c00007794d1f2e2bfa7a7f9cb/tasks
//        1. Login to Workfront 2. Go to Templates 3. Open any template with tasks
//        4. Select all template tsks and click on 3 dots (...) 5. Select 'Move to..' 6. Mouse over grayed steps under 'Details'

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/template/6241ab1e00001921338f03c34ec79beb/tasks");
        waitForPageToLoadCompletely(driver,60);

        // Click three dots button > Move to
        sleepInSecond(1);
        checkToCheckboxOrRadio(driver,"//div[@data-test-id='header-checkbox']");
        clickToElement(driver,"//button[@data-testid='templatetask-more-dropdown']");
        clickToElement(driver,"(//li[contains(@data-testid,'option')])[1]");
//      6. Mouse over grayed steps under 'Details'
        hoverToElement(driver,"//div[@data-testid='section-nav-item-parentTemplateTaskSection']");

        //Take YTu
        waitForElementVisible(driver,"//div[@data-testid='tooltip-styled']");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']",GlobalConstants.SCREENSHOTS+folder+"009_YTu.png");
    }
    @Test
    public void String_010() throws Exception {
//        MockID: YTj	Any documents attached to these template {__mlm_low_tasks} will be deleted and placed in the Recycle Bin for 30 days. Documents can be recovered only by an administrator.
        // YTh          Select the destination template {__mlm_low_task} that you want as the parent of this template {__mlm_low_task}.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/template/63f75d2c00007794d1f2e2bfa7a7f9cb/tasks
//          1. Login to Workfront
// 2. Go to Templates
// 3. Open any template with tasks
// 4. Select all template tasks and click on 3 dots (...)
// 5. Select 'Move to..'
// 6. Select any destination template
// 7. Uncheck 'Select all' under 'Options'

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/template/6241ab1e00001921338f03c34ec79beb/tasks");
        waitForPageToLoadCompletely(driver,60);

        // Click three dots button > Move to
        sleepInSecond(1);
        checkToCheckboxOrRadio(driver,"//div[@data-test-id='header-checkbox']");
        clickToElement(driver,"//button[@data-testid='templatetask-more-dropdown']");
        clickToElement(driver,"(//li[contains(@data-testid,'option')])[1]");

        //select Destination Template
        clickToElement(driver,"//input[@id='field-destinationTemplate']");
        sendKeyToElement(driver,"//input[@id='field-destinationTemplate']","contracted");
        clickToElement(driver,"(//span[contains(@data-testid,'option-listoption')])[1]");
// 7. Uncheck 'Select all' under 'Options'
        uncheckToCheckbox(driver,"//input[@id='select-all-options']");
        //Take YTj
        waitForElementVisible(driver,"//div[@data-testid='options-warning']");
        sleepInSecond(3);
        takeSnapShotWithHighlight(driver,"//div[@data-testid='options-warning']",GlobalConstants.SCREENSHOTS+folder+"010_YTj.png");

        takeSnapShotWithHighlight(driver,"//div[@data-testid='toolbar-primary-area__project_parent_tasks']",GlobalConstants.SCREENSHOTS+folder+"010_YTh.png");
    }
    @Test
    public void String_011() throws Exception {
//        MockID: YTe	Any documents attached to this template {__mlm_low_task} will be deleted and placed in the Recycle Bin for 30 days. Documents can be recovered only by an administrator.

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/template/63f75d2c00007794d1f2e2bfa7a7f9cb/tasks
//          1. Login to Workfront 2. Go to Templates 3. Open any template with tasks 4. Select 1 template task and click on 3 dots (...)
//          5. Select 'Move to..' 6. Select any destination template 7. Uncheck 'Select all' under 'Options'

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/template/6241ab1e00001921338f03c34ec79beb/tasks");
        waitForPageToLoadCompletely(driver,60);

        //4. Select 1 template task and click on 3 dots (...)
        //5. Select 'Move to..'
        sleepInSecond(1);
        checkToCheckboxOrRadio(driver,"(//div[@data-test-id='row-checkbox'])[1]");
        clickToElement(driver,"//button[@data-testid='templatetask-more-dropdown']");
        clickToElement(driver,"(//li[contains(@data-testid,'option')])[1]");

        //select Destination Template
        clickToElement(driver,"//input[@id='field-destinationTemplate']");
        sendKeyToElement(driver,"//input[@id='field-destinationTemplate']","contracted");
        clickToElement(driver,"(//span[contains(@data-testid,'option-listoption')])[1]");
// 7. Uncheck 'Select all' under 'Options'
        uncheckToCheckbox(driver,"//input[@id='select-all-options']");
        //Take YTe
        waitForElementVisible(driver,"//div[@data-testid='options-warning']");
        sleepInSecond(3);
        takeSnapShotWithHighlight(driver,"//div[@data-testid='options-warning']",GlobalConstants.SCREENSHOTS+folder+"011_YTe.png");

            }



    //Setup
    @Test
    public void String_016_030() throws Exception {
//        MockID:
//        R9F   Restrict timesheet editing to owners and administrators.
        //UiW	Restrict hour editing to owners and administrators.
        //Rzp	Where users can log time
        //SCk	Directly on {__mlm_low_projects}.
        //RJz	On {__mlm_low_projects} that are complete.
//        SXV	On {__mlm_low_projects} that are dead.
        //TJ8	Pre-populate timesheets
        //SIH	{__mlm_up_tasks} and {__mlm_low_issues} that have been completed.
        //SPQ	{__mlm_up_tasks} and {__mlm_low_issues} that have Planned Dates in timesheet's date range.
        //SCZ	Deleted {__mlm_low_projects}, {__mlm_low_tasks}, and {__mlm_low_issues}
//        RY9	{__mlm_up_projects}
        //Rg1	If the {__mlm_low_project} is later restored, the time remains on the timesheet
        //SJP	{__mlm_up_tasks} and {__mlm_low_issues}
        //SFh	Move any logged time to the parent {__mlm_low_project}.
        //R0W	If the {__mlm_low_task} or {__mlm_low_issue} is later restored, the time remains on the {__mlm_low_project}

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/timesheet-preferences
//          1. Login to Workfront 2. Go to Setup -> Timesheets & Hours -> Preferences 3. Scroll down

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/setup/timesheet-preferences");
        waitForPageToLoadCompletely(driver,60);


        //Take screenshot
        waitForElementVisible(driver,"//div[@data-test-id='timesheet-preferences-restrict-owner-and-admin']");
        takeSnapShotWithHighlight(driver,"//div[@data-test-id='timesheet-preferences-restrict-owner-and-admin']",GlobalConstants.SCREENSHOTS+folder+"016_017_R9F_UiW.png");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"(//h3)[2]",GlobalConstants.SCREENSHOTS+folder+"018_Rzp.png");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"//div[@data-test-id='logging-time']",GlobalConstants.SCREENSHOTS+folder+"019_020_021_SCk_RJz_SXV.png");
        sleepInSecond(1);
        scrollToElement(driver,"(//h3)[3]");
        takeSnapShotWithHighlight(driver,"(//h3)[3]",GlobalConstants.SCREENSHOTS+folder+"022_TJ8.png");
        sleepInSecond(1);
        scrollToElement(driver,"//label[@data-testid='timesheet.preferences.prepopulatewith.completed']");
        takeSnapShotWithHighlight(driver,"//label[@data-testid='timesheet.preferences.prepopulatewith.completed']",GlobalConstants.SCREENSHOTS+folder+"023_SIH.png");
        scrollToElement(driver,"//label[@data-testid='timesheet.preferences.prepopulatewith.planneddates']");
        takeSnapShotWithHighlight(driver,"//label[@data-testid='timesheet.preferences.prepopulatewith.planneddates']",GlobalConstants.SCREENSHOTS+folder+"024_SPQ.png");
        scrollToElement(driver,"(//h3)[4]");
        takeSnapShotWithHighlight(driver,"(//h3)[4]",GlobalConstants.SCREENSHOTS+folder+"025_SCZ.png");
        takeSnapShotWithHighlight(driver,"//legend[@id='deleteProjects']",GlobalConstants.SCREENSHOTS+folder+"026_RY9.png");
        takeSnapShotWithHighlight(driver,"(//div[@data-test-id='alert-component-info'])[1]",GlobalConstants.SCREENSHOTS+folder+"027_Rg1.png");
        takeSnapShotWithHighlight(driver,"//legend[@id='deleteTasksIssues']",GlobalConstants.SCREENSHOTS+folder+"028_SJP.png");
        takeSnapShotWithHighlight(driver,"//label[@for='timesheet.preferences.movehours.taskissuedelete.on.new']",GlobalConstants.SCREENSHOTS+folder+"029_SFh.png");
        takeSnapShotWithHighlight(driver,"(//div[@data-test-id='alert-component-info'])[2]",GlobalConstants.SCREENSHOTS+folder+"030_R0W.png");

    }
    @Test
    public void String_031() throws Exception {
//        MockID:
//        S9i	General preferences

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/system-preferences
//         1. Login to Workfront 2. Go to Setup 3. Go to System, choose Preferences

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/setup/system-preferences");
        waitForPageToLoadCompletely(driver,60);

        //Take screenshot
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");
        waitForElementVisible(driver,"(//legend)[2]");
        takeSnapShotWithHighlight(driver,"(//legend)[2]",GlobalConstants.SCREENSHOTS+folder+"031_S9i.png");

    }
    @Test
    public void String_032() throws Exception {
//        MockID:
//        YT5	Role Tag

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/job-roles
//         1. Login to Workfront 2. Go to Setup -> Job Roles 3. Click on New Job Role 4. Click on "Add new tagged rate"

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/setup/job-roles");
        waitForPageToLoadCompletely(driver,60);

        //step 3 click on New Job Role
        switchToIframeByElement(driver,"//iframe[@id='main-frame']");
        waitForElementVisible(driver,"//span[@class='button-icon']");
        clickToElement(driver,"//span[@class='button-icon']");
        switchToDefaultContent(driver);
        waitForElementVisible(driver,"//button[@theme='default']");
        clickToElement(driver,"//button[@theme='default']");


        //Take screenshot
        waitForElementVisible(driver,"//label[@id='roleTag-label']");
        takeSnapShotWithHighlight(driver,"//label[@id='roleTag-label']",GlobalConstants.SCREENSHOTS+folder+"032_YT5.png");

    }

    //Timesheet
    @Test
    public void String_033() throws Exception {
//        MockID:
        //
//        YU2	For delete row press Control+Alt+Minus
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//         1. Login to Workfront 2. Go to Timesheets 3. Open any timesheet with 'Open' status
//         4. If there's no 'Remove' icon under project's title then create new row ('+' icon) 5. Mouse over 'Remove' icon note: string is in Inspector

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        //step 4. If there's no 'Remove' icon under project's title then create new row ('+' icon)
        clickToElement(driver,"//button[contains(@data-testid,'add-button')]");
        waitForElementVisible(driver,"//button[@data-testid='delete-entry-button']");
        inspectElement(driver,"//button[@data-testid='delete-entry-button']");

        //Take screenshot YU2
        captureScreen(GlobalConstants.SCREENSHOTS+folder+"033_YU2.png");

    }
    @Test
    public void String_034() throws Exception {
//        MockID:
//        YUn	For add {0} to timesheet press Alt+P

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//         1. Login to Workfront 2. Go to Timesheets 3. Open any timesheet with 'Open' status
//         4. If there's no 'Remove' icon under project's title then create new row ('+' icon) 5. Mouse over 'Remove' icon note: string is in Inspector

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        //4. Add any project to timesheet (Pin icon)
        clickToElement(driver,"//button[contains(@data-testid,'add-button')]");
        inspectElement(driver,"(//button[contains(@data-testid,'pinned:false')])[2]");

        //Take screenshot YUn
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        sleepInSecond(3);
        captureScreen(GlobalConstants.SCREENSHOTS+folder+"034_YUn.png");

    }
    @Test
    public void String_035() throws Exception {
//        MockID:
//        YUw	For remove {0} from timesheet press Alt+P

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//         1. Login to Workfront 2. Go to Timesheets 3. Open any timesheet with 'Open' status
//         4. If there's no 'Remove' icon under project's title then create new row ('+' icon) 5. Mouse over 'Remove' icon note: string is in Inspector

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);


        //4. Select any task and mouse over Pin icon

        inspectElement(driver,"//span[contains(@data-testid,'pinned:true-tooltip')]");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        //Take screenshot YUn
        sleepInSecond(3);
        captureScreen(GlobalConstants.SCREENSHOTS+folder+"035_YUw.png");


    }
    @Test
    public void String_036() throws Exception {
//        MockID:
        //YUi   For add row press Control+Alt+Plus
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//         1. Login to Workfront 2. Go to Timesheets 3. Open any timesheet with 'Open' status
//         4. If there's no 'Remove' icon under project's title then create new row ('+' icon) 5. Mouse over 'Remove' icon note: string is in Inspector

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        //Take screenshot YUi
        waitForElementVisible(driver,"//span[contains(@data-testid,'add-button')]");
        inspectElement(driver,"//span[contains(@data-testid,'add-button')]");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        sleepInSecond(3);
        captureScreen(GlobalConstants.SCREENSHOTS+folder+"036_YUi.png");

    }
    @Test
    public void String_037() throws Exception {
//        MockID:
        //YU3	Collapse all

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//        1. Login to Workfront
//        2. Go to Timesheets
//        3. Open any timesheet with 'Open' status
//        4. Mouse over arrow down icon (Collapse) near to 'Name'

        // 2. Go to Timesheets
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        //3. Open any timesheet with 'Open' status

        //4. Mouse over arrow down icon (Collapse) near to 'Name'
        hoverToElement(driver,"//button[@data-testid='expand-button-all']");
        clickToElement(driver,"//button[contains(@data-testid,'add-button')]");
        clickToElement(driver,"//button[contains(@data-testid,'add-button')]");
        clickToElement(driver,"//button[contains(@data-testid,'add-button')]");
        hoverToElement(driver,"//button[@data-testid='expand-button-all']");
        waitForElementVisible(driver,"//div[@data-testid='tooltip-styled']");
        //take screenshots
        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']",GlobalConstants.SCREENSHOTS+folder+"037_YU3.png");

    }
    @Test
    public void String_038() throws Exception {
//        MockID:
        //YUU	Collapse all (Shift+Alt+Up arrow)
        //YUv	Expand all (Shift+Alt+Down arrow)
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//        1. Login to Workfront
//        2. Go to Timesheets
//        3. Open any timesheet with 'Open' status
//        4. Mouse over arrow down icon (Collapse) near to 'Name'

        // 2. Go to Timesheets
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        //3. Open any timesheet with 'Open' status

        //4. Mouse over arrow down icon (Collapse) near to 'Name'
        hoverToElement(driver,"//button[@data-testid='expand-button-all']");
        waitForElementVisible(driver,"//div[@data-testid='tooltip-styled']");
        //take screenshots
        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']",GlobalConstants.SCREENSHOTS+folder+"038_YUU.png");


    }
    @Test
    public void String_039() throws Exception {
//        MockID:

        //YUv	Expand all (Shift+Alt+Down arrow)
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//        1. Login to Workfront
//        2. Go to Timesheets
//        3. Open any timesheet with 'Open' status
//        4. Mouse over arrow down icon (Collapse) near to 'Name'

        // 2. Go to Timesheets
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        //3. Open any timesheet with 'Open' status

        //4. Mouse over arrow down icon (Collapse) near to 'Name'
        clickToElement(driver,"//button[@data-testid='expand-button-all']");
        hoverToElement(driver,"//button[@data-testid='expand-button-all']");

        waitForElementVisible(driver,"//div[@data-testid='tooltip-styled']");
        //take screenshots
        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']",GlobalConstants.SCREENSHOTS+folder+"039_YUv.png");


    }
    @Test
    public void String_040() throws Exception {
//        MockID:
        //YUz	Remove {0} from timesheet (Alt+P)
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//        1. Login to Workfront
//        2. Go to Timesheets
//        3. Open any timesheet with 'Open' status
//        4. Add any project to timesheet (Pin icon) 5. Mouse over that Pin icon

        // 2. Go to Timesheets
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        //3. Open any timesheet with 'Open' status
        //4. Add any project to timesheet (Pin icon)
        clickToElement(driver,"//button[contains(@data-testid,'add-button')]");

        // 5. Mouse over that Pin icon

        hoverToElement(driver,"(//button[contains(@data-testid,'pinned:true')])[1]");
        waitForElementVisible(driver,"//div[@data-testid='tooltip-styled']");
        //take screenshots
        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']",GlobalConstants.SCREENSHOTS+folder+"040_YUz.png");

    }
    @Test
    public void String_041() throws Exception {
//        MockID:
        //YUy	Delete row (Ctrl+Alt+-)
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//        1. Login to Workfront
//        2. Go to Timesheets
//        3. Open any timesheet with 'Open' status
//        4. If there's no 'Remove' icon under project's title then create new row ('+' icon)
//        5. Select row and mouse over 'Remove' icon

        // 2. Go to Timesheets
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        //3. Open any timesheet with 'Open' status
        //4. If there's no 'Remove' icon under project's title then create new row ('+' icon)
        clickToElement(driver,"//button[contains(@data-testid,'add-button')]");
        clickToElement(driver,"//button[@data-testid='expand-button-all']");
        hoverToElement(driver,"//button[@data-testid='expand-button-all']");
        clickToElement(driver,"//button[@data-testid='expand-button-all']");
        clickToElement(driver,"(//div[contains(@data-testid,'entry-name-cell')])[2]");


        // 5. Select row and mouse over 'Remove' icon
        waitForElementVisible(driver,"//button[@data-testid='delete-entry-button']");
        hoverToElement(driver,"//button[@data-testid='delete-entry-button']");
        waitForElementVisible(driver,"//div[@data-testid='tooltip-styled']");
        //take screenshots
        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']",GlobalConstants.SCREENSHOTS+folder+"041_YUy.png");

    }
    @Test
    public void String_042() throws Exception {
//        MockID:
        //YUx	Collapse {0} (Shift+Alt+Up arrow)
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//        1. Login to Workfront
//        2. Go to Timesheets
//        3. Open any timesheet with 'Open' status
//        4. Mouse over arrow down icon (Collapse) near to project name

        // 2. Go to Timesheets
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        //3. Open any timesheet with 'Open' status
        //4. Mouse over arrow down icon (Collapse) near to project name
        clickToElement(driver,"(//button[contains(@data-testid,'expand-button')])[1]");
        clickToElement(driver,"(//button[contains(@data-testid,'expand-button')])[1]");
        hoverToElement(driver,"(//button[contains(@data-testid,'expand-button')])[1]");
        waitForElementVisible(driver,"//div[@data-testid='tooltip-styled']");
        //take screenshots
        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']",GlobalConstants.SCREENSHOTS+folder+"042_YUx.png");


    }
    @Test
    public void String_043() throws Exception {
//        MockID:
        //YUV	Expand {0} (Shift+Alt+Down arrow)
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//        1. Login to Workfront
//        2. Go to Timesheets
//        3. Open any timesheet with 'Open' status
//        4. Mouse over arrow down icon (Collapse) near to project name

        // 2. Go to Timesheets
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        //click collapse/expand button again
        clickToElement(driver,"(//button[contains(@data-testid,'expand-button')])[1]");
        hoverToElement(driver,"(//button[contains(@data-testid,'expand-button')])[1]");
        waitForElementVisible(driver,"//div[@data-testid='tooltip-styled']");
        //take screenshots
        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']",GlobalConstants.SCREENSHOTS+folder+"043_YUV.png");

    }

    @Test
    public void String_044() throws Exception {
//        MockID:
        //YUo	Add row


//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//         1. Login to Workfront 2. Go to Timesheets 3. Open any timesheet with 'Open' status
//         4. Mouse over plus (' + ') icon
        //4-1. Select any task and mouse over Pin icon
        //4-2. Mouse over plus (' + ') icon

        // Go to Timesheet
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        //3. Open any timesheet with 'Open' status
        //4. Mouse over plus (' + ') icon
        hoverToElement(driver,"//button[contains(@data-testid,'add-button')]");
        waitForElementVisible(driver,"//div[@data-testid='tooltip-styled']");
        //take screenshots
        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']",GlobalConstants.SCREENSHOTS+folder+"044_YUo.png");
    }
    @Test
    public void String_045() throws Exception {
//        MockID:

        //YUa	Add {0} to timesheet (Alt+P)
//

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//         1. Login to Workfront 2. Go to Timesheets 3. Open any timesheet with 'Open' status
//         4. Mouse over plus (' + ') icon
        //4-1. Select any task and mouse over Pin icon
        //4-2. Mouse over plus (' + ') icon

        // Go to Timesheet
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        //4-1. Select any task and mouse over Pin icon
        clickToElement(driver,"//button[contains(@data-testid,'add-button')]");
        sleepInSecond(1);
        hoverToElement(driver,"(//button[contains(@data-testid,'pinned:false')])[2]");
        waitForElementVisible(driver,"//div[@data-testid='tooltip-styled']");
        //take screenshots
        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']",GlobalConstants.SCREENSHOTS+folder+"045_YUa.png");


    }@Test
    public void String_046() throws Exception {
//        MockID:
//        YUe	Add row (Ctrl+Alt++)

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//         1. Login to Workfront 2. Go to Timesheets 3. Open any timesheet with 'Open' status
//         4. Mouse over plus (' + ') icon
        //4-1. Select any task and mouse over Pin icon
        //4-2. Mouse over plus (' + ') icon

        // Go to Timesheet
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        //4-2. click and mouse over plus icon
        clickToElement(driver,"//img[@alt='IssueHeroIcon']");
        sleepInSecond(1);
        hoverToElement(driver,"//button[contains(@data-testid,'add-button')]");
        waitForElementVisible(driver,"//div[@data-testid='tooltip-styled']");
        //take screenshots
        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']",GlobalConstants.SCREENSHOTS+folder+"046_YUe.png");

    }

    @Test
    public void String_047() throws Exception {
//        MockID:
        //YUk	go to {0} (Enter)


//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//         1. Login to Workfront
// 2. Go to Timesheets
// 3. Open any timesheet with 'Open' status
// 4. Select any project and mouse over arrow icon after project's title

        // Go to Timesheet
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        //3. Open any timesheet with 'Open' status
        //4. Select any project and mouse over arrow icon after project's title
        hoverToElement(driver,"(//a[@data-testid='row-name-link'])[1]");
        waitForElementVisible(driver,"//div[@data-testid='tooltip-styled']");
        //take screenshots
        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']",GlobalConstants.SCREENSHOTS+folder+"047_YUk.png");

    }
    @Test
    public void String_048() throws Exception {
//        MockID:
        //YUd	Press Shift + F2 for comment
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//         1. Login to Workfront 2. Go to Timesheets 3. Open any timesheet with 'Open' status
//         4. Add any project to timesheet (Pin icon)
//         5. Enter some number into time fields and mouse hover the comment button

        // Go to Timesheet
        //3. Open any timesheet with 'Open' status
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        //5. Enter some number into time fields and mouse hover the comment button
        //clickToElement(driver,"(//div[@class='grid-cell hour-cell'])[66]");
        sendKeyToElement(driver,"(//input[contains(@data-testid,'hour-input')])[20]","2");
        clickToElement(driver,"(//input[contains(@data-testid,'hour-input')])[20]");
        waitForElementVisible(driver,"//button[contains(@data-testid,'comment-plus-button')]");
        hoverToElement(driver,"//button[contains(@data-testid,'comment-plus-button')]");

        //take screenshots
        captureScreen(GlobalConstants.SCREENSHOTS+folder+"048_YUd.png");

    }

    @Test
    public void String_049() throws Exception {
//        MockID:
        //YUc	For collapse all press Shift+Alt+Up Arrow and for expand all press Shift+Alt+Down Arrow
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//         1. Login to Workfront
// 2. Go to Timesheets
// 3. Open any timesheet with 'Open' status
// 4. Mouse over arrow down icon (Collapse) near to 'Name'
// note: string is in Inspector

        // 2. Go to Timesheets
        // 3. Open any timesheet with 'Open' status
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        // 4. Mouse over arrow down icon (Collapse) near to 'Name'
        inspectElement(driver,"//button[@data-testid='expand-button-all']");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        sleepInSecond(3);

        //Take screenshot YUc
        captureScreen(GlobalConstants.SCREENSHOTS+folder+"049_YUc.png");

    }
    @Test
    public void String_050() throws Exception {
//        MockID:
        //YUb	To go to {0} press Enter
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//         1. Login to Workfront
// 2. Go to Timesheets
//  3. Open any timesheet with 'Open' status
//  4. Select any project and mouse over arrow icon after project's title note: string is in Inspector

        // 2. Go to Timesheets
        // 3. Open any timesheet with 'Open' status
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        // 4. Select any project and mouse over arrow icon after project's title note: string is in Inspector
        inspectElement(driver,"(//a[@data-testid='row-name-link'])[1]");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        //Take screenshot YUc
        captureScreen(GlobalConstants.SCREENSHOTS+folder+"050_YUb.png");

    }
   @Test
    public void String_051() throws Exception {
//        MockID:
        //YU5	For expand {0} press shift+Alt+Down Arrow and for collapse {0} press Shift+Alt+Up Arrow
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//         1. Login to Workfront
// 2. Go to Timesheets
//  3. Open any timesheet with 'Open' status
//  4. Click on arrow down icon (Collapse) near to project name
// 5. Mouse over arrow up icon (Expand) near to project name
// note: string is in Inspector

        // 2. Go to Timesheets
        // 3. Open any timesheet with 'Open' status
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        // 4. Click on arrow down icon (Collapse) near to project name
        clickToElement(driver,"(//button[contains(@data-testid,'expand-button')])[2]");
        inspectElement(driver,"(//button[contains(@data-testid,'expand-button')])[2]");
       Robot robot = new Robot();
       robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
       robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
       robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
       robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
       robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT);
        //Take screenshot YUc
        captureScreen(GlobalConstants.SCREENSHOTS+folder+"051_YU5.png");

    }
    @Test
    public void String_052() throws Exception {
//        MockID:
        //YUs	Collapse {0}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//         1. Login to Workfront 2. Go to Timesheets
//         3. Open any timesheet with 'Open' status 4. Mouse over arrow down icon (Collapse) near to project name

        // Go to Timesheet
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        //4. Mouse over arrow down icon (Collapse) near to project name
        hoverToElement(driver,"(//button[contains(@data-testid,'expand-button')])[2]");
        waitForElementVisible(driver,"//div[@data-testid='tooltip-styled']");
        //take screenshots
        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']",GlobalConstants.SCREENSHOTS+folder+"052_YUs.png");

    }
    @Test
    public void String_053() throws Exception {
//        MockID:
        //YUm	Delete row
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview
//         1. Login to Workfront 2. Go to Timesheets
//         3. Open any timesheet with 'Open' status 4. If there's no 'Remove' icon under project's title then create new row ('+' icon)
// 5. Mouse over 'Remove' icon

        // Go to Timesheet
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/timesheet/63e2184b00010b51c0c01e6a6d89c66f/overview");
        waitForPageToLoadCompletely(driver,60);

        //4. If there's no 'Remove' icon under project's title then create new row ('+' icon)
        clickToElement(driver,"(//span[contains(@data-testid,'add-button')])[1]");
        hoverToElement(driver,"//button[@data-testid='delete-entry-button']");
        waitForElementVisible(driver,"//div[@data-testid='tooltip-styled']");
        //take screenshots
        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']",GlobalConstants.SCREENSHOTS+folder+"053_YUm.png");

    }

    //home
    @Test
    public void String_054() throws Exception {
//        MockID:
        //YTx	{0}'s documents
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
//         1. Login to Workfront 2. Go to workspaces
//         3. add widget "Mention"
// 5. Mouse over 'Remove' icon

        // Go to Timesheet
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        waitForPageToLoadCompletely(driver,60);

        //take screenshots
        takeSnapShotWithHighlight(driver,"//a[@href='/documents']",GlobalConstants.SCREENSHOTS+folder+"054_YTx.png");

    }
    @Test
    public void String_055() throws Exception {
//        MockID:
        //YTy	{0}'s updates
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
//         1. Login to Workfront 2. Go to workspaces
//         3. add widget "Mention"


        // Go to Timesheet
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        waitForPageToLoadCompletely(driver,60);

        //take screenshots
        scrollToElement(driver,"//a[contains(@href,'/update')]");
        takeSnapShotWithHighlight(driver,"//a[contains(@href,'/update')]",GlobalConstants.SCREENSHOTS+folder+"055_YTy.png");

    }

    // Need to login with alphawfone+cw@gmail.com/Adobe123#
    @Test
    public void String_012_013_014_015() throws Exception {
//        MockID: YTs	You don't have access to edit this template.
                // YTi This template {__mlm_low_task} has a different currency than the destination template. If it has financial fields (cost, expenses, etc) set you may need to manually convert them to the new currency
                // YTg Some of the template {__mlm_low_tasks} have a different currency than the destination template. If they have financial fields (cost, expenses, etc) set you may need to manually convert them to the new currency
                // YTf You do not have access to add template {__mlm_low_tasks} to this template. Select a different template or
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/template/63f75d2c00007794d1f2e2bfa7a7f9cb/tasks
//          1. Login to Workfront 2. Go to Templates and create 2 Templates 3. Share first template to alphawfone+cw@gmail.com/Adobe123# user - Edit rights
//          4. Share second template to alphawfone+cw@gmail.com/Adobe123# user - View rights 5. Login as this user and open first template
//          6. Add some task, select it and click three dots > Move to 7. Select second template as a destination OR
//          1. Login as alphawfone+cw@gmail.com/Adobe123# 2. Go to Restricted Access template https://adobeloctesting.devtest.workfront-dev.com/template/63e9f65c000019d2376367b393c34942/tasks
//          3. Select task and click three dots > Move to 7. Select "Restricted Access 2" template as a destination
        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/template/63e9f65c000019d2376367b393c34942/tasks");
        waitForPageToLoadCompletely(driver,60);

        //logout and login with alphawfone+cw@gmail.com/Adobe123#
        clickToElement(driver,"//button[@data-testid='global-nav-drawer-toggle']");
        clickToElement(driver,"//a[@data-testid='logout']");
        waitForPageToLoadCompletely(driver,60);
        sendKeyToElement(driver,"//input[@id='username']","alphawfone+cw@gmail.com");
        sendKeyToElement(driver,"//input[@id='password']","Adobe123#");
        clickToElement(driver, "//button[@type='submit']");
        waitForElementVisible(driver, "//div[@id='page-content']");


        //4. Select 1 template task and click on 3 dots (...)
        //5. Select 'Move to..'
        sleepInSecond(1);
        checkToCheckboxOrRadio(driver,"(//div[@data-test-id='row-checkbox'])[1]");
        clickToElement(driver,"//button[@data-testid='templatetask-more-dropdown']");
        clickToElement(driver,"(//li[contains(@data-testid,'option')])[1]");

        //select Destination Template Restricted Access 3
        clickToElement(driver,"//input[@id='field-destinationTemplate']");
        sendKeyToElement(driver,"//input[@id='field-destinationTemplate']","Restricted Access 3");
        sleepInSecond(3);
        clickToElement(driver,"(//span[contains(@data-testid,'option-listoption')])[1]");

        //Take YTi
        waitForElementVisible(driver,"//div[@data-testid='lightbox-alert']");
        sleepInSecond(3);
        takeSnapShotWithHighlight(driver,"//div[@data-testid='lightbox-alert']",GlobalConstants.SCREENSHOTS+folder+"012_YTi.png");


        refreshCurrentPage(driver);
        //5. Select 'Move to..'
        sleepInSecond(1);
        checkToCheckboxOrRadio(driver,"(//div[@data-test-id='row-checkbox'])[1]");
        clickToElement(driver,"//button[@data-testid='templatetask-more-dropdown']");
        clickToElement(driver,"(//li[contains(@data-testid,'option')])[1]");
        //select Destination Template Restricted Access 2
        clickToElement(driver,"//input[@id='field-destinationTemplate']");
        sendKeyToElement(driver,"//input[@id='field-destinationTemplate']","Restricted Access 2");
        sleepInSecond(3);
        clickToElement(driver,"(//span[contains(@data-testid,'option-listoption')])[1]");

        //Take YTs & YTf
        waitForElementVisible(driver,"//div[@data-testid='destinationTemplate-input-error']");
        sleepInSecond(3);
        takeSnapShotWithHighlight(driver,"//div[@data-testid='destinationTemplate-input-error']",GlobalConstants.SCREENSHOTS+folder+"013_YTs.png");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='details-page-error-summary']",GlobalConstants.SCREENSHOTS+folder+"014_YTf.png");

// refresh
                openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/template/63e9f65c000019d2376367b393c34942/tasks");
                waitForPageToLoadCompletely(driver,60);

                //4. Select 1 template task and click on 3 dots (...)
                //5. Select 'Move to..'
                sleepInSecond(1);
                checkToCheckboxOrRadio(driver,"//div[@data-test-id='header-checkbox']");
                clickToElement(driver,"//button[@data-testid='templatetask-more-dropdown']");
                clickToElement(driver,"(//li[contains(@data-testid,'option')])[1]");

                //select Destination Template Restricted Access 3
                clickToElement(driver,"//input[@id='field-destinationTemplate']");
                sendKeyToElement(driver,"//input[@id='field-destinationTemplate']","Restricted Access 3");
                sleepInSecond(3);
                clickToElement(driver,"(//span[contains(@data-testid,'option-listoption')])[1]");

                //Take YTg
                waitForElementVisible(driver,"//div[@data-testid='lightbox-alert']");
                sleepInSecond(3);
                takeSnapShotWithHighlight(driver,"//div[@data-testid='lightbox-alert']",GlobalConstants.SCREENSHOTS+folder+"015_YTg.png");
            }
    @Test
    public void String_056() throws Exception {
//        MockID: YUN	No mentions
                //YUM	Mentions will appear here when others add you to updates.

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//         Test User: alphawfone+cw@gmail.com / Adobe123# Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
////         1. Login to Workfront 2. Go to workspaces
////         3. add widget "Mention"

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        waitForPageToLoadCompletely(driver,60);

        //logout and login with alphawfone+cw@gmail.com/Adobe123#
        clickToElement(driver,"//button[@data-testid='global-nav-drawer-toggle']");
        clickToElement(driver,"//a[@data-testid='logout']");
        waitForPageToLoadCompletely(driver,60);
        sendKeyToElement(driver,"//input[@id='username']","alphawfone+cw@gmail.com");
        sendKeyToElement(driver,"//input[@id='password']","Adobe123#");
        clickToElement(driver, "//button[@type='submit']");
        waitForElementVisible(driver, "//div[@id='page-content']");

        //Take screenshot
        takeSnapShotWithHighlight(driver,"//div[@class='flex flex-col items-center']",GlobalConstants.SCREENSHOTS+folder+"056_YUN_YUM.png");

            }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}