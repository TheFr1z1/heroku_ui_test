package org.example.pages.herokuapp;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    private final WebDriver driver;
    private final By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу выпадающего списка")
    public void open() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Step("Выбрать опцию с текстом '{text}'")
    public void selectByText(String text) {
        Select select = new Select(driver.findElement(dropdown));
        select.selectByVisibleText(text);
    }

    @Step("Получить текст первой выбранной опции")
    public String getFirstSelectedOption() {
        Select select = new Select(driver.findElement(dropdown));
        return select.getFirstSelectedOption().getText();
    }
}
