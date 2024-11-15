package HomeWork2;

import Helpers.Waiter;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Helpers.Properties.*;

public class Tests extends BaseTest {

    protected By enterCatalog = By.xpath("//div[@id=\"/content/header/header/catalogEntrypoint\"]//div[@data-zone-name=\"catalog\"]");

    @Feature("Проверка property")
    @DisplayName("Проверка работа property")
    @Test
    public void testProperty() {
        System.out.println();
        System.out.println(homeWorkProperties.mainUrl());
    }

    @Feature("Проверка домена")
    @DisplayName("Проверка домена на существование")
    @Test
    public void domenTest() {
        chromeDriver.get(homeWorkProperties.mainUrl());
        String title = chromeDriver.getTitle();
        Assertions.assertEquals("Интернет-магазин Яндекс Маркет — покупки с быстрой доставкой", title, "Вы ошиблись адресом, это не " + title);
    }

    @Feature("Переход в каталог")
    @DisplayName("Поиск элекмента интерфейса для входа в католог")
    @Test
    public void enterCatalog(){
        chromeDriver.get(homeWorkProperties.mainUrl());
        Waiter.isClickableWait(enterCatalog);
        chromeDriver.findElement(enterCatalog).click();
    }

}
