package admin.UI;


import admin.Pages.AuthorizationPage;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;


public class AuthorizationTest extends AuthorizationPage {

    @BeforeEach
    public void openURL() {
        openAdminLoginPage();
    }

    @Test @Order(1)
    @Tag("C2730")
    @DisplayName("Login with empty password")
    public void LoginEmptyPassword() {
        setRegisteredAdminEmail();
        clickLoginButton();
        checkNonRegisteredErrorMessage();
    }

    @Test @Order(2)
    @Tag("C2729")
    @DisplayName("Login with empty email")
    public void LoginEmptyEmail() {
        setRegisteredPassword();
        clickLoginButton();
        checkNonRegisteredErrorMessage();
    }

    @Test @Order(3)
    @Tag("C2730")
    @DisplayName("Login with valid email & invalid password")
    public void LoginValidEmailInvalidPassword() {
        setRegisteredAdminEmail();
        setNonRegisteredPassword();
        clickLoginButton();
        checkNonRegisteredErrorMessage();
    }

    @Test @Order(4)
    @Tag("C2729")
    @DisplayName("Login with invalid email & valid password")
    public void LoginInvalidEmailValidPassword() {
        setNonRegisteredEmail();
        setRegisteredPassword();
        clickLoginButton();
        checkNonRegisteredErrorMessage();
    }

    @Test @Order(5)
    @Tag("C2731")
    @DisplayName("Login with invalid credentials")
    public void LoginInvalidCredentials() {
        setNonRegisteredEmail();
        setNonRegisteredPassword();
        clickLoginButton();
        checkNonRegisteredErrorMessage();
    }

    @Test @Order(6)
    @Tag("C2726")
    @DisplayName("Login with valid Admin credentials")
    public void LoginValidCredentials() {
        setRegisteredAdminEmail();
        setRegisteredPassword();
        clickLoginButton();
        checkSignOutButtonVisible();
    }

    @Test @Order(7)
    @Tag("C3455")
    @DisplayName("Login with valid Dry Cleaner user credentials")
    public void LoginValidDryCleanerUserCredentials() {
        setRegisteredDryCleanerUserEmail();
        setRegisteredPassword();
        clickLoginButton();
        checkSignOutButtonVisible();
    }

    @Test @Order(8)
    @Tag("C3456")
    @DisplayName("Login with valid Support user credentials")
    public void LoginValidSupportUserCredentials() {
        setRegisteredSupportUserEmail();
        setRegisteredPassword();
        clickLoginButton();
        checkSignOutButtonVisible();
    }

    @Test @Order(9)
    @Tag("C3155")
    @DisplayName("Success login message")
    public void SuccessLoginMessage() {
        authorizationAdmin();
        checkAuthorizationSuccessMessage();
    }

    @Test @Order(10)
    @Tag("C3154")
    @DisplayName("Success logout message")
    public void SuccessLogoutMessage() {
        authorizationAdmin();
        logout();
        checkSuccessLogoutMessage();
    }

    @Test @Order(11)
    @Tag("C3453, C3454")
    @DisplayName("Sign out")
    public void SignOut() {
        authorizationAdmin();
        logout();
        checkAuthorizationPageOpened();
    }

    @AfterEach
    public void closeDriver() {
        WebDriverRunner.driver().close();
    }
}
