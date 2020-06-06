package contactUsModule;

import BasePackage.SuiteBase;
import Utility.Add_Log;
import Utility.PageFunctions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.contactUsModule.ContactUsPF;

import java.io.IOException;

public class ContactUs_test extends SuiteBase {
    ContactUsPF obj_ContactUsPF;

    public ContactUs_test() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException {
        //Intialise the webdriver and browser related configuration
        initializeDriver();

        //Initiate Data driven process




        obj_ContactUsPF = new ContactUsPF(driver);
    }

    @Test
    public void ContactUs_Test() throws IOException, InterruptedException {
        String siteURL = hitURL();
        Add_Log.info("URL hit in browser.");
        driver.get(siteURL);
        obj_ContactUsPF.click_ContactUs();
        PageFunctions.wait(3000);
        PageFunctions.takeSnapshotWithText(driver, "Clicked on Contact Us.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
