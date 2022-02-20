package admin;

import com.codeborne.selenide.*;

import javax.management.Attribute;

import java.util.Objects;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DryCleanerPage extends AllPages {
    public SelenideElement dry_cleaner_tab = $(".fa.fa-hand-paper-o.icon_link.with-tip");
    public SelenideElement add_dry_cleaner_button = $(".btn.btn-primary");
    public SelenideElement status_dropdown_create = $$("#dry_cleaner_status").get(0);
    public SelenideElement status_dropdown_edit = $$("#dry_cleaner_status").get(1);
    public SelenideElement name_field_create = $$("#dry_cleaner_name").get(0);
    public SelenideElement address_field_create = $$("#dry_cleaner_address").get(0);
    public SelenideElement name_field_edit = $$("#dry_cleaner_name").get(1);
    public SelenideElement address_field_edit = $$("#dry_cleaner_address").get(1);
    public SelenideElement create_button = $("#submitDryCleaner");
    public SelenideElement update_button = $("#submitEditDryCleaner");

    public void openDryCleanerPage() {
        dry_cleaner_tab.click();
    }

    public void openAddDryCleanerModal() {
        add_dry_cleaner_button.click();
    }

    public void checkAddDryCleanerModalOpened() {
        status_dropdown_create.shouldBe(Condition.visible);
    }

    public void checkStatusDropDownOptions(String modalType) {
        if (modalType.equals("Create modal")) {
            status_dropdown_create.getSelectedOption().shouldBe(Condition.exactText("Active"));
            status_dropdown_create.selectOption(1);
            status_dropdown_create.getSelectedOption().shouldBe(Condition.exactText("Non active"));
        } else if (modalType.equals("Edit modal")) {
            status_dropdown_edit.getSelectedOption().shouldBe(Condition.exactText("Active"));
            status_dropdown_edit.selectOption(1);
            status_dropdown_edit.getSelectedOption().shouldBe(Condition.exactText("Non active"));
        }
    }

    public void createDryCleaner(String name, String address) {
        add_dry_cleaner_button.click();
        name_field_create.setValue(name);
        address_field_create.setValue(address);
        create_button.click();
    }

    public void checkDryCleanerExist(String newName, String newAddress) {
        $(byText(newName)).shouldBe(Condition.visible);
        $(byText(newAddress)).shouldBe(Condition.visible);
    }

    public void openEditDryCleanerModal(String dryCleanerName, String openButtonType) {
        if (openButtonType.equals("Edit button")) {
            $$(byAttribute("href", Objects.requireNonNull($(byText(dryCleanerName))
                    .getAttribute("href")))).get(1).click();
        } else if (openButtonType.equals("Dry Cleaner name")) {
            $$(byAttribute("href", Objects.requireNonNull($(byText(dryCleanerName))
                    .getAttribute("href")))).get(0).click();
        }
    }

    public void checkEditDryCleanerModalOpened() {
        update_button.shouldBe(Condition.visible);
    }

    public void editDryCleaner(String dryCleanerName, String name, String address) {
        openEditDryCleanerModal(dryCleanerName, "Edit button");
        name_field_edit.setValue(name);
        address_field_edit.setValue(address);
        update_button.click();
    }
}
