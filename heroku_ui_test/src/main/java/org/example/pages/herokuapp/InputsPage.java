package org.example.pages.herokuapp;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class InputsPage {
    private final WebDriver driver;
    private final By inputField = By.tagName("input");

    public InputsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу полей ввода")
    public void open() {
        driver.get("https://the-internet.herokuapp.com/inputs");
    }

    @Step("Ввести текст '{text}' в поле")
    public void enterText(String text) {
        driver.findElement(inputField).clear();
        driver.findElement(inputField).sendKeys(text);
    }

    @Step("Получить текущее значение поля ввода")
    public String getInputValue() {
        return driver.findElement(inputField).getAttribute("value");
    }

    @Step("Нажать стрелку вверх")
    public void pressArrowUp() {
        driver.findElement(inputField).sendKeys(Keys.ARROW_UP);
    }

    @Step("Нажать стрелку вниз")
    public void pressArrowDown() {
        driver.findElement(inputField).sendKeys(Keys.ARROW_DOWN);
    }
}
