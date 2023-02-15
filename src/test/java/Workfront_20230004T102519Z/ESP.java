package Workfront_20230004T102519Z;

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

public class ESP extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20230004T102519Z\\ESP\\3597465\\ESP\\"; // the path to store the captured images with  lang code can be changed accordingly
    // Select the lang code accordingly
    String lang_EN = "--lang=en\"";
    String lang_DE = "de";
    String lang_ES = "--lang=es";
    String lang_FR = "--lang=fr";
    String lang_IT = "--lang=it";
    String lang_JP = "--lang=ja-JP";
    String lang_PB = "--lang=pt-BR";

    @BeforeClass
    public void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Set language
        options.addArguments("--lang=es"); //set browser language
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
    public void String_001_002() throws Exception {
//        MockID:   YS0	My Requests
        //          YS1	Requests Created By Me
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
//        1. Login to Workfront 2. Go to Home and click on Add Widgets. Delete all widgets there. 3. Click on Add Widgets again

        // 2. Go to Home page and click on Manage Widgets
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        waitForPageToLoadCompletely(driver, 60);

        //3. Click on Add Widgets
        waitForElementVisible(driver, "//*[name()='path' and contains(@d,'M33.567,8.2,27.8,2.432a1.215,1.215,0,0,0-')]/ancestor::button");
        clickToElement(driver, "//*[name()='path' and contains(@d,'M33.567,8.2,27.8,2.432a1.215,1.215,0,0,0-')]/ancestor::button");
        waitForElementVisible(driver, "//*[name()='path' and contains(@d,'M18,2A16,16,0,1,0,34,18,16,16,0')]/ancestor::button");
        clickToElement(driver, "//*[name()='path' and contains(@d,'M18,2A16,16,0,1,0,34,18,16,16,0')]/ancestor::button");
        // Take SS: YSZ
        waitForElementVisible(driver, "(//div[@class='spectrum-Card-body'])[5]");
        takeSnapShotWithHighlight(driver, "(//div[@class='spectrum-Card-body'])[5]", GlobalConstants.SCREENSHOTS + folder + "001_002_YS0_YS1.png");
    }

    @Test
    public void String_003() throws Exception {
//        MockID:   YS0	My Requests
        //          YS1	Requests Created By Me
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/63c8131920ac63ab107aca58
//        1. Login to Workfront 2. Go to Boards and create a new board 3. Add any card to this boarf 4. Click on three dots near card name and select "Copy"

        // 2. Go to Home page and click on Manage Widgets
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/63c8131920ac63ab107aca58");
        waitForPageToLoadCompletely(driver, 60);

        //3. Add any card to this board
        /*clickToElement(driver, "//button[@data-testid='add-card-button']");
        waitForElementVisible(driver, "//li[@data-key='details']");
        clickToElement(driver, "//li[@data-key='details']");
        waitForElementVisible(driver, "//input[@data-testid='card-details-name']");
        sendKeyToElement(driver,"//input[@data-testid='card-details-name']",""+getRandomNumber());
        sleepInSecond(1);
        pressEnterKeyByRobot(driver);
        sleepInSecond(5);
        waitForElementVisible(driver,"//button[@id='close-button']");
        clickToElement(driver,"//button[@id='close-button']");*/

        waitForElementVisible(driver,"(//button[contains(@data-testid,'card-options-button')])[1]");
        clickToElement(driver,"(//button[contains(@data-testid,'card-options-button')])[1]");
        waitForElementVisible(driver,"//div[@data-testid='popover']//li[@data-key='details']");
        clickToElement(driver,"//div[@data-testid='popover']//li[@data-key='details']");

        clickToElement(driver,"//button[@data-testid='checklist-add-button']");
        //waitForElementVisible(driver,"//input[@placeholder='Checklist item title']");
        sendKeyToElement(driver,"(//input[@type='text'])[last()]",""+getRandomNumber());
        pressEnterKeyByRobot(driver);
        waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M24,18v0a1.988,1.988,0,0,1-.585,1')]/ancestor::button");
        clickToElement(driver,"//*[name()='path' and contains(@d,'M24,18v0a1.988,1.988,0,0,1-.585,1')]/ancestor::button");

        // Take SS: YSZ
        //waitForElementVisible(driver, "(//div[@class='spectrum-Card-body'])[5]");
        takeSnapShotWithHighlight(driver, "//span[@aria-current='page']", GlobalConstants.SCREENSHOTS + folder + "003_YS3.png");
    }
    @Test
    public void String_004() throws Exception {
//        MockID:
        //          YS4	copy
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/63c8131920ac63ab107aca58
//        1. Login to Workfront 2. Go to Boards and create a new board 3. Add any card to this boarf 4. Click on three dots near card name and select "Copy"

        // 2. Go to Home page and click on Manage Widgets
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/63c8131920ac63ab107aca58");
        waitForPageToLoadCompletely(driver, 60);

        //3. Add new card to this board
        /*clickToElement(driver, "//button[@data-testid='add-card-button']");
        waitForElementVisible(driver, "//li[@data-key='details']");
        clickToElement(driver, "//li[@data-key='details']");
        waitForElementVisible(driver, "//input[@data-testid='card-details-name']");
        sendKeyToElement(driver,"//input[@data-testid='card-details-name']",""+getRandomNumber());
        sleepInSecond(1);
        pressEnterKeyByRobot(driver);
        sleepInSecond(5);
        waitForElementVisible(driver,"//button[@id='close-button']");
        clickToElement(driver,"//button[@id='close-button']");*/

//      copy
        waitForElementVisible(driver,"(//button[contains(@data-testid,'card-options-button')])[1]");
        clickToElement(driver,"(//button[contains(@data-testid,'card-options-button')])[1]");
        waitForElementVisible(driver,"//div[@data-testid='popover']//li[@data-key='copy']");
        clickToElement(driver,"//div[@data-testid='popover']//li[@data-key='copy']");
        sleepInSecond(5);
        // Take SS: YS4
        refreshCurrentPage(driver);
        waitForPageToLoadCompletely(driver, 60);
        takeSnapShotWithHighlight(driver, "(//div[@class='two-line-truncate card-title'])[last()]", GlobalConstants.SCREENSHOTS + folder + "004_YS4.png");
//      delete copy
//        waitForElementVisible(driver,"(//button[@aria-label='More'])[4]");
//        clickToElement(driver,"(//button[@aria-label='More'])[4]");
//        waitForElementVisible(driver,"//div[@data-testid='popover']//li[@data-key='delete']");
//        clickToElement(driver,"//div[@data-testid='popover']//li[@data-key='delete']");
//        waitForElementVisible(driver,"//section[@role='alertdialog']//button[@data-variant='accent']");
//        clickToElement(driver,"//section[@role='alertdialog']//button[@data-variant='accent']");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}