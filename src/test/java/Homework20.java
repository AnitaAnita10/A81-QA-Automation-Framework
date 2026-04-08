import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{

    @Test
    public void deletePlayList() throws InterruptedException {

        String ExpectedSongDeletedMessage = "Deleted playlist \"Homework19.\"";

        navigateToPage();
        provideEmail("anita.surewicz@testpro.io");
        providePassword("AnitaAnita1029");
        clickLoginButton();

        clickPlayList();
        clickDeletePlayList();

        Assert.assertEquals(getSongDeletedMessage(), ExpectedSongDeletedMessage);
    }

    public void clickPlayList() {
        WebElement playList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//a[contains(text(), 'Homework19')]")));
        playList.click();
    }

    private void clickDeletePlayList() {
        WebElement DeletePlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        DeletePlayList.click();
    }

    public String getSongDeletedMessage() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

}

