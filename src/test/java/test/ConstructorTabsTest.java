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
        mainPageObject.openConstructorTab();
        mainPageObject.openBunsTab();
        assertEquals("Buns header should be visible", true, mainPageObject.isBunsHeaderVisible());
    }

    @Test
    @DisplayName("Constructor sauces tab test")
    @Description("Should open sauces tab")
    public void shouldOpenSaucesTab() {
        mainPageObject.openConstructorTab();
        mainPageObject.openSaucesTab();
        assertEquals("Sauces header should be visible", true, mainPageObject.isSaucesHeaderVisible());
    }

    @Test
    @DisplayName("Constructor fillings tab test")
    @Description("Should open fillings tab")
    public void shouldOpenFillingsTab() {
        mainPageObject.openConstructorTab();
        mainPageObject.openFillingsTab();
        assertEquals("Fillings header should be visible", true, mainPageObject.isFillingsHeaderVisible());
    }
}