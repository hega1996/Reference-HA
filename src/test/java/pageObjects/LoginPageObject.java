package pageObjects;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPageObject extends BasePageObject {

    public LoginPageObject(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class='login_logo']")
    private WebElement loginLogo;

    @FindBy(xpath = "//div[@class='login_credentials_wrap-inner']")
    private WebElement credentialsHelper;

    @FindBy(xpath="//input[@id='user-name']")
    private WebElement loginUserName;

    @FindBy(xpath="//input[@data-test='password']")
    private WebElement loginPassword;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class=\"form_group\"]//*[name()=\"svg\"]")
    private List<WebElement> loginErrorIcons;

    @FindBy(xpath="//button[@class='error-button']//*[name()='svg']")
    private WebElement loginErrorCloseButton;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    private WebElement loginErrorMessage;


    public boolean checkLoginLogo() {
        waitForElement(loginLogo);
        return loginLogo.isDisplayed();
    }

    public boolean checkCredentialsHelper() {
        waitForElement(credentialsHelper);
        return credentialsHelper.isDisplayed();
    }

    public boolean checkLoginUsername() {
        waitForElement(loginUserName);
        return loginUserName.isDisplayed();
    }

    public boolean checkLoginPassword() {
        waitForElement(loginPassword);
        return loginPassword.isDisplayed();
    }

    public boolean checkLoginButton() {
        waitForElement(loginButton);
        return loginButton.isDisplayed();
    }

    public void enterUsername(String username) {
        loginUserName.sendKeys(username);
    }

    public void enterPassword(String password) {
        loginPassword.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public boolean checkLoginErrorIcons() {
        try {
            waitForElements(loginErrorIcons);
            return !loginErrorIcons.isEmpty();
        }catch (TimeoutException e) {
            return false;
        }

        }

    public boolean checkLoginErrorMessage() {
        try {
            waitForElement(loginErrorMessage);
            return loginErrorMessage.isDisplayed();
        } catch ( TimeoutException e) {
            return false;
        }
    }

    public boolean checkLoginErrorCloseButton() throws TimeoutException {
        try {
            waitForElement(loginErrorCloseButton);
            return loginErrorCloseButton.isDisplayed();
        }
        catch( TimeoutException e) {
            return false;
        }
    }




    public void clickOnLoginErrorCloseButton() {
        loginErrorCloseButton.click();
    }

}
