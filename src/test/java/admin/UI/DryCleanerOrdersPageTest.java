package admin.UI;

import admin.Pages.DryCleanerOrdersPage;
import org.junit.jupiter.api.*;

public class DryCleanerOrdersPageTest extends DryCleanerOrdersPage {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class ViewFilterSortTest {
        @BeforeEach
        public void authorizeAndOpenDryCleanerPage() {
            openAdminLoginPage();
            authorizationAdmin();
            openDryCleanerOrdersPage();
        }

        @Test
        @Order(1)
        @Tag("C5463")
        @DisplayName("By clicking Dry Cleaner Orders tab, Dry Cleaner Orders page is opened")
        public void usersPageOpenedByClickingUsersTab () {
            checkDryCleanerOrdersPageIsOpened();
        }

    }
}
