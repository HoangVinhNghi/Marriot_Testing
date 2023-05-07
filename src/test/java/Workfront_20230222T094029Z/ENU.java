package Workfront_20230222T094029Z;

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
            openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/84160726-3e3f-4591-a7af-a93eff93f221/untitled_taxonomy-2/b2efa003-b8e9-411d-b716-73dc68804571/view");
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
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/84160726-3e3f-4591-a7af-a93eff93f221/untitled_taxonomy-2/b2efa003-b8e9-411d-b716-73dc68804571/view");
        waitForPageToLoadCompletely(driver,60);

        //click to dropdown
        waitForElementVisible(driver,"//button[@data-testid='view-widget-button']");
        clickToElement(driver,"//button[@data-testid='view-widget-button']");

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
    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }
    }
