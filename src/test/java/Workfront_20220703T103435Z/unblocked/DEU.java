package Workfront_20220703T103435Z.unblocked;

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
        waitForElementVisible(driver, "//div[@id='page-content']");
    }

    @Test
    public void String_001() {
//        MockID: X+i
//        Core string: since last week
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/graphs
//        1. Login to Workfront
//        2. Go to Main Menu -> Goals
//        3. Click on Goal Graphs

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goals/graphs");

        waitForElementInvisible(driver,"//div[@class='loader-icon']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "(//div[@class='text-right'])[1]/following-sibling::span",
                GlobalConstants.WF_20220703T103435Z + "/Unblocked/DEU/3170669/DEU/01_X+i.png");

        takeSnapShotWithHighlight(driver, "(//div[@data-testid='legend-baseline'])[1]",
                GlobalConstants.WF_20220703T103435Z + "/Unblocked/DEU/3170669/DEU/02_X+Z.png");
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}
