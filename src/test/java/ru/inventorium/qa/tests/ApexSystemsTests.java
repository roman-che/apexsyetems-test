package ru.inventorium.qa.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;

public class ApexSystemsTests extends TestBase {

    @BeforeEach
    public void openPage(){
        mainPage.openMainPage();
    }

    @Test
    @Tags({@Tag("all_tests"), @Tag("page_tests")})
    @Description("At least one toggler element in menu")
    @DisplayName("Menu has at least one toggler element")
    void menuTogglerElementsTest() {
                //mainPage.openMainPage();
                mainPage.clickAcceptCookies();
                mainPage.togglerMenuElementsArePresent();
    }

    @Test
    @Tags({@Tag("all_tests"), @Tag("page_tests")})
    @Description("Text assertion in footer")
    @DisplayName("\"What We do\" footer contains text")
    void clickWhatWeDoTest() {
                //mainPage.openMainPage();
                mainPage.clickAcceptCookies();
                mainPage.clickWhatWeDoMenuItem();
                mainPage.assertFooterText();
    }

    @Test
    @Tags({@Tag("all_tests"), @Tag("page_tests")})
    @Description("Title text assertion")
    @DisplayName("Page title should have text 'Apex Systems'")
    void titleTest() {
                //mainPage.openMainPage();
                mainPage.assertTitleText(title());
    }

    @Test
    @Tags({@Tag("all_tests"), @Tag("console_tests")})
    @Description("No errors in console log assertion")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
                //mainPage.openMainPage();
                mainPage.assertConsoleHaveNoErrors();
    }

    @Test
    @Tags({@Tag("all_tests"), @Tag("console_tests")})
    @Description("Console log has no warnings assertion")
    @DisplayName("Page console log should have no warnings")
    void consoleShouldNotHaveWarnings() {
                //mainPage.openMainPage();
                mainPage.assertConsoleHaveNoWarnings();
    }

    @Test
    @Tags({@Tag("all_tests"), @Tag("page_tests")})
    @Disabled("Test code for further test development")
    @Description("Skipped test")
    @DisplayName("Skipped test")
    void skippedTest() {
        //Skipped test code here
    }
}
