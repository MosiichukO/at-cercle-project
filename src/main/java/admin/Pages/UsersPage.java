package admin.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.util.*;


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

    public void clickRandomRoleUserCreation () {
        List<String> roles = Arrays.asList("Admin", "Support", "Dry cleaner");
        Random rand = new Random();
        String randomRole = roles.get(rand.nextInt(roles.size()));
        switch (randomRole) {
            case "Admin" -> new_user_admin_checkbox.click();
            case "Support" -> new_user_support_checkbox.click();
            case "Dry cleaner" -> new_user_dry_cleaner_checkbox.click();
        }
    }

    public void clickCreateButton () {
        new_user_create_button.click();
    }

    public void clickCancelButton () {
        new_user_cancel_button.click();
    }

    public void setMemberSinceStartDate() {
        member_since_start_filter_field.setValue(MEMBER_SINCE_START_DATE);
    }

    public void setSupportEmailToEmailFilter() {
        email_filter_filed.setValue(REGISTERED_SUPPORT_EMAIL);
    }

    public void setPartOfEmailToEmailFilter () {
        email_filter_filed.setValue(PART_OF_EMAIL_FOR_FILTERING);
    }

    public void setRandomValidEqualPasswordAndConfirmation () {
        UUID uuid = UUID.randomUUID();
        String random_password = uuid.toString()
                .substring(5, (int) ((Math.random() * (36 - PASSWORD_MIN_LENGTH)) + PASSWORD_MIN_LENGTH));
        new_user_password_field.setValue(random_password);
        new_user_password_confirmation_field.setValue(random_password);
    }

    public void setRandomInvalidLengthEqualPasswordAndConfirmation () {
        UUID uuid = UUID.randomUUID();
        String random_password = uuid.toString()
                .substring(0, (int) ((Math.random() * 5)));
        new_user_password_field.setValue(random_password);
        new_user_password_confirmation_field.setValue(random_password);
    }

    public void setRandomValidEmail () {
        UUID uuid = UUID.randomUUID();
        String random_email = uuid.toString().substring(0, 10)
                + "@" + uuid.toString().substring(11, 20) + "."
                + uuid.toString().substring(21, 30);
        new_user_email_field.setValue(random_email);
    }

    public void setRandomEmailWithoutAmpersand () {
        new_user_email_field.setValue(RANDOM_EMAIL_WITHOUT_AMPERSAND);
    }

    public void setRandomEmailWithoutPartBeforeAmpersand () {
        new_user_email_field.setValue(RANDOM_EMAIL_WITHOUT_PART_BEFORE_AMPERSAND);
    }

    public void setRandomEmailWithoutPartAfterAmpersand () {
        new_user_email_field.setValue(RANDOM_EMAIL_WITHOUT_PART_AFTER_AMPERSAND);
    }

    public void setRandomEmailWithDotRightAfterAmpersand () {
        new_user_email_field.setValue(RANDOM_EMAIL_WITH_DOT_RIGHT_AFTER_AMPERSAND);
    }

    public void setExistingEmail () {
        new_user_email_field.setValue(REGISTERED_ADMIN_EMAIL);
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

    public void checkUserCreateEmailBlankError() {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(EMAIL_BLANK_ERROR_CREATE_USER));
    }

    public void checkUserCreatePasswordBlankError() {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(PASSWORD_BLANK_ERROR_CREATE_USER));
    }

    public void checkErrorEmailFieldBorderColor () {
        new_user_email_field.shouldHave(Condition.cssValue("border-color", ERROR_FIELD_BORDER_COLOR));
    }

    public void checkErrorPasswordFieldBorderColor () {
        new_user_password_field.shouldHave(Condition.cssValue("border-color", ERROR_FIELD_BORDER_COLOR));
    }

    public void checkUserCreateEmailExistingError() {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(EMAIL_ALREADY_TAKEN_ERROR));
    }

    public void checkTooltipEmailWithoutAmpersand () {
        new_user_email_field.shouldHave(Condition.attribute("validationMessage",
               String.format(EMAIL_WITHOUT_AMPERSAND_ERROR, RANDOM_EMAIL_WITHOUT_AMPERSAND)));
    }

    public void checkTooltipEmailWithoutPartBeforeAmpersand () {
        new_user_email_field.shouldHave(Condition.attribute("validationMessage",
                String.format(EMAIL_WITHOUT_PART_BEFORE_AMPERSAND_ERROR, RANDOM_EMAIL_WITHOUT_PART_BEFORE_AMPERSAND)));
    }

    public void checkTooltipEmailWithoutPartAfterAmpersand () {
        new_user_email_field.shouldHave(Condition.attribute("validationMessage",
                String.format(EMAIL_WITHOUT_PART_AFTER_AMPERSAND_ERROR, RANDOM_EMAIL_WITHOUT_PART_AFTER_AMPERSAND)));
    }

    public void checkTooltipEmailWithDotRightAfterAmpersand () {
        new_user_email_field.shouldHave(Condition.attribute("validationMessage",
                String.format(EMAIL_DOT_RIGHT_AFTER_AMPERSAND_ERROR,
                        RANDOM_EMAIL_WITH_DOT_RIGHT_AFTER_AMPERSAND.split("@")[1])));
    }
}
