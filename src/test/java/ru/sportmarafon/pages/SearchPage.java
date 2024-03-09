package ru.sportmarafon.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {
    private final SelenideElement inputSearch = $("#head-search-input");

    private final ElementsCollection firstProduct = $$("div[class='product-list__item-hover']");

    @Step("Ищем продукт {0}")
    public SearchPage searchProduct(String product) {
        inputSearch.setValue(product).pressEnter();
        return this;
    }

    @Step("Выбираем первый продукт")
    public void chooseFirst() {
        firstProduct.first().shouldBe(visible).click();
    }
}