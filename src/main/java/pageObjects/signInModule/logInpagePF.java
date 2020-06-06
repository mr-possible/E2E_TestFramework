package pageObjects.signInModule;

import BasePackage.SuiteBase;
import Utility.PageFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class logInpagePF extends SuiteBase {

    @FindBy(xpath = "//input[@id='email']")
    private WebElement txt_Email;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement txt_Pwd;

    @FindBy(id = "SubmitLogin")
    private WebElement btn_Login;

    public logInpagePF(WebDriver driver) throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    public void LogInProcess(String email, String password) {
        PageFunctions.typeIntoTextbox(txt_Email, email);
        PageFunctions.typeIntoTextbox(txt_Pwd, password);
        //PageFunctions.clickElement(btn_Login);
    }


}
