package object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static constant.TestConstants.*;


public class MainPageObject {

    private final WebDriver driver;

    private final By profileLink = By.xpath("//p[text() = 'Личный Кабинет']");
    private final By loginButton = By.xpath("//button[text() = 'Войти в аккаунт']");
    private final By constructorTab = By.xpath("//p[text() = 'Конструктор']");
    private final By bunsTab = By.xpath("//span[text() = 'Булки']");
    private final By saucesTab = By.xpath("//*[text() = 'Соусы']");
    private final By fillingsTab = By.xpath("//*[text() = 'Начинки']");
    private final By bunsDiv = By.xpath("//span[text() = 'Булки']//parent::div");
    private final By saucesDiv = By.xpath("//span[text() = 'Соусы']//parent::div");
    private final By fillingsDiv = By.xpath("//span[text() = 'Начинки']//parent::div");

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
    private void openConstructorTab() {
        driver.findElement(constructorTab).click();
    }

    @Step("Open buns tab")
    public void openBunsTab() {
        openConstructorTab();
        if (isBunsTabSelected()) {
            openSaucesTab();
        }
        ((JavascriptExecutor) driver).executeScript(JS_CLICK_SCRIPT, driver.findElement(bunsTab));
    }

    @Step("Open buns tab")
    public void openSaucesTab() {
        openConstructorTab();
        if (isSaucesTabSelected()) {
            openBunsTab();
        }
        ((JavascriptExecutor) driver).executeScript(JS_CLICK_SCRIPT, driver.findElement(saucesTab));
    }

    @Step("Open fillings tab")
    public void openFillingsTab() {
        openConstructorTab();
        if (isFillingsTabSelected()) {
            openSaucesTab();
        }
        ((JavascriptExecutor) driver).executeScript(JS_CLICK_SCRIPT, driver.findElement(fillingsTab));
    }

    @Step("Is buns tab")
    public Boolean isBunsTabSelected() {
        return driver.findElement(bunsDiv).getAttribute(CLASS_ATTRIBUTE).contains(SELECTED_TAB_VALUE);
    }

    @Step("Is sauces tab")
    public Boolean isSaucesTabSelected() {
        return driver.findElement(saucesDiv).getAttribute(CLASS_ATTRIBUTE).contains(SELECTED_TAB_VALUE);
    }

    @Step("Is fillings tab")
    public Boolean isFillingsTabSelected() {
        return driver.findElement(fillingsDiv).getAttribute(CLASS_ATTRIBUTE).contains(SELECTED_TAB_VALUE);
    }

}