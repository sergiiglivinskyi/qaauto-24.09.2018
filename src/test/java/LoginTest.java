import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest {

    /**
     * Preconditions:
     * - Open FF browser
     *
     * Scenario:
     * - Navigate to https://www.linkedin.com/
     * - Verify that Login page is loaded
     * - Enter userEmail into userEmail field
     * - Enter userPassword into userPassword field
     * - Click on signIn button
     * - Verify that Home page is loaded
     *
     * Postcondition:
     * - Close FF browser
     */
    @Test
    public void successfulLoginTest() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.navigate().to("https://linkedin.com/");

        WebElement emailField = webDriver.findElement(By.xpath("//input[@class='login-email']"));
        WebElement passwordField = webDriver.findElement(By.xpath("//input[@class='login-password']"));
        WebElement signInButton = webDriver.findElement(By.id("login-submit"));

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "Home Page URL is wrong");
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up", "Title is wrong");
        Assert.assertEquals(signInButton.isDisplayed(), true, "Sign In button is absent");

        emailField.sendKeys("sergii.glivinskyi@gmail.com");
        passwordField.sendKeys("Tszyus1986@");
        signInButton.click();

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home Page URL is wrong");
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn", "Title is wrong");

        webDriver.quit();
    }
}
