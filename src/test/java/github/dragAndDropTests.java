package github;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class dragAndDropTests {

    @Test
    public void moveBtoAViaAction() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //TODO: не работает
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    public void moveAtoABiaDragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-b").dragAndDropTo("#column-a");

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void dragAndDropWebElementsBuilderTest() {
        open("http://www.pbclibrary.org/mousing/click4.htm");

        WebDriver driver = WebDriverRunner.driver().getWebDriver();
        WebElement squareA = driver.findElement(By.cssSelector("div img"));
        int xCoordinateBeforeMoving = squareA.getLocation().getX();
        WebElement squareB = driver.findElement(By.cssSelector("div a"));

        // drag and drop
        Actions builder = new Actions(driver);
        builder.dragAndDrop(squareA, squareB).perform();//works

        // check result
        int xCoordinateAfterMoving = squareA.getLocation().getX();
        assertThat(xCoordinateAfterMoving).isNotEqualTo(xCoordinateBeforeMoving);
    }
}
