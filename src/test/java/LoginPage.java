import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver webDriver;

    private WebElement emailField;
    private WebElement passwordField;
    private WebElement signInButton;
    private WebElement alertError;
    private WebElement passwordError;

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        initElements();
    }

    public void initElements(){
        emailField = webDriver.findElement(By.xpath("//input[@class='login-email']"));
        passwordField = webDriver.findElement(By.xpath("//input[@class='login-password']"));
        signInButton = webDriver.findElement(By.id("login-submit"));
    }

    public void login(String userName, String userPassword){
        emailField.sendKeys(userName);
        passwordField.sendKeys(userPassword);
        signInButton.click();
    }

    public WebElement getSignInButton(){
        return signInButton;
    }

    public WebElement getAlertError(){
        alertError = webDriver.findElement(By.xpath("//div[@class='alert error']"));
        return alertError;
    }

    public WebElement getPasswordError(){
        passwordError = webDriver.findElement(By.id("session_password-login-error"));
        return passwordError;
    }
}
