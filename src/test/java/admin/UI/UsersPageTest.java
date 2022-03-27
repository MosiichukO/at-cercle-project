package admin.UI;

import admin.Pages.UsersPage;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class UsersPageTest extends UsersPage {

    @BeforeEach
    public void authorizeAndOpenDryCleanerPage() {
        openAdminLoginPage();
        authorizationAdmin();
        openUsersPage();
    }

    @Nested
    @Order(1)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class ViewFilterUsersTest {

        @Test
        @Order(1)
        @Tag("C3546")
        @DisplayName("By clicking Users tab, Users page is opened")
        public void usersPageOpenedByClickingUsersTab () {
            checkUsersPageIsOpened();
        }

        @Test
        @Order(2)
        @Tag("C3600")
        @DisplayName("If filter by Admin role is applied, only users with Admin role are displayed in table")
        public void usersFilterByAdminRole () {
            clickRolesFilter();
            clickAdminRoleOption();
            clickSearchButton();
            checkAdminOnlyInList();
        }

        @Test
        @Order(3)
        @Tag("C3601")
        @DisplayName("If filter by Support role is applied, only users with Support role are displayed in table")
        public void usersFilterBySupportRole () {
            clickRolesFilter();
            clickSupportRoleOption();
            clickSearchButton();
            checkSupportUsersOnlyInList();
        }

        @Test
        @Order(4)
        @Tag("C3602")
        @DisplayName("If filter by Dry Cleaner role is applied, only users with Dry Cleaner role are displayed in table")
        public void usersFilterByDryCleanerRole () {
            clickRolesFilter();
            clickDryCleanerRoleOption();
            clickSearchButton();
            checkDryCleanerUsersOnlyInList();
        }

        @Test
        @Order(5)
        @Tag("C3603")
        @DisplayName("Filter users by Dry cleaner and Support roles")
        public void usersFilterByDryCleanerAndSupportRole () {
            clickRolesFilter();
            clickDryCleanerRoleOption();
            clickRolesFilter();
            clickSupportRoleOption();
            clickSearchButton();
            checkAdminAbsentInList();
        }

        @Test
        @Order(6)
        @Tag("C3603")
        @DisplayName("Filter users by Dry cleaner and Admin roles")
        public void usersFilterByDryCleanerAndAdminRole () {
            clickRolesFilter();
            clickDryCleanerRoleOption();
            clickRolesFilter();
            clickAdminRoleOption();
            clickSearchButton();
            checkSupportAbsentInList();
        }

        @Test
        @Order(7)
        @Tag("C3603")
        @DisplayName("Filter users by Support and Admin roles")
        public void usersFilterBySupportAndAdminRole () {
            clickRolesFilter();
            clickSupportRoleOption();
            clickRolesFilter();
            clickAdminRoleOption();
            clickSearchButton();
            checkDryCleanerAbsentInList();
        }

        @Test
        @Order(8)
        @Tag("C3607")
        @DisplayName("Filter users by Email full match")
        public void usersFilterByEmailFullMatch () {
            setSupportEmailToEmailFilter();
            clickSearchButton();
            checkFilterResultsBySupportEmail();
        }

        @Test
        @Order(9)
        @Tag("C3607")
        @DisplayName("Filter users by Email partial match")
        public void usersFilterByEmailPartialMatch () {
            setPartOfEmailToEmailFilter();
            clickSearchButton();
            checkFilterResultsByPartOfEmail();
        }

        @Test
        @Order(10)
        @Tag("C6379")
        @DisplayName("If Charity filter with Enabled option is applied, only users with charity label are displayed")
        public void usersFilterByEnabledCharity () {
            clickCharityFilter();
            clickEnabledCharityOption();
            clickSearchButton();
            checkEnabledCharityUsersInList();
        }

        @Test
        @Order(11)
        @Tag("C6380")
        @DisplayName("If Charity filter with Disabled option is applied, only users without charity label are are displayed")
        public void usersFilterByDisabledCharity () {
            clickCharityFilter();
            clickDisabledCharityOption();
            clickSearchButton();
            checkDisabledCharityUsersInList();
        }
    }

    @Nested
    @Order(2)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class CreateUserTest {

        @Test
        @Order(1)
        @Tag("C3514")
        @DisplayName("By clicking New User button, New user page is opened")
        public void newUserPageOpenedByClickingNewUserButton () {
            clickNewUserButton();
            checkNewUserPageOpened();
        }

        @Test
        @Order(2)
        @Tag("C3530")
        @DisplayName("By clicking Cancel button for create, Users page is opened")
        public void usersPageOpenedByClickingCancelButton () {
            clickNewUserButton();
            clickCancelButton();
            checkUsersPageIsOpened();
        }

        @Test
        @Order(3)
        @Tag("C3515")
        @DisplayName("If email is empty for create, there is error message")
        public void emailCanNotBeBlankErrorMessage () {
            clickNewUserButton();
            setRandomValidEqualPasswordAndConfirmation();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkUserCreateEmailBlankError();
        }

        @Test
        @Order(4)
        @Tag("C3518")
        @DisplayName("If email is empty for create, there is a form error message")
        public void emailCanNotBeBlankFormErrorMessage () {
            clickNewUserButton();
            setRandomValidEqualPasswordAndConfirmation();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkEmailFormErrorCanNotBeBlank();
        }

        @Test
        @Order(5)
        @Tag("C3517")
        @DisplayName("If email is empty for create, Email field is highlighted in red")
        public void redBorderIfEmailIsEmpty () {
            clickNewUserButton();
            setRandomValidEqualPasswordAndConfirmation();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkErrorEmailFieldBorderColor();
        }

        @Test
        @Order(6)
        @Tag("C3527")
        @DisplayName("If email already exists in DB for create, there is error message")
        public void emailTakenErrorIfEmailExistsInDB () {
            clickNewUserButton();
            setExistingEmail();
            setRandomValidEqualPasswordAndConfirmation();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkUserCreateEmailExistingError();
        }

        @Test
        @Order(7)
        @Tag("C3529")
        @DisplayName("If email already exists in DB for create, there is a form error message")
        public void emailAlreadyTakenFormErrorMessage () {
            clickNewUserButton();
            setExistingEmail();
            setRandomValidEqualPasswordAndConfirmation();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkEmailFormErrorAlreadyTaken();
        }

        @Test
        @Order(8)
        @Tag("C3528")
        @DisplayName("If email already exists in DB for create, Email field is highlighted in red")
        public void redBorderIfEmailIsAlreadyTaken () {
            clickNewUserButton();
            setExistingEmail();
            setRandomValidEqualPasswordAndConfirmation();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkErrorEmailFieldBorderColor();
        }

        @Test
        @Order(9)
        @Tag("C3531")
        @DisplayName("If email doesn't contain @ and is not empty for create, there is an error tooltip")
        public void errorTooltipIfEmailWithoutAmpersand () {
            clickNewUserButton();
            setRandomEmailWithoutAmpersand();
            clickCreateButton();
            checkTooltipEmailWithoutAmpersand();
        }

        @Test
        @Order(10)
        @Tag("C3532")
        @DisplayName("If email contains @ but there are no symbols before it for create, there is error tooltip")
        public void errorTooltipIfEmailWithoutPartBeforeAmpersand () {
            clickNewUserButton();
            setRandomEmailWithoutPartBeforeAmpersand();
            clickCreateButton();
            checkTooltipEmailWithoutPartBeforeAmpersand();
        }

        @Test
        @Order(11)
        @Tag("C3533")
        @DisplayName("If email contains @ but there are no symbols after it for create, there is an error tooltip")
        public void errorTooltipIfEmailWithoutPartAfterAmpersand () {
            clickNewUserButton();
            setRandomEmailWithoutPartAfterAmpersand();
            clickCreateButton();
            checkTooltipEmailWithoutPartAfterAmpersand();
        }

        @Test
        @Order(12)
        @Tag("C3534")
        @DisplayName("If email contains @ and a dot after it for create, there is an error tooltip")
        public void errorTooltipIfEmailDotRightAfterAmpersand () {
            clickNewUserButton();
            setRandomEmailWithDotRightAfterAmpersand();
            clickCreateButton();
            checkTooltipEmailWithDotRightAfterAmpersand();
        }

        @Test
        @Order(13)
        @Tag("C3538")
        @DisplayName("If email contains @ and a special symbol except for a dot in any place after it for create, there is an error tooltip")
        public void errorTooltipIfEmailSpecSymbolExceptDotAfterAmpersand () {
            clickNewUserButton();
            setRandomEmailWithSpecSymbolExceptDotAfterAmpersand();
            clickCreateButton();
            checkTooltipEmailWithSpecSymbolAfterAmpersand();
        }

        @Test
        @Order(14)
        @Tag("C3516")
        @DisplayName("If password is empty for create, there is error message")
        public void passwordCanNotBeBlankErrorMessage () {
            clickNewUserButton();
            setRandomValidEmail();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkUserCreatePasswordBlankError();
        }

        @Test
        @Order(15)
        @Tag("C3520")
        @DisplayName("If password is empty for create, there is a form error message")
        public void passwordCanNotBeBlankFormErrorMessage () {
            clickNewUserButton();
            setRandomValidEmail();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkPasswordFormErrorCanNotBeBlank();
        }

        @Test
        @Order(16)
        @Tag("C3519")
        @DisplayName("If password is empty for create, Password field is highlighted in red")
        public void redBorderIfPasswordIsEmpty () {
            clickNewUserButton();
            setRandomValidEmail();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkErrorPasswordFieldBorderColor();
        }

        @Test
        @Order(17)
        @Tag("C3521, C3522")
        @DisplayName("If password consists of < 6 symbols for create, there is an error message")
        public void errorMessageIfPasswordLessThanSixSymbols () {
            clickNewUserButton();
            setRandomValidEmail();
            setRandomInvalidLengthEqualPasswordAndConfirmation();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkInvalidPasswordLengthErrorMessage();
        }

        @Test
        @Order(18)
        @Tag("C3526")
        @DisplayName("If password consists of < 6 symbols for create, there is a form error message")
        public void passwordIsTooShortFormErrorMessage () {
            clickNewUserButton();
            setRandomValidEmail();
            setRandomInvalidLengthEqualPasswordAndConfirmation();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkPasswordFormErrorInvalidLength();
        }

        @Test
        @Order(19)
        @Tag("C3525")
        @DisplayName("If password consists of < 6 symbols for create, Password field is highlighted in red")
        public void redBorderIfPasswordLessThanSixSymbols () {
            clickNewUserButton();
            setRandomValidEmail();
            setRandomInvalidLengthEqualPasswordAndConfirmation();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkErrorPasswordFieldBorderColor();
        }

        @Test
        @Order(20)
        @Tag("C3523")
        @DisplayName("If password != password confirmation for create, there is an error message")
        public void errorMessageIfPasswordNotEqualPasswordConfirmation () {
            clickNewUserButton();
            setRandomValidEmail();
            setRandomValidDifferentPasswordAndConfirmation();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkDifferentPasswordAndConfirmationErrorMessage();
        }

        @Test
        @Order(21)
        @Tag("C3524")
        @DisplayName("If password != password confirmation for create, there is a form error message")
        public void differentPasswordAndConfirmationFormErrorMessage () {
            clickNewUserButton();
            setRandomValidEmail();
            setRandomValidDifferentPasswordAndConfirmation();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkConfirmationPasswordFormErrorDoesNotMatchPassword();
        }

        @Test
        @Order(22)
        @Tag("C3535")
        @DisplayName("It is possible to create Dry cleaner user")
        public void itIsPossibleToCreateDryCleanerUser () {
            clickNewUserButton();
            setTestValidEmailDryCleaner();
            setTestPasswordAndConfirmation();
            clickDryCleanerCheckbox();
            clickCreateButton();
            checkEditNewDcUserPageIsOpened();
        }

        @Test
        @Order(23)
        @Tag("C3536")
        @DisplayName("It is possible to create Support user")
        public void itIsPossibleToCreateSupportUser () {
            clickNewUserButton();
            setTestValidEmailSupport();
            setTestPasswordAndConfirmation();
            clickSupportCheckbox();
            clickCreateButton();
            checkEditNewSupportUserPageIsOpened();
        }

        @Test
        @Order(24)
        @Tag("C3537")
        @DisplayName("It is possible to create Admin")
        public void itIsPossibleToCreateAdmin () {
            clickNewUserButton();
            setTestValidEmailAdmin();
            setTestPasswordAndConfirmation();
            clickAdminCheckbox();
            clickCreateButton();
            checkEditNewAdminPageIsOpened();
        }
    }

    @Nested
    @Order(3)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class EditUserTest {
        @Test
        @Order(1)
        @Tag("C3576")
        @DisplayName("There is edit button for users from Users page")
        public void thereIsEditButtonForUsers () {
            checkEditButtonIsPresentForTestUser();
        }

        @Test
        @Order(2)
        @Tag("C3577")
        @DisplayName("By clicking edit button for any user, Edit user page is opened")
        public void editUserPageIsOpenedByClickingEditButton () {
            clickEditButtonForTestUser();
            checkEditUserPageIsOpened();
        }

        @Test
        @Order(3)
        @Tag("C3578")
        @DisplayName("By clicking user's email, Edit user page is opened")
        public void editUserPageIsOpenedByClickingEmail () {
            clickEmailOfTestUser();
            checkEditUserPageIsOpened();
        }

        @Test
        @Order(4)
        @Tag("C3579")
        @DisplayName("If email is empty for update, there is error message")
        public void errorMessageIfEmailIsEmpty () {
            clickEditButtonForTestUser();
            clearEmailField();
            clickUpdateButton();
            checkUserCreateEmailBlankError();
        }

        @Test
        @Order(5)
        @Tag("C3581")
        @DisplayName("If email is empty for update, there is a form error message")
        public void emailCanNotBeBlankFormErrorMessage () {
            clickEditButtonForTestUser();
            clearEmailField();
            clickUpdateButton();
            checkEmailFormErrorCanNotBeBlank();
        }

        @Test
        @Order(6)
        @Tag("C3580")
        @DisplayName("If email is empty for update, Email field is highlighted in red")
        public void redBorderIfEmailIsEmpty () {
            clickEditButtonForTestUser();
            clearEmailField();
            clickUpdateButton();
            checkErrorEmailFieldBorderColor();
        }

        @Test
        @Order(7)
        @Tag("C3582")
        @DisplayName("If email already exists in DB for update, there is error message")
        public void emailTakenErrorIfEmailExistsInDB () {
            clickEditButtonForTestUser();
            setExistingEmail();
            clickUpdateButton();
            checkUserCreateEmailExistingError();
        }

        @Test
        @Order(8)
        @Tag("C3584")
        @DisplayName("If email already exists in DB for update, there is a form error message")
        public void emailAlreadyTakenFormErrorMessage () {
            clickEditButtonForTestUser();
            setExistingEmail();
            clickUpdateButton();
            checkEmailFormErrorAlreadyTaken();
        }

        @Test
        @Order(9)
        @Tag("C3583")
        @DisplayName("If email already exists in DB for update, Email field is highlighted in red")
        public void redBorderIfEmailIsAlreadyTaken () {
            clickEditButtonForTestUser();
            setExistingEmail();
            clickUpdateButton();
            checkErrorEmailFieldBorderColor();
        }

        @Test
        @Order(10)
        @Tag("C3585")
        @DisplayName("If email doesn't contain @ and is not empty for update, there is an error tooltip")
        public void errorTooltipIfEmailWithoutAmpersand () {
            clickEditButtonForTestUser();
            setRandomEmailWithoutAmpersand();
            clickUpdateButton();
            checkTooltipEmailWithoutAmpersand();
        }

        @Test
        @Order(11)
        @Tag("C3586")
        @DisplayName("If email contains @ but there are no symbols before it for update, there is error tooltip")
        public void errorTooltipIfEmailWithoutPartBeforeAmpersand () {
            clickEditButtonForTestUser();
            setRandomEmailWithoutPartBeforeAmpersand();
            clickUpdateButton();
            checkTooltipEmailWithoutPartBeforeAmpersand();
        }

        @Test
        @Order(12)
        @Tag("C3587")
        @DisplayName("If email contains @ but there are no symbols after it for update, there is an error tooltip")
        public void errorTooltipIfEmailWithoutPartAfterAmpersand () {
            clickEditButtonForTestUser();
            setRandomEmailWithoutPartAfterAmpersand();
            clickUpdateButton();
            checkTooltipEmailWithoutPartAfterAmpersand();
        }

        @Test
        @Order(13)
        @Tag("C3588")
        @DisplayName("If email contains @ and a dot after it for update, there is an error tooltip")
        public void errorTooltipIfEmailDotRightAfterAmpersand () {
            clickEditButtonForTestUser();
            setRandomEmailWithDotRightAfterAmpersand();
            clickUpdateButton();
            checkTooltipEmailWithDotRightAfterAmpersand();
        }

        @Test
        @Order(14)
        @Tag("C3539")
        @DisplayName("If email contains @ and a special symbol except for a dot in any place after it for update, there is an error tooltip")
        public void errorTooltipIfEmailSpecSymbolExceptDotAfterAmpersand () {
            clickEditButtonForTestUser();
            setRandomEmailWithSpecSymbolExceptDotAfterAmpersand();
            clickUpdateButton();
            checkTooltipEmailWithSpecSymbolAfterAmpersand();
        }

        @Test
        @Order(15)
        @Tag("C3590, C3591")
        @DisplayName("If password consists of < 6 symbols for update, there is an error message")
        public void errorMessageIfPasswordLessThanSixSymbols () {
            clickEditButtonForTestUser();
            setRandomInvalidLengthEqualPasswordAndConfirmation();
            clickUpdateButton();
            checkInvalidPasswordLengthErrorMessage();
        }

        @Test
        @Order(16)
        @Tag("C3593")
        @DisplayName("If password consists of < 6 symbols for update, there is a form error message")
        public void passwordIsTooShortFormErrorMessage () {
            clickEditButtonForTestUser();
            setRandomInvalidLengthEqualPasswordAndConfirmation();
            clickUpdateButton();
            checkPasswordFormErrorInvalidLength();
        }

        @Test
        @Order(17)
        @Tag("C3592")
        @DisplayName("If password consists of < 6 symbols for update, Password field is highlighted in red")
        public void redBorderIfPasswordLessThanSixSymbols () {
            clickEditButtonForTestUser();
            setRandomInvalidLengthEqualPasswordAndConfirmation();
            clickUpdateButton();
            checkErrorPasswordFieldBorderColor();
        }

        @Test
        @Order(18)
        @Tag("C3594")
        @DisplayName("If password != password confirmation for update, there is an error message")
        public void errorMessageIfPasswordNotEqualPasswordConfirmation () {
            clickEditButtonForTestUser();
            setRandomValidDifferentPasswordAndConfirmation();
            clickUpdateButton();
            checkDifferentPasswordAndConfirmationErrorMessage();
        }

        @Test
        @Order(19)
        @Tag("C3595")
        @DisplayName("If password != password confirmation for update, there is a form error message")
        public void differentPasswordAndConfirmationFormErrorMessage () {
            clickEditButtonForTestUser();
            setRandomValidDifferentPasswordAndConfirmation();
            clickUpdateButton();
            checkConfirmationPasswordFormErrorDoesNotMatchPassword();
        }

        @Test
        @Order(20)
        @Tag("C3596")
        @DisplayName("By clicking Cancel button for update, Users page is opened")
        public void usersPageOpenedByClickingCancelButton () {
            clickEditButtonForTestUser();
            clickCancelButton();
            checkUsersPageIsOpened();
        }

        @Test
        @Order(21)
        @Tag("C3597")
        @DisplayName("If role is not chosen, there is error message")
        public void errorMessageIfRoleIsNotChosen () {
            clickEditButtonForTestUser();
            uncheckAllRolesCheckboxes();
            clickUpdateButton();
            checkRoleIsNotChosenErrorMessage();
        }

        @Test
        @Order(22)
        @Tag("3598")
        @DisplayName("It is possible to update user if valid data is used")
        public void userUpdatedIfValidDataUsed () {
            clickEditButtonForTestUser();
            setRandomValidEqualPasswordAndConfirmation();
            uncheckAllRolesCheckboxes();
            enableRandomRoleCheckbox();
            clickUpdateButton();
            checkSuccessMessageIsVisible();
        }

        @Test
        @Order(23)
        @Tag("3599")
        @DisplayName("When user is updated, there is success message")
        public void successMessageWhenUserIsUpdated () {
            clickEditButtonForTestUser();
            clickUpdateButton();
            checkUserUpdatedSuccessMessage();
        }
    }

    @AfterEach
    public void closeDriver() {
        WebDriverRunner.driver().close();
    }
}
