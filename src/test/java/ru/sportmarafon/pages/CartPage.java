package ru.sportmarafon.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class CartPage {
    private final SelenideElement productName = $("a[class$='name']");

    @Step("Получение названия продукта в корзине")
    public String getProductNameCart() {
        return productName.text();
    }

    @Step("Проверка, что продкт добавлен корректно")
    public void checkProductName(String productNameInCart, String productName) {
        assertThat(productNameInCart).contains(productName);
    }
}