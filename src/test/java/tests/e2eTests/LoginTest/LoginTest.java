package tests.e2eTests.LoginTest;

import e2ePages.LoginPage;
import e2ePages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.e2eTests.ProductsTest.ProductsAssertion;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    LoginAssertion loginAssertion;
    ProductsPage productsPage;
    ProductsAssertion productsAssertion;

    @BeforeMethod
    public void setUpData() throws Exception {
        initializedObjects();
    }


    @BeforeMethod(dependsOnMethods = "setUpData")
    public void openSwagLabsAndAssert(){
        loginPage.visitPageURL(dotenv.get("SWAG_LABS_FRONTEND_URL"));
        loginAssertion.assertLoginPageContentIsDisplayed();
    }



    @Test(priority = 1)
    public void testUserLoginWithValidUserNameAndPasswordSuccessfully() {
        loginPage.fillInUserName(VALID_USERNAME);
        loginPage.fillInPassword(PASSWORD);
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getCurrentURL(),SWAG_LABS_FRONTEND_URL + productsPage.getProductsPagePath());
        productsAssertion.assertProductsPageTitleIsDisplayed();
        productsAssertion.assertShoppingCartIconIsDisplayed();
    }


    @Test(priority = 2)
    public void testErrorMessageIsDisplayedWithInValidUserName() {
        loginPage.fillInUserName("InValid Username");
        loginPage.fillInPassword(PASSWORD);
        loginPage.clickLoginButton();
        loginAssertion.assertInvalidUserNameOrPasswordErrorMessageIsDisplayed();
    }


    @Test(priority = 3)
    public void testErrorMessageIsDisplayedWithInValidPassword() {
        loginPage.fillInUserName(VALID_USERNAME);
        loginPage.fillInPassword("Wrong Password");
        loginPage.clickLoginButton();
        loginAssertion.assertInvalidUserNameOrPasswordErrorMessageIsDisplayed();
    }



    @Test(priority = 4)
    public void testLockedOutErrorMessageIsDisplayedWithInLockedOutUserName() {
        loginPage.fillInUserName(LOCKED_USERNAME);
        loginPage.fillInPassword(PASSWORD);
        loginPage.clickLoginButton();
        loginAssertion.assertLockedOutErrorMessageIsDisplayed();
    }


    @Test(priority = 5)
    public void testEmptyPasswordErrorMessageIsDisplayed() {
        loginPage.fillInUserName(VALID_USERNAME);
        loginPage.clickLoginButton();
        loginAssertion.assertEmptyPasswordErrorMessageIsDisplayed();
    }


    @Test(priority = 6)
    public void testEmptyUserNameErrorMessageIsDisplayed() {
        loginPage.fillInPassword(PASSWORD);
        loginPage.clickLoginButton();
        loginAssertion.assertEmptyUserNameErrorMessageIsDisplayed();
    }


    public void initializedObjects(){
        loginPage = new LoginPage(driver);
        loginAssertion = new LoginAssertion();
        productsPage = new ProductsPage(driver);
        productsAssertion = new ProductsAssertion();
    }


    }
