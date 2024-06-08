package object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RestorePasswordPageObject {

    private final WebDriver driver;

    private final By login = By.xpath("//a[text() = 'Войти']");


    public RestorePasswordPageObject(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Press login button")
    public void pressLogin() {
        driver.findElement(login).click();
    }
}