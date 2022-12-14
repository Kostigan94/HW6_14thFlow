package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    public void testIssueSearch(){
        SelenideLogger.addListener("Allure", new AllureSelenide());
        open("https://github.com");
        $("[placeholder='Search GitHub']").setValue("selenide/selenide").pressEnter();
        $(linkText("selenide/selenide")).click();
        $("#issues-tab").click();
        $(withText("#1915")).should(Condition.exist);
    }
}

