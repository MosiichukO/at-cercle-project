package admin.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


public class UsersPage extends AllPages {

    public void openUsersPage() {
        users_tab.click();
    }

    public void clickRolesFilter() {
        roles_filter.click();
    }

    public void clickAdminRoleOption() {
        admin_role_option.click();
    }

    public void clickDryCleanerRoleOption() {
        dry_cleaner_role_option.click();
    }

    public void clickSupportRoleOption() {
        support_role_option.click();
    }

    public void clickSearchButton() {
        search_button.click();
    }

    public void clickNewUserButton() {new_user_button.click();}

    public void setMemberSinceStartDate() {
        member_since_start_filter_field.setValue(MEMBER_SINCE_START_DATE);
    }

    public void setSupportEmailToEmailFilter() {
        email_filter_filed.setValue(REGISTERED_SUPPORT_EMAIL);
    }

    public void setPartOfEmailToEmailFilter () {
        email_filter_filed.setValue(PART_OF_EMAIL_FOR_FILTERING);
    }

    public void checkUsersPageIsOpened() {
        page_title.shouldHave(Condition.attribute("text", USERS_PAGE_TITLE));
    }

    public void checkUsersRoleInList(String role) {
        ElementsCollection user_tr = users_table.$$(By.tagName("TR"));
        for (com.codeborne.selenide.SelenideElement selenideElement : user_tr) {
            selenideElement.find(By.xpath("td[2]")).shouldHave(Condition.exactText(role));
        }
    }

    public void checkAdminOnlyInList() {
        checkUsersRoleInList("Admin");
    }

    public void checkDryCleanerUsersOnlyInList() {
        checkUsersRoleInList("Dry cleaner");
    }

    public void checkSupportUsersOnlyInList() {
        checkUsersRoleInList("Support");
    }

    public void checkTwoRolesInList(String role) {
        ElementsCollection user_tr = users_table.$$(By.tagName("TR"));
        for (com.codeborne.selenide.SelenideElement selenideElement : user_tr) {
            selenideElement.find(By.xpath("td[2]")).shouldNotHave(Condition.exactText(role));
        }
    }

    public void checkAdminAbsentInList() {
        checkTwoRolesInList("Admin");
    }

    public void checkSupportAbsentInList() {
        checkTwoRolesInList("Support");
    }

    public void checkDryCleanerAbsentInList() {
        checkTwoRolesInList("Dry cleaner");
    }

    public void checkFilterResultsBySupportEmail() {
        ElementsCollection user_tr = users_table.$$(By.tagName("TR"));
        for (com.codeborne.selenide.SelenideElement selenideElement : user_tr) {
            selenideElement.find(By.xpath("td[1]")).shouldHave(Condition.exactText(REGISTERED_SUPPORT_EMAIL));
        }
    }

    public void checkFilterResultsByPartOfEmail () {
        ElementsCollection user_tr = users_table.$$(By.tagName("TR"));
        for (com.codeborne.selenide.SelenideElement selenideElement : user_tr) {
            selenideElement.find(By.xpath("td[1]")).shouldHave(Condition.matchText(".*" + PART_OF_EMAIL_FOR_FILTERING + ".*"));
        }
    }

    public void checkNewUserPageOpened () {
        page_title.shouldHave(Condition.attribute("text", NEW_USER_PAGE_TITLE));
    }
}
