package Workfront_20230312T094139Z;

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
    String folder = "\\Workfront_20230312T094139Z\\JPN\\3913903\\ja-JP\\"; // the path to store the captured images with  lang code can be changed accordingly
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
//        Board
//        MockID: Yf0	You may have mistyped the web ad...
//Yfz	Record type not found
//Yfo	Ok
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/5eda75b1-8767-4f61-aba7-f4a27d355d7d
//
//1. Login to Workfront
//2. Go to Main Menu > ''Maestro''
//3. Click on an ''+ Add record type'' or open any existing record type
//4. Duplicate browser tab
//5. On the first tab click on a three dots ''...'' button near the Record Type name and click ''Delete''
//6. On the second tab click refresh the page

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/8669757a-4ba1-41ca-ba10-0cdd74effa7c/untitled_operational_record_type-113/a18ec943-7ec5-4f4d-833b-109d838e17f4/view");
        waitForPageToLoadCompletely(driver,60);

        // Take SS:
        waitForElementVisible(driver,"//div[@data-testid='modal']");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='modal']", GlobalConstants.SCREENSHOTS+folder+"001_Yf0_Yfz_Yfo.png");
    }
    @Test
    public void String_002() throws Exception {
//        Board
//        MockID:   YfE	Select
//                  Yf9	Next
//Yf8	Dynamic Board Setup
//Yf7	Board details
//Yf+	Dynamic board
//Yf6	Unselected
//    Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//
//1. Login to Workfront
//2. Go to Main Menu > ''Boards''
//3. Click on an ''Add Board'' button
//4, Click on a ''Select'' button on ''Dynamic board'' template
//5. Enter name and click ''Next''
//6. Click on an ''Add source'' button > ''Folter sources'' > select any filter > click on a ''Create board'' button

        // Go to a board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards");
        waitForPageToLoadCompletely(driver,60);
        //3. Click on an ''Add Board'' button
        sleepInSecond(80);
        clickToElement(driver,"//button[@data-testid='dashboard-create-board-button']");
        // Take SS: YfE	Select; Yf+	Dynamic board
        waitForElementVisible(driver,"(//div[contains(@style,'cursor: pointer; width: min-content; place-self: end; margin-right:')])[4]");
        takeSnapShotWithHighlight(driver,"(//div[contains(@style,'cursor: pointer; width: min-content; place-self: end; margin-right:')])[4]", GlobalConstants.SCREENSHOTS+folder+"002_YfE.png");
        takeSnapShotWithHighlight(driver,"(//h4[contains(@style,'display: block; text-overflow: ellipsis; overflow: hidden; max-width:')])[4]", GlobalConstants.SCREENSHOTS+folder+"002_Yf+.png");

        //click to select Dynamic board
        clickToElement(driver,"(//div[contains(@style,'cursor: pointer; width: min-content; place-self: end; margin-right:')])[4]");
        //Take SS: Yf7-8-9
        waitForElementVisible(driver,"//h2[@data-testid='dynamic-setup-dialog-heading']");
        takeSnapShotWithHighlight(driver,"//h2[@data-testid='dynamic-setup-dialog-heading']", GlobalConstants.SCREENSHOTS+folder+"002_Yf8.png");
        takeSnapShotWithHighlight(driver,"//h3[@data-testid='dynamic-setup-board-details-heading']", GlobalConstants.SCREENSHOTS+folder+"002_Yf7.png");
        takeSnapShotWithHighlight(driver,"//button[@data-testid='dynamic-setup-next-button']", GlobalConstants.SCREENSHOTS+folder+"002_Yf9.png");
        //click to Next
        clickToElement(driver,"//button[@data-testid='dynamic-setup-next-button']");
        clickToElement(driver,"(//div[contains(@data-testid,'phoenix-input-select-')])[1]");
        sleepInSecond(10);
        clickToElement(driver,"(//li[contains(@id,'listoption')])[1]");
        sleepInSecond(3);
        clickToElement(driver,"//button[@data-testid='dynamic-setup-create-board-button']");
        //take SS: Yf6
        sleepInSecond(10);
        waitForElementVisible(driver,"//div[contains(@data-testid,'column-dynamicUnselected')]//h3");
        takeSnapShotWithHighlight(driver,"//div[contains(@data-testid,'column-dynamicUnselected')]//h3", GlobalConstants.SCREENSHOTS+folder+"002_Yf6.png");

    }
    @Test
    public void String_003() throws Exception {
//        Board
//        MockID:YfH1	Add a widget name
//YfG1	Add a section name
//YfF	Add a field name
//YfK	Add a descriptive text
//YZN	Previous configurations will con...
//    Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ
//
//1. Login to Workfront
//2. Go to Main Menu > click on a ''Setup''
//3. On the right menu select ''Custom Forms''
//4. Go to ''Forms'' tab and click on a ''+ New Custom Form'' button
//5. Click on ''Adobe XD''

        // YfF	Add a field name; YZN	Previous configurations will con... : Single line text
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ");
        waitForPageToLoadCompletely(driver,60);

        //Drag and drop Single Line text
        waitForElementVisible(driver,"//div[@data-testid='section-container']");
        clickToElement(driver,"//div[@data-testid='section-container']");
        clickToElement(driver,"//button[@data-tracking-id='new-field-SNGL']");

        // Take SS:
        waitForElementVisible(driver,"//label[contains(@id,'field')]");
        takeSnapShotWithHighlight(driver,"//label[contains(@id,'field')]", GlobalConstants.SCREENSHOTS+folder+"003_YfF.png");
        takeSnapShotWithHighlight(driver,"((//*[name()='path' and contains(@d,'M9,1a8,8,0,1,0,8,8A8,8,0,0,0,9,1ZM8.85')]/ancestor::div)[11]//div)[3]", GlobalConstants.SCREENSHOTS+folder+"003_YZN.png");
        //YfK	Add a descriptive text
        //Drag and drop Descriptive text
        clickToElement(driver,"//div[@data-testid='section-container']");
        clickToElement(driver,"//button[@data-tracking-id='new-field-DTXT']");
        //Take SS YfK
        waitForElementVisible(driver,"(//div[contains(@id,'custom-element-')])[3]");
        takeSnapShotWithHighlight(driver,"(//div[contains(@id,'custom-element-')])[3]", GlobalConstants.SCREENSHOTS+folder+"003_YfK.png");
        //Drag and drop Section break
        clickToElement(driver,"//div[@data-testid='section-container']");
        clickToElement(driver,"//button[@data-tracking-id='new-field-SECTION']");
        //Take SS YfG
        waitForElementVisible(driver,"(//div[@data-testid='section-container'])[2]");
        takeSnapShotWithHighlight(driver,"(//div[@data-testid='section-container'])[2]", GlobalConstants.SCREENSHOTS+folder+"003_YfG.png");
        //Drag and drop Adobe XD
        clickToElement(driver,"//div[@data-testid='section-container']");
        clickToElement(driver,"//button[@data-tracking-id='new-field-ADOBEXD']");
        //Take SS YfH
        waitForElementVisible(driver,"(//div[@data-testid='section-container'])[2]//div[@role='button']");
        takeSnapShotWithHighlight(driver,"(//div[@data-testid='section-container'])[2]//div[@role='button']", GlobalConstants.SCREENSHOTS+folder+"003_YfH.png");

    }
    @Test
    public void String_004() throws Exception {
//        Board
//        MockID:   Yfh	Private:
//Yfg	This update thread can only be s...
//    Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/6411bb4a0000cd891ba06b1052d6342a/updates
//
//1. Login to Workfront
//2. Go to Main Menu > ''Projects''
//3. Create a new project or open any project with requests
//4. Select ''Updates'' in left sidebar
//5. Click on a ''Start a new update'' > enter some text > turn on ''Private to my company'' switch > click ''Update'' button


        // Go to a board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/issue/62012f320001704354d4e1391949f5ff/updates");
        waitForPageToLoadCompletely(driver,60);

        // Take SS: Yfh, Yfg
        waitForElementVisible(driver,"(//div[contains(@class,'update-note-body')]//span)[1]");
        takeSnapShotWithHighlight(driver,"(//div[contains(@class,'update-note-body')]//span)[1]", GlobalConstants.SCREENSHOTS+folder+"004_Yfh.png");
        takeSnapShotWithHighlight(driver,"(//div[contains(@class,'update-note-body')]//span)[2]", GlobalConstants.SCREENSHOTS+folder+"004_Yfg.png");

    }
    @Test
    public void String_005() throws Exception {
//        Board
//        MockID:YfW	No data to display.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/report/5988ca3331de269d8c67fb0cca006d9d/detail
//
//1. Login to Workfront
//2. Go to Main Menu > ''Reports''
//3. Open any report with chart (e.g. https://adobeloctesting.devtest.workfront-dev.com/report/5988ca3331de269d8c67fb0cca006d9d/detail)
//4, Select ''Contains'' in ''Portfokia Name''
//5. Enter some not matching value in input field > clicl on a ''Run Report'' button

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/report/5988ca3331de269d8c67fb0cca006d9d/detail");
        waitForPageToLoadCompletely(driver,60);

        //select Contains
        switchToIframeByElement(driver,"//iframe[@data-test-id='kamino-shim']");
        clickToElement(driver,"//select[@class='operators enabled']");
        sleepInSecond(2);
        clickToElement(driver,"//option[@value='cicontains']");
        //enter some not matching value
        sleepInSecond(2);
        sendKeyToElement(driver,"//input[@class='text-value enabled']","!@#$%^&*()");
        //click on Run
        clickToElement(driver,"//button[@type='submit']");
        //Take ss:
        switchToIframeByElement(driver,"//iframe[@data-test-id='kamino-shim']");
        waitForElementVisible(driver,"//div[@id='prevent-flash-of-unstyled']//p");
        takeSnapShotWithHighlight(driver,"//div[@id='prevent-flash-of-unstyled']//p", GlobalConstants.SCREENSHOTS+folder+"005_YfW.png");
    }
    @Test
    public void String_006() throws Exception {
//        Board
//        MockID: Yfi	Saved
//
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/28fb7ef5-2572-4387-95e1-cc3a57d52ab6
//
//1. Create a new user with acces to Workfront and ''Maestro''
//2. Login as e new user to Workfront
//3. Go to Main Menu > ''Maestro''
//4. Open any Record Type or create a new one via ''+ Add record type''
//5. Make some changes (e.g. enter a name, delete or add new record)

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/8669757a-4ba1-41ca-ba10-0cdd74effa7c/untitled_operational_record_type-126/1b9c5aaf-e491-455b-b0cb-6e4e7106ba8f/view");
        waitForPageToLoadCompletely(driver,60);

        //Click to +

        waitForElementVisible(driver,"//button[@data-testid='add-record']");
        clickToElement(driver,"//button[@data-testid='add-record']");

        // Take SS: Yfi
        waitForElementVisible(driver,"//div[@id='toolbar-portal-left-slot']");
        takeSnapShotWithHighlight(driver,"//div[@id='toolbar-portal-left-slot']", GlobalConstants.SCREENSHOTS+folder+"006_Yfi.png");

    }




    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}