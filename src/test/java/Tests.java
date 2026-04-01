import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.ItemPage;
import pageobjects.MainPage;
import pageobjects.SearchResultPage;

import static com.codeborne.selenide.Selenide.*;

public class Tests {

    @BeforeEach
    void setUp() {

        ChromeOptions options = new ChromeOptions();
        // Отключаем уведомление "Браузером управляет автоматизированное ПО"
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--disable-blink-features=AutomationControlled");
        Configuration.browserCapabilities = options;

        Configuration.pageLoadStrategy = "eager";
        open("https://www.avito.ru");
    }


    @Test
    public void checkPhoneFieldIsEmptyInDeliveryOrder() {

        MainPage mainPage = new MainPage();
        SearchResultPage searchResultPage = mainPage.logIn()
                .authorisation()
                .userNameButtonDisplayed()
                .searchForItem();
        for (int i=0; i<5; i++){
            ItemPage itemPage = searchResultPage.chooseItem(i);
           if (itemPage.checkByAndDeliveryButton()) {
               itemPage.clickByAndDeliveryButton().checkPhoneFieldIsEmpty();
               break;
           } else {
               closeWindow();
               switchTo().window(0);
           }
        }
    }

    @AfterEach
    public void tearDown() {
       clearBrowserCookies();
       clearBrowserLocalStorage();
    }
}