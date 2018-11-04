import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordResetPage {

    private WebDriver webDriver;

    @FindBy(xpath = "//input[@name='newPassword']")
    private WebElement newPasswordFeild;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement submitButton;


    public PasswordResetPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().contains("password-reset")
                && webDriver.getTitle().contains("Reset Your Password");
    }

    public PasswordResetSubmitPage resetPassword(String newPassword, String confirmPassword){
        newPasswordFeild.sendKeys(newPassword);
        confirmPasswordField.sendKeys(confirmPassword);
        submitButton.click();
        return PageFactory.initElements(webDriver, PasswordResetSubmitPage.class);
    }
}
