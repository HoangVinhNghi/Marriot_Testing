package _19_Group_Details_Flow;

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

public class JPN extends AbstractPage {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Set language
        options.addArguments("--lang=ja-JP");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(GlobalConstants.APP_URL);
        sendKeyToElement(driver,"//input[@id='username']", GlobalConstants.ACCOUNT);
        sendKeyToElement(driver,"//input[@id='password']", GlobalConstants.PASSWORD);
        clickToElement(driver,"//button[@type='submit']");

    }



    @Test
    public void TC_01_UI_ReproStep() {
//        1        Open WF
//        URL: https://adobeloctesting.devtest.workfront-dev.com/
//        2        Click on Main Menu -> Setup ->  Groups
        waitForElementVisible(driver, "//img[@data-testid='empty-state-child-img']");
        clickToElement(driver, "//button[@data-testid='global-nav-drawer-toggle']");
        clickToElement(driver, "//a[@data-testid='setup']");
        sleepInSecond(2);
        clickToElement(driver, "//li[@data-content-tile='list-groups']");
        sleepInSecond(10);
        takeSnapShot(driver, GlobalConstants.GROUP_DETAILS_FLOW + "\\JPN\\01_Setup_Groups_Area.png");

//        3        Click on "labudae" group name
        switchToIframeByElement(driver, "//iframe[@id='main-frame']");
        sleepInSecond(2);

        clickToElement(driver, "//a[normalize-space()='labudae']");
        sleepInSecond(10);

//        4        Click on Group Details
        switchToDefaultContent(driver);
        sleepInSecond(3);

        clickToElement(driver, "//div[@data-testid='navitem-list-group-details-forms ']");
        sleepInSecond(4);
        takeSnapShot(driver, GlobalConstants.GROUP_DETAILS_FLOW + "\\JPN\\02_Groups_labudae_Details_Area.png");

//        5        Click on Business Leader field
        clickToElement(driver, "//a[@data-testid='businessLeader-add-button']");
        sleepInSecond(3);
        takeSnapShot(driver, GlobalConstants.GROUP_DETAILS_FLOW + "\\JPN\\03_labudae_Details_Click_Business_Leader.png");

//        6        Click Save Changes
        clickToElement(driver, "//button[@data-testid='save-changes-button']");
        sleepInSecond(3);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='details-page-error-summary']", GlobalConstants.GROUP_DETAILS_FLOW + "\\JPN\\04_labudae_Details_Save_Changes_Error_Message.png");

//        7        Click Cancel
        clickToElement(driver, "//button[@data-testid='cancel-changes-button']");
        sleepInSecond(2);

//        8        Click on Description field
        clickToElement(driver, "(//div[@data-testid='view-component-wrapper'])[1]");
        sleepInSecond(1);
//        9        Press 'a'
        sendKeyToElementWithoutClear(driver, "//textarea[@id='description']", "a");
        sleepInSecond(1);

//        10        Click Save Changes
        clickToElement(driver, "//button[@data-testid='save-changes-button']");
        sleepInSecond(2);
        takeSnapShotWithHighlight(driver, "(//div[contains(@class,'layout-grid')])[1]", GlobalConstants.GROUP_DETAILS_FLOW + "\\JPN\\05_labudae_Details_Save_Changes_Success.png");

//        11        Hover over Collapse All button
        hoverToElement(driver, "//button[@data-testid='collapse-button']");
        sleepInSecond(3);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='tooltip-styled']/div", GlobalConstants.GROUP_DETAILS_FLOW + "\\JPN\\06_labudae_Details_Collapse_All_Tooltip.png");

//        12        Hover over Edit button
        hoverToElement(driver, "//button[@data-testid='edit-sections-trigger-button']");
        sleepInSecond(3);
        takeSnapShotWithHighlight(driver, "//div[@data-testid='tooltip-styled']/div", GlobalConstants.GROUP_DETAILS_FLOW + "\\JPN\\07_labudae_Details_Edit_Tooltip.png");

//        13        Click on Edit button
        clickToElement(driver, "//button[@data-testid='edit-sections-trigger-button']");
        sleepInSecond(4);
        takeSnapShotWithHighlight(driver, "(//ul[@id='dropdown-options'])[4]", GlobalConstants.GROUP_DETAILS_FLOW + "\\JPN\\08_labudae_Details_Edit_Dropdown.png");

    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }
}
