package StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    @Given("I open the browser")
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @And("I am in the Koel login page")
    public void iAmInTheKoelLoginPage() {
        driver.get("https://qa.koel.app/#!/home");
    }

    @When("I input email {string}")
    public void iInputEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[type='email']"))).sendKeys(email);
    }

    @When("I input password {string}")
    public void iInputPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[type='password']"))).sendKeys(password);
    }

    @And("I click Log in")
    public void iClickLogIn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[type='submit']"))).click();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("img.avatar"))).isDisplayed());

    }
}
