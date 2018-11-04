import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordResetSubmitPage {

    private WebDriver webDriver;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement goToHomeButton;

    public PasswordResetSubmitPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().contains("password-reset-submit")
                && webDriver.getTitle().contains("You've successfully reset your password");
    }

    public HomePage clickOnGoToHomeButton(){
        goToHomeButton.click();
        return PageFactory.initElements(webDriver, HomePage.class);
    }
}
