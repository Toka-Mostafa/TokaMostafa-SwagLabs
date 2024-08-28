package e2ePages;


import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    private static final Duration WAIT = Duration.ofSeconds(60,1);
    private WebElement element;

    public BasePage(WebDriver webDriver){this.driver = webDriver;}


    public void visitPageURL(String url) {
        driver.get(url);
    }


    protected void waitUntilElementIsPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    protected void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    protected void clickElement(By locator) {
        waitUntilElementIsPresent(locator);
        element = driver.findElement(locator);
        waitForElementToBeClickable(element);
        element.click();
    }


    protected void fillInElement(By locator, String value) {
        waitUntilElementIsPresent(locator);
        driver.findElement(locator).sendKeys(value);
    }

    protected void waitForElementVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    protected Boolean isElementDisplayed(By locator){
        waitForElementVisibility(locator);
        return driver.findElement(locator).isDisplayed();
    }


    public void refreshPage() {
        driver.navigate().refresh();
    }


    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }


    public Dotenv dotenv = Dotenv.load();

}