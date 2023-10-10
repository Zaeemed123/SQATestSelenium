package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;


    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    public CheckoutPage redirect(){
        return new CheckoutPage(driver);
    }

    public boolean isCartEmpty(){
        return cartItems.isEmpty();
    }

    public boolean isCartNotEmpty(){
        return !cartItems.isEmpty();
    }
}
