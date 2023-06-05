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

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FRA extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20230319T094158Z\\FRA\\3937803\\FRA\\"; // the path to store the captured images with  lang code can be changed accordingly
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

        if(isElementDisplayed(driver,"//button[@data-testid='toast-close-btn']")){
            clickToElement(driver,"//button[@data-testid='toast-close-btn']");
        }

        waitForElementVisible(driver,"//button[@data-testid='button-label']");
        clickToElement(driver,"//button[@data-testid='button-label']");

        waitForElementVisible(driver,"//ul[@data-testid='options-container']/li[1]");
        String option1 = "//ul[@data-testid='options-container']/li[1]";
        String option2 = "//ul[@data-testid='options-container']/li[2]";

// Using for loop, it tries for 3 times.
// If the element is located for the first time then it breaks from the for loop nad comeout of the loop
        for(int i=0; i<=2;i++){
            try{
                takeSnapShotWithHighlight(driver,option1, GlobalConstants.SCREENSHOTS+folder+"01_Ygu.png");
                takeSnapShotWithHighlight(driver,option2, GlobalConstants.SCREENSHOTS+folder+"02_Ygu.png");
                break;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

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
//        YgL	Refresh
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

        if(isElementDisplayed(driver,"//button[@data-testid='toast-close-btn']")){
            clickToElement(driver,"//button[@data-testid='toast-close-btn']");
        }

        takeSnapShotWithHighlight(driver,"//div[@data-testid='notification-container']", GlobalConstants.SCREENSHOTS+folder+"09_Yfw.png");
        takeSnapShotWithHighlight(driver,"//button[@data-testid='action-button']", GlobalConstants.SCREENSHOTS+folder+"10_YgL.png");
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
    @Test
    public void String_12() throws Exception {
//        MockID: YgR	Months
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64526c0a4d5844a5f12fbb64
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Boards''
//        3. Click on a ''Add workstream''
//        4. Click on ''Configure'' button > ''Iterations''
//        5. Click on the second dropdown"

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64526c0a4d5844a5f12fbb64");
        waitForPageToLoadCompletely(driver,60);

        if(isElementDisplayed(driver,"//button[@data-testid='toast-close-btn']")){
            clickToElement(driver,"//button[@data-testid='toast-close-btn']");
        }
        clickToElement(driver,"//div[contains(@class,'spectrum-TabsPanel-collapseWrapper')]/following-sibling::div/button");
        waitForElementVisible(driver,"(//div[contains(@class,'styles-module_sectionHeader')])[4]");
        clickToElement(driver,"(//div[contains(@class,'styles-module_sectionHeader')])[4]");

        waitForElementVisible(driver,"(//button[@aria-haspopup='listbox'])[3]");
        clickToElement(driver,"(//button[@aria-haspopup='listbox'])[3]");
        takeSnapShotWithHighlight(driver,"(//div[contains(@class,'spectrum-Menu-item')])[5]", GlobalConstants.SCREENSHOTS+folder+"12_YgR.png");
    }
    @Test
    public void String_13() throws Exception {
//        MockID: Ygh	+ Add
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/8669757a-4ba1-41ca-ba10-0cdd74effa7c/untitled_operational_record_type-142/4f6bb546-d044-407b-82a5-2e3d1b022f51/record
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Maestro''
//        3. Click on an ''+ Add record type'' or open any existing record type
//        4. Click on a ''+ New record'' > double click on an empty ''Name'' cell > click on a ''Open record details page'' icon in the name cell"

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/8669757a-4ba1-41ca-ba10-0cdd74effa7c/untitled_operational_record_type-142/4f6bb546-d044-407b-82a5-2e3d1b022f51/record");
        waitForPageToLoadCompletely(driver,60);
        if(isElementDisplayed(driver,"//button[@data-testid='toast-close-btn']")){
            clickToElement(driver,"//button[@data-testid='toast-close-btn']");
        }
        waitForElementVisible(driver,"//button[@data-testid='add-value']");
        takeSnapShotWithHighlight(driver,"//button[@data-testid='add-value']", GlobalConstants.SCREENSHOTS+folder+"13_Ygh.png");
    }
    @Test
    public void String_14() throws Exception {
//        MockID: Ygi	No value
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/5eda75b1-8767-4f61-aba7-f4a27d355d7d
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Maestro''
//        3. Click on an ''+ Add record type'' or open any existing record type
//        4. Click on a ''+'' button in a header of the table and for ''Field Type'' select ''Relationship'' > enter label and for ''Find a record type'' select record and column with no value (e.g. ''Name'')
//        5. Click on a ''+ New record'' > double click on an empty ''Name'' cell > click on a ''Open record details page'' icon in the name cell"


        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/8669757a-4ba1-41ca-ba10-0cdd74effa7c/untitled_operational_record_type-145/15358519-2e5e-4b59-9760-203f05c81a41/record");
        waitForPageToLoadCompletely(driver,60);
        if(isElementDisplayed(driver,"//button[@data-testid='toast-close-btn']")){
            clickToElement(driver,"//button[@data-testid='toast-close-btn']");
        }
        waitForElementVisible(driver,"//button[@data-testid='add-value']");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='view-field-tooltip-wrapper']//span", GlobalConstants.SCREENSHOTS+folder+"14_Ygi.png");
    }
    @Test
    public void String_15() throws Exception {
//        MockID: Yge	Save changes
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/5eda75b1-8767-4f61-aba7-f4a27d355d7d
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Maestro''
//        3. Click on an ''+ Add record type'' or open any existing record type
//        4. Click on a ''+ New record'' > double click on an empty ''Name'' cell > click on a ''Open record details page'' icon in the name cell
//        5. Click on ''+ Add''

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/8669757a-4ba1-41ca-ba10-0cdd74effa7c/untitled_operational_record_type-142/4f6bb546-d044-407b-82a5-2e3d1b022f51/record");
        waitForPageToLoadCompletely(driver,60);
        if(isElementDisplayed(driver,"//button[@data-testid='toast-close-btn']")){
            clickToElement(driver,"//button[@data-testid='toast-close-btn']");
        }
        waitForElementVisible(driver,"//button[@data-testid='add-value']");
        clickToElement(driver,"//button[@data-testid='add-value']");
        takeSnapShotWithHighlight(driver,"//div[contains(@class,'spectrum-ButtonGroup')]/button[2]", GlobalConstants.SCREENSHOTS+folder+"15_Yge.png");
    }

    @Test
    public void String_16() throws Exception {
//        MockID: Yfr	Unable to save your changes. Ref...
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/5eda75b1-8767-4f61-aba7-f4a27d355d7d
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Maestro''
//        3. Click on an ''+ Add record type'' or open any existing record type
//        4. Duplicate browser tab
//        5. On the first tab click on a three dots ''...'' button near the Record Type name and click ''Delete''
//        6. On the second tab click on a ''+ New record'' button"


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
        if(isElementDisplayed(driver,"//button[@data-testid='toast-close-btn']")){
            clickToElement(driver,"//button[@data-testid='toast-close-btn']");
        }
        clickToElement(driver,"//button[contains(@data-omega-element,'maestro-table-add-record-button')]");
        sleepInSecond(1);
        clickToElement(driver,"//button[contains(@data-omega-element,'maestro-table-add-record-button')]");
        waitForElementVisible(driver,"//div[contains(@data-testid,'notification-container')]");

// Using for loop, it tries for 3 times.
// If the element is located for the first time then it breaks from the for loop nad comeout of the loop
        for(int i=0; i<=2;i++){
            try{
                takeSnapShotWithHighlight(driver,"//div[contains(@data-testid,'notification-container')]", GlobalConstants.SCREENSHOTS+folder+"16_Yfr.png");
                break;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    @Test
    public void String_17() throws Exception {
//        MockID: Yf3	Cards are created and sorted usi...
//        "Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//        1. Login to Workfront
//        2. Go to Main Menu > ''Boards''
//        3. Click on an ''Add Board'' button"

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards");
        waitForPageToLoadCompletely(driver,60);
        sleepInSecond(60);
        if(isElementDisplayed(driver,"//button[@data-testid='toast-close-btn']")){
            clickToElement(driver,"//button[@data-testid='toast-close-btn']");
        }
        waitForElementVisible(driver,"//button[@data-testid='dashboard-create-board-button']");
        clickToElement(driver,"//button[@data-testid='dashboard-create-board-button']");
        takeSnapShotWithHighlight(driver,"//button[@data-testid='dynamic-board-creation-button']//span", GlobalConstants.SCREENSHOTS+folder+"17_Yf3.png");
    }
    @Test
    public void String_18_23() throws Exception {
//        MockID: YgS	Bar style
//                YgT	Choose up to {0} fields to show ...
//                YgW	Restore all fields to default
//                Ygd	Add field
//                Ygj	Record details
//                YgU	Search fields

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/8669757a-4ba1-41ca-ba10-0cdd74effa7c
//
//        1. Login to Workfront
//        2. Go to Main Menu > ''Maestro''
//        3. Click on an ''+ Add record type''
//        4. Click on a ''Default View'' dropdown > click ''+ Create view'' > select ''Timeline'' > enter view name > click ''Save''
//        5. Click on a ''Default View'' dropdown > select newly created view
//        6. Click on a ''Settings''
//        7. Select ''Record details''

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/8669757a-4ba1-41ca-ba10-0cdd74effa7c/eae2b316-38db-4411-bac9-ffbecdecad83/872adf24-ea3f-493f-8f07-0ff54618ad6e/view");
        waitForPageToLoadCompletely(driver,60);
        if(isElementDisplayed(driver,"//button[@data-testid='toast-close-btn']")){
            clickToElement(driver,"//button[@data-testid='toast-close-btn']");
        }
        waitForElementVisible(driver,"//div[@id='toolbar-portal-middle-slot']//button");
        clickToElement(driver,"//div[@id='toolbar-portal-middle-slot']//button");
        sleepInSecond(1);
        waitForElementVisible(driver,"//div[@data-testid='timeline-settings-record-details-link']");
        clickToElement(driver,"//div[@data-testid='timeline-settings-record-details-link']");
        sleepInSecond(1);

        takeSnapShotWithHighlight(driver,"//div[@data-testid='record-details-tab']/h3", GlobalConstants.SCREENSHOTS+folder+"18_YgS.png");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='record-details-tab']//h5", GlobalConstants.SCREENSHOTS+folder+"19_YgT.png");
        takeSnapShotWithHighlight(driver,"//button[@data-testid='record-details-tab--reset-card-fields-button']", GlobalConstants.SCREENSHOTS+folder+"20_YgW.png");
        takeSnapShotWithHighlight(driver,"//button[@data-testid='record-details-tab--add-field-button']", GlobalConstants.SCREENSHOTS+folder+"21_Ygd.png");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='timeline-settings-record-details-link']", GlobalConstants.SCREENSHOTS+folder+"22_Ygj.png");

        clickToElement(driver,"//button[@data-testid='record-details-tab--add-field-button']");
        takeSnapShotWithHighlight(driver,"//button[contains(@data-testid,'record-details-tab--fields-picker')]", GlobalConstants.SCREENSHOTS+folder+"23_YgU.png");

    }
    @Test
    public void String_24_25() throws Exception {
//        MockID: Ygk	Assigned to {0}
//              Ygl	Search team members
//        "Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
//
//        1. Login to Workfront new home
//        2. In the team reques widget click on any ""Assign"" button
//        3. Enter ""Admin User"" and press Enter
//
//        note: if you don't have available tasks - create a new task in some project and assign it to ""team DEU"""

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        waitForPageToLoadCompletely(driver,60);
        if(isElementDisplayed(driver,"//button[@data-testid='toast-close-btn']")){
            clickToElement(driver,"//button[@data-testid='toast-close-btn']");
        }
        waitForElementVisible(driver,"//button[@data-omega-element='team-requests-assignment-open']");

        clickToElement(driver,"//button[@data-omega-element='team-requests-assignment-open']");
        takeSnapShotWithHighlight(driver,"//input[contains(@data-testid,'phoenix-input-')]", GlobalConstants.SCREENSHOTS+folder+"24_Ygl.png");
        sendKeyToElement(driver,"//input[contains(@data-testid,'phoenix-input-')]","admin");
        clickToElement(driver,"//div[@data-testid='option-content-wrapper']");

        takeSnapShotWithHighlight(driver,"//div[contains(@class,'spectrum-Toast-body')]", GlobalConstants.SCREENSHOTS+folder+"25_Ygk.png");

    }
    @Test
    public void String_26() throws Exception {
//        MockID:
//              YgA	Customize
//              YgK	My {filter}
//              YgC	Day
//              YgB	Month
//              YgF	Week
//              YgH	Quarter - Removed
//              YgN	{0} Tasks complete
//              YgP	{0} {__mlm_up_tasks} due

//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
//
//        1. Login to Workfront new home
//        2. Click on ""My {filter}"" button"

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        waitForPageToLoadCompletely(driver,60);
        if(isElementDisplayed(driver,"//button[@data-testid='toast-close-btn']")){
            clickToElement(driver,"//button[@data-testid='toast-close-btn']");
        }
        waitForElementVisible(driver,"//button[@data-omega-element='new-home-banner-filter-button']");
        takeSnapShotWithHighlight(driver,"//button[@data-omega-element='customize']", GlobalConstants.SCREENSHOTS+folder+"26_YgA.png");
        takeSnapShotWithHighlight(driver,"//button[@data-omega-element='new-home-banner-filter-button']", GlobalConstants.SCREENSHOTS+folder+"27_YgK.png");
        takeSnapShotWithHighlight(driver,"//div[@data-omega-element='tasks-due']", GlobalConstants.SCREENSHOTS+folder+"31_YgP.png");
        takeSnapShotWithHighlight(driver,"//div[contains(@data-omega-element,'tasks-complete')]", GlobalConstants.SCREENSHOTS+folder+"32_YgN.png");

        clickToElement(driver,"//button[@data-omega-element='new-home-banner-filter-button']");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='popover']", GlobalConstants.SCREENSHOTS+folder+"28_29_30_YgC_YgB_YgF.png");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}