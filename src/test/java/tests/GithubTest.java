package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;

 import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;



public class GithubTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
    }
   @Test
   void checkForJUnitExamples() {
       open("/selenide/selenide");
       $("#wiki-tab").click();
       $("#wiki-pages-filter").click();
       $("#wiki-pages-filter").setValue("SoftAssertions");
       $("#wiki-pages-box").$(byText("SoftAssertions")).click();
       $("#wiki-content").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                @Test
                void test() {
                Configuration.assertionMode = SOFT;
                open("page.html");
                $("#first").should(visible).click();
                $("#second").should(visible).click();
                """));
   }

}
