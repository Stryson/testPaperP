package com.example.pampadu;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class MainPageMobileTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "400x800";
    }

    @BeforeEach
    public void setUp() {
        open("https://b2c.pampadu.ru/index.html#49a973bd-2d7c-4b9b-9c28-d986d7757983");
    }

    @Test
    @DisplayName("Наличие - Заголовок страницы и текст Подсказки")
    public void titlePageAndTipsBlock() {
        mainPage.title.should(text("Калькулятор ОСАГО"), visible);
        mainPage.subtitle.should(text("Простой способ выгодно купить полис"), visible);
        mainPage.tipTextMobile.should(visible);
    }

}
