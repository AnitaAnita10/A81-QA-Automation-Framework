import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String expectedSongAddedMessage = "Added 1 song into \"Homework17.\"";

        navigateToPage();
        provideEmail("anita.surewicz@testpro.io");
        providePassword("AnitaAnita1029");
        clickLoginButton();
        Thread.sleep(2000);

        clickSearchField("Dark Days");
        clickViewAll();
        clickFirstSong();
        clickAddTo();
        addToPlaylist();

        Assert.assertEquals(getAddToPlaylistMessage(), expectedSongAddedMessage);

    }

    public void clickSearchField(String name) throws InterruptedException {
        WebElement searchField = driver.findElement(By.xpath("//input[@name='q']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(name);
        Thread.sleep(2000);
    }

    public void clickViewAll() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(5000);
    }

    public void clickFirstSong() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item selected'][1]"));
        firstSong.click();
        Thread.sleep(2000);
    }

    public void clickAddTo() throws InterruptedException {
        WebElement addTo = driver.findElement(By.xpath("//button[@data-test='add-to-btn']"));
        addTo.click();
        Thread.sleep(2000);
    }

    public void addToPlaylist() throws InterruptedException {
        WebElement addSong = driver.findElement(By.xpath("//li[@class='playlist']"));
        addSong.click();
        Thread.sleep(2000);
    }

    public String getAddToPlaylistMessage() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

}