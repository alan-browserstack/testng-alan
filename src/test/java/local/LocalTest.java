package local;

import org.testng.annotations.Test;

import com.browserstack.local.Local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LocalTest {
    public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_KEY");
    public static final String browserstackLocalIdentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    DesiredCapabilities caps;
    WebDriver driver;
    private static Local l;
    WebElement element;

    @Test
    public void testGoToLocalHost() throws Exception {
        open_Browser();
        go_to_localhost();
        retrieve_Title_if_Up_and_Running();
    }

    public void open_Browser() throws Exception {

        caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "75.0");
        caps.setCapability("build", "TestNG Example");
        caps.setCapability("name", "local_test");
        caps.setCapability("browserstack.local", "true");

        l = new Local();

        Map<String, String> options = new HashMap<String, String>();
        options.put("key", AUTOMATE_KEY);

        l.start(options);

        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    public void go_to_localhost() {
        driver.get("http://bs-local.com:45691/check");
    }

    public void retrieve_Title_if_Up_and_Running() throws Exception {
        System.out.println(driver.getTitle());
        driver.quit();
        if (l != null) {
            l.stop();
        }
        if (l != null)
            l.stop();
    }
}
