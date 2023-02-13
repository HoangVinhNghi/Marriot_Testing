package Workfront_20221114T111033Z;

import common.AbstractPage;
import common.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.*;
import java.util.concurrent.TimeUnit;

import static java.time.Instant.ofEpochMilli;

public class ENU extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20221114T111033Z\\ENU\\"; // the path to store the captured images with  lang code can be changed accordingly
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
//        String instantExpected = "2022-12-22T15:15:30Z";
//        Clock clock = Clock.fixed(Instant.parse(instantExpected), ZoneId.of("UTC"));
//        Instant instant = Instant.now(clock);
//        Runtime.getRuntime().exec("cmd /C time " + "15:21:20"); // hh:mm:ss

        Clock constantClock = Clock.fixed(ofEpochMilli(0), ZoneId.systemDefault());
// go to the future:
        Clock clock = Clock.offset(constantClock, Duration.ofSeconds(10800));

//// rewind back with a negative value:
//        clock = Clock.offset(constantClock, Duration.ofSeconds(-5));
//
//// the 0 duration returns to the same clock:
//        clock = Clock.offset(constantClock, Duration.ZERO);


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
//        System.out.println(instant.toString());
    }

    @Test
    public void String_001() throws Exception {
//        MockID: YRw	Good morning, {0}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/home/workspaces
//        1. Login to Workfront 2. Go to Home page and enter New Home 3. Set your PC time to 9 AM and refresh the page

        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/home/workspaces");
        waitForPageToLoadCompletely(driver,60);

        // Take SS: YQy	Custom Data
        takeSnapShotWithHighlight(driver,"//h1", GlobalConstants.SCREENSHOTS+folder+"001_YRs.png");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}
