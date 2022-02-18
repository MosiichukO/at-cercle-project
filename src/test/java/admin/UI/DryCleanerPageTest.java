package admin.UI;

import admin.DryCleanerPage;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static core.Config.ADMIN_AUTH_URL;

public class DryCleanerPageTest extends DryCleanerPage {

    private final String DRY_CLEANER_ADDRESS = "1" + RandomStringUtils.randomAscii(1,20);
    private final String DRY_CLEANER_NAME = "1" + RandomStringUtils.randomAscii(1,20);

    @BeforeEach
    public void authorizeAndOpenDryCleanerPage() {
        open(ADMIN_AUTH_URL);
        authorization(VALID_EMAIL, VALID_PASSWORD);
        openDryCleanerPage();
    }


    @Test
    @Tag("C3457")
    @DisplayName("Add Dry Cleaner modal is opened by clicking Add Dry Cleaner button")
    public void addDryCleanerModalOpens() {
        openAddDryCleanerModal();
        checkAddDryCleanerModalOpened();
    }

    @Test
    @Tag("C3458")
    @DisplayName("Status drop-down contains options: Active and Non active")
    public void statusDropDownOptions() {
        openAddDryCleanerModal();
        checkStatusDropDownOptions();
    }

    @Test
    @Tag("C3459")
    @DisplayName("Name can't be blank error if Name is empty")
    public void nameCanNotBeBlankError() {
        createDryCleaner("", DRY_CLEANER_ADDRESS);
        checkErrorMessage("Name can't be blank");
    }

    @Test
    @Tag("C3460")
    @DisplayName("Address can't be blank error if Address is empty")
    public void addressCanNotBeBlankError() {
        createDryCleaner(DRY_CLEANER_NAME, "");
        checkErrorMessage("Address can't be blank");
    }

    @Test
    @Tag("C3461")
    @DisplayName("Name can't be blank, Address can't be blank error if both fields are empty")
    public void nameAndAddressCanNotBeBlankError() {
        createDryCleaner("", "");
        checkErrorMessage("Name can't be blank, Address can't be blank");
    }

    @Test
    @Tag("C3462")
    @DisplayName("Dry Cleaner is created if both fields are not empty")
    public void dryCleanerCreation() {
        createDryCleaner(DRY_CLEANER_NAME, DRY_CLEANER_ADDRESS);
        checkDryCleanerCreated(DRY_CLEANER_NAME, DRY_CLEANER_ADDRESS);
    }

    @Test
    @Tag("C3465")
    @DisplayName("Dry Cleaner creation success message")
    public void dryCleanerCreationSuccessMessage() {
        createDryCleaner(DRY_CLEANER_NAME, DRY_CLEANER_ADDRESS);
        checkSuccessMessage("Dry Cleaner was successfully created.");
    }

    @AfterEach
    public void closeDriver() {
        WebDriverRunner.driver().close();
    }
}
