package Workfront_20220926T101547Z;

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

public class ESP extends AbstractPage {
    WebDriver driver;
    Actions action;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Set language
        options.addArguments("--lang=es");

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
    public void String_001_YEW() {
//        MockID: YEW
//        Core string: Archive after
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/
//        1. Login to Workfront
//        2. Go to Main Menu -> Boards
//        3. Create a new Kanban board
//        4. Click on Configure -> Automatically archive cards from the board

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/");

        waitForElementVisible(driver,"//button[@data-testid='dashboard-create-board-button']");
        clickToElement(driver,"//button[@data-testid='dashboard-create-board-button']");
        waitForElementVisible(driver,"//div[@data-testid='board-configure-button']//button");
        clickToElement(driver,"//div[@data-testid='board-configure-button']//button");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='configure-board-accordion-card']");
        sleepInSecond(1);
        clickToElement(driver,"//input[@data-testid='card-falloff-switch']");


        takeSnapShotWithHighlight(driver, "//input[@data-testid='card-falloff-switch']/parent::label/following-sibling::div[1]/div/span", GlobalConstants.SCREENSHOTS + "\\Workfront_20220926T101547Z\\ESP\\01_YEW.png");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {

        driver.quit();
    }

}
