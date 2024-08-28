package e2ePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }

    private String LOGIN_PATH = dotenv.get("SWAG_LABS_FRONTEND_URL") ;

    private By loginPageTitle = By.className("login_logo");

    private By userNameField = By.id("user-name");

    private By userNamePlaceholder = By.cssSelector("input[placeholder=\"Username\"]");

    private By passwordField = By.id("password");

    private By passwordPlaceholder = By.cssSelector("input[placeholder=\"Password\"]");

    private By loginButton = By.id("login-button");

    private By lockedOutErrorMessage = By.xpath("//*[text()=\"Epic sadface: Sorry, this user has been locked out.\"]");

    private By emptyUserNameErrorMessage = By.xpath("//*[text()=\"Epic sadface: Username is required\"]");

    private By emptyPasswordErrorMessage = By.xpath("//*[text()=\"Epic sadface: Password is required\"]");

    private By invalidUserNameOrPasswordErrorMessage = By.xpath("//*[text()=\"Epic sadface: Username and password do not match any user in this service\"]");


    public String getLoginPath() {
        return LOGIN_PATH;
    }


    public void fillInUserName(String userName) {
        fillInElement(userNameField, userName);
    }

    public void fillInPassword(String password) {
        fillInElement(passwordField, password);
    }


    public void clickLoginButton() {
        clickElement(loginButton);
    }


    public Boolean checkLoginPageTitleIsDisplayed() {
        return isElementDisplayed(loginPageTitle);
    }


    public Boolean checkEmptyUserNameErrorMessageIsDisplayed() {
        return isElementDisplayed(emptyUserNameErrorMessage);
    }


    public Boolean checkEmptyPasswordErrorMessageIsDisplayed() {
        return isElementDisplayed(emptyPasswordErrorMessage);
    }


    public Boolean checkLockedOutErrorMessageIsDisplayed() {
        return isElementDisplayed(lockedOutErrorMessage);
    }


    public Boolean checkInvalidUserNameOrPasswordErrorMessageIsDisplayed() {
        return isElementDisplayed(invalidUserNameOrPasswordErrorMessage);
    }


    public Boolean checkLoginButtonIsDisplayed() {
        return isElementDisplayed(loginButton);
    }


    public Boolean checkUserNamePlaceholderIsDisplayed(){
        return isElementDisplayed(userNamePlaceholder);
    }


    public Boolean checkPasswordPlaceholderIsDisplayed(){
        return isElementDisplayed(passwordPlaceholder);
    }


    public void login(String userName, String password){
        visitPageURL(dotenv.get("SWAG_LABS_FRONTEND_URL"));
        fillInUserName(userName);
        fillInPassword(password);
        clickLoginButton();
    }


}
