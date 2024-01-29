package ru.sportmarafon.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage {

    private final SelenideElement inputEmail = $("#system_auth_form_USER_LOGIN"),
            inputPass = $("#system_auth_form_USER_PASSWORD"),
            buttonEnter = $("#system_auth_form_Login"),
            errMsg = $("div[class*='response']"),
            linkRegistration = $("a[aria-controls='registration_form']"),
            inputRegisterName = $("#REGISTER_NAME"),
            inputRegisterPhone = $("#REGISTER_PERSONAL_PHONE"),
            inputRegisterEmail = $("#REGISTER_EMAIL"),
            inputRegisterPassword = $("#REGISTER_PASSWORD"),
            inputRegisterConfirmPassword = $("#REGISTER_CONFIRM_PASSWORD"),
            buttonRegisterSubmit = $("#REGISTER_register_submit_button");

    @Step("Вставляем email - {email}")
    public AuthPage setEmail(String email) {
        inputEmail.setValue(email);
        return this;
    }

    @Step("Вставляем пароль")
    public AuthPage setPass(String pass) {
        inputPass.setValue(pass);
        return this;
    }

    @Step("Нажимаем кнопку 'Войти'")
    public void enter() {
        buttonEnter.click();
    }

    @Step("Переходим на форму 'Регистрация'")
    public AuthPage linkRegistration() {
        linkRegistration.click();
        return this;
    }

    @Step("Вводим ФИО - {fullName}")
    public AuthPage setRegisterName(String fullName) {
        inputRegisterName.setValue(fullName);
        return this;
    }

    @Step("Вводим номер телефона - {phone}")
    public AuthPage setRegisterPhone(String phone) {
        inputRegisterPhone.setValue(phone);
        return this;
    }

    @Step("Вводим email - {email}")
    public AuthPage setRegisterEmail(String email) {
        inputRegisterEmail.setValue(email);
        return this;
    }

    @Step("Вводим пароль")
    public AuthPage setRegisterPass(String pass) {
        inputRegisterPassword.setValue(pass);
        return this;
    }

    @Step("Вводим подтверждение пароля")
    public AuthPage setRegisterConfirmPass(String pass) {
        inputRegisterConfirmPassword.setValue(pass);
        return this;
    }

    @Step("Нажимаем кнопку 'Зарегистрироваться'")
    public void submit() {
        buttonRegisterSubmit.click();
    }

    @Step("Проверяем текст ошиби")
    public void negativeCheckAuth(String msg) {
        errMsg.shouldHave(text(msg));
    }
}