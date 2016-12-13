import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Config;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public final static String URL = Config.getProperty("baseUrl");
    public final String BROWSER = Config.getProperty("driver");
    public final String TIMEOUT = Config.getProperty("timeout");
    WebDriver driver;

    public WebDriver getDriver () {
        if (BROWSER.equals("firefox")) return new FirefoxDriver();
        if (BROWSER.equals("chrome")) return new ChromeDriver();
        return new ChromeDriver();
    }

    @AfterMethod
    public void tearDown () {
        driver.quit();
    }

    @BeforeMethod
    public void preConfig () {
        System.setProperty("webdriver.gecko.driver", "C:\\pr\\gecko\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\pr\\cd\\chromedriver.exe");
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(TIMEOUT), TimeUnit.SECONDS);
        driver.get(BaseTest.URL);
        driver.manage().window().maximize();
    }
}
