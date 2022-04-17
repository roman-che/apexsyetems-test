package ru.inventorium.qa.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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
    @Step("Open url \"https://www.apexsystems.com/\"")
    public MainPage openMainPage() {
        open("https://www.apexsystems.com/");
        return this;
    }

    @Step("click \"accept cookies\"")
    public void clickAcceptCookies() {
        acceptCookiesButtonLocator.shouldBe(visible);
        acceptCookiesButtonLocator.click();
    }

    @Step("menu elements of class toggler are not null")
    public void togglerMenuElementsArePresent() {
        mainNavigationLocator.shouldBe(visible);
        mainNavigationLocator.$$(".toggler").shouldBe(sizeGreaterThan(0));
    }

    @Step("click \"What We Do\" menu item")
    public void clickWhatWeDoMenuItem() {
        whatWeDoMenuItemLocator.shouldBe(visible);
        whatWeDoMenuItemLocator.click();
    }

    @Step("footer contains \"{FOOTER_TEXT}\"")
    public void assertFooterText() {
        pageFooterLocator.scrollTo();
        pageFooterLocator.shouldHave(matchText(FOOTER_TEXT));
    }

    @Step("Page title should have text \"{TITLE_TEXT}\"")
    public void assertTitleText(String titleValue) {
        mainNavigationLocator.shouldBe(visible);
        assertThat(TITLE_TEXT).isEqualTo(titleValue);
    }

    @Step("Console logs should not contain text 'SEVERE'")
    public void assertConsoleHaveNoErrors() {
        mainNavigationLocator.shouldBe(visible);
        String consoleLogs = DriverUtils.getConsoleLogs();
        assertThat(consoleLogs).doesNotContain(CONSOLE_ERROR_TEXT);
    }

    @Step("Console logs should not contain text 'WARNING'")
    public void assertConsoleHaveNoWarnings() {
        mainNavigationLocator.shouldBe(visible);
        String consoleLogs = DriverUtils.getConsoleLogs();
        assertThat(consoleLogs).doesNotContain(CONSOLE_WARNING_TEXT);
    }

}
