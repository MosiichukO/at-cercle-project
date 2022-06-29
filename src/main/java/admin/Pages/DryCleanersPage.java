package admin.Pages;

import com.codeborne.selenide.*;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class DryCleanersPage extends AllPages {

    public void openDryCleanerPage() {
        dry_cleaner_tab.click();
    }

    public void clickAddDryCleanerButton() {
        add_dry_cleaner_button.click();
    }

    public void clickEditButton() {
        getDcEditButton(DRY_CLEANER_NAME).click();
    }

    public void clickDryCleanerName() {
        getDcNameButton(DRY_CLEANER_NAME).click();
    }

    public void clickDeleteButtonForUpdatedDc() {
        getDcDeleteButton(DRY_CLEANER_NAME_UPDATED).click();
    }

    public void clickDeleteButtonForNotUpdatedDc() {
        getDcDeleteButton(DRY_CLEANER_NAME).click();
    }

    public void clickUpdateButton() {
        update_button.click();
    }

    public void clickCreateButton() {
        create_button.click();
    }

    public void clickIdColumn() {
        dry_cleaners_id_column_name.click();
    }

    public void clickNameColumn() {
        dry_cleaners_name_column_name.click();
    }

    public void clickAddressColumn() {
        dry_cleaners_address_column_name.click();
    }

    public void clickContactDetailsColumn() {
        dry_cleaners_contact_details_column_name.click();
    }

    public void clickUserColumn() {
        dry_cleaners_user_column_name.click();
    }

    public void clickStatusColumn() {
        dry_cleaners_status_column_name.click();
    }

    public void clickCreatedAtColumn() {
        dry_cleaners_created_at_column_name.click();
    }

    public void clickSearchButton() {
        dry_cleaners_search_button.click();
    }

    public void deleteCreatedDryCleaner() {
        openAdminLoginPage();
        authorizationAdmin();
        openDryCleanerPage();
        getDcDeleteButton(DRY_CLEANER_NAME).click();
        Selenide.switchTo().alert().accept();
    }

    public void setNewNameForUpdate() {
        name_field_edit.setValue(DRY_CLEANER_NAME_UPDATED);
    }

    public void setNewAddressForUpdate() {
        address_field_edit.setValue(DRY_CLEANER_ADDRESS_UPDATED);
    }

    public void setNonEmptyNameForCreate() {
        name_field_create.setValue(DRY_CLEANER_NAME);
    }

    public void setNonEmptyAddressForCreate() {
        address_field_create.setValue(DRY_CLEANER_ADDRESS);
    }

    public void setNonEmptyContactDetailsForCreate() {
        contact_details_field_create.setValue(DRY_CLEANER_CONTACT_DETAILS);
    }

    public void setExistingDryCleanerNameToNameField() {
        dry_cleaners_name_search_field.setValue(DRY_CLEANER_NAME_UPDATED);
    }

    public void setExistingDryCleanerAddressToAddressField() {
        dry_cleaners_address_search_field.setValue(DRY_CLEANER_ADDRESS_UPDATED);
    }

    public void clearNameField() {
        name_field_edit.clear();
    }

    public void clearAddressField() {
        address_field_edit.clear();
    }

    public void confirmDryCleanerDelete() {
        Selenide.switchTo().alert().accept();
    }

    public void chooseActiveStatusOption() {
        dry_cleaners_active_status_option.click();
    }

    public void chooseNonActiveStatusOption() {
        dry_cleaners_non_active_status_option.click();
    }

    public void checkDryCleanersPageIsOpened() {
        page_title.shouldHave(Condition.attribute("text", DRY_CLEANERS_PAGE_TITLE));
    }

    public void checkAddDryCleanerModalOpened() {
        create_button.shouldBe(Condition.visible);
    }

    public void checkAddDryCleanerButtonIsNotVisible () {
        create_button.shouldNotBe(Condition.visible);
    }


    public void checkStatusDropDownOptionsCreate() {
        status_dropdown_create.shouldHave(size(2));
        status_dropdown_create.shouldHave(exactTexts(STATUS_DROPDOWN_FIRST_OPTION_DC, STATUS_DROPDOWN_SECOND_OPTION_DC));
    }

    public void checkStatusDropDownOptionsEdit() {
        status_dropdown_edit.shouldHave(size(2));
        status_dropdown_edit.shouldHave(exactTexts(STATUS_DROPDOWN_FIRST_OPTION_DC, STATUS_DROPDOWN_SECOND_OPTION_DC));
    }

    public void checkDryCleanerExist() {
        $(byText(DRY_CLEANER_NAME)).shouldBe(Condition.visible);
        $(byText(DRY_CLEANER_ADDRESS)).shouldBe(Condition.visible);
    }

    public void checkDryCleanerUpdated() {
        $(byText(DRY_CLEANER_NAME_UPDATED)).shouldBe(Condition.visible);
        $(byText(DRY_CLEANER_ADDRESS_UPDATED)).shouldBe(Condition.visible);
    }

    public void checkEditDryCleanerModalOpened() {
        update_button.shouldBe(Condition.visible);
    }

    public void checkDryCleanersTabIsNotVisible() {
        dry_cleaner_tab.shouldNotBe(Condition.visible);
    }

    public void checkDryCleanerCreationSuccessMessage() {
        success_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(DRY_CLEANER_CREATED_SUCCESS_MESSAGE));
    }

    public void checkDryCleanerUpdateSuccessMessage() {
        success_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(DRY_CLEANER_UPDATE_SUCCESS_MESSAGE));
    }

    public void checkDryCleanerDeleteSuccessMessage() {
        success_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(DRY_CLEANER_DELETE_SUCCESS_MESSAGE));
    }

    public void checkDryCleanerUpdateNameBlankError() {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(NAME_BLANK_ERROR_EDIT_DC));
    }

    public void checkDryCleanerUpdateAddressBlankError() {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(ADDRESS_BLANK_ERROR_EDIT_DC));
    }

    public void checkDryCleanerUpdateEmptyInputFieldsError() {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(NAME_ADDRESS_BLANK_ERROR_EDIT_DC));
    }

    public void checkDryCleanerCreateBlankNameError() {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(NAME_BLANK_ERROR_CREATE_DC));
    }

    public void checkDryCleanerCreateBlankAddressError() {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(ADDRESS_BLANK_ERROR_CREATE_DC));
    }

    public void checkDryCleanerCreateBlankNameAddressError() {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(NAME_ADDRESS_BLANK_ERROR_CREATE_DC));
    }

    public void checkUpdatedDryCleanerRemovedFromList() {
        $(byText(DRY_CLEANER_NAME_UPDATED)).shouldNotBe(Condition.visible);
        $(byText(DRY_CLEANER_ADDRESS_UPDATED)).shouldNotBe(Condition.visible);
    }

    public void checkDryCleanerStatusInList(String status) {
        for (com.codeborne.selenide.SelenideElement selenideElement : dry_cleaners_info_lines) {
            selenideElement.find(By.xpath("td[6]")).shouldHave(Condition.exactText(status));
        }
    }

    public void checkActiveStatusDryCleanersOnlyInList() {
        checkDryCleanerStatusInList(STATUS_DROPDOWN_FIRST_OPTION_DC);
    }

    public void checkNonActiveStatusDryCleanersOnlyInList() {
        checkDryCleanerStatusInList(STATUS_DROPDOWN_SECOND_OPTION_DC);
    }

    public void checkDryCleanerNameInList() {
        for (com.codeborne.selenide.SelenideElement selenideElement : dry_cleaners_info_lines) {
            selenideElement.find(By.xpath("td[2]")).shouldHave(Condition.matchText(DRY_CLEANER_NAME_UPDATED));
        }
    }

    public void checkDryCleanerAddressInList() {
        for (com.codeborne.selenide.SelenideElement selenideElement : dry_cleaners_info_lines) {
            selenideElement.find(By.xpath("td[3]")).shouldHave(Condition.matchText(DRY_CLEANER_ADDRESS_UPDATED));
        }
    }

    public void checkDryCleanerCreatedAtFromDate() {
        for (com.codeborne.selenide.SelenideElement selenideElement : dry_cleaners_info_lines) {
            if (selenideElement.find(By.xpath("td[7]")).getText().equals(TODAY_DATE)) {
                selenideElement.find(By.xpath("td[7]")).shouldBe(Condition.exactText(TODAY_DATE));
            } else {
                selenideElement.find(By.xpath("td[7]")).shouldBe(Condition.exactText(YESTERDAY_DATE));
            }
        }
    }

    public void checkDryCleanerCreatedAtToDate() {
        for (com.codeborne.selenide.SelenideElement selenideElement : dry_cleaners_info_lines) {
            selenideElement.find(By.xpath("td[7]")).shouldNotHave(Condition.exactText(TOMORROW_DATE));
        }
    }

    public void checkDryCleanersDescSortingByIdColumn() {
        checkAscSortingByIdColumn(dry_cleaners_info_lines, "td[1]", "DESC");
    }

    public void checkDryCleanersAscSortingByIdColumn() {
        checkAscSortingByIdColumn(dry_cleaners_info_lines, "td[1]", "ASC");
    }

    public void checkDryCleanersDescSortingByNameColumn() {
        checkSortingByColumn(dry_cleaners_info_lines,"td[2]", "DESC");
    }

    public void checkDryCleanersAscSortingByNameColumn() {
        checkSortingByColumn(dry_cleaners_info_lines,"td[2]", "ASC");
    }

    public void checkDryCleanersDescSortingByAddressColumn() {
        checkSortingByColumn(dry_cleaners_info_lines,"td[3]", "DESC");
    }

    public void checkDryCleanersAscSortingByAddressColumn() {
        checkSortingByColumn(dry_cleaners_info_lines,"td[3]", "ASC");
    }

    public void checkDryCleanersDescSortingByContactDetailsColumn() {
        checkSortingByColumn(dry_cleaners_info_lines,"td[4]", "DESC");
    }

    public void checkDryCleanersAscSortingByContactDetailsColumn() {
        checkSortingByColumn(dry_cleaners_info_lines,"td[4]", "ASC");
    }

    public void checkDryCleanersDescSortingByUserColumn() {
        checkSortingByColumn(dry_cleaners_info_lines,"td[5]", "DESC");
    }

    public void checkDryCleanersAscSortingByUserColumn() {
        checkSortingByColumn(dry_cleaners_info_lines,"td[5]", "ASC");
    }

    public void checkDryCleanersDescSortingByStatusColumn() {
        checkSortingByColumn(dry_cleaners_info_lines,"td[6]", "DESC");
    }

    public void checkDryCleanersAscSortingByStatusColumn() {
        checkSortingByColumn(dry_cleaners_info_lines,"td[6]", "ASC");
    }

    public void checkDryCleanersDescSortingByCreatedAtColumn() throws ParseException {
        checkSortingForDates(dry_cleaners_info_lines, "td[7]", "DESC");
    }

    public void checkDryCleanersAscSortingByCreatedAtColumn() throws ParseException {
        checkSortingForDates(dry_cleaners_info_lines, "td[7]", "ASC");
    }

    public void checkFieldNameHasActualName() {
        name_field_edit.shouldHave(Condition.exactValue(DRY_CLEANER_NAME));
    }

    public void checkFieldAddressHasActualAddress() {
        address_field_edit.shouldHave(Condition.exactValue(DRY_CLEANER_ADDRESS));
    }

    public void checkFieldContactDetailsHasActualContactDetails() {
        contact_details_field_edit.shouldHave(Condition.exactValue(DRY_CLEANER_CONTACT_DETAILS));
    }

    public void checkStatusDropdownHasActualStatus () {
        status_dropdown_edit.find(Condition.selected).shouldHave(Condition.exactText(STATUS_DROPDOWN_FIRST_OPTION_DC));
    }

    public void checkUserDropdownHasActualStatus () {
        user_dropdown_edit.find(Condition.selected).shouldHave(Condition.exactText(USER_DROPDOWN_NONE_OPTION_DC));
    }

}
