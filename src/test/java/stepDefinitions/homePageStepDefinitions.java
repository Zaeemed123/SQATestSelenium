package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.HomePage;
import utils.driverFactory;

public class homePageStepDefinitions {
    private static WebDriver driver;

    private static HomePage homePage;
    private static CartPage cartPage;

    @Given("User is on Home Page")
    public static void onHomePage(){
        driver = driverFactory.getDriver("chrome");
        homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Then("User clicks on add to cart to add item to cart")
    public static void clickAddToCart(){
        homePage.addToCart();
    }

    @Then("User clicks on Remove to remove item from cart")
    public static void clickRemove(){
        homePage.removeFromCart();
    }

    @Then("User selects the filter {string} to filter the items")
    public static void filter(String filter){
        homePage.filterItems(filter);
    }

    @Then("User clicks on cart icon")
    public static void clickCartIcon(){
        homePage.clickCartIcon();
    }

    @Then("the user is redirected to the cart screen")
    public static void assertCartPage(){
        cartPage = homePage.redirect();
        Assert.assertEquals(cartPage.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Then("user clicks on side bar icon")
    public static void clickSideBarIcon(){
        homePage.clickSideBarIcon();
    }

    @Then("User clicks on Logout button")
    public static void clickLogoutButton(){
        homePage.clickLogoutButton();
    }

    @Then("user is redirected to login screen")
    public static void assertLoginScreen(){
        Assert.assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
    }
}
