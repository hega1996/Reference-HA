package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPageObject extends BasePageObject{

    public ProductsPageObject(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement productsAppLogo;

    @FindBy(xpath = "//span[@class='title']")
    WebElement productsTitle;

    @FindBy(xpath = "(//div[@class='inventory_item'])")
    List<WebElement> products;

    public boolean checkProductsAppLogo() {
        waitForElement(productsAppLogo);
        return productsAppLogo.isDisplayed();
    }

    public boolean checkProductsTitle() {
        waitForElement(productsTitle);
        return productsTitle.isDisplayed();
    }

    public boolean checkProducts() {
        waitForElements(products);
        return !products.isEmpty();
    }

    public int numberOfProducts() {
        waitForElements(products);
        return products.size();
    }
}
