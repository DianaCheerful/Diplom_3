package object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constant.TestConstants.VALUE_ATTRIBUTE;


public class ProfilePageObject {

    private final WebDriver driver;

    private final By profileHeader = By.xpath("//a[text() = 'Профиль']");

    public ProfilePageObject(WebDriver driver) {
        this.driver = driver;
    }



    @Step("Wait for the profile header")
    public void waitProfileHeader() {
        new WebDriverWait(driver, 5).until(driver -> driver.findElement(profileHeader).isDisplayed());
    }

}