package maxim.kim.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открыть страницу")
    public void openPage() {
        open("https://github.com");

    }

    @Step("Поиск репозитория {repository}")
    public void findRep(String repository) {

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();

    }

    @Step("Открывем репозиторий {repository}")
    public void goToRep(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Открываем таб Issues")
    public void openTabIssue() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверяем репозиторий номер {number}")
    public void checkIssueTab(int number) {
        $(withText("#" + number)).should(Condition.visible);
    }

}
