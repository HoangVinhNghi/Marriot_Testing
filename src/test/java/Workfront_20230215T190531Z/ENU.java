package Workfront_20230215T190531Z;

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

public class ENU extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20230215T190531Z\\ENU\\"; // the path to store the captured images with  lang code can be changed accordingly
    // Select the lang code accordingly
    String lang_EN = "--lang=en";
    String lang_DE = "--lang=de";
    String lang_ES = "--lang=es";
    String lang_FR = "--lang=fr";
    String lang_IT = "--lang=it";
    String lang_JP = "--lang=ja-JP";
    String lang_PB = "--lang=pt-BR";

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
    public void String_01() throws Exception {
//        MockID: YbW Move board to a workstream to share Cards, Members and Data across multiple views.
//        Steps
//Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//
//1. Login to Workfront
//2. Go to Main Menu > ''Boards''
//3. Open any workstream or create a new one by clicking on a ''Add workstream''
//4. Add some board and open it
//5. Click on three dots -> Move to workstream

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/");
        waitForPageToLoadCompletely(driver, 60);
        clickToElement(driver, "//button[@data-testid='dashboard-workspace-section-filter-button']");
        sleepInSecond(2);
        clickToElement(driver, "(//li[@role='menuitemradio'])[2]");
        clickToElement(driver, "(//button[contains(@data-testid,'workspace-options')])[1]");
        waitForElementVisible(driver, "(//li[@role='menuitem'])[1]");

        takeSnapShotWithHighlight(driver, "(//li[@role='menuitem'])[1]", GlobalConstants.SCREENSHOTS + folder + "01_YbW.png");

    }

    @Test
    public void String_02() throws Exception {
//        MockID: YbX Backlog
//        Steps
//Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//
//1. Login to Workfront
//2. Go to Main Menu > ''Boards''

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64061f131fe74d1745186c04/board/64568068703c7f05d888c51c");
        waitForPageToLoadCompletely(driver, 60);
        waitForElementVisible(driver, "//div[contains(@data-testid,'column-backlog')]//h3");
        takeSnapShotWithHighlight(driver, "//div[contains(@data-testid,'column-backlog')]//h3", GlobalConstants.SCREENSHOTS + folder + "02_YbX.png");
    }

    @Test
    public void String_03_4_5() throws Exception {
//        MockID: Yar	Restore all fields to default
//        Yb1	CARD FIELDS
//        Ybi	VISIBLE ON BOARD

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64061f131fe74d1745186c04/board/64568068703c7f05d888c51c
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Boards''
//        3. Click on a ''Add board''
//        4. Click on a ''Create board''' button
//        5. Click on ''Configure'' > ''Cards''

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64061f131fe74d1745186c04/board/64568068703c7f05d888c51c");
        waitForPageToLoadCompletely(driver, 60);
        waitForElementVisible(driver, "//div[@data-testid='board-configure-button']/button");
        clickToElement(driver, "//div[@data-testid='board-configure-button']/button");
        clickToElement(driver, "//div[@data-testid='configure-board-accordion-card']");

        takeSnapShotWithHighlight(driver, "//span[@role='link']", GlobalConstants.SCREENSHOTS + folder + "03_Yar.png");
        takeSnapShotWithHighlight(driver, "//div[contains(@style,'width: 100%; flex-direction: row; gap: var(--spectrum-global-dimension-size-150, var(--spectrum-alias-size-150));')]", GlobalConstants.SCREENSHOTS + folder + "04_05_Yb1_Ybi.png");

    }

    @Test
    public void String_06_9() throws Exception {
//        MockID: YbG	Card List
//                Yal	View List
//                YbD	Cards pointed
//                Ya4	configure workstream

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64575dd5fd92681780115d53
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Boards''
//        3. Click on a ''Add workstream''

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64575dd5fd92681780115d53");
        waitForPageToLoadCompletely(driver, 60);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='workstream-card-list']", GlobalConstants.SCREENSHOTS + folder + "06_YbG.png");

        clickToElement(driver, "//div[contains(@class,'TabsPanel-collapseWrapper')]/following-sibling::div");
        clickToElement(driver,"(//div[@class='styles-module_sectionHeader__3wKJD'])[4]");
        takeSnapShotWithHighlight(driver, "(//button[@data-testid='close-rail-button'])[1]/preceding-sibling::span", GlobalConstants.SCREENSHOTS + folder + "07_Ya4.png");
        takeSnapShotWithHighlight(driver, "(//button[@data-style='outline'])[3]", GlobalConstants.SCREENSHOTS + folder + "08_Yal.png");
        takeSnapShotWithHighlight(driver, "(//div[@style='background-color: rgb(244, 244, 244); margin: 6px; padding: var(--spectrum-global-dimension-size-85, var(--spectrum-alias-size-85)); border-radius: var(--spectrum-alias-border-radius-medium);'])[2]",
                GlobalConstants.SCREENSHOTS + folder + "09_YbD.png");
    }

    @Test
    public void String_10() throws Exception {
//        MockID: YbO	Are you sure you want to delete ...
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64575dd5fd92681780115d53
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Boards''
//        3. Click on a ''Add workstream''

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64575dd5fd92681780115d53");
        waitForPageToLoadCompletely(driver, 60);

        clickToElement(driver, "//div[@data-testid='workstream-card-list']");
        clickToElement(driver, "(//div[contains(@class,'baseSelectionTab')])[2]");
        checkToCheckboxOrRadio(driver,"(//input[contains(@class,'Checkbox-input')])[2]");
        checkToCheckboxOrRadio(driver,"(//input[contains(@class,'Checkbox-input')])[3]");
        clickToElement(driver,"(//button[contains(@class,'ButtonGroup-Button')])[2]");
        takeSnapShotWithHighlight(driver, "//section[contains(@class,'spectrum-Dialog-content')]", GlobalConstants.SCREENSHOTS + folder + "10_YbO.png");
    }
    @Test
    public void String_11_12() throws Exception {
//        MockID: Ybo	Custom statuses
//                YbB	The custom status is applied whe...

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/6459ce5afaa29be7e32b9931/board/6459ce75faa29be7e32b9d9a
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Boards''
//        3. Click on a ''Add workstream''
//        4. In ''Boards'' tab click on a ''Add board'' button > click on ''Use board template'' button on ''Iteration Process'' card
//        5. Click on a newly created ''Iteration Process'' card
//        6. Find ''In Progress'' column and click on a ''...'' button near it > ''Edit''

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/6459ce5afaa29be7e32b9931/board/6459ce75faa29be7e32b9d9a");
        waitForPageToLoadCompletely(driver, 60);

        clickToElement(driver, "(//button[@data-testid='column-options-button'])[2]");
        clickToElement(driver, "(//li[@role='menuitem'])[1]");

        waitForElementVisible(driver,"//span[@data-testid='workfront-task-status-mapping']");
        scrollToElement(driver,"//span[@data-testid='workfront-task-status-mapping']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//span[@data-testid='workfront-task-status-mapping']", GlobalConstants.SCREENSHOTS + folder + "11_Ybo.png");

        clickToElement(driver,"//button[contains(@class,'react-spectrum-ContextualHelp-button')]");
        takeSnapShotWithHighlight(driver, "//section[contains(@class,'ContextualHelp-content')]", GlobalConstants.SCREENSHOTS + folder + "12_YbB.png");
    }
    @Test
    public void String_13() throws Exception {
//        MockID: Yau	End date
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64575dd5fd92681780115d53/card%20list
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Boards''
//        3. Click on a ''Add workstream''

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64575dd5fd92681780115d53/card%20list");
        waitForPageToLoadCompletely(driver, 60);

        clickToElement(driver, "//div[@data-testid='workstream-card-list']");
        clickToElement(driver, "//button[@data-testid='action-bar-create-iteration-button']");
        waitForElementVisible(driver, "(//div[contains(@class,'react-spectrum-Datepicker-fieldWrapper')]/span)[3]");
        takeSnapShotWithHighlight(driver, "(//div[contains(@class,'react-spectrum-Datepicker-fieldWrapper')]/span)[3]", GlobalConstants.SCREENSHOTS + folder + "13_Yau.png");
    }
    @Test
    public void String_14_15() throws Exception {
//        MockID: YbE	Board status
//        Yb3	Board template
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64575dd5fd92681780115d53
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Boards''
//        3. Click on a ''Add workstream''

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64575dd5fd92681780115d53");
        waitForPageToLoadCompletely(driver, 60);
        clickToElement(driver, "//button[@data-testid='dashboard-section-filter-rail-button']");
        waitForElementVisible(driver, "//div[@data-testid='filter-rail-group-heading-status']");
        takeSnapShotWithHighlight(driver, "//div[@data-testid='filter-rail-group-heading-status']", GlobalConstants.SCREENSHOTS + folder + "14_YbE.png");
        takeSnapShotWithHighlight(driver, "//div[@data-testid='filter-rail-group-heading-template']", GlobalConstants.SCREENSHOTS + folder + "15_Yb3.png");
    }
    @Test
    public void String_16_17_18_19() throws Exception {
//        MockID: Yak	Configure iterations
//                Yab	Click "Configure iterations" to ...
//                YbQ	No iterations yet
//                Ya8	if applicable, or to a
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/6459ce5afaa29be7e32b9931/board/6459ce75faa29be7e32b9d9a
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Boards''
//        3. Click on a ''Add workstream''
//        4. In ''Boards'' tab click on a ''Add board'' button > click on ''Use board template'' button on ''Iteration Process'' card
//        5. Click on a newly created ''Iteration Process'' card
//        6. Find ''In Progress'' column and click on a ''...'' button near it > ''Edit''

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/6459ce5afaa29be7e32b9931/board/6459ce75faa29be7e32b9d9a");
        waitForPageToLoadCompletely(driver, 60);

        waitForElementVisible(driver,"(//*[name()='path' and contains(@d,'M33.5,6H15.9A5,5,0,0,0,6.1,6H2')])[2]/ancestor::button");
        takeSnapShotWithHighlight(driver, "(//*[name()='path' and contains(@d,'M33.5,6H15.9A5,5,0,0,0,6.1,6H2')])[2]/ancestor::button",
                GlobalConstants.SCREENSHOTS + folder + "16_Yak.png");

        takeSnapShotWithHighlight(driver, "((//*[name()='path' and contains(@d,'M33.5,6H15.9A5,5,0,0,0,6.1,6H2')])[2]/ancestor::button/preceding-sibling::div)[2]",
                GlobalConstants.SCREENSHOTS + folder + "17_YbQ.png");

        takeSnapShotWithHighlight(driver, "((//*[name()='path' and contains(@d,'M33.5,6H15.9A5,5,0,0,0,6.1,6H2')])[2]/ancestor::button/preceding-sibling::div)[3]",
                GlobalConstants.SCREENSHOTS + folder + "18_Yab.png");

        clickToElement(driver, "(//button[@data-testid='column-options-button'])[2]");
        clickToElement(driver, "(//li[@role='menuitem'])[1]");
        scrollToElement(driver,"//span[@data-testid='workfront-task-status-mapping']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='default-task-status-picker']");
        sleepInSecond(1);
        clickToElement(driver,"(//div[contains(@class,'spectrum-Menu-itemGrid')])[2]");
        takeSnapShotWithHighlight(driver, "(//div[.='Workfront']/following-sibling::div//span)[1]", GlobalConstants.SCREENSHOTS + folder + "19_Ya8.png");
    }
    @Test
    public void String_20() throws Exception {
//        MockID: Ya6	Iteration Execution Board
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Boards''
//        3. Open any workstream
//        4. Click on a ''Card List'' tab
//        5. Click on a ''Iteration view'' button
//        6. Click on a ''Configure'' button

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64575dd5fd92681780115d53");
        waitForPageToLoadCompletely(driver, 60);

        clickToElement(driver, "//div[contains(@class,'TabsPanel-collapseWrapper')]/following-sibling::div");
        clickToElement(driver,"(//div[@class='styles-module_sectionHeader__3wKJD'])[4]");
        scrollToElement(driver,"(//*[name()='svg'][contains(@class,'icon-iteration')])[2]/parent::div/following-sibling::h4");
        takeSnapShotWithHighlight(driver, "(//*[name()='svg'][contains(@class,'icon-iteration')])[2]/parent::div/following-sibling::h4", GlobalConstants.SCREENSHOTS + folder + "20_Ya6.png");
    }
    @Test
    public void String_21() throws Exception {
//        MockID: Ybm	Iteration process
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Boards''
//        3. Click on a ''Add workstream''
//        4. Click on a ''Configure'' button


        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64575dd5fd92681780115d53");
        waitForPageToLoadCompletely(driver, 60);
        clickToElement(driver, "//div[contains(@class,'TabsPanel-collapseWrapper')]/following-sibling::div");
        clickToElement(driver,"(//div[@class='styles-module_sectionHeader__3wKJD'])[4]");

        waitForElementVisible(driver,"//span[@style='line-height: 0; text-transform: uppercase; color: rgb(50, 50, 50); font-size: 14px; font-weight: 700;']/parent::div");
        takeSnapShotWithHighlight(driver, "//span[@style='line-height: 0; text-transform: uppercase; color: rgb(50, 50, 50); font-size: 14px; font-weight: 700;']/parent::div",
                GlobalConstants.SCREENSHOTS + folder + "21_Ybm.png");
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //        driver.quit();
    }

}