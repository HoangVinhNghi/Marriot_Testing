package Workfront_20230229T100133Z;

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
    String folder = "\\Workfront_20230229T100133Z\\JPN\\3866723\\ja-JP\\"; // the path to store the captured images with  lang code can be changed accordingly
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

    //board
    @Test
    public void String_001() throws Exception {
//        Board
//        MockID: YdQ1	Someone assigns you to a card.
//YdK1	Email Notifications
//YdH1	Someone adds you as a member to ...
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//
//1. Login to Workfront
//2. Go to Main Menu > ''Boards''
//3. Click on a ''Preferences'' button

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/preferences");
        waitForPageToLoadCompletely(driver,60);

        // Take SS:
        waitForElementVisible(driver,"//div[@data-testid='modal']//h3");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='modal']//h3", GlobalConstants.SCREENSHOTS+folder+"001_YdK.png");
        takeSnapShotWithHighlight(driver,"(//span[contains(@class,'spectrum-ToggleSwitch-label')]/child::span)[1]", GlobalConstants.SCREENSHOTS+folder+"001_YdH.png");
        takeSnapShotWithHighlight(driver,"(//span[contains(@class,'spectrum-ToggleSwitch-label')]/child::span)[2]", GlobalConstants.SCREENSHOTS+folder+"001_YdQ.png");
    }
    @Test
    public void String_002() throws Exception {
//        Board
//        MockID:   Yde	Sources
//                  Ydi	Add source
//    Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//
//1. Login to Workfront
//2. Go to Main Menu > ''Boards''
//3. Create new workstream or open any existing one
//4. Click on a ''Sources'' button

        // Go to a board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64644a3541cbf041d60099c8");
        waitForPageToLoadCompletely(driver,60);
        //4. Click on a ''Sources'' button
        clickToElement(driver,"(//div[@data-testid='header']//button[contains(@class,'spectrum-ActionButton--quiet')])[3]");
        // Take SS:
        waitForElementVisible(driver,"(//button[@data-testid='close-rail-button']//parent::div)[4]");
        takeSnapShotWithHighlight(driver,"(//button[@data-testid='close-rail-button']//parent::div)[4]", GlobalConstants.SCREENSHOTS+folder+"002_Yde.png");
        takeSnapShotWithHighlight(driver,"//img[contains(@alt,'Workfront')]//ancestor::button", GlobalConstants.SCREENSHOTS+folder+"002_Ydi.png");


    }
    @Test
    public void String_003() throws Exception {
//        Board
//        MockID:
//Ydr	Set a recuirring work cycle
//Ydq	Cadence
//Ydn	Iterations cycle every
//Ydk	Number
//Ydh	Cycle start date
//    Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//
//1. Login to Workfront
//2. Go to Main Menu > ''Boards''
//3. Click on a ''Add workstream'' button
//4. Click on a ''Configure'' button > open ''Iterations'' menu

        // Go to a board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64644a3541cbf041d60099c8");
        waitForPageToLoadCompletely(driver,60);


        //4. Click on a ''Sources'' button
        clickToElement(driver,"(//*[name()='path' and contains(@d,'M33.5,6H15.9A5,5,0,0,0,6.1,6H2.5a.5.5,0,0,0-.5.5v1a.5.5,0,0,0,.5.5H6.1a5,5,0,0')]/ancestor::button)[2]");
        waitForElementVisible(driver,"(//h4[contains(@id,'react-aria')])[4]");
        clickToElement(driver,"(//h4[contains(@id,'react-aria')])[4]");
        // Take SS:
        waitForElementVisible(driver,"(//span[contains(@id,'react-aria')])[4]");
        takeSnapShotWithHighlight(driver,"(//span[contains(@id,'react-aria')])[4]", GlobalConstants.SCREENSHOTS+folder+"003_Ydh.png");
        takeSnapShotWithHighlight(driver,"(//span[contains(@id,'react-aria')])[1]", GlobalConstants.SCREENSHOTS+folder+"003_Ydn.png");
        takeSnapShotWithHighlight(driver,"(//span[contains(@id,'react-aria')])[2]", GlobalConstants.SCREENSHOTS+folder+"003_Ydk.png");
        takeSnapShotWithHighlight(driver,"(//span[contains(@id,'react-aria')])[3]", GlobalConstants.SCREENSHOTS+folder+"003_Ydq.png");
        takeSnapShotWithHighlight(driver,"((//span[contains(@id,'react-aria')])[1]//parent::div//parent::div//parent::div//span)[1]", GlobalConstants.SCREENSHOTS+folder+"003_Ydr.png");
    }
    @Test
    public void String_004() throws Exception {
//        Board
//        MockID:   Yds	Search...
//                  Ydj	Iteration name
//    Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//
//1. Login to Workfront
//2. Go to Main Menu > ''Boards''
//3. Open any workstream
//4. Click on a ''Card List'' tab
//5. Click on an ''Add card'' button


        // Go to a board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64644a3541cbf041d60099c8");
        waitForPageToLoadCompletely(driver,60);
        // click to "Card list"
        clickToElement(driver,"//div[@data-testid='workstream-card-list']");
        waitForPageToLoadCompletely(driver,60);
        //Add card
        clickToElement(driver,"//button[@data-variant='accent']");
        // Take SS:
        waitForElementVisible(driver,"(//div[contains(@id,'react-select-')])[1]");
        takeSnapShotWithHighlight(driver,"(//div[contains(@id,'react-select-')])[1]", GlobalConstants.SCREENSHOTS+folder+"004_Yds.png");

        //click to Create Iteration
        clickToElement(driver,"//button[@data-testid='action-bar-create-iteration-button']");

        // Take SS:
        waitForElementVisible(driver,"(//label[contains(@id,'react-aria')])[4]");
        takeSnapShotWithHighlight(driver,"(//label[contains(@id,'react-aria')])[4]", GlobalConstants.SCREENSHOTS+folder+"004_Ydj.png");

    }
    @Test
    public void String_005() throws Exception {
//        Board
//        MockID:
//
//        YdU	Relationship
//Ydc	Choices
//Ydd	Sort choices A-Z
//YdW	Add choice
//Ydb	This choice needs to have a name...

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/8c48a3d1-7caa-480f-84d9-8ebbccd8db40
//
//1. Login to Workfront
//2. Go to Main Menu
//3. Go to ''Maestro''
//4. Click on a ''+ Add record type''
//5. Click on the down arrow near the any header of the record table (for example: ''Status'') and click on a ''Edit field''
//6. Click on a ''+ Add choice''

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/8669757a-4ba1-41ca-ba10-0cdd74effa7c/untitled_operational_record_type-105/f041bd5a-48cd-452e-9b13-f0ddbe0bdb7f/view");
        waitForPageToLoadCompletely(driver,60);

        //Click to +
        waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M29,16H20V7a1,1,0,0,0-1-1H17a1,1,0,0,0-1,1v9H7a1,1')]/ancestor::button");
        clickToElement(driver,"//*[name()='path' and contains(@d,'M29,16H20V7a1,1,0,0,0-1-1H17a1,1,0,0,0-1,1v9H7a1,1')]/ancestor::button");

        //click to dropdown, choose "single select"
        waitForElementVisible(driver,"//div[@data-omega-widget='maestro-table-new-field-creation-widget']//button[contains(@class,'spectrum-Dropdown-trigger')]");
        clickToElementByJS(driver,"//div[@data-omega-widget='maestro-table-new-field-creation-widget']//button[contains(@class,'spectrum-Dropdown-trigger')]");
        waitForElementVisible(driver,"//div[@aria-posinset='9']");

        //Take ss:
        takeSnapShotWithHighlight(driver,"(//div[contains(@class,'Menu-itemGrid')])[9]", GlobalConstants.SCREENSHOTS+folder+"005_YdU.png");

        //select single-select
        clickToElementByJS(driver,"//div[@aria-posinset='6']");
        sleepInSecond(1);

        // Take SS: Choice
        waitForElementVisible(driver,"(//div[@data-omega-widget='maestro-table-new-field-creation-widget']/div[contains(@style,'margin-top: var(--spectrum-global-dimension-size')])[2]/span");
        takeSnapShotWithHighlight(driver,"(//div[@data-omega-widget='maestro-table-new-field-creation-widget']/div[contains(@style,'margin-top: var(--spectrum-global-dimension-size')])[2]/span", GlobalConstants.SCREENSHOTS+folder+"005_Ydc.png");
        // Sort choices A-Z
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver,"(//div[@data-omega-widget='maestro-table-new-field-creation-widget']//span)[5]", GlobalConstants.SCREENSHOTS+folder+"005_Ydd.png");
        // Add choice
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver,"//button[@data-testid='add-option']", GlobalConstants.SCREENSHOTS+folder+"005_YdW.png");
        //click to Add choice
        clickToElement(driver,"//button[@data-testid='add-option']");
        // Ydb	This choice needs to have a name...
        takeSnapShotWithHighlight(driver,"//div[contains(@class,'spectrum-HelpText-text_')]", GlobalConstants.SCREENSHOTS+folder+"005_Ydb.png");


    }
    @Test
    public void String_006() throws Exception {
//        Board
//        MockID: YXX	Locale ({0})
//                  YdY	Edit
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/8c48a3d1-7caa-480f-84d9-8ebbccd8db40
//
//1. Login to Workfront
//2. Go to Main Menu
//3. Go to ''Maestro''
//4. Click on a ''+ Add record type''
//5. Click on the down arrow near the any header of the record table (for example: ''Status'') and click on a ''Edit field''
//6. Click on a ''+ Add choice''

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/8669757a-4ba1-41ca-ba10-0cdd74effa7c/untitled_operational_record_type-105/f041bd5a-48cd-452e-9b13-f0ddbe0bdb7f/view");
        waitForPageToLoadCompletely(driver,60);


        //Click to +
        waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M29,16H20V7a1,1,0,0,0-1-1H17a1,1,0,0,0-1,1v9H7a1,1')]/ancestor::button");
        clickToElement(driver,"//*[name()='path' and contains(@d,'M29,16H20V7a1,1,0,0,0-1-1H17a1,1,0,0,0-1,1v9H7a1,1')]/ancestor::button");

        //click to dropdown, choose "Date"
        waitForElementVisible(driver,"//div[@data-omega-widget='maestro-table-new-field-creation-widget']//button[contains(@class,'spectrum-Dropdown-trigger')]");
        clickToElementByJS(driver,"//div[@data-omega-widget='maestro-table-new-field-creation-widget']//button[contains(@class,'spectrum-Dropdown-trigger')]");
        waitForElementVisible(driver,"//div[@aria-posinset='8']");

        //select Date
        clickToElementByJS(driver,"//div[@aria-posinset='8']");
        sleepInSecond(1);

        // Take SS: YXX	Locale ({0})
        waitForElementVisible(driver,"(//div[@data-omega-widget='maestro-table-new-field-creation-widget']//button[contains(@class,'spectrum-FieldButton')])[2]");
        takeSnapShotWithHighlight(driver,"(//div[@data-omega-widget='maestro-table-new-field-creation-widget']//button[contains(@class,'spectrum-FieldButton')])[2]", GlobalConstants.SCREENSHOTS+folder+"006_YXX.png");

    }
    @Test
    public void String_007() throws Exception {
//        Board
//        MockID: YXX	Locale ({0})
//                  YdY	Edit
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/8c48a3d1-7caa-480f-84d9-8ebbccd8db40
//
//1. Login to Workfront
//2. Go to Main Menu
//3. Go to ''Maestro''
//4. Click on a ''+ Add record type''
//5. Click on the down arrow near the any header of the record table (for example: ''Status'') and click on a ''Edit field''
//6. Click on a ''+ Add choice''

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/8669757a-4ba1-41ca-ba10-0cdd74effa7c/untitled_operational_record_type-105/f041bd5a-48cd-452e-9b13-f0ddbe0bdb7f/view");
        waitForPageToLoadCompletely(driver,60);

        //click to dropdow near workspace name
        waitForElementVisible(driver,"(//button[contains(@class,'ActionButton')])[3]");
        clickToElement(driver,"(//button[contains(@class,'ActionButton')])[3]");
        //Take SS YdY
        waitForElementVisible(driver,"(//div[contains(@class,'Menu-itemGrid')])[1]");
        takeSnapShotWithHighlight(driver,"(//div[contains(@class,'Menu-itemGrid')])[1]", GlobalConstants.SCREENSHOTS+folder+"007_YdY.png");

    }
    @Test
    public void String_008() throws Exception {
//        Board
//        MockID: YdV	You're already using this value ...
//              YdT	Remove choice
//              UIa	Make a required field
//       Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ
//
//1. Login to Workfront
//2. Go to Main Menu > click on a ''Setup''
//3. On the right menu select ''Custom Forms''
//4. Go to ''Forms'' tab and click on a ''+ New Custom Form'' button
//5. Click on ''Dropdown''
//6. In the right sidebar enter the same value for each choices in input fields

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/form-builder/6465fe0e000c64398f7b7771f6b3e98a");
        waitForPageToLoadCompletely(driver,60);

        //click to dropdow field
        waitForElementVisible(driver,"//div[@title='test']");
        clickToElement(driver,"//div[@title='test']");
        //Take SS UIa
        waitForElementVisible(driver,"//input[@id='field.required']//parent::label");
        takeSnapShotWithHighlight(driver,"//input[@id='field.required']//parent::label", GlobalConstants.SCREENSHOTS+folder+"008_UIa.png");
        //click to gear choice
        waitForElementVisible(driver,"//button[@data-tracking-id='open-settings-dropdown']");
        clickToElement(driver,"//button[@data-tracking-id='open-settings-dropdown']");
//Take SS YdT
        waitForElementVisible(driver,"//li[@data-key='removeChoice']");
        takeSnapShotWithHighlight(driver,"//li[@data-key='removeChoice']", GlobalConstants.SCREENSHOTS+folder+"008_YdT.png");
//add choice
        refreshCurrentPage(driver);
        waitForPageToLoadCompletely(driver,60);
        //click to dropdow field
        waitForElementVisible(driver,"//div[@title='test']");
        clickToElement(driver,"//div[@title='test']");
        waitForElementVisible(driver,"//button[@data-tracking-id='add-choice']");
        clickToElement(driver,"//button[@data-tracking-id='add-choice']");
        sleepInSecond(1);
        sendKeyToElement(driver,"(//input[@name='field.options'])[2]","Choice 2");

        // YdV	You're already using this value ...
        takeSnapShotWithHighlight(driver,"(//div[contains(@class,'spectrum-HelpText-text_')])[1]", GlobalConstants.SCREENSHOTS+folder+"008_YdV.png");
    }
    @Test
    public void String_009() throws Exception {
//        Board
//        MockID: YdE1	New
//       Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/requests
//
//1. Login to Workfront
//2. Go to Main Menu > ''Requests''
//3. Click on a ''New requsest'' button and select any ''Request Type'' from the dropdown menu
//4. Enter all required fields and click ''Submit'' button
//5. Newly created request will have ''New'' status

        // Go to request
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/requests ");
        waitForPageToLoadCompletely(driver,60);

        //Take SS YdE
        waitForElementVisible(driver,"(//span[@color='71A1FF'])[1]/parent::div");
        takeSnapShotWithHighlight(driver,"(//span[@color='71A1FF'])[1]/parent::div", GlobalConstants.SCREENSHOTS+folder+"009_YdE.png");

    }
    @Test
    public void String_010() throws Exception {
//        Board
//        MockID: YdF1	Assignments
//       Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
//
//1. Login to Workfront
//2. Go to the ''Home'' tab
//3. Click on a ''Try out new Home'' button on the down right corner
//4. Click on a ''Manage widgets'' button on the top right corner > ''+ Add widget''
//5. Select ''My issue'' widget and click ''Add'' button
//6. Click on a ''Done'' button in upper right corner
//7. Click on a ''New'' button on the ''My Issue'' widget

        // Go to request
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/setup/log-in-as");
        waitForPageToLoadCompletely(driver,60);

        //log in a new user
        waitForElementVisible(driver,"//div[contains(@data-testid,'phoenix-input-select')]");
        sendKeyToElement(driver,"//input[@data-testid='phoenix-input-select-0']","tuan");
        sleepInSecond(1);
        clickToElement(driver,"//ul[@data-testid='options-container']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-variant='accent']");
        sleepInSecond(10);
        //click to new button
        waitForPageToLoadCompletely(driver,60);
        clickToElement(driver,"//button[@data-omega-element='new-issue-button']");
        //take SS
        sleepInSecond(2);
        captureScreen(GlobalConstants.SCREENSHOTS+folder+"010_YdF.png");

    }



    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}