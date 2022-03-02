package admin.Pages;

import com.codeborne.selenide.Condition;

public class AuthorizationPage extends AllPages {

    public void setRegisteredAdminEmail () {
        email_field.setValue(REGISTERED_ADMIN_EMAIL);
    }

    public void setRegisteredDryCleanerUserEmail () {
        email_field.setValue(REGISTERED_DRY_CLEANER_EMAIL);
    }

    public void setRegisteredSupportUserEmail () {
        email_field.setValue(REGISTERED_SUPPORT_EMAIL);
    }

    public void setRegisteredPassword () {
        password_field.setValue(REGISTERED_PASSWORD);
    }

    public void setNonRegisteredEmail () {
        email_field.setValue(NON_REGISTERED_EMAIL);
    }

    public void setNonRegisteredPassword () {
        password_field.setValue(NON_REGISTERED_PASSWORD);
    }

    public void clickLoginButton () {
        login_button.click();
    }

    public void logout() {
        logout_button.click();
    }

    public void checkSignOutButtonVisible() {
        logout_button.shouldBe(Condition.visible);
    }

    public void checkAuthorizationPageOpened() {
        email_field.shouldBe(Condition.visible);
        password_field.shouldBe(Condition.visible);
    }

    public void checkAuthorizationSuccessMessage() {
        success_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(AUTHORIZATION_SUCCESS_MESSAGE));
    }

    public void checkSuccessLogoutMessage() {
        success_logout_message.shouldBe(Condition.visible);
        success_logout_message.should(Condition.exactText(LOGOUT_SUCCESS_MESSAGE));
    }

    public void checkNonRegisteredErrorMessage() {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(NON_REGISTERED_CREDENTIALS_ERROR));
    }
}


