package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utils.driverFactory;
import utils.logUtils;

public class loginPageStepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @Given("User is on login page")
    public void onLoginPage(){
        driver = driverFactory.getDriver("chrome");
        loginPage = new LoginPage(driver);
        logUtils.log("Navigating to the sauce demo login page");
        driver.get("https://www.saucedemo.com");
    }

    @When("he enters the username {string} and password {string}")
    public void enterCredentials(String name, String password){
        logUtils.log("entering username and password to login the website");
        loginPage.enterUsernameCredentials(name);
        loginPage.enterPasswordCredentials(password);
    }

    @When("clicks on the login button")
    public void clickLogin(){
        logUtils.log("Clicking the login button");
        loginPage.clickLogin();
    }

    @Then("he should be redirected to home page")
    public void assertHomePage(){
        homePage = loginPage.redirect();
        logUtils.log("Verifying the successful login of the user");
        Assert.assertEquals(homePage.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Then("he should see the error message")
    public void errorMessage(){
        logUtils.log("Verifying the unsuccessful login of the user");
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.getErrorMessage());
    }

}
