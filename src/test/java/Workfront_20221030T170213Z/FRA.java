package Workfront_20221030T170213Z;

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
import java.util.concurrent.TimeUnit;

public class FRA extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20221030T170213Z\\FRA\\3526563\\FRA\\"; // the path to store the captured images with  lang code can be changed accordingly
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
//        MockID: YQ3	Filters - More options
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/projects/all
//        1. Login to Workfront 2. Go to Projects and click on Filters button 3. Click on three-dot button
//        4. Right click -> Inspect and search the following selector: [data-testid="filters-options-dropdown-options"] 5. Look at the string at the lower level (currently this function is broken and only appears like this)

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/projects/all");
        waitForPageToLoadCompletely(driver,30);

        // 2. Go to Projects and click on Filters button
        clickToElement(driver, "//button[@data-testid='open-filter-selection-panel']");
        sleepInSecond(1);
        // 3. Click on three-dot button
        inspectElement(driver,"//button[contains(@data-testid,'options-dropdown-trigger-button')]");
        sleepInSecond(1);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_LEFT);        rb.keyRelease(KeyEvent.VK_LEFT);
        rb.keyPress(KeyEvent.VK_LEFT);        rb.keyRelease(KeyEvent.VK_LEFT);
        rb.keyPress(KeyEvent.VK_UP);        rb.keyRelease(KeyEvent.VK_UP);

        // Take SS: YQy	Custom Data
        takeSnapShot(driver,GlobalConstants.SCREENSHOTS+folder+"001_YQ3.png");
        sleepInSecond(1);
        captureScreen(GlobalConstants.SCREENSHOTS+folder+"001_YQ3.png");
    }

    @Test
    public void String_002() throws Exception {
//        MockID: YIx	Go back to Legacy Filters
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/projects/all
//        1. Login to Workfront 2. Go to Projects and click on Filters button 3. Click on three-dot button
//        4. Right click -> Inspect and search the following selector: [data-testid="filters-options-dropdown-options"] 5. Look at the string at the lower level (currently this function is broken and only appears like this)

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/projects/all");
        waitForPageToLoadCompletely(driver,30);

        // 2. Go to Projects and click on Filters button
        clickToElement(driver, "//button[@data-testid='open-filter-selection-panel']");
        sleepInSecond(1);
        // 3. Click on three-dot button
        clickToElement(driver,"//button[contains(@data-testid,'options-dropdown-trigger-button')]");
        clickToElement(driver,"//li[@data-testid='panel-option-disableLegacy']");
        sleepInSecond(1);
        waitForElementVisible(driver,"//button[@data-testid='add-new-button']");
        clickToElement(driver,"//button[contains(@data-testid,'options-dropdown-trigger-button')]");

        // Take SS: YIx	Go back to Legacy Filters
        takeSnapShotWithHighlight(driver,"//div[@data-testid='filters-options-dropdown-options']",GlobalConstants.SCREENSHOTS+folder+"002_YIx.png");
        clickToElement(driver,"//li[@data-testid='panel-option-enableLegacy']");
    }

    @Test
    public void String_003() throws Exception {
//        MockID: YQn	{author} made {owner} the owner
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/961e6f96-3907-4168-b081-983320082cbe/updates
//        1. Login to Workfront 2. Go to Goals and create a new goal 3. In the toolbar change the Goal Owner 4. Go to Updates -> System Activity

        // NOTE: Go to https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
        // New Home > Add widget To-do

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/goal/ebfbe5a0-ba19-4f7c-ab41-9fd86b127f9b/updates");
        waitForPageToLoadCompletely(driver,30);

        clickToElement(driver, "//div[@class='header-item ']");
        sleepInSecond(1);

        // Take SS: YQn	{author} made {owner} the owner
        takeSnapShotWithHighlight(driver,"(//div[contains(@style,'color: var(--spectrum-gray-600);')])[1]", GlobalConstants.SCREENSHOTS+folder+"003_YQn.png");
    }

    @Test
    public void String_004_010() throws Exception {
//        MockID: YRa	Clear date
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
//        1. Login to Workfront 2. Open home page and click on "Try out the new home" 3. Click Manage Widgets -> Add Widgets and add a "to-do widget" 4. Mouse hover any to-do

        // NOTE: Go to https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
        // New Home > Add widget To-do

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        waitForPageToLoadCompletely(driver,30);

        waitForElementVisible(driver, "(//div[contains(@id,'todo-')])[1]");
        hoverToElement(driver, "(//div[contains(@id,'todo-')])[1]");
        sleepInSecond(1);

        // Take SS: YRa	Clear date
        takeSnapShotWithHighlight(driver,"//button[contains(@class,'!hidden !py-[3px] !ml-1 group-focus-within:!inline-block group-hover')]",
                GlobalConstants.SCREENSHOTS+folder+"004_YRa.png");

        // Take SS: YRF	All
        clickToElement(driver,"//button[@aria-haspopup='listbox']");
        takeSnapShotWithHighlight(driver,"//div[contains(@class,'spectrum-Menu-item') and @aria-posinset='1']", GlobalConstants.SCREENSHOTS+folder+"005_YRF.png");

        // Take SS: YRG	Incomplete
        takeSnapShotWithHighlight(driver,"//div[contains(@class,'spectrum-Menu-item') and @aria-posinset='2']", GlobalConstants.SCREENSHOTS+folder+"006_YRG.png");

        // Take SS: YRR	Complete
        takeSnapShotWithHighlight(driver,"//div[contains(@class,'spectrum-Menu-item') and @aria-posinset='3']", GlobalConstants.SCREENSHOTS+folder+"007_YRR.png");

        // Take SS: YRK	To-dos filter
        inspectElement(driver,"//button[@aria-haspopup='listbox']");
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_UP);        rb.keyRelease(KeyEvent.VK_UP);
        rb.keyPress(KeyEvent.VK_UP);        rb.keyRelease(KeyEvent.VK_UP);
        captureScreen(GlobalConstants.SCREENSHOTS+folder+"008_YRK.png");

        // Take SS: YRL	To-do name
        inspectElement(driver,"(//div[contains(@class,'spectrum-Field--positionTop')]/div/textarea)[1]");
        captureScreen(GlobalConstants.SCREENSHOTS+folder+"009_YRL.png");

        // Take SS: YRO	Is complete?
        inspectElement(driver,"(//input[@type='checkbox'])[1]");
        captureScreen(GlobalConstants.SCREENSHOTS+folder+"010_YRO.png");

        // Take SS: YRH	Planned completion date
        inspectElement(driver,"(//div[@class='text-gray-700 inline-block bg-white border-gray-700 px-2 py-[2px] border border-solid rounded'])[1]");
        captureScreen(GlobalConstants.SCREENSHOTS+folder+"011_YRH.png");

        // YRP	Edit to-do name // This string is blocked as it is not available in the DOM anymore

    }

    @Test
    public void String_013() throws Exception {
//        MockID: YRb	Untitled Column
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/6399b680dbb855d88100edae
//        1. Login to Workfront 2. Go to Boards and open/create any board 3. Click on "Add Column" button

        // NOTE: Go to https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
        // New Home > Add widget To-do

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/6399b680dbb855d88100edae");
        waitForPageToLoadCompletely(driver,30);

        waitForElementVisible(driver, "(//h3)[4]");
        sleepInSecond(1);

        // Take SS: YRb	Untitled Column
        takeSnapShotWithHighlight(driver,"(//h3)[4]",GlobalConstants.SCREENSHOTS+folder+"013_YRb.png");
    }

    @Test
    public void String_014_015() throws Exception {
//        MockID: YRI	There was a problem creating your to-do, please try again soon.
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/worklist
//        1. Login to Workfront 2. Open up the browser JavaScript console 3. In the JavaScript console, type: localStorage.setItem('devtools', true)
//        4. Refresh the page 5. You should now see a floating icon that when clicked will open the Workfront Inspector 6. Enable feature toggles: home-workspaces
//        7.a. Go to Setup > Login As and logina as "a gavrilov" 7.b. Open home page and click on "Try out the new home" 8. Click "Go back to current home"
//        9. Click on "Add widget" and add "Todos" widget 10. Try adding new todo

        // NOTE: Go to https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
        // New Home > Add widget To-do

        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/setup/log-in-as");
        waitForPageToLoadCompletely(driver,60);
        waitForElementVisible(driver,"//div[@data-testid='setup-header-container']//h2");
        sleepInSecond(1);

        // Login as other user > Select
        sendKeyToElement(driver,"//input[@data-testid='phoenix-input-select-0']", "a gavrilov");
        sleepInSecond(1);
        clickToElement(driver,"//div[@data-testid='option-content-wrapper']");
        clickToElement(driver,"//button[@data-variant='accent']");

        //open New Home Workspace
        waitForElementVisible(driver,"//h2[@data-testid='logged-in-as']");
        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        waitForPageToLoadCompletely(driver,60);

        // Take SS: YRI	There was a problem creating your to-do, please try again soon.
        takeSnapShotWithHighlight(driver,"//div[contains(@class,'flex gap-2 flex-col items-center')]/span", GlobalConstants.SCREENSHOTS+folder+"014_YRI.png");

        // Take SS: YRJ	Add to-do
        takeSnapShotWithHighlight(driver,"//button[@class='flex gap-2 items-center']", GlobalConstants.SCREENSHOTS+folder+"015_YRJ.png");

        // Take SS: YRI	There was a problem creating your to-do, please try again soon.
        clickToElement(driver,"//button[@class='flex gap-2 items-center']");
        sendKeyToElement(driver,"//textarea[contains(@class,'spectrum-Textfield-input')]","aaaaa");
        clickToElement(driver,"//button[@class='flex gap-2 items-center']");
//        waitForElementVisible(driver,"//div[@id='snackbar-root']/div");
        takeSnapShotWithHighlight(driver,"//div[@id='snackbar-root']/div/div", GlobalConstants.SCREENSHOTS+folder+"016_YRI.png");

        // Log out the User
        clickToElement(driver,"//h2[@data-testid='logged-in-as']/button");
        sleepInSecond(1);
    }

    @Test
    public void String_017_018() throws Exception {
//        MockID:
//        YRT	{author} converted the {__mlm_low_activity} {title} to {__mlm_low_goal} {goalName}
//        YRS	{author} converted the {__mlm_low_result} {title} to {__mlm_low_goal} {goalName}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/goal/ebfbe5a0-ba19-4f7c-ab41-9fd86b127f9b/updates
//        1. Login to Workfront 2. Go to Goals and create a new goal 3. Go to Progress Indicators tab and add a new activity
//        4. Select created activity and press "Convert to goal" button 5. Go to Updates -> System Activity

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/goal/e2fabe6f-a052-42a2-a453-8e729827adad/updates");
        waitForPageToLoadCompletely(driver,30);

        clickToElement(driver, "//div[@class='header-item ']");
        sleepInSecond(1);

        // Take SS: YRS	{author} converted the {__mlm_low_result} {title} to {__mlm_low_goal} {goalName}
        takeSnapShotWithHighlight(driver,"(//div[contains(@style,'color: var(--spectrum-gray-600);')])[1]", GlobalConstants.SCREENSHOTS+folder+"0017_YRS.png");

        // Take SS: YRT	{author} converted the {__mlm_low_activity} {title} to {__mlm_low_goal} {goalName}
        takeSnapShotWithHighlight(driver,"(//div[contains(@style,'color: var(--spectrum-gray-600);')])[3]", GlobalConstants.SCREENSHOTS+folder+"018_YRT.png");
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

}
