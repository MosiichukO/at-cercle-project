package client.Pages;

import com.codeborne.selenide.Condition;

public class ForgotPasswordModal extends AuthorizationPages {

    public void clickForgotPasswordButton () {
        forgot_password_button.click();
        forgot_password_form.shouldBe(Condition.visible);
    }

    public void clickBackButton () {
        back_forgot_password_button.click();
    }

    public void clickSendResetLinkButton () {
        send_reset_link_button.click();
    }

    public void checkForgotPasswordModalIsOpened () {
        forgot_password_form.shouldBe(Condition.visible);
    }

    public void checkForgotPasswordModalIsClosed () {
        forgot_password_form.shouldNotBe(Condition.visible);
    }

    public void checkUserIsNotFoundError() { checkFieldError(email_field_error, USER_NOT_FOUND_ERROR);}

}
