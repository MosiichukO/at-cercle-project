package API;

import admin.API.TestDataAPI;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Objects;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.restassured.RestAssured.given;

public class ApiMethodsBase extends TestDataAPI {

    public static String csrf_token;
    public static String backend_session_cookie;
    public static String guest_token;
    public static String test_dry_cleaner_id;

    public void getAdminLoginPage () {
        Response adminLoginPage = given()
                .baseUri(BASE_URL)
                .basePath("/login")
                .when()
                .get()
                .then()
                .extract()
                .response();

        setNewCsrfToken(adminLoginPage);
        setBackendSessionCookie(adminLoginPage);
        setGuestToken(adminLoginPage);
    }

    public void getOrdersPage () {
        Response dryCleanersPage = given()
                .baseUri(BASE_URL)
                .basePath("/orders")
                .cookie("_cercle_backend_session", backend_session_cookie)
                .cookie("guest_token", guest_token)
                .contentType(ContentType.URLENC)
                .when()
                .get()
                .then()
                .extract()
                .response();

        setNewCsrfToken(dryCleanersPage);
        setBackendSessionCookie(dryCleanersPage);
    }

    public void getDryCleanersPage () {
        Response dryCleanersPage = given()
                .baseUri(BASE_URL)
                .basePath("/dry_cleaners")
                .cookie("_cercle_backend_session", backend_session_cookie)
                .cookie("guest_token", guest_token)
                .contentType(ContentType.URLENC)
                .when()
                .get()
                .then()
                .extract()
                .response();

        setNewCsrfToken(dryCleanersPage);
        setBackendSessionCookie(dryCleanersPage);
    }

    public void adminAuthorization () {
        Response login = given()
                .baseUri(BASE_URL)
                .basePath("/login")
                .cookie("_cercle_backend_session", backend_session_cookie)
                .cookie("guest_token", guest_token)
                .contentType(ContentType.URLENC)
                .formParam("commit", "Login")
                .formParam("spree_user[email]", REGISTERED_ADMIN_EMAIL)
                .formParam("spree_user[password]", REGISTERED_PASSWORD)
                .formParam("spree_user[remember_me]", "0")
                .formParam("authenticity_token", csrf_token)
                .post()
                .then()
                .extract()
                .response();

        setBackendSessionCookie(login);
    }

    public void dryCleanerUserAuthorization () {
        Response login = given()
                .baseUri(BASE_URL)
                .basePath("/login")
                .cookie("_cercle_backend_session", backend_session_cookie)
                .cookie("guest_token", guest_token)
                .contentType(ContentType.URLENC)
                .formParam("commit", "Login")
                .formParam("spree_user[email]", REGISTERED_DRY_CLEANER_EMAIL)
                .formParam("spree_user[password]", REGISTERED_PASSWORD)
                .formParam("spree_user[remember_me]", "0")
                .formParam("authenticity_token", csrf_token)
                .post();

        setBackendSessionCookie(login);
    }

    public void supportUserAuthorization () {
        Response login = given()
                .baseUri(BASE_URL)
                .basePath("/login")
                .cookie("_cercle_backend_session", backend_session_cookie)
                .cookie("guest_token", guest_token)
                .contentType(ContentType.URLENC)
                .formParam("commit", "Login")
                .formParam("spree_user[email]", REGISTERED_SUPPORT_EMAIL)
                .formParam("spree_user[password]", REGISTERED_PASSWORD)
                .formParam("spree_user[remember_me]", "0")
                .formParam("authenticity_token", csrf_token)
                .post()
                .then()
                .extract()
                .response();

        setBackendSessionCookie(login);

    }

    public void postTestDryCleaner () {
        Response createTestDryCleaner = given()
                .baseUri(BASE_URL)
                .basePath("/dry_cleaners")
                .cookie(BACKEND_SESSION_COOKIE_NAME, backend_session_cookie)
                .cookie(GUEST_TOKEN_COOKIE_NAME, guest_token)
                .contentType(ContentType.URLENC)
                .formParam("commit", "Create")
                .formParam("dry_cleaner[name]", DRY_CLEANER_NAME)
                .formParam("dry_cleaner[address]", DRY_CLEANER_ADDRESS)
                .formParam("dry_cleaner[status]", "active")
                .formParam("authenticity_token", csrf_token)
                .post();

    }

    public void setNewCsrfToken (Response response) {
        csrf_token = response.htmlPath().getString("html.head.meta[3].@content");
    }

    public void setBackendSessionCookie (Response response) {
        backend_session_cookie = response.getCookie(BACKEND_SESSION_COOKIE_NAME);
    }

    public void setGuestToken (Response response) {
        guest_token = response.getCookie(GUEST_TOKEN_COOKIE_NAME);
    }

    public String getFlashErrorText (Response response) {
       return response.htmlPath().getString("**.findAll { it.@class == 'flash error' } [0]");
    }

    public String getPageTitle (Response response) {
        return response.htmlPath().getString("html.head.title");
    }

    public void checkAuthorizationFailureRedirect (Response response) {
        Assertions.assertEquals(AUTHORIZATION_FAILURE_REDIRECT, response.getBody().asString());
    }

    public void checkUserSessionsTitleHtml (Response response) {
        Assertions.assertEquals(AUTHORIZATION_PAGE_TITLE, response.htmlPath().getString("html.head.title"));

    }
}
