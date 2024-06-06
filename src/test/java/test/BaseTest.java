package test;

import driver.WebDriverConfiguration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;
import object.MainPageObject;
import object.RegistrationPageObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static constant.TestConstants.STELLAR_BURGER_URL;
import static constant.TestConstants.WebDriverType.*;
import static constant.UserData.*;

public class BaseTest {

    private static WebDriver driver;

    public BaseTest(User user) {
        this.user = user;
    }

    protected User user;
    protected static MainPageObject mainPageObject;
    public static WebDriver getWebdriver() {
        return driver;
    }

    @BeforeClass
    public static void initSettings() {
        RestAssured.baseURI = STELLAR_BURGER_URL;
        driver = WebDriverConfiguration.setDriver(FIREFOX);
        driver.get(STELLAR_BURGER_URL);
        mainPageObject = new MainPageObject(driver);
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }

    @Parameterized.Parameters
    public static Object[][] getUser() {
        return new Object[][]{
                {new User(USER_1.getName(), USER_1.getEmail(), USER_1.getPassword())},
                {new User(USER_2.getEmail(), USER_2.getPassword(), USER_2.getName())},
                {new User(USER_3.getEmail(), USER_3.getPassword(), USER_3.getName())}
        };
    }
}