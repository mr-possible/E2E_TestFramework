package newsletterModule;

import BasePackage.SuiteBase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.newsletterModule.NewsLetterInputPF;

import java.io.IOException;

public class NewsLetterInput_test extends SuiteBase {

    NewsLetterInputPF obj_ContactUsPF;

    public NewsLetterInput_test() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException {
        initializeDriver();
    }

    @Test
    public void NewsLetterInput_Test() throws IOException {
        obj_ContactUsPF = new NewsLetterInputPF(driver);
        String siteURL = hitURL();
        driver.get(siteURL);
        obj_ContactUsPF.setNewsLetterInput("abc@gmail.com");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver = null;
    }
}
