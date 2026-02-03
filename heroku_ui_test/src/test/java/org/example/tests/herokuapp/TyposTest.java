package org.example.tests.herokuapp;

import io.qameta.allure.*;
import org.example.pages.herokuapp.TyposPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Тестирование сайта HerokuApp")
@Feature("Опечатки")
public class TyposTest extends BaseTest {

    @Test
    @DisplayName("Проверка текста на наличие опечаток")
    @Story("Текст на странице не должен содержать грамматических ошибок")
    @Description("Тест сравнивает текст на странице с эталонным значением.")
    @Severity(SeverityLevel.TRIVIAL)
    public void testTypos() {
        TyposPage page = new TyposPage(driver);
        page.open();

        String expectedText = "Sometimes you'll see a typo, other times you won't.";
        String actualText = page.getParagraphText();

        // В зависимости от перезагрузки текст может меняться,
        // но по заданию нужно проверить "наличие опечаток"
        Assertions.assertEquals(expectedText, actualText, "Текст содержит опечатку или не совпадает");
    }
}
