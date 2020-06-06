package BasePackage;

import Utility.PageFunctions;
import Utility.Read_ExcelData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SuiteBase {

    public static WebDriver driver;
    public static Properties prop;
    public static FileInputStream fis;
    public static Read_ExcelData TestSuiteListExcel = null;
    private static String fileDir = System.getProperty("user.dir");

    public SuiteBase() throws IOException {
        fis = new FileInputStream(fileDir + "\\src\\main\\java\\resources\\param.properties");
        prop = new Properties();
        prop.load(fis);
    }

    public static void initializeDriver() {

        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            Boolean headlessSetting = Boolean.valueOf(prop.getProperty("headlessMode"));
            System.setProperty("webdriver.chrome.driver", fileDir + "\\src\\main\\java\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(headlessSetting);


        } else if (browserName.equalsIgnoreCase("firefox")) {
            //execution for firefox driver

        } else if (browserName.equalsIgnoreCase("ie")) {
            //execution for internet explorer
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void intialiseSuiteListFile() {
        TestSuiteListExcel = new Read_ExcelData(fileDir + "\\src\\main\\java\\ExcelFiles\\SuitesList.xlsx");
    }

    public String hitURL() {
        String siteURL = prop.getProperty("siteURL");
        PageFunctions.maximizeWindow(driver);
        return siteURL;
    }

}
