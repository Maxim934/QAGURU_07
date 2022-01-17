package maxim.kim;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepLambda {

    private static final String NUMBER = "68";
    private static String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    public void testGithub() {
//        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть страницу", () -> {
            open("https://github.com");
        });
        step("Поиск репозитория" + REPOSITORY, () -> {

            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переход в репозиторий" + REPOSITORY, () -> {
            $(linkText("eroshenkoam/allure-example")).click();
        });
        step("TAB Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Issues с номером" + NUMBER, () -> {
            $(withText("#" + NUMBER)).should(Condition.visible);
        });
    }

}