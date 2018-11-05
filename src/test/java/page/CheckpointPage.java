package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckpointPage {

    private WebDriver webDriver;

    @FindBy(xpath = "//button[@class='resend__link']")
    private WebElement resendLinkButton;

    @FindBy(xpath = "//span[contains(text(), 'We've sent another email. Please check your inbox.')]")
    private WebElement alertMessage;


    public CheckpointPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().contains("checkpoint")
                && webDriver.getTitle().contains("Please check your mail for reset password link")
                && isResendLinkButtonDisplayed();
    }

    public boolean isResendLinkButtonDisplayed(){
        return resendLinkButton.isDisplayed();
    }

    public void clickOnResendLinkButton(){
        resendLinkButton.click();
    }

    public boolean isAlertMessageDisplayed(){
        return alertMessage.isDisplayed();
    }









}
