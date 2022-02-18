package admin;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage extends AllPages {

    public SelenideElement logout_button = $(".fa.fa-sign-out");
    public SelenideElement success_logout_message = $(".flash.notice");

    public void checkSignOutButtonVisible() {
        logout_button.shouldBe(Condition.visible);
    }

    public void logout() {
        logout_button.click();
    }

    public void checkSuccessLogoutMessage() {
        success_logout_message.shouldBe(Condition.visible);
        success_logout_message.should(Condition.exactText("Signed out successfully."));
    }

    public void checkAuthorizationPageOpened() {
        email_field.shouldBe(Condition.visible);
        password_field.shouldBe(Condition.visible);
    }

}


