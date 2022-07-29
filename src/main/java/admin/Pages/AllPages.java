package admin.Pages;

import admin.AdminPanelLocators;
import com.codeborne.selenide.ElementsCollection;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.open;
import static core.Config.ADMIN_AUTH_URL;

public class AllPages extends AdminPanelLocators {

    public void openAdminLoginPage() {
        open(ADMIN_AUTH_URL);
    }

    public void authorizationAdmin() {
        email_field.setValue(REGISTERED_ADMIN_EMAIL);
        password_field.setValue(REGISTERED_PASSWORD);
        login_button.click();
    }

    public void authorizationDryCleanerUser() {
        email_field.setValue(REGISTERED_DRY_CLEANER_EMAIL);
        password_field.setValue(REGISTERED_PASSWORD);
        login_button.click();
    }

    public void authorizationSupportUser() {
        email_field.setValue(REGISTERED_SUPPORT_EMAIL);
        password_field.setValue(REGISTERED_PASSWORD);
        login_button.click();
    }

    public void clickStatusDropdown() {
        filter_status_dropdown.click();
    }

    public void setDayBeforeTodayToCreatedFromDateField() {
        filter_created_at_from_field.setValue(YESTERDAY_DATE);
    }

    public void setDayTomorrowToCreatedToDateField() {
        filter_created_at_to_field.setValue(TOMORROW_DATE);
    }

    public void checkSortingByColumn(ElementsCollection info_lines, String column_td, String sort_type) {
        for (int i = 1; i < info_lines.size(); i++) {
            String str1 = info_lines.get(i - 1).find(By.xpath(column_td)).getText();
            String str2 = info_lines.get(i).find(By.xpath(column_td)).getText();
            int compare = str1.compareToIgnoreCase(str2);
            if (sort_type.equals("DESC")) {
                Assert.isTrue(compare >= 0, "Incorrect DESC sorting");
            } else if (sort_type.equals("ASC")) {
                Assert.isTrue(compare <= 0, "Incorrect ASC sorting");
            } else {
                throw new java.lang.Error("Incorrect sort type used in the method");
            }
        }
    }

    public void checkAscSortingByIdColumn(ElementsCollection info_lines, String column_td, String sort_type) {
        for (int i = 1; i < info_lines.size(); i++) {
            int id1 = Integer.parseInt(info_lines.get(i - 1).find(By.xpath(column_td)).getText());
            int id2 = Integer.parseInt(info_lines.get(i).find(By.xpath(column_td)).getText());
            if (sort_type.equals("ASC")) {
                Assert.isTrue(id2 > id1, "Incorrect sorting");
            } else if (sort_type.equals("DESC")) {
                Assert.isTrue(id2 < id1, "Incorrect sorting");
            } else {
                throw new java.lang.Error("Incorrect sort type used in the method");
            }
        }
    }


    public void checkSortingForDates(ElementsCollection info_lines, String column_td, String sort_type) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 1; i < info_lines.size(); i++) {
            Date date1 = sdf.parse(info_lines.get(i - 1).find(By.xpath(column_td)).getText());
            Date date2 = sdf.parse(info_lines.get(i).find(By.xpath(column_td)).getText());
            int compare = date1.compareTo(date2);
            if (sort_type.equals("DESC")) {
                Assert.isTrue(compare >= 0, "Incorrect DESC sorting");
            } else if (sort_type.equals("ASC")) {
                Assert.isTrue(compare <= 0, "Incorrect ASC sorting");
            } else {
                throw new java.lang.Error("Incorrect sort type used in the method");
            }
        }
    }
}
