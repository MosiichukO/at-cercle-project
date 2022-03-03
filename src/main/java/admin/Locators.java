package admin;

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
    public SelenideElement page_title = $("title");

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

    // Users page locators
    public SelenideElement users_tab = $(".fa.fa-user.icon_link.with-tip");
    public SelenideElement new_user_button = $("#admin_new_user_link");
    public SelenideElement roles_filter = $("#s2id_q_spree_roles_id_in");
    public SelenideElement admin_role_option = $(By.xpath("//div[text()='Admin']"));
    public SelenideElement dry_cleaner_role_option = $(By.xpath("//div[text()='Dry cleaner']"));
    public SelenideElement support_role_option = $(By.xpath("//div[text()='Support']"));
    public SelenideElement search_button = $("#spree\\/user_search > div.actions.filter-actions > button");
    public SelenideElement users_table = $("#listing_users > tbody");
    public SelenideElement member_since_start_filter_field = $("#q_created_at_gt");
    public SelenideElement email_filter_filed = $("#q_email_cont");
}
