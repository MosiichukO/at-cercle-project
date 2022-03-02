package admin.Pages;

import admin.Locators;

import static com.codeborne.selenide.Selenide.open;
import static core.Config.ADMIN_AUTH_URL;

public class AllPages extends Locators {

    public void openAdminLoginPage () {
        open(ADMIN_AUTH_URL);
    }

    public void authorizationAdmin () {
        email_field.setValue(REGISTERED_ADMIN_EMAIL);
        password_field.setValue(REGISTERED_PASSWORD);
        login_button.click();
    }

    public void authorizationDryCleanerUser () {
        email_field.setValue(REGISTERED_DRY_CLEANER_EMAIL);
        password_field.setValue(REGISTERED_PASSWORD);
        login_button.click();
    }

    public void authorizationSupportUser () {
        email_field.setValue(REGISTERED_SUPPORT_EMAIL);
        password_field.setValue(REGISTERED_PASSWORD);
        login_button.click();
    }
}
