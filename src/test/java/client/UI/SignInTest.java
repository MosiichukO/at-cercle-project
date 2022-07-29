package client.UI;

import client.Pages.AuthorizationPages;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class SignInTest extends AuthorizationPages {

    @Nested @Order(1)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class GeneralTest {

        @BeforeEach
        public void openURL() {
            openHomePage();
        }


        @Test
        @Order(1)
        @Tag("C7976")
        @DisplayName("Sign In modal is opened by clicking Log in button")
        public void signInModalIsOpenedByClickingLogInButton() {
            openSignUpModal();
            clickLogInButtonInSignUpModal();
            checkSignInModalIsOpened();
        }

        @Test
        @Order(2)
        @Tag("C7977")
        @DisplayName("By clicking Sign Up button on the Sign In modal, Sign up modal is opened")
        public void signUpModalIsOpenedByClickingSignUpButtonOnTheSignInModal() {
            openSignUpModal();
            clickLogInButtonInSignUpModal();
            clickSignUpButton();
            checkSignUpModalIsOpened();
        }

        @Test
        @Order(3)
        @Tag("C7978")
        @DisplayName("By clicking cross button, Sign In modal is closed")
        public void signInModalIsClosedByClickingCrossButton() {
            openSignUpModal();
            clickLogInButtonInSignUpModal();
            clickCrossButton();
            checkSignInModalIsClosed();
        }
    }

    @Nested @Order(2)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class EmailPasswordTest {
        @BeforeEach
        public void openSignInModalFromHomePage () {
            openHomePage();
            openSignInModal();
        }

        @Test
        @Order(1)
        @Tag("C7976")
        @DisplayName("If any symbols are entered to the Password field, they are hidden with dots")
        public void passwordIsHiddenByDefault () {
            setNonRegisteredPassword();
            checkPasswordIsHidden();
        }

        @Test
        @Order(2)
        @Tag("C7984")
        @DisplayName("By clicking Show button for Password field, entered symbols are not hidden")
        public void passwordIsNotHiddenIfShowButtonIsClicked () {
            setNonRegisteredPassword();
            clickShowButtonForPasswordField();
            checkPasswordIsNotHidden();
        }

        @Test
        @Order(3)
        @Tag("C14178")
        @DisplayName("By clicking Show button for Password field, when entered symbols are not hidden, they become hidden")
        public void passwordIsHiddenIfShowButtonIsClickedTwice () {
            setNonRegisteredPassword();
            clickShowButtonForPasswordField();
            clickShowButtonForPasswordField();
            checkPasswordIsHidden();
        }

        @Test
        @Order(4)
        @Tag("C14179")
        @DisplayName("Email is required error appears under the Email field if it is empty")
        public void emailIsRequiredErrorAppearsIfEmailIsEmpty () {
            clickLogInButtonInSignInModal();
            checkEmailRequiredError();
        }

        @Test
        @Order(4)
        @Tag("C14180")
        @DisplayName("Password is required error appears under the Password field if it is empty")
        public void passwordIsRequiredErrorAppearsIfEmailIsEmpty () {
            clickLogInButtonInSignInModal();
            checkPasswordRequiredErrorSignIn();
        }

        @Test
        @Order(5)
        @Tag("C14181")
        @DisplayName("6 symbols minimum error appears under the Password field if > 0 and  < 6 symbols are entered")
        public void sixSymbolsMinimumErrorIfPasswordLessThanSixSymbols () {
            setRandomPasswordWithLengthFromOneToSix();
            clickLogInButtonInSignInModal();
            checkPasswordSixSymbolsMinimumErrorSignIn();
        }

        @Test
        @Order(6)
        @Tag("C14182")
        @DisplayName("If email doesn't contain @ and is not empty, there is an error -> Enter a valid email address")
        public void errorMessageIfEmailWithoutAmpersand () {
            setRandomEmailWithoutAmpersand();
            clickLogInButtonInSignInModal();
            checkEmailIsNotValidError();
        }

        @Test
        @Order(7)
        @Tag("C14183")
        @DisplayName("If email contains @ but there are no symbols before it, there is an error -> Enter a valid email address")
        public void errorMessageIfEmailWithoutPartBeforeAmpersand () {
            setRandomEmailWithoutPartBeforeAmpersand();
            clickLogInButtonInSignInModal();
            checkEmailIsNotValidError();
        }

        @Test
        @Order(8)
        @Tag("C14184")
        @DisplayName("If email contains @ but there are no symbols after it, there is an error -> Enter a valid email address")
        public void errorMessageIfEmailWithoutPartAfterAmpersand () {
            setRandomEmailWithoutPartAfterAmpersand();
            clickLogInButtonInSignInModal();
            checkEmailIsNotValidError();
        }

        @Test
        @Order(9)
        @Tag("C14185")
        @DisplayName("If email contains @ and a dot after it, there is an error -> Enter a valid email address")
        public void errorMessageIfEmailDotRightAfterAmpersand () {
            setRandomEmailWithDotRightAfterAmpersand();
            clickLogInButtonInSignInModal();
            checkEmailIsNotValidError();
        }

        @Test
        @Order(10)
        @Tag("C14186")
        @DisplayName("If email contains @ and a special symbol except for a dot in any place after it, there is an error -> Enter a valid email address")
        public void errorMessageIfEmailSpecSymbolExceptDotAfterAmpersand () {
            setRandomEmailWithSpecSymbolExceptDotAfterAmpersand();
            clickLogInButtonInSignInModal();
            checkEmailIsNotValidError();
        }

        @Test
        @Order(11)
        @Tag("C14188")
        @DisplayName("Wrong credentials error appears under both fields if email doesn't exist in DB and password exists in DB")
        public void errorMessageIfEmailIsNotRegisteredPasswordIsRegistered () {
            setNonRegisteredEmail();
            setRegisteredPassword();
            clickLogInButtonInSignInModal();
            checkWrongCredentialsError();
        }

        @Test
        @Order(12)
        @Tag("C14189")
        @DisplayName("Wrong credentials error appears under both fields if email exists in DB and password is not valid")
        public void errorMessageIfEmailIsRegisteredPasswordIsNotRegistered () {
            setRegisteredEmail();
            setNonRegisteredPassword();
            clickLogInButtonInSignInModal();
            checkWrongCredentialsError();
        }

        @Test
        @Order(13)
        @Tag("C7986")
        @DisplayName("It is possible to log in by using existing in DB confirmed email + password")
        public void itIsPossibleToLogInWithValidCredentials () {
            setRegisteredEmail();
            setRegisteredPassword();
            clickLogInButtonInSignInModal();
            checkUserIsLoggedIn();
        }

        @Test
        @Order(14)
        @Tag("C14191")
        @DisplayName("The Sign In modal is closed after the successful authorization")
        public void signInModalIsClosedAfterAuthorization () {
            setRegisteredEmail();
            setRegisteredPassword();
            clickLogInButtonInSignInModal();
            checkSignInModalIsClosed();
        }

        @Test
        @Order(15)
        @Tag("C14190")
        @DisplayName("The Sign up button is changed to the user's picture or standard icon after the successful authorization")
        public void signUpButtonIsChangedToUserAvatarAfterAuthorization () {
            setRegisteredEmail();
            setRegisteredPassword();
            clickLogInButtonInSignInModal();
            checkSignUpButtonChangedToUserAvatar();
        }

        @Test
        @Order(16)
        @Tag("C14187")
        @DisplayName("User account is not confirmed error appears under the Email field if user's email is not confirmed")
        public void errorMessageIfEmilIsNotConfirmed () {
            setNonConfirmedEmail();
            setRegisteredPassword();
            clickLogInButtonInSignInModal();
            checkEmailIsNotConfirmedError();
        }


    }

    @AfterEach
    public void closeDriver() {
        WebDriverRunner.driver().close();
    }
}
