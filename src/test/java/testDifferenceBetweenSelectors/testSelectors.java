package testDifferenceBetweenSelectors;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class testSelectors {

    @Test
    public void test1(){
        open("http://localhost:63342/GitHubTests/GitHubTests.test/html/index.html?_ijt=hinun3gbjnkvf0tbt9ipeqo65q");
        System.out.println($("h1 div").getText());
    }

    @Test
    public void test2(){
        open("http://localhost:63342/GitHubTests/GitHubTests.test/html/index.html?_ijt=hinun3gbjnkvf0tbt9ipeqo65q");
        System.out.println($("h1").$("div").getText());
    }
}
