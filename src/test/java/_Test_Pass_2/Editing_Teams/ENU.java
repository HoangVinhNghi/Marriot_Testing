package _Test_Pass_2.Editing_Teams;

import common.AbstractPage;
import common.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class ENU extends AbstractPage {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() throws Exception {
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
        waitForElementVisible(driver, "//div[@id='page-content']");
    }

    @Test
    public void String_233() throws Exception {
//        Test user: adobeloctesting@workfront.com / 2wsx#EDC

//        1 Go to Teams and open Training Team
//        2 Go to Team Settings tab
//        3 In Methodology swtich to Kanban and scroll down
//        4 In Methodology swtich to Scrum and scroll down
//        5 Click Save Changes
//        6 Click on Add to Favorites
//        7 Click on Remove from Favorites

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas");
        waitForPageToLoadCompletely(driver,30);
        clickToElement(driver, "//button[@data-testid='new-report-button']");
        sleepInSecond(1);
        doubleClickToElement(driver,"//li[@data-testid='builder-layout-table']");
        sleepInSecond(2);
        clickToElement(driver,"//button[@data-testid='empty-table-edit-icon']");
        clickToElement(driver,"(//div[@data-testid='fields-panel']//button)[1]");
        sleepInSecond(1);
        sendKeyToElement(driver,"//input[@id='configuration-search-input']","CONCAT");
        sleepInSecond(2);
        dragAndDropHTML5ByJS(driver,"//li[@id='CONCAT']","//div[@data-testid='dropzone-canvas']");
        sleepInSecond(2);
        inspectElement(driver,"//div[@data-testid='node-argument-drop-zone']/span");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTEXT_MENU);
        robot.keyRelease(KeyEvent.VK_CONTEXT_MENU);
        sleepInSecond(1);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        sleepInSecond(2);
        captureScreen(GlobalConstants.SCREENSHOTS+"\\Workfront_20220529T102027Z\\ENU\\233_X7G.png");

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}
