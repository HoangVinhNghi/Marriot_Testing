package Marriott_ReleaseValidation;

import common.AbstractPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NO_ProductionReleaseValidations extends AbstractPage {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Set language
        options.addArguments("--lang=en");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        driver.get("https://www.marriott.com/no/default.mi?AKAQA=qa16b");
//        sendKeyToElement(driver, "//input[@id='username']", GlobalConstants.ACCOUNT);
//        sendKeyToElement(driver, "//input[@id='password']", GlobalConstants.PASSWORD);
//        clickToElement(driver, "//button[@type='submit']");
//        waitForElementVisible(driver, "//div[@id='page-content']");
    }

    @Test
    public void Step_01_Validate_qa16() throws Exception {
//        Account 2
//        First name: Jonckerstwo
//        Last name: Test Mar QA
//        Email – Jonckerstesting2@gmail.com
//        Password – Testing2
//        Bonvoy Member Number – 108194000

//This concluded validations on 16b.

// 1. We validate 16b first*: We launch https://www.marriott.com/no/default.mi?AKAQA=qa16b. This link will bring us to the 16b inactive cluster.**
        driver.get("https://www.marriott.com/no/default.mi?AKAQA=qa16g");
        waitForPageToLoadCompletely(driver, 30);

// 2. We sign in with one of the accounts provided to us.
        clickToElement(driver,"//button[@class='signin-btn t-subtitle-l custom_click_track track-completed']");
        if(isElementDisplayed(driver,"//div[@class='input-container s-form__remember-input']"))
        {
            sendKeyToElement(driver,"//input[@id='signin-user-password']","Testing2"); sleepInSecond(2);
            clickToElement(driver,"//button[@class='login-link m-button-s m-button-primary custom_click_track track-completed']");
            waitForElementInvisible(driver,"//button[@class='login-link m-button-s m-button-primary custom_click_track track-completed']");
            sleepInSecond(10);
        } else
            sendKeyToElement(driver,"//input[@id='signin-userid']","Jonckerstesting2@gmail.com"); sleepInSecond(3);
        sendKeyToElement(driver,"//input[@id='signin-user-password']","Testing2"); sleepInSecond(3);
        clickToElement(driver,"//button[@class='login-link m-button-s m-button-primary custom_click_track track-completed']");
        waitForElementInvisible(driver,"//button[@class='login-link m-button-s m-button-primary custom_click_track track-completed']");
        sleepInSecond(10);

        if(isElementDisplayed(driver,"//input[@class=' l-width-max js-emailValidation']")){
            sendKeyToElement(driver,"//input[@class=' l-width-max js-emailValidation']","Jonckerstesting2@gmail.com");
            sendKeyToElement(driver,"//input[@id='field-password']","Testing2");
            clickToElement(driver,"//button[contains(@class,'js-btn-submit')]");
            sleepInSecond(10);
            driver.get("https://www.marriott.com/no/default.mi?AKAQA=qa16g");
        }

// 3. We move to the Search card and enter “Antarctica” in the location field,
        sendKeyToElement(driver,"//input[@name='destinationAddress.destination']","Antarctica");
        waitForElementVisible(driver,"//li[contains(@id,'search-destination-option')][1]");
        sleepInSecond(1);
        clickToElement(driver,"//li[contains(@id,'search-destination-option')][1]");
        sleepInSecond(1);

//      we select dates at least 6 months out from the current date. We search for 1 room, one night and most importantly at a flexible rate, we click on “Find Hotels”.
        clickToElement(driver,"//div[contains(@class,'StyledAddDatesDiv')]");
        clickToElement(driver,"//button[@class='link-white icon-cancel']");
        sleepInSecond(2);
        clickToElement(driver,"//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"); sleepInSecond(1);
        clickToElement(driver,"//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"); sleepInSecond(1);
        clickToElement(driver,"//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"); sleepInSecond(1);
        clickToElement(driver,"//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"); sleepInSecond(1);
        clickToElement(driver,"//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"); sleepInSecond(1);
        clickToElement(driver,"//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"); sleepInSecond(1);
        clickToElement(driver,"//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"); sleepInSecond(1);
        clickToElement(driver,"//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"); sleepInSecond(1);
        clickToElement(driver,"//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"); sleepInSecond(1);
        clickToElement(driver,"//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"); sleepInSecond(1);
        clickToElement(driver,"//span[@class='DayPicker-Day-value'][normalize-space()='22']");
        clickToElement(driver,"//span[@class='DayPicker-Day-value'][normalize-space()='23']");
        sleepInSecond(1);
        clickToElement(driver,"//button[@class='m-button-secondary']");
        sleepInSecond(1);
        clickToElement(driver,"//button[contains(@class,'StyledFindBtn')]");

// 4. We proceed with our reservation and ReviewReservationDetails.mi will display already the details saved on the account we logged in to.
        String Destination = getElementText(driver,"//div[@id='destination']/a");
        System.out.println("Destination: "+Destination);
        clickToElement(driver,"(//a[@class='js-view-rate-btn-link analytics-click '])[3]"); //Choose hotel
        clickToElement(driver,"(//div[contains(@class,' l-rate-button rate-button')]/button)[2]"); //Choose room

        waitForElementVisible(driver,"//div[contains(@id,'ResReservationStep')]");
        waitForElementVisible(driver,"//button[@class='analytics-click m-button m-button-primary l-padding-top-three-quarters l-padding-bottom-three-quarters js-submit-sticky-btn custom_click_track']");

//      We fill in the field for an alternative email with “MarriottProductionTestingACCEPT@accertify.com”
        clickToElement(driver,"//a[@class='t-alt-link js-edit-text js-edit-text-addEmail t-no-hover-link']");
        clickToElement(driver,"//label[@for='alternate-email-address']");
        sleepInSecond(1);
        sendKeyToElement(driver,"//input[@id='alternate-email-text']","MarriottProductionTestingACCEPT@accertify.com");
        waitForElementVisible(driver,"//button[@id='submit-guest-name-and-email-address']");
        clickToElement(driver,"//button[@id='submit-guest-name-and-email-address']");

// 5. Before we click on “Book now” it’s good practice to review the page, and
// and that we have entered the alternative email indicated above.
//
//
//        System.out.println("---Review Reservation Detail---");
//
//// make sure we are booking in a hotel in Antarctica,
//        //Hotel address
//        String hoteladdress = getElementText(driver,"//address[@class='address-wrapper t-font-s l-margin-bottom-none l-display-inline-block']");
//        System.out.println("Hotel Address: "+hoteladdress);
//
//// First name Last name
//        //First name
//        String First_name = getElementText(driver,"//input[@id='first-name']");
//        System.out.println("First name: "+First_name);
//        //Last name
//        String Last_name = getElementText(driver,"//input[@id='last-name']");
//        System.out.println("Last name: "+Last_name);
//
//// for the approved dates,
//        //Booking date
//        String Checkin_date = getElementText(driver,"(//span[@class='m-date-text'])[1]");
//        System.out.println("Check In: "+Checkin_date);
//        String checkOut_date = getElementText(driver,"(//span[@class='m-date-text'])[1]");
//        System.out.println("Check Out: "+checkOut_date);
//
//// for a FLEXIBLE RATE,
//        clickToElement(driver,"//div[contains(@class,'m-price-container')]"); // Expand price container
//        //RateDetail
//        String RateDetail = getElementText(driver,"//div[contains(@class,'review-your-price')]//h3[@class='l-margin-none t-font-ml l-padding-bottom-quarter']");
//        System.out.println("Rate Detail: "+RateDetail);
//
//        //Section ID
//        String sectionID = getElementText(driver,"//div[contains(@class,'js-session-detail')]");
//        System.out.println("Section ID: "+sectionID);

        clickToElement(driver,"//button[@name='submit']");
        waitForElementVisible(driver,"//div[@data-component-name='confirmationDetails']");

// 6. On the confirmation page we copy the session ID and we pasted in the reservation log (or provide this to our coordinator/supervisor). We also take note of the Confirmation number, the First and Last name on the account,
//    the account number, the arrival day (MM/DD/YYYY), the hotel Marsha code (more info on how to find this will be provided separately). All this, together with the cancellation number will be logged on the Reservations file
//    (a link to the same will be shared on release day on Teams/by your supervisor)
        System.out.println("---Review Reservation Detail---");
        //Section ID
        String sectionID = getElementText(driver,"//div[contains(@class,'js-session-detail')]");
        System.out.println("Section ID: "+sectionID);

        clickToElement(driver,"//a[contains(@href,'reservation/printReservation.mi')]");

        //Hotel address
        String hoteladdress = getElementText(driver,"//div[@class='l-address l-margin-bottom-half']");
        System.out.println("Hotel Address: "+hoteladdress);

        //Confirmation number
        String Confirmation_number = getElementText(driver,"//span[@class='t-font-weight-bold l-room-label']");
        System.out.println("Confirmation number: "+Confirmation_number);

// First name Last name
        String FirstLast_name = getElementText(driver,"//div[contains(@id,'ResConfirmationMessage')]/p");
        System.out.println("First name Last name: "+FirstLast_name);

// Alternative email
        String Alternative_email = getElementText(driver,"//div[contains(@id,'ResConfirmationMessage')]/p/span[@class='t-font-weight-bold t-lowercase']");
        System.out.println("Alternative email: "+Alternative_email);

// for the approved dates,
        //Start_date
        String Start_date = getElementText(driver,"//div[contains(@class,'l-start-date t-font-s t-font-m')]");
        System.out.println("Start_date: "+Start_date);

// for a FLEXIBLE RATE,
        String RateDetail = getElementText(driver,"//div[@id=\"m-summary-charges-confirmation-upsell\"]//h3[@class='l-margin-none t-font-ml']");
        System.out.println("Rate Detail: "+RateDetail);

// 7. While it is not required to run extensive tests during validations, with sign in and booking, testers will visit and move through some of the pages with higher visibility hence they should notice any broken feature or
//    any functionality defects and these should be reported.***

    }
    @Test
    public void Step_02_Validate_qa13() throws Exception {
//        Account 2
//        First name: Jonckerstwo
//        Last name: Test Mar QA
//        Email – Jonckerstesting2@gmail.com
//        Password – Testing2
//        Bonvoy Member Number – 108194000

// 1. We move to the next cluster, 13b, the url would be https://www.marriott.com/no/default.mi?AKAQA=qa13b
        driver.get("https://www.marriott.com/no/default.mi?AKAQA=qa13g");
        waitForPageToLoadCompletely(driver, 30);

// 2. We sign in with the same account used on 16b and navigate to My Trips.
        //We should see “(1)” just next to “Mijn reizan” (or the equivalent on any other domain we are testing). This number indicate the upcoming reservations saved on that account.
        clickToElement(driver,"//button[@class='signin-btn t-subtitle-l custom_click_track track-completed']");
        if(isElementDisplayed(driver,"//div[@class='input-container s-form__remember-input']")) {
            sendKeyToElement(driver,"//input[@id='signin-user-password']","Testing2"); sleepInSecond(3);
            clickToElement(driver,"//button[@class='login-link m-button-s m-button-primary custom_click_track track-completed']"); sleepInSecond(2);
            waitForElementInvisible(driver,"//button[@class='login-link m-button-s m-button-primary custom_click_track track-completed']");
            sleepInSecond(10);
        } if(isElementDisplayed(driver,"//input[@id='signin-userid']")) {
            sendKeyToElement(driver,"//input[@id='signin-userid']","Jonckerstesting2@gmail.com"); sleepInSecond(3);
            sendKeyToElement(driver,"//input[@id='signin-user-password']","Testing2"); sleepInSecond(3);
            clickToElement(driver,"//button[@class='login-link m-button-s m-button-primary custom_click_track track-completed']"); sleepInSecond(2);
            waitForElementInvisible(driver,"//button[@class='login-link m-button-s m-button-primary custom_click_track track-completed']");
            sleepInSecond(10);
        } if(isElementDisplayed(driver,"//div[@class='tile-member-details-widget']")){
            clickToElement(driver,"//a[@data-component-name='myAccount']");
        }

        if(isElementDisplayed(driver,"//input[@class=' l-width-max js-emailValidation']")){
            sendKeyToElement(driver,"//input[@class=' l-width-max js-emailValidation']","Jonckerstesting2@gmail.com"); sleepInSecond(3);
            sendKeyToElement(driver,"//input[@id='field-password']","Testing2"); sleepInSecond(3);
            clickToElement(driver,"//button[contains(@class,'js-btn-submit')]");
            sleepInSecond(10);
            driver.get("https://www.marriott.com/no/default.mi?AKAQA=qa13g");
        }

        // Once we click in My Trips we will navigate to /loyalty/findReservationList.mi. This page has 2 tabs, one for upcoming bookings, the other for cancelled booking.
        clickToElement(driver,"//a[contains(@href,'rewards/findReservationList.mi')]"); //Click on My Trip

        // By default the page will show the list of upcoming bookings.
        waitForElementVisible(driver,"//a[contains(@href,'reservation/findReservationList.mi?toggleUpcoming=true')]");

// 3. We should see the reservation we just completed, we click on View/Modify.
        clickToElement(driver,"(//a[contains(@class,'m-button m-button-secondary l-margin-right-three-quarters l-button')])[1]"); // click on View/Edit

// 4. On /findReservationDetail.mi we click on “Edit Room”.
        clickToElement(driver,"//a[contains(@class,'l-edit-button m-button m-button-secondary')]");

// 5. On /reservation/modifyRateListMenu.mi we can change the dates (still at least 6 months out from the current date),
        //Change Check In date 3 days later.
        clickToElement(driver,"//span[@class='next-checkin t-icon-arrow-right focus-elem']"); sleepInSecond(1);
        clickToElement(driver,"//span[@class='next-checkin t-icon-arrow-right focus-elem']"); sleepInSecond(1);
        clickToElement(driver,"//span[@class='next-checkin t-icon-arrow-right focus-elem']"); sleepInSecond(1);

        // or number of guests, + 1 guess
        clickToElement(driver,"//span[@class='js-adults-perroom js-adlt ']");
        clickToElement(driver,"(//a[contains(@class,'l-plus js-plus t-icon-plus analytics-click')])[1]");

        // or change to another FLEXIBLE rate, e.g. a Senior Discount (Code S9R) and modify our booking.
        clickToElement(driver,"//a[contains(@class,'js-special-rates-header l-h-toggle l-h-field analytics-click')]");
        clickToElement(driver,"//input[@class='search-clusterCode-S9R radio']/parent::fieldset");

        clickToElement(driver,"//button[@class='analytics-click js-is-roomkey-enabled m-button m-button-primary ']"); //Click Update

// 6. This should bring us to the Modification confirmation page. We copy the Session ID and share it with our coordinator/add this to the Reservation log.
        waitForElementVisible(driver,"(//button[contains(@data-formaction,'reservation/modifySelectRate.mi')])[1]");
        clickToElement(driver,"(//button[contains(@data-formaction,'reservation/modifySelectRate.mi')])[1]");

// 7. We have successfully modified our booking. This concludes validations on 13b. Any functionality defects on the pages tested should be reported.
        waitForElementVisible(driver,"//div[@class='tile-summary-of-changes']");

        System.out.println("---Summary Of Changes---");
        String Confirmation_ID = getElementText(driver,"//div[@class='tile-summary-of-changes']//h2");
        System.out.println("Confirmation_ID: "+Confirmation_ID);

        String Old_Date = getElementText(driver,"//p[@class='l-margin-top-quarter l-l-display-inline l-l-margin-left-quarter']");
        System.out.println("Old Date: "+Old_Date);

        String New_Date = getElementText(driver,"//p[@class='l-margin-top-quarter l-l-margin-left-quarter l-l-display-inline']");
        System.out.println("New Date: "+New_Date);

        waitForElementVisible(driver,"//div[contains(@id,'ResReviewModifyActions')]//button[@name='submit']"); //Click Submit change
        clickToElement(driver,"//div[contains(@id,'ResReviewModifyActions')]//button[@name='submit']"); //Click Submit change

        String sectionID = getElementText(driver,"//div[contains(@class,'js-session-detail')]");
        System.out.println("Section ID: "+sectionID);

    }
    @Test
    public void Step_03_Validate_qa8() throws Exception {
//        Account 2
//        First name: Jonckerstwo
//        Last name: Test Mar QA
//        Email – Jonckerstesting2@gmail.com
//        Password – Testing2
//        Bonvoy Member Number – 108194000

// 1. We move to the next cluster, 13b, the url would be https://www.marriott.com/no/default.mi?AKAQA=qa13b
        driver.get("https://www.marriott.com/no/default.mi?AKAQA=qa8g");
        waitForPageToLoadCompletely(driver, 30);

// 2. We sign in with the same account used on 16b and navigate to My Trips.
        //We should see “(1)” just next to “Mijn reizan” (or the equivalent on any other domain we are testing). This number indicate the upcoming reservations saved on that account.
        clickToElement(driver,"//button[@class='signin-btn t-subtitle-l custom_click_track track-completed']");
        if(isElementDisplayed(driver,"//div[@class='input-container s-form__remember-input']")) {
            sendKeyToElement(driver,"//input[@id='signin-user-password']","Testing2"); sleepInSecond(3);
            clickToElement(driver,"//button[@class='login-link m-button-s m-button-primary custom_click_track track-completed']"); sleepInSecond(2);
            waitForElementInvisible(driver,"//button[@class='login-link m-button-s m-button-primary custom_click_track track-completed']");
            sleepInSecond(10);
        } if(isElementDisplayed(driver,"//input[@id='signin-userid']")) {
            sendKeyToElement(driver,"//input[@id='signin-userid']","Jonckerstesting2@gmail.com"); sleepInSecond(3);
            sendKeyToElement(driver,"//input[@id='signin-user-password']","Testing2"); sleepInSecond(3);
            clickToElement(driver,"//button[@class='login-link m-button-s m-button-primary custom_click_track track-completed']"); sleepInSecond(2);
            waitForElementInvisible(driver,"//button[@class='login-link m-button-s m-button-primary custom_click_track track-completed']");
            sleepInSecond(10);
        } if(isElementDisplayed(driver,"//div[@class='tile-member-details-widget']")){
            clickToElement(driver,"//a[@data-component-name='myAccount']");
        }

        if(isElementDisplayed(driver,"//input[@class=' l-width-max js-emailValidation']")){
            sendKeyToElement(driver,"//input[@class=' l-width-max js-emailValidation']","Jonckerstesting2@gmail.com"); sleepInSecond(3);
            sendKeyToElement(driver,"//input[@id='field-password']","Testing2"); sleepInSecond(3);
            clickToElement(driver,"//button[contains(@class,'js-btn-submit')]");
            sleepInSecond(10);
            driver.get("https://www.marriott.com/no/default.mi?AKAQA=qa8g");
        }

        // Once we click in My Trips we will navigate to /loyalty/findReservationList.mi. This page has 2 tabs, one for upcoming bookings, the other for cancelled booking.
        clickToElement(driver,"//a[contains(@href,'rewards/findReservationList.mi')]"); //Click on My Trip

        // By default the page will show the list of upcoming bookings.
        waitForElementVisible(driver,"//a[contains(@href,'reservation/findReservationList.mi?toggleUpcoming=true')]");

// 3. We should see the reservation we just completed, we click on View/Modify.
        clickToElement(driver,"(//a[contains(@class,'m-button m-button-secondary l-margin-right-three-quarters l-button')])[1]"); // click on View/Edit

// 4. On /findReservationDetail.mi we click on “Edit Room”.
        clickToElement(driver,"//a[contains(@class,'l-edit-button m-button m-button-secondary')]");

// 5. On /reservation/modifyRateListMenu.mi we can change the dates (still at least 6 months out from the current date),
        //Change Check In date 3 days later.
        clickToElement(driver,"//span[@class='next-checkin t-icon-arrow-right focus-elem']"); sleepInSecond(1);
        clickToElement(driver,"//span[@class='next-checkin t-icon-arrow-right focus-elem']"); sleepInSecond(1);
        clickToElement(driver,"//span[@class='next-checkin t-icon-arrow-right focus-elem']"); sleepInSecond(1);

        // or number of guests, + 1 guess
        clickToElement(driver,"//span[@class='js-adults-perroom js-adlt ']");
        clickToElement(driver,"(//a[contains(@class,'l-plus js-plus t-icon-plus analytics-click')])[1]");

        // or change to another FLEXIBLE rate, e.g. a Senior Discount (Code S9R) and modify our booking.
        clickToElement(driver,"//a[contains(@class,'js-special-rates-header l-h-toggle l-h-field analytics-click')]");
        clickToElement(driver,"//input[@class='search-clusterCode-S9R radio']/parent::fieldset");

        clickToElement(driver,"//button[@class='analytics-click js-is-roomkey-enabled m-button m-button-primary ']"); //Click Update

// 6. This should bring us to the Modification confirmation page. We copy the Session ID and share it with our coordinator/add this to the Reservation log.
        waitForElementVisible(driver,"(//button[contains(@data-formaction,'reservation/modifySelectRate.mi')])[1]");
        clickToElement(driver,"(//button[contains(@data-formaction,'reservation/modifySelectRate.mi')])[1]");

// 7. We have successfully modified our booking. This concludes validations on 13b. Any functionality defects on the pages tested should be reported.
        waitForElementVisible(driver,"//div[@class='tile-summary-of-changes']");

        System.out.println("---Summary Of Changes---");
        String Confirmation_ID = getElementText(driver,"//div[@class='tile-summary-of-changes']//h2");
        System.out.println("Confirmation_ID: "+Confirmation_ID);

        String Old_Date = getElementText(driver,"//p[@class='l-margin-top-quarter l-l-display-inline l-l-margin-left-quarter']");
        System.out.println("Old Date: "+Old_Date);

        String New_Date = getElementText(driver,"//p[@class='l-margin-top-quarter l-l-margin-left-quarter l-l-display-inline']");
        System.out.println("New Date: "+New_Date);

        clickToElement(driver,"//div[contains(@id,'ResReviewModifyActions')]//button[@name='submit']"); //Click Submit change

        String sectionID = getElementText(driver,"//div[contains(@class,'js-session-detail')]");
        System.out.println("Section ID: "+sectionID);

    }
    @Test
    public void Step_04_Validate_qa9() throws Exception {
//        Account 2
//        First name: Jonckerstwo
//        Last name: Test Mar QA
//        Email – Jonckerstesting2@gmail.com
//        Password – Testing2
//        Bonvoy Member Number – 108194000

// 1. Validations of 9b: We follow steps 1 to 3 from cluster 13b. https://www.marriott.com/no/default.mi?AKAQA=qa9b
        driver.get("https://www.marriott.com/no/default.mi?AKAQA=qa9b");
        waitForPageToLoadCompletely(driver, 30);
        sleepInSecond(30);

// 2. We sign in with the same account used on 16b and navigate to My Trips.
        //We should see “(1)” just next to “Mijn reizan” (or the equivalent on any other domain we are testing). This number indicate the upcoming reservations saved on that account.
//        clickToElement(driver,"//button[@class='signin-btn t-subtitle-l custom_click_track track-completed']");
//        if(isElementDisplayed(driver,"//div[@class='input-container s-form__remember-input']")) {
//            sendKeyToElement(driver,"//input[@id='signin-user-password']","Testing2"); sleepInSecond(3);
//            clickToElement(driver,"//button[@class='login-link m-button-s m-button-primary custom_click_track track-completed']");
//            waitForElementInvisible(driver,"//button[@class='login-link m-button-s m-button-primary custom_click_track track-completed']");
//            sleepInSecond(10);
//        } if(isElementDisplayed(driver,"//input[@id='signin-userid']")) {
//            sendKeyToElement(driver,"//input[@id='signin-userid']","Jonckerstesting2@gmail.com"); sleepInSecond(3);
//            sendKeyToElement(driver,"//input[@id='signin-user-password']","Testing2"); sleepInSecond(3);
//            clickToElement(driver,"//button[@class='login-link m-button-s m-button-primary custom_click_track track-completed']");
//            waitForElementInvisible(driver,"//button[@class='login-link m-button-s m-button-primary custom_click_track track-completed']");
//            sleepInSecond(10);
//        } if(isElementDisplayed(driver,"//div[@class='tile-member-details-widget']")){
//            clickToElement(driver,"//a[@data-component-name='myAccount']");
//        }
//
//        if(isElementDisplayed(driver,"//input[@class=' l-width-max js-emailValidation']")){
//            sendKeyToElement(driver,"//input[@class=' l-width-max js-emailValidation']","Jonckerstesting2@gmail.com"); sleepInSecond(3);
//            sendKeyToElement(driver,"//input[@id='field-password']","Testing2"); sleepInSecond(3);
//            clickToElement(driver,"//button[contains(@class,'js-btn-submit')]");
//            sleepInSecond(10);
//            driver.get("https://www.marriott.com/no/default.mi?AKAQA=qa9b");
//        }

        // Once we click in My Trips we will navigate to /loyalty/findReservationList.mi. This page has 2 tabs, one for upcoming bookings, the other for cancelled booking.
        clickToElement(driver,"//a[contains(@href,'rewards/findReservationList.mi')]"); //Click on My Trip

        // By default the page will show the list of upcoming bookings.
        waitForElementVisible(driver,"//a[contains(@href,'reservation/findReservationList.mi?toggleUpcoming=true')]");

// 3. On On /findReservationDetail.mi we click on “Cancel”.
        clickToElement(driver,"(//a[contains(@href,'reservation/cancelUpcomingReservation.mi')])[1]"); // click on Cancel

// 4. We confirm we want to cancel our booking, by clicking on “Yes” on the overlay.
        clickToElement(driver,"//form[@data-component-name='cancelReservation']//input[@type='submit']");

// 5. We get to the Cancellation Confirmation page, the session ID on this page is also needed. Please share it with your coordinator/save it on the Reservation log file.
        System.out.println("---Summary Of Cancellation---");
        //Confirmation ID
        String Confirmation_ID = getElementText(driver,"//ul[contains(@class,'list-container cancellation-details-confirmation')]/li[contains(@class,'list-item')]/p[3]");
        System.out.println("Confirmation_ID: "+Confirmation_ID);

        //Cancellation ID
        String Cancellation_ID = getElementText(driver,"//ul[contains(@class,'list-container cancellation-details-confirmation')]/li[contains(@class,'list-item')]/p[4]");
        System.out.println("Cancellation_ID: "+Cancellation_ID);

        //Section ID
        String sectionID = getElementText(driver,"//div[contains(@class,'js-session-detail')]");
        System.out.println("Section ID: "+sectionID);


    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        driver.quit();
    }

}
