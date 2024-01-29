package sl;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


import static factory.DriverFactory.newChromeDriver;
public class BaseScript {
    public String baseURL = "https://purchase-testing.klimber.com/ar/GroupLife/Index";
    protected WebDriver driver;

    @BeforeClass
    public void initDriver() {
        driver = newChromeDriver();
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }

    public static void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
