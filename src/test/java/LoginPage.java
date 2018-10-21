import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver webDriver;

    private WebElement emailField;
    private WebElement passwordField;
    private WebElement signInButton;

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

    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/")
                && webDriver.getTitle().equals("LinkedIn: Log In or Sign Up")
                && isSignInButtonDisplayed();
    }


    public boolean isSignInButtonDisplayed(){
        return signInButton.isDisplayed();
    }
}
