package admin.API;

import admin.TestData;

public class TestDataAPI extends TestData {
    public final String BASE_URL = "http://thisiscercle.herokuapp.com/admin";

    // Cookies
    public final String BACKEND_SESSION_COOKIE_NAME = "_cercle_backend_session";
    public final String GUEST_TOKEN_COOKIE_NAME = "guest_token";

    // HTML response elements
    public final String AUTHORIZATION_FAILURE_REDIRECT = "<html><body>You are being <a href=\"http://thisiscercle.herokuapp.com/admin/authorization_failure\">redirected</a>.</body></html>";
}
