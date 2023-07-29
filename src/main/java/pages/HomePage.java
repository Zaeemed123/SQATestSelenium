package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

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

}
