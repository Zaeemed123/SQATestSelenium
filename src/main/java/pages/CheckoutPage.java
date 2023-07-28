package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement zipCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className = "complete-header")
    private WebElement header;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void enterDetails(String first_Name, String last_Name, String zip_Code){
        firstName.sendKeys(first_Name);
        lastName.sendKeys(last_Name);
        zipCode.sendKeys(zip_Code);
    }

    public void clickContinue(){
        continueButton.click();
    }

    public void clickFinish(){
        finishButton.click();
    }

    public String assertHeader(){
        return header.getText();
    }
}
