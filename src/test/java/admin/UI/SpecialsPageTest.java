package admin.UI;

import admin.Pages.SpecialsPage;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpecialsPageTest extends SpecialsPage {

        @BeforeEach
        public void authorizeAndOpenDryCleanerPage() {
            openAdminLoginPage();
            authorizationAdmin();
            openSpecialsPage();
        }
    }

