import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

@Test
    public void deletePlayList() throws InterruptedException {

        String ExpectedSongDeletedMessage = "Deleted playlist \"Homework19.\"";

        navigateToPage();
        provideEmail("anita.surewicz@testpro.io");
        providePassword("AnitaAnita1029");
        clickLoginButton();
        Thread.sleep(3000);

        clickPlayList();
        clickDeletePlayList();
        
        Assert.assertEquals(getSongDeletedMessage(), ExpectedSongDeletedMessage);
}

    public void clickPlayList() throws InterruptedException {
        WebElement playList = driver.findElement(By.xpath("//section[@id='playlists']//a[contains(text(), 'Homework19')]"));
        playList.click();
        Thread.sleep(2000);
    }

    private void clickDeletePlayList() throws InterruptedException {
        WebElement DeletePlayList = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        DeletePlayList.click();
        Thread.sleep(2000); 
    }

    public String getSongDeletedMessage() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

}
