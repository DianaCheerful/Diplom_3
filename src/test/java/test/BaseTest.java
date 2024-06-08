package test;

import driver.WebDriverConfiguration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;
import object.MainPageObject;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static constant.TestConstants.STELLAR_BURGER_URL;
import static constant.TestConstants.WebDriverType.CHROME;
import static constant.UserData.*;

public class BaseTest {

    private static WebDriver driver;
    protected Response responseWithToken;

    public BaseTest(User user) {
        this.user = user;
    }
    public BaseTest() {
    }

    protected User user;
    protected static MainPageObject mainPageObject;

    public static WebDriver getWebdriver() {
        return driver;
    }

    @BeforeClass
    public static void initSettings() {
        RestAssured.baseURI = STELLAR_BURGER_URL;
        driver = WebDriverConfiguration.setDriver(CHROME);
        mainPageObject = new MainPageObject(driver);
    }
    @Before
    public void start(){
        driver.get(STELLAR_BURGER_URL);
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }

    @Parameterized.Parameters
    public static Object[][] getUser() {
        return new Object[][]{
                {new User(USER_1.getEmail(), USER_1.getPassword(), USER_1.getName())},
                {new User(USER_2.getEmail(), USER_2.getPassword(), USER_2.getName())},
                {new User(USER_3.getEmail(), USER_3.getPassword(), USER_3.getName())}
        };
    }
}