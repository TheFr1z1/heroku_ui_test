package org.example.tests.herokuapp;

import io.qameta.allure.*;
import org.example.pages.herokuapp.CheckboxesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Тестирование сайта HerokuApp")
@Feature("Чекбоксы")
public class CheckboxesTest extends BaseTest {

    @Test
    @DisplayName("Проверка состояния и переключения чекбоксов")
    @Story("Пользователь должен иметь возможность отмечать и снимать выделение с чекбоксов")
    @Description("Тест проверяет начальное состояние чекбоксов и корректность смены состояния при клике.")
    @Severity(SeverityLevel.MINOR)
    public void testCheckboxes() {
        CheckboxesPage page = new CheckboxesPage(driver);
        page.open();

        // Первый чекбокс unchecked по умолчанию
        Assertions.assertFalse(page.isChecked(0), "Первый чекбокс должен быть не отмечен");

        // Отмечаем первый чекбокс
        page.clickCheckbox(0);
        Assertions.assertTrue(page.isChecked(0), "Первый чекбокс должен стать отмеченным");

        // Второй чекбокс checked по умолчанию
        Assertions.assertTrue(page.isChecked(1), "Второй чекбокс должен быть отмечен");

        // Снимаем отметку со второго чекбокса
        page.clickCheckbox(1);
        Assertions.assertFalse(page.isChecked(1), "Второй чекбокс должен стать не отмеченным");
    }
}
