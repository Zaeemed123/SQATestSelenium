package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import utils.driverFactory;
import utils.logUtils;

public class cartPageStepDefinitions {
    private static WebDriver driver;
    private static CartPage cartPage;
    private static CheckoutPage checkoutPage;

    @Given("User is on Cart Page")
    public static void onCartPage(){
        driver = driverFactory.getDriver("chrome");
        cartPage = new CartPage(driver);
        logUtils.log("Asserting if the user is present on the cart page");
        Assert.assertEquals(cartPage.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Then("User clicks on checkout button")
    public static void clickCheckout(){
        logUtils.log("Clicking the checkout button on cart page");
        cartPage.clickCheckoutButton();
    }

    @Then("the user is redirected to the checkout screen one")
    public static void assertCheckoutPageOne(){
        checkoutPage = cartPage.redirect();
        logUtils.log("Verifying that the user is redirected to the checkout screen");
        Assert.assertEquals(cartPage.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Then("user verifies the product is present in cart")
    public static void isProductPresent(){
        logUtils.log("Verifying if product(s) available in cart");
        Assert.assertTrue(cartPage.isCartNotEmpty());
    }
}
