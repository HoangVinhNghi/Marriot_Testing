package Workfront_20230108T104644Z;

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

public class DEU extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20230108T104644Z\\DEU\\3729471\\DEU"; // the path to store the captured images with  lang code can be changed accordingly
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
        options.addArguments("--lang=de"); //set browser language
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
//        MockID:   YWY	Title is required
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/collection/63cfff24074a430a3f989996
//        1. Login to Workfront 2. Go to Boards 3. Click on Create New button near Collection panel 4. Click Create New

        // Go to Boards
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ");
        waitForPageToLoadCompletely(driver,60);

        sleepInSecond(1);
        waitForElementVisible(driver,"//h2[@id='form-title']");

        // Take SS: YWY	Title is required
        takeSnapShotWithHighlight(driver,"//h2[@id='form-title']",GlobalConstants.SCREENSHOTS+folder+"001_YWY.png");


    }

    @Test
    public void String_002_003() throws Exception {
//        MockID: YXK	Awaiting my approval
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/62668d0f00007fab94235ee296969bc6/tasks
//        1. Login to Workfront 2. Open any project 3. Go to Tasks and open any task 4. Go to Subtask and create some subtasks 5. Select any subtask and start spamming any intent button(in the toolbar)

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        waitForPageToLoadCompletely(driver,60);

        waitForElementVisible(driver,"//button[@data-dd-action-name='manage-widgets']");
        clickToElement(driver,"//button[@data-dd-action-name='manage-widgets']");
        sleepInSecond(1);
        waitForElementVisible(driver,"//button[@data-dd-action-name='add-widget']");
        clickToElement(driver,"//button[@data-dd-action-name='add-widget']");

        // Take SS: YXK	Awaiting my approval
        takeSnapShotWithHighlight(driver,"//*[name()='path' and contains(@d,'M15.5 10a5.5 5.5 0')]/ancestor::div[contains(@class,'spectrum-Card')]//div[@class='spectrum-Card-title']",
                GlobalConstants.SCREENSHOTS+folder+"002_YXK.png");

        // Take SS: YXJ	Items that need my approval
        takeSnapShotWithHighlight(driver,"//*[name()='path' and contains(@d,'M15.5 10a5.5 5.5 0')]/ancestor::div[contains(@class,'spectrum-Card')]//div[@class='spectrum-Card-content']",
                GlobalConstants.SCREENSHOTS+folder+"003_YXJ.png");

    }

    @Test
    public void String_004() throws Exception {
//        MockID: YXD	Due Date By Week
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/62011f0c0004c151deb2f44c092036da/tasks //
        // 1. Login to Workfront
        // 2. Go to Project -> Tasks
        // 3. Click on Grouping button

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/project/62011f0c0004c151deb2f44c092036da/tasks");
        waitForPageToLoadCompletely(driver,60);

        clickToElement(driver,"//button[@data-testid='open-groupingv2-drawer']");
        sleepInSecond(1);
        waitForElementVisible(driver,"//div[@data-checked='true']");
        scrollToElement(driver,"//div[@data-checked='true']");
        sleepInSecond(1);

        // Take SS: YXD	Due Date By Week
        takeSnapShotWithHighlight(driver,"//div[@data-checked='true']/label",  GlobalConstants.SCREENSHOTS+folder+"004_YXD.png");

    }

    @Test
    public void String_005_008_012() throws Exception {
//        MockID: YWv	Add condition
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/6b1db2b6-038a-4ba9-9890-9b06fab40eeb/6f529627-2cdc-4a27-96d7-91452f2e9b6f/table?view=d9745b6d-0dd2-4b9a-93b2-189817bf5dac
        // 1. Login to Workfront
        // 2. Go to Main Menu -> Maestro
        // 3. Click on Add Record Type
        // 4. Click on Filters

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/6b1db2b6-038a-4ba9-9890-9b06fab40eeb/6f529627-2cdc-4a27-96d7-91452f2e9b6f/table?view=d9745b6d-0dd2-4b9a-93b2-189817bf5dac");
        waitForPageToLoadCompletely(driver,60);

        // Take SS: YW/	Filters
        takeSnapShotWithHighlight(driver,"//button[@data-testid='filter-widget-button']",  GlobalConstants.SCREENSHOTS+folder+"005_YWslash.png");

        clickToElement(driver,"//button[@data-testid='filter-widget-button']");
        sleepInSecond(1);
        waitForElementVisible(driver,"//button[@data-testid='filter-content-widget-add-filter']");

        // Take SS: YWv	Add condition
        takeSnapShotWithHighlight(driver,"//button[@data-testid='filter-content-widget-add-filter']",  GlobalConstants.SCREENSHOTS+folder+"006_YWv.png");


        clickToElement(driver,"//button[@data-testid='filter-content-widget-add-filter']");
        sleepInSecond(1);
        clickToElement(driver,"//button[contains(@class,'spectrum-Dropdown-trigger')]");

        // Take SS: YW9	AND
        // Take SS: YW+	OR
        takeSnapShotWithHighlight(driver,"//div[@data-testid='popover']",  GlobalConstants.SCREENSHOTS+folder+"007_008_YW9_YW+.png");

        clickToElement(driver,"//div[contains(@id,'option-and')]");
        sleepInSecond(1);
        clickToElement(driver,"(//button[contains(@class,'spectrum-Dropdown-trigger')])[2]");
        clickToElement(driver,"//span[text()='aa']");
        sleepInSecond(1);
        clickToElement(driver,"(//button[contains(@class,'spectrum-Dropdown-trigger')])[3]");

        // Take SS: YVl	Is not
        takeSnapShotWithHighlight(driver,"(//div[contains(@class,'Menu-itemGrid')])[2]",  GlobalConstants.SCREENSHOTS+folder+"009_YVl.png");
    }

    @Test
    public void String_010_011() throws Exception {
//        MockID: YWn	You must assign a new auto-upgrade option for the affected access levels before you can delete this access level. To view which access levels are affected, see
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/access-levels//
    // 1. Login to Workfront
    // 2. Go to Setup -> Access Levels
    // 3. Select 'Light' access level and click Delete

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/setup/access-levels");
        waitForPageToLoadCompletely(driver,60);

        waitForElementVisible(driver,"//iframe[@data-testid='kamino-shim']");
        switchToIframeByElement(driver,"//iframe[@data-testid='kamino-shim']");
        sleepInSecond(5);

        clickToElement(driver,"(//tr[contains(@class,'listItem ')])[8]");
        sleepInSecond(1);
        clickToElement(driver,"//button[@id='deleteToolbar']");

        switchToDefaultContent(driver);
        switchToIframeByElement(driver,"//iframe[@id='reference-replacement']");

        // Take SS: YWl	This access level is currently in use as an auto-upgrade option.
        takeSnapShotWithHighlight(driver,"//a/parent::p/preceding-sibling::p",  GlobalConstants.SCREENSHOTS+folder+"010_YWl.png");

        // Take SS: YWn	You must assign a new auto-upgrade option for the affected access levels before you can delete this access level. To view which access levels are affected, see
        takeSnapShotWithHighlight(driver,"//a/parent::p",  GlobalConstants.SCREENSHOTS+folder+"011_YWn.png");
    }
    @Test
    public void String_012_013() throws Exception {
//        MockID: YWm	Monthly Decision Allotment
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/licenses
//
// 1. Login to Workfront
// 2. Go to Setup -> System -> Licenses

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/setup/licenses");
        waitForPageToLoadCompletely(driver,60);

        // Take SS: YWm	Monthly Decision Allotment
        takeSnapShotWithHighlight(driver,"//div[@data-testid='monthly-decision-allotment']", GlobalConstants.SCREENSHOTS+folder+"012_YWm.png");


        hoverToElement(driver,"//div[@data-testid='monthly-decision-allotment-value']");
        sleepInSecond(1);
        // Take YW7	proof and document decisions available
        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-styled']", GlobalConstants.SCREENSHOTS+folder+"013_014_YW7.png");

    }

    @Test
    public void String_015() throws Exception {
//        MockID: YWh	Cannot edit description when editing multiple items
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/collection/63dcf02ddc79c2c5761450ed
// 1. Login to Workfront
// 2. Go to Boards
// 3. Click on button View Collection near any collection
// 4. Switch to Card List tab
// 5. Select multiple cards and click Edit

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/collection/63dcf02ddc79c2c5761450ed");
        waitForPageToLoadCompletely(driver,60);

        clickToElement(driver,"//div[@data-key='backlog']");
        sleepInSecond(2);
        checkToCheckboxOrRadio(driver,"(//input[@type='checkbox'])[2]");
        checkToCheckboxOrRadio(driver,"(//input[@type='checkbox'])[3]");
        clickToElement(driver,"//*[name()='path'][contains(@d,'M33.567,8.2,27.8,2.432a1')]/ancestor::button");

        // Take SS: YWh	Cannot edit description when editing multiple items
        takeSnapShotWithHighlight(driver,"((//hr/following-sibling::div//div[contains(@class,'module_sectionContainer')])[2]//span)[5]", GlobalConstants.SCREENSHOTS+folder+"015_YWh.png");
    }
    @Test
    public void String_016() throws Exception {
//        MockID: YW3	Add a filter
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/collection/63dcf02ddc79c2c5761450ed/board/63c8131920ac63ab107aca58
// 1. Login to Workfront
// 2. Go to Boards and open a board
// 3. In the Configure menu click on "Dynamically intake items to board"

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/collection/63dcf02ddc79c2c5761450ed/board/63c8131920ac63ab107aca58");
        waitForPageToLoadCompletely(driver,60);

        waitForElementVisible(driver,"//div[@style='flex-direction: column; align-items: center;']//button");

        // Take SS: YW3	Add a filter
        takeSnapShotWithHighlight(driver,"//div[@style='flex-direction: column; align-items: center;']//button", GlobalConstants.SCREENSHOTS+folder+"016_YW3.png");
    }
    @Test
    public void String_017() throws Exception {
//        MockID: YVD	Work time is the percentage of FTE time that the user is available for actual work, not including overhead. It must be a decimal number between 0 and 1 (for example a 20% availability would be 0.2).	None
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: Direct link: https://adobeloctesting.devtest.workfront-dev.com/user/61f9b69800061c20bc107fe06c49e6ce/details
//
// 1. Login to Workfront
// 2. Go to Main Menu and click on user avatar
// 3. Click on Edit and scroll down to "Work Time" field

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/user/61f9b69800061c20bc107fe06c49e6ce/details");
        waitForPageToLoadCompletely(driver,60);

        clickToElement(driver,"//button[@data-testid='more-testid-trigger-button']");
        clickToElement(driver,"//li[@data-testid='edit-user']");
        sleepInSecond(2);

        waitForElementVisible(driver,"//iframe[@id='form-user-settings']");
        switchToIframeByElement(driver,"//iframe[@id='form-user-settings']");
        sleepInSecond(1);

        clickToElement(driver,"(//ul[@class='scrollNav']/li)[6]");
        sleepInSecond(1);
        hoverToElement(driver,"//li[@name='workTime']/label/img");
        sleepInSecond(1);

        // Take SS: YVD	Work time is the percentage of FTE time that the user is available for actual work, not including overhead. It must be a decimal number between 0 and 1 (for example a 20% availability would be 0.2).	None
        takeSnapShotWithHighlight(driver,"//div[@data-testid='tooltip-popup']", GlobalConstants.SCREENSHOTS+folder+"017_YVD.png");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}