package Workfront_20221021T194141Z_NewHome.Workfront_20221021T194141Z;

import common.AbstractPage;
import common.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DEU extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20221021T194141Z_Update\\DEU\\3500831\\DEU\\"; // the path to store the captured images with  lang code can be changed accordingly

    @BeforeClass
    public void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Set language
        options.addArguments("--lang=de"); //set browser language
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        sendKeyToElement(driver, "//input[@id='username']", "hometest123@workfront.com");
        sendKeyToElement(driver, "//input[@id='password']", "Adobe123#");
        clickToElement(driver, "//button[@type='submit']");
        waitForElementVisible(driver, "//div[@id='page-content']");
    }

    @Test
    public void String_001() throws Exception {
//        MockID:
//        YMl	Welcome to the new Home
//        YMn	The new Home experience provides a personalized, flexible page to view and access the work items that are most important to you. We are continuing to refine and add features to this area. Use the Feedback button to let us know what you think!
//        Core string: When this is selected, approvers can also submit, reopen, or edit the timesheet, unless your administrator restricts these actions in the Timesheet Preferences area of Setup.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/timesheets
//        1. Login to Workfront 2. Switch to New Home

        waitForPageToLoadCompletely(driver,30);

        // Take SS: YMl	Welcome to the new Home
        takeSnapShotWithHighlight(driver,"//h2[contains(@class,'Dialog-heading')]", GlobalConstants.SCREENSHOTS+folder+"045_YMl.png");
        // Take SS: YMn	The new Home experience provides a personalized, flexible page to view and access the work items that are most important to you. We are continuing to refine and add features to this area. Use the Feedback button to let us know what you think!
        takeSnapShotWithHighlight(driver,"//section[contains(@class,'Dialog-content')]", GlobalConstants.SCREENSHOTS+folder+"046_YMl.png");

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

}
