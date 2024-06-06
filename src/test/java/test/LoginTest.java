package test;


import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.User;
import object.LoginPageObject;
import object.ProfilePageObject;
import object.RegistrationPageObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static api.UserApiService.*;
import static constant.TestConstants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


@RunWith(Parameterized.class)
public class LoginTest extends BaseTest {

    public LoginTest(User user) {
        super(user);
    }

    private final LoginPageObject loginPageObject = new LoginPageObject(getWebdriver());
    private final ProfilePageObject profilePageObject = new ProfilePageObject(getWebdriver());

    private Response responseWithToken;


    @Before
    public void init(){
        responseWithToken = createUser(user);
    }
    @After
    public void finish(){
        deleteUser(getAccessToken(responseWithToken));
    }

    @Test
    @DisplayName("Login test by login button")
    @Description("Should open login page and login")
    public void shouldOpenLoginPageAndLogin() {
        mainPageObject.openLoginPageByLoginButton();
        loginPageObject.login(user);
        mainPageObject.openProfile();
        profilePageObject.waitProfileHeader();
        assertEquals("Pages urls should be the same", PROFILE_PAGE_URL, getWebdriver().getCurrentUrl());
    }


}
