package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPageObject extends BasePageObject {

    public ShoppingCartPageObject(WebDriver driver){
        super(driver);
    }

    @FindBy(className = "cart_item")
    WebElement cartItem;

    public boolean hasItem() {
        waitForElement(cartItem);
        return cartItem.isDisplayed();
    }
}
