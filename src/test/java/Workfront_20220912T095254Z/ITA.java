package Workfront_20220912T095254Z;

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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ITA extends AbstractPage {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Set language
        options.addArguments("--lang=it");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(GlobalConstants.APP_URL);
        sendKeyToElement(driver, "//input[@id='username']", GlobalConstants.ACCOUNT);
        sendKeyToElement(driver, "//input[@id='password']", GlobalConstants.PASSWORD);
        clickToElement(driver, "//button[@type='submit']");
        sleepInSecond(5);

    }

    @Test
    public void String_001() {
//        MockID: YC/
//        Core string: You can check your filters, create {__mlm_low_goals}, or ask others to share theirs with you to view {__mlm_low_goals} here.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list
//         1. Login to Workfront
//         2. Go to Main Menu -> Goals
//         3. In the filter menu select My Teams filter

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");

        // Click to filter button
        waitForElementVisible(driver,"//button[@data-testid='FILTER_GOALS']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='FILTER_GOALS']");

        // Select My Team filter
        waitForElementVisible(driver,"//ul[@data-testid='accordion-items']/li[3]");
        sleepInSecond(1);
        clickToElement(driver,"//ul[@data-testid='accordion-items']/li[3]");

        //Close filter field
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='header-close-icon']");
        refreshCurrentPage(driver);

        // Take screenshot
        waitForElementVisible(driver,"//span[@data-testid='goals-notfound-desc']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//span[@data-testid='goals-notfound-desc']",
                GlobalConstants.SCREENSHOTS + "\\01_YC-.png");
    }

    @Test
    public void String_002() {
//        MockID: YC+
//        Core string: New {__mlm_low_goal}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list
//        1. Login to Workfront
//        2. Go to Main Menu -> Goals

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");


        // Take screenshot
        waitForElementVisible(driver,"//button[@data-testid='add-goal-button']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//button[@data-testid='add-goal-button']",
                GlobalConstants.WF_20220912T095254Z_ITA + "\\02_YC+.png");
    }

    @Test
    public void String_003() {
//        MockID: YDA
//        Core string: There are no {__mlm_low_goals}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list
//         1. Login to Workfront
//         2. Go to Main Menu -> Goals
//         3. In the filter menu select My Teams filter

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");

        // Click to filter button
        waitForElementVisible(driver,"//button[@data-testid='FILTER_GOALS']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='FILTER_GOALS']");

        // Select My Team filter
        waitForElementVisible(driver,"//ul[@data-testid='accordion-items']/li[3]");
        sleepInSecond(1);
        clickToElement(driver,"//ul[@data-testid='accordion-items']/li[3]");

        //Close filter field
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='header-close-icon']");
        refreshCurrentPage(driver);

        // Take screenshot
        waitForElementVisible(driver,"//span[@data-testid='goals-notfound-title']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//span[@data-testid='goals-notfound-title']",
                GlobalConstants.SCREENSHOTS + "\\03_YDA.png");
    }

    @Test
    public void String_004() throws Exception {
//        MockID: YDB
//        Core string: Grouping is on
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/6374d1611c2b73edc0be1627
//        Steps:
//        1. Go to Workfront
//        2. Go to Boards and create a new board
//        3. Click on Group and set any grouping
//        4. Inspect Group button(aria-label string)

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/6374d1611c2b73edc0be1627");

        //Click on Group and set any grouping
        waitForElementVisible(driver,"//button[@data-testid='select-board-picker']");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='group-by-button']");
        sleepInSecond(1);
        clickToElement(driver,"//input[@data-testid='group-by-ASSIGNMENT']");

        //Inspect Group button(aria-label string) and take screenshot
        waitForElementVisible(driver,"//div[@class='filterActiveIndicator']");
        sleepInSecond(1);
        inspectElement(driver,"//div[@class='filterActiveIndicator']");
        captureScreen(GlobalConstants.SCREENSHOTS + "\\04_YDB.png");

    }

    @Test
    public void String_005() {
//        MockID: YDC
//        Core string: Sort
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/
//         Steps:
//         1. Go to Workfront
//         2. Go to Boards

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/");

        // Take screenshot
        waitForElementVisible(driver,"//button[@data-testid='dashboard-sort-button']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//button[@data-testid='dashboard-sort-button']",
                GlobalConstants.SCREENSHOTS + "\\05_YDC.png");
    }

    @Test
    public void String_006() throws Exception {
//        MockID: YDD
//        Core string: Next period loaded. Currently selected dates are
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/resourcemanagement/scheduling
//        1. Login to Workfront
//        2. Click on Main Menu -> Resourcing -> Workload Balancer
//        3. Click on '>' button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/resourcemanagement/scheduling");

        // Click on '>' button
        waitForElementVisible(driver,"//button[@data-testid='navigate_next']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='navigate_next']");

        // Take screenshot
        sleepInSecond(2);
        inspectElement(driver,"//header");
        captureScreen(GlobalConstants.SCREENSHOTS + "\\06_YDD.png");
    }

    @Test
    public void String_007() throws Exception {
//        MockID: YDE
//        Core string: Previous period loaded. Currently selected dates are
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/resourcemanagement/scheduling
//        1. Login to Workfront
//        2. Click on Main Menu -> Resourcing -> Workload Balancer
//        3. Click on '<' button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/resourcemanagement/scheduling");

        // Click on '<' button
        waitForElementVisible(driver,"//button[@data-testid='navigate_previous']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='navigate_previous']");

        // Take screenshot
        sleepInSecond(2);
        inspectElement(driver,"//header");
        captureScreen(GlobalConstants.SCREENSHOTS + "\\07_YDE.png");
    }

    @Test
    public void String_008() {
//        MockID: YDI
//        Core string: You have reached the max count for applications
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/oauth2-apps/633eb136f10e5831b770b795
//        Steps:
//        1. Go to Workfront
//        2. Go to Setup > System > OAuth2 Applications > Create/Edit Single Page Web Application
//        3. Create more than 10 app integrations

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/setup/oauth2-apps");

        // Check if New OAuth2 application items not max > create one
        waitForElementInvisible(driver,"//div[@data-testid='spinner']");
        sleepInSecond(3);
        List<WebElement> listOauth2Items = getElements(driver,"//div[contains(@class,'mdc-layout-grid__inner')]");

        int numberOauth2Items = listOauth2Items.size();
        System.out.println(numberOauth2Items);

        while (numberOauth2Items <= 10) {
            // Create New OAuth2 application with Single Page Web Application
            clickToElement(driver, "//button[@data-testid='create-button']");
            waitForElementVisible(driver,"//div[@data-testid='authorization-method-section']/fieldset/div[2]//span/span");
            clickToElement(driver,"//input[@data-testid='authorization-code-flow-pkce-radio-button']");
            sendKeyToElement(driver, "//input[@data-testid='phoenix-input-name']", "test_" + generateRandomNumber());
            sleepInSecond(2);
            clickToElement(driver, "//button[@data-testid='create-submit-button']");
            sleepInSecond(2);
            driver.get("https://adobeloctesting.devtest.workfront-dev.com/setup/oauth2-apps");
            waitForElementInvisible(driver,"//div[@data-testid='spinner']");
            sleepInSecond(3);
            numberOauth2Items++;
            System.out.println(numberOauth2Items);
        }

        // Create New OAuth2 application with Single Page Web Application in case reached the limit
        clickToElement(driver, "//button[@data-testid='create-button']");
        waitForElementVisible(driver,"//div[@data-testid='authorization-method-section']/fieldset/div[2]//span/span");
        clickToElement(driver,"//input[@data-testid='authorization-code-flow-pkce-radio-button']");
        sendKeyToElement(driver, "//input[@data-testid='phoenix-input-name']", "test_" + generateRandomNumber());
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='create-submit-button']");


        // Take screenshot
        waitForElementVisible(driver,"//div[@data-testid='toast-notification']//span");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='toast-notification']//span",
                GlobalConstants.SCREENSHOTS + "\\08_YDI.png");
    }

    @Test
    public void String_010() {
//        MockID: YDL
//        Core string: Q{quarter} {year}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list
//        1. Login to Workfront
//        2. Go to Main Menu -> Goals

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list");

        // Click to filter button
        waitForElementVisible(driver,"//button[@data-testid='FILTER_GOALS']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='FILTER_GOALS']");

        // Select My Team filter
        waitForElementVisible(driver,"//ul[@data-testid='accordion-items']/li[1]");
        sleepInSecond(1);
        clickToElement(driver,"//ul[@data-testid='accordion-items']/li[1]");

        //Close filter field
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='header-close-icon']");
        refreshCurrentPage(driver);

        // Take screenshot
        waitForElementVisible(driver,"//div[@data-valuefield='period']//div[@data-test-name='BodyInnerCell']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-valuefield='period']//div[@data-test-name='BodyInnerCell']",
                GlobalConstants.SCREENSHOTS + "\\10_YDL.png");
    }

    @Test
    public void String_011() {
//        MockID: YDP
//        Core string: You cannot edit closed {__mlm_low_goal}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/b9045a9e-2617-473e-81a5-7ac08bfa4189/overview
//        1. Login to Workfront
//        2. Go to Main Menu -> Goals
//        3. Open details of a closed Goal
//        4. In the Goal details tab hover on description field

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goal/b9045a9e-2617-473e-81a5-7ac08bfa4189/overview");

        waitForElementVisible(driver,"(//div[@data-testid='field-description-content'])[1]");
        sleepInSecond(1);
        hoverToElement(driver,"(//div[@data-testid='field-description-content'])[1]");

        // Take screenshot
        waitForElementVisible(driver,"//div[@data-testid='tooltip-styled']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='tooltip-styled']",
                GlobalConstants.SCREENSHOTS + "\\11_YDP.png");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

}
