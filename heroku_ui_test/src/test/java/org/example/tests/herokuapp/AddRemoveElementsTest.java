package org.example.tests.herokuapp;

import io.qameta.allure.*;
import org.example.pages.herokuapp.AddRemoveElementsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Тестирование сайта HerokuApp")
@Feature("Добавление и удаление элементов")
public class AddRemoveElementsTest extends BaseTest {

    @Test
    @DisplayName("Проверка функционала добавления и удаления кнопок")
    @Story("Пользователь должен иметь возможность добавлять и удалять элементы на лету")
    @Description("Тест проверяет, что при нажатии на 'Add Element' появляется новая кнопка, а при нажатии на нее — исчезает.")
    @Severity(SeverityLevel.NORMAL)
    public void testAddRemove() {
        AddRemoveElementsPage page = new AddRemoveElementsPage(driver);
        page.open();

        // Добавляем 2 элемента
        page.addElement();
        page.addElement();
        Assertions.assertEquals(2, page.getDeleteButtonsCount(), "Должно быть 2 кнопки удаления");

        // Удаляем один элемент
        page.deleteElement();
        Assertions.assertEquals(1, page.getDeleteButtonsCount(), "Должна остаться 1 кнопка удаления");
    }
}
