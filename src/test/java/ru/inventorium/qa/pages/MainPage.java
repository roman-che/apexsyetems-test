package ru.inventorium.qa.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.SelenideElementListIterator;
import ru.inventorium.qa.helpers.DriverUtils;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPage {

    //locators and elements
    private final String
            TITLE_TEXT = "Apex Systems",
            FOOTER_TEXT = "Apex Systems is an equal opportunity employer.",
            CONSOLE_ERROR_TEXT = "SEVERE",
            CONSOLE_WARNING_TEXT = "[WARNING]";

    private SelenideElement
            acceptCookiesButtonLocator = $("#onetrust-accept-btn-handler"),
            mainNavigationLocator = $("#block-apex-bootstrap-main-navigation"),
            whatWeDoMenuItemLocator = $("[href='/what-we-do']"),
            pageFooterLocator = $("#block-eeocstatement");

    //actions
    public void openMainPage() {
        open("https://www.apexsystems.com/");
    }

    public void clickAcceptCookies() {
        acceptCookiesButtonLocator.shouldBe(visible);
        acceptCookiesButtonLocator.click();
    }

    public void togglerMenuElementsArePresent() {
        mainNavigationLocator.shouldBe(visible);
        mainNavigationLocator.$$(".toggler").shouldBe(sizeGreaterThan(0));
    }

    public void clickWhatWeDoMenuItem() {
        whatWeDoMenuItemLocator.shouldBe(visible);
        whatWeDoMenuItemLocator.click();
    }

    public void assertFooterText() {
        pageFooterLocator.scrollTo();
        pageFooterLocator.shouldHave(matchText(FOOTER_TEXT));
    }

    public void assertTitleText(String titleValue) {
        mainNavigationLocator.shouldBe(visible);
        assertThat(TITLE_TEXT).isEqualTo(titleValue);
    }

    public void assertConsoleHaveNoErrors() {
        mainNavigationLocator.shouldBe(visible);
        String consoleLogs = DriverUtils.getConsoleLogs();
        assertThat(consoleLogs).doesNotContain(CONSOLE_ERROR_TEXT);
    }

    public void assertConsoleHaveNoWarnings() {
        mainNavigationLocator.shouldBe(visible);
        String consoleLogs = DriverUtils.getConsoleLogs();
        assertThat(consoleLogs).doesNotContain(CONSOLE_WARNING_TEXT);
    }
}
