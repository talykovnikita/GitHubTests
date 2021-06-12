package herokuapp;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class githubTests {
    @Test
    public void checkSoftAssertionsIsPresentInPagesViaSearch(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        open("https://github.com/selenide/selenide");
        $(withText("Wiki")).click();
        $("#wiki-pages-filter").setValue("Soft");
        $(withText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }

    @Test
    public void checkSoftAssertionsIsPresentInPagesViaExpandList(){
        open("https://github.com/selenide/selenide");
        $(withText("Wiki")).click();
        $(withText("more pages")).click();
        $(withText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
