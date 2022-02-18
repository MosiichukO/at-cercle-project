package admin;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage {

    public SelenideElement email_field = $("#spree_user_email");
    public SelenideElement password_field = $("#spree_user_password");
    public SelenideElement login_button = $(".btn.btn-primary");
    public SelenideElement error_message = $(".flash.error");
    public SelenideElement logout_button = $(".fa.fa-sign-out");
    public SelenideElement success_login_message = $(".flash.success");
    public SelenideElement success_logout_message = $(".flash.notice");

    public final String VALID_EMAIL = "qa@admin.com";
    public final String VALID_PASSWORD = "qa1234";

    public void checkErrorMessage(String error) {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(error));
    }

    public void authorization(String email, String password) {
        email_field.setValue(email);
        password_field.setValue(password);
        login_button.click();
    }

    public void checkSignOutButtonVisible() {
        logout_button.shouldBe(Condition.visible);
    }

    public void checkSuccessLoginMessage() {
        success_login_message.shouldBe(Condition.visible);
        success_login_message.should(Condition.exactText("Logged in successfully"));
    }

    public void logout() {logout_button.click();}

    public void checkSuccessLogoutMessage() {
        success_logout_message.shouldBe(Condition.visible);
        success_logout_message.should(Condition.exactText("Signed out successfully."));
    }

    public void checkAuthorizationPageOpened() {
        email_field.shouldBe(Condition.visible);
        password_field.shouldBe(Condition.visible);
    }

}


