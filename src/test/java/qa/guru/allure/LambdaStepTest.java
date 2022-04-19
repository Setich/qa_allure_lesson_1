package qa.guru.allure;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepTest {

    private static final String REPOSITORY = "microsoft/WSL";
    private static final int ISSUE_NUMBER = 8306;

    @Test
    void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу github", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".jump-to-field").click();
            $(".jump-to-field").setValue(REPOSITORY);
            $(".jump-to-field").pressEnter();
        });
        step("Переходим по ссылке репозитория " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Переходим на таб Issues", () -> {
            $(By.partialLinkText("Issues")).click();
        });
        step("Проверяем что существует Issues с номером " + ISSUE_NUMBER, () ->{
            $(withText("#8306")).shouldBe(Condition.visible);
        });
    }
}
