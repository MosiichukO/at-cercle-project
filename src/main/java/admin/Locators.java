package admin;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
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
    public SelenideElement name_field_edit = $(By.name("dry_cleaner[name]"));
    public SelenideElement address_field_edit = $(By.name("dry_cleaner[address]"));
    public SelenideElement create_button = $("#submitDryCleaner");
    public SelenideElement update_button = $("#submitEditDryCleaner");
    public SelenideElement dry_cleaner_orders_tab = $(By.xpath("/html/body/div[1]/div/nav/ul/li[7]/ul/li[2]/a"));
    public SelenideElement dry_cleaners_status_dropdown = $("#q_status_eq");
    public SelenideElement dry_cleaners_active_status_option = $("#q_status_eq > option:nth-child(2)");
    public SelenideElement dry_cleaners_non_active_status_option = $("#q_status_eq > option:nth-child(3)");
    public SelenideElement dry_cleaners_search_button = $("#dry_cleaner_search > div.actions.filter-actions > button");
    public SelenideElement dry_cleaners_table = $("#listing_dry_cleaners > tbody");
    public SelenideElement dry_cleaners_name_search_field = $("#q_name_cont");
    public SelenideElement dry_cleaners_address_search_field = $("#q_address_cont");
    public SelenideElement dry_cleaners_created_at_from_field = $("#q_created_at_gt");
    public SelenideElement dry_cleaners_created_at_to_field = $("#q_created_at_lt");
    public SelenideElement dry_cleaners_id_column_name = $("#listing_dry_cleaners > thead > tr > th:nth-child(1) > a");
    public SelenideElement dry_cleaners_name_column_name = $("#listing_dry_cleaners > thead > tr > th:nth-child(2) > a");
    public SelenideElement dry_cleaners_address_column_name = $("#listing_dry_cleaners > thead > tr > th:nth-child(3) > a");
    public SelenideElement dry_cleaners_contact_details_column_name = $("#listing_dry_cleaners > thead > tr > th:nth-child(4) > a");
    public SelenideElement dry_cleaners_user_column_name = $("#listing_dry_cleaners > thead > tr > th:nth-child(5) > a");




    public SelenideElement getDcEditButton(String dc_name) {
        return $$(byAttribute("href", Objects.requireNonNull($(byText(dc_name))
                .getAttribute("href")).split(".com")[1])).get(1);
    }

    public SelenideElement getDcNameButton(String dc_name) {
        return $$(byAttribute("href", Objects.requireNonNull($(byText(dc_name))
                .getAttribute("href")).split(".com")[1])).get(0);
    }

    public SelenideElement getDcDeleteButton(String dc_name) {
        return $(byAttribute("href", Objects.requireNonNull($(byText(dc_name))
                .getAttribute("href")).split(".com")[1].split("/edit")[0]));
    }

    public ElementsCollection status_dropdown_create = $("#formDryCleaner.new_dry_cleaner").
            $("#dry_cleaner_status").$$(By.tagName("OPTION"));
    public ElementsCollection status_dropdown_edit = $("#formDryCleaner.edit_dry_cleaner")
            .$("#dry_cleaner_status").$$(By.tagName("OPTION"));
    public ElementsCollection dry_cleaners_info_lines = dry_cleaners_table.$$(By.tagName("TR"));

    // Users page locators
    public SelenideElement users_tab = $(".fa.fa-user.icon_link.with-tip");
    public SelenideElement new_user_button = $("#admin_new_user_link");
    public SelenideElement roles_filter = $("#s2id_q_spree_roles_id_in");
    public SelenideElement admin_role_option = $(By.xpath("//div[text()='Admin']"));
    public SelenideElement dry_cleaner_role_option = $(By.xpath("//div[text()='Dry cleaner']"));
    public SelenideElement support_role_option = $(By.xpath("//div[text()='Support']"));
    public SelenideElement charity_filter = $("#q_charity_status_eq");
    public SelenideElement enabled_charity_option = $(By.xpath("//*[@id=\"q_charity_status_eq\"]/option[3]"));
    public SelenideElement disabled_charity_option = $(By.xpath("//*[@id=\"q_charity_status_eq\"]/option[2]"));
    public SelenideElement search_button = $("#spree\\/user_search > div.actions.filter-actions > button");
    public SelenideElement users_table = $("#listing_users > tbody");
    public SelenideElement member_since_start_filter_field = $("#q_created_at_gt");
    public SelenideElement email_filter_filed = $("#q_email_cont");
    public SelenideElement next_button = $(By.linkText("Next ›"));

    public SelenideElement getUserEditButtonFromUsersList(String user_email) {
        return $$(byAttribute("href", Objects.requireNonNull($(byText(user_email))
                .getAttribute("href")))).get(1);
    }

    public SelenideElement getUserEmailButtonFromUsersList(String user_email) {
        return $$(byAttribute("href", Objects.requireNonNull($(byText(user_email))
                .getAttribute("href")))).get(0);
    }

    public ElementsCollection user_info_lines = users_table.$$(By.tagName("TR"));

    // Create User and Edit User pages locators
    public SelenideElement new_user_create_button = $(".btn.btn-primary");
    public SelenideElement user_cancel_button = $(byText("Cancel"));
    public SelenideElement edit_user_update_button = $(byText("Update"));
    public SelenideElement user_email_field = $("#user_email");
    public SelenideElement email_field_error_form = $("#user_email_field").$(By.className("formError"));
    public SelenideElement user_password_field = $("#user_password");
    public SelenideElement user_password_confirmation_field = $("#user_password_confirmation");
    public SelenideElement user_password_field_error_form = $("#user_password_field").$(By.className("formError"));
    public SelenideElement user_password_confirmation_error_form = $$("#user_password_field").get(1).$(By.className("formError"));
    public SelenideElement user_username_field = $("#user_username");
    public SelenideElement user_admin_checkbox = $("#user_spree_role_admin");
    public SelenideElement user_support_checkbox = $("#user_spree_role_support");
    public SelenideElement user_dry_cleaner_checkbox = $("#user_spree_role_dry_cleaner");

    // Specials page locators
    public SelenideElement specials_tab = $("fa.fa-object-group.icon_link.with-tip");
}
