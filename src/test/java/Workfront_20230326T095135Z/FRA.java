package Workfront_20230326T095135Z;

import com.github.javafaker.HowIMetYourMother;
import com.relevantcodes.extentreports.model.ScreenCapture;
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
public class FRA extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20230326T095135Z\\FRA\\3964213\\fr-FR\\"; // the path to store the captured images with  lang code can be changed accordingly
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
        options.addArguments("--lang=fr"); //set browser language
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
//        MockID:   YhF	Customize
//YhE	Customize the look and feel of y...
//YhC	Widgets
//YhB	Background
//YhY	Add a team to start seeing unass...
//            Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
//
//1. Login to Workfront
//2. Go to Home > ''Customize''

        // log in to another acc
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/setup/log-in-as");
        waitForPageToLoadCompletely(driver,60);
        waitForElementVisible(driver,"//input[contains(@data-testid,'phoenix-input-select')]");
        sendKeyToElement(driver,"//input[contains(@data-testid,'phoenix-input-select')]","tuan");
        sleepInSecond(1);
        clickToElement(driver,"//span[@data-testid='option-Tuan Nguyen-ellipse']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-variant='accent']");
        // Click to Customize
        waitForElementVisible(driver,"//button[@data-omega-element='customize']");
        clickToElement(driver,"//button[@data-omega-element='customize']");

        //Take SS
        waitForElementVisible(driver,"//section[@data-testid='side-rail-overlay']//h3");
        takeSnapShotWithHighlight(driver,"//section[@data-testid='side-rail-overlay']//h3", GlobalConstants.SCREENSHOTS+folder+"001_YhF_YhE.png");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"(//h4[contains(@id,'react-aria')])[1]", GlobalConstants.SCREENSHOTS+folder+"001_YhB.png");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"(//h4[contains(@id,'react-aria')])[2]", GlobalConstants.SCREENSHOTS+folder+"001_YhC.png");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"//div[@data-omega-widget='HomeTeamRequests']//span", GlobalConstants.SCREENSHOTS+folder+"001_YhY.png");
        //log out
        waitForElementVisible(driver,"(//button[@theme='default'])[1]");
        clickToElement(driver,"(//button[@theme='default'])[1]");
        sleepInSecond(2);
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/setup/log-in-as");
        waitForPageToLoadCompletely(driver,60);
        waitForElementVisible(driver,"//input[contains(@data-testid,'phoenix-input-select')]");
        waitForPageToLoadCompletely(driver,60);
        sendKeyToElement(driver,"//input[contains(@data-testid,'phoenix-input-select')]","alp");
        sleepInSecond(1);
        clickToElement(driver,"//span[@data-testid='option-alp01 alp01-ellipse']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-variant='accent']");
        waitForPageToLoadCompletely(driver,60);
        // open a1 (0)
        waitForElementVisible(driver,"//div[@data-omega-widget='HomeTeamRequests']//button");
        clickToElement(driver,"//div[@data-omega-widget='HomeTeamRequests']//button");
        //Take SS; YhX1	You have no unassigned work for ...; YhZ1	When there is unassigned work, i...
        waitForElementVisible(driver,"(//div[@data-omega-widget='HomeTeamRequests']//section)[1]");
        takeSnapShotWithHighlight(driver,"(//div[@data-omega-widget='HomeTeamRequests']//section)[1]", GlobalConstants.SCREENSHOTS+folder+"001_YhX_YhZ.png");
        //log out
        waitForElementVisible(driver,"(//button[@theme='default'])[1]");
        clickToElement(driver,"(//button[@theme='default'])[1]");
    }
    @Test
    public void String_002() throws Exception {
//        Board
//        MockID:   YhW1	Timeline
//YhV1	Create
//YhU1	New view
//YhR1	Table
//Yg9	Records need start and end date ...
//Yg8	Next
//Yg7	End date field
//Yg5	Choose a date field
//Yg4	Start date field
//            Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/84160726-3e3f-4591-a7af-a93eff93f221
//
//1. Login to Workfront
//2. Go to Main Menu > Maestro
//3. Click "Add record type"
//4. Go to Default View > Create new view
//5. Choose Timeline
//6. Click Next
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/8669757a-4ba1-41ca-ba10-0cdd74effa7c/untitled_operational_record_type-106/407a5fae-2029-449f-b0d2-345b2f0396ec/view");
        waitForPageToLoadCompletely(driver,60);

        // Take SS: Ycs
        waitForElementVisible(driver,"//button[@data-testid='view-widget-button']");
        clickToElement(driver,"//button[@data-testid='view-widget-button']");
        sleepInSecond(5);
        waitForElementVisible(driver,"//button[@data-testid='rich-picker-action-button']");
        clickToElement(driver,"//button[@data-testid='rich-picker-action-button']");

        // Take SS: YhW1	Timeline, YhV1	Create, YhR1	Table , YhU1	New view
        waitForElementVisible(driver,"//form[@data-testid='create-view-form']/h3");
        takeSnapShotWithHighlight(driver,"//form[@data-testid='create-view-form']/h3", GlobalConstants.SCREENSHOTS+folder+"002_YhU.png");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"(//form[@data-testid='create-view-form']//h2)[1]", GlobalConstants.SCREENSHOTS+folder+"002_YhR.png");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"(//form[@data-testid='create-view-form']//h2)[2]", GlobalConstants.SCREENSHOTS+folder+"002_YhW.png");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"//button[@data-testid='create-new-view-btn-save']", GlobalConstants.SCREENSHOTS+folder+"002_YhV.png");

        //click to Timeline
        waitForElementVisible(driver,"(//div[@data-omega-widget='maestro-toolbar-view-panel']/div)[2]");
        clickToElement(driver,"(//div[@data-omega-widget='maestro-toolbar-view-panel']/div)[2]");
        //Take SS Yg8 Next
        takeSnapShotWithHighlight(driver,"//button[@data-testid='create-new-view-btn-save']", GlobalConstants.SCREENSHOTS+folder+"002_Yg8.png");

        //click next
        clickToElement(driver,"//button[@data-testid='create-new-view-btn-save']");
        //Yg9	Records need start and end date ..., Yg7	End date field, Yg5	Choose a date field, Yg4	Start date field
        waitForElementVisible(driver,"//div[@data-testid='timeline-config']");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='timeline-config']/span", GlobalConstants.SCREENSHOTS+folder+"002_Yg5.png");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"//div[@data-testid='timeline-config']/section", GlobalConstants.SCREENSHOTS+folder+"002_Yg9.png");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"(//div[@data-testid='timeline-config']/div)[2]", GlobalConstants.SCREENSHOTS+folder+"002_Yg4_Yg7.png");

    }
    @Test
    public void String_003() throws Exception {
//        Board
//        MockID:   YhP	Start typing project name...
//YhN	Use advanced filters
//YhM	Use simple filters
//YhL1	Include completed work
//YhH	Select users or teams
//           Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/6422dd01d4c10ff9d87a9f6b
//
//1. Go to Boards and open a board
//2. Click Configure and expand Board panel
//3. Click on "Use simple filters" button

        // 2. Go to a kanban board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/6422dd01d4c10ff9d87a9f6b");
        waitForPageToLoadCompletely(driver,60);
        //click to Configure
        waitForElementVisible(driver,"//div[@data-testid='board-configure-button']/button");
        clickToElement(driver,"//div[@data-testid='board-configure-button']/button");
        //click to Board
        waitForElementVisible(driver,"//div[@data-testid='configure-board-accordion-board']/div");
        clickToElement(driver,"//div[@data-testid='configure-board-accordion-board']/div");
        sleepInSecond(1);
        // Take SS: YhM	Use simple filters
        waitForElementVisible(driver,"(//span[contains(@class,'spectrum-Link')])[1]");
        takeSnapShotWithHighlight(driver,"(//span[contains(@class,'spectrum-Link')])[1]", GlobalConstants.SCREENSHOTS+folder+"003_YhM.png");
        //change to Advanced Filters
        clickToElement(driver,"(//span[contains(@class,'spectrum-Link')])[1]");
        // Take SS: YhP	Start typing project name..., YhN	Use advanced filters, YhL1	Include completed work, YhH	Select users or teams
        waitForElementVisible(driver,"//input[@data-testid='include-completed-items']");
        takeSnapShotWithHighlight(driver,"//input[@data-testid='include-completed-items']/parent::label", GlobalConstants.SCREENSHOTS+folder+"003_YhL.png");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"(//input[contains(@data-testid,'phoenix-input-select')])[2]", GlobalConstants.SCREENSHOTS+folder+"003_YhH.png");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"(//input[contains(@data-testid,'phoenix-input-select')])[1]", GlobalConstants.SCREENSHOTS+folder+"003_YhP.png");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"//span[@data-testid='use-advanced-filters']", GlobalConstants.SCREENSHOTS+folder+"003_YhN.png");
    }
    @Test
    public void String_004() throws Exception {
//        Board
//        MockID:   Yhz	This column has archived cards. ...
//YhQ1	Delete all
//YhJ1	Delete column and cards?
//          Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//
//1. Login to Workfront
//2. Go to Main Menu > ''Boards''
//3. Choose any board with one column
//4. In column add card
//5. Send card to archive
//6. Click Delete in 3 dots in column

        // 2. Go to the ''Home'' tab
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/64662452af60958e637b5b53");
        waitForPageToLoadCompletely(driver,60);
        //click to 3 dot
        waitForElementVisible(driver,"//button[@data-testid='column-options-button']");
        clickToElement(driver,"//button[@data-testid='column-options-button']");
        waitForElementVisible(driver,"//li[@data-key='delete']");
        clickToElement(driver,"//li[@data-key='delete']");
        // Take SS: Yc1
        waitForElementVisible(driver,"//div[@data-testid='modal']");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='modal']", GlobalConstants.SCREENSHOTS+folder+"004_Yhz_YhQ_YhJ.png");

    }
    @Test
    public void String_005() throws Exception {
//        Board
//        MockID:   YhK1	Deleting this column will delete...
//          Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//
//1. Login to Workfront
//2. Go to Main Menu > ''Boards''
//3. Choose any board with one column
//4. In column add card
//5. Send card to archive
//6. Click Delete in 3 dots in column

        // 2. Go to the ''Home'' tab
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/645dfeaa54c2ab327d756c2d");
        waitForPageToLoadCompletely(driver,60);
        //click to 3 dot
        waitForElementVisible(driver,"//button[@data-testid='column-options-button']");
        clickToElement(driver,"//button[@data-testid='column-options-button']");
        waitForElementVisible(driver,"//li[@data-key='delete']");
        clickToElement(driver,"//li[@data-key='delete']");
        // Take SS: Yc1
        waitForElementVisible(driver,"//div[@data-testid='modal']");
        takeSnapShotWithHighlight(driver,"(//div[@data-testid='modal']//section)[2]", GlobalConstants.SCREENSHOTS+folder+"005_YhK.png");

    }
    @Test
    public void String_006() throws Exception {
//        Board
//        MockID:   Yhx	The {0} column contains archived...
//          Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//
//1. Login to Workfront
//2. Go to Main Menu > ''Boards''
//3. Choose any board
//4. Add empty column
//5. In column add card
//6. Send card to archive
//7. Click Delete in 3 dots in column

        // 2. Go to the ''Home'' tab
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/645e205001c9f20608cf1842");
        waitForPageToLoadCompletely(driver,60);
        //click to 3 dot
        waitForElementVisible(driver,"(//button[@data-testid='column-options-button'])[2]");
        clickToElement(driver,"(//button[@data-testid='column-options-button'])[2]");
        waitForElementVisible(driver,"//li[@data-key='delete']");
        clickToElement(driver,"//li[@data-key='delete']");
        // Take SS: Yc1
        waitForElementVisible(driver,"//div[@data-testid='modal']");
        takeSnapShotWithHighlight(driver,"(//div[@data-testid='modal']//section)[2]/div/div/div", GlobalConstants.SCREENSHOTS+folder+"006_Yhx.png");

    }
    @Test
    public void String_007() throws Exception {
//        Board
//        MockID:Yhy	Total points
//Yhw	Compare to:
//Yhv	Burndown chart
//Yhu	Agile metrics
//Yht	Points completed
//Yhs	Remaining points
//Yhq	Story points
//
//           Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64061f131fe74d1745186c04
//
//1. Login to Workfront
//2. Go to Mine Menu > Boards
//3. Choose any workstream
//4. Choose Metrics tab

        // 2. Go to the ''Home'' tab
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/63e0b0c69ac0b0b4161b77c5");
        waitForPageToLoadCompletely(driver,60);

        //3. Click on Metrics
        waitForElementVisible(driver,"//div[@data-key='metrics']");
        clickToElement(driver,"//div[@data-key='metrics']");

        //take screenshot
        waitForElementVisible(driver,"(//h2)[1]");
        takeSnapShotWithHighlight(driver,"(//h2)[1]", GlobalConstants.SCREENSHOTS+folder+"007_Yhv.png");
        takeSnapShotWithHighlight(driver,"(//h2)[2]", GlobalConstants.SCREENSHOTS+folder+"007_Yhu.png");
        takeSnapShotWithHighlight(driver,"//span[contains(@style,'color: rgb(142, 142, 142);')]", GlobalConstants.SCREENSHOTS+folder+"007_Yhw.png");
        takeSnapShotWithHighlight(driver,"//*[name()='path' and contains(@d,'M18,2A16,16,0,1,0,34,18,16.00008,16.00008,0,0,0,18,2Zm10.666,9')]/ancestor::div[@style='margin-top: 24px; margin-bottom: 24px;']", GlobalConstants.SCREENSHOTS+folder+"007_Yhy_Yhs_Yht.png");
        takeSnapShotWithHighlight(driver,"(//div[@style='position: relative;'])[1]", GlobalConstants.SCREENSHOTS+folder+"007_Yhq.png");

    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }
}
