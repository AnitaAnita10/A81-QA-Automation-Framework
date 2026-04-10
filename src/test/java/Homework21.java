import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    String newPlaylistName = "Anita Again";

    @Test
    public void renamePlayList() {

        String updatedPlayListMsg = "Updated playlist \"Anita Again.\"";

        /*navigateToPage();*/
        provideEmail("anita.surewicz@testpro.io");
        providePassword("AnitaAnita1029");
        clickLoginButton();
        doubleClickPlayList();
        enterNewPlayListName();
        Assert.assertEquals(getRenamePlayListSuccessMsg(),updatedPlayListMsg);

    }

    public void doubleClickPlayList() {
        WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        actions.doubleClick(playListElement).perform();
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