package test;


import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.User;
import object.LoginPageObject;
import object.RegistrationPageObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static api.UserApiService.*;
import static constant.TestConstants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


@RunWith(Parameterized.class)
public class RegistrationTest extends BaseTest {

    public RegistrationTest(User user) {
        super(user);
    }

    private final RegistrationPageObject registrationPageObject = new RegistrationPageObject(getWebdriver());
    private final LoginPageObject loginPageObject = new LoginPageObject(getWebdriver());


    @Before
    public void init() {
        getWebdriver().get(STELLAR_BURGER_URL);
    }

    @Test
    @DisplayName("Registration test")
    @Description("Should open login page after successful registration")
    public void shouldOpenLoginPageAfterSuccessRegistration() {
        mainPageObject.openProfile();
        registrationPageObject.registerUser(user.getName(), user.getEmail(), user.getPassword());
        loginPageObject.waitLoginPage();
        assertEquals("Pages urls should be the same", LOGIN_PAGE_URL, getWebdriver().getCurrentUrl());
        Response responseWithToken = loginUser(user);
        deleteUser(getAccessToken(responseWithToken));
    }

    @Test
    @DisplayName("Registration test with incorrect password")
    @Description("Should not register and show incorrect password error")
    public void shouldShowPasswordErrorAfterFailedRegistration() {
        mainPageObject.openProfile();
        registrationPageObject.registerUser(user.getName(), user.getEmail(), INCORRECT_PASSWORD);
        registrationPageObject.waitPasswordError();
        assertNotEquals("Pages urls should not be the same", LOGIN_PAGE_URL, getWebdriver().getCurrentUrl());
    }
}
