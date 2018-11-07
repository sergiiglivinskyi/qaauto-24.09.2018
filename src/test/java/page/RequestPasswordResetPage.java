package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestPasswordResetPage {

    private WebDriver webDriver;

    String link;

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
        GMailService gMailService = new GMailService();
        gMailService.connect();

        emailOrPhoneField.sendKeys(userEmail);
        findAccountButton.click();

        String messageSubject = "Serg, here's the link to reset your password";
        String messageTo = "autotestserg555@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 60);
        System.out.println("Content: " + message);
        System.out.println("====================================================");
        Pattern p = Pattern.compile("href=\"(.*?)\"");
        Matcher m = p.matcher(message);
        String url = null;
        for(int i = 0; i < 3; i++) {
            if (m.find()) {
                url = m.group(1);
            }
        }
        link = url.replace("amp;","");
        System.out.println("Link: " + link);
        return PageFactory.initElements(webDriver, CheckpointPage.class);
    }

    public PasswordResetPage navigateToLinkFromEmail(){
        webDriver.navigate().to(link);
        return PageFactory.initElements(webDriver, PasswordResetPage.class);
    }


}
