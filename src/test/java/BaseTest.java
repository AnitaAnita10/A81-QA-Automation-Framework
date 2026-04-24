import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    public static WebDriver driver;
    public static String url;
    public static WebDriverWait wait = null;
    public static Actions actions;

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {

        return threadDriver.get();
    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setUpBrowser(String BaseURL) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;


    /*public void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = BaseURL;

        wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        actions = new Actions(driver);*/
        navigateToPage();
    }

    @AfterMethod
    public void tearDown() {
        threadDriver.get().quit();
        threadDriver.remove();
    }

    public void navigateToPage() {
        driver.get(url);
    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        /*DesiredCapabilities caps = new DesiredCapabilities();*/
        String gridURL = "http://localhost:4444";

        switch(browser) {
            case "firefox":
            WebDriverManager.firefoxdriver().setup();
            return driver = new FirefoxDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();

            case "grid-firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                return new RemoteWebDriver(URI.create(gridURL).toURL(), firefoxOptions);
            case "grid-safari":
                SafariOptions safariOptions = new SafariOptions();
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), safariOptions);
            case "grid-chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), chromeOptions);
            case "cloud-chrome":
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver();
        }
    }

    public static WebDriver lambdaTest() throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("dev");
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", "anitasurewicz");
        ltOptions.put("accessKey", "LT_hgaVN9YiSNM7rbc57cCQcJn6pf2JDbn3rO5bOT0vilgDCZs");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);

    }

}