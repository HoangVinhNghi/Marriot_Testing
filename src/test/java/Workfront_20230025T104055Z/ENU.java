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


    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}