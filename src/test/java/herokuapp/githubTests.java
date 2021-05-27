package herokuapp;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class githubTests {
    @Test
    public void checkSoftAssertionsIsPresentInPagesViaSearch(){
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
