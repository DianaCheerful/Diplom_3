package object;

import io.qameta.allure.Step;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constant.TestConstants.VALUE_ATTRIBUTE;


public class RegistrationPageObject {

    private final WebDriver driver;

    private final By registerLink = By.xpath("//a[text() = 'Зарегистрироваться']");
    private final By nameInput = By.xpath("//label[text() = 'Имя']/parent::div/input");
    private final By emailInput = By.xpath("//label[text() = 'Email']/parent::div/input");
    private final By passwordInput = By.xpath("//label[text() = 'Пароль']/parent::div/input");
    private final By registerButton = By.xpath("//button[text() = 'Зарегистрироваться']");
    private final By passwordError = By.xpath("//p[text() = 'Некорректный пароль']");

    public RegistrationPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void registerUser(String name, String email, String password) {
        openRegistrationPage();
        fillUserName(name);
        fillUserEmail(email);
        fillUserPassword(password);
        pressRegisterButton();
    }

    @Step("Open registration page https://stellarburgers.nomoreparties.site/register by button click")
    public void openRegistrationPage() {
        driver.findElement(registerLink).click();
    }

    @Step("Fill user name for registration")
    public void fillUserName(String name) {
        driver.findElement(nameInput).sendKeys(name);
        new WebDriverWait(driver, 3).until(driver ->
                driver.findElement(nameInput).getAttribute(VALUE_ATTRIBUTE).equals(name));
    }

    @Step("Fill user email for registration")
    public void fillUserEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
        new WebDriverWait(driver, 3).until(driver ->
                driver.findElement(emailInput).getAttribute(VALUE_ATTRIBUTE).equals(email));
    }

    @Step("Fill user email for registration")
    public void fillUserPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        new WebDriverWait(driver, 3).until(driver ->
                driver.findElement(passwordInput).getAttribute(VALUE_ATTRIBUTE).equals(password));
    }

    @Step("Press register button")
    public void pressRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Wait for the incorrect password error")
    public void waitPasswordError() {
        new WebDriverWait(driver, 3).until(driver -> driver.findElement(passwordError).isDisplayed());
    }

}