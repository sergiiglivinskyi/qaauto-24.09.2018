import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginTest {

    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod(){
        webDriver = new FirefoxDriver();
    }

    @AfterMethod
    public void afterMethod(){
        webDriver.quit();
    }

    /**
     * Preconditions:
     * - Open FF browser
     * <p>
     * Scenario:
     * - Navigate to https://www.linkedin.com/
     * - Verify that Login page is loaded
     * - Enter userEmail into userEmail field
     * - Enter userPassword into userPassword field
     * - Click on signIn button
     * - Verify that Home page is loaded
     * <p>
     * Postcondition:
     * - Close FF browser
     */
    @Test
    public void successfulLoginTest() {
        webDriver.navigate().to("https://linkedin.com/");
        LoginPage loginPage = new LoginPage(webDriver);

        //By userNameLocator = By.xpath("");
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "Home Page URL is wrong");
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up", "Title is wrong");
        Assert.assertEquals(loginPage.getSignInButton().isDisplayed(), true, "Sign In button is absent");

        loginPage.login("autotestserg555@gmail.com", "Password555@");

        HomePage homePage = new HomePage(webDriver);
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home Page URL is wrong");
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn", "Title is wrong");
        Assert.assertEquals(homePage.getProfileNavItem().isDisplayed(), true, "profileNavItem is not displayed on Login page");


        //li[@id='profile-nav-item']
    }

    @Test
    public void passwordFieldIsEmptyTest() {
        webDriver.navigate().to("https://linkedin.com/");
        LoginPage loginPage = new LoginPage(webDriver);
        //By userNameLocator = By.xpath("");
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "Home Page URL is wrong");
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up", "Title is wrong");
        Assert.assertEquals(loginPage.getSignInButton().isDisplayed(), true, "Sign In button is absent");

        loginPage.login("autotestserg555@gmail.com", "");

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "Home Page URL is wrong");
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up", "Title is wrong");

    }

    @Test
    public void passwordFieldIsIncorrectTest() {
        webDriver.navigate().to("https://linkedin.com/");
        LoginPage loginPage = new LoginPage(webDriver);
        //By userNameLocator = By.xpath("");
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "Home Page URL is wrong");
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up", "Title is wrong");
        Assert.assertEquals(loginPage.getSignInButton().isDisplayed(), true, "Sign In button is absent");

        loginPage.login("autotestserg555@gmail.com", "test12345");

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME", "Home Page URL is wrong");
        Assert.assertEquals(loginPage.getAlertError().getText(), "There were one or more errors in your submission. Please correct the marked fields below.", "Alert Error message is absent");
        Assert.assertEquals(loginPage.getPasswordError().getText(), "Hmm, that's not the right password. Please try again or request a new one.", "Alert Error message is absent");
    }
}
