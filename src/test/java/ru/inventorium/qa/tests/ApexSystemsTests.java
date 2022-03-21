package ru.inventorium.qa.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class ApexSystemsTests extends TestBase {

    @Test
    @Tags({@Tag("all_tests"), @Tag("page_tests")})
    @Description("at least one toggler element in menu")
    @DisplayName("Menu has at least one toggler element")
    void menuTogglerElementsTest() {
        step("open https://www.apexsystems.com/", () ->
                mainPage.openMainPage());

        step("click 'accept cookies'", () ->
                mainPage.clickAcceptCookies());

        step("menu elements of class toggler are not null ", () ->
                mainPage.togglerMenuElementsArePresent());
    }

    @Test
    @Tags({@Tag("all_tests"), @Tag("page_tests")})
    @Description(" text assertion in footer")
    @DisplayName("\"What We do\" footer contains text")
    void clickWhatWeDoTest() {
        step("open https://www.apexsystems.com/", () ->
                mainPage.openMainPage());

        step("accept cookies", () ->
                mainPage.clickAcceptCookies());

        step("click \"What We Do\" menu item ", () ->
                mainPage.clickWhatWeDoMenuItem());

        step("footer contains \"Apex Systems is an equal opportunity employer.\" ", () ->
                mainPage.assertFooterText());
    }

    @Test
    @Tags({@Tag("all_tests"), @Tag("page_tests")})
    @Description("title text assertion")
    @DisplayName("Page title should have text 'Apex Systems'")
    void titleTest() {
        step("Open url 'https://www.apexsystems.com/'", () ->
                mainPage.openMainPage());

        step("Page title should have text 'Apex Systems'", () ->
                mainPage.assertTitleText(title()));
    }

    @Test
    @Tags({@Tag("all_tests"), @Tag("console_tests")})
    @Description("No errors in console log assertion")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.apexsystems.com/'", () ->
                mainPage.openMainPage());

        step("Console logs should not contain text 'SEVERE'", () ->
                mainPage.assertConsoleHaveNoErrors());
    }

    @Test
    @Tags({@Tag("all_tests"), @Tag("console_tests")})
    @Description("console log has no warnings assertion")
    @DisplayName("Page console log should have no warnings")
    void consoleShouldNotHaveWarnings() {
        step("Open url 'https://www.apexsystems.com/'", () ->
                mainPage.openMainPage());

        step("Console logs should not contain text 'WARNING'", () ->
                mainPage.assertConsoleHaveNoWarnings());
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
