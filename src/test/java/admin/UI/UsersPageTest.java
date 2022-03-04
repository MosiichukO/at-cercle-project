package admin.UI;

import admin.Pages.UsersPage;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

public class UsersPageTest extends UsersPage {

    @BeforeEach
    public void authorizeAndOpenDryCleanerPage() {
        openAdminLoginPage();
        authorizationAdmin();
        openUsersPage();
    }

    @Nested
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
    }

    @Nested
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
        @Tag("C3515")
        @DisplayName("If email is empty, there is error message: Email can't be blank")
        public void emailCanNotBeBlankErrorMessage () {
            clickNewUserButton();
            setRandomValidEqualPasswordAndConfirmation();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkUserCreateEmailBlankError();
        }

        @Test
        @Order(3)
        @Tag("C3516")
        @DisplayName("If password is empty, there is error message: Password can't be blank")
        public void passwordCanNotBeBlankErrorMessage () {
            clickNewUserButton();
            setRandomValidEmail();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkUserCreatePasswordBlankError();
        }

        @Test
        @Order(4)
        @Tag("C3517")
        @DisplayName("If email is empty, Email field is highlighted in red")
        public void redBorderIfEmailIsEmpty () {
            clickNewUserButton();
            setRandomValidEqualPasswordAndConfirmation();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkErrorEmailFieldBorderColor();
        }

        @Test
        @Order(5)
        @Tag("C3519")
        @DisplayName("If password is empty, Password field is highlighted in red")
        public void redBorderIfPasswordIsEmpty () {
            clickNewUserButton();
            setRandomValidEmail();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkErrorPasswordFieldBorderColor();
        }

        @Test
        @Order(6)
        @Tag("C3525")
        @DisplayName("If password consists of < 6 symbols, Password field is highlighted in red")
        public void redBorderIfPasswordLessThanSixSymbols () {
            clickNewUserButton();
            setRandomValidEmail();
            setRandomInvalidLengthEqualPasswordAndConfirmation();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkErrorPasswordFieldBorderColor();
        }

        @Test
        @Order(7)
        @Tag("C3527")
        @DisplayName("If email already exists in DB, there is error message: Email has been already taken")
        public void emailTakenErrorIfEmailExistsInDB () {
            clickNewUserButton();
            setExistingEmail();
            setRandomValidEqualPasswordAndConfirmation();
            clickRandomRoleUserCreation();
            clickCreateButton();
            checkUserCreateEmailExistingError();
        }

        @Test
        @Order(8)
        @Tag("C3528")
        @DisplayName("If email already exists in DB, Email field is highlighted in red")
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
        @Tag("C3530")
        @DisplayName("By clicking Cancel button, Users page is opened")
        public void usersPageOpenedByClickingCancelButton () {
            clickNewUserButton();
            clickCancelButton();
            checkUsersPageIsOpened();
        }

        @Test
        @Order(10)
        @Tag("C3531")
        @DisplayName("If email doesn't contain @ and is not empty, there is an error tooltip")
        public void errorTooltipIfEmailWithoutAmpersand () {
            clickNewUserButton();
            setRandomEmailWithoutAmpersand();
            clickCreateButton();
            checkTooltipEmailWithoutAmpersand();
        }

        @Test
        @Order(11)
        @Tag("C3532")
        @DisplayName("If email contains @ but there are no symbols before it, there is error tooltip")
        public void errorTooltipIfEmailWithoutPartBeforeAmpersand () {
            clickNewUserButton();
            setRandomEmailWithoutPartBeforeAmpersand();
            clickCreateButton();
            checkTooltipEmailWithoutPartBeforeAmpersand();
        }

        @Test
        @Order(12)
        @Tag("C3533")
        @DisplayName("If email contains @ but there are no symbols after it, there is an error tooltip")
        public void errorTooltipIfEmailWithoutPartAfterAmpersand () {
            clickNewUserButton();
            setRandomEmailWithoutPartAfterAmpersand();
            clickCreateButton();
            checkTooltipEmailWithoutPartAfterAmpersand();
        }

        @Test
        @Order(13)
        @Tag("C3534")
        @DisplayName("If email contains @ and a dot after it, there is an error tooltip")
        public void errorTooltipIfEmailDorRightAfterAmpersand () {
            clickNewUserButton();
            setRandomEmailWithDotRightAfterAmpersand();
            clickCreateButton();
            checkTooltipEmailWithDotRightAfterAmpersand();
        }
    }

    @AfterEach
    public void closeDriver() {
        WebDriverRunner.driver().close();
    }
}
