package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class dragAndDropTests {

    @Test
    public void moveBtoAViaAction(){
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //TODO: не работает
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    public void moveAtoABiaDragAndDrop(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-b").dragAndDropTo("#column-a");

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
