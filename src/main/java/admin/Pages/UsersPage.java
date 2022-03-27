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

    public void clickRolesFilter() {roles_filter.click();}

    public void clickAdminRoleOption() {
        admin_role_option.click();
    }

    public void clickDryCleanerRoleOption() {
        dry_cleaner_role_option.click();
    }

    public void clickSupportRoleOption() {
        support_role_option.click();
    }

    public void clickCharityFilter() {charity_filter.click();}

    public void clickEnabledCharityOption() {enabled_charity_option.click();}

    public void clickDisabledCharityOption() {disabled_charity_option.click();}

    public void clickSearchButton() {
        search_button.click();
    }

    public void clickNewUserButton() {new_user_button.click();}

    public void clickRandomRoleUserCreation () {
        List<String> roles = Arrays.asList("Admin", "Support", "Dry cleaner");
        Random rand = new Random();
        String randomRole = roles.get(rand.nextInt(roles.size()));
        switch (randomRole) {
            case "Admin" -> user_admin_checkbox.click();
            case "Support" -> user_support_checkbox.click();
            case "Dry cleaner" -> user_dry_cleaner_checkbox.click();
        }
    }

    public void clickDryCleanerCheckbox () {
        user_dry_cleaner_checkbox.click();
    }

    public void clickSupportCheckbox () {
        user_support_checkbox.click();
    }

    public void clickAdminCheckbox () {
        user_admin_checkbox.click();
    }

    public void clickCreateButton () {
        new_user_create_button.click();
    }

    public void clickCancelButton () {
        user_cancel_button.click();
    }

    public void clickUpdateButton () {edit_user_update_button.click();}

    public void clickEditButtonForTestUser () {
        while (true) {
            if (next_button.isDisplayed()) {
                if ($(byText(TEST_VALID_EMAIL_ADMIN)).isDisplayed()) {
                    getUserEditButtonFromUsersList(TEST_VALID_EMAIL_ADMIN).click();
                    break;
                } else {
                    next_button.click();
                }
            } else {
                getUserEditButtonFromUsersList(TEST_VALID_EMAIL_ADMIN).click();
                break;
            }
        }
    }

    public void clickEmailOfTestUser () {
        while (true) {
            if (next_button.isDisplayed()) {
                if ($(byText(TEST_VALID_EMAIL_ADMIN)).isDisplayed()) {
                    getUserEmailButtonFromUsersList(TEST_VALID_EMAIL_ADMIN).click();
                    break;
                } else {
                    next_button.click();
                }
            } else {
                getUserEmailButtonFromUsersList(TEST_VALID_EMAIL_ADMIN).click();
                break;
            }
        }
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
        user_password_field.setValue(RANDOM_PASSWORD_VALID_LENGTH);
        user_password_confirmation_field.setValue(RANDOM_PASSWORD_VALID_LENGTH);
    }

    public void setRandomInvalidLengthEqualPasswordAndConfirmation () {
        user_password_field.setValue(RANDOM_PASSWORD_INVALID_LENGTH);
        user_password_confirmation_field.setValue(RANDOM_PASSWORD_INVALID_LENGTH);
    }

    public void setRandomValidDifferentPasswordAndConfirmation () {
        user_password_field.setValue(RANDOM_PASSWORD_VALID_LENGTH);
        user_password_confirmation_field.setValue(RANDOM_PASSWORD_VALID_LENGTH + RANDOM_PASSWORD_VALID_LENGTH);
    }

    public void setTestPasswordAndConfirmation () {
        user_password_field.setValue(TEST_VALID_PASSWORD);
        user_password_confirmation_field.setValue(TEST_VALID_PASSWORD);
    }

    public void setRandomValidEmail () {
        user_email_field.setValue(RANDOM_VALID_EMAIL);
    }

    public void setTestValidEmailDryCleaner () {
        user_email_field.setValue(TEST_VALID_EMAIL_DC);
    }

    public void setTestValidEmailSupport () {
        user_email_field.setValue(TEST_VALID_EMAIL_SUPPORT);
    }

    public void setTestValidEmailAdmin () {
        user_email_field.setValue(TEST_VALID_EMAIL_ADMIN);
    }

    public void setRandomEmailWithoutAmpersand () {
        user_email_field.setValue(RANDOM_EMAIL_WITHOUT_AMPERSAND);
    }

    public void setRandomEmailWithoutPartBeforeAmpersand () {
        user_email_field.setValue(RANDOM_EMAIL_WITHOUT_PART_BEFORE_AMPERSAND);
    }

    public void setRandomEmailWithoutPartAfterAmpersand () {
        user_email_field.setValue(RANDOM_EMAIL_WITHOUT_PART_AFTER_AMPERSAND);
    }

    public void setRandomEmailWithDotRightAfterAmpersand () {
        user_email_field.setValue(RANDOM_EMAIL_WITH_DOT_RIGHT_AFTER_AMPERSAND);
    }

    public void setRandomEmailWithSpecSymbolExceptDotAfterAmpersand () {
        user_email_field.setValue(RANDOM_EMAIL_WITH_SPEC_SYMBOL_AFTER_AMPERSAND);
    }

    public void setExistingEmail () {
        user_email_field.setValue(REGISTERED_ADMIN_EMAIL);
    }

    public void clearEmailField () {user_email_field.clear();}

    public void uncheckAllRolesCheckboxes () {
        if (user_admin_checkbox.isEnabled()) {
            user_admin_checkbox.click();
        } else if (user_dry_cleaner_checkbox.isEnabled()) {
            user_dry_cleaner_checkbox.click();
        } else if (user_support_checkbox.isEnabled()) {
            user_support_checkbox.click();
        }
    }

    public void enableRandomRoleCheckbox () {
        int roleNumber =  1 + (int) (Math.random() * 3);
        switch (roleNumber) {
            case 1 -> user_admin_checkbox.click();
            case 2 -> user_support_checkbox.click();
            case 3 -> user_dry_cleaner_checkbox.click();
        }
    }

    public void checkUsersPageIsOpened() {
        page_title.shouldHave(Condition.attribute("text", USERS_PAGE_TITLE));
    }

    public void checkUsersRoleInList(String role) {
        for (com.codeborne.selenide.SelenideElement selenideElement : user_info_lines) {
            selenideElement.find(By.xpath("td[2]")).shouldHave(Condition.exactText(role));
        }
    }

    public void checkUsersCharityInList(String charity) {
        for (com.codeborne.selenide.SelenideElement selenideElement : user_info_lines) {
            selenideElement.find(By.xpath("td[3]")).shouldHave(Condition.exactText(charity));
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

    public void checkEnabledCharityUsersInList() {
        checkUsersCharityInList("Enabled");
    }

    public void checkDisabledCharityUsersInList() {
        checkUsersCharityInList("Disabled");
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
        user_email_field.shouldHave(Condition.cssValue("border-color", ERROR_FIELD_BORDER_COLOR));
    }

    public void checkErrorPasswordFieldBorderColor () {
        user_password_field.shouldHave(Condition.cssValue("border-color", ERROR_FIELD_BORDER_COLOR));
    }

    public void checkUserCreateEmailExistingError() {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(EMAIL_ALREADY_TAKEN_ERROR));
    }

    public void checkTooltipEmailWithoutAmpersand () {
        user_email_field.shouldHave(Condition.attribute("validationMessage",
               String.format(EMAIL_WITHOUT_AMPERSAND_ERROR, RANDOM_EMAIL_WITHOUT_AMPERSAND)));
    }

    public void checkTooltipEmailWithoutPartBeforeAmpersand () {
        user_email_field.shouldHave(Condition.attribute("validationMessage",
                String.format(EMAIL_WITHOUT_PART_BEFORE_AMPERSAND_ERROR, RANDOM_EMAIL_WITHOUT_PART_BEFORE_AMPERSAND)));
    }

    public void checkTooltipEmailWithoutPartAfterAmpersand () {
        user_email_field.shouldHave(Condition.attribute("validationMessage",
                String.format(EMAIL_WITHOUT_PART_AFTER_AMPERSAND_ERROR, RANDOM_EMAIL_WITHOUT_PART_AFTER_AMPERSAND)));
    }

    public void checkTooltipEmailWithDotRightAfterAmpersand () {
        user_email_field.shouldHave(Condition.attribute("validationMessage",
                String.format(EMAIL_DOT_RIGHT_AFTER_AMPERSAND_ERROR,
                        RANDOM_EMAIL_WITH_DOT_RIGHT_AFTER_AMPERSAND.split("@")[1])));
    }

    public void checkTooltipEmailWithSpecSymbolAfterAmpersand () {
        user_email_field.shouldHave(Condition.attribute("validationMessage",
                String.format(EMAIL_SPEC_SYMBOL_AFTER_AMPERSAND_ERROR, random_spec_symbol)));
    }

    public void checkEmailFormErrorCanNotBeBlank () {
        email_field_error_form.shouldHave(Condition.exactText(BLANK_FORM_ERROR));
    }

    public void checkPasswordFormErrorCanNotBeBlank () {
        user_password_field_error_form.shouldHave(Condition.exactText(BLANK_FORM_ERROR));
    }

    public void checkInvalidPasswordLengthErrorMessage () {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(PASSWORD_INVALID_LENGTH_ERROR_CREATE_USER));
    }

    public void checkPasswordFormErrorInvalidLength () {
        user_password_field_error_form.shouldHave(Condition.exactText(TOO_SHORT_FORM_6_SYMBOLS_ERROR));
    }

    public void checkEmailFormErrorAlreadyTaken () {
        email_field_error_form.shouldHave(Condition.exactText(ALREADY_TAKEN_FORM_ERROR));
    }

    public void checkDifferentPasswordAndConfirmationErrorMessage () {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(DIFFERENT_PASSWORD_AND_CONFIRMATION_ERROR));
    }

    public void checkConfirmationPasswordFormErrorDoesNotMatchPassword () {
        user_password_confirmation_error_form.shouldHave(Condition.exactText(PASSWORD_DO_NOT_MATCH_CONFIRMATION_FORM_ERROR));
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

    public void checkEditUserPageIsOpened () {
        page_title.shouldHave(Condition.attribute("text", String.format(EDIT_USER_PAGE_TITLE, TEST_VALID_EMAIL_ADMIN)));
    }

    public void checkRoleIsNotChosenErrorMessage () {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(ROLE_IS_NOT_CHOSEN_ERROR));
    }

    public void checkSuccessMessageIsVisible () {
        success_message.shouldBe(Condition.visible);
    }

    public void checkUserUpdatedSuccessMessage() {
        success_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(USER_UPDATE_SUCCESS_MESSAGE));

    }
}
