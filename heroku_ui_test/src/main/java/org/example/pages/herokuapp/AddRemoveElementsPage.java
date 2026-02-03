package org.example.pages.herokuapp;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AddRemoveElementsPage {
    private final WebDriver driver;
    private final By addElementButton = By.xpath("//button[text()='Add Element']");
    private final By deleteButtons = By.xpath("//button[text()='Delete']");

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу добавления/удаления элементов")
    public void open() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Step("Добавить новый элемент")
    public void addElement() {
        driver.findElement(addElementButton).click();
    }

    @Step("Удалить элемент")
    public void deleteElement() {
        driver.findElement(deleteButtons).click();
    }

    @Step("Получить количество кнопок удаления")
    public int getDeleteButtonsCount() {
        List<WebElement> buttons = driver.findElements(deleteButtons);
        return buttons.size();
    }
}
