package pageObjects.newsletterModule;

import BasePackage.SuiteBase;
import Utility.PageFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class NewsLetterInputPF extends SuiteBase {

    @FindBy(id = "newsletter-input")
    @CacheLookup
    private WebElement txt_newsletterInput;

    public NewsLetterInputPF(WebDriver driver) throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    public void setNewsLetterInput(String emailToPass) throws IOException {
        PageFunctions.switchToWindow(driver, "My Store");
        PageFunctions.typeIntoTextbox(txt_newsletterInput, emailToPass);
        PageFunctions.takeSnapshotWithText(driver, "Email entered in text box");

    }



}
