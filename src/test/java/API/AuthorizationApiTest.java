package API;

import com.codeborne.selenide.WebDriverRunner;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

public class AuthorizationApiTest extends ApiMethodsBase {

    @BeforeEach
    public void getLoginPage () {
        getAdminLoginPage();
    }

    @Test
    @Tag("C3449")
    @DisplayName("Email parameter is required for authorization")
    public void emailParameterIsRequiredForAuthorization () {

        Response loginWithoutEmail = given()
                .baseUri(BASE_URL)
                .basePath("/login")
                .cookie("_cercle_backend_session", backend_session_cookie)
                .cookie("guest_token", guest_token)
                .contentType(ContentType.URLENC)
                    .formParam("commit", "Login")
                    .formParam("spree_user[password]", REGISTERED_PASSWORD)
                    .formParam("spree_user[remember_me]", "0")
                    .formParam("authenticity_token", csrf_token)
                .post()
                .then()
                .extract()
                .response();

        Assertions.assertEquals("Invalid email or password.", getFlashErrorText(loginWithoutEmail));

        Assertions.assertEquals(AUTHORIZATION_PAGE_TITLE, getPageTitle(loginWithoutEmail));
    }

    @Test
    @Tag("C3450")
    @DisplayName("Password parameter is required for authorization")
    public void passwordParameterIsRequiredForAuthorization () {

        Response loginWithoutEmail = given()
                .baseUri(BASE_URL)
                .basePath("/login")
                .cookie("_cercle_backend_session", backend_session_cookie)
                .cookie("guest_token", guest_token)
                .contentType(ContentType.URLENC)
                .formParam("commit", "Login")
                .formParam("spree_user[email]", REGISTERED_ADMIN_EMAIL)
                .formParam("spree_user[remember_me]", "0")
                .formParam("authenticity_token", csrf_token)
                .post()
                .then()
                .extract()
                .response();

        Assertions.assertEquals("Invalid email or password.", getFlashErrorText(loginWithoutEmail));

        Assertions.assertEquals(AUTHORIZATION_PAGE_TITLE, getPageTitle(loginWithoutEmail));
    }

    @AfterEach
    public void closeDriver() {
        WebDriverRunner.driver().close();
    }
}
