package e2ePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{

    public ProductsPage (WebDriver webDriver){super(webDriver);}

    private String PRODUCTS_PAGE_PATH = "inventory.html";

    private By productPageTitle = By.xpath("//*[text()=\"Products\"]");

    private By shoppingCartIcon = By.className("shopping_cart_link");


    public String getProductsPagePath() {
        return PRODUCTS_PAGE_PATH;
    }


    public Boolean checkProductPageTitleIsDisplayed() {
        return isElementDisplayed(productPageTitle);
    }


    public Boolean checkShoppingCartIconIsDisplayed() {
        return isElementDisplayed(shoppingCartIcon);
    }





}
