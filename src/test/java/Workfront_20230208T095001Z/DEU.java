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

public class DEU extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20230208T095001Z\\DEU\\3797855\\DEU\\"; // the path to store the captured images with  lang code can be changed accordingly
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
//        MockID: YY8_Delete workspace
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ
//          1. Login to Workfront
// 2. Go to Main Menu > click on a ''Setup''
// 3. On the right menu select ''Custom Forms''
// 4. Go to ''Forms'' tab and click on a ''+ New Custom Form'' button
// 5. Select any object from the dialog window
// 6. Click on a ''Section Break'' in right menu and give it some name in ''Label'' field
// 7. Click on a ''Apply'' button

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ");
        waitForPageToLoadCompletely(driver,60);

//        clickToElement(driver,"//h2[@id='form-title']");
        waitForElementVisible(driver,"//h2[@id='form-title']/parent::div/following-sibling::div//input");
        sendKeyToElement(driver,"//h2[@id='form-title']/parent::div/following-sibling::div//input","test_23323232");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-tracking-id='new-field-SECTION']");
        waitForElementVisible(driver,"//input[@name='section.name']");
        sendKeyToElement(driver,"//input[@name='section.name']","test_aaa");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-tracking-id='apply']");
        waitForElementVisible(driver,"//div[@data-testid='modal']//h2");

        takeSnapShotWithHighlight(driver,"//div[@data-testid='modal']//h2",GlobalConstants.SCREENSHOTS+folder+"001_YZV.png");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='modal']//section[contains(@class,'spectrum-Dialog-content')]",GlobalConstants.SCREENSHOTS+folder+"002_YZV.png");


    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}