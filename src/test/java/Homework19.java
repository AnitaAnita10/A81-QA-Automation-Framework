import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

@Test
    public void deletePlayList() throws InterruptedException {
        navigateToPage();
        provideEmail("anita.surewicz@testpro.io");
        providePassword("AnitaAnita1029");
        clickLoginButton();
        Thread.sleep(3000);

        clickPlayList();
        clickDeletePlayList();
}


    public void clickPlayList() throws InterruptedException {
        WebElement playList = driver.findElement(By.xpath(""));
        playList.click();
        Thread.sleep(2000); 
    }

    private void clickDeletePlayList() { throws InterruptedException
        WebElement DeletePlayList = driver.findElement(By.xpath(""));
        DeletePlayList.click();
        Thread.sleep(2000); 
    }


}
