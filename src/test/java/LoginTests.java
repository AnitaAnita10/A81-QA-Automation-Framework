import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test
    public void loginValidEmailPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
            loginPage.provideEmail("anita.surewicz@testpro.io").providePassword("AnitaAnita1029").clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginEmptyEmailPassword() throws InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("").providePassword("").clickSubmit();

        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test
    public void loginInvalidEmailValidPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("dfaf@gmail.com")
                .providePassword("AnitaAnita1029")
                .clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginValidEmailEmptyPassword() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("anita.surewicz@testpro.io")
                .providePassword("")
                .clickSubmit();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://qa.koel.app/");
    }


}
