package org.example.tests.herokuapp;

import io.qameta.allure.*;
import org.example.pages.herokuapp.InputsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Тестирование сайта HerokuApp")
@Feature("Поля ввода")
public class InputsTest extends BaseTest {

    @Test
    @DisplayName("Проверка ввода данных в числовое поле")
    @Story("Пользователь должен иметь возможность вводить числа и изменять их стрелками")
    @Description("Тест проверяет ввод цифр, работу клавиш ARROW_UP/ARROW_DOWN и игнорирование текстового ввода.")
    @Severity(SeverityLevel.NORMAL)
    public void testInputs() {
        InputsPage page = new InputsPage(driver);
        page.open();

        // Проверка ввода чисел
        page.enterText("123");
        Assertions.assertEquals("123", page.getInputValue(), "Значение 123 должно быть введено");

        // Проверка стрелок
        page.pressArrowUp();
        Assertions.assertEquals("124", page.getInputValue(), "Значение должно увеличиться до 124");

        page.pressArrowDown();
        Assertions.assertEquals("123", page.getInputValue(), "Значение должно уменьшиться до 123");

        // Проверка ввода текста (не должен отображаться, если это type=number)
        page.enterText("abc");
        Assertions.assertEquals("", page.getInputValue(), "Текст не должен вводиться в числовое поле");
    }
}
