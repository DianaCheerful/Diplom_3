package constant;

public class TestConstants {

    public static final String STELLAR_BURGER_URL = "https://stellarburgers.nomoreparties.site";
    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    public static final String PROFILE_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";


    public enum WebDriverType {
        CHROME,
        FIREFOX
    }

    public static final String CREATE_USER_METHOD = "/api/auth/register";
    public static final String EDIT_USER_METHOD = "/api/auth/user";
    public static final String LOGIN_USER_METHOD = "/api/auth/login";
    public static final String JSON_TYPE = "application/json";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String VALUE_ATTRIBUTE = "value";
    public static final String INCORRECT_PASSWORD = "1234";
}
