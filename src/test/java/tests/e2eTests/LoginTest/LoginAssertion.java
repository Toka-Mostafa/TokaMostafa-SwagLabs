package tests.e2eTests.LoginTest;

import e2ePages.LoginPage;
import org.testng.Assert;

import static tests.BaseTest.driver;

public class LoginAssertion {

        LoginPage loginPage = new LoginPage(driver);

        public void assertEmptyPasswordErrorMessageIsDisplayed() {
            Assert.assertTrue(loginPage.checkEmptyPasswordErrorMessageIsDisplayed());
        }


        public void assertEmptyUserNameErrorMessageIsDisplayed() {
            Assert.assertTrue(loginPage.checkEmptyUserNameErrorMessageIsDisplayed());
        }


        public void assertLockedOutErrorMessageIsDisplayed() {
            Assert.assertTrue(loginPage.checkLockedOutErrorMessageIsDisplayed());
        }


        public void assertInvalidUserNameOrPasswordErrorMessageIsDisplayed() {
            Assert.assertTrue(loginPage.checkInvalidUserNameOrPasswordErrorMessageIsDisplayed());
        }


        public void assertLoginPageTitleIsDisplayed() {
            Assert.assertTrue(loginPage.checkLoginPageTitleIsDisplayed());
        }


        public void assertUserNamePlaceholderIsDisplayed() {
            Assert.assertTrue(loginPage.checkUserNamePlaceholderIsDisplayed());
        }


        public void assertLoginButtonIsDisplayed() {
            Assert.assertTrue(loginPage.checkLoginButtonIsDisplayed());
        }


        public void assertPasswordPlaceholderIsDisplayed(){
            Assert.assertTrue(loginPage.checkPasswordPlaceholderIsDisplayed());
        }


        public void assertLoginPageContentIsDisplayed() {
            assertLoginPageTitleIsDisplayed();
            assertUserNamePlaceholderIsDisplayed();
            assertPasswordPlaceholderIsDisplayed();
            assertLoginButtonIsDisplayed();
        }



}
