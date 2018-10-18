import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver webDriver;

    private WebElement profileNavItem;

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        initElements();
    }

    public void initElements(){
        profileNavItem = webDriver.findElement(By.xpath("//li[@id='profile-nav-item']"));
    }

    public WebElement getProfileNavItem(){
        return profileNavItem;
    }
}
