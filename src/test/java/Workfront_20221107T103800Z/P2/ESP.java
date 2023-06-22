package Workfront_20221107T103800Z.P2;

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

public class ESP extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20221107T103800Z\\ESP\\3548149\\ESP"; // the path to store the captured images with  lang code can be changed accordingly
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
        options.addArguments("--lang=es"); //set browser language
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
    public void String_01_02() throws Exception {
//        MockID: YRc	After someone interacts with this object, that activity will be listed here
//                YRd	No activity yet
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome Test User: alp02c@alp.ee / Alp123
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/task/647e47020001092191145c49b6b476fd/updates
//        1. Go to Projects and open some Project 2. Go to Tasks tab and create+open a new task 3. Go to Updates tab

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/task/647e47020001092191145c49b6b476fd/updates");
        waitForPageToLoadCompletely(driver,30);
        clickToElement(driver,"//div[@class='tabs-header']/div[2]");

        // Take SS: YQy	Custom Data
        takeSnapShotWithHighlight(driver,"//div[contains(@class,'IllustratedMessage')][1]//h3", GlobalConstants.SCREENSHOTS+folder+"01_YRd.png");
        takeSnapShotWithHighlight(driver,"//div[contains(@class,'IllustratedMessage')][1]//section", GlobalConstants.SCREENSHOTS+folder+"02_YRc.png");
    }
    @Test
    public void String_03_05() throws Exception {
//        MockID: YRm	Removing {0} from this board will also remove them from all {1} connected cards and unassign them from the associated tasks/issues. Do you want to continue?
//                YRj	Remove user from board
//                YRi	Remove user
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome Test User: alp02c@alp.ee / Alp123
//        Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/64770d2516ae66fe25173283
//        1. Go to Boards and create a new board 2. In the toolbar add some user as a member of the board 3. Create a new simple card and assign it to the new member
//        4. Add some connected card and assign it to the new member 5. In the members panel try removing added member

        //Log out Admin user
        clickToElement(driver,"//button[@data-testid='global-nav-drawer-toggle']");
        clickToElement(driver,"//a[contains(@href,'/logout')]");

        //Log in with Test User: alp02c@alp.ee / Alp123
        sendKeyToElement(driver, "//input[@id='username']", "alp02c@alp.ee");
        sendKeyToElement(driver, "//input[@id='password']", "Alp123");
        clickToElement(driver, "//button[@type='submit']");
        waitForElementVisible(driver, "//div[@id='page-content']");
        sleepInSecond(2);

        //Open direct link to test
        openPageUrl(driver,"https://adobeloctesting.devtest.workfront-dev.com/boards/64770d2516ae66fe25173283");
        clickToElement(driver,"//button[@data-testid='open-add-members-button']");
        clickToElement(driver,"//button[@data-testid='remove-member-button-BuzzLightyear']");

        // Take SS:
        takeSnapShotWithHighlight(driver,"//div[contains(@class,'Dialog-grid')]/h2", GlobalConstants.SCREENSHOTS+folder+"03_YRj.png");
        takeSnapShotWithHighlight(driver,"//div[contains(@class,'Dialog-grid')]/h2/parent::div/section", GlobalConstants.SCREENSHOTS+folder+"04_YRm.png");
        takeSnapShotWithHighlight(driver,"//div[contains(@class,'Dialog-buttonGroup')]/button[2]", GlobalConstants.SCREENSHOTS+folder+"05_YRi.png");
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}
