package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//h1[text()='Products']")
    private WebElement productsHeader;

    @FindBy(xpath = "//*[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement addToCartSKUOne;

    @FindBy(xpath = "//*[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCartSKUTwo;

    @FindBy(xpath = "//*[@id='remove-sauce-labs-bike-light']")
    private WebElement removeFromCart;

    @FindBy(xpath = "//*[@id='header_container']/div[2]/div/span/select")
    private WebElement filter;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement sideBarIcon;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    @FindBy(className = "social_linkedin")
    private WebElement linkedinIcon;

    @FindBy(className = "social_twitter")
    private WebElement twitterIcon;

    @FindBy(className = "social_facebook")
    private WebElement facebookIcon;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void addToCart(){
        addToCartSKUOne.click();
        addToCartSKUTwo.click();
    }

    public void removeFromCart(){
        removeFromCart.click();
    }

    public void filterItems(String filterChoice){
        filter.click();
        if (Objects.equals(filterChoice, "Name (Z to A)")) {
            filter.sendKeys(Keys.DOWN);
        } else if (Objects.equals(filterChoice, "Price (low to high)")) {
            filter.sendKeys(Keys.DOWN);
            filter.sendKeys(Keys.DOWN);
        } else if (Objects.equals(filterChoice, "Price (high to low)")) {
            filter.sendKeys(Keys.DOWN);
            filter.sendKeys(Keys.DOWN);
            filter.sendKeys(Keys.DOWN);
        }
        filter.sendKeys(Keys.ENTER);
    }
    public void clickCartIcon(){
        cartIcon.click();
    }
    public CartPage redirect(){
        return new CartPage(driver);
    }

    public void clickSideBarIcon(){
        sideBarIcon.click();
    }

    public void clickLogoutButton(){
        logoutButton.click();
    }

    public void scrollScreen(){
        JavascriptExecutor js =  (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void clickIcon(String iconName){
        if(Objects.equals(iconName, "linkedin")){
            linkedinIcon.click();
        } else if (Objects.equals(iconName, "twitter")) {
            twitterIcon.click();

        } else if(Objects.equals(iconName, "facebook")){
            facebookIcon.click();
        }
    }

    public String assertExternalRedirect(String website){
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<>(windowHandles);
        driver.switchTo().window(handlesList.get(1));
        String link = "";
        if(Objects.equals(website, "linkedin")){
             link = "https://www.linkedin.com/company/sauce-labs/";
        } else if (Objects.equals(website, "twitter")) {
            link = "https://twitter.com/saucelabs";
        } else if(Objects.equals(website, "facebook")){
            link = "https://www.facebook.com/saucelabs";
        }
        return link;
    }
}
