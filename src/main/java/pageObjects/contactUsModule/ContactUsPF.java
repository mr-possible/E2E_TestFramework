package pageObjects.contactUsModule;

import BasePackage.SuiteBase;
import Utility.PageFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ContactUsPF extends SuiteBase {

    @FindBy(xpath = "//div[@id='contact-link']//a[text()='Contact us']")
    private WebElement link_ContactUs;

    public ContactUsPF(WebDriver driver) throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    public void click_ContactUs() {
        PageFunctions.clickElement(link_ContactUs);
    }
}
