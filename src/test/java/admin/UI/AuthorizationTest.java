package admin.UI;


import admin.AuthorizationPage;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static core.Config.ADMIN_AUTH_URL;

public class AuthorizationTest extends AuthorizationPage {

    private final String INVALID_EMAIL = "qa@invalid.com";
    private final String INVALID_PASSWORD = "invalid12";
    private final String VALID_CLEANER_EMAIL = "qa@cleaner.com";
    private final String VALID_SUPPORT_EMAIL = "qa@support.com";
    private final String INVALID_CREDENTIALS_ERROR = "Invalid email or password.";


    @BeforeEach
    public void openURL() {
        open(ADMIN_AUTH_URL);
    }

    @Test
    @Tag("C2730")
    @DisplayName("Login with empty password")
    public void LoginEmptyPassword() {
        authorization(VALID_EMAIL, "");
        checkErrorMessage(INVALID_CREDENTIALS_ERROR);
    }

    @Test
    @Tag("C2729")
    @DisplayName("Login with empty email")
    public void LoginEmptyEmail() {
        authorization("", VALID_PASSWORD);
        checkErrorMessage(INVALID_CREDENTIALS_ERROR);
    }

    @Test
    @Tag("C2730")
    @DisplayName("Login with valid email & invalid password")
    public void LoginValidEmailInvalidPassword() {
        authorization(VALID_EMAIL, INVALID_PASSWORD);
        checkErrorMessage(INVALID_CREDENTIALS_ERROR);
    }

    @Test
    @Tag("C2729")
    @DisplayName("Login with invalid email & valid password")
    public void LoginInvalidEmailValidPassword() {
        authorization(INVALID_EMAIL, VALID_PASSWORD);
        checkErrorMessage(INVALID_CREDENTIALS_ERROR);
    }

    @Test
    @Tag("C2731")
    @DisplayName("Login with invalid credentials")
    public void LoginInvalidCredentials() {
        authorization(INVALID_EMAIL, INVALID_PASSWORD);
        checkErrorMessage(INVALID_CREDENTIALS_ERROR);
    }

    @Test
    @Tag("C2726")
    @DisplayName("Login with valid Admin credentials")
    public void LoginValidCredentials() {
        authorization(VALID_EMAIL, VALID_PASSWORD);
        checkSignOutButtonVisible();
    }

    @Test
    @Tag("C3455")
    @DisplayName("Login with valid Dry Cleaner user credentials")
    public void LoginValidDryCleanerUserCredentials() {
        authorization(VALID_CLEANER_EMAIL, VALID_PASSWORD);
        checkSignOutButtonVisible();
    }

    @Test
    @Tag("C3456")
    @DisplayName("Login with valid Support user credentials")
    public void LoginValidSupportUserCredentials() {
        authorization(VALID_SUPPORT_EMAIL, VALID_PASSWORD);
        checkSignOutButtonVisible();
    }

    @Test
    @Tag("C3155")
    @DisplayName("Success login message")
    public void SuccessLoginMessage() {
        authorization(VALID_EMAIL, VALID_PASSWORD);
        checkSuccessMessage("Logged in successfully");
    }

    @Test
    @Tag("C3154")
    @DisplayName("Success logout message")
    public void SuccessLogoutMessage() {
        authorization(VALID_EMAIL, VALID_PASSWORD);
        logout();
        checkSuccessLogoutMessage();
    }

    @Test
    @Tag("C3453, C3454")
    @DisplayName("Sign out")
    public void SignOut() {
        authorization(VALID_EMAIL, VALID_PASSWORD);
        logout();
        checkAuthorizationPageOpened();
    }

    @AfterEach
    public void closeDriver() {
        WebDriverRunner.driver().close();
    }
}
