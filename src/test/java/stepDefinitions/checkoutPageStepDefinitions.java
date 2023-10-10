package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CartPage;
import pages.CheckoutPage;
import utils.driverFactory;
import utils.logUtils;

public class checkoutPageStepDefinitions {
    private static WebDriver driver;
    private static CheckoutPage checkoutPage;

    @Given("User is on Checkout Page")
    public static void onCheckoutPage(){
        driver = driverFactory.getDriver("chrome");
        checkoutPage = new CheckoutPage(driver);
        logUtils.log("Verifying that the user is present on the checkout page");
        Assert.assertEquals(checkoutPage.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Then("User enters his first name as {string}, last name as {string} and zip code as {string}")
    public static void enterDetails(String firstName, String lastName, String code){
        logUtils.log("User enter details on the checkout screen");
        checkoutPage.enterDetails(firstName,lastName,code);
    }

    @Then("User clicks on continue button")
    public static void clickContinue(){
        logUtils.log("User clicks on the continue button");
        checkoutPage.clickContinue();
    }

    @Then("User is redirected to second page")
    public static void assertSecondPage(){
        logUtils.log("Verify that the user is redirected to the second screen of checkout");
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-two.html", driver.getCurrentUrl());
    }

    @Then("User clicks on finish button")
    public static void clickFinish(){
        logUtils.log("User clicks on finish button");
        checkoutPage.clickFinish();
    }

    @Then("the user is redirected to the checkout complete screen")
    public static void assertCheckoutCompletePage(){
        logUtils.log("Verify that the user is redirected to the checkout complete screen");
        Assert.assertEquals("https://www.saucedemo.com/checkout-complete.html", driver.getCurrentUrl());
        Assert.assertEquals("Thank you for your order!", checkoutPage.assertHeader());
        driver.quit();
    }
}
