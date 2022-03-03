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
        @DisplayName("By clicking New User button, New user page is opened ")
        public void newUserPageOpenedByClickingNewUserButton () {
            clickNewUserButton();
            checkNewUserPageOpened();
        }
    }

    @AfterEach
    public void closeDriver() {
        WebDriverRunner.driver().close();
    }
}
