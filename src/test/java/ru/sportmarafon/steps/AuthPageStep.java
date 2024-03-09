package ru.sportmarafon.steps;

import io.qameta.allure.Step;
import ru.sportmarafon.data.TestData;
import ru.sportmarafon.pages.AuthPage;

public class AuthPageStep {

    AuthPage authPage = new AuthPage();

    @Step("Выполнение авторизации под пользователем {email}")
    public void login(String email, String password) {
        authPage.setEmail(email)
                .setPass(password)
                .clickEnter();
    }

    @Step("Заполнение формы регистрации")
    public void setRegistrationForm(TestData data) {
        authPage.clickRegistrationLink()
                .setRegistrationName(data.fullName)
                .setRegistrationPhone(data.phone)
                .setRegistrationEmail(data.email)
                .setRegistrationPass(data.password)
                .setRegistrationConfirmPass(data.password)
                .clickSubmit();
    }
}