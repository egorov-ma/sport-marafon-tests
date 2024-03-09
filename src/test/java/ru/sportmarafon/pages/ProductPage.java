package ru.sportmarafon.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPage {
    private final SelenideElement productName = $("h1[itemprop='name']"),
            btnAddCart = $("button[class*='catalog-detail__to-cart']");
    private final ElementsCollection btnPopupCart = $$("a[href='/personal/basket/'].popup-form__btn_cart");

    @Step("Получаем название продкут")
    public String getProductName() {
        return productName.text();
    }

    @Step("Добавляем продукт и переходим в корзину")
    public void addGoCart() {
        btnAddCart.scrollTo().shouldBe(visible).click();
        btnPopupCart.first().click();
    }
}