package guru;

import com.codeborne.selenide.Condition;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;


public class ListenerTest {
        @BeforeEach
        void preconditionBrowser() {
             browserSize = "1920x1080";
        }

        @Test
        public void issueSearch() {
            addListener("allure", new AllureSelenide());

            open("https://github.com");
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("Eisritter/QA-GURU-7");
            $(".header-search-input").submit();
            $(By.linkText("Eisritter/QA-GURU-7")).click();
            $(By.partialLinkText("Issues")).should(Condition.visible);
        }
}
