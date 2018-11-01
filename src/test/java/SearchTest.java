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
        SearchPage searchPage = homePage.search("HR", SearchPage.class);
        sleep(5000);
        Assert.assertTrue(searchPage.isPageLoaded(), "Search Page is not loaded");
        Assert.assertEquals(searchPage.numberOfSearchResults(), 10, "Search Results does not equals to 10");
        Assert.assertTrue(searchPage.isSearchTermPresent("HR"), "Search Term does not present");
    }
}
