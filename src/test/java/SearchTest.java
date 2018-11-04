import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class SearchTest {

    WebDriver webDriver;
    LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod(){
        webDriver = new FirefoxDriver();
        webDriver.navigate().to("https://linkedin.com/");
        loginPage = PageFactory.initElements(webDriver, LoginPage.class);
    }

    @AfterMethod
    public void afterMethod(){
        webDriver.quit();
    }


    /**
     * PreConditions:
     * - Open new Browser
     * - Navigate to linkedin.com
     *
     * Scenario:
     * - Verify that Login page is loaded
     * - Login with valid credentials
     * - Verify that Home page is loaded
     * - Enter 'searchTerm' into search field and press RETURN key
     * - Verify that Search page is loaded
     * - Verify 10 searchResults displayed on page
     * - Verify each result item contains 'searchTerm'
     */

    @Test
    public void basicSearchTest() throws InterruptedException {
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page is not loaded");
        HomePage homePage = loginPage.login("autotestserg555@gmail.com", "Password555@", HomePage.class);
        Assert.assertTrue(homePage.isPageLoaded(), "Home Page is not loaded");
        SearchPage searchPage = homePage.search("HR");
        sleep(5000);
        Assert.assertTrue(searchPage.isPageLoaded(), "Search Page is not loaded");
        Assert.assertEquals(searchPage.getNumberOfSearchResults(), 10, "Search Results does not equals to 10");
        Assert.assertTrue(searchPage.isSearchTermPresent("HR"), "Search Term does not present");
    }

    @Test
    public void resetPasswordTest() throws InterruptedException {
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page is not loaded");
        RequestPasswordResetPage requestPasswordResetPage = loginPage.clickOnForgotPasswordLink();
        sleep(5000);
        Assert.assertTrue(requestPasswordResetPage.isPageLoaded(), "Request Password Reset is not loaded");
        CheckpointPage checkpointPage = requestPasswordResetPage.findAccount("autotestserg555@gmail.com");
        sleep(5000);
        Assert.assertTrue(checkpointPage.isPageLoaded(), "Check Point Page is not loaded");
        sleep(50000);
        PasswordResetPage passwordResetPage = new PasswordResetPage(webDriver);
        Assert.assertTrue(passwordResetPage.isPageLoaded(), "Password Reset Page is not loaded");
        PasswordResetSubmitPage passwordResetSubmitPage = passwordResetPage.resetPassword("Password555@@@", "Password555@@@");
        sleep(5000);
        Assert.assertTrue(passwordResetSubmitPage.isPageLoaded(), "Password Reset Submit Page is not loaded");
        HomePage homePage = passwordResetSubmitPage.clickOnGoToHomeButton();
        Assert.assertTrue(homePage.isPageLoaded(), "Home Page is not loaded");




    }
}
