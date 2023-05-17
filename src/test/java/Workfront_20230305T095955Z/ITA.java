package Workfront_20230305T095955Z;

import com.github.javafaker.HowIMetYourMother;
import common.AbstractPage;
import common.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


import java.util.concurrent.TimeUnit;

public class ITA extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20230305T095955Z\\ITA\\3892575\\it-IT\\"; // the path to store the captured images with  lang code can be changed accordingly
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
        options.addArguments("--lang=it"); //set browser language
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
//        MockID: YdP	Added to board
//YdO	These preferences only apply to ...
//YdM	Added to card
//YeN1	Preferences
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

        // Take SS: YT+
        waitForElementVisible(driver,"//h2[contains(@class,'spectrum-Dialog-heading')]");
        takeSnapShotWithHighlight(driver,"//h2[contains(@class,'spectrum-Dialog-heading')]", GlobalConstants.SCREENSHOTS+folder+"001_YeN1.png");
        takeSnapShotWithHighlight(driver,"(//span[contains(@class,'spectrum-ToggleSwitch-label')]/child::h4)[1]", GlobalConstants.SCREENSHOTS+folder+"001_YdB.png");
        takeSnapShotWithHighlight(driver,"(//span[contains(@class,'spectrum-ToggleSwitch-label')]/child::h4)[2]", GlobalConstants.SCREENSHOTS+folder+"001_YdM.png");
        takeSnapShotWithHighlight(driver,"(//section[contains(@class,'spectrum-Dialog-content')]//div[contains(@class,'flex')]//span)[1]", GlobalConstants.SCREENSHOTS+folder+"001_Yd0.png");

    }
    @Test
    public void String_002() throws Exception {
//        Board
//        MockID: Yed	MAX
//                Yec	MIN
//                Yeb	SUM
//                YeX	None
//                YeW	AVG
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/8c48a3d1-7caa-480f-84d9-8ebbccd8db40
//
//1. Login to Workfront
//2. Go to Main Menu > ''Maestro''
//4. Click on a ''+ Add record type''
//5. Click on a ''+'' button and select ''Number'' for ''Field type''
//6. Go back to ''Workspace'' and click on a ''+ Add record type''
//7. Click on a ''+'' button and select ''Relationship'' for ''Field type'' and in ''Find a record type'' select early created Record Type
//8. Select checkbox for numbers and click on a dropdown menu

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/8669757a-4ba1-41ca-ba10-0cdd74effa7c/untitled_operational_record_type-105/f041bd5a-48cd-452e-9b13-f0ddbe0bdb7f/view");
        waitForPageToLoadCompletely(driver,60);

        //Click to +
        waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M29,16H20V7a1,1,0,0,0-1-1H17a1,1,0,0,0-1,1v9H7a1,1')]/ancestor::button");
        clickToElement(driver,"//*[name()='path' and contains(@d,'M29,16H20V7a1,1,0,0,0-1-1H17a1,1,0,0,0-1,1v9H7a1,1')]/ancestor::button");

        //click to dropdown
        waitForElementVisible(driver,"//div[@data-omega-widget='maestro-table-new-field-creation-widget']//button[contains(@class,'spectrum-Dropdown-trigger')]");
        clickToElementByJS(driver,"//div[@data-omega-widget='maestro-table-new-field-creation-widget']//button[contains(@class,'spectrum-Dropdown-trigger')]");
        waitForElementVisible(driver,"//div[@aria-posinset='9']");
        clickToElementByJS(driver,"//div[@aria-posinset='9']");
        sleepInSecond(1);
        //select a record type
        waitForElementVisible(driver,"(//div[@data-omega-widget='maestro-table-new-field-creation-widget']//button[contains(@class,'spectrum-FieldButton')])[2]");
        clickToElementByJS(driver,"(//div[@data-omega-widget='maestro-table-new-field-creation-widget']//button[contains(@class,'spectrum-FieldButton')])[2]");
        waitForElementVisible(driver,"//div[@aria-posinset='3']");
        clickToElementByJS(driver,"//div[@aria-posinset='3']");
        //check box 123
        waitForElementVisible(driver,"(//div[@data-omega-widget='maestro-table-new-field-creation-widget']//input[@type='checkbox'])[7]");
        checkToCheckboxOrRadio(driver,"(//div[@data-omega-widget='maestro-table-new-field-creation-widget']//input[@type='checkbox'])[7]");
        sleepInSecond(2);
        //click to None
        waitForElementVisible(driver,"//div[contains(@class,'flex_')]/label[contains(@class,'is-checked')]/following-sibling::button");
        clickToElementByJS(driver,"//div[contains(@class,'flex_')]/label[contains(@class,'is-checked')]/following-sibling::button");

        // Take SS: Yed	MAX
        waitForElementVisible(driver,"(//div[contains(@class,'Menu-itemGrid')])[1]");
        takeSnapShotWithHighlight(driver,"(//div[contains(@class,'Menu-itemGrid')])[1]", GlobalConstants.SCREENSHOTS+folder+"002_Yed.png");
        // Yec	MIN
        takeSnapShotWithHighlight(driver,"(//div[contains(@class,'Menu-itemGrid')])[2]", GlobalConstants.SCREENSHOTS+folder+"002_Yec.png");
        // Yeb	SUM
        takeSnapShotWithHighlight(driver,"(//div[contains(@class,'Menu-itemGrid')])[3]", GlobalConstants.SCREENSHOTS+folder+"002_Yeb.png");
        // YeX	None
        takeSnapShotWithHighlight(driver,"(//div[contains(@class,'Menu-itemGrid')])[5]", GlobalConstants.SCREENSHOTS+folder+"002_YeX.png");
        // YeW	AVG
        takeSnapShotWithHighlight(driver,"(//div[contains(@class,'Menu-itemGrid')])[4]", GlobalConstants.SCREENSHOTS+folder+"002_YeW.png");


    }
    @Test
    public void String_003() throws Exception {
//        Board
//        MockID:   YeQ	No {0} added yet
//                  YeP	Click "Add {0}" to get started.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//
//1.1 Login to Workfront
//2.1 Go to Main Menu > ''Boards''
//3.1 Сreate a new workstream by cliking on an ''Add workstream'' button
//4.2 Click on a ''Card List'' tab
//5.3 Go back to ''Boards'' tab > ''Add board''
//6.3 Click on a ''Select'' button on a ''Basic board'' card
//7.3 Delete all Columns by cliking on a ''...'' button > ''Delete''

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards");
        waitForPageToLoadCompletely(driver,60);

        //Click to Add workstream
        waitForElementVisible(driver,"//button[@data-testid='dashboard-create-workstream-button']");
        clickToElement(driver,"//button[@data-testid='dashboard-create-workstream-button']");

        // Take SS: YeQ
        waitForElementVisible(driver,"(//div[contains(@class,'spectrum-TabsPanel-tabpanel')]//div[contains(@class,'flex')])[6]");
        takeSnapShotWithHighlight(driver,"(//div[contains(@class,'spectrum-TabsPanel-tabpanel')]//div[contains(@class,'flex')])[6]", GlobalConstants.SCREENSHOTS+folder+"002_YeQ_YeP.png");
        // YeP
        // takeSnapShotWithHighlight(driver,"(//div[contains(@class,'Menu-itemGrid')])[2]", GlobalConstants.SCREENSHOTS+folder+"002_Yec.png");

    }
    @Test
    public void String_004() throws Exception {
//        Board
//        MockID:   YeK1	No results found
//                  YeR1	Try adjusting your search or fil...
//                  Xo8	No results found
//       Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//
//1. Login to Workfront
//2. Go to Main Menu > ''Boards''
//3. Enter not matching name in ''Search'' field

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards");
        waitForPageToLoadCompletely(driver,60);

        //Click to search boards
        waitForElementVisible(driver,"(//*[name()='path' and contains(@d,'M33.173,30.215,25.4,22.443A12.826,12.8')])[2]/ancestor::button");
        clickToElement(driver,"(//*[name()='path' and contains(@d,'M33.173,30.215,25.4,22.443A12.826,12.8')])[2]/ancestor::button");
        //send random key
        waitForElementVisible(driver,"//input[contains(@class,'spectrum-Textfield-input_')]");
        sendKeyToElement(driver,"//input[contains(@class,'spectrum-Textfield-input_')]","asdasdafgqweqwe");
        //Click to search workstream
        waitForElementVisible(driver,"(//*[name()='path' and contains(@d,'M33.173,30.215,25.4,22.443A12.826,12.8')])[2]/ancestor::button");
        clickToElement(driver,"(//*[name()='path' and contains(@d,'M33.173,30.215,25.4,22.443A12.826,12.8')])[2]/ancestor::button");
        //send random key
        waitForElementVisible(driver,"(//input[contains(@class,'spectrum-Textfield-input_')])[2]");
        sendKeyToElement(driver,"(//input[contains(@class,'spectrum-Textfield-input_')])[2]","asdasdafgqweqwe");

        sleepInSecond(15);
        // Take SS: YeK, YeR
        waitForElementVisible(driver,"//div[@data-testid='workstream-dashboard-board-container']");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='workstream-dashboard-board-container']", GlobalConstants.SCREENSHOTS+folder+"004_YeK_YeR.png");
        // Take SS: Xo8
        waitForElementVisible(driver,"//div[@data-testid='workstream-dashboard-workstream-container']");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='workstream-dashboard-workstream-container']", GlobalConstants.SCREENSHOTS+folder+"004_Xo8.png");


    }
    @Test
    public void String_005() throws Exception {
//        Board
//        MockID:   Ybr	Points
//                  YbF	Cards
//       Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//
//1. Login to Workfront
//2. Go to Main Menu > ''Boards''
//3. Open any workstream
//4. Click on a ''Card List'' tab
//5. Click on a ''Iteration view'' button
//6. Click on a ''Create iteration'' button > enter ''Iteration name'' > click ''Save'' button

        // Go to a workstream
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64644a3541cbf041d60099c8");
        waitForPageToLoadCompletely(driver,60);
        // click to "Card list"
        clickToElement(driver,"//div[@data-testid='workstream-card-list']");
        waitForPageToLoadCompletely(driver,60);
        // Take SS: YbF
        takeSnapShotWithHighlight(driver,"(//div[@class='icon-gray']/following-sibling::div)[2]", GlobalConstants.SCREENSHOTS+folder+"005_YbF.png");
        // Take SS: Ybr
        takeSnapShotWithHighlight(driver,"(//div[@class='icon-gray']/following-sibling::div)[3]", GlobalConstants.SCREENSHOTS+folder+"005_Ybr.png");


    }
    @Test
    public void String_006() throws Exception {
//        Board
//        MockID:   Yd8	Commenting Beta
//
//       Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/issue/625d4630000393933c1b80897e2cf401/updates
//
//1. Login to Workfront
//2. Go to ''Projects'' tab
//3. Open any project or create a new one
//4. On the left sidebar select ''Requests''
//5. Open any request or create a new one
//6. On the left sidebar select ''Updates''

        // Go to a request
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/issue/625d4630000393933c1b80897e2cf401/updates");
        waitForPageToLoadCompletely(driver,60);
        // Take SS: Yd8
        takeSnapShotWithHighlight(driver,"(//span[contains(@class,'switch-label')])[1]", GlobalConstants.SCREENSHOTS+folder+"006_Yd8.png");


    }
    @Test
    public void String_007() throws Exception {
//        Board
//        MockID:   Yd9	Text copied to clipboard
//
//       Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/issue/625d4630000393933c1b80897e2cf401/updates
//
//1. Login to Workfront
//2. Go to ''Projects'' tab
//3. Open any project or create a new one
//4. On the left sidebar select ''Requests''
//5. Open any request or create a new one
//6. On the left sidebar select ''Updates'' and activate ''Commenting Beta'' switch
//7. Add some new comment
//8. Click on a ''...'' near the new comment and click on a ''Copy body text''

        // Go to a request
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/issue/625d4630000393933c1b80897e2cf401/updates");
        waitForPageToLoadCompletely(driver,60);
        //8. Click on a ''...'' near the new comment
        waitForElementVisible(driver,"(//button[@aria-label='extra actions'])[1]");
        clickToElement(driver,"(//button[@aria-label='extra actions'])[1]");
        //and click on a ''Copy body text''
        waitForElementVisible(driver,"//li[contains(@data-testid,'copy-text-button')]");
        clickToElement(driver,"//li[contains(@data-testid,'copy-text-button')]");

        // Take SS: Yd9
        waitForElementVisible(driver,"//div[@data-testid='toast-notification']//span");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='toast-notification']//span", GlobalConstants.SCREENSHOTS+folder+"007_Yd9.png");


    }
    @Test
    public void String_008() throws Exception {
//        Board
//        MockID:   YeO1	Delete iteration
//                  YeL1	Are you sure you want to delete ...
//       Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//
//1. Login to Workfront
//2. Go to Main Menu > ''Boards''
//3. Open any workstream
//4. Click on a ''Card List'' tab
//5. Click on a ''Iteration view'' button
//6. Click on a ''Create iteration'' button
//7. Click on a ''Save'' button
//8. Near the Iteration click on a trash icon do delete the iteration

        // Go to a workstream
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64644a3541cbf041d60099c8");
        waitForPageToLoadCompletely(driver,60);
        // click to "Card list"
        clickToElement(driver,"//div[@data-testid='workstream-card-list']");
        waitForPageToLoadCompletely(driver,60);
        // click to delete icon
        clickToElement(driver,"//*[name()='path' and contains(@d,'M31.5,6H24V4a2,2,0,0,0-2-2H12a2,2,0,0')]/ancestor::button");
        // Take SS:
        takeSnapShotWithHighlight(driver,"(//div[@data-testid='modal']//span[contains(@class,'spectrum-Button-label')])[2]", GlobalConstants.SCREENSHOTS+folder+"008_YeO.png");
        takeSnapShotWithHighlight(driver,"//section[contains(@class,'spectrum-Dialog-content')]", GlobalConstants.SCREENSHOTS+folder+"008_YeL.png");


    }
    @Test
    public void String_009() throws Exception {
//        Board
//        MockID:   Yea	Select a field
//                  YeY	Show records where
//     Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/8c48a3d1-7caa-480f-84d9-8ebbccd8db40
//
//1. Login to Workfront
//2. Go to Main Menu
//3. Go to ''Maestro''
//4. Create new Record Type by clicking on a ''+ Add record type'' or open any Record Type
//5. Click on a ''Filters'' button

        // Go to maestro
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/8669757a-4ba1-41ca-ba10-0cdd74effa7c/jonckers_1/f29a3d58-a0ac-45c1-ba16-f31e1291c917/view");
        waitForPageToLoadCompletely(driver,60);
        // click to filter
        clickToElement(driver,"//button[@data-testid='filter-widget-button']");
        // Take SS:
        waitForElementVisible(driver,"//div[@data-testid='filter-widget']/h3");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='expression-edit']//div[contains(@class,'spectrum-Dropdown')]", GlobalConstants.SCREENSHOTS+folder+"009_Yea.png");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='filter-widget']/h3", GlobalConstants.SCREENSHOTS+folder+"009_YeY.png");


    }
    @Test
    public void String_010() throws Exception {
//        Board
//        MockID:   YeV	Workfront Filters Service
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
        waitForElementVisible(driver,"(//section[@role='region']//h4[contains(@id,'react-aria')])[5]");
        takeSnapShotWithHighlight(driver,"(//section[@role='region']//h4[contains(@id,'react-aria')])[5]", GlobalConstants.SCREENSHOTS+folder+"010_YeV.png");


    }
    @Test
    public void String_011() throws Exception {
//        Board
//        MockID:   YeZ	Search options ...
//   Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/28fb7ef5-2572-4387-95e1-cc3a57d52ab6
//
//1. Login to Workfront
//2. Go to Main Menu > ''Maestro''
//3. Near the ''Workspace'' name click on a down arrow button > ''Create workspace''
//4. Click on a ''Use template'' button on ''Campaign management'' workspace template card
//5. Click on a ''Activities'' under ''Operational Record Types''
//6. Double click on a ''Summer Sale Email'' name and click on a ''Details'' icon near it
//7. Click on a ''+'' button

        // Go to a record
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/baa10f33-c14c-425e-b1dd-0dae659d2abf/opportunity-1/c61b5fdb-0f55-4faf-a28f-b022b2856bff/record");
        waitForPageToLoadCompletely(driver,60);
        //click on a variable
        sleepInSecond(3);
        clickToElement(driver,"(//div[@data-testid='bubble-group-wrapper'])[1]");
        sleepInSecond(2);
        clickToElement(driver,"(//div[@data-testid='bubble-group-wrapper'])[1]//button");
        sleepInSecond(2);
        clickToElement(driver,"(//div[@data-testid='bubble-group-wrapper'])[1]//button");
        // Take SS:
        sleepInSecond(3);
        waitForElementVisible(driver,"//div[@class='click-outside-ignore']//input[@data-testid='single-select-search-field']");
        takeSnapShotWithHighlight(driver,"//div[@class='click-outside-ignore']//input[@data-testid='single-select-search-field']", GlobalConstants.SCREENSHOTS+folder+"011_YeZ.png");


    }
    @Test
    public void String_012() throws Exception {
//        Board
//        MockID:   Yd+	Leave feedback
//   Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/issue/625d4630000393933c1b80897e2cf401/updates
//
//1. Login to Workfront
//2. Go to ''Projects'' tab
//3. Open any project or create a new one
//4. On the left sidebar select ''Requests''
//5. Open any request or create a new one
//6. On the left sidebar select ''Updates'' and activate ''Commenting Beta'' switch


        // Go to a request
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/project/646439410001431cf770efeabb98f57d/updates");
        waitForPageToLoadCompletely(driver,60);

        // Take SS:
        waitForElementVisible(driver,"//div[@data-dd-action-name='new-updates-beta-toggle-item-off']//following-sibling::button");
        takeSnapShotWithHighlight(driver,"//div[@data-dd-action-name='new-updates-beta-toggle-item-off']//following-sibling::button", GlobalConstants.SCREENSHOTS+folder+"012_Yd+.png");


    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}