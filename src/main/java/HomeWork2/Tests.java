package HomeWork2;

import Helpers.Properties;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Helpers.Properties.*;

public class Tests extends BaseTest {
    @Feature("Проверка property")
    @DisplayName("Проверка работа property")
    @Test
    public void testProperty() {
        System.out.println(homeWorkProperties.mainUrl());
    }

    @Feature("Проверка домена")
    @DisplayName("Проверка домена на существование")
    @Test
    public void domenTest() {
        chromeDriver.get(homeWorkProperties.mainUrl());
        String title = chromeDriver.getTitle();
        System.out.println(title);
        Assertions.assertEquals("Интернет-магазин Яндекс Маркет — покупки с быстрой доставкой", title, "Вы ошиблись адресом, это не " + title);
    }
}
