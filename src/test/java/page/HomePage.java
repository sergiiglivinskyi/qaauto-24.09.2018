package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavItem;

    @FindBy(xpath = "//input[@role='combobox']")
    private WebElement searchField;

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isProfileNavItemDisplayed(){
        return profileNavItem.isDisplayed();
    }

    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/feed/")
                && webDriver.getTitle().contains("LinkedIn")
                && isProfileNavItemDisplayed();
    }

    public SearchPage search(String searchTerm){
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return PageFactory.initElements(webDriver, SearchPage.class);
    }
}
