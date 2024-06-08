package test;


import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.User;
import object.LoginPageObject;
import object.ProfilePageObject;
import object.RegistrationPageObject;
import object.RestorePasswordPageObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static api.UserApiService.*;
import static constant.TestConstants.*;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ProfileTest extends BaseTest {

    public ProfileTest(User user) {
        super(user);
    }

    private final LoginPageObject loginPageObject = new LoginPageObject(getWebdriver());
    private final ProfilePageObject profilePageObject = new ProfilePageObject(getWebdriver());


    @Before
    public void init() {
        responseWithToken = createUser(user);
    }

    @After
    public void finish() {
        deleteUser(getAccessToken(responseWithToken));
    }


    @Test
    @DisplayName("Link test profile page link")
    @Description("Should open profile page from the main page")
    public void shouldOpenProfilePage() {
        mainPageObject.openProfile();
        loginPageObject.login(user);
        mainPageObject.openProfile();
        profilePageObject.waitProfileHeader();
        assertEquals("Pages urls should be the same", PROFILE_PAGE_URL, getWebdriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Link test constructor link")
    @Description("Should open main page constructor tab from the profile page")
    public void shouldOpenConstructorTab() {
        mainPageObject.openProfile();
        loginPageObject.login(user);
        mainPageObject.openProfile();
        profilePageObject.waitProfileHeader();
        profilePageObject.openConstructorTab();
        assertEquals("Pages urls should be the same", MAIN_PAGE_URL, getWebdriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Link test stellar burger login")
    @Description("Should open main page constructor tab from the profile page")
    public void shouldLinkStellarLogo() {
        mainPageObject.openProfile();
        loginPageObject.login(user);
        mainPageObject.openProfile();
        profilePageObject.waitProfileHeader();
        profilePageObject.clickStellarBurgerLogo();
        assertEquals("Pages urls should be the same", MAIN_PAGE_URL, getWebdriver().getCurrentUrl());
    }

}