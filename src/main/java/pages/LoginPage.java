package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernameCred;

    @FindBy(id = "login-button")
    private WebElement login;

    @FindBy(id = "password")
    private WebElement passwordCred;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsernameCredentials(String username){
        usernameCred.sendKeys(username);
    }

    public void enterPasswordCredentials(String password){
        passwordCred.sendKeys(password);
    }

    public void clickLogin(){
        login.click();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

    public HomePage redirect(){
        return new HomePage(driver);
    }
}
