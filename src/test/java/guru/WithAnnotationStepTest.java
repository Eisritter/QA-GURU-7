package guru;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Configuration.browserSize;

public class WithAnnotationStepTest {
    @BeforeEach
    void preconditionBrowser() {
        browserSize = "1920x1060";
    }
    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }
    @Test
    public void issueSearchWithAnnotationSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        AnnotationStep steps = new AnnotationStep();

        steps.openPage();
        steps.searchRepository();
        steps.openRepository();
        steps.findIssue();
        steps.takeScreenshot();
    }
}
