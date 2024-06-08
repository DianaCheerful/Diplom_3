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
import static constant.TestConstants.STELLAR_BURGER_URL;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class LoginTest extends BaseTest {

    public LoginTest(User user) {
        super(user);
    }

    private final LoginPageObject loginPageObject = new LoginPageObject(getWebdriver());
    private final ProfilePageObject profilePageObject = new ProfilePageObject(getWebdriver());
    private final RegistrationPageObject registrationPageObject = new RegistrationPageObject(getWebdriver());
    private final RestorePasswordPageObject restorePasswordPageObject = new RestorePasswordPageObject(getWebdriver());

    private Response responseWithToken;


    @Before
    public void init() {
        responseWithToken = createUser(user);
        getWebdriver().get(STELLAR_BURGER_URL);
    }

    @After
    public void finish() {
        profilePageObject.clickLogout();
        deleteUser(getAccessToken(responseWithToken));
    }

    @Test
    @DisplayName("Login test by login button")
    @Description("Should open login page and login")
    public void shouldLoginByLoginButton() {
        mainPageObject.openLoginPageByLoginButton();
        loginPageObject.login(user);
        mainPageObject.openProfile();
        profilePageObject.waitLoginField();
        assertEquals("Login field should have user email", user.getEmail(), profilePageObject.getLoginValue());
    }

    @Test
    @DisplayName("Login test by profile page link")
    @Description("Should open profile page and login")
    public void shouldLoginByProfileButton() {
        mainPageObject.openProfile();
        loginPageObject.login(user);
        mainPageObject.openProfile();
        profilePageObject.waitLoginField();
        assertEquals("Login field should have user email", user.getEmail(), profilePageObject.getLoginValue());
    }

    @Test
    @DisplayName("Login test by login link on registration page")
    @Description("Should open registration page and login")
    public void shouldLoginByRegistrationPage() {
        mainPageObject.openProfile();
        loginPageObject.pressRegisterButton();
        registrationPageObject.pressLogin();
        loginPageObject.login(user);
        mainPageObject.openProfile();
        profilePageObject.waitLoginField();
        assertEquals("Login field should have user email", user.getEmail(), profilePageObject.getLoginValue());
    }

    @Test
    @DisplayName("Login test by password restore link")
    @Description("Should open restore password page and login")
    public void shouldLoginByRestorePasswordLink() {
        mainPageObject.openProfile();
        loginPageObject.pressRestorePasswordButton();
        restorePasswordPageObject.pressLogin();
        loginPageObject.login(user);
        mainPageObject.openProfile();
        profilePageObject.waitLoginField();
        assertEquals("Login field should have user email", user.getEmail(), profilePageObject.getLoginValue());
    }

}