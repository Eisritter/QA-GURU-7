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
import static io.qameta.allure.Allure.step;

public class WithStepTest {
    private static final String REPOSITORY = "Eisritter/QA-GURU-7"; //коммент для 8-го урока

    @BeforeEach
    void preconditionBrowser() { // еще один коммент для 8-го урока
        browserSize = "1920x1080";
    }

    @Test
    public void issueSearchWithSteps() {
        addListener("allure", new AllureSelenide());

        step("Открыть главную страницу GitHub", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").setValue(REPOSITORY).pressEnter();
        });
        step("Открываем репозиторий", () -> {
            $(By.linkText("Eisritter/QA-GURU-7")).click();
        });
        step("Проверка, что на открытой странице есть кнопка 'Issues'", () -> {
            $(By.partialLinkText("Issues")).should(Condition.visible);
        });
    }
}
