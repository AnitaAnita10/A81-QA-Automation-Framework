import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17Test extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        navigateToPage();
        provideEmail("anita.surewicz@testpro.io");
        providePassword("AnitaAnita1029");
        clickLoginButton();
        Thread.sleep(5000);
        clickSearchField();
        clickViewAll();
        clickFirstSong();
        clickAddTo();
        addToPlaylist();

    }

    private void addToPlaylist() {
        WebElement addSong = driver.findElement(By.xpath("//li[@class='playlist']"));
        addSong.click();
    }


    private void clickSearchField() {
        WebElement searchField = driver.findElement(By.xpath("//input[@name='q']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys("Dark Days");
    }

    private void clickViewAll() {
        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
    }

    private void clickFirstSong() {
        WebElement firstSong = driver.findElement(By.xpath("//tr[@class='song-item selected'][1]"));
        firstSong.click();
    }

    private void clickAddTo() {
        WebElement addTo = driver.findElement(By.xpath("//button[@data-test='add-to-btn']"));
        addTo.click();
    }






        /*WebElement viewAllBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[@data-test='view-all-songs-btn']")
                )
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", viewAllBtn);


        wait.until(ExpectedConditions.elementToBeClickable(viewAllBtn));

        viewAllBtn.click();

        WebElement firstSong = driver.findElement(By.xpath("//tr[@class='song-item'][1]"));
        firstSong.click();

        WebElement addToBtn = driver.findElement(By.xpath("//button[@class='btn-add-to']"));
        addToBtn.click();

        WebElement homework17Playlist = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/header/div[3]/div/section[1]/ul/li[5]"));
        homework17Playlist.click();

        WebElement notification = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']"))
        );

        String actualMessage = notification.getText().trim();
        String expectedSongAddedMessage = "Added 1 song into \"Homework17.\"";

        Assert.assertEquals(actualMessage, expectedSongAddedMessage);



   }
         */
}