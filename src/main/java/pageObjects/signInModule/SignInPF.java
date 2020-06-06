package pageObjects.signInModule;

import BasePackage.SuiteBase;
import Utility.PageFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SignInPF extends SuiteBase {

    @FindBy(xpath = "//a[@class='login']")
    private WebElement link_SignIn;

    public SignInPF(WebDriver driver) throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    public void click_SignIn() throws InterruptedException {
        PageFunctions.wait(2000);
        PageFunctions.clickElement(link_SignIn);
    }


}
