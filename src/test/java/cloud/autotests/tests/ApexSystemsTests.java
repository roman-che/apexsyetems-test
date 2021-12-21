package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class ApexSystemsTests extends TestBase {

    @Test
    @Tags({@Tag("all_tests"), @Tag("page_tests")})
    @Description("at least one toggler element in menu")
    @DisplayName("Menu has at least one toggler element")
    void menuTogglerElementsTest() {
        step("open https://www.apexsystems.com/", () ->
                open("https://www.apexsystems.com/"));

        step("click 'accept cookies'", () -> {
            $("#onetrust-accept-btn-handler").shouldBe(visible);
            $("#onetrust-accept-btn-handler").click();
        });

        step("menu elements of class toggler are not null ", () -> {
            $("#block-apex-bootstrap-main-navigation").shouldBe(visible);
            $("#block-apex-bootstrap-main-navigation").$$(".toggler").shouldBe(sizeGreaterThan(0));
        });
    }

    @Test
    @Tags({@Tag("all_tests"), @Tag("page_tests")})
    @Description(" text assertion in footer")
    @DisplayName("\"What We do\" footer contains text")
    void clickWhatWeDoTest() {
        step("open https://www.apexsystems.com/", () ->
                open("https://www.apexsystems.com/"));

        step("accept cookies", () -> {
            $("#onetrust-accept-btn-handler").shouldBe(visible);
            $("#onetrust-accept-btn-handler").click();
        });

        step("click \"What We Do\" menu item ", () -> {
            $("[href='/what-we-do']").shouldBe(visible);
            $("[href='/what-we-do']").click();
        });

        step("footer contains \"Apex Systems is an equal opportunity employer.\" ", () -> {
            $("#block-eeocstatement").scrollTo();
            $("#block-eeocstatement").shouldHave(matchText("Apex Systems is an equal opportunity employer."));
        });
    }

    @Test
    @Tags({@Tag("all_tests"), @Tag("page_tests")})
    @Description("title text assertion")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://www.apexsystems.com/'", () ->
                open("https://www.apexsystems.com/"));

        step("Page title should have text 'Apex Systems'", () -> {
            $("#block-apex-bootstrap-main-navigation").shouldBe(visible);
            String expectedTitle = "Apex Systems";
            String actualTitle = title();
            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Tags({@Tag("all_tests"), @Tag("console_tests")})
    @Description("No errors in console log assertion")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.apexsystems.com/'", () ->
                open("https://www.apexsystems.com/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            $("#block-apex-bootstrap-main-navigation").shouldBe(visible);
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";
            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @Tags({@Tag("all_tests"), @Tag("console_tests")})
    @Description("console log has no warnings assertion")
    @DisplayName("Page console log should have no warnings")
    void consoleShouldNotHaveWarnings() {
        step("Open url 'https://www.apexsystems.com/'", () ->
                open("https://www.apexsystems.com/"));

        step("Console logs should not contain text 'WARNING'", () -> {
            $("#block-apex-bootstrap-main-navigation").shouldBe(visible);
            String consoleLogs = DriverUtils.getConsoleLogs();
            String warningText = "[WARNING]";
            assertThat(consoleLogs).doesNotContain(warningText);
        });
    }

    @Test
    @Tags({@Tag("all_tests"), @Tag("page_tests")})
    @Disabled("Test code for further test development")
    @Description("skipped test")
    @DisplayName("skipped test")
    void skippedTest() {
        //add code here
    }
}
