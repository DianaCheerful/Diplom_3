package object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPageObject {

    private final WebDriver driver;

    private final By personalCabinet = By.xpath("//p[text() = 'Личный Кабинет']");

    public MainPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open personal cabinet")
    public void openPersonalCabinet() {
        driver.findElement(personalCabinet).click();
    }


}