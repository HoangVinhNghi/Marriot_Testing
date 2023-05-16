package Workfront_20230305T095955Z;

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
    String folder = "\\Workfront_20230305T095955Z\\ENU\\"; // the path to store the captured images with  lang code can be changed accordingly
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
    public void String_001() throws Exception {
//        Board
//        MockID: YdP	Added to board
//YdO	These preferences only apply to ...
//YdM	Added to card
//YeN1	Preferences
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards
//
//1. Login to Workfront
//2. Go to Main Menu > ''Boards''
//3. Click on a ''Preferences'' button

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/preferences");
        waitForPageToLoadCompletely(driver,60);

        // Take SS: YT+
        waitForElementVisible(driver,"//h2[contains(@class,'spectrum-Dialog-heading')]");
        takeSnapShotWithHighlight(driver,"//h2[contains(@class,'spectrum-Dialog-heading')]", GlobalConstants.SCREENSHOTS+folder+"001_YeN1.png");
        takeSnapShotWithHighlight(driver,"(//span[contains(@class,'spectrum-ToggleSwitch-label')]/child::h4)[1]", GlobalConstants.SCREENSHOTS+folder+"001_YdB.png");
        takeSnapShotWithHighlight(driver,"(//span[contains(@class,'spectrum-ToggleSwitch-label')]/child::h4)[2]", GlobalConstants.SCREENSHOTS+folder+"001_YdM.png");
        takeSnapShotWithHighlight(driver,"(//section[contains(@class,'spectrum-Dialog-content')]//div[contains(@class,'flex')]//span)[1]", GlobalConstants.SCREENSHOTS+folder+"001_Yd0.png");

    }
    @Test
    public void String_002() throws Exception {
//        Board
//        MockID: Yed	MAX
//Yec	MIN
//Yeb	SUM
//        YeX	None
//        YeW	AVG
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//Test User: adobeloctesting@workfront.com / 2wsx#EDC
//Direct link: https://adobeloctesting.devtest.workfront-dev.com/maestro/workspaces/8c48a3d1-7caa-480f-84d9-8ebbccd8db40
//
//1. Login to Workfront
//2. Go to Main Menu > ''Maestro''
//4. Click on a ''+ Add record type''
//5. Click on a ''+'' button and select ''Number'' for ''Field type''
//6. Go back to ''Workspace'' and click on a ''+ Add record type''
//7. Click on a ''+'' button and select ''Relationship'' for ''Field type'' and in ''Find a record type'' select early created Record Type
//8. Select checkbox for numbers and click on a dropdown menu

        // Go to board Preferences
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/maestro/8669757a-4ba1-41ca-ba10-0cdd74effa7c/untitled_operational_record_type-105/f041bd5a-48cd-452e-9b13-f0ddbe0bdb7f/view");
        waitForPageToLoadCompletely(driver,60);

        //Click to +
        waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M29,16H20V7a1,1,0,0,0-1-1H17a1,1,0,0,0-1,1v9H7a1,1')]/ancestor::button");
        clickToElement(driver,"//*[name()='path' and contains(@d,'M29,16H20V7a1,1,0,0,0-1-1H17a1,1,0,0,0-1,1v9H7a1,1')]/ancestor::button");

        //click to dropdown
        waitForElementVisible(driver,"//div[@data-omega-widget='maestro-table-new-field-creation-widget']//button[contains(@class,'spectrum-Dropdown-trigger')]");
        clickToElementByJS(driver,"//div[@data-omega-widget='maestro-table-new-field-creation-widget']//button[contains(@class,'spectrum-Dropdown-trigger')]");
        waitForElementVisible(driver,"//div[@aria-posinset='9']");
        clickToElementByJS(driver,"//div[@aria-posinset='9']");
        sleepInSecond(1);
        //select a record type
        waitForElementVisible(driver,"(//div[@data-omega-widget='maestro-table-new-field-creation-widget']//button[contains(@class,'spectrum-FieldButton')])[2]");
        clickToElementByJS(driver,"(//div[@data-omega-widget='maestro-table-new-field-creation-widget']//button[contains(@class,'spectrum-FieldButton')])[2]");
        waitForElementVisible(driver,"//div[@aria-posinset='3']");
        clickToElementByJS(driver,"//div[@aria-posinset='3']");
        //check box 123
        waitForElementVisible(driver,"(//div[@data-omega-widget='maestro-table-new-field-creation-widget']//input[@type='checkbox'])[7]");
        checkToCheckboxOrRadio(driver,"(//div[@data-omega-widget='maestro-table-new-field-creation-widget']//input[@type='checkbox'])[7]");
        sleepInSecond(1);
        //click to None
        waitForElementVisible(driver,"(//div{@style=\"justify-content: space-between;\"])[6]//button");
        clickToElementByJS(driver,"(//div{@style=\"justify-content: space-between;\"])[6]//button//*[name()='path' and contains(@d,'M8,14.02a2,2,0,0,1,3.411-1.411l6')]/ancestor::button)[7]");
        waitForElementVisible(driver,"//div[@aria-posinset='2']");
        clickToElementByJS(driver,"//div[@aria-posinset='2']");
        // Take SS: YT+
        /*waitForElementVisible(driver,"//h2[contains(@class,'spectrum-Dialog-heading')]");
        takeSnapShotWithHighlight(driver,"//h2[contains(@class,'spectrum-Dialog-heading')]", GlobalConstants.SCREENSHOTS+folder+"001_YeN1.png");
        takeSnapShotWithHighlight(driver,"(//span[contains(@class,'spectrum-ToggleSwitch-label')]/child::h4)[1]", GlobalConstants.SCREENSHOTS+folder+"001_YdB.png");
        takeSnapShotWithHighlight(driver,"(//span[contains(@class,'spectrum-ToggleSwitch-label')]/child::h4)[2]", GlobalConstants.SCREENSHOTS+folder+"001_YdM.png");
        takeSnapShotWithHighlight(driver,"(//section[contains(@class,'spectrum-Dialog-content')]//div[contains(@class,'flex')]//span)[1]", GlobalConstants.SCREENSHOTS+folder+"001_Yd0.png");
*/
    }



    // Need to login with alphawfone+cw@gmail.com/Adobe123#


    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}