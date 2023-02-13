package Workfront_20221121T103817Z;

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

public class PTB extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20221121T103817Z\\PTB\\3585959\\PTB\\"; // the path to store the captured images with  lang code can be changed accordingly
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
        options.addArguments("--lang=pt_BR"); //set browser language
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
    public void String_001_006() throws Exception {
//        MockID: YSZ,YST,YSf,YSg,YSe,YSU	New issue,{__mlm_up_issue} name,Description,Priority,Documents,Save new {__mlm_low_issue}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
//        1. Login to Workfront 2. Go to Home page and enter New Home 3. Add Issues widget if there isn't one 4. In the Issues panel click on New button

        // 2. Go to Home page and enter New Home
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        waitForPageToLoadCompletely(driver,60);

        // 3. Add Issues widget if there isn't one

        //4. In the Issues panel click on New button
        waitForElementVisible(driver,"//div[@data-testid='toolbar-primary-area__OPTASK']");

        clickToElement(driver,"//div[@data-testid='toolbar-primary-area__OPTASK']");
        // Take SS: YSZ
        waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M16,33a1,1,0,0,0,1,1h2a1')]/ancestor::button");
        takeSnapShotWithHighlight(driver,"//h2[contains(@class,'spectrum-Dialog-heading--noTypeIcon_')]", GlobalConstants.SCREENSHOTS+folder+"001_YSZ.png");
        // Take SS: YST
        takeSnapShotWithHighlight(driver,"(//*[name()='path' and contains(@d,'M6.573 6.558c.056.055.092.13 0')])[2]/ancestor::label", GlobalConstants.SCREENSHOTS+folder+"002_YST.png");

        // Take SS: YSf
        takeSnapShotWithHighlight(driver,"(//div[contains(@class,'spectrum-Textfield-wrapper')])[3]//label[contains(@id,'react-aria')]", GlobalConstants.SCREENSHOTS+folder+"003_YSf.png");

        // Take SS: YSg
        takeSnapShotWithHighlight(driver,"//div[contains(@class,' spectrum-Field--positionTop_')]//span[contains(@id,'react-aria')]", GlobalConstants.SCREENSHOTS+folder+"004_YSg.png");
        // Take SS: YSe
        takeSnapShotWithHighlight(driver,"//div[@class='h-full overflow-hidden relative border-gray-200 transition-all border-2 border-dashed rounded-md']//parent::div//span", GlobalConstants.SCREENSHOTS+folder+"005_YSe.png");
        // Take SS: YSU
        takeSnapShotWithHighlight(driver,"//div[contains(@class,'spectrum-ButtonGroup--alignEnd')]//button[@type='submit']", GlobalConstants.SCREENSHOTS+folder+"006_YSU.png");
    }

    @Test
    public void String_007() throws Exception {
//        MockID: YR+	You created the <b>{name}</b> {__mlm_low_activity}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/961e6f96-3907-4168-b081-983320082cbe/progress-indicators
//        1. Login to Workfront 2. Go to Goals and create/open a goal 3. In the Progress Indicators tab create new Activity

        // 2. Go to Home page and enter New Home
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/goal/961e6f96-3907-4168-b081-983320082cbe/progress-indicators");
        waitForPageToLoadCompletely(driver,60);

        //3. In the Progress Indicators tab create new Activity
        waitForElementVisible(driver,"//button[@id='add-new-indicator-dropdown-dropdown-button']");
        clickToElement(driver,"//button[@id='add-new-indicator-dropdown-dropdown-button']");
        clickToElement(driver,"(//ul[@data-testid='options-container']//child::li)[2]");
        sendKeyToElement(driver,"//input[@data-testid='name-input']","test_"+getRandomNumber());
        clickToElement(driver,"//button[@data-testid='create-new-task']");

        // Take SS: YR+	Custom Data
        takeSnapShotWithHighlight(driver,"//span[@data-testid='body']", GlobalConstants.SCREENSHOTS+folder+"007_YR+.png");

    }
    @Test
    public void String_008() throws Exception {
//        MockID: YR/	You added <b>{0}</b> as an {__mlm_low_activity} for the <b>{1}</b> {__mlm_low_goal}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/961e6f96-3907-4168-b081-983320082cbe/progress-indicators
//        1. Login to Workfront 2. Go to Goals and create/open a goal 3. In the Progress Indicators tab add some Existing Project

        // 2. Go to Home page and enter New Home
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/goal/961e6f96-3907-4168-b081-983320082cbe/progress-indicators");
        waitForPageToLoadCompletely(driver,60);

        //3. In the Progress Indicators tab select 1 Existing Project
        waitForElementVisible(driver,"//button[@id='add-new-indicator-dropdown-dropdown-button']");
        clickToElement(driver,"//button[@id='add-new-indicator-dropdown-dropdown-button']");
        clickToElement(driver,"(//ul[@data-testid='options-container']//child::li)[3]");
        waitForElementVisible(driver,"//div[@data-testid='sliding-pane']");
        clickToElement(driver,"//div[@aria-rowindex='1']//div[@data-testid='table-body-cell']");

        //add
        clickToElement(driver,"//footer[@data-testid='sliding-pane-footer']//button[@type='button']");

        // Take SS: YR/	Custom Data
        takeSnapShotWithHighlight(driver,"//span[@data-testid='body']", GlobalConstants.SCREENSHOTS+folder+"008_YRslash.png");

    }
    @Test
    public void String_009() throws Exception {
//        MockID: YSE	You added <b>{0} {__mlm_low_projects}</b> as {__mlm_low_activities} for the <b>{1}</b> {__mlm_low_goal}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/961e6f96-3907-4168-b081-983320082cbe/progress-indicators
//        1. Login to Workfront 2. Go to Goals and create/open a goal 3. In the Progress Indicators tab add some Existing Project

        // 2. Go to Home page and enter New Home
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/goal/961e6f96-3907-4168-b081-983320082cbe/progress-indicators");
        waitForPageToLoadCompletely(driver,60);

        //3. In the Progress Indicators tab select 1 Existing Project
        waitForElementVisible(driver,"//button[@id='add-new-indicator-dropdown-dropdown-button']");
        clickToElement(driver,"//button[@id='add-new-indicator-dropdown-dropdown-button']");
        clickToElement(driver,"(//ul[@data-testid='options-container']//child::li)[3]");
        waitForElementVisible(driver,"//div[@data-testid='sliding-pane']");

        sleepInSecond(5);
        waitForElementClickable(driver,"(//div[@data-testid='sliding-pane']//div[@data-testid='row-checkbox'])[1]");
        checkToCheckboxOrRadio(driver,"(//div[@data-testid='sliding-pane']//div[@data-testid='row-checkbox'])[1]");
        sleepInSecond(1);
        waitForElementClickable(driver,"(//div[@data-testid='sliding-pane']//div[@data-testid='row-checkbox'])[2]");
        checkToCheckboxOrRadio(driver,"(//div[@data-testid='sliding-pane']//div[@data-testid='row-checkbox'])[2]");
        // Click Add
        clickToElement(driver,"//footer[@data-testid='sliding-pane-footer']//button[@type='button']");

        // Take SS: YR/	Custom Data
        takeSnapShotWithHighlight(driver,"//span[@data-testid='body']", GlobalConstants.SCREENSHOTS+folder+"009_YSE.png");

    }
    @Test
    public void String_010() throws Exception {
//     s   MockID:  YSC	You deactivated the <b>{name}</b> {__mlm_low_goal}
//                  YSD	You activated the <b>{name}</b> {__mlm_low_goal}
//                  YSB	You closed the <b>{name}</b> {__mlm_low_goal}
//                  YSF	Add closing notes
//                  YSA	You reopened the <b>{name}</b> {__mlm_low_goal}
//        Tet Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
//        1. Login to Workfront 2. Go to Home page and enter New Home


        // 2. Go to Home page and enter New Home
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/goal/961e6f96-3907-4168-b081-983320082cbe/progress-indicators");
        waitForPageToLoadCompletely(driver,60);
// Note: switch button should be enable first
        // Take SS: YSC
        waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M4.5 9A2.5 2.5 0 107 11.5 2.5 2.5 0')]/ancestor::button");
        clickToElement(driver,"//*[name()='path' and contains(@d,'M4.5 9A2.5 2.5 0 107 11.5 2.5 2.5 0')]/ancestor::button");
        waitForElementVisible(driver,"//li[@data-testid='deactivate']");
        clickToElement(driver,"//li[@data-testid='deactivate']");
        takeSnapShotWithHighlight(driver,"//span[@data-testid='body']", GlobalConstants.SCREENSHOTS+folder+"010_YSC.png");
        // Take SS: YSD
        waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M4.5 9A2.5 2.5 0 107 11.5 2.5 2.5 0')]/ancestor::button");
        clickToElement(driver,"//*[name()='path' and contains(@d,'M4.5 9A2.5 2.5 0 107 11.5 2.5 2.5 0')]/ancestor::button");
        waitForElementVisible(driver,"//li[@data-testid='activate']");
        clickToElement(driver,"//li[@data-testid='activate']");
        takeSnapShotWithHighlight(driver,"//span[@data-testid='body']", GlobalConstants.SCREENSHOTS+folder+"011_YSD.png");
        // Take SS: YSB
        waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M4.5 9A2.5 2.5 0 107 11.5 2.5 2.5 0')]/ancestor::button");
        clickToElement(driver,"//*[name()='path' and contains(@d,'M4.5 9A2.5 2.5 0 107 11.5 2.5 2.5 0')]/ancestor::button");
        waitForElementVisible(driver,"//li[@data-testid='close']");
        clickToElement(driver,"//li[@data-testid='close']");
        takeSnapShotWithHighlight(driver,"//span[@data-testid='body']", GlobalConstants.SCREENSHOTS+folder+"012_YSB.png");
        takeSnapShotWithHighlight(driver,"//a[@data-testid='closing-notes-dialog']", GlobalConstants.SCREENSHOTS+folder+"013_YSF.png");
        // Take SS: YSA
        waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M4.5 9A2.5 2.5 0 107 11.5 2.5 2.5 0')]/ancestor::button");
        clickToElement(driver,"//*[name()='path' and contains(@d,'M4.5 9A2.5 2.5 0 107 11.5 2.5 2.5 0')]/ancestor::button");
        waitForElementVisible(driver,"//li[@data-testid='reopen']");
        clickToElement(driver,"//li[@data-testid='reopen']");
        waitForElementVisible(driver,"//div[@id='react-aria-modal-dialog']");
        clickToElement(driver,"//button[@data-testid='confirm-button-confirm-dialog']");
        takeSnapShotWithHighlight(driver,"//span[@data-testid='body']", GlobalConstants.SCREENSHOTS+folder+"014_YSA.png");

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}
