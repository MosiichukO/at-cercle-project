package admin.UI;

import admin.Pages.ConciergeRequestsPage;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

import java.text.ParseException;

public class ConciergeRequestsPageTest extends ConciergeRequestsPage {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class AdminRoleTest {

        @BeforeEach
        public void authorizeAndOpenConciergeRequestsPage() {
            openAdminLoginPage();
            authorizationAdmin();
            openConciergeRequestsPage();
        }

        @Test
        @Order(1)
        @Tag("C12875")
        @DisplayName("By clicking Concierge Requests tab, Concierge Requests page is opened")
        public void conciergeRequestsPageOpenedByClickingConciergeRequestsTab() {
            checkConciergeRequestsPageIsOpened();
        }

        @Test
        @Order(2)
        @Tag("C12881")
        @DisplayName("If liter by Pending status is applied, only requests with Pending status are displayed")
        public void checkFilterByPendingStatus () {
            clickStatusDropdown();
            choosePendingStatusOption();
            clickSearchButton();
            checkPendingStatusConciergeRequestsOnlyInList();
        }

        @Test
        @Order(3)
        @Tag("C12882")
        @DisplayName("If liter by In progress status is applied, only requests with In progress status are displayed")
        public void checkFilterByInProgressStatus () {
            clickStatusDropdown();
            chooseInProgressStatusOption();
            clickSearchButton();
            checkInProgressStatusConciergeRequestsOnlyInList();
        }

        @Test
        @Order(4)
        @Tag("C12883")
        @DisplayName("If liter by Completed status is applied, only requests with Completed status are displayed")
        public void checkFilterByCompletedStatus () {
            clickStatusDropdown();
            chooseCompletedStatusOption();
            clickSearchButton();
            checkCompletedStatusConciergeRequestsOnlyInList();
        }

        @Test
        @Order(5)
        @Tag("C12884")
        @DisplayName("If liter by Canceled status is applied, only requests with Canceled status are displayed")
        public void checkFilterByCanceledStatus () {
            clickStatusDropdown();
            chooseCanceledStatusOption();
            clickSearchButton();
            checkCanceledStatusConciergeRequestsOnlyInList();
        }

        @Test
        @Order(6)
        @Tag("C12885")
        @DisplayName("It is possible to filter Concierge requests by Created at From date")
        public void checkFilterByCreatedFromDate () {
            setDayBeforeTodayToCreatedFromDateField();
            clickStatusDropdown();
            clickSearchButton();
            checkConciergeRequestsCreatedAtFromDate();
        }

        @Test
        @Order(7)
        @Tag("C12492")
        @DisplayName("It is possible to filter Dry cleaners by Created at To date")
        public void checkFilterByCreatedToDate () {
            setDayTomorrowToCreatedToDateField();
            clickStatusDropdown();
            clickSearchButton();
            checkConciergeRequestsCreatedAtToDate();
        }

        @Test
        @Order(8)
        @Tag("C12887")
        @DisplayName("It is possible to filter Concierge requests by Created at From and Created at To date")
        public void checkFilterByCreatedFromAndToDates () {
            setDayBeforeTodayToCreatedFromDateField();
            setDayTomorrowToCreatedToDateField();
            clickStatusDropdown();
            clickSearchButton();
            checkConciergeRequestsCreatedAtFromDate();
        }

        @Test
        @Order(9)
        @Tag("C12888")
        @DisplayName("By first click on Id column's name, Concierge requests are sorted by id in DESC order")
        public void checkDescSortingById () {
            clickIdColumn();
            checkConciergeRequestsDescSortingByIdColumn();
        }

        @Test
        @Order(10)
        @Tag("C12889")
        @DisplayName("By second click on Id column's name, Concierge requests are sorted by id in ASC order")
        public void checkAscSortingById () {
            clickIdColumn();
            clickIdColumn();
            checkConciergeRequestsAscSortingByIdColumn();
        }

        @Test
        @Order(11)
        @Tag("C13502")
        @DisplayName("By first click on Full Name column's name, Concierge requests are sorted by full name in DESC order")
        public void checkDescSortingByFullName () {
            clickFullNameColumn();
            checkConciergeRequestsDescSortingByFullNameColumn();
        }

        @Test
        @Order(12)
        @Tag("C13503")
        @DisplayName("By second click on Full Name column's name, Concierge requests are sorted by full name in ASC order")
        public void checkAscSortingByFullName () {
            clickFullNameColumn();
            clickFullNameColumn();
            checkConciergeRequestsAscSortingByFullNameColumn();
        }

        @Test
        @Order(13)
        @Tag("C12894")
        @DisplayName("By first click on Email column's name, Concierge requests are sorted by email in DESC order")
        public void checkDescSortingByEmail () {
            clickEmailColumn();
            checkConciergeRequestsDescSortingByEmailColumn();
        }

        @Test
        @Order(14)
        @Tag("C12895")
        @DisplayName("By second click on Email column's name, Concierge requests are sorted by email in ASC order")
        public void checkAscSortingByEmail () {
            clickEmailColumn();
            clickEmailColumn();
            checkConciergeRequestsAscSortingByEmailColumn();
        }

        @Test
        @Order(15)
        @Tag("C12892")
        @DisplayName("By first click on Phone column's name, Concierge requests are sorted by phone in DESC order")
        public void checkDescSortingByPhone () {
            clickPhoneColumn();
            checkConciergeRequestsDescSortingByPhoneColumn();
        }

        @Test
        @Order(16)
        @Tag("C12893")
        @DisplayName("By second click on Phone column's name, Concierge requests are sorted by phone in ASC order")
        public void checkAscSortingByPhone () {
            clickPhoneColumn();
            clickPhoneColumn();
            checkConciergeRequestsAscSortingByPhoneColumn();
        }

        @Test
        @Order(17)
        @Tag("C12900")
        @DisplayName("By first click on Created at column's name, Concierge requests are sorted by created at date in DESC order")
        public void checkDescSortingByCreatedAt () {
            clickCreatedAtColumn();
            checkConciergeRequestsDescSortingByCreatedAtColumn();
        }

        @Test
        @Order(18)
        @Tag("C12901")
        @DisplayName("By second click on Created at column's name, Concierge requests are sorted by created at date in ASC order")
        public void checkAscSortingByCreatedAt () {
            clickCreatedAtColumn();
            clickCreatedAtColumn();
            checkConciergeRequestsAscSortingByCreatedAtColumn();
        }

        @Test
        @Order(19)
        @Tag("C12896")
        @DisplayName("By first click on Pick up datetime column's name, Concierge requests are sorted by pick up date time in DESC order")
        public void checkDescSortingByPickUpDate () throws ParseException {
            clickPickUpDatetimeColumn();
            checkConciergeRequestsDescSortingByPickUpDatetimeColumn();
        }

        @Test
        @Order(20)
        @Tag("C12897")
        @DisplayName("By second click on Pick up datetime column's name, Concierge requests are sorted by pick up date time in ASC order")
        public void checkAscSortingByPickUpDate () throws ParseException {
            clickPickUpDatetimeColumn();
            clickPickUpDatetimeColumn();
            checkConciergeRequestsAscSortingByPickUpDatetimeColumn();
        }

        @Test
        @Order(21)
        @Tag("C12902")
        @DisplayName("By clicking Info button, Concierge Request Info modal is opened")
        public void byClickingInfoButtonConciergeRequestInfoModalOpens () {

        }

    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class SupportRoleTest {

        @Test
        @Order(1)
        @Tag("C12957, C12877")
        @DisplayName("Support user doesn't see Requests tab")
        public void supportUserDoesNotSeeRequestsTab() {
            openAdminLoginPage();
            authorizationSupportUser();
            checkRequestsTabIsNotVisible();
        }
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class DryCleanerRoleTest {

        @Test
        @Order(1)
        @Tag("C12956, С12876")
        @DisplayName("Dry cleaner user doesn't see Requests tab")
        public void dryCleanerUserDoesNotSeeRequestsTab() {
            openAdminLoginPage();
            authorizationDryCleanerUser();
            checkRequestsTabIsNotVisible();
        }
    }

    @AfterEach
    public void closeDriver() {
        WebDriverRunner.driver().close();
    }

}
