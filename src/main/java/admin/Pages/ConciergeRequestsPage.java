package admin.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConciergeRequestsPage extends AllPages {

    public void openConciergeRequestsPage() {
        requests_tab.click();
    }

    public void clickSearchButton() {
        concierge_requests_search_button.click();
    }

    public void clickIdColumn() {
        concierge_requests_id_column_name.click();
    }

    public void clickFullNameColumn() {
        concierge_requests_full_name_column_name.click();
    }

    public void clickEmailColumn() {
        concierge_requests_email_column_name.click();
    }

    public void clickPhoneColumn() {
        concierge_requests_phone_column_name.click();
    }

    public void clickCreatedAtColumn() {
        concierge_requests_created_at_column_name.click();
    }

    public void clickPickUpDatetimeColumn() {
        concierge_requests_pick_up_column_name.click();
    }

    public void clickRequestUserColumn() {
        concierge_requests_request_user_column_name.click();
    }

    public void choosePendingStatusOption() {
        concierge_requests_pending_status_option.click();
    }

    public void chooseInProgressStatusOption() {
        concierge_requests_in_progress_status_option.click();
    }

    public void chooseCompletedStatusOption() {
        concierge_requests_completed_status_option.click();
    }

    public void chooseCanceledStatusOption() {
        concierge_requests_canceled_status_option.click();
    }

    public void checkConciergeRequestsPageIsOpened() {
        page_title.shouldHave(Condition.attribute("text", CONCIERGE_REQUESTS_PAGE_TITLE));
    }

    public void checkRequestsTabIsNotVisible() {
        requests_tab.shouldNotBe(Condition.visible);
    }

    public void checkConciergeRequestsStatusInList(String status) {
        for (com.codeborne.selenide.SelenideElement selenideElement : concierge_requests_info_lines) {
            selenideElement.find(By.xpath("td[7]")).shouldHave(Condition.exactText(status));
        }
    }

    public void checkPendingStatusConciergeRequestsOnlyInList() {
        checkConciergeRequestsStatusInList(STATUS_DROPDOWN_FIRST_OPTION_CR);
    }

    public void checkInProgressStatusConciergeRequestsOnlyInList() {
        checkConciergeRequestsStatusInList(STATUS_DROPDOWN_SECOND_OPTION_CR);
    }

    public void checkCompletedStatusConciergeRequestsOnlyInList() {
        checkConciergeRequestsStatusInList(STATUS_DROPDOWN_THIRD_OPTION_CR);
    }

    public void checkCanceledStatusConciergeRequestsOnlyInList() {
        checkConciergeRequestsStatusInList(STATUS_DROPDOWN_FOURTH_OPTION_CR);
    }

    public void checkConciergeRequestsCreatedAtFromDate() {
        for (com.codeborne.selenide.SelenideElement selenideElement : concierge_requests_info_lines) {
            if (selenideElement.find(By.xpath("td[8]")).getText().equals(TODAY_DATE)) {
                selenideElement.find(By.xpath("td[8]")).shouldBe(Condition.exactText(TODAY_DATE));
            } else {
                selenideElement.find(By.xpath("td[8]")).shouldBe(Condition.exactText(YESTERDAY_DATE));
            }
        }
    }

    public void checkConciergeRequestsCreatedAtToDate() {
        for (com.codeborne.selenide.SelenideElement selenideElement : concierge_requests_info_lines) {
            selenideElement.find(By.xpath("td[8]")).shouldNotHave(Condition.exactText(TOMORROW_DATE));
        }
    }

    public void checkConciergeRequestsDescSortingByIdColumn() {
        checkAscSortingByIdColumn(concierge_requests_info_lines, "td[1]", "DESC");
    }

    public void checkConciergeRequestsAscSortingByIdColumn() {
        checkAscSortingByIdColumn(concierge_requests_info_lines, "td[1]", "ASC");
    }

    public void checkConciergeRequestsDescSortingByFullNameColumn() {
        checkSortingByColumn(concierge_requests_info_lines, "td[3]", "DESC");
    }

    public void checkConciergeRequestsAscSortingByFullNameColumn() {
        checkSortingByColumn(concierge_requests_info_lines, "td[3]", "ASC");
    }

    public void checkConciergeRequestsDescSortingByEmailColumn() {
        checkSortingByColumn(concierge_requests_info_lines, "td[5]", "DESC");
    }

    public void checkConciergeRequestsAscSortingByEmailColumn() {
        checkSortingByColumn(concierge_requests_info_lines, "td[5]", "ASC");
    }

    public void checkConciergeRequestsDescSortingByPhoneColumn() {
        checkSortingByColumn(concierge_requests_info_lines, "td[4]", "DESC");
    }

    public void checkConciergeRequestsAscSortingByPhoneColumn() {
        checkSortingByColumn(concierge_requests_info_lines, "td[4]", "ASC");
    }

    public void checkConciergeRequestsDescSortingByCreatedAtColumn() {
        checkSortingByColumn(concierge_requests_info_lines, "td[8]", "DESC");
    }

    public void checkConciergeRequestsAscSortingByCreatedAtColumn() {
        checkSortingByColumn(concierge_requests_info_lines, "td[8]", "ASC");
    }

    public void checkConciergeRequestsDescSortingByPickUpDatetimeColumn(String sort_type) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yy: hh:mm");
        for (int i = 1; i < concierge_requests_info_lines.size(); i++) {
            Date date1 = sdf.parse(concierge_requests_info_lines.get(i - 1).find(By.xpath("td[6]")).getText());
            Date date2 = sdf.parse(concierge_requests_info_lines.get(i).find(By.xpath("td[6]")).getText());
            System.out.println(date1.toString());
            int compare = date1.compareTo(date2);
            if (sort_type.equals("DESC")) {
                Assert.isTrue(compare >= 0, "Incorrect DESC sorting");
            } else if (sort_type.equals("ASC")) {
                Assert.isTrue(compare <= 0, "Incorrect ASC sorting");
            } else {
                throw new java.lang.Error("Incorrect sort type used in the method");
            }
        }
    }

    public void checkConciergeRequestsDescSortingByPickUpDatetimeColumn() throws ParseException {
        checkConciergeRequestsDescSortingByPickUpDatetimeColumn("DESC");
    }

    public void checkConciergeRequestsAscSortingByPickUpDatetimeColumn() throws ParseException {
        checkConciergeRequestsDescSortingByPickUpDatetimeColumn("ASC");
    }
}
