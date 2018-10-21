import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmitPage {

    private WebDriver webDriver;

    private WebElement signInLink;
    private WebElement alertError;
    private WebElement passwordError;
    private WebElement emailError;

    public LoginSubmitPage(WebDriver webDriver){
        this.webDriver = webDriver;
        initElements();
    }

    private void initElements(){
        signInLink = webDriver.findElement(By.xpath("//a[@class='nav-link']"));
    }

    public boolean isSignInLinkDisplayed(){
        return signInLink.isDisplayed();
    }

    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().contains("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
                && webDriver.getTitle().contains("Sign In to LinkedIn")
                && isSignInLinkDisplayed();
    }

    public String alertErrorText(){
        alertError = webDriver.findElement(By.xpath("//div[@class='alert error']"));
        return alertError.getText();
    }

    public String passwordErrorText(){
        passwordError = webDriver.findElement(By.id("session_password-login-error"));
        return passwordError.getText();
    }

    public String emailErrorText(){
        emailError = webDriver.findElement(By.xpath("//span[@id='session_key-login-error']"));
        return emailError.getText();
    }












}
