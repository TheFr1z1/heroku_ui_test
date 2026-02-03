package org.example.pages.herokuapp;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CheckboxesPage {
    private final WebDriver driver;
    private final By checkboxes = By.cssSelector("[type=checkbox]");

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу чекбоксов")
    public void open() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    public List<WebElement> getCheckboxes() {
        return driver.findElements(checkboxes);
    }

    @Step("Проверить, отмечен ли чекбокс с индексом {index}")
    public boolean isChecked(int index) {
        return getCheckboxes().get(index).isSelected();
    }

    @Step("Нажать на чекбокс с индексом {index}")
    public void clickCheckbox(int index) {
        getCheckboxes().get(index).click();
    }
}
