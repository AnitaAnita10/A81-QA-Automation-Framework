import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() {
        LoginPage loginPage = new LoginPage(driver);

    loginPage.provideEmail("anita.surewicz@testpro.io");
    loginPage.providePassword("AnitaAnita1029");
    loginPage.clickSubmit();
}
}
