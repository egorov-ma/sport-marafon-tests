package ru.sportmarafon.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.sportmarafon.data.TestData;

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
    private AuthPage setEmail(String email) {
        inputEmail.setValue(email);
        return this;
    }

    @Step("Вставляем пароль")
    private AuthPage setPass(String pass) {
        inputPass.setValue(pass);
        return this;
    }

    @Step("Нажимаем кнопку 'Войти'")
    private void clickEnter() {
        buttonEnter.click();
    }

    @Step("Переходим на форму 'Регистрация'")
    private AuthPage clickRegistrationLink() {
        linkRegistration.click();
        return this;
    }

    @Step("Вводим ФИО - {fullName}")
    private AuthPage setRegistrationName(String fullName) {
        inputRegisterName.setValue(fullName);
        return this;
    }

    @Step("Вводим номер телефона - {phone}")
    private AuthPage setRegistrationPhone(String phone) {
        inputRegisterPhone.setValue(phone);
        return this;
    }

    @Step("Вводим email - {email}")
    private AuthPage setRegistrationEmail(String email) {
        inputRegisterEmail.setValue(email);
        return this;
    }

    @Step("Вводим пароль")
    private AuthPage setRegistrationPass(String pass) {
        inputRegisterPassword.setValue(pass);
        return this;
    }

    @Step("Вводим подтверждение пароля")
    private AuthPage setRegistrationConfirmPass(String pass) {
        inputRegisterConfirmPassword.setValue(pass);
        return this;
    }

    @Step("Нажимаем кнопку 'Зарегистрироваться'")
    private void clickSubmit() {
        buttonRegisterSubmit.click();
    }


    @Step("Выполнение авторизации под пользователем {email}")
    public void login(String email, String password) {
        setEmail(email).setPass(password).clickEnter();
    }

    @Step("Заполнение формы регистрации")
    public void setRegistrationForm(TestData data) {
        clickRegistrationLink()
                .setRegistrationName(data.fullName)
                .setRegistrationPhone(data.phone)
                .setRegistrationEmail(data.email)
                .setRegistrationPass(data.password)
                .setRegistrationConfirmPass(data.password)
                .clickSubmit();
    }

    @Step("Проверяем текст ошибки")
    public void checkNegativeAuth(String msg) {
        errMsg.shouldHave(text(msg));
    }
}