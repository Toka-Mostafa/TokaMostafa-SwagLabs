package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;


public class ChromeDriverManager extends DriverManager {

    private ChromeDriverService chromeDriverService;

    @Override
    public void startService() {
        WebDriverManager.chromedriver().clearDriverCache();
        WebDriverManager.chromedriver().setup();
        chromeDriverService = ChromeDriverService.createDefaultService();

        try {
            chromeDriverService.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

       @Override
        public void createDriver() throws MalformedURLException {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--window-size=1840,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-gpu");
            //options.addArguments("--headless");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-dev-shm-usage");

            driver = new RemoteWebDriver(chromeDriverService.getUrl(), options);
            driver.manage().window().maximize();
        }


}
