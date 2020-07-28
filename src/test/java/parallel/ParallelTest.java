package parallel;

import org.testng.annotations.Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ParallelTest {

    WebDriver driver;
    WebElement element;
    public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_KEY");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void testGoogleSearchBrowserStackChrome() throws MalformedURLException {
        open_Chrome();
        search_for_BrowserStack();
        display_Title();
    }

    @Test
    public void testGoogleSearchBrowserStackFirefox() throws MalformedURLException {
        open_Firefox();
        search_for_BrowserStack();
        display_Title();
    }

    @Test
    public void testGoogleSearchBrowserStackSafari() throws MalformedURLException {
        open_Safari();
        search_for_BrowserStack();
        display_Title();
    }

    public void open_Chrome() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "76.0");
        caps.setCapability("build", "TestNG Example");
        caps.setCapability("name", "parallel_test");

        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    public void open_Firefox() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Firefox");
        caps.setCapability("browser_version", "70.0");
        caps.setCapability("build", "TestNG Example");
        caps.setCapability("name", "parallel_test");

        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    public void open_Safari() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "Mojave");
        caps.setCapability("browser", "Safari");
        caps.setCapability("browser_version", "12.0");
        caps.setCapability("build", "TestNG Example");
        caps.setCapability("name", "parallel_test");

        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    public void search_for_BrowserStack() {
        driver.get("https://www.google.co.in/");
        element = driver.findElement(By.name("q"));
        element.sendKeys("BrowserStack", Keys.ENTER);
    }

    public void display_Title() {
        String title = driver.getTitle();
        System.out.println(title);
        driver.quit();
    }

}
