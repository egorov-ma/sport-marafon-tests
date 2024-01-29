package ru.sportmarafon.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final ElementsCollection headerMenu = $$("ul[class='header-menu__wrap'] li");
    private final SelenideElement buttonAuth = $(byText("Вход")),
            linkHeaderUser = $("a[class='header__user-initial']");

    @Step("Открываем главную страницу - {url}")
    public MainPage openMainPage(String url) {
        open(url);
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Нажимаем кнопку 'Вход'")
    public void btnAuth() {
        buttonAuth.click();
    }

    @Step("Переходим в профиль клиента")
    public void linkUser() {
        linkHeaderUser.click();
    }

    @Step("Проверка досупности личного кабмнета")
    public void checkUser() {
        linkHeaderUser.click();
    }

    @Step("Проверка 'Шапки' главной страницы")
    public void checkMainHeader() {
        headerMenu.shouldHave(texts("Доставка и оплата", "Контакты", "Сервис", "Блог",
                "Клуб", "YouTube", "Fest", "Подкасты", "Парк", "О магазине"));
    }
}
