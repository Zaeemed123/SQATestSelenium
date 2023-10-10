package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.HomePage;
import utils.driverFactory;
import utils.logUtils;

import java.util.Objects;

public class homePageStepDefinitions {
    private static WebDriver driver;

    private static HomePage homePage;
    private static CartPage cartPage;

    @Given("User is on Home Page")
    public static void onHomePage(){
        driver = driverFactory.getDriver("chrome");
        homePage = new HomePage(driver);
        logUtils.log("Asserting that the user is present on the home page");
        Assert.assertEquals(homePage.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Then("User clicks on add to cart to add item to cart")
    public static void clickAddToCart(){
        logUtils.log("Adding the item(s) to the cart");
        homePage.addToCart();
    }

    @Then("User clicks on Remove to remove item from cart")
    public static void clickRemove(){
        logUtils.log("Removing the items(s) from the cart");
        homePage.removeFromCart();
    }

    @Then("User selects the filter {string} to filter the items")
    public static void filter(String filter){
        logUtils.log("Filtering the products on the home page");
        homePage.filterItems(filter);
    }

    @Then("User clicks on cart icon")
    public static void clickCartIcon(){
        logUtils.log("Clicking the cart icon");
        homePage.clickCartIcon();
    }

    @Then("the user is redirected to the cart screen")
    public static void assertCartPage(){
        cartPage = homePage.redirect();
        logUtils.log("Verifying user redirection to the cart page");
        Assert.assertEquals(cartPage.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Then("user clicks on side bar icon")
    public static void clickSideBarIcon(){
        logUtils.log("Clicking the side bar icon to view side bar options");
        homePage.clickSideBarIcon();
    }

    @Then("User clicks on Logout button")
    public static void clickLogoutButton(){
        logUtils.log("Clicking the logout button to logout the user");
        homePage.clickLogoutButton();
    }

    @Then("user is redirected to login screen")
    public static void assertLoginScreen(){
        logUtils.log("Verifying user redirection to the login page");
        Assert.assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
    }

    @Then("user scrolls the page to the bottom")
    public static void scrollScreen(){
        logUtils.log("Scrolling the screen");
        homePage.scrollScreen();
    }

    @Then("user clicks on the {string} icon")
    public static void clickIcon(String iconName){
        homePage.clickIcon(iconName);
    }

    @Then("user is redirected to the {string} website")
    public static void confirmExternalRedirect(String website){
        String link = homePage.assertExternalRedirect(website);
        if(Objects.equals(website, "linkedin")){
            Assert.assertEquals("https://www.linkedin.com/company/sauce-labs/", link);
        } else if (Objects.equals(website, "twitter")) {
            Assert.assertEquals("https://twitter.com/saucelabs", link);
        } else if(Objects.equals(website, "facebook")){
            Assert.assertEquals("https://www.facebook.com/saucelabs", link);
        }
        driver.quit();
    }
}
