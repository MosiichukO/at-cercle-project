package admin;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Locators extends TestData {

    // All pages locators
    public SelenideElement error_message = $(".flash.error");
    public SelenideElement success_message = $(".flash.success");
    public SelenideElement logout_button = $(".fa.fa-sign-out");

    //Authorization page locators
    public SelenideElement email_field = $("#spree_user_email");
    public SelenideElement password_field = $("#spree_user_password");
    public SelenideElement login_button = $(".btn.btn-primary");
    public SelenideElement success_logout_message = $(".flash.notice");

    // Dry Cleaners page locators
    public SelenideElement dry_cleaner_tab = $(".fa.fa-hand-paper-o.icon_link.with-tip");
    public SelenideElement add_dry_cleaner_button = $(".btn.btn-primary");
    public SelenideElement name_field_create = $$("#dry_cleaner_name").get(0);
    public SelenideElement address_field_create = $$("#dry_cleaner_address").get(0);
    public SelenideElement name_field_edit = $$("#dry_cleaner_name").get(1);
    public SelenideElement address_field_edit = $$("#dry_cleaner_address").get(1);
    public SelenideElement create_button = $("#submitDryCleaner");
    public SelenideElement update_button = $("#submitEditDryCleaner");
    public ElementsCollection status_dropdown_create = $("#formDryCleaner.new_dry_cleaner").
            $("#dry_cleaner_status").$$(By.tagName("OPTION"));
    public ElementsCollection status_dropdown_edit = $("#formDryCleaner.edit_dry_cleaner")
            .$("#dry_cleaner_status").$$(By.tagName("OPTION"));

}
