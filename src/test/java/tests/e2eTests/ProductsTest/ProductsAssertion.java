package tests.e2eTests.ProductsTest;

import e2ePages.ProductsPage;
import org.testng.Assert;

import static tests.BaseTest.driver;

public class ProductsAssertion {

    ProductsPage productsPage = new ProductsPage(driver);

    public void assertProductsPageTitleIsDisplayed(){
        Assert.assertTrue(productsPage.checkProductPageTitleIsDisplayed());
    }

    public void assertShoppingCartIconIsDisplayed(){
        Assert.assertTrue(productsPage.checkShoppingCartIconIsDisplayed());
    }




}
