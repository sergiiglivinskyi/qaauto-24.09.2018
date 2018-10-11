import org.openqa.selenium.WebDriver;
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
    public void successfulLoginTest(){
        WebDriver webDriver = new FirefoxDriver();
        webDriver.navigate().to("https://linkedin.com/");
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "Home Page URL is wrong");
        webDriver.quit();
    }
}
