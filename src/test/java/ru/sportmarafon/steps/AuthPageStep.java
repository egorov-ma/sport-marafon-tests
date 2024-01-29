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
                .enter();
    }

    @Step("Заполнение формы регистрации")
    public void setRegistrationForm(TestData data) {
        authPage.linkRegistration()
                .setRegisterName(data.fullName)
                .setRegisterPhone(data.phone)
                .setRegisterEmail(data.email)
                .setRegisterPass(data.password)
                .setRegisterConfirmPass(data.password)
                .submit();
    }
}