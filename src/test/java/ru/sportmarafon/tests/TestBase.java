package ru.sportmarafon.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.sportmarafon.config.ProjectConfiguration;
import ru.sportmarafon.config.web.WebConfig;
import ru.sportmarafon.helpers.Attach;

public class TestBase {
    private static final WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());

    @BeforeAll
    static void beforeAll() {
        ProjectConfiguration projectConfiguration = new ProjectConfiguration(webConfig);
        projectConfiguration.webConfig();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        Selenide.closeWebDriver();
    }
}
