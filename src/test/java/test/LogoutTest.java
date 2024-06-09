package test;


import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.User;
import object.LoginPageObject;
import object.ProfilePageObject;
import object.RestorePasswordPageObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static api.UserApiService.*;
import static constant.TestConstants.LOGIN_PAGE_URL;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class LogoutTest extends BaseTest {

    public LogoutTest(User user) {
        super(user);
    }

    private final LoginPageObject loginPageObject = new LoginPageObject(getWebdriver());
    private final ProfilePageObject profilePageObject = new ProfilePageObject(getWebdriver());
    private final RestorePasswordPageObject restorePasswordPageObject = new RestorePasswordPageObject(getWebdriver());


    @Before
    public void init() {
        responseWithToken = createUser(user);
    }

    @After
    public void finish() {
        deleteUser(getAccessToken(responseWithToken));
    }

    @Test
    @DisplayName("Logout test")
    @Description("Should logout")
    public void shouldLogout() {
        mainPageObject.openLoginPageByLoginButton();
        loginPageObject.pressRestorePasswordButton();
        restorePasswordPageObject.pressLogin();
        loginPageObject.login(user);
        mainPageObject.openProfile();
        profilePageObject.clickLogout();
        loginPageObject.waitLoginPage();
        assertEquals("Pages urls should be the same", LOGIN_PAGE_URL, getWebdriver().getCurrentUrl());
    }

}