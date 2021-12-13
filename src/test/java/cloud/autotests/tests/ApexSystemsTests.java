package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class ApexSystemsTests extends TestBase {
    @Test
    @Description("Menu has at least one toggler element")
    @DisplayName("Menu has at least one toggler element")
    void menuTogglerElementsTest() {
        step("open https://www.apexsystems.com/", () ->
                open("https://www.apexsystems.com/"));

        step("click 'accept cookies'", () ->
                $("#onetrust-accept-btn-handler").click());


        step("menu elements of class toggler are not null ", () -> {
            $("#block-apex-bootstrap-main-navigation").$$(".toggler").shouldBe(sizeGreaterThan(0));
        });
    }

    @Test
    @Description("\"What We do\" footer contains text")
    @DisplayName("\"What We do\" footer contains text")
    void clickWhatWeDoTest() {
        step("open https://www.apexsystems.com/", () ->
                open("https://www.apexsystems.com/"));

        step("accept cookies", () ->
                $("#onetrust-accept-btn-handler").click());

        step("click \"What We Do\" menu item ", () ->
                $("[href='/what-we-do']").click());

        step("footer contains \"Apex Systems is an equal opportunity employer.\" ", () -> {
            $("#onetrust-consent-sdk").scrollTo();
            $("#block-eeocstatement").shouldHave(matchText("Apex Systems is an equal opportunity employer."));
        });

    }

    @Test
    @Description("Page title should have header text")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://www.apexsystems.com/'", () ->
                open("https://www.apexsystems.com/"));

        step("Page title should have text 'Apex Systems'", () -> {
            String expectedTitle = "Apex Systems";
            String actualTitle = title();
            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Page console log should not have errors")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.apexsystems.com/'", () ->
                open("https://www.apexsystems.com/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";
            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}