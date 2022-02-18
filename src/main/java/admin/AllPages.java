package admin;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

public class AllPages {
    public SelenideElement error_message = $(".flash.error");
    public SelenideElement success_message = $(".flash.success");
    public SelenideElement email_field = $("#spree_user_email");
    public SelenideElement password_field = $("#spree_user_password");
    public SelenideElement login_button = $(".btn.btn-primary");

    public final String VALID_EMAIL = "qa@admin.com";
    public final String VALID_PASSWORD = "qa1234";


    public void authorization(String email, String password) {
        email_field.setValue(email);
        password_field.setValue(password);
        login_button.click();
    }

    public void checkErrorMessage(String error) {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(error));
    }

    public void checkSuccessMessage(String message) {
        success_message.shouldBe(Condition.visible);
        success_message.should(Condition.exactText(message));
    }
}
