package driver;

import com.google.common.io.Resources;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.concurrent.BrokenBarrierException;

import static com.google.common.io.Resources.getResource;
import static constant.TestConstants.WebDriverType;
import static constant.TestConstants.WebDriverType.CHROME;
import static constant.TestConstants.YANDEX_BINARY;

public class WebDriverConfiguration extends ExternalResource {

    public static WebDriver setDriver(WebDriverType webDriver) {
        if (webDriver == CHROME) {
            return setChrome();
        } else {
            return setYandex();
        }
    }

    private static ChromeDriver setChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(new ChromeOptions());
    }

    private static ChromeDriver setYandex() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setBinary(YANDEX_BINARY);
        return new ChromeDriver(options);
    }
}