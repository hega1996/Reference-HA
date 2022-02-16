package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BasePageObject {

    private WebDriver driver;

    public BasePageObject (WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    void waitForElement(WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
    void waitForElements(List<WebElement> list){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElements(list));
    }


}