package client.Pages;

import client.ClientPanelLocators;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import java.time.Duration;
import static com.codeborne.selenide.Selenide.open;


public class AllPages extends ClientPanelLocators {

    public void openHomePage() {
        open(HOME_PAGE);
    }

    public void openTempMailService () {
        open(TEMP_MAIL);
        temp_mail_field.should(Condition.appear, Duration.ofSeconds(30));
    }

    public void maximizeWindow () {
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
    }
}
