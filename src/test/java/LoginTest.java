import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;


public class LoginTest {

    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod(){
        webDriver = new FirefoxDriver();
    }

    @AfterMethod
    public void afterMethod(){
        //webDriver.quit();
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
    public void successfulLoginTest() throws InterruptedException {
        webDriver.navigate().to("https://linkedin.com/");
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page is not loaded");
        HomePage homePage = loginPage.login("autotestserg555@gmail.com", "Password555@", HomePage.class);
        sleep(3000);
        Assert.assertTrue(homePage.isPageLoaded(), "Home Page is not loaded");
    }

    @Test
    public void passwordFieldIsEmptyTest() throws InterruptedException {
        webDriver.navigate().to("https://linkedin.com/");
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page is not loaded");
        loginPage.login("autotestserg555@gmail.com", "", LoginPage.class);
        sleep(3000);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page is not loaded");
    }

    @Test
    public void passwordIsWrongTest() throws InterruptedException {
        webDriver.navigate().to("https://linkedin.com/");
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page is not loaded");
        LoginSubmitPage loginSubmitPage = loginPage.login("autotestserg555@gmail.com", "test12345", LoginSubmitPage.class);
        sleep(3000);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "Login Submit Page is not loaded");
        Assert.assertEquals(loginSubmitPage.alertErrorText(), "There were one or more errors in your submission. Please correct the marked fields below.", "Alert Error message is absent");
        Assert.assertEquals(loginSubmitPage.passwordErrorText(), "Hmm, that's not the right password. Please try again or request a new one.", "Password Error message is absent");
    }

    @Test
    public void passwordHasLessThanSixCharTest() throws InterruptedException {
        webDriver.navigate().to("https://linkedin.com/");
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page is not loaded");
        LoginSubmitPage loginSubmitPage = loginPage.login("autotestserg555@gmail.com", "testt", LoginSubmitPage.class);
        sleep(3000);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "Login Submit Page is not loaded");
        Assert.assertEquals(loginSubmitPage.alertErrorText(), "There were one or more errors in your submission. Please correct the marked fields below.", "Alert Error message is absent");
        Assert.assertEquals(loginSubmitPage.passwordErrorText(), "The password you provided must have at least 6 characters.", "Password Error message is absent");
    }

    @Test
    public void emailFieldIsEmptyTest() throws InterruptedException {
        webDriver.navigate().to("https://linkedin.com/");
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page is not loaded");
        loginPage.login("", "test12", LoginPage.class);
        sleep(3000);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page is not loaded");
    }

    @Test
    public void allFieldsAreEmptyTest() throws InterruptedException {
        webDriver.navigate().to("https://linkedin.com/");
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page is not loaded");
        loginPage.login("", "", LoginPage.class);
        sleep(3000);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page is not loaded");
    }

    @Test
    public void emailIsWrongTest() throws InterruptedException {
        webDriver.navigate().to("https://linkedin.com/");
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page is not loaded");
        LoginSubmitPage loginSubmitPage = loginPage.login("autotest", "test12345", LoginSubmitPage.class);
        sleep(3000);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "Login Submit Page is not loaded");
        Assert.assertEquals(loginSubmitPage.alertErrorText(), "There were one or more errors in your submission. Please correct the marked fields below.", "Alert Error message is absent");
        Assert.assertEquals(loginSubmitPage.emailErrorText(), "Please enter a valid email address.", "Email Error message is absent");
    }

    @Test
    public void emailHasLessThanThreeCharTest() throws InterruptedException {
        webDriver.navigate().to("https://linkedin.com/");
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page is not loaded");
        LoginSubmitPage loginSubmitPage = loginPage.login("au", "test12345", LoginSubmitPage.class);
        sleep(3000);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "Login Submit Page is not loaded");
        Assert.assertEquals(loginSubmitPage.alertErrorText(), "There were one or more errors in your submission. Please correct the marked fields below.", "Alert Error message is absent");
        Assert.assertEquals(loginSubmitPage.emailErrorText(), "The text you provided is too short (the minimum length is 3 characters, your text contains 2 characters).", "Email Error message is absent");
    }
}
