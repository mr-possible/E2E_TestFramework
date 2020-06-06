package contactUsModule;

import BasePackage.SuiteBase;
import Utility.Add_Log;
import Utility.Read_ExcelData;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class contactUsBASE extends SuiteBase {

    private static Read_ExcelData TestModuleName = null;
    private static String fileDir = System.getProperty("user.dir");
    private Read_ExcelData FilePath = null;
    private String SheetName = null;
    private String SuiteName = null;
    private String ToRunColumnName = null;

    public contactUsBASE() throws IOException {
        super();
    }

    @BeforeSuite
    public void checkSuiteToRun() {
        //To initialise SuitesList file.
        intialiseSuiteListFile();
        Add_Log.info("SuiteList file initiated successfully.");

        TestModuleName = new Read_ExcelData(fileDir + "\\src\\main\\java\\ExcelFiles\\contactUsModule.xlsx");

        FilePath = TestModuleName;
        SheetName = "SuitesList";
        SuiteName = "contactUsModule";
        ToRunColumnName = "SuiteToRun";     //Yes OR No

    }
}
