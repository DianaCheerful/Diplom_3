package object;

import io.qameta.allure.Step;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constant.TestConstants.VALUE_ATTRIBUTE;


public class LoginPageObject {

    private final WebDriver driver;

    private final By emailInput = By.xpath("//label[text() = 'Email']/parent::div/input");
    private final By passwordInput = By.xpath("//label[text() = 'Пароль']/parent::div/input");
    private final By loginButton = By.xpath("//button[text() = 'Войти']");
    private final By register = By.xpath("//a[text() = 'Зарегистрироваться']");
    private final By restorePassword = By.xpath("//a[text() = 'Восстановить пароль']");


    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void login(User user) {
        waitLoginPage();
        fillUserEmail(user.getEmail());
        fillUserPassword(user.getPassword());
        pressLoginButton();
    }

    @Step("Wait for the login page loading")
    public void waitLoginPage() {
        new WebDriverWait(driver, 5).until(driver -> driver.findElement(loginButton).isDisplayed());
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

    @Step("Press login button")
    public void pressLoginButton() {
        new WebDriverWait(driver, 5).until(driver ->
                driver.findElement(loginButton).isDisplayed());
        driver.findElement(loginButton).click();
    }

    @Step("Press register button")
    public void pressRegisterButton() {
        driver.findElement(register).click();
    }

    @Step("Press restore password button")
    public void pressRestorePasswordButton() {
        driver.findElement(restorePassword).click();
    }
}