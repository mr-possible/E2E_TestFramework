package Utility;

import BasePackage.SuiteBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PageFunctions extends SuiteBase {
    //describe those methods here which serve as a common utility in day-to-day automation testing of web application.;

    public PageFunctions() throws IOException {
        super();
    }

    public static void clickElement(WebElement element) {
        element.click();
        Add_Log.info("Clicked the element: " + element.getAttribute("title"));
    }

    public static void takeSnapshotWithText(WebDriver driver, String textToDisplay) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("C:\\Users\\Sambhav\\IdeaProjects\\E2E_testFramework\\src\\main\\java\\Screenshots\\screenshot.png");
        FileUtils.copyFile(scrFile, destFile);
        BufferedImage bi = ImageIO.read(scrFile);
        Graphics g = bi.getGraphics();
        g.setColor(Color.GREEN);
        g.setFont(g.getFont().deriveFont(30f));
        g.drawString(textToDisplay, 100, 600);
        g.dispose();
        ImageIO.write(bi, "png", destFile);
    }

    public static void typeIntoTextbox(WebElement element, String stringToPass) {
        element.clear();
        element.sendKeys(stringToPass);
        Add_Log.info("Typed: '" + stringToPass + "' into the textbox.");
    }

    public static void wait(int i) throws InterruptedException {
        try {
            TimeUnit.MILLISECONDS.sleep(i);
        } catch (Exception e) {
            Add_Log.warn(e.toString());
        }
    }

    public static void captureText(WebElement element) {
        String textCaught = element.getText();
        Add_Log.info("Text captured as : " + textCaught);
    }

    public static void captureValueFromAttr(WebElement element) {
        String valueCaught = element.getAttribute("value");
        Add_Log.info("Value caught as : " + valueCaught);
    }

    public static void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public static void selectDropDown(WebElement element, String visibleText) {
        Select s = new Select(element);
        s.selectByVisibleText(visibleText);
    }

    public static void switchToWindow(WebDriver driver, String windowName) {
        for (String currentWindowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(currentWindowHandle);
            maximizeWindow(driver);
            if (driver.getTitle().equalsIgnoreCase(windowName)) {
                Add_Log.info(windowName + " ----> Window Matched.");
            } else {
                Add_Log.info("Window Switch Failed ! Please check the window name that has been passed.");
            }
        }
    }

    public static void createScreenshotWordDoc() {
        //This will create a word document consisting all the screenshots of the test (passed or failed).
        //If the test is skipped, then no word document will be created (obviously)
    }
}
