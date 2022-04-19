package qa.guru.allure;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу github")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".jump-to-field").click();
        $(".jump-to-field").sendKeys(repo);
        $(".jump-to-field").pressEnter();
    }

    @Step("Переходим по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("Переходим на таб Issues")
    public void openIssuesTab() {
        $(By.partialLinkText("Issues")).click();
    }

    @Step("Проверяем что существует Issues с номером {number}")
    public void shouldSeeIssueWithNumber(int number){
        $(withText("#" + number)).shouldBe(Condition.visible);
    }
}
