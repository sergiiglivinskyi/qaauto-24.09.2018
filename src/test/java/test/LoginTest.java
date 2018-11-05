package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.LoginSubmitPage;

import static java.lang.Thread.sleep;


public class LoginTest extends BaseTest{

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "autotestserg555@gmail.com", "Password555@"},
                { "autotestSERG555@gmail.com", "Password555@"},
                { " autotestSERG555@gmail.com ", "Password555@"}
        };
    }

    @DataProvider
    public Object[][] wrongDataProvider() {
        return new Object[][]{
                { "autotestserg555@gmail.com", "test12345", "", "Hmm, that's not the right password. Please try again or request a new one."},
                { "autotestSERG555@gmail.com", "test1", "", "The password you provided must have at least 6 characters."},
                { "autotestSERG555@gmail", "Password555@", "Please enter a valid email address.", ""},
                { "au", "Password555@", "The text you provided is too short (the minimum length is 3 characters, your text contains 2 characters).", ""}
        };
    }

    @DataProvider
    public Object[][] emptyDataProvider() {
        return new Object[][]{
                { "", ""},
                { "autotestSERG555@gmail.com", ""},
                { "", "Password555@"}
        };
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
    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String userName, String userPassword) throws InterruptedException {
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page is not loaded");
        HomePage homePage = loginPage.login(userName, userPassword, HomePage.class);
        sleep(3000);
        Assert.assertTrue(homePage.isPageLoaded(), "Home Page is not loaded");
    }

    @Test(dataProvider = "wrongDataProvider")
    public void errorMessagesOnInvalidEmailPasswordTest(String userName, String userPassword, String emailErrorText, String passwordErrorText) throws InterruptedException {
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page is not loaded");
        LoginSubmitPage loginSubmitPage = loginPage.login(userName, userPassword, LoginSubmitPage.class);
        sleep(3000);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "Login Submit Page is not loaded");
        Assert.assertEquals(loginSubmitPage.alertErrorText(), "There were one or more errors in your submission. Please correct the marked fields below.", "Alert Error message is absent");
        Assert.assertEquals(loginSubmitPage.emailErrorText(), emailErrorText, "Email Error message is absent");
        Assert.assertEquals(loginSubmitPage.passwordErrorText(), passwordErrorText, "Password Error message is absent");
    }

    @Test(dataProvider = "emptyDataProvider")
    public void emptyDataLoginTest(String userName, String userPassword) throws InterruptedException {
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page is not loaded");
        loginPage.login(userName, userPassword, LoginPage.class);
        sleep(3000);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page is not loaded");
    }
}
