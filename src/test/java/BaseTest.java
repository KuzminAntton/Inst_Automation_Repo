import logger.MainLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest extends Assert {

    private static String driverPath = "driver/";
    public static ChromeDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterSuite
    public void finishMessage() {
        MainLogger.getLogger().info("Finished tests");
    }

}
