package object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static constant.TestConstants.JS_CLICK_SCRIPT;


public class MainPageObject {

    private final WebDriver driver;

    private final By profileLink = By.xpath("//p[text() = 'Личный Кабинет']");
    private final By loginButton = By.xpath("//button[text() = 'Войти в аккаунт']");
    private final By constructorTab = By.xpath("//p[text() = 'Конструктор']");
    private final By bunsTab = By.xpath("//span[text() = 'Булки']");
    private final By saucesTab = By.xpath("//*[text() = 'Соусы']");
    private final By fillingsTab = By.xpath("//*[text() = 'Начинки']");
    private final By bunsHeader = By.xpath("//h2[text() = 'Булки']");
    private final By saucesHeader = By.xpath("//h2[text() = 'Соусы']");
    private final By fillingsHeader = By.xpath("//h2[text() = 'Начинки']");

    public MainPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open personal cabinet")
    public void openProfile() {
        driver.findElement(profileLink).click();
    }

    @Step("Open login page by login button")
    public void openLoginPageByLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Open constructor tab")
    public void openConstructorTab() {
        driver.findElement(constructorTab).click();
    }

    @Step("Open buns tab")
    public void openBunsTab() {
        ((JavascriptExecutor) driver).executeScript(JS_CLICK_SCRIPT, driver.findElement(bunsTab));
    }

    @Step("Open buns tab")
    public void openSaucesTab() {
        ((JavascriptExecutor) driver).executeScript(JS_CLICK_SCRIPT, driver.findElement(saucesTab));
    }

    @Step("Open fillings tab")
    public void openFillingsTab() {
        ((JavascriptExecutor) driver).executeScript(JS_CLICK_SCRIPT, driver.findElement(fillingsTab));
    }

    @Step("Is buns tab")
    public Boolean isBunsHeaderVisible() {
        return driver.findElement(bunsHeader).isDisplayed();
    }

    @Step("Is sauces tab")
    public Boolean isSaucesHeaderVisible() {
        return driver.findElement(saucesHeader).isDisplayed();
    }

    @Step("Is fillings tab")
    public Boolean isFillingsHeaderVisible() {
        return driver.findElement(fillingsHeader).isDisplayed();
    }

}