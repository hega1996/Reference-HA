package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject extends BasePageObject {

    public LoginPageObject(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class='login_logo']")
    private WebElement loginLogo;

    @FindBy(xpath = "//div[@class='bot_column']")
    private WebElement loginBot;

    @FindBy(xpath="//input[@id='user-name']")
    private WebElement loginUserName;

    @FindBy(xpath="//input[@data-test='password']")
    private WebElement loginPassword;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    public boolean checkLoginLogo() {
        waitForElement(loginLogo);
        return loginLogo.isDisplayed();
    }

    public boolean checkLoginBot() {
        waitForElement(loginBot);
        return loginBot.isDisplayed();
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

}
