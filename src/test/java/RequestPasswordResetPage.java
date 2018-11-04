import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestPasswordResetPage {

    private WebDriver webDriver;

    @FindBy(xpath = "//button[@class='form__submit']")
    private WebElement findAccountButton;

    @FindBy(xpath = "//input[@name='userName']")
    private WebElement emailOrPhoneField;



    public RequestPasswordResetPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().contains("request-password-reset")
                && webDriver.getTitle().contains("Reset Password")
                && isFindAccountButtonDisplayed();
    }

    public boolean isFindAccountButtonDisplayed(){
        return findAccountButton.isDisplayed();
    }

    public CheckpointPage findAccount(String userEmail){
        emailOrPhoneField.sendKeys(userEmail);
        findAccountButton.click();
        return PageFactory.initElements(webDriver, CheckpointPage.class);
    }


}
