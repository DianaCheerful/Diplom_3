package test;

import driver.WebDriverConfiguration;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import object.MainPageObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static constant.TestConstants.STELLAR_BURGER_URL;
import static constant.TestConstants.WebDriverType.CHROME;
import static org.junit.Assert.assertEquals;

public class ConstructorTabsTest {

    private static WebDriver driver;

    protected static MainPageObject mainPageObject;


    @Before
    public void initSettings() {
        RestAssured.baseURI = STELLAR_BURGER_URL;
        driver = WebDriverConfiguration.setDriver(CHROME);
        driver.get(STELLAR_BURGER_URL);
        mainPageObject = new MainPageObject(driver);
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    @DisplayName("Constructor buns tab test")
    @Description("Should open buns tab")
    public void shouldOpenBunsTab() {
        mainPageObject.openConstructorTab();
        mainPageObject.openBunsTab();
        assertEquals("Buns header should be visible", true, mainPageObject.isBunsHeaderVisible());
    }

    @Test
    @DisplayName("Constructor sauces tab test")
    @Description("Should open sauces tab")
    public void shouldOpenSaucesTab() {
        mainPageObject.openConstructorTab();
        mainPageObject.openSaucesTab();
        assertEquals("Sauces header should be visible", true, mainPageObject.isSaucesHeaderVisible());
    }

    @Test
    @DisplayName("Constructor fillings tab test")
    @Description("Should open fillings tab")
    public void shouldOpenFillingsTab() {
        mainPageObject.openConstructorTab();
        mainPageObject.openFillingsTab();
        assertEquals("Fillings header should be visible", true, mainPageObject.isFillingsHeaderVisible());
    }
}