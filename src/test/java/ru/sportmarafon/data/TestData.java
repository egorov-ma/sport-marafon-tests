package ru.sportmarafon.data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    private final Faker fakerRu = new Faker(new Locale("ru"));
    private final Faker fakerEn = new Faker(new Locale("en"));

    public final static String TEST_EMAIL = "testtest@test.ru",
            WRONG_TEST_EMAIL = "wrong.testtest@test.ru",
            TEST_PASSWORD = "qwe123",
            TEST_NAME = "Тестовый Клиент",
            TEST_PHONE = "+7 (123) 456-78-90",
            AUTH_ERR_MSG = "Неверный логин или пароль.";

    public String fullName = fakerRu.name().fullName(),
            phone = fakerRu.phoneNumber().phoneNumber(),
            email = fakerEn.internet().emailAddress(),
            password = fakerRu.numerify("######");
}