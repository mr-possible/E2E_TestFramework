package pageObjects.signInModule;

import BasePackage.SuiteBase;
import Utility.PageFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class createNewAccountPF extends SuiteBase {

    public createNewAccountPF(WebDriver driver) throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_create")
    private WebElement text_newUserEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement btn_SubmitNewEmail;

    @FindBy(id = "id_gender")
    private WebElement radio_Salutation;

    @FindBy(id = "customer_firstname")
    private WebElement text_FirstName;

    @FindBy(id = "customer_lastname")
    private WebElement text_LastName;

    @FindBy(id = "passwd")
    private WebElement txt_userPwd;

    @FindBy(id = "days")
    private WebElement dd_days;

    @FindBy(id = "months")
    private WebElement dd_months;

    @FindBy(id = "years")
    private WebElement dd_years;

    @FindBy(id = "firstname")
    private WebElement txt_firstNameAddrr;

    @FindBy(id = "lastname")
    private WebElement txt_lastNameAddrr;

    @FindBy(id = "company")
    private WebElement txt_CompanyName;

    @FindBy(id = "address1")
    private WebElement txt_address1;

    @FindBy(id = "address2")
    private WebElement txt_address2;

    @FindBy(id = "city")
    private WebElement txt_CityName;

    @FindBy(id = "uniform-id_state")
    private WebElement dd_StateName;

    @FindBy(id = "postcode")
    private WebElement txt_Zipcode;

    @FindBy(id = "phone_mobile")
    private WebElement txt_MobileNumber;

    @FindBy(id = "submitAccount")
    private WebElement btn_Register;

    public void createNewUserProcess() {
        PageFunctions.switchToWindow(driver, "Login - My Store");
        PageFunctions.typeIntoTextbox(text_newUserEmail, "samd6197@gmail.com");
        PageFunctions.clickElement(btn_SubmitNewEmail);
        PageFunctions.switchToWindow(driver, "Login - My Store");
        CustomerInfo();
        addressInfo();
        submitNewUser();
    }

    public void CustomerInfo() {
        PageFunctions.clickElement(radio_Salutation);
        PageFunctions.typeIntoTextbox(text_FirstName, "Sambhav");
        PageFunctions.typeIntoTextbox(text_LastName, "Dave");
        PageFunctions.typeIntoTextbox(txt_userPwd, "123@xyz");
        PageFunctions.selectDropDown(dd_days, "6");
        PageFunctions.selectDropDown(dd_months, "January");
        PageFunctions.selectDropDown(dd_years, "1997");
    }

    public void addressInfo() {
        PageFunctions.typeIntoTextbox(txt_firstNameAddrr, "Sambhav");
        PageFunctions.typeIntoTextbox(txt_lastNameAddrr, "Dave");
        PageFunctions.typeIntoTextbox(txt_CompanyName, "TCS");
        PageFunctions.typeIntoTextbox(txt_address1, "XYZ colony PO box 98");
        PageFunctions.typeIntoTextbox(txt_address2, "Risali");
        PageFunctions.typeIntoTextbox(txt_CityName, "Bhilai nagar");
        PageFunctions.selectDropDown(dd_StateName, "Alaska");
        PageFunctions.typeIntoTextbox(txt_Zipcode, "490006");
        PageFunctions.typeIntoTextbox(txt_MobileNumber, "0000112364");
    }

    public void submitNewUser() {
        PageFunctions.clickElement(btn_Register);
    }
}
