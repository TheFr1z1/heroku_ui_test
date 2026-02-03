package org.example.pages.herokuapp;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {
    private final WebDriver driver;
    private final By avatars = By.className("figure");

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу с наведением (hovers)")
    public void open() {
        driver.get("https://the-internet.herokuapp.com/hovers");
    }

    @Step("Навести курсор на аватар пользователя с индексом {index}")
    public void hoverUser(int index) {
        WebElement avatar = driver.findElements(avatars).get(index);
        new Actions(driver).moveToElement(avatar).perform();
    }

    @Step("Получить имя пользователя с индексом {index}")
    public String getUserName(int index) {
        WebElement avatar = driver.findElements(avatars).get(index);
        return avatar.findElement(By.tagName("h5")).getText();
    }

    @Step("Нажать на ссылку профиля пользователя с индексом {index}")
    public void clickProfileLink(int index) {
        WebElement avatar = driver.findElements(avatars).get(index);
        avatar.findElement(By.tagName("a")).click();
    }
}
