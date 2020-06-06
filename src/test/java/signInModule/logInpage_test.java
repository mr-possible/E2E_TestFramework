package signInModule;

import BasePackage.SuiteBase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.signInModule.logInpagePF;

import java.io.IOException;

public class logInpage_test extends SuiteBase {
    logInpagePF obj_LoginPagePF;

    public logInpage_test() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException {
        initializeDriver();
    }

    @Test
    public void LogInPage_Test() throws IOException {
        obj_LoginPagePF = new logInpagePF(driver);
        String url = hitURL();
        driver.get(url);
    }

    @AfterTest
    public void teardown() {
        driver.close();
        driver = null;
    }
}
