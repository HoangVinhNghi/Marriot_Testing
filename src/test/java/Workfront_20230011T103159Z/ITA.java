package Workfront_20230011T103159Z;

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

public class ITA extends AbstractPage {
    WebDriver driver;
    String folder = "\\Workfront_20230011T103159Z\\ITA\\3616615\\ITA"; // the path to store the captured images with  lang code can be changed accordingly
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
        options.addArguments("--lang=it"); //set browser language
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
    public void String_001_005() throws Exception {
//        MockID:   YTC	Kanban board
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64575dd5fd92681780115d53
//        1. Login to Workfront 2. Go to Boards 3. Click on Create New button near Collection panel 4. Click Create New

        // Go to Boards
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/boards/workstream/64575dd5fd92681780115d53");
        waitForPageToLoadCompletely(driver,60);

        sleepInSecond(1);
        clickToElement(driver,"//button[@data-testid='dashboard-create-board-button']");
        waitForElementVisible(driver,"//*[name()='path' and contains(@d,'M32,18.5a3.49643,3.49643')]/ancestor::div[contains(@style,'height: 100%; width: 100%; flex-direction: column;')]");

        // Take SS: YTC	Kanban board
        takeSnapShotWithHighlight(driver,"//*[name()='path' and contains(@d,'M32,18.5a3.49643,3.49643')]/ancestor::div[contains(@style,'height: 100%; width: 100%; flex-direction: column;')]//h4",
                GlobalConstants.SCREENSHOTS+folder+"001_YTC.png");

        // Take SS: YS/	A board with an intake column and work limits
        takeSnapShotWithHighlight(driver,"(//*[name()='path' and contains(@d,'M32,18.5a3.49643,3.49643')]/ancestor::div[contains(@style,'height: 100%; width: 100%; flex-direction: column;')]//span)[1]",
                GlobalConstants.SCREENSHOTS+folder+"002_YSSlash.png");

        // Take SS: YS+	A freeform board that can be customized from the ground up
        takeSnapShotWithHighlight(driver,"(//*[name()='path' and contains(@d,'M2,5V31a1')]/ancestor::div[contains(@style,'height: 100%; width: 100%; flex-direction: column;')]//span)[1]",
                GlobalConstants.SCREENSHOTS+folder+"003_YS+.png");

        // Take SS: YS9	A board with suggested columns for running a retrospective
        takeSnapShotWithHighlight(driver,"(//*[name()='path' and contains(@d,'M32.67383,20H30')]/ancestor::div[contains(@style,'height: 100%; width: 100%; flex-direction: column;')]//span)[1]",
                GlobalConstants.SCREENSHOTS+folder+"004_YS9.png");

        // Take SS: YTA	Team policies, planning, and a recurring time-cycle board to measure efficiency over time
        takeSnapShotWithHighlight(driver,"(//*[name()='path' and contains(@d,'M33.174,16.724A13')]/ancestor::div[contains(@style,'height: 100%; width: 100%; flex-direction: column;')]//span)[1]",
                GlobalConstants.SCREENSHOTS+folder+"005_YTA.png");

    }
    @Test
    public void String_006() throws Exception {
//        MockID: YS6	Another indent/outdent operation is in progress.	None
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome
//        Test User: adobeloctesting@workfront.com / 2wsx#EDC Direct link: https://adobeloctesting.devtest.workfront-dev.com/project/62668d0f00007fab94235ee296969bc6/tasks
//        1. Login to Workfront 2. Open any project 3. Go to Tasks and open any task 4. Go to Subtask and create some subtasks 5. Select any subtask and start spamming any intent button(in the toolbar)

        // Go to Boards and open a new board
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/task/6475a7cd0002a0562b03d69b30b1de96/tasks");
        waitForPageToLoadCompletely(driver,60);
        sleepInSecond(1);
        waitForElementVisible(driver,"//div[@data-test-id='header-checkbox']");
        checkToCheckboxOrRadio(driver,"//div[@data-test-id='header-checkbox']");
        sleepInSecond(2);
        waitForElementVisible(driver,"//button[@data-testid='indent' or @data-testid='outdent']");
        clickToElementByJS(driver,"//button[@data-testid='indent' or @data-testid='outdent']");
        clickToElementByJS(driver,"//button[@data-testid='indent' or @data-testid='outdent']");
        clickToElementByJS(driver,"//button[@data-testid='indent' or @data-testid='outdent']");

        // Take SS: YS6	Another indent/outdent operation is in progress.
        takeSnapShotWithHighlight(driver,"(//div[@data-testid='toast-notification'])[1]", GlobalConstants.SCREENSHOTS+folder+"006_YS6.png");

    }
    @Test
    public void String_007() throws Exception {
//        MockID: Xgg
//        {selectedUser} replaced {changeFrom} {rolesCount, plural, =0 {} =1 {in the {roleNames} role} other {in the {roleNames} roles}} on { count, plural, one {# work item} other {# work items}}
//        Test Environment: https://adobeloctesting.devtest.workfront-dev.com/login?nextURL=%2Fhome Test User: alp02c@alp.ee / Alp123
//        DL: https://adobeloctesting.devtest.workfront-dev.com/resourcemanagement/scheduling
//        1. Go to Projects and create a new project 2. Create 2 tasks and assign them to Consultant role 3. Go to Resource Management and click on Bulk Assignments button
//        4. In the filter select project id - and select your created project 5. In "Role Assignment" select role Consultant 6. In "User to assign" select Buzz Lightyear and click Assign
//        7. Select Replace User radio box 8. In "Currently assigned user" select Buzz Lightyear 9. In "User to assign" select Alpha Worker-Grabber 10. Click Replace

        // Go to Resource Management and click on Bulk Assignments button
        openPageUrl(driver, "https://adobeloctesting.devtest.workfront-dev.com/resourcemanagement/scheduling");
        waitForPageToLoadCompletely(driver,60);
        sleepInSecond(1);
        waitForElementVisible(driver,"//button[@data-testid='bulk-assignments-button']");
        clickToElement(driver,"//button[@data-testid='bulk-assignments-button']");
        sleepInSecond(2);
        sendKeyToElement(driver,"//div[@data-testid='select-component-wrapper']//input","jk_test_prj01");
        sleepInSecond(2);
        clickToElement(driver,"//span[@data-label='JK_Test_prj01']");
        sleepInSecond(1);
        checkToCheckboxOrRadio(driver,"//input[@data-testid='replace-user']");
        sleepInSecond(1);
        sendKeyToElement(driver,"//input[@data-testid='replace-user-user-select-input']","Alpha Consultant 2");
        sleepInSecond(1);
        clickToElement(driver,"//span[@aria-label='Alpha Consultant 2']");
        sendKeyToElement(driver,"//input[@id='assign-user-user-select']","Alpha Worker");
        sleepInSecond(1);
        clickToElement(driver,"//span[@aria-label='Alpha Worker 100']");
        clickToElement(driver,"//button[@data-testid='bulk-assignment-assign-user']");

        // Take SS: YS6	Another indent/outdent operation is in progress.
        waitForElementVisible(driver,"//div[@data-testid='toast-notification']");
        takeSnapShotWithHighlight(driver,"//div[@data-testid='toast-notification']//span[@data-testid='body']", GlobalConstants.SCREENSHOTS+folder+"007_Xgg.png");

        //Reset assignment for other round
        clickToElement(driver,"//button[@data-testid='bulk-assignments-button']");
        sleepInSecond(2);
        sendKeyToElement(driver,"//div[@data-testid='select-component-wrapper']//input","jk_test_prj01");
        sleepInSecond(2);
        clickToElement(driver,"//span[@data-label='JK_Test_prj01']");
        sleepInSecond(1);
        checkToCheckboxOrRadio(driver,"//input[@data-testid='replace-user']");
        sleepInSecond(1);
        sendKeyToElement(driver,"//input[@data-testid='replace-user-user-select-input']","Alpha Worker");
        sleepInSecond(1);
        clickToElement(driver,"//span[@aria-label='Alpha Worker 100']");

        sendKeyToElement(driver,"//input[@id='assign-user-user-select']","Alpha Consultant 2");
        sleepInSecond(1);
        clickToElement(driver,"//span[@aria-label='Alpha Consultant 2']");
        clickToElement(driver,"//button[@data-testid='bulk-assignment-assign-user']");

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}