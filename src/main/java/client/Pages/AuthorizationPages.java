package client.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public class AuthorizationPages extends AllPages {

    public void openSignUpModal() {
        sign_up_button.click();
    }

    public void openSignInModal() {
        sign_up_button.click();
        clickLogInButtonInSignUpModal();
        login_form.shouldBe(Condition.visible);
    }

    public void openTheFirstLetterFromTempMail () {
        first_mail.should(Condition.appear, Duration.ofSeconds(30));
        first_mail.click();
    }

    public void getTempMail () {
        TEMP_EMAIL = temp_mail_field.getValue() + "@mailto.plus";
    }

    public void clickTheConfirmMyAccountButton () {
        confirm_my_account_button.click();
    }

    public void clickLogInButtonInSignUpModal() {
        log_in_button_sign_up_modal.click();
    }

    public void clickLogInButtonInSignInModal() {
        log_in_button_sign_in_modal.click();
    }

    public void clickSignUpButton() {
        sign_up_button_in_sign_in_modal.click();
    }

    public void clickCrossButton() {
        cross_button.click();
    }

    public void clickShowButtonForPasswordField() {
        show_button_password_field.click();
    }

    public void clickShowButtonForConfirmPasswordField() {
        show_button_confirm_password_field.click();
    }

    public void clickCreateAccountButton() {
        create_account_button.click();
    }

    public void setRandomPasswordWithLengthFromOneToSix() {
        password_field.setValue(RANDOM_PASSWORD_INVALID_LENGTH);
    }

    public void setRandomConfirmPasswordWithLengthFromOneToSix() {
        confirm_password_field.setValue(RANDOM_PASSWORD_INVALID_LENGTH);
    }

    public void setRandomEmailWithoutAmpersand() {
        email_field.setValue(RANDOM_EMAIL_WITHOUT_AMPERSAND);
    }

    public void setRandomEmailWithoutPartBeforeAmpersand() {
        email_field.setValue(RANDOM_EMAIL_WITHOUT_PART_BEFORE_AMPERSAND);
    }

    public void setRandomEmailWithoutPartAfterAmpersand() {
        email_field.setValue(RANDOM_EMAIL_WITHOUT_PART_AFTER_AMPERSAND);
    }

    public void setRandomEmailWithDotRightAfterAmpersand() {
        email_field.setValue(RANDOM_EMAIL_WITH_DOT_RIGHT_AFTER_AMPERSAND);
    }

    public void setRandomEmailWithSpecSymbolExceptDotAfterAmpersand() {
        email_field.setValue(RANDOM_EMAIL_WITH_SPEC_SYMBOL_AFTER_AMPERSAND);
    }

    public void setNonRegisteredEmail() {
        email_field.setValue(NON_REGISTERED_EMAIL);
    }

    public void setRegisteredEmail() {
        email_field.setValue(REGISTERED_USER_EMAIL);
    }

    public void setRegisteredTempMail () {
        email_field.setValue(TEMP_EMAIL);
    }

    public void setNonConfirmedEmail() {
        email_field.setValue(NON_CONFIRMED_USER_EMAIL);
    }

    public void setTempMailIntoEmailField() {
        email_field.setValue(TEMP_EMAIL);
    }

    public void setNonRegisteredPassword() {
        password_field.setValue(NON_REGISTERED_PASSWORD);
    }

    public void setNonRegisteredConfirmPassword() {
        confirm_password_field.setValue(NON_REGISTERED_PASSWORD);
    }

    public void setRegisteredPassword() {
        password_field.setValue(REGISTERED_PASSWORD);
    }

    public void setRegisteredPasswordToConfirm() {
        confirm_password_field.setValue(REGISTERED_PASSWORD);
    }

    public void setRandomValidPasswordAndConfirmPassword() {
        password_field.setValue(RANDOM_PASSWORD_VALID_LENGTH);
        confirm_password_field.setValue(RANDOM_PASSWORD_VALID_LENGTH);
    }

    public void setValidLengthFullName () {
        full_name_field.setValue(RANDOM_FULL_NAME_VALID_LENGTH);
    }

    public void setInvalidMinLengthFullName() {
        full_name_field.setValue(RANDOM_FULL_NAME_INVALID_MIN_LENGTH);
    }

    public void setInvalidMaxLengthFullName() {
        full_name_field.setValue(RANDOM_FULL_NAME_INVALID_MAX_LENGTH);
    }

    public void checkSignInModalIsOpened() {
        login_form.shouldBe(Condition.visible);
    }

    public void checkSignInModalIsClosed() {
        login_form.shouldNotBe(Condition.visible);
    }

    public void checkSignUpModalIsOpened() {
        login_form.shouldNotBe(Condition.visible);
        signup_form.shouldBe(Condition.visible);
    }

    public void checkSignUpModalIsClosed() {
        signup_form.shouldNotBe(Condition.visible);
    }

    public void checkPasswordIsHidden() {
        password_field.shouldHave(Condition.attribute("type", "password"));
    }

    public void checkPasswordIsNotHidden() {
        password_field.shouldHave(Condition.exactValue(NON_REGISTERED_PASSWORD));
        password_field.shouldHave(Condition.attribute("type", "text"));
    }

    public void checkConfirmPasswordIsHidden() {
        confirm_password_field.shouldHave(Condition.attribute("type", "password"));
    }

    public void checkConfirmPasswordIsNotHidden() {
        confirm_password_field.shouldHave(Condition.exactValue(NON_REGISTERED_PASSWORD));
        confirm_password_field.shouldHave(Condition.attribute("type", "text"));
    }

    public void checkFieldError (SelenideElement field, String error) {
        field.shouldBe(Condition.visible);
        field.shouldHave(Condition.exactText(error));
    }

    public void checkEmailRequiredError() { checkFieldError(email_field_error, EMAIL_REQUIRED_ERROR);}

    public void checkEmailIsNotValidError() { checkFieldError(email_field_error, EMAIL_INVALID_ERROR);}

    public void checkEmailIsNotConfirmedError() { checkFieldError(email_field_error, NON_CONFIRMED_EMAIL_ERROR);}

    public void checkEmailIsAlreadyTakenError() { checkFieldError(email_field_error, EMAIL_TAKEN_ERROR);}

    public void checkFullNameRequiredErrorSignUp() { checkFieldError(full_name_field_error, FULL_NAME_REQUIRED_ERROR);}

    public void checkFullNameThreeSymbolsMinimumError() { checkFieldError(full_name_field_error, FULL_NAME_THREE_SYMBOLS_MINIMUM_ERROR);}

    public void checkFullNameThirtySymbolsMaximumError() { checkFieldError(full_name_field_error, FULL_NAME_THIRTY_SYMBOLS_MAXIMUM_ERROR);}

    public void checkPasswordRequiredErrorSignIn() { checkFieldError(password_field_error_sign_in, PASSWORD_REQUIRED_ERROR);}

    public void checkPasswordRequiredErrorSignUp() { checkFieldError(password_field_error_sign_up, PASSWORD_REQUIRED_ERROR);}

    public void checkConfirmPasswordRequiredErrorSignUp() { checkFieldError(confirm_password_field_error_sign_up, CONFIRM_PASSWORD_REQUIRED_ERROR);}

    public void checkPasswordSixSymbolsMinimumErrorSignIn() { checkFieldError(password_field_error_sign_in, PASSWORD_SIX_SYMBOLS_MINIMUM_ERROR);}

    public void checkPasswordSixSymbolsMinimumErrorSignUp() { checkFieldError(password_field_error_sign_up, PASSWORD_SIX_SYMBOLS_MINIMUM_ERROR);}

    public void checkConfirmPasswordSixSymbolsMinimumErrorSignUp() { checkFieldError(confirm_password_field_error_sign_up, PASSWORD_SIX_SYMBOLS_MINIMUM_ERROR);}

    public void checkConfirmPasswordShouldMatchErrorSignUp() { checkFieldError(confirm_password_field_error_sign_up, CONFIRM_PASSWORD_MATCH_ERROR);}

    public void checkWrongCredentialsError() {
        email_field_error.shouldBe(Condition.visible);
        password_field_error_sign_in.shouldBe(Condition.visible);
        email_field_error.shouldHave(Condition.exactText(WRONG_CREDENTIALS_ERROR));
        password_field_error_sign_in.shouldHave(Condition.exactText(WRONG_CREDENTIALS_ERROR));
    }

    public void checkUserIsLoggedIn() {
        Selenide.refresh();
        sign_up_button.shouldNotBe(Condition.visible);
    }

    public void checkSignUpButtonChangedToUserAvatar() {
        sign_up_button.shouldNotBe(Condition.visible);
        user_avatar_button.shouldBe(Condition.visible);
    }

    public void checkConfirmEmailPageIsOpened () {
        confirm_email_page.shouldBe(Condition.visible);
    }

    public void checkTooltipForShowButtonIfValueIsHidden () {
        show_button_tooltip.shouldBe(Condition.visible);
        show_button_tooltip.shouldHave(Condition.exactText(SHOW_BUTTON_FOR_HIDDEN_PASSWORD));
    }

    public void checkTooltipForShowButtonIfValueIsNotHidden () {
        show_button_tooltip.shouldBe(Condition.visible);
        show_button_tooltip.shouldHave(Condition.exactText(SHOW_BUTTON_FOR_NOT_HIDDEN_PASSWORD));
    }


    public void switchToNewTab () {
        Selenide.switchTo().window(1);
    }

}
