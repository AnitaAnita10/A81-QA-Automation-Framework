import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        driver.get(url);

        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("anita.surewicz@testpro.io");

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.clear();
        passwordField.sendKeys("AnitaAnita1029");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement searchField = driver.findElement(By.xpath("//input[@type='search']"));
        searchField.clear(); //
        searchField.sendKeys("Episode 2");

        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();

        WebElement firstSong = driver.findElement(By.xpath("//tr[@class='song-item'][1]"));
        firstSong.click();

        WebElement addToBtn = driver.findElement(By.xpath("//button[@class='btn-add-to']"));
        addToBtn.click();

        WebElement homework17Playlist = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/header/div[3]/div/section[1]/ul/li[5]"));
        homework17Playlist.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement notification = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']"))
        );

        String actualMessage = notification.getText().trim();
        String expectedSongAddedMessage = "Added 1 song into \"Homework17.\"";

        Assert.assertEquals(actualMessage, expectedSongAddedMessage);


    }
}
