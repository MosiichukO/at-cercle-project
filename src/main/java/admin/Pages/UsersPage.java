package admin.Pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.util.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


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

    public void clickDryCleanerCheckbox () {
        new_user_dry_cleaner_checkbox.click();
    }

    public void clickSupportCheckbox () {
        new_user_support_checkbox.click();
    }

    public void clickAdminCheckbox () {
        new_user_admin_checkbox.click();
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
        new_user_password_field.setValue(RANDOM_PASSWORD_VALID_LENGTH);
        new_user_password_confirmation_field.setValue(RANDOM_PASSWORD_VALID_LENGTH);
    }

    public void setRandomInvalidLengthEqualPasswordAndConfirmation () {
        new_user_password_field.setValue(RANDOM_PASSWORD_INVALID_LENGTH);
        new_user_password_confirmation_field.setValue(RANDOM_PASSWORD_INVALID_LENGTH);
    }

    public void setRandomValidDifferentPasswordAndConfirmation () {
        new_user_password_field.setValue(RANDOM_PASSWORD_VALID_LENGTH);
        new_user_password_confirmation_field.setValue(RANDOM_PASSWORD_VALID_LENGTH + RANDOM_PASSWORD_VALID_LENGTH);
    }

    public void setTestPasswordAndConfirmation () {
        new_user_password_field.setValue(TEST_VALID_PASSWORD);
        new_user_password_confirmation_field.setValue(TEST_VALID_PASSWORD);
    }

    public void setRandomValidEmail () {
        new_user_email_field.setValue(RANDOM_VALID_EMAIL);
    }

    public void setTestValidEmailDryCleaner () {
        new_user_email_field.setValue(TEST_VALID_EMAIL_DC);
    }

    public void setTestValidEmailSupport () {
        new_user_email_field.setValue(TEST_VALID_EMAIL_SUPPORT);
    }

    public void setTestValidEmailAdmin () {
        new_user_email_field.setValue(TEST_VALID_EMAIL_ADMIN);
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

    public void setRandomEmailWithSpecSymbolExceptDotAfterAmpersand () {
        new_user_email_field.setValue(RANDOM_EMAIL_WITH_SPEC_SYMBOL_AFTER_AMPERSAND);
    }

    public void setExistingEmail () {
        new_user_email_field.setValue(REGISTERED_ADMIN_EMAIL);
    }

    public void checkUsersPageIsOpened() {
        page_title.shouldHave(Condition.attribute("text", USERS_PAGE_TITLE));
    }

    public void checkUsersRoleInList(String role) {
        for (com.codeborne.selenide.SelenideElement selenideElement : user_info_lines) {
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
        for (com.codeborne.selenide.SelenideElement selenideElement : user_info_lines) {
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
        for (com.codeborne.selenide.SelenideElement selenideElement : user_info_lines) {
            selenideElement.find(By.xpath("td[1]")).shouldHave(Condition.exactText(REGISTERED_SUPPORT_EMAIL));
        }
    }

    public void checkFilterResultsByPartOfEmail () {
        for (com.codeborne.selenide.SelenideElement selenideElement : user_info_lines) {
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

    public void checkTooltipEmailWithSpecSymbolAfterAmpersand () {
        new_user_email_field.shouldHave(Condition.attribute("validationMessage",
                String.format(EMAIL_SPEC_SYMBOL_AFTER_AMPERSAND_ERROR, random_spec_symbol)));
    }

    public void checkEmailFormErrorCanNotBeBlank () {
        new_user_email_field_error_form.shouldHave(Condition.exactText(BLANK_FORM_ERROR));
    }

    public void checkPasswordFormErrorCanNotBeBlank () {
        new_user_password_field_error_form.shouldHave(Condition.exactText(BLANK_FORM_ERROR));
    }

    public void checkInvalidPasswordLengthErrorMessage () {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(PASSWORD_INVALID_LENGTH_ERROR_CREATE_USER));
    }

    public void checkPasswordFormErrorInvalidLength () {
        new_user_password_field_error_form.shouldHave(Condition.exactText(TOO_SHORT_FORM_6_SYMBOLS_ERROR));
    }

    public void checkEmailFormErrorAlreadyTaken () {
        new_user_email_field_error_form.shouldHave(Condition.exactText(ALREADY_TAKEN_FORM_ERROR));
    }

    public void checkDifferentPasswordAndConfirmationErrorMessage () {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(DIFFERENT_PASSWORD_AND_CONFIRMATION_ERROR));
    }

    public void checkConfirmationPasswordFormErrorDoesNotMatchPassword () {
        new_user_password_confirmation_error_form.shouldHave(Condition.exactText(PASSWORD_DO_NOT_MATCH_CONFIRMATION_FORM_ERROR));
    }

    public void checkEditNewDcUserPageIsOpened () {
        page_title.shouldHave(Condition.attribute("text", String.format(EDIT_USER_PAGE_TITLE, TEST_VALID_EMAIL_DC)));
    }

    public void checkEditNewSupportUserPageIsOpened () {
        page_title.shouldHave(Condition.attribute("text", String.format(EDIT_USER_PAGE_TITLE, TEST_VALID_EMAIL_SUPPORT)));
    }

    public void checkEditNewAdminPageIsOpened () {
        page_title.shouldHave(Condition.attribute("text", String.format(EDIT_USER_PAGE_TITLE, TEST_VALID_EMAIL_ADMIN)));
    }

    public void checkEditButtonIsPresentForTestUser () {
        while (true) {
            if (next_button.isDisplayed()) {
                if ($(byText(TEST_VALID_EMAIL_ADMIN)).isDisplayed()) {
                    getUserEditButtonFromUsersList(TEST_VALID_EMAIL_ADMIN).shouldBe(Condition.visible);
                    break;
                } else {
                    next_button.click();
                }
            } else {
                getUserEditButtonFromUsersList(TEST_VALID_EMAIL_ADMIN).shouldBe(Condition.visible);
                break;
            }
        }
    }


}
