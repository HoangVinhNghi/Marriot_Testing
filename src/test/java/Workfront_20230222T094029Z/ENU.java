package Workfront_20230222T094029Z;

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
public class ENU extends AbstractPage {
        WebDriver driver;
        String folder = "\\Workfront_20230222T094029Z\\ENU\\"; // the path to store the captured images with  lang code can be changed accordingly
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
        public void String_001() throws Exception {
//        Board
//        MockID:   Yce	Quarter
//                  Ycf	W
//                  Ycg	Month
//                  Yci	Today
//                  Yck	Q
//                  Ycl	Year
//            Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces
//
//1. Login to Workfront
//2. Go to Main Menu
//3. Go to "Maestro"
//4. Under the "Taxonomies" click on a "+ Add Taxonomy"
//5. Click on a "Default View - View" on the right side
//6. Click on a "+ Create a new view" button
//7. Enter "View name"
//8. Choose "Timeline"
//9. Click on a "Default View - View" on the right side
//10. Choose created timeline
//11. Open dropdown(Year/Quarter/Month) on the right side

            // 2. Go to the ''Home'' tab
            openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/38e832b8-07ce-4ae2-a17a-5c29c6c7ff67/untitled_taxonomy-7/63763c40-f9d0-43df-86de-9e4ebbe67de7/view");
            waitForPageToLoadCompletely(driver,60);

            // Take SS: Yci
            waitForElementVisible(driver,"//button[@data-testid='today-button']");
            takeSnapShotWithHighlight(driver,"//button[@data-testid='today-button']", GlobalConstants.SCREENSHOTS+folder+"001_Yci.png");

            // Take SS: Yck
            waitForElementVisible(driver,"(//div[@class='Calendar-clickable-subheader-Textwrapper'])[1]");
            takeSnapShotWithHighlight(driver,"(//div[@class='Calendar-clickable-subheader-Textwrapper'])[1]", GlobalConstants.SCREENSHOTS+folder+"001_Yck.png");

            //3. click on dropdown
            waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M9.99 1.01A1 1 0 0 0 8.283.303L5 3.586 1.717.303A1 1 0 1 0')]/ancestor::button");
            clickToElement(driver,"//*[name()='path' and contains(@d,'M9.99 1.01A1 1 0 0 0 8.283.303L5 3.586 1.717.303A1 1 0 1 0')]/ancestor::button");

            // Take SS: Ycl_Yce_Ycg
            waitForElementVisible(driver,"//div[@data-testid='popover']");
            takeSnapShotWithHighlight(driver,"//div[@data-testid='popover']", GlobalConstants.SCREENSHOTS+folder+"001_Ycl_Yce_Ycg.png");

            //Select Month
            waitForElementVisible(driver,"//div[contains(@id,'option-MONTH')]");
            clickToElement(driver,"//div[contains(@id,'option-MONTH')]");

            // Take SS: Ycf
            waitForElementVisible(driver,"(//div[@class='Calendar-clickable-subheader-Textwrapper'])[1]");
            takeSnapShotWithHighlight(driver,"//div[@class='Calendar-clickable-subheader-Textwrapper']", GlobalConstants.SCREENSHOTS+folder+"001_Ycf.png");
        }
        @Test
        public void String_002() throws Exception {
//        Board
//        MockID:   Ycv	Embed an external source
//Ycu	Web Content
//Yct	View data in graphs and charts
//Ycs	View data in columns and rows
//Ycr	Visualization

//            Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//            Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces
//            1. Login to Workfront 2. Go to Main Menu 3. Go to "Reporting" 4. Click "New report"

        // 2. Go to the ''Home'' tab
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/reporting-canvas/report/64568e482addf06891c2642d/edit");
        waitForPageToLoadCompletely(driver,60);

        // Take SS: Ycs
        waitForElementVisible(driver,"//li[@data-testid='builder-layout-table']");
        takeSnapShotWithHighlight(driver,"//li[@data-testid='builder-layout-table']", GlobalConstants.SCREENSHOTS+folder+"002_Ycs.png");

        // Take SS: Ycr Yct
        waitForElementVisible(driver,"//li[@data-testid='builder-layout-chart']");
        takeSnapShotWithHighlight(driver,"//li[@data-testid='builder-layout-chart']", GlobalConstants.SCREENSHOTS+folder+"002_Ycr_Yct.png");

        // Take SS: Ycu Ycv
        waitForElementVisible(driver,"//li[@data-testid='builder-layout-webContent']");
        takeSnapShotWithHighlight(driver,"//li[@data-testid='builder-layout-webContent']", GlobalConstants.SCREENSHOTS+folder+"002_Ycu_Ycv.png");

    }
        @Test
        public void String_003() throws Exception {
//        Board
//        MockID:   YcA1	Are you sure you want to delete ...
//                  YcC1	View name
//                  YcI1	Delete record type
//                  YYd	    Create new view
//                  YZf	    Events display in chronological ...
//           Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces
//
//1. Login to Workfront
//2. Go to Main Menu
//3. Go to "Maestro"
//4. Under the "Taxonomies" click on a "+ Add Taxonomy"
//5. Click on a "Default View - View" on the right side

        // 2. Go to the ''Home'' tab
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/38e832b8-07ce-4ae2-a17a-5c29c6c7ff67/untitled_taxonomy-7/63763c40-f9d0-43df-86de-9e4ebbe67de7/view");
        waitForPageToLoadCompletely(driver,60);

        //click to dropdown
        waitForElementVisible(driver,"//button[@data-testid='view-widget-button']");
        clickToElement(driver,"//button[@data-testid='view-widget-button']");
        sleepInSecond(1);
        // Take SS: YYd
        waitForElementVisible(driver,"//button[@data-testid='rich-picker-action-button']");
        takeSnapShotWithHighlight(driver,"//button[@data-testid='rich-picker-action-button']", GlobalConstants.SCREENSHOTS+folder+"003_YYd.png");

        //Create new view
        clickToElement(driver,"//button[@data-testid='rich-picker-action-button']");

        // Take SS: YcC1 YZf
        waitForElementVisible(driver,"//form[@data-testid='create-view-form']//h2");
        takeSnapShotWithHighlight(driver,"//form[@data-testid='create-view-form']//h2", GlobalConstants.SCREENSHOTS+folder+"003_YcC1.png");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"(//form[@data-testid='create-view-form']//input[@type='radio'])[2]", GlobalConstants.SCREENSHOTS+folder+"003_YZf.png");


    }
       /* @Test
        public void String_004() throws Exception {
//        Board
//        MockID:   Yc1	Name
//                  Ycz	Due on
//           Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
//
//1. Login to Workfront
//2. Go to the ''Home'' tab
//3. Click on a ''Try out new Home'' button on the down right corner
//4. Click on a ''Manage widgets'' button on the top right corner > ''+ Add widget''
//5. Select ''Team Requests'' and click on an ''Add'' button
//6. Find ''Team Requests'' widget on ''Home'' screen

        // 2. Go to the ''Home'' tab
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        waitForPageToLoadCompletely(driver,60);

        // Take SS: Yc1
        waitForElementVisible(driver,"(//div[@role='presentation']//div[@role='columnheader'])[1]");
        takeSnapShotWithHighlight(driver,"(//div[@role='presentation']//div[@role='columnheader'])[1]", GlobalConstants.SCREENSHOTS+folder+"004_Yc1.png");

        // Take SS: Ycz
        waitForElementVisible(driver,"(//div[@role='presentation']//div[@role='columnheader'])[3]");
        takeSnapShotWithHighlight(driver,"(//div[@role='presentation']//div[@role='columnheader'])[3]", GlobalConstants.SCREENSHOTS+folder+"004_Ycz.png");

    }*/

        /*@Test
        public void String_004() throws Exception {
//        Board
//        MockID:   YcA1	Are you sure you want to delete ...
//                  YcI1	Delete record type
//
//           Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/2fd91509-dfed-41c9-9c8b-026b585acf5e/e592ce83-35f9-40da-8c2c-69688e8cff3d/table?view=7a350436-208c-4f74-83b4-a17abade515e
//
//1. Login to Workfront
//2. Go to Main Menu > "Maestro"
//3. Select any Operational Record type or create a new one
//4. Click on a ''...'' near the Operational Record Type name > ''Delete''

        // 2. Go to the ''Home'' tab
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/a38be145-1ca7-44ae-a65b-d4df20d5a9e7/untitled_operational_record_type-58/269b81b6-7521-4936-be55-a55725658dee/view");
        waitForPageToLoadCompletely(driver,60);

        //click to 3 dot
        waitForElementVisible(driver,"//button[contains(@class,'spectrum-ActionButton')][2]");
        clickToElement(driver,"//button[contains(@class,'spectrum-ActionButton')][2]");

        //click to delete
        waitForElementVisible(driver,"//li[@data-key='REMOVE']");
        clickToElement(driver,"//li[@data-key='REMOVE']");
        sleepInSecond(2);

        // Take SS: YcI1
        waitForElementVisible(driver,"//h2[2]");
        takeSnapShotWithHighlight(driver,"//h2[2]", GlobalConstants.SCREENSHOTS+folder+"004_YcI1.png");

        // Take SS: YcA1
        waitForElementVisible(driver,"//section[2]");
        takeSnapShotWithHighlight(driver,"//section[2]", GlobalConstants.SCREENSHOTS+folder+"004_YcA1.png");


    }*/
        @Test
        public void String_005() throws Exception {
//        Board
//        MockID:
//            YcG1	Operational Record Types
//
//           Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/28fb7ef5-2572-4387-95e1-cc3a57d52ab6
//
//1. Login to Workfront
//2. Go to Main Menu > ''Maestro''
//3. Near the ''Workspace'' name click on a down arrow button > ''Create workspace''
//4. Click on a ''Preview'' button of any workspace template card

        // 2. Go to the ''Home'' tab
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/d5537cf5-03f5-4f51-bcd6-e71ca9160b2a");
        waitForPageToLoadCompletely(driver,60);

        // Take SS: YcG1
        waitForElementVisible(driver,"(//div[@class='RecordTypeItemNew clickable'])[2]");
        takeSnapShotWithHighlight(driver,"(//div[@class='RecordTypeItemNew clickable'])[2]", GlobalConstants.SCREENSHOTS+folder+"005_YcG1.png");

        }
        @Test
        public void String_006() throws Exception {
//        Board
//        MockID:   YcB1	{0} workspace preview
//
//           Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/28fb7ef5-2572-4387-95e1-cc3a57d52ab6
//
//1. Login to Workfront
//2. Go to Main Menu > ''Maestro''
//3. Near the ''Workspace'' name click on a down arrow button > ''Create workspace''
//4. Click on a ''Preview'' button of any workspace template card

        // 2. Go to the ''Home'' tab
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/d5537cf5-03f5-4f51-bcd6-e71ca9160b2a");
        waitForPageToLoadCompletely(driver,60);

        //create new workspace
        waitForElementVisible(driver,"//button[@data-testid='header-object-selection']");
        clickToElement(driver,"//button[@data-testid='header-object-selection']");
        waitForElementVisible(driver,"//li[@data-key='new-workspace']");
        clickToElement(driver,"//li[@data-key='new-workspace']");
        waitForElementVisible(driver,"(//section[@class='spectrum-Card spectrum-Card--sizeL spectrum-Card--workspace'])[3]");
        waitForElementVisible(driver,"(//button[@data-variant='secondary'])[2]");
        clickToElement(driver,"(//button[@data-variant='secondary'])[2]");

        //take screenshot
        waitForElementVisible(driver,"(//div[@data-testid='modal']//h2)[2]");
        takeSnapShotWithHighlight(driver,"(//div[@data-testid='modal']//h2)[2]", GlobalConstants.SCREENSHOTS+folder+"006_YcB1.png");

    }
        @Test
        public void String_007() throws Exception {
//        Board
//        MockID:
//            YcM1	Active workstreams
//            YcN1	Archived workstreams
//
//           Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//
//1. Login to Workfront
//2. Go to Main Menu > ''Boards''
//3. Click on a ''Filter'' for ''Workstreams'' section

        // 2. Go to the ''Home'' tab
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards");
        waitForPageToLoadCompletely(driver,60);

        //3. Click on a ''Filter'' for ''Workstreams'' section
        waitForElementVisible(driver,"//button[@data-testid='dashboard-workspace-section-filter-button']");
        clickToElement(driver,"//button[@data-testid='dashboard-workspace-section-filter-button']");

        //take screenshot
        waitForElementVisible(driver,"//li[@data-key='active']");
        takeSnapShotWithHighlight(driver,"//li[@data-key='active']", GlobalConstants.SCREENSHOTS+folder+"007_YcM1.png");
        waitForElementVisible(driver,"//li[@data-key='archived']");
        takeSnapShotWithHighlight(driver,"//li[@data-key='archived']", GlobalConstants.SCREENSHOTS+folder+"007_YcN1.png");

    }
        @Test
        public void String_008() throws Exception {
//        Board
//        MockID:
//            Ycq	Add a form name
//            Yco	Add a form description
//
//           Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ
//
//1. Login to Workfront
//2. Go to Main Menu > click on a ''Setup''
//3. On the right menu select ''Custom Forms''
//4. Go to ''Forms'' tab and click on a ''+ New Custom Form'' button

        // 2. Go to the ''Home'' tab
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ");
        waitForPageToLoadCompletely(driver,60);

        //take screenshot
        waitForElementVisible(driver,"//h2");
        takeSnapShotWithHighlight(driver,"//h2", GlobalConstants.SCREENSHOTS+folder+"008_Ycq.png");
        waitForElementVisible(driver,"(//h3)[1]");
        takeSnapShotWithHighlight(driver,"(//h3)[1]", GlobalConstants.SCREENSHOTS+folder+"008_Yco.png");

    }
        @Test
        public void String_009() throws Exception {
//        Board
//        MockID: Ycp	You must enter a form name
//
//Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ
//
//1. Login to Workfront
//2. Go to Main Menu > click on a ''Setup''
//3. On the right menu select ''Custom Forms''
//4. Go to ''Forms'' tab and click on a ''+ New Custom Form'' button
//5. Click on an ''Apply'' button

        // 2. Go to the ''Home'' tab
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/form-builder/new?objTypes=PROJ");
        waitForPageToLoadCompletely(driver,60);

        //Click on an "Apply" button
        waitForElementVisible(driver,"//button[@data-tracking-id='apply']");
        clickToElement(driver,"//button[@data-tracking-id='apply']");

        //take screenshot
        waitForElementVisible(driver,"//div[@data-testid='toast-notification']");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='toast-notification']", GlobalConstants.SCREENSHOTS+folder+"009_Ycp.png");

    }
        @Test
        public void String_010() throws Exception {
//        Board
//        MockID:   YcL1	Try out the Commenting Beta
//                  YcJ1	Go back to the current Commentin...
//Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/issue/625d4630000393933c1b80897e2cf401/updates
//
//1. Login to Workfront
//2. Go to ''Projects'' tab
//3. Open any project or create a new one
//4. On the left sidebar select ''Requests''
//5. Open any request or create a new one
//6. On the left sidebar select ''Updates''

        // 2. Go to the ''Home'' tab
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/issue/625d4630000393933c1b80897e2cf401/updates");
        waitForPageToLoadCompletely(driver,60);

        //Click on an "Apply" button
        waitForElementVisible(driver,"//button[@data-tracking-id='apply']");
        clickToElement(driver,"//button[@data-tracking-id='apply']");

        //take screenshot
        waitForElementVisible(driver,"//div[@data-testid='toast-notification']");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='toast-notification']", GlobalConstants.SCREENSHOTS+folder+"009_Ycp.png");

    }
        @Test
        public void String_011() throws Exception {
//        Board
//        MockID:   Ych	Previous
//                  Ycj	Next
//            Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces
//
//1. Login to Workfront
//2. Go to Main Menu
//3. Go to "Maestro"
//4. Under the "Taxonomies" click on a "+ Add Taxonomy"
//5. Click on a "Default View - View" on the right side
//6. Click on a "+ Create a new view" button
//7. Enter "View name"
//8. Choose "Timeline"
//9. Click on a "Default View - View" on the right side
//10. Choose created timeline
//11. Open inspect

        // 2. Go to the ''Home'' tab
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/38e832b8-07ce-4ae2-a17a-5c29c6c7ff67/untitled_taxonomy-7/63763c40-f9d0-43df-86de-9e4ebbe67de7/view");
        waitForPageToLoadCompletely(driver,60);

        // Take SS: Ych
        waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M12,18v0a1.988,1.988,0,0,0,.585')]/ancestor::button')]");
        inspectElement(driver,"//*[name()='path' and contains(@d,'M12,18v0a1.988,1.988,0,0,0,.585')]/ancestor::button')]");
            Robot rb = new Robot();
            rb.keyPress(KeyEvent.VK_UP);        rb.keyRelease(KeyEvent.VK_UP);
            rb.keyPress(KeyEvent.VK_UP);        rb.keyRelease(KeyEvent.VK_UP);
        captureScreen(GlobalConstants.SCREENSHOTS+folder+"011_Ych.png");
        // Take SS: Ycj
        waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M24,18v0a1.988,1.988,0,0,1-.585,1.409l-7.983,7.98a2')]/ancestor::button')]");
        inspectElement(driver,"//*[name()='path' and contains(@d,'M24,18v0a1.988,1.988,0,0,1-.585,1.409l-7.983,7.98a2')]/ancestor::button')]");
            rb.keyPress(KeyEvent.VK_UP);        rb.keyRelease(KeyEvent.VK_UP);
            rb.keyPress(KeyEvent.VK_UP);        rb.keyRelease(KeyEvent.VK_UP);
        captureScreen(GlobalConstants.SCREENSHOTS+folder+"011_Ycj.png");


        }
        @Test
        public void String_012() throws Exception {
//        Board
//        MockID:   YWn	You must assign a new auto-upgra...
//            Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/access-levels
//
//1. Login to Workfront
//2. Go to Setup -> Access Levels
//3. Select 'Light' access level and click Delete

        // 2. Go to the ''Home'' tab
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/setup/access-levels");
        waitForPageToLoadCompletely(driver,60);

        //3. Select 'Light' access level and click Delete
        waitForElementVisible(driver,"(//div[@class='CheckBox '])[7]");
        checkToCheckboxOrRadio(driver,"(//div[@class='CheckBox '])[7]");
        waitForElementVisible(driver,"//button[@id='deleteToolbar']");
        clickToElement(driver,"//button[@id='deleteToolbar']");

        // Take SS: YWn
            captureScreen(GlobalConstants.SCREENSHOTS+folder+"012_YWn.png");
        }
        @Test
        public void String_013() throws Exception {
//        Board
//        MockID:   Ycd	All Approvals
//Ycc	Requests Sent To My Team
//Ycb	All approval items
//Yca	Team Requests
//
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
//
//1. Login to Workfront
//2. Go to the ''Home'' tab
//3. Click on a ''Try out new Home'' button on the down right corner
//4. Click on a ''Manage widgets'' button on the top right corner > ''+ Add widget''

        // 2. Go to the ''Home'' tab
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        waitForPageToLoadCompletely(driver,60);

        //remove team request first
            //Click customize
        waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M33.567,8.2,27.8,2.432a1.215,1.215,0,0')]/ancestor::button')]");
        clickToElement(driver,"//*[name()='path' and contains(@d,'M33.567,8.2,27.8,2.432a1.215,1.215,0,0')]/ancestor::button')]");

        // Take SS: Yca Ycc
        takeSnapShotWithHighlight(driver,"//g[@clip-path='url(#Team_Requests_svg__e)']/ancestor::div[contains(@id,'react-spectrum')]", GlobalConstants.SCREENSHOTS+folder+"013_Yca_Ycc.png");
        takeSnapShotWithHighlight(driver,"//g[@clip-path='url(#All_Approvals_svg__D)']/ancestor::div[contains(@id,'react-spectrum')]", GlobalConstants.SCREENSHOTS+folder+"013_Yca_Ycc.png");
        }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }
    }
