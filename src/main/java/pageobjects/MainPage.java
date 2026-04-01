package pageobjects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

public class MainPage {

    private final SelenideElement enter = $(byText("Вход и регистрация"));
    private final SelenideElement userNameButton = $("[data-marker='header/username-button']");
    private final SelenideElement searchInput = $("[data-marker='search-form/suggest/input']");

    public LoginModal logIn() {
        enter.click();
        return page(LoginModal.class);
    }

    public MainPage  userNameButtonDisplayed(){
        userNameButton.shouldBe(visible, Duration.ofSeconds(30)); // время для ввода смс
        return this;
    }

    public SearchResultPage searchForItem() {
        searchInput.val("Кроссовки Сочи").pressEnter();
        return page(SearchResultPage.class);
    }
}
