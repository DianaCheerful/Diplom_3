package object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constant.TestConstants.VALUE_ATTRIBUTE;


public class ProfilePageObject {

    private final WebDriver driver;

    private final By profileHeader = By.xpath("//a[text() = 'Профиль']");
    private final By logoutHeader = By.xpath("//button[text() = 'Выход']");
    private final By loginInput = By.xpath("//label[text() = 'Логин']/parent::div/input");
    private final By constructorTab = By.xpath("//p[text() = 'Конструктор']");
    private final By stellarBurgerLogo = By.xpath("//div[@class = 'AppHeader_header__logo__2D0X2']/a");


    public ProfilePageObject(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Wait for the login header")
    public void waitLoginField() {
        new WebDriverWait(driver, 5).until(driver -> driver.findElement(loginInput).isDisplayed());
    }

    @Step("Get text from the login input field")
    public String getLoginValue() {
        return driver.findElement(loginInput).getAttribute(VALUE_ATTRIBUTE);
    }

    @Step("Wait for the profile header")
    public void waitProfileHeader() {
        new WebDriverWait(driver, 5).until(driver -> driver.findElement(profileHeader).isDisplayed());
    }

    @Step("Open constructor tab")
    public void openConstructorTab() {
        driver.findElement(constructorTab).click();
    }

    @Step("Click Stellar Burger logo")
    public void clickStellarBurgerLogo() {
        driver.findElement(stellarBurgerLogo).click();
    }

    @Step("Click logout")
    public void clickLogout() {
        new WebDriverWait(driver, 10).until(driver -> driver.findElement(logoutHeader).isDisplayed());
        driver.findElement(logoutHeader).click();
    }


}