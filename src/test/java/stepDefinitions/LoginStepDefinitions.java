package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPageObject;
import pageObjects.ProductsPageObject;

import static org.junit.Assert.assertTrue;

public class LoginStepDefinitions {
    private WebDriver driver;
    private LoginPageObject login;
    private ProductsPageObject products;
    private Logger log= Logger.getLogger(LoginStepDefinitions.class.getName());

    // 1. Scenario
    @Given("the Site is opened")
    public void the_site_is_opened() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        login = new LoginPageObject(driver);
        products = new ProductsPageObject(driver);
        log.info("the Site is opened succesfully");
    }
    @Then("the Login-logo is visible")
    public void the_login_logo_is_visible() {
        assertTrue("The Login-logo is not visible",login.checkLoginLogo());
        log.info("the Login logo is visible");
    }
    @Then("the Username input field is visible")
    public void the_username_input_field_is_visible() {
        assertTrue("The Username field is not visible",login.checkLoginUsername());
        log.info("the Username input field is visible");
    }
    @Then("the Password input field is visible")
    public void the_password_input_field_is_visible() {
        assertTrue("The Password input field is not visible",login.checkLoginPassword());
        log.info("the Password input field is visible");
    }
    @Then("the Login button is visible")
    public void the_login_button_is_visible() {
        assertTrue("The Login button is not visible",login.checkLoginButton());
        log.info("the Login button is visible");
    }
    @Then("the Bot image is visible")
    public void the_bot_image_is_visible() {
        assertTrue("The Bot image is not visible",login.checkLoginBot());
        log.info("the Bot image is visible");
    }

    @When("^the (\\w+) username is typed into the Username input field$")
    public void the_standard_user_username_is_typed_into_the_username_input_field(String username) {
        assertTrue("The" + username + "username is not typed into the username input field",login.checkLoginUsername());
        login.enterUsername(username);
        log.info("The username is typed into the field");
    }
    @When("^the (\\w+) password is typed into the Password input field$")
    public void the_secret_sauce_password_is_typed_into_the_password_input_field(String password) {
        assertTrue("The" + password + "password is not typed into the password input field",login.checkLoginPassword());
        login.enterPassword(password);
        log.info("The password is typed into the field");

    }
    @When("the Login button is clicked")
    public void the_login_button_is_clicked() {
        assertTrue("The login button is not clicked",login.checkLoginButton());
        login.clickOnLoginButton();
        log.info("The login button is clicked");
    }
    @Then("the App logo is visible")
    public void the_app_logo_is_visible() {
        assertTrue("The App logo is not visible", products.checkProductsAppLogo());
        log.info("The App logo is visible");
    }
    @Then("the Products title is visible")
    public void the_products_title_is_visible() {
        assertTrue("The Products title is visible",products.checkProductsTitle());
        log.info("The Products title is visible");
    }
    @Then("the Products are visible")
    public void the_products_are_visible() {
        assertTrue("The Products are visible", products.checkProducts());
        log.info("The Products are visible");
    }

}
