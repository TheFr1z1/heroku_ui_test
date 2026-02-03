package org.example.tests.herokuapp;

import io.qameta.allure.*;
import org.example.pages.herokuapp.HoversPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Тестирование сайта HerokuApp")
@Feature("Наведение (Hovers)")
public class HoversTest extends BaseTest {

    @Test
    @DisplayName("Проверка всплывающей информации при наведении")
    @Story("При наведении на пользователя должна появляться информация и ссылка")
    @Description("Тест наводит курсор на первого пользователя, проверяет имя и переходит по ссылке (проверяя 404).")
    @Severity(SeverityLevel.NORMAL)
    public void testHovers() {
        HoversPage page = new HoversPage(driver);
        page.open();

        page.hoverUser(0);
        Assertions.assertEquals("name: user1", page.getUserName(0), "Имя пользователя 1 должно отображаться");

        page.clickProfileLink(0);
        Assertions.assertTrue(driver.getPageSource().contains("Not Found"),
                "Должна открыться страница с ошибкой (Not Found)");
    }
}
