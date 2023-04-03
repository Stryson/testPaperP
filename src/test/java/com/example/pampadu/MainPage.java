package com.example.pampadu;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    public static final String URL = "https://b2c.pampadu.ru/index.html#49a973bd-2d7c-4b9b-9c28-d986d7757983";

    public SelenideElement title = $(".ppdw-head-title").as("Заголовок");
    public SelenideElement subtitle = $(".ppdw-head-sub").as("Подзаголовок");

    //TODO Ненадежный локатор на текст
    public SelenideElement tipTextMobile = $(byText("Рассчитайте стоимость в 16+ компаниях, сравните, оплатите картой и получите полис на e-mail")).as("Текст подсказки");

    public ElementsCollection tipsNum = $$("span.step-num");
    public ElementsCollection tipsText = $$("span.step-title");

    public SelenideElement gosNumTitle = $(".gos-sign-title").as("Заголовок");
    public SelenideElement gosNumSubtitle = $(".gos-sign-subtitle").as("Подзаголовок");
    public SelenideElement gosNumLink = $("[data-test='gos-sign-link']").as("Не помню или еще не получал");
    public SelenideElement gosNumButton = $("[data-test='left-side-gos-sign-continue']").as("Кнопка");
    public SelenideElement gosNumInputLeftSide = $("[data-test='left-side-gos-sign']").as("Гос. номер - левая сторона");
    public SelenideElement gosNumInputRegion = $(".gos-input-region").as("Гос. номер - регион");

    //TODO Ненадежный локатор на текст
    public SelenideElement priceText1 = $(byText("Экономия до")).as("Экономия до");
    public SelenideElement priceText2 = $(byText("20%")).as("20%");
    public SelenideElement priceText3 = $(byText("или в среднем:")).as("или в среднем:");
    public SelenideElement priceText4 = $(byText("1060 ₽")).as("1060 ₽");

    public SelenideElement svgCar = $("svg.ppdw-car").as("Машина");

    //TODO Нет локатора на картинку
    public ElementsCollection images = $(".ppdw-main-card").$$("img");

    public void checkAllImagesPage() {
        images.get(0).as("Стрелка 1").isImage();
        images.get(1).as("Стрелка 2").isImage();
        images.get(2).as("Флаг").isImage();
        images.get(3).as("Картинка с ценами").isImage();
    }

}
