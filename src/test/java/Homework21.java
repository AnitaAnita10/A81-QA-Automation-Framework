import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    String newPlaylistName = "AnitaAgain";

    @Test
    public void renamePlayList() {

        String updatedPlayListMsg = "Updated playlist \"AnitaAgain.\"";

        /*navigateToPage();*/
        provideEmail("anita.surewicz@testpro.io");
        providePassword("AnitaAnita1029");
        clickLoginButton();
        doubleClickPlayList();
        enterNewPlayListName();
        Assert.assertEquals(getRenamePlayListSuccessMsg(),updatedPlayListMsg);

    }

    public void doubleClickPlayList() {
        WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='active']")));
        actions.doubleClick(playListElement).perform();
    }

    public void enterNewPlayListName() {
        WebElement newPlayListName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists'] //a[@class='active']")));
        newPlayListName.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        newPlayListName.sendKeys(newPlaylistName);
        newPlayListName.sendKeys(Keys.ENTER);

    }

    public String getRenamePlayListSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

}



/*public class Homework20 extends BaseTest{

    @Test
    public void deletePlayList() {

        String ExpectedSongDeletedMessage = "Deleted playlist \"Homework19.\"";

        navigateToPage();
        provideEmail("anita.surewicz@testpro.io");
        providePassword("AnitaAnita1029");
        clickLoginButton();

        clickPlayList();
        clickDeletePlayList();

        Assert.assertEquals(getSongDeletedMessage(), ExpectedSongDeletedMessage);
    }*/