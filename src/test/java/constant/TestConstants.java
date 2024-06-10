package constant;

public class TestConstants {

    public static final String STELLAR_BURGER_URL = "https://stellarburgers.nomoreparties.site";
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    public static final String PROFILE_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    public static final String JS_CLICK_SCRIPT = "arguments[0].click();";
    public static final String BIN_PROPERTY_NAME = "webdriver.yandex.bin";
    public static final String BROWSER_PROPERTY_NAME = "browser";
    public static final String VERSION_PROPERTY_NAME = "version";


    public enum WebDriverType {
        CHROME,
        YANDEX
    }

    public static final String CREATE_USER_METHOD = "/api/auth/register";
    public static final String EDIT_USER_METHOD = "/api/auth/user";
    public static final String LOGIN_USER_METHOD = "/api/auth/login";
    public static final String JSON_TYPE = "application/json";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String VALUE_ATTRIBUTE = "value";
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String SELECTED_TAB_VALUE = "current";
    public static final String INCORRECT_PASSWORD = "1234";
}
