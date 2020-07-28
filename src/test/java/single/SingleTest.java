package single;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

public class SingleTest {
    public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME"); // OR String USERNAME =
                                                                                  // "<browserstack-username>"
    public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_KEY");// OR String AUTOMATE_KEY =
                                                                                // "<browserstack-accesskey>"
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    DesiredCapabilities caps;
    WebDriver driver;
    WebElement element;

    @Test
    public void testSearchBrowserStack() throws MalformedURLException {
        open_Browser();
        search_for_BrowserStack();
        check_page_title();
    }

    public void open_Browser() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "75.0");
        caps.setCapability("build", "TestNG Example");
        caps.setCapability("name", "single_test");
        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    public void search_for_BrowserStack() {
        driver.get("http://www.google.com");
        element = driver.findElement(By.name("q"));
        element.sendKeys("BrowserStack");
        element.submit();
    }

    public void check_page_title() {
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
