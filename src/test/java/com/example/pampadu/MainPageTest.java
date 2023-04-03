package com.example.pampadu;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import net.joshka.junit.json.params.JsonFileSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import javax.json.JsonObject;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        open(MainPage.URL);
    }

    @Test
    @DisplayName("Наличие - Заголовок страницы")
    public void titlePage() {
        mainPage.title.should(text("Калькулятор ОСАГО"), visible);
        mainPage.subtitle.should(text("Простой способ выгодно купить полис"), visible);
    }

    @ParameterizedTest(name = "{displayName} - {index}")
    @JsonFileSource(resources = "/fixtures/tips.json")
    @DisplayName("Наличие - Элементы блока с Подсказкой")
    public void tipsBlock(JsonObject object) {
        var index = object.getInt("index");
        var num = object.getString("num");
        var text = object.getString("text");
        mainPage.tipsNum.get(index).as("Номер подсказки").should(text(num));
        mainPage.tipsText.get(index).as("Текст подсказки").should(text(text));
    }

    @Test
    @DisplayName("Наличие - Заголовок блока с Гос. номером")
    public void gosNumTitle() {
        mainPage.gosNumTitle.should(text("Введите гос. номер"), visible);
        mainPage.gosNumSubtitle.should(text("и мы найдем данные автомобиля"), visible);
    }

    @Test
    @DisplayName("Механизм - Нажатие на 'Не помню или еще не получал' Гос. номер")
    public void gosNumLinkClick() {
        mainPage.gosNumLink.should(text("Не помню или еще не получал")).click();
        mainPage.gosNumLink.shouldNot(visible); // Добавить проверку перехода (вне тестовго задания)
    }

    // TODO Использовать API
    @Test
    @DisplayName("Механизм - Ввод валидного Гос. номера")
    public void gosNumSuccessful() {
        mainPage.gosNumInputLeftSide.should(visible).sendKeys("С123АМ");
        mainPage.gosNumInputRegion.should(visible).sendKeys("44");
        mainPage.gosNumButton.should(text("Продолжить"), visible).click();
        mainPage.gosNumInputLeftSide.shouldNot(visible); // Добавить проверку перехода (вне тестовго задания)
    }

    // TODO Использовать API
    @Test
    @DisplayName("Механизм - Ввод невалидного Гос. номера")
    public void gosNumFailed() {
        mainPage.gosNumInputLeftSide.should(visible).sendKeys("С123АQ");
        mainPage.gosNumInputRegion.should(visible).sendKeys("Q");
        mainPage.gosNumButton.should(text("Продолжить"), visible).click();
        mainPage.gosNumInputLeftSide.should(visible); // Добавить проверку перехода (вне тестовго задания)
    }

    @Test
    @DisplayName("Наличие - Элементы блока Стоимости")
    public void priceBlock() {
        mainPage.priceText1.should(visible);
        mainPage.priceText2.should(visible);
        mainPage.priceText3.should(visible);
        mainPage.priceText4.should(visible);
    }

    @Test
    @DisplayName("Наличие - Картинки страницы")
    public void imagesPage() {
        mainPage.images.should(CollectionCondition.size(4));
        mainPage.checkAllImagesPage();
        mainPage.svgCar.should(visible);
    }

}
