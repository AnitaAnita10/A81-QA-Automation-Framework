import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

@Test
    public void deletePlayList() throws InterruptedException {
        navigateToPage();
        provideEmail("anita.surewicz@testpro.io");
        providePassword("AnitaAnita1029");
        clickLoginButton();
        Thread.sleep(3000);
}
