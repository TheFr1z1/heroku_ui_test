package org.example.tests.herokuapp;

import io.qameta.allure.*;
import org.example.pages.herokuapp.DropdownPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Тестирование сайта HerokuApp")
@Feature("Выпадающий список")
public class DropdownTest extends BaseTest {

    @Test
    @DisplayName("Проверка выбора элементов из списка")
    @Story("Пользователь должен иметь возможность выбрать любую опцию из выпадающего меню")
    @Description("Тест выбирает опции 1 и 2 и проверяет, что они действительно выбраны.")
    @Severity(SeverityLevel.NORMAL)
    public void testDropdown() {
        DropdownPage page = new DropdownPage(driver);
        page.open();

        page.selectByText("Option 1");
        Assertions.assertEquals("Option 1", page.getFirstSelectedOption(), "Опция 1 должна быть выбрана");

        page.selectByText("Option 2");
        Assertions.assertEquals("Option 2", page.getFirstSelectedOption(), "Опция 2 должна быть выбрана");
    }
}
