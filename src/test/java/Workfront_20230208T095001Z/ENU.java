package Workfront_20230208T095001Z;

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

public class ENU extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20230208T095001Z\\ENU\\"; // the path to store the captured images with  lang code can be changed accordingly
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

    @Test
    public void String_001() throws Exception {
//        MockID: YY8_Delete workspace
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/cab5cc61-c30f-4e8d-ab31-3cb14da1fd77
//          1. Login to Workfront
//          2. Go to Main Menu
//          3. Go to "Maestro"
//          4. Select any workspace
//          5. Click on a ''...'' button on the right from the ''Workspace'' name > click on a ''Delete'' from dropdown menu

        // 4. Select any workspace
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/cab5cc61-c30f-4e8d-ab31-3cb14da1fd77");
        waitForPageToLoadCompletely(driver,60);

        //5. Click on a ''...'' button on the right from the ''Workspace'' name
        waitForElementVisible(driver,"(//button[contains(@id,'react-aria')])[2]");
        clickToElement(driver,"(//button[contains(@id,'react-aria')])[2]");

        // click on a ''Delete'' from dropdown menu
       /* waitForElementVisible(driver,"//li[@data-key='REMOVE']");
        clickToElement(driver,"//li[@data-key='REMOVE']");
        //Take the screenshots YY8
        waitForElementVisible(driver,"//h2[contains(@class,'spectrum-Dialog-heading')]");
        takeSnapShotWithHighlight(driver,"//h2[contains(@class,'spectrum-Dialog-heading')]", GlobalConstants.SCREENSHOTS+folder+"001_YY8.png");
*/
    }

    @Test
    public void String_002() throws Exception {
//        MockID: YU+	View collection
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/
//        1. Login to Workfront 2. Go to Boards 3. Click Create new near Collections, back to All Boards

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/");
        waitForPageToLoadCompletely(driver,60);

        // Take SS: YU+
        waitForElementVisible(driver,"(//button[@data-variant='primary'])[1]");
        takeSnapShotWithHighlight(driver,"(//button[@data-variant='primary'])[1]", GlobalConstants.SCREENSHOTS+folder+"002_YU+.png");

    }
    @Test
    public void String_003() throws Exception {
//        MockID: YU6	No boards added yet
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/
//        1. Login to Workfront 2. Go to Boards 3. Click Create new near Collections, back to All Boards

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/");
        waitForPageToLoadCompletely(driver,60);

        // Take SS: YU6 YU9
        scrollToElement(driver,"(//div[@style='align-items: center; flex-direction: column;'])[1]");
        waitForElementVisible(driver,"(//div[@style='align-items: center; flex-direction: column;'])[1]");
        takeSnapShotWithHighlight(driver,"(//div[@style='align-items: center; flex-direction: column;'])[1]", GlobalConstants.SCREENSHOTS+folder+"003_YU6_YU9.png");

    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}