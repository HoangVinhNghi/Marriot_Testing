package Workfront_20230319T094158Z;

import common.AbstractPage;
import common.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ENU extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20230319T094158Z\\ENU\\"; // the path to store the captured images with  lang code can be changed accordingly
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

    //board
    @Test
    public void String_01_05() throws Exception {
//        MockID:
//        Ygx	New Board
//        Ygy	Existing Board
//        Ygn	Start using your existing Kanban...
//        Ygv	Clicking Add will add your Kanba...
//        Ygz	Your existing Kanban board will ...
//        Ygu	Add to existing board

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/team/62a874e70003b82a98ad2b11cc300fbe/kanbanboard
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Teams''
//        3. Open team with ''Kanban Board''
//        3. Click on an ''Add to Boards'' > ''Existing Board''

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/team/62a874e70003b82a98ad2b11cc300fbe/kanbanboard");
        waitForPageToLoadCompletely(driver,60);

        clickToElement(driver,"//button[@data-testid='button-label']");
        waitForElementVisible(driver,"//li[@data-testid='option-1']");

        takeSnapShotWithHighlight(driver,"//li[@data-testid='option-0']", GlobalConstants.SCREENSHOTS+folder+"01_Ygu.png");
        takeSnapShotWithHighlight(driver,"//li[@data-testid='option-1']", GlobalConstants.SCREENSHOTS+folder+"02_Ygu.png");

        clickToElement(driver,"//li[@data-testid='option-1']");

        // Take SS:
        waitForElementVisible(driver,"(//section[@data-testid='dialog-dialog-body']//span)[2]");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"//section[@data-testid='dialog-dialog-body']//h2", GlobalConstants.SCREENSHOTS+folder+"03_Ygu.png");
        takeSnapShotWithHighlight(driver,"(//section[@data-testid='dialog-dialog-body']//span)[1]/parent::div", GlobalConstants.SCREENSHOTS+folder+"04_Ygn.png");
        takeSnapShotWithHighlight(driver,"(//section[@data-testid='dialog-dialog-body']//span)[2]/parent::div", GlobalConstants.SCREENSHOTS+folder+"05_Ygz_Ygv.png");
    }
    @Test
    public void String_06_08() throws Exception {
//        MockID:
//        Yg1	Add to new board
//        Ygq	Clicking Add will create a new K...
//        Ygo	Board Name

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/team/62a874e70003b82a98ad2b11cc300fbe/kanbanboard
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Teams''
//        3. Open team with ''Kanban Board''
//        3. Click on an ''Add to Boards'' > ''Existing Board''

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/team/62a874e70003b82a98ad2b11cc300fbe/kanbanboard");
        waitForPageToLoadCompletely(driver,60);

        clickToElement(driver,"//button[@data-testid='button-label']");
        clickToElement(driver,"//li[@data-testid='option-0']");

        // Take SS:
        waitForElementVisible(driver,"(//section[@data-testid='dialog-dialog-body']//span)[2]");
        sleepInSecond(1);
        takeSnapShotWithHighlight(driver,"//section[@data-testid='dialog-dialog-body']//h2", GlobalConstants.SCREENSHOTS+folder+"06_Yg1.png");
        takeSnapShotWithHighlight(driver,"(//section[@data-testid='dialog-dialog-body']//span)[2]/parent::div", GlobalConstants.SCREENSHOTS+folder+"07_Ygq.png");
        takeSnapShotWithHighlight(driver,"//label[@id='kanbanBoardName-label']", GlobalConstants.SCREENSHOTS+folder+"08_Ygo.png");
    }
    @Test
    public void String_09() throws Exception {
//        MockID: Yfw	Unable to display the records. C...
//       Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/5eda75b1-8767-4f61-aba7-f4a27d355d7d
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Maestro''
//        3. Click on an ''+ Add record type'' or open any existing record type
//        4. Duplicate browser tab
//        5. On the first tab click on a three dots ''...'' button near the Record Type name and click ''Delete''
//        6. On the second tab click on ''Filters'' button > ''Add condition''

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/8669757a-4ba1-41ca-ba10-0cdd74effa7c");
        waitForPageToLoadCompletely(driver,60);

        //Create new Record
        clickToElement(driver,"//div[@data-omega-element='add-new-record-type']");
        clickToElement(driver,"//input[@data-testid='blank-card']");
        clickToElement(driver,"//button[@data-testid='create-new-record-type']");
        waitForElementVisible(driver,"//button[@data-omega-element='maestro-filter-button']");

        //Get the new Record URL
        copyStringToClipboard(getPageUrl(driver));
        //Open the newly created Record in new Tab
        openCurrentUrlNewTabByRobot(driver);
        sleepInSecond(3);

        ArrayList<String> tabID = new ArrayList<String> (driver.getWindowHandles());

        //Switch to new Tab > Delete
        switchToWindowByID(driver, tabID.get(1));
        clickToElement(driver,"//button[@data-testid='header-object-selection']/following-sibling::button");
        clickToElement(driver,"(//li[@role='menuitem'])[2]");
        clickToElement(driver,"//div[contains(@class,'Dialog-buttonGroup')]/button[2]");
        sleepInSecond(5);
        closeTabByRobot(driver);

        //Switch to old Tab > Refresh
        switchToWindowByID(driver, tabID.get(0));
        clickToElement(driver,"//button[@data-omega-element='maestro-filter-button']");
        clickToElement(driver,"//div[@role='toolbar']/button");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='notification-container']", GlobalConstants.SCREENSHOTS+folder+"09_Yfw.png");
    }
    @Test
    public void String_10() throws Exception {
//        MockID: Yfu	Unable to create the field colum...
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/5eda75b1-8767-4f61-aba7-f4a27d355d7d
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Maestro''
//        3. Click on an ''+ Add record type'' or open any existing record type
//        4. Duplicate browser tab
//        5. On the first tab click on a three dots ''...'' button near the Record Type name and click ''Delete''
//        6. On the second tab click ''+'' icon near the table headers in right corner > ''New field'' > select ''Field type'' > enter a Label > click ''Create''

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/8669757a-4ba1-41ca-ba10-0cdd74effa7c");
        waitForPageToLoadCompletely(driver,60);

        //Create new Record
        clickToElement(driver,"//div[@data-omega-element='add-new-record-type']");
        clickToElement(driver,"//input[@data-testid='blank-card']");
        clickToElement(driver,"//button[@data-testid='create-new-record-type']");
        waitForElementVisible(driver,"//button[@data-omega-element='maestro-filter-button']");

        //Get the new Record URL
        copyStringToClipboard(getPageUrl(driver));
        //Open the newly created Record in new Tab
        openCurrentUrlNewTabByRobot(driver);
        sleepInSecond(3);

        ArrayList<String> tabID = new ArrayList<String> (driver.getWindowHandles());

        //Switch to new Tab > Delete
        switchToWindowByID(driver, tabID.get(1));
        clickToElement(driver,"//button[@data-testid='header-object-selection']/following-sibling::button");
        clickToElement(driver,"(//li[@role='menuitem'])[2]");
        clickToElement(driver,"//div[contains(@class,'Dialog-buttonGroup')]/button[2]");
        sleepInSecond(5);
        closeTabByRobot(driver);

        //Switch to old Tab > Refresh
        switchToWindowByID(driver, tabID.get(0));
        clickToElement(driver,"//button[@data-omega-element='maestro-table-add-field-button']");
        clickToElement(driver,"(//div[@role='gridcell'])[1]");
        sendKeyToElement(driver,"//input[@name='displayName']","aaa11");
        clickToElement(driver,"//button[@data-testid='create-field-button']");

//        takeSnapShotWithHighlight(driver,"//div[@data-testid='notification-container']", GlobalConstants.SCREENSHOTS+folder+".png");
    }
    @Test
    public void String_11() throws Exception {
//        MockID: Yfy	Unable to delete the field. Try ...
//        "Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/5eda75b1-8767-4f61-aba7-f4a27d355d7d
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Maestro''
//        3. Click on an ''+ Add record type'' or open any existing record type
//        4. Duplicate browser tab
//        5. On the first tab click on a three dots ''...'' button near the Record Type name and click ''Delete''
//        6. On the second tab click on a down arrow near the field name (e.g. ''Status'') > ''Delete''"


        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/8669757a-4ba1-41ca-ba10-0cdd74effa7c");
        waitForPageToLoadCompletely(driver,60);

        //Create new Record
        clickToElement(driver,"//div[@data-omega-element='add-new-record-type']");
        clickToElement(driver,"//input[@data-testid='blank-card']");
        clickToElement(driver,"//button[@data-testid='create-new-record-type']");
        waitForElementVisible(driver,"//button[@data-omega-element='maestro-filter-button']");

        //Get the new Record URL
        copyStringToClipboard(getPageUrl(driver));
        //Open the newly created Record in new Tab
        openCurrentUrlNewTabByRobot(driver);
        sleepInSecond(3);

        ArrayList<String> tabID = new ArrayList<String> (driver.getWindowHandles());

        //Switch to new Tab > Delete
        switchToWindowByID(driver, tabID.get(1));
        waitForElementVisible(driver,"//button[@data-testid='header-object-selection']/following-sibling::button");
        sleepInSecond(2);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_CONTROL);        rb.keyPress(KeyEvent.VK_F3);
        rb.keyRelease(KeyEvent.VK_CONTROL);        rb.keyRelease(KeyEvent.VK_F3);
        sleepInSecond(5);        closeTabByRobot(driver);


        //Switch to old Tab > Refresh
        switchToWindowByID(driver, tabID.get(0));
        waitForElementVisible(driver,"//button[@data-omega-element='maestro-table-add-field-button']");
        rb.keyPress(KeyEvent.VK_CONTROL);        rb.keyPress(KeyEvent.VK_F3);
        rb.keyRelease(KeyEvent.VK_CONTROL);        rb.keyRelease(KeyEvent.VK_F3);

        takeSnapShotWithHighlight(driver,"//div[contains(@class,'spectrum-Toast--negative')]", GlobalConstants.SCREENSHOTS+folder+"11_Yfy.png");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}