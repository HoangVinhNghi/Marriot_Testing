package Workfront_20220717T104723Z;

import common.AbstractPage;
import common.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PTB extends AbstractPage {
    WebDriver driver;
    Actions action;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Set language
        options.addArguments("--lang=pt-BR");

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
    public void String_001_X_0_007_X_z() {
//        MockID: X+0
//        Core string: Refresh token will expire based on an specified inactivity lifetime, after which the token can no longer be used.
//        MockID: X+z
//        Core string: Refresh token will expire based on an absolute lifetime, after which the token can no longer be used.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goals/goal-list
//        1. Login to Workfront
//        2. Go to Main Menu -> Setup -> System -> OAuth2 Applications
//        3. Click "Create app integration" - > "Web Application"
//        4. Enter any name and click Create

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/setup/oauth2-apps");
        explicitWait = new WebDriverWait(driver, 15);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='spinner']")));
        sleepInSecond(3);
        List<WebElement> listOauth2Items = getElements(driver,"//div[contains(@class,'mdc-layout-grid__inner')]");
        System.out.println(listOauth2Items.size());
        if (listOauth2Items.size()==11) {
            hoverToElement(driver,"(//div[contains(@class,'mdc-layout-grid__inner')])[2]");
            sleepInSecond(2);
            clickToElement(driver,"(//div[contains(@class,'mdc-layout-grid__inner')])[2]/div[5]/div/button");
            sleepInSecond(1);
            clickToElement(driver,"//footer[@data-testid='dialog-dialog-footer']/button[1]");
        }

        clickToElement(driver, "//button[@data-testid='create-button']");
        waitForElementVisible(driver,"//div[@data-testid='authorization-method-section']/fieldset/div[3]//span/span");
        clickToElement(driver,"//input[@data-testid='authorization-code-flow-radio-button']");
        sendKeyToElement(driver, "//input[@data-testid='phoenix-input-name']", "test_" + generateRandomNumber());
        sleepInSecond(2);
        clickToElement(driver, "//button[@data-testid='create-submit-button']");
        sleepInSecond(3);
        scrollToElement(driver,"//div[@data-testid='absolute-lifetime-section']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='inactivity-lifetime-section']/span", GlobalConstants.SCREENSHOTS + "\\Workfront_20220717T104723Z\\PTB\\01_X+0.png");
        takeSnapShotWithHighlight(driver, "//div[@data-testid='absolute-lifetime-section']/span", GlobalConstants.SCREENSHOTS + "\\Workfront_20220717T104723Z\\PTB\\07_X+z.png");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='cancel']");

    }

    @Test
    public void String_002_X_1() {
//        MockID: X+1
//        Core string: In
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting
//        3. Click New report
//        4. Drag&Drop Table block and click Edit
//        5. Click on New(field) button
//        6. Drag&Drop In function into the content panel

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas");
        waitForPageToLoadCompletely(driver,30);
        clickToElement(driver, "//button[@data-testid='new-report-button']");
        sleepInSecond(1);
        doubleClickToElement(driver,"//li[@data-testid='builder-layout-table']");
        sleepInSecond(2);
        clickToElement(driver,"//button[@data-testid='empty-table-edit-icon']");
        clickToElement(driver,"(//div[@data-testid='fields-panel']//button)[1]");
        sleepInSecond(1);
        sendKeyToElement(driver,"//input[@id='configuration-search-input']","IN");
        sleepInSecond(2);
        dragAndDropHTML5ByJS(driver,"//li[@id='IN']","//div[@data-testid='dropzone-canvas']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//div[@type='formula']/div[2]/div/div[3]/div", GlobalConstants.SCREENSHOTS + "\\Workfront_20220717T104723Z\\PTB\\02_X+1.png");
    }
    @Test
    public void String_003_X_2() {
//        MockID: X+2
//        Core string: Within
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting
//        3. Click New report
//        4. Drag&Drop Table block and click Edit
//        5. Click on New(field) button
//        6. Drag&Drop In function into the content panel

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas");
        waitForPageToLoadCompletely(driver,30);
        clickToElement(driver, "//button[@data-testid='new-report-button']");
        sleepInSecond(1);
        doubleClickToElement(driver,"//li[@data-testid='builder-layout-table']");
        sleepInSecond(2);
        clickToElement(driver,"//button[@data-testid='empty-table-edit-icon']");
        clickToElement(driver,"(//div[@data-testid='fields-panel']//button)[1]");
        sleepInSecond(1);
        sendKeyToElement(driver,"//input[@id='configuration-search-input']","IN");
        sleepInSecond(2);
        dragAndDropHTML5ByJS(driver,"//li[@id='IN']","//div[@data-testid='dropzone-canvas']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//div[@type='formula']/div[2]/div/div[4]/div[2]/span", GlobalConstants.SCREENSHOTS + "\\Workfront_20220717T104723Z\\PTB\\03_X+2.png");
    }

    @Test
    public void String_004_X_3() {
//        MockID: X+3
//        Core string: Find
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting
//        3. Click New report
//        4. Drag&Drop Table block and click Edit
//        5. Click on New(field) button
//        6. Drag&Drop In function into the content panel

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas");
        waitForPageToLoadCompletely(driver,30);
        clickToElement(driver, "//button[@data-testid='new-report-button']");
        sleepInSecond(1);
        doubleClickToElement(driver,"//li[@data-testid='builder-layout-table']");
        sleepInSecond(2);
        clickToElement(driver,"//button[@data-testid='empty-table-edit-icon']");
        clickToElement(driver,"(//div[@data-testid='fields-panel']//button)[1]");
        sleepInSecond(1);
        sendKeyToElement(driver,"//input[@id='configuration-search-input']","IN");
        sleepInSecond(2);
        dragAndDropHTML5ByJS(driver,"//li[@id='IN']","//div[@data-testid='dropzone-canvas']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//div[@type='formula']/div[2]/div/div[2]/span", GlobalConstants.SCREENSHOTS + "\\Workfront_20220717T104723Z\\PTB\\04_X+3.png");
    }
    @Test
    public void String_005_X_4() {
//        MockID: X+4
//        Core string: IN
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas
//        1. Login to Workfront
//        2. Go to Main Menu -> Reporting
//        3. Click New report
//        4. Drag&Drop Table block and click Edit
//        5. Click on New(field) button


        driver.get("https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas");
        waitForPageToLoadCompletely(driver,30);
        clickToElement(driver, "//button[@data-testid='new-report-button']");
        sleepInSecond(1);
        doubleClickToElement(driver,"//li[@data-testid='builder-layout-table']");
        sleepInSecond(2);
        clickToElement(driver,"//button[@data-testid='empty-table-edit-icon']");
        clickToElement(driver,"(//div[@data-testid='fields-panel']//button)[1]");
        sleepInSecond(1);
        sendKeyToElement(driver,"//input[@id='configuration-search-input']","IN");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//li[@id='IN']/div/div/span[1]", GlobalConstants.SCREENSHOTS + "\\Workfront_20220717T104723Z\\PTB\\05_X+4.png");
    }
    @Test
    public void String_006_X_5() {
//        MockID: X+5
//        Core string: Migrate Report
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/report/62051b7400032b6f37857cc7959e5a10
//        1. Login to Workfront
//        2. Go to Main Menu -> Reports and open any report
//        3. Click on Report Actions button


        driver.get("https://adobeloctesting.devtest.workfront-dev.com/report/62051b7400032b6f37857cc7959e5a10/detail");
        waitForElementVisible(driver,"//span[@data-testid='timestamp']");
        clickToElement(driver, "//button[@data-testid='button-label']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='button-options']//li[@data-testid='option-6']", GlobalConstants.SCREENSHOTS + "\\Workfront_20220717T104723Z\\PTB\\06_X+5.png");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

}
