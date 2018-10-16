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
        //Assert.assertEquals(signInButton.isDisplayed(), true, "Sign In button is absent");

        loginPage.login("autotestserg555@gmail.com", "Password555@");


        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home Page URL is wrong");
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn", "Title is wrong");


    }

    @Test
    public void negativeLoginTest() {
        webDriver.navigate().to("https://linkedin.com/");

        WebElement emailField = webDriver.findElement(By.xpath("//input[@class='login-email']"));
        WebElement passwordField = webDriver.findElement(By.xpath("//input[@class='login-password']"));
        WebElement signInButton = webDriver.findElement(By.id("login-submit"));

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "Home Page URL is wrong");
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up", "Title is wrong");
        Assert.assertEquals(signInButton.isDisplayed(), true, "Sign In button is absent");

        emailField.sendKeys("autotestserg555@gmail.com1");
        passwordField.sendKeys("");
        signInButton.click();

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "Home Page URL is wrong");
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up", "Title is wrong");

    }
}
