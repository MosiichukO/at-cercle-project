package admin.UI;

import admin.Pages.DryCleanersPage;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;



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
        @Tag("C3457")
        @DisplayName("Add Dry Cleaner modal is opened by clicking Add Dry Cleaner button")
        public void addDryCleanerModalOpens() {
            clickAddDryCleanerButton();
            checkAddDryCleanerModalOpened();
        }

        @Test
        @Order(2)
        @Tag("C3458")
        @DisplayName("Status drop-down contains options: Active and Non active [Add Dry Cleaner modal]")
        public void statusDropDownOptionsCreateModal() {
            clickAddDryCleanerButton();
            checkStatusDropDownOptionsCreate();
        }

        @Test
        @Order(3)
        @Tag("C3459")
        @DisplayName("Name can't be blank error if Name is empty [Add Dry Cleaner modal]")
        public void nameCanNotBeBlankErrorCreateModal() {
            clickAddDryCleanerButton();
            setNonEmptyAddressForCreate();
            clickCreateButton();
            checkDryCleanerCreateBlankNameError();
        }

        @Test
        @Order(4)
        @Tag("C3460")
        @DisplayName("Address can't be blank error if Address is empty [Add Dry Cleaner modal]")
        public void addressCanNotBeBlankErrorCreateModal() {
            clickAddDryCleanerButton();
            setNonEmptyNameForCreate();
            clickCreateButton();
            checkDryCleanerCreateBlankAddressError();
        }

        @Test
        @Order(5)
        @Tag("C3461")
        @DisplayName("Name can't be blank, Address can't be blank error if both fields are empty [Add Dry Cleaner modal]")
        public void nameAndAddressCanNotBeBlankErrorCreateModal() {
            clickAddDryCleanerButton();
            clickCreateButton();
            checkDryCleanerCreateBlankNameAddressError();
        }

        @Test
        @Order(6)
        @Tag("C3462")
        @DisplayName("Dry Cleaner is created if both fields are not empty [Add Dry Cleaner modal]")
        public void dryCleanerCreation() {
            clickAddDryCleanerButton();
            setNonEmptyNameForCreate();
            setNonEmptyAddressForCreate();
            clickCreateButton();
            checkDryCleanerExist();
        }

        @Test
        @Order(7)
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
        @Order(8)
        @Tag("C3466")
        @DisplayName("Edit Dry Cleaner modal is opened by clicking Edit button")
        public void editDryCleanerModalOpenedByClickingEditButton() {
            clickEditButton();
            checkEditDryCleanerModalOpened();
        }

        @Test
        @Order(9)
        @Tag("C3467")
        @DisplayName("Status drop-down contains options: Active and Non active [Edit Dry Cleaner modal]")
        public void statusDropDownOptionsEditModal() {
            clickEditButton();
            checkStatusDropDownOptionsEdit();
        }

        @Test
        @Order(10)
        @Tag("C3468")
        @DisplayName("Name can't be blank error if Name is empty [Edit Dry Cleaner modal]")
        public void nameCanNotBeBlankErrorEditModal() {
            clickEditButton();
            clearNameField();
            clickUpdateButton();
            checkDryCleanerUpdateNameBlankError();
        }

        @Test
        @Order(11)
        @Tag("C3469")
        @DisplayName("Address can't be blank error if Address is empty [Edit Dry Cleaner modal]")
        public void addressCanNotBeBlankErrorEditModal() {
            clickEditButton();
            clearAddressField();
            clickUpdateButton();
            checkDryCleanerUpdateAddressBlankError();
        }

        @Test
        @Order(12)
        @Tag("C3470")
        @DisplayName("Name can't be blank, Address can't be blank error if both fields are empty [Edit Dry Cleaner modal]")
        public void nameAndAddressCanNotBeBlankErrorEditModal() {
            clickEditButton();
            clearNameField();
            clearAddressField();
            clickUpdateButton();
            checkDryCleanerUpdateEmptyInputFieldsError();
        }

        @Test
        @Order(13)
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
        @Order(14)
        @Tag("C3472")
        @DisplayName("Edit Dry Cleaner modal is opened by clicking Dry Cleaner's name")
        public void editDryCleanerModalOpenedByClickingDryCleanerName() {
            clickDryCleanerName();
            checkEditDryCleanerModalOpened();
        }

        @Test
        @Order(15)
        @Tag("C4137")
        @DisplayName("Dry Cleaner was successfully updated. message if Dry Cleaner was updated")
        public void successDryCleanerUpdateMessage() {
            clickEditButton();
            clickUpdateButton();
            checkDryCleanerUpdateSuccessMessage();
        }

        @Test
        @Order(16)
        @Tag("C3502")
        @DisplayName("By clicking Dry Cleaner tab, Dry cleaner page is opened")
        public void dryCleanersPageOpenedByClickingDryCleanersTab() {
            checkDryCleanersPageIsOpened();
        }

        @Test
        @Order(17)
        @Tag("C3510")
        @DisplayName("By clicking Delete button, Dry cleaner is removed from dry cleaner's list ")
        public void dryCleanerRemovedFromListByClickingDeleteButton() {
            clickDeleteButton();
            confirmDryCleanerDelete();
            checkDryCleanerRemovedFromList();
        }

        @AfterAll
        public void deleteTestData () {
            deleteCreatedDryCleaner();
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

    @AfterEach
    public void closeDriver() {
        WebDriverRunner.driver().close();
    }
}
