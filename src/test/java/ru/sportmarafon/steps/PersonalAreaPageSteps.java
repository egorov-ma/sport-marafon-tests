package ru.sportmarafon.steps;

import io.qameta.allure.Step;
import ru.sportmarafon.pages.MainPage;
import ru.sportmarafon.pages.PersonalAreaPage;

public class PersonalAreaPageSteps {

    AuthPageStep authPageStep = new AuthPageStep();
    MainPage mainPage = new MainPage();
    PersonalAreaPage personalAreaPage = new PersonalAreaPage();

    @Step("Открытие Профиля клиента, раздела - 'Моя информация'")
    public void openTestPersonalProfile(String email, String pass) {
        mainPage.openAuthForm();
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
