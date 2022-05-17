package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.BasePageObject;
import pageObjects.LoginPageObject;
import pageObjects.ProductsPageObject;
import pageObjects.ShoppingCartPageObject;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class StepDefinitions {
    private WebDriver driver;
    private LoginPageObject login;
    private ProductsPageObject products;
    private BasePageObject base;
    private ShoppingCartPageObject shopping;
    private Logger log= Logger.getLogger(StepDefinitions.class.getName());


    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        base = new BasePageObject(driver);
        if (scenario.isFailed()) {
            base.takeScreenshot();
            log.info("The '" + scenario.getName() + "' scenario is failed.");
        } else {
            log.info("The '" + scenario.getName() + "'scenario ran successfully.");
        }
        driver.close();
        driver.quit();
    }


    // 1. Scenario
    @Given("the Site is opened")
    public void the_site_is_opened() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        login = new LoginPageObject(driver);
        products = new ProductsPageObject(driver);
        shopping = new ShoppingCartPageObject(driver);
        log.info("the Site is opened succesfully");
    }
    @Then("the Login-logo is visible")
    public void the_login_logo_is_visible() {
        assertFalse("The Login-logo is not visible",login.checkLoginLogo());
        driver.findElement(By.id("asd"));
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

    //Scenario 2:

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
        assertTrue("The Products title is not visible",products.checkProductsTitle());
        log.info("The Products title is visible");
    }
    @Then("the Products are visible")
    public void the_products_are_visible() {
        assertTrue("The Products are not visible", products.checkProducts());
        log.info(products.numberOfProducts()+ " products are visible");
    }

    @Then("the error message is displayed")
    public void the_error_message_is_displayed() {
        assertTrue("The error message is not visible ", login.checkLoginErrorMessage());
        log.info("The error message is visible");
    }

    @When("the close button on the error message is clicked")
    public void the_close_button_on_the_error_message_is_clicked() {
        assertTrue("The login error close button is not clicked", login.checkLoginErrorCloseButton());
        login.clickOnLoginErrorCloseButton();
        log.info("The Login error close button is clicked");
    }
    @Then("the error message is not displayed")
    public void the_error_message_is_not_displayed() {
        assertFalse("The error messages is displayed", login.checkLoginErrorMessage());
        log.info("The error message is not displayed");
    }

    @Then("the error icons are not displayed")
    public void the_error_icons_are_not_displayed() {
        assertFalse("The error icons are displayed", login.checkLoginErrorIcons());
        log.info("The error icons are not displayed");
    }

    @When("the sorting dropdown box is clicked")
    public void the_sorting_dropdown_box_is_clicked() {
        products.clickOnSortDropdown();
        log.info("The sorting dropdown box is clicked");
    }


    @Given("the {string} username is typed into the Username input field")
    public void the_username_is_typed_into_the_username_input_field(String username) {
        assertTrue("The" + username + "username is not typed into the username input field",login.checkLoginUsername());
        login.enterUsername(username);
        log.info("The username is typed into the field");
    }
    @Given("the {string} password is typed into the Password input field")
    public void the_password_is_typed_into_the_password_input_field(String password) {
        assertTrue("The" + password + "password is not typed into the password input field",login.checkLoginPassword());
        login.enterPassword(password);
        log.info("The password is typed into the field");
    }

    @Then("the following options are in the dropdown list:")
    public void theFollowingOptionsAreInTheDropdownList(List<String> desiredOptions) {
        assertEquals("The options are not in the dropdown list", products.getProductSortOptions(), desiredOptions);
        log.info("The options are in the dropdown list");
    }


    @Then("the {string} menu item is visible")
    public void theMenuItemIsVisible(String item) {
        assertTrue("The "+ item + " is not visible", products.checkIfMenuContainsItem(item));
        log.info("The"+item+ "item is visible in the menu");

    }

    @When("the menu button is clicked")
    public void theMenuButtonIsClicked() {
        products.clickOnMenuButton();
        log.info("The menu button is clicked");
    }

    @When("the add to cart button is clicked")
    public void theAddToCartButtonIsClicked() {
        products.clickOnAddToCartButton();
        log.info("The Add to cart button is clicked");
    }


    @Then("the remove button is visible\"")
    public void theRemoveButtonIsVisible() {
        assertTrue("The Remove button is not visible", products.checkRemoveFromCartButton());
        log.info("The remove button is visible");
    }

    @Then("an item is in the inventory")
    public void anItemIsInTheInventory() {
        assertTrue("The shopping cart has no item in it", shopping.hasItem());
        log.info("The item in the shopping cart is visible");
    }

    @And("the Shopping cart button is clicked")
    public void theShoppingCartButtonIsClicked() {
        products.clickonShoppingCartButton();
        log.info("The Shopping cart button is clicked");
    }
}
