package Workfront_20221002T102834Z;

import common.AbstractPage;
import common.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ENU extends AbstractPage {
    WebDriver driver;
    Actions action;
    WebDriverWait explicitWait;

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
        waitForElementVisible(driver, "//img[@data-testid='empty-state-child-img']");

    }

    @Test
    public void String_001_YE0() {
//        MockID: YE0
//        Core string: On the {__mlm_low_project}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/6372512000032c330ef86a1b9e903c60/teamScheduling
//        1. Login to Workfront
//        2. Go to Projects -> New Project
//        3. Create a new task and assign it to yourself
//        4. Switch to Workload Balancer tab
//        5. Click on Show All Users button
//        6. Expand user list and mouse hover 'On the project' icon

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/project/6372512000032c330ef86a1b9e903c60/teamScheduling");

        waitForElementVisible(driver,"//span[@data-testid='user-on-this-project']");
        hoverToElement(driver,"//span[@data-testid='user-on-this-project']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='tooltip-styled']//span", GlobalConstants.SCREENSHOTS + "\\Workfront_20221002T102834Z\\ENU\\01_YE0.png");
    }

    @Test
    public void String_002_YE1() {
//        MockID: YE0
//        Core string: Suggested fields
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/projects/all
//        1. Login to Workfront
//        2. Go to Projects -> New Project
//        3. Switch to Workload Balancer tab
//        4. Click on Settings button
//        5 Click on sort dropdown

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/projects/all");

        waitForElementVisible(driver,"//div[@data-testid='button-options-trigger']");
        clickToElement(driver,"//div[@data-testid='button-options-trigger']");
        clickToElement(driver,"//li[@data-testid='option-0']");
        waitForElementVisible(driver,"//div[@data-testid='navitem-project-team-scheduling ']//a");
        clickToElement(driver,"//div[@data-testid='navitem-project-team-scheduling ']//a");
        waitForElementVisible(driver,"//button[@data-testid='setting-iconPROJ']");
        clickToElement(driver,"//button[@data-testid='setting-iconPROJ']");
        waitForElementVisible(driver,"//input[@id='field-select']");
        clickToElement(driver,"//input[@id='field-select']");
        waitForElementVisible(driver,"/li[@id='option-group-suggested-fields']");
        takeSnapShotWithHighlight(driver, "//li[@id='option-group-suggested-fields']", GlobalConstants.SCREENSHOTS + "\\Workfront_20221002T102834Z\\ENU\\02_YE1.png");
    }

    @Test
    public void String_003_YEa() {
//        MockID: YEa
//        Core string: Actual Progress
//        MockID: YEZ
//        Core string: Progress indicators
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/e070fcfa-0ff7-43d6-828f-643299cc03da/progress-indicators
//         1. Login to Workfront
//         2. Go to Goals and create a new goal
//         3. Go to Progress indicators tab

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goal/e070fcfa-0ff7-43d6-828f-643299cc03da/progress-indicators");

        waitForElementVisible(driver, "//div[@data-valuefield='actualProgress']");
        takeSnapShotWithHighlight(driver, "//div[@data-valuefield='actualProgress']", GlobalConstants.SCREENSHOTS + "\\Workfront_20221002T102834Z\\ENU\\03_YEa.png");

        if (driver.findElement(By.xpath("//div[contains(@id,'/progress-indicators')]/span")).isDisplayed()) {
            takeSnapShotWithHighlight(driver, "//div[contains(@id,'/progress-indicators')]", GlobalConstants.SCREENSHOTS + "\\Workfront_20221002T102834Z\\ENU\\04_YEZ.png");
        } else {
            clickToElement(driver, "//button[@data-testid='toolbar-tabs-toggle']");
            sleepInSecond(2);
            takeSnapShotWithHighlight(driver, "//div[contains(@id,'/progress-indicators')]", GlobalConstants.SCREENSHOTS + "\\Workfront_20221002T102834Z\\ENU\\04_YEZ.png");
        }
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {

        driver.quit();
    }

}
