package org.example.pages.herokuapp;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SortableDataTablesPage {
    private final WebDriver driver;

    public SortableDataTablesPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу таблиц")
    public void open() {
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @Step("Получить текст ячейки в таблице {tableId}, строка {row}, колонка {col}")
    public String getTableCellText(int tableId, int row, int col) {
        // Таблица 1 имеет id='table1'
        // XPath строится от 1
        String xpath = String.format("//table[@id='table%d']/tbody/tr[%d]/td[%d]", tableId, row + 1, col + 1);
        return driver.findElement(By.xpath(xpath)).getText();
    }
}
