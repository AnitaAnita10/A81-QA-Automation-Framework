import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

@Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        provideEmail("anita.surewicz@testpro.io");
        providePassword("AnitaAnita1029");
        clickLoginButton();
        Thread.sleep(3000);
}
