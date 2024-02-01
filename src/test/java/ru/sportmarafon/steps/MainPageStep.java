package ru.sportmarafon.steps;

import io.qameta.allure.Step;
import ru.sportmarafon.pages.MainPage;

public class MainPageStep {

    MainPage mainPage = new MainPage();

    @Step("Переход на форму авторизации")
    public void openAuthForm(String url) {
        mainPage.openMainPage(url)
                .clickAuth();
    }
}
