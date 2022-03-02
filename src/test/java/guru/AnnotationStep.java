package guru;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AnnotationStep {
    private static final String REPOSITORY = "Eisritter/QA-GURU-7";

    @Step("Открыть главную страницу GitHub")
    public void openPage() {
        open("https://github.com");
    }

    @Step("Заполнить поле Поиск данными: " + REPOSITORY)
    public void searchRepository() {
        $(".header-search-input").setValue(REPOSITORY).pressEnter();
    }
    @Step("Открываем репозиторий {REPOSITORY}")
    public void openRepository () {
        $(By.linkText(REPOSITORY)).click();
    }
    @Step("Проверить, что на открывшейся стр. есть кнопка 'Issues' ")
    public void findIssue() {
        $(By.partialLinkText("Issues")).should(Condition.visible);
    }

    @Step("Делаем скриншот")
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
