package Workfront_20230018T105148Z.P1;

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

public class JPN extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20230018T105148Z\\JPN\\3637343\\JPN\\"; // the path to store the captured images with  lang code can be changed accordingly
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
        options.addArguments("--lang=ja-JP"); //set browser language
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
//        MockID: YTR	Delete collection
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/63e0f237c77c8222346e76a3
//        1. Login to Workfront 2. Go to Boards 3. Click on 3 dots (...) of any 'Untitled Collection' under 'Collections' section 4. Select 'Delete'

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/63e0f237c77c8222346e76a3");
        waitForPageToLoadCompletely(driver,60);

        // Open any existed Board
//        waitForElementVisible(driver,"(//div[@data-testid='dashboard-board-container']//h4)[1]");
//        clickToElement(driver,"(//div[@data-testid='dashboard-board-container']//h4)[1]");

        // Click three dots button > Delete
        sleepInSecond(1);
        waitForElementVisible(driver,"//button[@data-testid='board-menu-button']");
        clickToElement(driver,"//button[@data-testid='board-menu-button']");

        waitForElementVisible(driver,"//li[@data-key='delete']");
        clickToElement(driver,"//li[@data-key='delete']");

        // Take SS: YQy	Custom Data
        takeSnapShotWithHighlight(driver,"(//button[@data-variant='accent'])[2]", GlobalConstants.SCREENSHOTS+folder+"001_YTR.png");

    }

    @Test
    public void String_002() throws Exception {
//        MockID: YTE	template {__mlm_low_task}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/template/6241ab1e00001921338f03c34ec79beb/tasks
//        1. Login to Workfront 2. Go to Templates 3. Open any template with tasks 4. Select 2 template tsks and click on 3 dots (...) 5. Select 'Move to..'

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/template/6241ab1e00001921338f03c34ec79beb/tasks");
        waitForPageToLoadCompletely(driver,60);

        // Click three dots button > Move to
        sleepInSecond(1);
        checkToCheckboxOrRadio(driver,"(//div[@data-test-id='row-checkbox'])[1]");
        checkToCheckboxOrRadio(driver,"(//div[@data-test-id='row-checkbox'])[2]");
        clickToElement(driver,"//button[@data-testid='templatetask-more-dropdown']");
        clickToElement(driver,"(//li[contains(@data-testid,'option')])[1]");


        // Take SS: YTP	Custom Data
        takeSnapShotWithHighlight(driver,"//input[@data-testid='name-input']", GlobalConstants.SCREENSHOTS+folder+"002_YTE.png");

    }
    @Test
    public void String_003() throws Exception {
//        MockID: YTG	template {__mlm_low_tasks}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/template/6241ab1e00001921338f03c34ec79beb/tasks
//        1. Login to Workfront 2. Go to Templates 3. Open 3 template with tasks 4. Select all template tsks and click on 3 dots (...) 5. Select 'Move to..'

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/template/6241ab1e00001921338f03c34ec79beb/tasks");
        waitForPageToLoadCompletely(driver,60);

        // Click three dots button > Move to
        sleepInSecond(1);
        checkToCheckboxOrRadio(driver,"//div[@data-test-id='header-checkbox']");
        clickToElement(driver,"//button[@data-testid='templatetask-more-dropdown']");
        clickToElement(driver,"(//li[contains(@data-testid,'option')])[1]");


        // Take SS: YTG
        takeSnapShotWithHighlight(driver,"//input[@data-testid='name-input']", GlobalConstants.SCREENSHOTS+folder+"003_YTG.png");

    }
    @Test
    public void String_004() throws Exception {
//        MockID: YTJ	Destination Template
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/template/6241ab1e00001921338f03c34ec79beb/tasks
//        1. Login to Workfront 2. Go to Templates 3. Open any template with tasks 4. Select all template tsks and click on 3 dots (...)
//        5. Select 'Move to..' 6. Select any destination template

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/template/6241ab1e00001921338f03c34ec79beb/tasks");
        waitForPageToLoadCompletely(driver,60);

        // Click three dots button > Move to
        sleepInSecond(1);
        checkToCheckboxOrRadio(driver,"//div[@data-test-id='header-checkbox']");
        clickToElement(driver,"//button[@data-testid='templatetask-more-dropdown']");
        clickToElement(driver,"(//li[contains(@data-testid,'option')])[1]");


        // Take SS: YTJ
        takeSnapShotWithHighlight(driver,"//h2[@data-testid='lightbox-text-section-destinationTemplateSection']", GlobalConstants.SCREENSHOTS+folder+"004_YTJ.png");

    }
    @Test
    public void String_005() throws Exception {
//        MockID: YTK	Options
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/template/6241ab1e00001921338f03c34ec79beb/tasks
//        1. Login to Workfront 2. Go to Templates 3. Open any template with tasks 4. Select all template tsks and click on 3 dots (...)
//        5. Select 'Move to..' 6. Select any destination template

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/template/6241ab1e00001921338f03c34ec79beb/tasks");
        waitForPageToLoadCompletely(driver,60);

        // Click three dots button > Move to
        sleepInSecond(1);
        checkToCheckboxOrRadio(driver,"//div[@data-test-id='header-checkbox']");
        clickToElement(driver,"//button[@data-testid='templatetask-more-dropdown']");
        clickToElement(driver,"(//li[contains(@data-testid,'option')])[1]");

        //select Destination Template
        clickToElement(driver,"//input[@id='field-destinationTemplate']");
        sendKeyToElement(driver,"//input[@id='field-destinationTemplate']","contracted");
        clickToElement(driver,"(//span[contains(@data-testid,'option-listoption')])[1]");


        // Take SS: YTK
        waitForElementVisible(driver,"//h2[@data-testid='lightbox-text-section-optionsSection']");
        takeSnapShotWithHighlight(driver,"//h2[@data-testid='lightbox-text-section-optionsSection']", GlobalConstants.SCREENSHOTS+folder+"005_YTK.png");

    }
    @Test
    public void String_006() throws Exception {
//        MockID: YTH	Deselect the items that you do not want to move with the template {__mlm_low_task}. Selected items will be moved.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/template/6241ab1e00001921338f03c34ec79beb/tasks
//        1. Login to Workfront 2. Go to Templates 3. Open any template with tasks 4. Select all template tsks and click on 3 dots (...)
//        5. Select 'Move to..' 6. Select any destination template

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/template/6241ab1e00001921338f03c34ec79beb/tasks");
        waitForPageToLoadCompletely(driver,60);

        // Click three dots button > Move to
        sleepInSecond(1);
        checkToCheckboxOrRadio(driver,"//div[@data-test-id='header-checkbox']");
        clickToElement(driver,"//button[@data-testid='templatetask-more-dropdown']");
        clickToElement(driver,"(//li[contains(@data-testid,'option')])[1]");

        //select Destination Template
        clickToElement(driver,"//input[@id='field-destinationTemplate']");
        sendKeyToElement(driver,"//input[@id='field-destinationTemplate']","contracted");
        clickToElement(driver,"(//span[contains(@data-testid,'option-listoption')])[1]");


        // Take SS: YTK
        waitForElementVisible(driver,"//span[@id='options-hint']");
        takeSnapShotWithHighlight(driver,"//span[@id='options-hint']", GlobalConstants.SCREENSHOTS+folder+"006_YTH.png");

    }
    @Test
    public void String_007() throws Exception {
//        MockID: YTP	Select Parent
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/template/6241ab1e00001921338f03c34ec79beb/tasks
//        1. Login to Workfront 2. Go to Templates 3. Open any template with tasks 4. Select all template tsks and click on 3 dots (...)
//        5. Select 'Move to..' 6. Select any destination template

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/template/6241ab1e00001921338f03c34ec79beb/tasks");
        waitForPageToLoadCompletely(driver,60);

        // Click three dots button > Move to
        sleepInSecond(1);
        checkToCheckboxOrRadio(driver,"//div[@data-test-id='header-checkbox']");
        clickToElement(driver,"//button[@data-testid='templatetask-more-dropdown']");
        waitForElementVisible(driver,"(//li[contains(@data-testid,'option')])[1]");
        clickToElement(driver,"(//li[contains(@data-testid,'option')])[1]");

        //select Destination Template
        clickToElement(driver,"//input[@id='field-destinationTemplate']");
        sendKeyToElement(driver,"//input[@id='field-destinationTemplate']","contracted");
        clickToElement(driver,"(//span[contains(@data-testid,'option-listoption')])[1]");


        // Take SS: YTP
        waitForElementVisible(driver,"//h2[@data-testid='lightbox-text-section-parentTemplateTaskSection']");
        takeSnapShotWithHighlight(driver,"//h2[@data-testid='lightbox-text-section-parentTemplateTaskSection']", GlobalConstants.SCREENSHOTS+folder+"007_YTP.png");

    }
    @Test
    public void String_008() throws Exception {
//        MockID: YTF	Select the destination template {__mlm_low_task} that you want as the parent of this template {__mlm_low_task}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/template/6241ab1e00001921338f03c34ec79beb/tasks
//        1. Login to Workfront 2. Go to Templates 3. Open any template with tasks 4. Select all template tsks and click on 3 dots (...)
//        5. Select 'Move to..' 6. Select any destination template

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/template/6241ab1e00001921338f03c34ec79beb/tasks");
        waitForPageToLoadCompletely(driver,60);

        // Click three dots button > Move to
        sleepInSecond(1);
        checkToCheckboxOrRadio(driver,"//div[@data-test-id='header-checkbox']");
        clickToElement(driver,"//button[@data-testid='templatetask-more-dropdown']");
        clickToElement(driver,"(//li[contains(@data-testid,'option')])[1]");

        //select Destination Template
        clickToElement(driver,"//input[@id='field-destinationTemplate']");
        sendKeyToElement(driver,"//input[@id='field-destinationTemplate']","contracted");
        clickToElement(driver,"(//span[contains(@data-testid,'option-listoption')])[1]");


        // Take SS: YTF
        waitForElementVisible(driver,"//span[@id='PROJECT_PARENT_TASK_LIST-hint']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver,"//span[@id='PROJECT_PARENT_TASK_LIST-hint']", GlobalConstants.SCREENSHOTS+folder+"008_YTF.png");

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}