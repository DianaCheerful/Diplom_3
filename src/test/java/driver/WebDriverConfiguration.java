package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static constant.TestConstants.*;
import static constant.TestConstants.WebDriverType.YANDEX;

public class WebDriverConfiguration extends ExternalResource {

    public static WebDriver setDriver(WebDriverType webDriver) {
        if (webDriver == YANDEX) {
            return setYandex();
        } else {
            return setChrome();
        }
    }

    private static ChromeDriver setChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(new ChromeOptions());
    }

    private static ChromeDriver setYandex() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setBinary(System.getProperty(BIN_PROPERTY_NAME));
        options.setCapability(BROWSER_PROPERTY_NAME, System.getProperty(BROWSER_PROPERTY_NAME));
        options.setCapability(VERSION_PROPERTY_NAME, System.getProperty(VERSION_PROPERTY_NAME));
        return new ChromeDriver(options);
    }
}