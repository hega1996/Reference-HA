package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
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

    @FindBy(xpath = "//select[@data-test=\"product_sort_container\"]")
    WebElement productsSort;

    @FindBy(id = "react-burger-menu-btn")
    WebElement productMenuButton;

    @FindBy(xpath = "//a[@class='bm-item menu-item']")
    List<WebElement> productMenuItems;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeFromCartButton;

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

    public void clickOnSortDropdown() {
        waitForElement(productsSort);
        productsSort.click();
    }
    public List<String> getProductSortOptions() {
        Select select = new Select(productsSort);
        List<WebElement> options = select.getOptions();
        List<String> optionString = new ArrayList<>();
        for (WebElement option: options) {
            optionString.add(option.getText());
            System.out.println("Option:"+ option.getText());
        }
        for (String option: optionString) {
            System.out.println("Option from the created list:"+ option);
        }
        return optionString;
    }

    public void clickOnMenuButton() {
        waitForElement(productMenuButton);
        productMenuButton.click();
    }

    public boolean checkIfMenuContainsItem(String item) {
        waitForElements(productMenuItems);
        for(WebElement e : productMenuItems){
            if (e.getText().equalsIgnoreCase(item)){
                return true;
            }
        }
        return false;
    }

    public void clickOnAddToCartButton() {
        waitForElement(addToCartButton);
        addToCartButton.click();
    }

    public boolean checkRemoveFromCartButton() {
        waitForElement(removeFromCartButton);
        return removeFromCartButton.isDisplayed();
    }



}
