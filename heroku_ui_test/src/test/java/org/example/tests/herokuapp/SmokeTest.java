package org.example.tests.herokuapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void testSiteOpens() {
        driver.get("https://the-internet.herokuapp.com/");

        String title = driver.getTitle();
        Assertions.assertTrue(title.contains("The Internet"), "Заголовок страницы должен совпадать");
        Assertions.assertTrue(driver.getCurrentUrl().contains("the-internet.herokuapp.com"),
                "URL должен быть корректным");
    }
}
