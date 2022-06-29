package admin.UI;

import admin.Pages.DryCleanersPage;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

import java.text.ParseException;


public class DryCleanerPageTest extends DryCleanersPage {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class AdminRoleTest {
        @BeforeEach
        public void authorizeAndOpenDryCleanerPage() {
            openAdminLoginPage();
            authorizationAdmin();
            openDryCleanerPage();
        }

        @Test
        @Order(1)
        @Tag("C3502")
        @DisplayName("By clicking Dry Cleaner tab, Dry cleaner page is opened")
        public void dryCleanersPageOpenedByClickingDryCleanersTab() {
            checkDryCleanersPageIsOpened();
        }

        @Test
        @Order(2)
        @Tag("C3457")
        @DisplayName("Add Dry Cleaner modal is opened by clicking Add Dry Cleaner button")
        public void addDryCleanerModalOpens() {
            clickAddDryCleanerButton();
            checkAddDryCleanerModalOpened();
        }

        @Test
        @Order(3)
        @Tag("C3458")
        @DisplayName("Status drop-down contains options: Active and Non active [Add Dry Cleaner modal]")
        public void statusDropDownOptionsCreateModal() {
            clickAddDryCleanerButton();
            checkStatusDropDownOptionsCreate();
        }

        @Test
        @Order(4)
        @Tag("C3459")
        @DisplayName("Name can't be blank error if Name is empty [Add Dry Cleaner modal]")
        public void nameCanNotBeBlankErrorCreateModal() {
            clickAddDryCleanerButton();
            setNonEmptyAddressForCreate();
            clickCreateButton();
            checkDryCleanerCreateBlankNameError();
        }

        @Test
        @Order(5)
        @Tag("C3460")
        @DisplayName("Address can't be blank error if Address is empty [Add Dry Cleaner modal]")
        public void addressCanNotBeBlankErrorCreateModal() {
            clickAddDryCleanerButton();
            setNonEmptyNameForCreate();
            clickCreateButton();
            checkDryCleanerCreateBlankAddressError();
        }

        @Test
        @Order(6)
        @Tag("C3461")
        @DisplayName("Name can't be blank error if Address and Name fields are empty [Add Dry Cleaner modal]")
        public void nameAndAddressCanNotBeBlankErrorCreateModal() {
            clickAddDryCleanerButton();
            clickCreateButton();
            checkDryCleanerCreateBlankNameAddressError();
        }

        @Test
        @Order(7)
        @Tag("C3462")
        @DisplayName("Dry Cleaner is created if Address and Name fields are not empty [Add Dry Cleaner modal]")
        public void dryCleanerCreation() {
            clickAddDryCleanerButton();
            setNonEmptyNameForCreate();
            setNonEmptyAddressForCreate();
            clickCreateButton();
            checkDryCleanerExist();
        }

        @Test
        @Order(8)
        @Tag("C3465")
        @DisplayName("Dry Cleaner creation success message")
        public void dryCleanerCreationSuccessMessage() {
            clickAddDryCleanerButton();
            setNonEmptyNameForCreate();
            setNonEmptyAddressForCreate();
            clickCreateButton();
            checkDryCleanerCreationSuccessMessage();
        }

        @Test
        @Order(9)
        @Tag("C3466")
        @DisplayName("Edit Dry Cleaner modal is opened by clicking Edit button")
        public void editDryCleanerModalOpenedByClickingEditButton() {
            clickEditButton();
            checkEditDryCleanerModalOpened();
        }

        @Test
        @Order(10)
        @Tag("C3467")
        @DisplayName("Status drop-down contains options: Active and Non active [Edit Dry Cleaner modal]")
        public void statusDropDownOptionsEditModal() {
            clickEditButton();
            checkStatusDropDownOptionsEdit();
        }

        @Test
        @Order(11)
        @Tag("C3468")
        @DisplayName("Name can't be blank error if Name is empty [Edit Dry Cleaner modal]")
        public void nameCanNotBeBlankErrorEditModal() {
            clickEditButton();
            clearNameField();
            clickUpdateButton();
            checkDryCleanerUpdateNameBlankError();
        }

        @Test
        @Order(12)
        @Tag("C3469")
        @DisplayName("Address can't be blank error if Address is empty [Edit Dry Cleaner modal]")
        public void addressCanNotBeBlankErrorEditModal() {
            clickEditButton();
            clearAddressField();
            clickUpdateButton();
            checkDryCleanerUpdateAddressBlankError();
        }

        @Test
        @Order(13)
        @Tag("C3470")
        @DisplayName("Name can't be blank error if both fields are empty [Edit Dry Cleaner modal]")
        public void nameAndAddressCanNotBeBlankErrorEditModal() {
            clickEditButton();
            clearNameField();
            clearAddressField();
            clickUpdateButton();
            checkDryCleanerUpdateEmptyInputFieldsError();
        }

        @Test
        @Order(14)
        @Tag("C3471")
        @DisplayName("Dry Cleaner is updated if both fields are not empty [Edit Dry Cleaner modal]")
        public void dryCleanerUpdate() {
            clickEditButton();
            setNewNameForUpdate();
            setNewAddressForUpdate();
            clickUpdateButton();
            checkDryCleanerUpdated();
        }

        @Test
        @Order(15)
        @Tag("C3472")
        @DisplayName("Edit Dry Cleaner modal is opened by clicking Dry Cleaner's name")
        public void editDryCleanerModalOpenedByClickingDryCleanerName() {
            clickDryCleanerName();
            checkEditDryCleanerModalOpened();
        }

        @Test
        @Order(16)
        @Tag("C4137")
        @DisplayName("Dry Cleaner was successfully updated. message if Dry Cleaner was updated")
        public void successDryCleanerUpdateMessage() {
            clickEditButton();
            clickUpdateButton();
            checkDryCleanerUpdateSuccessMessage();
        }

        @Test
        @Order(17)
        @Tag("C12489")
        @DisplayName("If filter by Active status is applied, only Dry Cleaners with Active status are displayed in the table")
        public void checkFilterByActiveStatus () {
            clickStatusDropdown();
            chooseActiveStatusOption();
            clickSearchButton();
            checkActiveStatusDryCleanersOnlyInList();
        }

        @Test
        @Order(18)
        @Tag("C12490")
        @DisplayName("If filter by Non Active status is applied, only Dry Cleaners with Non Active status are displayed in the table")
        public void checkFilterByNonActiveStatus () {
            clickStatusDropdown();
            chooseNonActiveStatusOption();
            clickSearchButton();
            checkNonActiveStatusDryCleanersOnlyInList();
        }

        @Test
        @Order(19)
        @Tag("C12487")
        @DisplayName("It is possible to filter Dry cleaners by Name with partial match")
        public void checkSearchByName () {
            setExistingDryCleanerNameToNameField();
            clickSearchButton();
            checkDryCleanerNameInList();
        }

        @Test
        @Order(20)
        @Tag("C12488")
        @DisplayName("It is possible to filter Dry cleaners by Address with partial match")
        public void checkSearchByAddress () {
            setExistingDryCleanerAddressToAddressField();
            clickSearchButton();
            checkDryCleanerNameInList();
        }

        @Test
        @Order(21)
        @Tag("C12491")
        @DisplayName("It is possible to filter Dry cleaners by Created at From date")
        public void checkFilterByCreatedFromDate () {
            setDayBeforeTodayToCreatedFromDateField();
            clickSearchButton();
            checkDryCleanerCreatedAtFromDate();
        }

        @Test
        @Order(22)
        @Tag("C12492")
        @DisplayName("It is possible to filter Dry cleaners by Created at To date")
        public void checkFilterByCreatedToDate () {
            setDayTomorrowToCreatedToDateField();
            clickSearchButton();
            checkDryCleanerCreatedAtToDate();
        }

        @Test
        @Order(23)
        @Tag("C12493")
        @DisplayName("It is possible to filter Dry cleaners by Created at From and Created at To date")
        public void checkFilterByCreatedFromAndToDates () {
            setDayBeforeTodayToCreatedFromDateField();
            setDayTomorrowToCreatedToDateField();
            clickSearchButton();
            checkDryCleanerCreatedAtFromDate();
        }

        @Test
        @Order(24)
        @Tag("C12517")
        @DisplayName("By first click on Id column's name, Dry Cleaners are sorted by id in DESC order")
        public void checkDescSortingById () {
            clickIdColumn();
            checkDryCleanersDescSortingByIdColumn();

        }

        @Test
        @Order(25)
        @Tag("C12518")
        @DisplayName("By second click on Id column's name, Dry Cleaners are sorted by id in ASC order")
        public void checkAscSortingById () {
            clickIdColumn();
            clickIdColumn();
            checkDryCleanersAscSortingByIdColumn();
        }

        @Test
        @Order(26)
        @Tag("C12519")
        @DisplayName("By first click on Name column's name, Dry Cleaners are sorted by name in DESC order")
        public void checkDescSortingByName () {
            clickNameColumn();
            checkDryCleanersDescSortingByNameColumn();
        }

        @Test
        @Order(27)
        @Tag("C12520")
        @DisplayName("By second click on Name column's name, Dry Cleaners are sorted by name in ASC order")
        public void checkAscSortingByName () {
            clickNameColumn();
            clickNameColumn();
            checkDryCleanersAscSortingByNameColumn();
        }

        @Test
        @Order(28)
        @Tag("C12521")
        @DisplayName("By first click on Address column's name, Dry Cleaners are sorted by address in DESC order")
        public void checkDescSortingByAddress () {
            clickAddressColumn();
            checkDryCleanersDescSortingByAddressColumn();
        }

        @Test
        @Order(29)
        @Tag("C12522")
        @DisplayName("By second click on Address column's name, Dry Cleaners are sorted by address in ASC order")
        public void checkAscSortingByAddress () {
            clickAddressColumn();
            clickAddressColumn();
            checkDryCleanersAscSortingByAddressColumn();
        }

        @Test
        @Order(30)
        @Tag("C12523")
        @DisplayName("By first click on Contact Details column's name, Dry Cleaners are sorted by contact details in DESC order")
        public void checkDescSortingByContactDetails () {
            clickContactDetailsColumn();
            checkDryCleanersDescSortingByContactDetailsColumn();
        }

        @Test
        @Order(31)
        @Tag("C12524")
        @DisplayName("By second click on Contact Details column's name, Dry Cleaners are sorted by contact details in ASC order")
        public void checkAscSortingByContactDetails () {
            clickContactDetailsColumn();
            clickContactDetailsColumn();
            checkDryCleanersAscSortingByContactDetailsColumn();
        }

        @Test
        @Order(32)
        @Tag("C12525")
        @DisplayName("By first click on User column's name, Dry Cleaners are sorted by user in DESC order")
        public void checkDescSortingByUser () {
            clickUserColumn();
            checkDryCleanersDescSortingByUserColumn();
        }

        @Test
        @Order(33)
        @Tag("C12526")
        @DisplayName("By second click on User column's name, Dry Cleaners are sorted by user in ASC order")
        public void checkAscSortingByUser () {
            clickUserColumn();
            clickUserColumn();
            checkDryCleanersAscSortingByUserColumn();
        }

        @Test
        @Order(33)
        @Tag("C12527")
        @DisplayName("By first click on Status column's name, Dry Cleaners are sorted by status in DESC order")
        public void checkDescSortingByStatus () {
            clickStatusColumn();
            checkDryCleanersDescSortingByStatusColumn();
        }

        @Test
        @Order(34)
        @Tag("C12528")
        @DisplayName("By second click on Status column's name, Dry Cleaners are sorted by status in ASC order")
        public void checkAscSortingByStatus () {
            clickStatusColumn();
            clickStatusColumn();
            checkDryCleanersAscSortingByStatusColumn();
        }

        @Test
        @Order(35)
        @Tag("C12529")
        @DisplayName("By first click on Created at column's name, Dry Cleaners are sorted by created at date in DESC order")
        public void checkDescSortingByCreatedAt () throws ParseException {
            clickCreatedAtColumn();
            checkDryCleanersDescSortingByCreatedAtColumn();
        }

        @Test
        @Order(36)
        @Tag("C12530")
        @DisplayName("By second click on Created at column's name, Dry Cleaners are sorted by created at date in ASC order")
        public void checkAscSortingByCreatedAt () throws ParseException {
            clickCreatedAtColumn();
            clickCreatedAtColumn();
            checkDryCleanersAscSortingByCreatedAtColumn();
        }

        @Test
        @Order(37)
        @Tag("C3510")
        @DisplayName("By clicking Delete button, Dry cleaner is removed from dry cleaner's list")
        public void dryCleanerRemovedFromListByClickingDeleteButton() {
            clickDeleteButtonForUpdatedDc();
            confirmDryCleanerDelete();
            checkUpdatedDryCleanerRemovedFromList();
        }

        @Test
        @Order(38)
        @Tag("C5475")
        @DisplayName("Dry Cleaner was successfully destroyed. message if Dry Cleaner was deleted")
        public void successDryCleanerDeleteMessage() {
            clickDeleteButtonForNotUpdatedDc();
            confirmDryCleanerDelete();
            checkDryCleanerDeleteSuccessMessage();
        }

        @Test
        @Order(39)
        @Tag("C12497")
        @DisplayName("It is possible to create Dry cleaner if Name, Address and Contact Details fields are not empty")
        public void dryCleanerCreationWithContactDetails() {
            clickAddDryCleanerButton();
            setNonEmptyNameForCreate();
            setNonEmptyAddressForCreate();
            setNonEmptyContactDetailsForCreate();
            clickCreateButton();
            checkDryCleanerExist();
        }

        @Test
        @Order(40)
        @Tag("C12500")
        @DisplayName("Name field is prefilled with Dry Cleaner's name when Edit Dry Cleaner modal is opened")
        public void nameFieldIsPrefilledInEditModal () {
            clickEditButton();
            checkFieldNameHasActualName();
        }

        @Test
        @Order(41)
        @Tag("C12501")
        @DisplayName("Address field is prefilled with Dry Cleaner's address when Edit Dry Cleaner modal is opened")
        public void addressFieldIsPrefilledInEditModal () {
            clickEditButton();
            checkFieldAddressHasActualAddress();
        }

        @Test
        @Order(42)
        @Tag("C12502")
        @DisplayName("Contact Details field is prefilled with Dry Cleaner's contact details when Edit Dry Cleaner modal is opened")
        public void contactDetailsFieldIsPrefilledInEditModal () {
            clickEditButton();
            checkFieldContactDetailsHasActualContactDetails();
        }

        @Test
        @Order(43)
        @Tag("C12504")
        @DisplayName("Status dropdown is prefilled with Dry Cleaner's status when Edit Dry Cleaner modal is opened")
        public void statusDropdownIsPrefilledInEditModal () {
            clickEditButton();
            checkStatusDropdownHasActualStatus();
        }

        @Test
        @Order(44)
        @Tag("C12503")
        @DisplayName("User dropdown is prefilled with Dry Cleaner's user when Edit Dry Cleaner modal is opened")
        public void userDropdownIsPrefilledInEditModal () {
            clickEditButton();
            checkUserDropdownHasActualStatus();
        }

        @AfterAll
        public void deleteCreatedDryCleaners() {
            openAdminLoginPage();
            authorizationAdmin();
            openDryCleanerPage();
            clickDeleteButtonForNotUpdatedDc();
            confirmDryCleanerDelete();
            checkDryCleanerDeleteSuccessMessage();
        }

    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class SupportRoleTest {

        @Test
        @Order(1)
        @Tag("C3508")
        @DisplayName("Support user doesn't see Dry cleaners tab ")
        public void supportUserDoesNotSeeDryCleanersTab() {
            openAdminLoginPage();
            authorizationSupportUser();
            checkDryCleanersTabIsNotVisible();
        }
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class DryCleanerRoleTest {

        @Test
        @Order(1)
        @Tag("C12486")
        @DisplayName("By clicking Dry Cleaners tab, Dry Cleaners page is opened for Dry cleaner user")
        public void dryCleanersPageOpenedByClickingDryCleanersTabForDryCleaner() {
            openAdminLoginPage();
            authorizationDryCleanerUser();
            checkDryCleanersPageIsOpened();
        }

        @Test
        @Order(2)
        @Tag("C12499")
        @DisplayName("There isn't Add Dry Cleaner button for Dry cleaner user")
        public void noAddDryCleanerButtonForDryCleanerUser () {
            openAdminLoginPage();
            authorizationDryCleanerUser();
            checkAddDryCleanerButtonIsNotVisible();
        }
    }

    @AfterEach
    public void closeDriver() {
        WebDriverRunner.driver().close();
    }


}
