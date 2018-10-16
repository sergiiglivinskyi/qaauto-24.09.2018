import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver webDriver;
    //userName = "autotestserg555@gmail.com";
    //userPassword = "Password555@";

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        initElements();
    }

    WebElement emailField;
    WebElement passwordField;
    WebElement signInButton;

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
}
