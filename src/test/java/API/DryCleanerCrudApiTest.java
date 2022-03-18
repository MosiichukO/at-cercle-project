package API;

import com.codeborne.selenide.WebDriverRunner;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DryCleanerCrudApiTest extends ApiMethodsBase {

    @Test
    @Tag("C3463")
    @DisplayName("Dry cleaner user doesn't have access to POST /admin/dry_cleaners")
    public void dryCleanerUserCanNotCreateDryCleaner () {
        getAdminLoginPage();
        dryCleanerUserAuthorization();
        getDryCleanersPage();

        Response createDryCleaner = given ()
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
                .log().all()
                .post()
                .then()
                .log().all()
                .extract()
                .response();

        checkAuthorizationFailureRedirect(createDryCleaner);
    }

    @Test
    @Tag("C3464")
    @DisplayName("Support user doesn't have access to POST /admin/dry_cleaners")
    public void supportUserCanNotCreateDryCleaner () {
        getAdminLoginPage();
        supportUserAuthorization();
        getOrdersPage();

        Response createDryCleaner = given ()
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
                .post()
                .then()
                .extract()
                .response();

        checkAuthorizationFailureRedirect(createDryCleaner);
    }

    @AfterEach
    public void closeDriver() {
        WebDriverRunner.driver().close();
    }
}
