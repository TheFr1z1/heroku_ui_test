package org.example.tests.herokuapp;

import io.qameta.allure.*;
import org.example.pages.herokuapp.SortableDataTablesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Тестирование сайта HerokuApp")
@Feature("Таблицы")
public class SortableDataTablesTest extends BaseTest {

    @Test
    @DisplayName("Проверка содержимого таблиц")
    @Story("Пользователь должен видеть корректные данные в ячейках")
    @Description("Тест проверяет конкретные значения Email и Фамилии в первой таблице.")
    @Severity(SeverityLevel.NORMAL)
    public void testTables() {
        SortableDataTablesPage page = new SortableDataTablesPage(driver);
        page.open();

        Assertions.assertEquals("Smith", page.getTableCellText(1, 0, 0),
                "Фамилия в 1 строке 1 колонке должна быть Smith");
        Assertions.assertEquals("jsmith@gmail.com", page.getTableCellText(1, 0, 2),
                "Email должен быть jsmith@gmail.com");
    }
}
