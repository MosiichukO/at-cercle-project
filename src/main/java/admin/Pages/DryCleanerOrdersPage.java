package admin.Pages;

import com.codeborne.selenide.Condition;

public class DryCleanerOrdersPage extends AllPages {

    public void openDryCleanerOrdersPage() {
        dry_cleaner_tab.click();
        dry_cleaner_orders_tab.click();
    }

    public void checkDryCleanerOrdersPageIsOpened() {
        page_title.shouldHave(Condition.attribute("text", DRY_CLEANER_ORDERS_PAGE_TITLE));
    }
}
