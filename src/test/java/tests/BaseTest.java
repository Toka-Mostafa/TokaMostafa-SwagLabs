package tests;

import driverManager.ChromeDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ScreenshotUtility;

import java.net.MalformedURLException;

public class BaseTest {
    public static WebDriver driver = null;
    protected Dotenv dotenv = Dotenv.load();
    protected final String VALID_USERNAME = dotenv.get("VALID_USERNAME");
    protected final String LOCKED_USERNAME = dotenv.get("LOCKED_USERNAME");
    protected final String PASSWORD = dotenv.get("PASSWORD");
    protected final String SWAG_LABS_FRONTEND_URL = dotenv.get("SWAG_LABS_FRONTEND_URL");

    ChromeDriverManager driverManager;


    @BeforeMethod
    public void startDriver() throws MalformedURLException {
        driverManager = new ChromeDriverManager();
        driver = driverManager.getDriver();
    }


    @AfterMethod
    public void stopDriver() {
        driverManager.quitDriver();
    }


    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtility.captureScreenshot(driver, result.getName());
        }
        stopDriver();
    }
}
