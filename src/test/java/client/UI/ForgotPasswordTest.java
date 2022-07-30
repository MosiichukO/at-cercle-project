package client.UI;

import client.Pages.ForgotPasswordModal;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ForgotPasswordTest extends ForgotPasswordModal {

    @BeforeEach
    public void openSignInModalFromHomePage () {
        openHomePage();
        maximizeWindow();
        openSignInModal();
    }

    @Test
    @Order(1)
    @Tag("C7237")
    @DisplayName("Forgot password modal is opened by clicking Forgot your password button")
    public void forgotPasswordModalIsOpenedByClickingForgotPasswordButton () {
        clickForgotPasswordButton();
        checkForgotPasswordModalIsOpened();
    }

    @Test
    @Order(2)
    @Tag("C7239")
    @DisplayName("Forgot password modal is closed by clicking cross button")
    public void forgotPasswordModalIsClosedByClickingCrossButton () {
        forgotPasswordModalIsOpenedByClickingForgotPasswordButton();
        clickCrossButton();
        checkForgotPasswordModalIsClosed();
    }

    @Test
    @Order(3)
    @Tag("C7240")
    @DisplayName("By clicking Back button, user is returned to Sign In modal")
    public void signInModalIsOpenedByClickingBackButton () {
        forgotPasswordModalIsOpenedByClickingForgotPasswordButton();
        clickBackButton();
        checkSignInModalIsOpened();
    }

    @Test
    @Order(4)
    @Tag("C14642")
    @DisplayName("If email is empty -> Enter a valid email address")
    public void emailIsRequiredErrorAppearsIfEmailIsEmpty () {
        forgotPasswordModalIsOpenedByClickingForgotPasswordButton();
        clickSendResetLinkButton();
        checkEmailRequiredError();
    }

    @Test
    @Order(5)
    @Tag("C14226")
    @DisplayName("If email doesn't contain @ and is not empty, there is an error -> Enter a valid email address")
    public void errorMessageIfEmailWithoutAmpersand () {
        forgotPasswordModalIsOpenedByClickingForgotPasswordButton();
        setRandomEmailWithoutAmpersand();
        clickSendResetLinkButton();
        checkEmailIsNotValidError();
    }

    @Test
    @Order(6)
    @Tag("C14227")
    @DisplayName("If email contains @ but there are no symbols before it, there is an error -> Enter a valid email address")
    public void errorMessageIfEmailWithoutPartBeforeAmpersand () {
        forgotPasswordModalIsOpenedByClickingForgotPasswordButton();
        setRandomEmailWithoutPartBeforeAmpersand();
        clickSendResetLinkButton();
        checkEmailIsNotValidError();
    }

    @Test
    @Order(7)
    @Tag("C14228")
    @DisplayName("If email contains @ but there are no symbols after it, there is an error -> Enter a valid email address")
    public void errorMessageIfEmailWithoutPartAfterAmpersand () {
        forgotPasswordModalIsOpenedByClickingForgotPasswordButton();
        setRandomEmailWithoutPartAfterAmpersand();
        clickSendResetLinkButton();
        checkEmailIsNotValidError();
    }

    @Test
    @Order(8)
    @Tag("C14229")
    @DisplayName("If email contains @ and a dot after it, there is an error -> Enter a valid email address")
    public void errorMessageIfEmailDotRightAfterAmpersand () {
        forgotPasswordModalIsOpenedByClickingForgotPasswordButton();
        setRandomEmailWithDotRightAfterAmpersand();
        clickSendResetLinkButton();
        checkEmailIsNotValidError();
    }

    @Test
    @Order(9)
    @Tag("C14230")
    @DisplayName("If email contains @ and a special symbol except for a dot in any place after it, there is an error -> Enter a valid email address")
    public void errorMessageIfEmailSpecSymbolExceptDotAfterAmpersand () {
        forgotPasswordModalIsOpenedByClickingForgotPasswordButton();
        setRandomEmailWithSpecSymbolExceptDotAfterAmpersand();
        clickSendResetLinkButton();
        checkEmailIsNotValidError();
    }

    @Test
    @Order(10)
    @Tag("C14231")
    @DisplayName("User not found. Please check your email. error appears under the Email field if entered email is not registered")
    public void userNotFoundError () {
        forgotPasswordModalIsOpenedByClickingForgotPasswordButton();
        setNonRegisteredEmail();
        clickSendResetLinkButton();
        checkUserIsNotFoundError();
    }
}
