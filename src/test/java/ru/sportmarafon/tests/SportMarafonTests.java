package ru.sportmarafon.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.sportmarafon.data.TestData;
import ru.sportmarafon.pages.*;

import static ru.sportmarafon.data.TestData.*;

@DisplayName("Проверка sport-marafon.ru")
@Tag("WEB")
public class SportMarafonTests extends TestBase {
    TestData data = new TestData();
    MainPage mainPage = new MainPage();
    AuthPage authPage = new AuthPage();
    PersonalAreaPage personalAreaPage = new PersonalAreaPage();
    SearchPage searchPage = new SearchPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @Test
    @Tags({
            @Tag("SMOKE"),
            @Tag("POSITIVE")
    })
    @Feature("Тесты на главной")
    @Story("Позитивный тест")
    @Owner("@egorovma")
    @Severity(SeverityLevel.CRITICAL)
    @Link(url = "https://sport-marafon.ru/")
    @DisplayName("Проверка открытия главной")
    void mainPageOpenTest() {
        mainPage.openMainPage();
        mainPage.checkMainHeader();
    }

    @Test
    @Tags({
            @Tag("SMOKE"),
            @Tag("POSITIVE")
    })
    @Feature("Тесты на авторизацию")
    @Story("Позитивный тест")
    @Owner("@egorovma")
    @Severity(SeverityLevel.CRITICAL)
    @Link(url = "https://sport-marafon.ru/")
    @DisplayName("Проверка авторизации")
    void successfulAuthTest() {
        mainPage.openAuthForm();
        authPage.login(TEST_EMAIL, TEST_PASSWORD);
        mainPage.checkUserVisibility();
    }

    @Test
    @Tag("NEGATIVE")
    @Feature("Тесты на авторизацию")
    @Story("Негативный тест")
    @Owner("@egorovma")
    @Severity(SeverityLevel.BLOCKER)
    @Link(url = "https://sport-marafon.ru/")
    @DisplayName("Проверка некорректной авторизации")
    void negativeAuthTest() {
        mainPage.openAuthForm();
        authPage.login(WRONG_TEST_EMAIL, TEST_PASSWORD);
        authPage.checkNegativeAuth(AUTH_ERR_MSG);
    }

    @Test
    @Tags({
            @Tag("REGRESSION"),
            @Tag("POSITIVE")
    })
    @Feature("Тесты на регистрацию")
    @Story("Позитивный тест")
    @Owner("@egorovma")
    @Severity(SeverityLevel.CRITICAL)
    @Link(url = "https://sport-marafon.ru/")
    @DisplayName("Проверка регистрации")
    public void registrationTest() {
        mainPage.openAuthForm();
        authPage.setRegistrationForm(data);
        mainPage.checkUserVisibility();
    }

    @Test
    @Tags({
            @Tag("REGRESSION"),
            @Tag("POSITIVE")
    })
    @Feature("Тесты личный кабинет")
    @Story("Позитивный тест")
    @Owner("@egorovma")
    @Severity(SeverityLevel.CRITICAL)
    @Link(url = "https://sport-marafon.ru/")
    @DisplayName("Проверка профиля клиента")
    public void personalProfileTest() {
        mainPage.openAuthForm();
        personalAreaPage.openTestPersonalProfile(TEST_EMAIL, TEST_PASSWORD);
        personalAreaPage.checkTestPersonalData(TEST_NAME, TEST_EMAIL, TEST_PHONE);
    }

    @ValueSource(strings = {
            "nike", "hoka", "saucony"
    })
    @ParameterizedTest(name = "Проверка поиска продукта: {0}")
    @Tags({
            @Tag("WEB"),
            @Tag("POSITIVE")
    })
    @Feature("Проверка поиска товара")
    @Story("Позитивный тест")
    @Owner("@egorovma")
    @Severity(SeverityLevel.CRITICAL)
    @Link(url = "https://sport-marafon.ru/")
    @DisplayName("Проверка различных наборов поиска товаров")
    void searchProductTest(String product) {
        mainPage.openMainPage()
                .clickSearch();
        searchPage.searchProduct(product)
                .chooseFirst();
        String productName = productPage.getProductName();
        productPage.addGoCart();
        cartPage.checkProductName(cartPage.getProductNameCart(), productName);
    }
}