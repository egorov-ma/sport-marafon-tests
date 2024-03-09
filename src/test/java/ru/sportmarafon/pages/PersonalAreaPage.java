package ru.sportmarafon.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;

public class PersonalAreaPage {
    AuthPage authPage = new AuthPage();
    private final SelenideElement linkPersonalProfile = $("#personal-link-2"),
            inputProfileName = $("#personal_profile_NAME"),
            inputEmail = $("#personal_profile_EMAIL"),
            inputPhone = $("#personal_profile_PERSONAL_PHONE"),
            linkHeaderUser = $("a[class='header__user-initial']");

    @Step("Переходим в профиль клиента")
    private void clickUser() {
        linkHeaderUser.click();
    }

    @Step("Переход в раздел 'Моя информация'")
    private void clickPersonalProfile() {
        linkPersonalProfile.click();
    }

    @Step("Проверка ФИО - {name}")
    private void checkPersonalName(String name) {
        String personalName = inputProfileName.getValue();
        Assertions.assertEquals(name, personalName);
    }

    @Step("Проверка email - {email}")
    private void checkEmail(String email) {
        String personalName = inputEmail.getValue();
        Assertions.assertEquals(email, personalName);
    }

    @Step("Проверка телефона - {phone}")
    private void checkPhone(String phone) {
        String personalName = inputPhone.getValue();
        Assertions.assertEquals(phone, personalName);
    }


    @Step("Открытие Профиля клиента, раздела - 'Моя информация'")
    public void openTestPersonalProfile(String email, String pass) {
        authPage.login(email, pass);
        clickUser();
        clickPersonalProfile();
    }

    @Step("Проверка данных тестового клиента")
    public void checkTestPersonalData(String name, String email, String phone) {
        checkPersonalName(name);
        checkEmail(email);
        checkPhone(phone);
    }
}