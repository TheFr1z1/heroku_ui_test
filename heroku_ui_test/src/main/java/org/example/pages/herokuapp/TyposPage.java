package org.example.pages.herokuapp;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TyposPage {
    private final WebDriver driver;
    private final By paragraph2 = By.xpath("//div[@class='example']/p[2]");

    public TyposPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу опечаток")
    public void open() {
        driver.get("https://the-internet.herokuapp.com/typos");
    }

    @Step("Получить текст второго параграфа")
    public String getParagraphText() {
        return driver.findElement(paragraph2).getText();
    }
}
