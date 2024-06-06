package object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPageObject {

    private final WebDriver driver;

    private final By profileLink = By.xpath("//p[text() = 'Личный Кабинет']");
    private final By loginButton = By.xpath("//button[text() = 'Войти в аккаунт']");

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


}