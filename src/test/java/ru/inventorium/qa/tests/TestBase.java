package ru.inventorium.qa.tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.inventorium.qa.config.Project;
import ru.inventorium.qa.helpers.AllureAttachments;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.inventorium.qa.pages.MainPage;

import static java.lang.String.format;

@ExtendWith({AllureJunit5.class})
public class TestBase {

    MainPage mainPage = new MainPage();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserSize="1920x1080";
        Configuration.startMaximized = true;
        Configuration.remote = format("https://%s:%s@%s",Project.config.login(),Project.config.password(),Project.config.remoteDriverUrl());
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void addAttachments() {
        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        AllureAttachments.addVideo();
        Selenide.closeWebDriver();
    }

}
