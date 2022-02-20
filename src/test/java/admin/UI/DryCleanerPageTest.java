package admin.UI;

import admin.DryCleanerPage;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static core.Config.ADMIN_AUTH_URL;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DryCleanerPageTest extends DryCleanerPage {

    private final String DRY_CLEANER_ADDRESS = "qa_auto_address";
    private final String DRY_CLEANER_NAME = "1-qa_auto_name";
    private final String DRY_CLEANER_ADDRESS_UPDATED = "qa_auto_address_updated";
    private final String DRY_CLEANER_NAME_UPDATED = "1-qa_auto_name_updated";
    private final String NAME_BLANK_ERROR = "Name can't be blank";
    private final String ADDRESS_BLANK_ERROR = "Address can't be blank";
    private final String NAME_ADDRESS_BLANK_ERROR = "Name can't be blank, Address can't be blank";

    @BeforeEach
    public void authorizeAndOpenDryCleanerPage() {
        open(ADMIN_AUTH_URL);
        authorization(VALID_EMAIL, VALID_PASSWORD);
        openDryCleanerPage();
    }


    @Test @Order(1)
    @Tag("C3457")
    @DisplayName("Add Dry Cleaner modal is opened by clicking Add Dry Cleaner button")
    public void addDryCleanerModalOpens() {
        openAddDryCleanerModal();
        checkAddDryCleanerModalOpened();
    }

    @Test @Order(2)
    @Tag("C3458")
    @DisplayName("Status drop-down contains options: Active and Non active [Add Dry Cleaner modal]")
    public void statusDropDownOptionsCreateModal() {
        openAddDryCleanerModal();
        checkStatusDropDownOptions("Create modal");
    }

    @Test @Order(3)
    @Tag("C3459")
    @DisplayName("Name can't be blank error if Name is empty [Add Dry Cleaner modal]")
    public void nameCanNotBeBlankErrorCreateModal() {
        createDryCleaner("", DRY_CLEANER_ADDRESS);
        checkErrorMessage(NAME_BLANK_ERROR);
    }

    @Test @Order(4)
    @Tag("C3460")
    @DisplayName("Address can't be blank error if Address is empty [Add Dry Cleaner modal]")
    public void addressCanNotBeBlankErrorCreateModal() {
        createDryCleaner(DRY_CLEANER_NAME, "");
        checkErrorMessage(ADDRESS_BLANK_ERROR);
    }

    @Test @Order(5)
    @Tag("C3461")
    @DisplayName("Name can't be blank, Address can't be blank error if both fields are empty [Add Dry Cleaner modal]")
    public void nameAndAddressCanNotBeBlankErrorCreateModal() {
        createDryCleaner("", "");
        checkErrorMessage(NAME_ADDRESS_BLANK_ERROR);
    }

    @Test @Order(6)
    @Tag("C3462")
    @DisplayName("Dry Cleaner is created if both fields are not empty [Add Dry Cleaner modal]")
    public void dryCleanerCreation() {
        createDryCleaner(DRY_CLEANER_NAME, DRY_CLEANER_ADDRESS);
        checkDryCleanerExist(DRY_CLEANER_NAME, DRY_CLEANER_ADDRESS);
    }

    @Test @Order(7)
    @Tag("C3465")
    @DisplayName("Dry Cleaner creation success message")
    public void dryCleanerCreationSuccessMessage() {
        createDryCleaner(DRY_CLEANER_NAME, DRY_CLEANER_ADDRESS);
        checkSuccessMessage("Dry Cleaner was successfully created.");
    }

    @Test @Order(8)
    @Tag("C3466")
    @DisplayName("Edit Dry Cleaner modal is opened by clicking Edit button")
    public void editDryCleanerModalOpenedByClickingEditButton() {
        openEditDryCleanerModal(DRY_CLEANER_NAME, "Edit button");
        checkEditDryCleanerModalOpened();
    }

    @Test @Order(9)
    @Tag("C3467")
    @DisplayName("Status drop-down contains options: Active and Non active [Edit Dry Cleaner modal]")
    public void statusDropDownOptionsEditModal() {
        openEditDryCleanerModal(DRY_CLEANER_NAME, "Edit button");
        checkStatusDropDownOptions("Edit modal");
    }

    @Test @Order(10)
    @Tag("C3468")
    @DisplayName("Name can't be blank error if Name is empty [Edit Dry Cleaner modal]")
    public void nameCanNotBeBlankErrorEditModal() {
        editDryCleaner(DRY_CLEANER_NAME, "", DRY_CLEANER_ADDRESS);
        checkErrorMessage(NAME_BLANK_ERROR);
    }

    @Test @Order(11)
    @Tag("C3469")
    @DisplayName("Address can't be blank error if Address is empty [Edit Dry Cleaner modal]")
    public void addressCanNotBeBlankErrorEditModal() {
        editDryCleaner(DRY_CLEANER_NAME, DRY_CLEANER_ADDRESS, "");
        checkErrorMessage(ADDRESS_BLANK_ERROR);
    }

    @Test @Order(12)
    @Tag("C3470")
    @DisplayName("Name can't be blank, Address can't be blank error if both fields are empty [Edit Dry Cleaner modal]")
    public void nameAndAddressCanNotBeBlankErrorEditModal() {
        editDryCleaner(DRY_CLEANER_NAME, "", "");
        checkErrorMessage(NAME_ADDRESS_BLANK_ERROR);
    }

    @Test @Order(13)
    @Tag("C3471")
    @DisplayName("Dry Cleaner is updated if both fields are not empty [Edit Dry Cleaner modal]")
    public void dryCleanerUpdate() {
        editDryCleaner(DRY_CLEANER_NAME, DRY_CLEANER_NAME_UPDATED, DRY_CLEANER_ADDRESS_UPDATED);
        checkDryCleanerExist(DRY_CLEANER_NAME_UPDATED, DRY_CLEANER_ADDRESS_UPDATED);
    }

    @Test @Order(14)
    @Tag("C3472")
    @DisplayName("Edit Dry Cleaner modal is opened by clicking Dry Cleaner's name")
    public void editDryCleanerModalOpenedByClickingDryCleanerName() {
        openEditDryCleanerModal(DRY_CLEANER_NAME_UPDATED, "Dry Cleaner name");
        checkEditDryCleanerModalOpened();
    }

    @AfterEach
    public void closeDriver() {
        WebDriverRunner.driver().close();
    }
}
