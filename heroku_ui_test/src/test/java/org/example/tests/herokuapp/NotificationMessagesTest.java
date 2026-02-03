package org.example.tests.herokuapp;

import io.qameta.allure.*;
import org.example.pages.herokuapp.NotificationMessagesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Тестирование сайта HerokuApp")
@Feature("Уведомления")
public class NotificationMessagesTest extends BaseTest {

    @Test
    @DisplayName("Проверка динамических уведомлений")
    @Story("При нажатии на ссылку должно появляться уведомление с текстом Action")
    @Description("Тест кликает по ссылке и проверяет, что появившееся уведомление содержит ключевое слово 'Action'.")
    @Severity(SeverityLevel.NORMAL)
    public void testNotifications() {
        NotificationMessagesPage page = new NotificationMessagesPage(driver);
        page.open();

        page.clickLoadMessage();
        String message = page.getNotificationText();

        // Уведомление может содержать "Action successful" или "Action unsuccesful,
        // please try again"
        Assertions.assertTrue(message.contains("Action"), "Уведомление должно содержать текст Action");
    }
}
