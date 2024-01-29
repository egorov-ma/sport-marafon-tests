package ru.sportmarafon.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;

public class PersonalAreaPage {
    private final SelenideElement linkPersonalProfile = $("#personal-link-2"),
            inputProfileName = $("#personal_profile_NAME"),
            inputEmail = $("#personal_profile_EMAIL"),
            inputPhone = $("#personal_profile_PERSONAL_PHONE");

    @Step("Переход в раздел 'Моя информация'")
    public void linkPersonalProfile() {
        linkPersonalProfile.click();
    }

    @Step("Проверка ФИО - {name}")
    public void checkPersonalName(String name) {
        String personalName = inputProfileName.getValue();
        Assertions.assertEquals(name, personalName);
    }

    @Step("Проверка email - {email}")
    public void checkEmail(String email) {
        String personalName = inputEmail.getValue();
        Assertions.assertEquals(email, personalName);
    }

    @Step("Проверка телефона - {phone}")
    public void checkPhone(String phone) {
        String personalName = inputPhone.getValue();
        Assertions.assertEquals(phone, personalName);
    }
}
