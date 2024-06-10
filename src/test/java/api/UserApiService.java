package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import model.User;
import org.apache.http.protocol.HTTP;

import static constant.TestConstants.*;
import static io.restassured.RestAssured.given;

public class UserApiService {

    @Step("Send POST-request /api/auth/register")
    public static Response createUser(User user) {
        return given()
                .header(HTTP.CONTENT_TYPE, JSON_TYPE)
                .body(new User(user.getEmail(), user.getPassword(), user.getName()))
                .post(CREATE_USER_METHOD);
    }

    @Step("Send POST-request /api/auth/login to login user")
    public static Response loginUser(User user) {
        return given()
                .header(HTTP.CONTENT_TYPE, JSON_TYPE)
                .body(new User(user.getEmail(), user.getPassword()))
                .post(LOGIN_USER_METHOD);
    }

    @Step("Send DELETE-request /api/auth/user to delete user")
    public static void deleteUser(String accessToken) {
        given()
                .header(AUTHORIZATION_HEADER, accessToken)
                .delete(EDIT_USER_METHOD);
    }

    @Step("Get accessToken from user created response")
    public static String getAccessToken(Response response) {
        return response.body().as(UserResponse.class).getAccessToken();
    }

}