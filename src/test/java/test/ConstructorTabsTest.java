package test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstructorTabsTest extends BaseTest {

    @Test
    @DisplayName("Constructor buns tab test")
    @Description("Should open buns tab")
    public void shouldOpenBunsTab() {
        mainPageObject.openBunsTab();
        assertEquals("Buns tab should be selected", true, mainPageObject.isBunsTabSelected());
    }

    @Test
    @DisplayName("Constructor sauces tab test")
    @Description("Should open sauces tab")
    public void shouldOpenSaucesTab() {
        mainPageObject.openSaucesTab();
        assertEquals("Sauces tab should be selected", true, mainPageObject.isSaucesTabSelected());
    }

    @Test
    @DisplayName("Constructor fillings tab test")
    @Description("Should open fillings tab")
    public void shouldOpenFillingsTab() {
        mainPageObject.openFillingsTab();
        assertEquals("Fillings tab should be selected", true, mainPageObject.isFillingsTabSelected());
    }
}