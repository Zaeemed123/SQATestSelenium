package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import utils.driverFactory;

public class cartPageStepDefinitions {
    private static WebDriver driver;
    private static CartPage cartPage;
    private static CheckoutPage checkoutPage;

    @Given("User is on Cart Page")
    public static void onCartPage(){
        driver = driverFactory.getDriver("chrome");
        cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Then("User clicks on checkout button")
    public static void clickCheckout(){
        cartPage.clickCheckoutButton();
    }

    @Then("the user is redirected to the checkout screen one")
    public static void assertCheckoutPageOne(){
        checkoutPage = cartPage.redirect();
        Assert.assertEquals(cartPage.getCurrentUrl(), driver.getCurrentUrl());
    }
}
