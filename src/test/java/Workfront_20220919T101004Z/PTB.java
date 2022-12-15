package Workfront_20220919T101004Z;

import common.AbstractPage;
import common.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PTB extends AbstractPage {
    WebDriver driver;
    Actions action;

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
    public void TC_001_String_001() {
//        Mock ID: SbC
//        Core string: Add users to {__mlm_up_project} Team
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/people
//        1. Login to Workfront
//        2. Open any project and go to People tab
//        3. Click on 'Add users' button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/people");

        waitForElementVisible(driver,"//button[@data-testid='add-to-project']");
        clickToElement(driver,"//button[@data-testid='add-to-project']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//header[@data-testid='confirm-dialog-dialog-header']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\01_SbC.png");
    }

    @Test
    public void TC_002_String_002() {
//        Mock ID: UjL
//        Core string: Search users
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/people
//        1. Login to Workfront
//        2. Open any project and go to People tab
//        3. Click on 'Add users' button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/people");

        waitForElementVisible(driver,"//button[@data-testid='add-to-project']");
        clickToElement(driver,"//button[@data-testid='add-to-project']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//input[@data-testid='phoenix-input-select-0']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\02_UjL.png");
    }

    @Test
    public void TC_003_String_003() {
//        Mock ID: ULe
//        Core string: Add users
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/people
//        1. Login to Workfront
//        2. Open any project and go to People tab
//        3. Click on 'Add users' button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/people");

        waitForElementVisible(driver,"//button[@data-testid='add-to-project']");
        clickToElement(driver,"//button[@data-testid='add-to-project']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//section[@data-testid='confirm-dialog-dialog-body']/div[1]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\03_ULe.png");
    }

    @Test
    public void TC_004_String_004() {
//        Mock ID: Xmr
//        Core string: Undo comment
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/user/61f9b69800061c20bc107fe06c49e6ce/updates
//         1. Login to Workfront
//         2. Open any Updates page E.g. Current User -> Updates
//         3. Add some comment

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/user/61f9b69800061c20bc107fe06c49e6ce/updates");

        waitForElementVisible(driver,"//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']");
        clickToElement(driver,"//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']");
        sleepInSecond(1);
        sendKeyToElement(driver,"//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']","updated comment test");
        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='update-button']");
        sleepInSecond(1);

        takeSnapShotWithHighlight(driver, "//button[contains(@class,'cursor-pointer ')]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\04_Xmr.png");
    }

    @Test
    public void TC_005_String_005() {
//        Mock ID: YC1
//        Core string: Saving these changes will archive all cards older than {0} days in column {1}. Do you want to save and archive cards from the board?
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/
//        1. Login to Workfront
//        2. Go to Main Menu -> Boards
//        3. Create a new Kanban board
//        4. Click on Configure -> Automatically archive cards from the board
//        5. Select any option in the "In column" dropdown

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/");

        //Click to Create new
        waitForElementVisible(driver,"//button[@data-testid='dashboard-create-board-button']");
        clickToElement(driver,"//button[@data-testid='dashboard-create-board-button']");

        // Click on Configure
        waitForElementVisible(driver,"//div[@data-testid='board-configure-button']//button");
        clickToElement(driver,"//div[@data-testid='board-configure-button']//button");
        sleepInSecond(1);
        // click on Card
        waitForElementVisible(driver,"//div[@data-testid='configure-board-accordion-card']");
        clickToElement(driver,"//div[@data-testid='configure-board-accordion-card']");
        sleepInSecond(1);

        // Click on Automatically archive cards from the board
        waitForElementVisible(driver,"//input[@data-testid='card-falloff-switch']");
        clickToElement(driver,"//input[@data-testid='card-falloff-switch']");
        sleepInSecond(1);

        // Select any option in the "In column" dropdown
        waitForElementVisible(driver,"//button[@data-testid='card-falloff-column']");
        clickToElement(driver,"//button[@data-testid='card-falloff-column']");
        sleepInSecond(1);
        clickToElement(driver,"(//div[contains(@class,'spectrum-Menu-itemGrid')])[1]");


        waitForElementVisible(driver,"//section[contains(@class,'spectrum-Dialog-content')]");
        sleepInSecond(1);

        takeSnapShotWithHighlight(driver, "//section[contains(@class,'spectrum-Dialog-content')]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\05_YC1.png");
    }

    @Test
    public void TC_006_String_007() {
//        Mock ID: YD+
//        Core string: Column 3
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/
//        1. Login to Workfront
//        2. Go to Main Menu -> Boards
//        3. Create a new basic board

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/");

        //Click to Create new
        waitForElementVisible(driver,"//button[@data-testid='dashboard-create-board-button']");
        clickToElement(driver,"//button[@data-testid='dashboard-create-board-button']");

        waitForAllElementVisible(driver,"//div[contains(@data-testid,'column-default-')]");
        takeSnapShotWithHighlight(driver, "//div[contains(@data-testid,'column-default-')][3]//h3",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\07_YC1.png");
    }

    @Test
    public void TC_007_String_009() {
//        Mock ID: YD8
//        Core string: Column 2
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/
//        1. Login to Workfront
//        2. Go to Main Menu -> Boards
//        3. Create a new basic board

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/");

        //Click to Create new
        waitForElementVisible(driver,"//button[@data-testid='dashboard-create-board-button']");
        clickToElement(driver,"//button[@data-testid='dashboard-create-board-button']");

        waitForAllElementVisible(driver,"//div[contains(@data-testid,'column-default-')]");
        takeSnapShotWithHighlight(driver, "//div[contains(@data-testid,'column-default-')][2]//h3",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\09_YD8.png");
    }

    @Test
    public void TC_008_String_010() {
//        Mock ID: YD9
//        Core string: Column 1
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/
//        1. Login to Workfront
//        2. Go to Main Menu -> Boards
//        3. Create a new basic board

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/boards/");

        //Click to Create new
        waitForElementVisible(driver,"//button[@data-testid='dashboard-create-board-button']");
        clickToElement(driver,"//button[@data-testid='dashboard-create-board-button']");

        waitForAllElementVisible(driver,"//div[contains(@data-testid,'column-default-')]");
        takeSnapShotWithHighlight(driver, "//div[contains(@data-testid,'column-default-')][1]//h3",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\09_YD8.png");
    }

    @Test
    public void TC_009_String_011() {
//        Mock ID: YDa
//        Core string: You can add only users from the group associated with the {__mlm_low_project}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/people
//        1. Login to Workfront
//        2. Open any project and go to People tab
//        3. Click on 'Add users' button

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/project/6334011500087bbea6d4d761bee954f9/people");

        waitForElementVisible(driver,"//button[@data-testid='add-to-project']");
        clickToElement(driver,"//button[@data-testid='add-to-project']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//section[@data-testid='confirm-dialog-dialog-body']/div[2]/div[2]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\011_YDa.png");
    }

    @Test
    public void TC_010_String_012() {
//        Mock ID: YDe
//        Core string: MM DD, YYYY
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/layout-template/create
//        1. Login to Workfront
//        2. Go to Main Menu -> Setup -> Interface -> Layout Templates
//        3. Create a new template

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/setup/layout-template/create");

        waitForElementVisible(driver,"//div[@data-testid='plannedCompletionDate']//div[@data-testid='field-content']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='plannedCompletionDate']//div[@data-testid='field-content']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\012_YDe.png");
    }

    @Test
    public void TC_011_String_013() {
//        Mock ID: YDf
//        Core string: {date} ( {count, plural, =0 {No days left} one {# day left} other {# days left}} )
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/setup/licenses
//        1. Login to Workfront
//        2. Go to Setup -> System -> Licenses

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/setup/licenses");

        waitForElementVisible(driver,"//div[@data-testid='setup-header-container']/div/div[3]/div/div[3]/div[2]");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='setup-header-container']/div/div[3]/div/div[3]/div[2]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\013_YDf.png");
    }

    @Test
    public void TC_012_String_014() {
//        Mock ID: YDm
//        Core string: Reopen {__mlm_low_goal}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/5d7e2481-4c0d-4add-9fae-2d274c36201d/overview
//         1. Login to Workfront
//         2. Go to Goals and create a new goal
//         3. Go to Progress Indicators and add a new Result
//         4. Click on three dots button -> Activate
//         5. Click on three dots again -> Close
//         6. Click on three dots again -> Reopen

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goal/5d7e2481-4c0d-4add-9fae-2d274c36201d/overview");

        waitForElementVisible(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='reopen']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//h1[@data-testid='confirm-dialog-dialog-header-text']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\014_YDm.png");
    }

    @Test
    public void TC_013_String_015() {
//        Mock ID: YDn
//        Core string: The {__mlm_low_goal}'s progress (On Target, At Risk or In Trouble) will be recalculated as of today and the progress color indicator might change.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/5d7e2481-4c0d-4add-9fae-2d274c36201d/overview
//         1. Login to Workfront
//         2. Go to Goals and create a new goal
//         3. Go to Progress Indicators and add a new Result
//         4. Click on three dots button -> Activate
//         5. Click on three dots again -> Close
//         6. Click on three dots again -> Reopen

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goal/5d7e2481-4c0d-4add-9fae-2d274c36201d/overview");

        waitForElementVisible(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='reopen']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//section[@data-testid='confirm-dialog-dialog-body']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\015_YDn.png");
    }

    @Test
    public void TC_014_String_016() {
//        Mock ID: YDo
//        Core string: Reopened {__mlm_low_goals} are active.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//         Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/5d7e2481-4c0d-4add-9fae-2d274c36201d/overview
//         1. Login to Workfront
//         2. Go to Goals and create a new goal
//         3. Go to Progress Indicators and add a new Result
//         4. Click on three dots button -> Activate
//         5. Click on three dots again -> Close
//         6. Click on three dots again -> Reopen

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goal/5d7e2481-4c0d-4add-9fae-2d274c36201d/overview");

        waitForElementVisible(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='reopen']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//section[@data-testid='confirm-dialog-dialog-body']/div",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\016_YDo.png");
    }

    @Test
    public void TC_015_String_017() {
//        Mock ID: YDR
//        Core string: Copy {__mlm_low_goal}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//          Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/5d7e2481-4c0d-4add-9fae-2d274c36201d/overview
//          1. Login to Workfront
//          2. Go to Goals and create a new goal
//          3. Click on three dots button -> Copy goal

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goal/5d7e2481-4c0d-4add-9fae-2d274c36201d/overview");

        waitForElementVisible(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        clickToElement(driver,"//li[@data-testid='copy']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='name-editor-element']/div",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\017_YDo.png");
    }

    @Test
    public void TC_016_String_018() {
//        Mock ID: YDS
//        Core string: {__mlm_up_goal} details
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/5d7e2481-4c0d-4add-9fae-2d274c36201d/overview
//        1. Login to Workfront
//        2. Go to Goals and create a new goal

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goal/5d7e2481-4c0d-4add-9fae-2d274c36201d/overview");

        waitForElementVisible(driver,"//a[contains(@href,'/overview')]");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//a[contains(@href,'/overview')]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\018_YDS.png");
    }

    @Test
    public void TC_017_String_019() {
//        Mock ID: YDT
//        Core string: Reopen
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/5d7e2481-4c0d-4add-9fae-2d274c36201d/overview
//        1. Login to Workfront
//        2. Go to Goals and create a new goal

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goal/5d7e2481-4c0d-4add-9fae-2d274c36201d/overview");

        waitForElementVisible(driver,"//a[contains(@href,'/progress-indicators')]");
        clickToElement(driver,"//a[contains(@href,'/progress-indicators')]");
        sleepInSecond(1);
        waitForElementVisible(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        sleepInSecond(1);
        waitForElementVisible(driver,"//li[@data-testid='reopen']");
        takeSnapShotWithHighlight(driver, "//li[@data-testid='reopen']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\019_YDT.png");
    }

    @Test
    public void TC_018_String_020() {
//        Mock ID: YDU
//        Core string: Activate
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/0191dad6-b7aa-43bb-80ff-e32a91691d64/progress-indicators
//        1. Login to Workfront
//        2. Go to Goals and create a new goal

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goal/0191dad6-b7aa-43bb-80ff-e32a91691d64/progress-indicators");

        waitForElementVisible(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");

        if (!(isElementDisplayed(driver,"//li[@data-testid='activate']"))) {
            clickToElement(driver,"//li[@data-testid='deactivate']");
            sleepInSecond(1);
            clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        }

        waitForElementVisible(driver,"//li[@data-testid='activate']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//li[@data-testid='activate']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\020_YDU.png");
    }

    @Test
    public void TC_019_String_021() {
//        Mock ID: YDV
//        Core string: Progress indicators
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/5d7e2481-4c0d-4add-9fae-2d274c36201d/overview
//        1. Login to Workfront
//        2. Go to Goals and create a new goal

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goal/5d7e2481-4c0d-4add-9fae-2d274c36201d/overview");

        waitForElementVisible(driver,"//a[contains(@href,'/progress-indicators')]");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//a[contains(@href,'/progress-indicators')]",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\021_YDV.png");
    }

    @Test
    public void TC_020_String_022() {
//        Mock ID: YDX
//        Core string: Close
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/0191dad6-b7aa-43bb-80ff-e32a91691d64/progress-indicators
//        1. Login to Workfront
//        2. Go to Goals and create a new goal
//        3. Go to Progress Indicators and add a new Result
//        4. Click on three dots button -> Activate
//        5. Click on three dots again

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goal/0191dad6-b7aa-43bb-80ff-e32a91691d64/progress-indicators");

        waitForElementVisible(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");

        if (!(isElementDisplayed(driver,"//li[@data-testid='deactivate']"))) {
            clickToElement(driver,"//li[@data-testid='activate']");
            sleepInSecond(1);
            clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        }

        sleepInSecond(1);
        waitForElementVisible(driver,"//li[@data-testid='close']");
        takeSnapShotWithHighlight(driver, "//li[@data-testid='close']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\022_YDX.png");
    }

    @Test
    public void TC_021_String_023() {
//        Mock ID: YDZ
//        Core string: Deactivate
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/0191dad6-b7aa-43bb-80ff-e32a91691d64/progress-indicators
//        1. Login to Workfront
//        2. Go to Goals and create a new goal
//        3. Go to Progress Indicators and add a new Result
//        4. Click on three dots button -> Activate
//        5. Click on three dots again

        driver.get("https://adobeloctesting.devtest.workfront-dev.com/goal/0191dad6-b7aa-43bb-80ff-e32a91691d64/progress-indicators");

        waitForElementVisible(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");

        if (!(isElementDisplayed(driver,"//li[@data-testid='deactivate']"))) {
            clickToElement(driver,"//li[@data-testid='activate']");
            sleepInSecond(1);
            clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        }

        clickToElement(driver,"//a[contains(@href,'/progress-indicators')]");
        sleepInSecond(1);
        waitForElementVisible(driver,"//button[@data-testid='picklist-button-label']");
        clickToElement(driver,"//button[@data-testid='picklist-button-label']");
        waitForElementVisible(driver,"//li[@data-testid='close']");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver, "//li[@data-testid='deactivate']",
                GlobalConstants.SCREENSHOTS + "\\Workfront_20220919T101004Z\\PTB\\023_YDZ.png");
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

}
