package Workfront_20220710T102101Z;

import common.AbstractPage;
import common.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DEU extends AbstractPage {
    WebDriver driver;
    Actions action;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Set language
        options.addArguments("--lang=de");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(GlobalConstants.APP_URL);
        sendKeyToElement(driver, "//input[@id='username']", GlobalConstants.ACCOUNT);
        sendKeyToElement(driver, "//input[@id='password']", GlobalConstants.PASSWORD);
        clickToElement(driver, "//button[@type='submit']");
        waitForElementVisible(driver, "//img[@data-testid='empty-state-child-img']");

    }

    @Test
    public void String_001_X_r() {
//        MockID: X+r
//        Core string: Status
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs
//        1. Login to Workfront
//        2. Go to Setup -> System -> Audit Logs and click on Log Type dropdown

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/setup/audit-logs");
        switchToIframeByElement(driver,"//iframe[@data-test-id='kamino-shim']");
        waitForElementVisible(driver,"//button[@data-name='log-filter-button']");
        clickToElement(driver,"//button[@data-name='log-filter-button']");
        takeSnapShotWithHighlight(driver, "//div[@data-name='STATUS']", GlobalConstants.SCREENSHOTS + "\\Workfront_20220710T102101Z\\DEU\\01_X+r.png");
    }

    @Test
    public void String_003_004_005() {
//        MockID: X+u
//        Core string: New {__mlm_up_project} from Template
//        MockID: X+v
//        Core string: Templates you mark as favorites will display to the right
//        MockID: X+w
//        Core string: Favorite templates
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/campaigns
//        1. Login to Workfront
//        2. Go to Main Menu -> Campaigns -> New Campaign
//        3. Click on New Project

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/campaigns");
        waitForElementVisible(driver,"//button[@data-testid='add-new-campaign']");
        clickToElement(driver,"//button[@data-testid='add-new-campaign']");
        waitForElementVisible(driver,"//button[@data-testid='import-project-button-dropdown']");
        clickToElement(driver,"//button[@data-testid='import-project-button-dropdown']");
        takeSnapShotWithHighlight(driver, "//span[@data-testid='option__project-template']", GlobalConstants.SCREENSHOTS + "\\Workfront_20220710T102101Z\\DEU\\03_X+u.png");
        takeSnapShotWithHighlight(driver, "//li[@data-testid='option-group__create-project-from-template']/span", GlobalConstants.SCREENSHOTS + "\\Workfront_20220710T102101Z\\DEU\\05_X+w.png");
        hoverToElement(driver,"//li[@data-testid='option-group__create-project-from-template']/span");
        waitForElementVisible(driver,"//div[@data-testid='tooltip-styled']");
        takeSnapShotWithHighlight(driver, "//div[@data-testid='tooltip-styled']//span", GlobalConstants.SCREENSHOTS + "\\Workfront_20220710T102101Z\\DEU\\04_X+v.png");
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {

        driver.quit();
    }

}
