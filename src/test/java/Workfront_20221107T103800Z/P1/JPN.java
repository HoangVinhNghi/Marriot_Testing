package Workfront_20221107T103800Z.P1;

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

public class JPN extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20221107T103800Z\\JPN\\3548153\\JPN"; // the path to store the captured images with  lang code can be changed accordingly
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
        options.addArguments("--lang=ja-JP"); //set browser language
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
//        MockID: YRs	Are you sure you want to delete
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/63a01f089a30709d646d5680
//        1. Login to Workfront 2. Go to Boards and open a new board 3. Click three dots -> Delete

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/63e0f237c77c8222346e76a3");
        waitForPageToLoadCompletely(driver,60);

        // Open any existed Board
//        waitForElementVisible(driver,"(//div[@data-testid='dashboard-board-container']//h4)[1]");
//        clickToElement(driver,"(//div[@data-testid='dashboard-board-container']//h4)[1]");

        // Click three dots button > Delete
        sleepInSecond(1);
        waitForElementVisible(driver,"//button[@data-testid='board-menu-button']");
        clickToElement(driver,"//button[@data-testid='board-menu-button']");

        waitForElementVisible(driver,"//li[@data-key='delete']");
        clickToElement(driver,"//li[@data-key='delete']");

        // Take SS: YQy	Custom Data
        takeSnapShotWithHighlight(driver,"//section[contains(@class,'spectrum-Dialog-content')]", GlobalConstants.SCREENSHOTS+folder+"001_YRs.png");

    }

    @Test
    public void String_002() throws Exception {
//        MockID: YRr	Go back to the current Home
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
//        1. Login to Workfront 2. Go to Home page and enter New Home

        // 2. Go to Home page and enter New Home
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        waitForPageToLoadCompletely(driver,60);

        // Take SS: YRr	Custom Data
        takeSnapShotWithHighlight(driver,"//button[@data-tracking-id='new-home-opt-out']", GlobalConstants.SCREENSHOTS+folder+"002_YRr.png");

    }
    @Test
    public void String_003() throws Exception {
//        MockID: YRq	Sorry to see you go!
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
//        1. Login to Workfront 2. Go to Home page and enter New Home 3. Click on Go back to the current Home

        // 2. Go to Home page and enter New Home
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        waitForPageToLoadCompletely(driver,60);

        // 3. Click on Go back to the current Home
        clickToElement(driver,"//button[@data-tracking-id='new-home-opt-out']");

        // Take SS: YRq
        takeSnapShotWithHighlight(driver,"//h2[contains(@id,'react-aria')]", GlobalConstants.SCREENSHOTS+folder+"003_YRq.png");

    }

    @Test
    public void String_004() throws Exception {
//        MockID: YRp	Leave feedback
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
//        1. Login to Workfront 2. Go to Home page and enter New Home

        // 2. Go to Home page and enter New Home
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        waitForPageToLoadCompletely(driver,60);

        // Take SS: YRp	Custom Data
        takeSnapShotWithHighlight(driver,"//a[@data-variant='accent']", GlobalConstants.SCREENSHOTS+folder+"004_YRp.png");

    }
    @Test
    public void String_005() throws Exception {
//     s   MockID: YRh	{count, plural, =0 {} other {# }}{count, plural, =0 {Filter} =1 {Filter} other {Filters}}
//        Tet Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
//        1. Login to Workfront 2. Go to Home page and enter New Home

        // 2. Go to Home page and enter New Home
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        waitForPageToLoadCompletely(driver,60);
// Note: switch button should be enable first
        // Take SS: YRh	1
        waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M30.946,2H3.054a1')]/ancestor::button");
        scrollToElement(driver,"//*[name()='path' and contains(@d,'M30.946,2H3.054a1')]/ancestor::button");
        clickToElement(driver,"//*[name()='path' and contains(@d,'M30.946,2H3.054a1')]/ancestor::button");
        sleepInSecond(10);
        clickToElement(driver,"//input[contains(@value,'task.active')]");
        takeSnapShotWithHighlight(driver,"//*[name()='path' and contains(@d,'M30.946,2H3.054a1')]/ancestor::button", GlobalConstants.SCREENSHOTS+folder+"005_YRh.png");

        // Take SS: YRh	2
        clickToElement(driver,"//input[contains(@value,'task.unassigned')]");
        takeSnapShotWithHighlight(driver,"//*[name()='path' and contains(@d,'M30.946,2H3.054a1')]/ancestor::button", GlobalConstants.SCREENSHOTS+folder+"006_YRh.png");
        clickToElement(driver,"//input[contains(@value,'task.active')]");
        clickToElement(driver,"//input[contains(@value,'task.unassigned')]");
    }

    @Test
    public void String_006() throws Exception {
//     s   MockID: YRg	{count, plural, =0 {} other {# }}Grouping
//        Tet Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
//        1. Login to Workfront 2. Go to Home page and enter New Home 3. In the My Tasks widget select any grouping

        // 2. Go to Home page and enter New Home
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        waitForPageToLoadCompletely(driver,60);

        // Take SS: YRh	1
        waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M34,10H2V3A1,1,0,0,1,3,2H33a1,1,0,0,1,1,1Z')]/ancestor::button");
        scrollToElement(driver,"//*[name()='path' and contains(@d,'M34,10H2V3A1,1,0,0,1,3,2H33a1,1,0,0,1,1,1Z')]/ancestor::button");
        clickToElement(driver,"//*[name()='path' and contains(@d,'M34,10H2V3A1,1,0,0,1,3,2H33a1,1,0,0,1,1,1Z')]/ancestor::button");
        sleepInSecond(10);
        checkToCheckboxOrRadio(driver,"(//div[@id='widget-list-all-tasks-sidepanel']//input[@type='radio'])[2]");
        takeSnapShotWithHighlight(driver,"//*[name()='path' and contains(@d,'M34,10H2V3A1,1,0,0,1,3,2H33a1,1,0,0,1,1,1Z')]/ancestor::button", GlobalConstants.SCREENSHOTS+folder+"007_YRg.png");
        checkToCheckboxOrRadio(driver,"//div[@id='widget-list-all-tasks-sidepanel']//input[@type='radio'])[1]");
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}
