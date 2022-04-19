package qa.guru.allure;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SeleniumTest {

    @Test
    void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");

        $(".jump-to-field").click();
        $(".jump-to-field").sendKeys("microsoft/WSL");
        $(".jump-to-field").pressEnter();

        $(By.linkText("microsoft/WSL")).click();
        $(By.partialLinkText("Issues")).click();
        $(withText("#8306")).shouldBe(Condition.visible);
    }
}
