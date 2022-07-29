package client.UI;

import client.Pages.AuthorizationPages;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class SignUpTest extends AuthorizationPages {


    @Nested
    @Order(1)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class GeneralTest {

            @BeforeEach
            public void openURL() {
                openHomePage();
            }

        @Test
        @Order(1)
        @Tag("C14192")
        @DisplayName("Sign Up modal is opened by clicking Sign up button in the header ")
        public void signUpModalIsOpenedByClickingHeaderSignUpButton() {
            openSignUpModal();
            checkSignUpModalIsOpened();
        }

        @Test
        @Order(2)
        @Tag("C14193")
        @DisplayName("By clicking cross button, Sign Up modal is closed")
        public void signUpModalIsClosedByClickingCrossButton() {
            openSignUpModal();
            clickCrossButton();
            checkSignUpModalIsClosed();
        }
    }

    @Nested @Order(2)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class EmailPasswordTest {

        @BeforeEach
        public void openSignUpModalFromHomePage () {
            openHomePage();
            maximizeWindow();
            openSignUpModal();
        }

        @Test
        @Order(1)
        @Tag("C14197")
        @DisplayName("If any symbols are entered to the Create password field, they are hidden with dots")
        public void createPasswordIsHiddenByDefault () {
            setNonRegisteredPassword();
            checkPasswordIsHidden();
        }

        @Test
        @Order(2)
        @Tag("C14198")
        @DisplayName("If any symbols are entered to the Confirm password field, they are hidden with dots")
        public void confirmPasswordIsHiddenByDefault () {
            setNonRegisteredConfirmPassword();
            checkConfirmPasswordIsHidden();
        }

        @Test
        @Order(3)
        @Tag("C14199")
        @DisplayName("By clicking Show button for Create password field, entered symbols are not hidden")
        public void createPasswordIsNotHiddenIfShowButtonIsClicked () {
            setNonRegisteredPassword();
            clickShowButtonForPasswordField();
            checkPasswordIsNotHidden();
        }

        @Test
        @Order(4)
        @Tag("C14200")
        @DisplayName("By clicking Show button for Create password field, when entered symbols are not hidden, they become hidden")
        public void createPasswordIsHiddenIfShowButtonIsClickedTwice () {
            setNonRegisteredPassword();
            clickShowButtonForPasswordField();
            clickShowButtonForPasswordField();
            checkPasswordIsHidden();
        }

        @Test
        @Order(5)
        @Tag("C14201")
        @DisplayName("By clicking Show button for Confirm password field, entered symbols are not hidden")
        public void confirmPasswordIsNotHiddenIfShowButtonIsClicked () {
            setNonRegisteredConfirmPassword();
            clickShowButtonForConfirmPasswordField();
            checkConfirmPasswordIsNotHidden();
        }

        @Test
        @Order(6)
        @Tag("C14202")
        @DisplayName("By clicking Show button for Confirm password field, when entered symbols are not hidden, they become hidden")
        public void confirmPasswordIsHiddenIfShowButtonIsClickedTwice () {
            setNonRegisteredConfirmPassword();
            clickShowButtonForConfirmPasswordField();
            clickShowButtonForConfirmPasswordField();
            checkConfirmPasswordIsHidden();
        }

        @Test
        @Order(7)
        @Tag("C14207")
        @DisplayName("Email is required error appears under the Email field if it is empty")
        public void emailIsRequiredErrorAppearsIfEmailIsEmpty () {
            clickCreateAccountButton();
            checkEmailRequiredError();
        }

        @Test
        @Order(8)
        @Tag("C14208")
        @DisplayName("Full name is required error appears under the Full name field if it is empty")
        public void fullNameIsRequiredErrorAppearsIfFullNameIsEmpty () {
            clickCreateAccountButton();
            checkFullNameRequiredErrorSignUp();
        }

        @Test
        @Order(9)
        @Tag("C14209")
        @DisplayName("Password is required error appears under the Create password field if it is empty")
        public void passwordIsRequiredErrorAppearsIfCreatePasswordIsEmpty () {
            clickCreateAccountButton();
            checkPasswordRequiredErrorSignUp();
        }

        @Test
        @Order(10)
        @Tag("C14210")
        @DisplayName("Password confirmation is required error appears under the Confirm password field if it is empty")
        public void passwordConfirmationIsRequiredErrorAppearsIfConfirmPasswordIsEmpty () {
            clickCreateAccountButton();
            checkConfirmPasswordRequiredErrorSignUp();
        }

        @Test
        @Order(11)
        @Tag("C14211")
        @DisplayName("6 symbols minimum error appears under the Create password field if > 0 and  < 6 symbols are entered")
        public void sixSymbolsMinimumErrorIfCreatePasswordLessThanSixSymbols () {
            setRandomPasswordWithLengthFromOneToSix();
            clickCreateAccountButton();
            checkPasswordSixSymbolsMinimumErrorSignUp();
        }

        @Test
        @Order(12)
        @Tag("C14212")
        @DisplayName("6 symbols minimum error appears under the Confirm password field if > 0 and  < 6 symbols are entered")
        public void sixSymbolsMinimumErrorIfConfirmPasswordLessThanSixSymbols () {
            setRandomConfirmPasswordWithLengthFromOneToSix();
            clickCreateAccountButton();
            checkConfirmPasswordSixSymbolsMinimumErrorSignUp();
        }

        @Test
        @Order(13)
        @Tag("C14213")
        @DisplayName("Should match password error appears under the Confirm password field if password confirmation != password")
        public void shouldMatchPasswordErrorIfConfirmPasswordIsNotEqualToPassword () {
            setRegisteredPassword();
            setNonRegisteredConfirmPassword();
            clickCreateAccountButton();
            checkConfirmPasswordShouldMatchErrorSignUp();
        }

        @Test
        @Order(14)
        @Tag("C14214")
        @DisplayName("If email doesn't contain @ and is not empty, there is an error -> Enter a valid email address")
        public void errorMessageIfEmailWithoutAmpersand () {
            setRandomEmailWithoutAmpersand();
            clickCreateAccountButton();
            checkEmailIsNotValidError();
        }

        @Test
        @Order(15)
        @Tag("C14215")
        @DisplayName("If email contains @ but there are no symbols before it, there is an error -> Enter a valid email address")
        public void errorMessageIfEmailWithoutPartBeforeAmpersand () {
            setRandomEmailWithoutPartBeforeAmpersand();
            clickCreateAccountButton();
            checkEmailIsNotValidError();
        }

        @Test
        @Order(16)
        @Tag("C14216")
        @DisplayName("If email contains @ but there are no symbols after it, there is an error -> Enter a valid email address")
        public void errorMessageIfEmailWithoutPartAfterAmpersand () {
            setRandomEmailWithoutPartAfterAmpersand();
            clickCreateAccountButton();
            checkEmailIsNotValidError();
        }

        @Test
        @Order(17)
        @Tag("C14217")
        @DisplayName("If email contains @ and a dot after it, there is an error -> Enter a valid email address")
        public void errorMessageIfEmailDotRightAfterAmpersand () {
            setRandomEmailWithDotRightAfterAmpersand();
            clickCreateAccountButton();
            checkEmailIsNotValidError();
        }

        @Test
        @Order(18)
        @Tag("C14218")
        @DisplayName("If email contains @ and a special symbol except for a dot in any place after it, there is an error -> Enter a valid email address")
        public void errorMessageIfEmailSpecSymbolExceptDotAfterAmpersand () {
            setRandomEmailWithSpecSymbolExceptDotAfterAmpersand();
            clickCreateAccountButton();
            checkEmailIsNotValidError();
        }

        @Test
        @Order(19)
        @Tag("C14220")
        @DisplayName("Email has already been taken. error appears under the Email field if email is used for other non-deleted user")
        public void errorMessageIfEmailIsAlreadyTaken () {
            setRegisteredEmail();
            setValidLengthFullName();
            setRandomValidPasswordAndConfirmPassword();
            clickCreateAccountButton();
            checkEmailIsAlreadyTakenError();
        }

        @Test
        @Order(20)
        @Tag("C14640")
        @DisplayName("3 symbols minimum error appears under the Full name field if it is > 0 and  < 3 symbols")
        public void errorMessageIfFullNameLessThenThreeSymbols () {
            setInvalidLengthFullName();
            clickCreateAccountButton();
            checkFullNameThreeSymbolsMinimumError();
        }

        @Test
        @Order(21)
        @Tag("C14219, 14222, 14223, 14224")
        @DisplayName("Registration flow")
        public void registrationFlow () {
            openTempMailService();
            getTempMail();

            openSignUpModalFromHomePage();
            setTempMailIntoEmailField();
            setValidLengthFullName();
            setRegisteredPassword();
            setRegisteredPasswordToConfirm();
            clickCreateAccountButton();

            checkConfirmEmailPageIsOpened();

            openTempMailService();
            openTheFirstLetterFromTempMail();
            clickTheConfirmMyAccountButton();
            switchToNewTab();

            checkSignInModalIsOpened();
        }
    }
}
