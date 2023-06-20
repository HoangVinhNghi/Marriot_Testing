package Workfront_20221030T170213Z.P2;

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
    String folder = "\\Workfront_20221030T170213Z\\ENU\\"; // the path to store the captured images with  lang code can be changed accordingly
    // Select the lang code accordingly
    String lang_EN ="--lang=en";
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
    public void String_01() throws Exception {
//        MockID: YRV	{author} created {__mlm_low_goal} {goalName} from the {__mlm_low_activity} {title}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/d79184b8-2b84-4906-901b-f085e5fc8b63/updates
//
//        1. Login to Workfront
//        2. Go to Goals and create a new goal
//        2. In progress indicators create a new activity
//        4. Select created activity and click Convert to goal
//        5. Convert this activity to goal and follow the link in notifications
//        6. Switch to Updates tab

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/goal/d79184b8-2b84-4906-901b-f085e5fc8b63/updates");
        waitForPageToLoadCompletely(driver,30);

        clickToElement(driver,"//div[@data-test-id='tab-header-System Activity']");

        // Take SS: YQy	Custom Data
        takeSnapShotWithHighlight(driver,"//div[@data-testid='activity-layout'][4]/div/span[1]", GlobalConstants.SCREENSHOTS+folder+"01_YRV.png");
    }
    @Test
    public void String_02_03() throws Exception {
//        MockID: YRU	{author} created {__mlm_low_goal} {goalName} from the {__mlm_low_result} {title}
//                YQ2	{author} converted the {__mlm_low_activity} {title} to {goalName} {__mlm_low_goal}	None
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/fe5235d6-9dca-4d9e-b96d-b96537db6d29/updates
//
//        1. Login to Workfront
//        2. Go to Goals and create a new goal
//        2. In progress indicators create a new result
//        4. Select created result and click Convert to goal
//        5. Convert this result to goal and follow the link in notifications
//        6. Switch to Updates tab

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/goal/fe5235d6-9dca-4d9e-b96d-b96537db6d29/updates");
        waitForPageToLoadCompletely(driver,30);

        clickToElement(driver,"//div[@data-test-id='tab-header-System Activity']");

        // Take SS: YQy	Custom Data
        takeSnapShotWithHighlight(driver,"//div[@data-testid='activity-layout'][3]/div/span[1]", GlobalConstants.SCREENSHOTS+folder+"02_YRU.png");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='activity-layout'][1]/div/span[1]", GlobalConstants.SCREENSHOTS+folder+"03_YQ2.png");
    }
    @Test
    public void String_04() throws Exception {
//        MockID: YRD	{0} (inactive)
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/user/6461d2ba00077dd70460e6b964d5322a/updates

//        Open user Edit page of the following user:
//        https://adobeloctesting.devtest.workfront-dev.com/user/6461d2ba00077dd70460e6b964d5322a/updates

//        1. Open any user details page
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/user/6461d2ba00077dd70460e6b964d5322a/updates");
        waitForPageToLoadCompletely(driver,30);
//        2. Click Edit and scroll down to Available Hour Types
        clickToElement(driver,"//div[@data-testid='more-testid-options-trigger']");
        clickToElement(driver,"//li[@data-testid='edit-user']");
//        3. Set some hour type and save
        switchToIframeByElement(driver,"//iframe[@id='form-user-settings']");
//        4. Go to Setup -> TIMESHEETS & HOURS -> Hour Types, select and disable assigned hour type
        clickToElement(driver,"//ul[@class='scrollNav']/li[6]");
        scrollToElement(driver,"//li[@name='hourTypeIDs']//span");
        sleepInSecond(2);

        // Take SS: YQy	Custom Data
            takeSnapShotWithHighlight(driver,"//li[@name='hourTypeIDs']//span[contains(@id,'label-DropDown_')]", GlobalConstants.SCREENSHOTS+folder+"04_YRD.png");
    }
    @Test
    public void String_05() throws Exception {
//        MockID: YRC	Legacy Filters
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/projects/all
//        1. Go to Projects and click on Filter button
//        2. Click on meatballs button and switch to legacy filters

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/projects/all");
        waitForPageToLoadCompletely(driver,30);

//        2. Click Edit and scroll down to Available Hour Types
        clickToElement(driver,"//button[@data-testid='open-filter-selection-panel']");

        if(isElementDisplayed(driver,"//h1[@id='panel-components-panel-title']")) {
            clickToElement(driver,"//div[@data-testid='filters-options-dropdown-trigger']");
            clickToElement(driver,"//li[@data-testid='panel-option-enableLegacy']");
        }

        waitForElementVisible(driver,"//div[@data-testid='filter-panel']/div/span");

        // Take SS: YQy	Custom Data
        takeSnapShotWithHighlight(driver,"//div[@data-testid='filter-panel']/div/span", GlobalConstants.SCREENSHOTS+folder+"05_YRC.png");
    }




    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}
