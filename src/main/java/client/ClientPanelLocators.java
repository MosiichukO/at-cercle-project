package client;

import com.codeborne.selenide.SelenideElement;
import core.TestData;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ClientPanelLocators extends TestData {

    // Header locators
    public SelenideElement sign_up_button = $("[data-testid=\"sign-up-button\"]");
    public SelenideElement user_avatar_button = $("[data-testid=\"user-avatar-button\"]");

    // Sign Up & Sign In modals locators
    public SelenideElement log_in_button_sign_up_modal = $("body > div:nth-child(12) > div > div > div:nth-child(2) > div > div.css-ebb5ev.ej8l8jj4 > p > button");
    public SelenideElement signup_form = $("[data-testid=\"signup-form\"]");
    public SelenideElement login_form = $("[data-testid=\"login-form\"]");
    public SelenideElement sign_up_button_in_sign_in_modal = $("body > div:nth-child(12) > div > div > div:nth-child(2) > div > div.css-1ulg1vh.elm852s4 > div.css-jioun6.elm852s2 > button");
    public SelenideElement cross_button = $$("[data-testid=\"button-picture\"]").get(0);
    public SelenideElement password_field = $(By.id("password"));
    public SelenideElement confirm_password_field = $(By.id("confirm"));
    public SelenideElement email_field = $(By.id("email"));
    public SelenideElement full_name_field = $(By.id("username"));
    public SelenideElement show_button_password_field = $$("[data-testid=\"button-picture\"]").get(1);
    public SelenideElement show_button_confirm_password_field = $$("[data-testid=\"button-picture\"]").get(2);
    public SelenideElement log_in_button_sign_in_modal = $("[type=\"submit\"]");
    public SelenideElement create_account_button = $$("[data-testid=\"button\"]").get(1);
    public SelenideElement email_field_error = $(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]/form/div/div[1]/p"));
    public SelenideElement password_field_error_sign_in = $( By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]/form/div/div[2]/p"));
    public SelenideElement full_name_field_error = $( By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]/form/div/div[2]/p"));
    public SelenideElement password_field_error_sign_up = $( By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]/form/div/div[3]/p"));
    public SelenideElement confirm_password_field_error_sign_up = $( By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]/form/div/div[4]/p"));
    public SelenideElement confirm_email_page = $("[data-testid=\"congratulations\"]");
    public SelenideElement forgot_password_button = $(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]/div[4]/button"));
    public SelenideElement show_button_tooltip = $("[role=\"tooltip\"]");


    // Forgot password modal locators

    public SelenideElement forgot_password_form = $("[data-testid=\"forgotpassword-page\"]");
    public SelenideElement back_forgot_password_button = $(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]/div[2]/button"));
    public SelenideElement send_reset_link_button = $("[type=\"submit\"]");


    // Temp mail
    public SelenideElement temp_mail_field = $(By.id("pre_button"));
    public SelenideElement first_mail = $("#container-body > div.container-xl.body > div.inbox > div.mail");
    public SelenideElement confirm_my_account_button = $(By.xpath("/html/body/div[8]/div[2]/div[2]/div[1]/div[2]/div[3]/table/tbody/tr/td/center/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[1]/div/a"));



}
