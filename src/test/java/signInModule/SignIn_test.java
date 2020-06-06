package signInModule;

import BasePackage.SuiteBase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.signInModule.SignInPF;
import pageObjects.signInModule.createNewAccountPF;
import pageObjects.signInModule.logInpagePF;

import java.io.IOException;

public class SignIn_test extends SuiteBase {

    logInpagePF obj_LogInpagePF;
    createNewAccountPF obj_CreateNewAccount;

    public SignIn_test() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException {
        initializeDriver();
    }

    @Test
    public void SignIn_Test() throws IOException, InterruptedException {
        SignInPF obj_SignInPF = new SignInPF(driver);
        String signInURL = hitURL();
        driver.get(signInURL);
        obj_SignInPF.click_SignIn();
        obj_CreateNewAccount = new createNewAccountPF(driver);

        obj_LogInpagePF = new logInpagePF(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver = null;
    }
}
