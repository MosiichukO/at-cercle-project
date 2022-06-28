package admin.UI;

import admin.Pages.GroupOfItemsPage;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GroupOfItemsPageTest extends GroupOfItemsPage {

    @BeforeEach
    public void authorizeAndOpenGroupOfItemsPage() {
        openAdminLoginPage();
        authorizationAdmin();
        openGroupOfItemsPage();
    }
}

