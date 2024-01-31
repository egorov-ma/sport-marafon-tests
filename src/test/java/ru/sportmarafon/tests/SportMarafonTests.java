package ru.sportmarafon.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.sportmarafon.data.TestData;
import ru.sportmarafon.pages.AuthPage;
import ru.sportmarafon.pages.MainPage;
import ru.sportmarafon.steps.AuthPageStep;
import ru.sportmarafon.steps.MainPageStep;
import ru.sportmarafon.steps.PersonalAreaPageSteps;

import static com.codeborne.selenide.Configuration.baseUrl;
import static ru.sportmarafon.data.TestData.*;

@DisplayName("Проверка sport-marafon.ru")
@Tag("WEB")
public class SportMarafonTests extends TestBase {
    TestData data = new TestData();
    MainPage mainPage = new MainPage();
    MainPageStep mainPageStep = new MainPageStep();
    AuthPage authPage = new AuthPage();
    AuthPageStep authPageStep = new AuthPageStep();
    PersonalAreaPageSteps personalAreaPageSteps = new PersonalAreaPageSteps();

    @Test
    @Tags({
            @Tag("SMOKE"),
            @Tag("POSITIVE")
    })
    @Feature("Тесты на главной")
    @Story("Позитивный тест")
    @Owner("@egorovma")
    @Severity(SeverityLevel.CRITICAL)
    @Link(url = "https://sport-marafon.ru/")
    @DisplayName("Проверка открытия главной")
    void mainPageTest() {
        mainPage.openMainPage(baseUrl);
        mainPage.checkMainHeader();
    }

    @Test
    @Tags({
            @Tag("SMOKE"),
            @Tag("POSITIVE")
    })
    @Feature("Тесты на авторизацию")
    @Story("Позитивный тест")
    @Owner("@egorovma")
    @Severity(SeverityLevel.CRITICAL)
    @Link(url = "https://sport-marafon.ru/")
    @DisplayName("Проверка авторизации")
    void successfulAuthTest() {
        mainPageStep.linkAuth(baseUrl);
        authPageStep.login(TEST_EMAIL, TEST_PASSWORD);
        mainPage.checkUser();
    }

    @Test
    @Tag("NEGATIVE")
    @Feature("Тесты на авторизацию")
    @Story("Негативный тест")
    @Owner("@egorovma")
    @Severity(SeverityLevel.BLOCKER)
    @Link(url = "https://sport-marafon.ru/")
    @DisplayName("Проверка некорректной авторизации")
    void negativeAuthTest() {
        mainPageStep.linkAuth(baseUrl);
        authPageStep.login(WRONG_TEST_EMAIL, TEST_PASSWORD);
        authPage.negativeCheckAuth(AUTH_ERR_MSG);
    }

    @Test
    @Tags({
            @Tag("REGRESSION"),
            @Tag("POSITIVE")
    })
    @Feature("Тесты на регистрацию")
    @Story("Позитивный тест")
    @Owner("@egorovma")
    @Severity(SeverityLevel.CRITICAL)
    @Link(url = "https://sport-marafon.ru/")
    @DisplayName("Проверка регистрации")
    public void registrationTest() {
        mainPageStep.linkAuth(baseUrl);
        authPageStep.setRegistrationForm(data);
        mainPage.checkUser();
    }

    @Test
    @Tags({
            @Tag("REGRESSION"),
            @Tag("POSITIVE")
    })
    @Feature("Тесты личный кабинет")
    @Story("Позитивный тест")
    @Owner("@egorovma")
    @Severity(SeverityLevel.CRITICAL)
    @Link(url = "https://sport-marafon.ru/")
    @DisplayName("Проверка профиля клиента")
    public void personalProfileTest() {
        personalAreaPageSteps.openTestPersonalProfile(TEST_EMAIL, TEST_PASSWORD);
        personalAreaPageSteps.checkTestPersonalData();
    }
}