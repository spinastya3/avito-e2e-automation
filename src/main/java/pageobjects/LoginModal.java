package pageobjects;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginModal {

    private final SelenideElement phoneField = $("[data-marker='login-form/login/input']");
    private final SelenideElement passField = $("[data-marker='login-form/password/input']");
    private final SelenideElement enterButton = $(byText("Войти"));

    public MainPage authorisation() {
        phoneField.shouldBe(visible, Duration.ofSeconds(15)).val(""); // сюда ввести телефон для авторизации
        passField.shouldBe(visible, Duration.ofSeconds(15)).val(""); // сюда ввести пароль для авторизации
        enterButton.click();
        return page(MainPage.class);
    }
}
