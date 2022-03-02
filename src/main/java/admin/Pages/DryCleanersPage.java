package admin.Pages;

import com.codeborne.selenide.*;

import java.util.Objects;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DryCleanersPage extends AllPages {

    public void openDryCleanerPage() {
        dry_cleaner_tab.click();
    }

    public void clickAddDryCleanerButton () {
        add_dry_cleaner_button.click();
    }

    public void clickEditButton () {
        $$(byAttribute("href", Objects.requireNonNull($(byText(DRY_CLEANER_NAME))
                .getAttribute("href")))).get(1).click();
    }

    public void clickDryCleanerName () {
        $$(byAttribute("href", Objects.requireNonNull($(byText(DRY_CLEANER_NAME))
                .getAttribute("href")))).get(0).click();
    }

    public void clickDeleteButton () {
        $(byAttribute("href", Objects.requireNonNull($(byText(DRY_CLEANER_NAME_UPDATED))
                .getAttribute("href")).split(".com")[1].split("/edit")[0])).click();
    }

    public void clickUpdateButton () {
        update_button.click();
    }

    public void clickCreateButton () {
        create_button.click();
    }

    public void deleteCreatedDryCleaner () {
        openAdminLoginPage();
        authorizationAdmin();
        openDryCleanerPage();
        $(byAttribute("href", Objects.requireNonNull($(byText(DRY_CLEANER_NAME))
                .getAttribute("href")).split(".com")[1].split("/edit")[0])).click();
        Selenide.switchTo().alert().accept();
    }

    public void setNewNameForUpdate () {
        name_field_edit.setValue(DRY_CLEANER_NAME_UPDATED);
    }

    public void setNewAddressForUpdate () {
        address_field_edit.setValue(DRY_CLEANER_ADDRESS_UPDATED);
    }

    public void setNonEmptyNameForCreate () {
        name_field_create.setValue(DRY_CLEANER_NAME);
    }

    public void setNonEmptyAddressForCreate () {
        address_field_create.setValue(DRY_CLEANER_ADDRESS);
    }

    public void clearNameField () {
        name_field_edit.clear();
    }

    public void clearAddressField () {
        address_field_edit.clear();
    }

    public void confirmDryCleanerDelete () {
        Selenide.switchTo().alert().accept();
    }

    public void checkDryCleanersPageIsOpened () {add_dry_cleaner_button.shouldBe(Condition.visible);}

    public void checkAddDryCleanerModalOpened() {
        create_button.shouldBe(Condition.visible);
    }

    public void checkStatusDropDownOptionsCreate () {
        status_dropdown_create.shouldHave(size(2));
        status_dropdown_create.shouldHave(exactTexts(STATUS_DROPDOWN_FIRST_OPTION, STATUS_DROPDOWN_SECOND_OPTION));
    }

    public void checkStatusDropDownOptionsEdit () {
        status_dropdown_edit.shouldHave(size(2));
        status_dropdown_edit.shouldHave(exactTexts(STATUS_DROPDOWN_FIRST_OPTION, STATUS_DROPDOWN_SECOND_OPTION));
    }

    public void checkDryCleanerExist() {
        $(byText(DRY_CLEANER_NAME)).shouldBe(Condition.visible);
        $(byText(DRY_CLEANER_ADDRESS)).shouldBe(Condition.visible);
    }

    public void checkDryCleanerUpdated () {
        $(byText(DRY_CLEANER_NAME_UPDATED)).shouldBe(Condition.visible);
        $(byText(DRY_CLEANER_ADDRESS_UPDATED)).shouldBe(Condition.visible);
    }

    public void checkEditDryCleanerModalOpened() {
        update_button.shouldBe(Condition.visible);
    }

    public void checkDryCleanersTabIsNotVisible() {dry_cleaner_tab.shouldNotBe(Condition.visible);}

    public void checkDryCleanerCreationSuccessMessage () {
        success_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(DRY_CLEANER_CREATED_SUCCESS_MESSAGE));
    }

    public void checkDryCleanerUpdateSuccessMessage () {
        success_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(DRY_CLEANER_UPDATE_SUCCESS_MESSAGE));
    }

    public void checkDryCleanerUpdateNameBlankError () {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(NAME_BLANK_ERROR));
    }

    public void checkDryCleanerUpdateAddressBlankError () {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(ADDRESS_BLANK_ERROR));
    }

    public void checkDryCleanerUpdateEmptyInputFieldsError () {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(NAME_ADDRESS_BLANK_ERROR));
    }

    public void checkBlankNameError () {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(NAME_BLANK_ERROR));
    }

    public void checkBlankAddressError () {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(ADDRESS_BLANK_ERROR));
    }

    public void checkBlankNameAddressError () {
        error_message.shouldBe(Condition.visible).shouldHave(Condition.exactText(NAME_ADDRESS_BLANK_ERROR));
    }

    public void checkDryCleanerRemovedFromList () {
        $(byText(DRY_CLEANER_NAME_UPDATED)).shouldNotBe(Condition.visible);
        $(byText(DRY_CLEANER_ADDRESS_UPDATED)).shouldNotBe(Condition.visible);
    }
}
