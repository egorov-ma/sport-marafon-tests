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
    public void openTestPersonalProfile(String email, String pass) {
        mainPageStep.openAuthForm(baseUrl);
        authPageStep.login(email, pass);
        mainPage.clickUser();
        personalAreaPage.clickPersonalProfile();
    }

    @Step("Проверка данных тестового клиента")
    public void checkTestPersonalData(String name, String email, String phone) {
        personalAreaPage.checkPersonalName(name);
        personalAreaPage.checkEmail(email);
        personalAreaPage.checkPhone(phone);
    }
}
