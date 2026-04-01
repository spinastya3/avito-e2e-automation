package pageobjects;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ItemPage {

    private final SelenideElement byAndDeliveryButton = $(byText("Купить с доставкой"));

    public boolean checkByAndDeliveryButton() {
        try {
             byAndDeliveryButton.shouldBe(visible, Duration.ofSeconds(20));
             return true;
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            return false;
        }
    }

    public Checkout clickByAndDeliveryButton() {
        byAndDeliveryButton.shouldBe(visible, Duration.ofSeconds(15)).click();
        return page(Checkout.class);
    }
}
