package org.example.pages.herokuapp;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotificationMessagesPage {
    private final WebDriver driver;
    private final By loadMessageLink = By.linkText("Click here");
    private final By flashMessage = By.id("flash");

    public NotificationMessagesPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу уведомлений")
    public void open() {
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
    }

    @Step("Нажать для загрузки нового уведомления")
    public void clickLoadMessage() {
        driver.findElement(loadMessageLink).click();
    }

    @Step("Получить текст текущего уведомления")
    public String getNotificationText() {
        return driver.findElement(flashMessage).getText();
    }
}
