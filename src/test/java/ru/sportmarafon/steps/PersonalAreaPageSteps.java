package ru.sportmarafon.steps;

import io.qameta.allure.Step;
import ru.sportmarafon.pages.MainPage;
import ru.sportmarafon.pages.PersonalAreaPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static ru.sportmarafon.data.TestData.*;

public class PersonalAreaPageSteps {

    MainPageStep mainPageStep = new MainPageStep();
    AuthPageStep authPageStep = new AuthPageStep();
    MainPage mainPage = new MainPage();
    PersonalAreaPage personalAreaPage = new PersonalAreaPage();

    @Step("Открытие Профиля клиента, раздела - 'Моя информация'")
    public void openTestPersonalProfile() {
        mainPageStep.linkAuth(baseUrl);
        authPageStep.login(TEST_EMAIL, TEST_PASSWORD);
        mainPage.linkUser();
        personalAreaPage.linkPersonalProfile();
    }

    @Step("Проверка данных тестового клиента")
    public void checkTestPersonalData() {
        personalAreaPage.checkPersonalName(TEST_NAME);
        personalAreaPage.checkEmail(TEST_EMAIL);
        personalAreaPage.checkPhone(TEST_PHONE);
    }
}
