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


    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Wait for the login page loading")
    public void waitLoginPage() {
        new WebDriverWait(driver, 5).until(driver -> driver.findElement(loginButton).isDisplayed());
    }

}