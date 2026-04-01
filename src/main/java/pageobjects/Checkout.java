package pageobjects;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

public class Checkout {

    private final SelenideElement phoneField = $("[data-marker='form/phone/input']");

    public void checkPhoneFieldIsEmpty() {
        phoneField.scrollTo().shouldHave(value(""));
    }
}
