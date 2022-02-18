package admin;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DryCleanerPage extends AllPages {
    public SelenideElement dry_cleaner_tab = $(".fa.fa-hand-paper-o.icon_link.with-tip");
    public SelenideElement add_dry_cleaner_button = $(".btn.btn-primary");
    public SelenideElement status_dropdown = $("#dry_cleaner_status");
    public SelenideElement name_field = $("#dry_cleaner_name");
    public SelenideElement address_field = $("#dry_cleaner_address");
    public SelenideElement create_button = $("#submitDryCleaner");

    public void openDryCleanerPage() {
        dry_cleaner_tab.click();
    }

    public void openAddDryCleanerModal() {
        add_dry_cleaner_button.click();
    }

    public void checkAddDryCleanerModalOpened() {
        status_dropdown.shouldBe(Condition.visible);
    }

    public void checkStatusDropDownOptions() {
        status_dropdown.getSelectedOption().shouldBe(Condition.exactText("Active"));
        status_dropdown.selectOption(1);
        status_dropdown.getSelectedOption().shouldBe(Condition.exactText("Non active"));
    }

    public void createDryCleaner(String name, String address) {
        add_dry_cleaner_button.click();
        name_field.setValue(name);
        address_field.setValue(address);
        create_button.click();
    }

    public void checkDryCleanerCreated(String name, String address) {
        $(byText(name)).shouldBe(Condition.visible);
        $(byText(address)).shouldBe(Condition.visible);
    }
}
