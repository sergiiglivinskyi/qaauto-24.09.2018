import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSubmitPage {

    private WebDriver webDriver;

    @FindBy (xpath = "//a[@class='nav-link']")
    private WebElement signInLink;

    @FindBy (xpath = "//div[@class='alert error']")
    private WebElement alertError;

    @FindBy (xpath = "//span[@id='session_password-login-error']")
    private WebElement passwordError;

    @FindBy (xpath = "//span[@id='session_key-login-error']")
    private WebElement emailError;

    public LoginSubmitPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
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
        return alertError.getText();
    }

    public String passwordErrorText(){
        return passwordError.getText();
    }

    public String emailErrorText(){
        return emailError.getText();
    }












}
