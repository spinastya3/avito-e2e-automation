package pageobjects;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage {

 private final ElementsCollection items = $$("[data-marker='item-photo']");

    public ItemPage chooseItem(int index) {
        items.get(index).scrollTo() .click();
        switchTo().window(1);
        return page(ItemPage.class);
    }
}
