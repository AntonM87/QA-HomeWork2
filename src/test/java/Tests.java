import helpers.Waiter;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.MainPage;

import java.util.List;

import static helpers.HomeWorkProperties.homeWorkProperties;

public class Tests extends BaseTest {


    protected By onlyLaptops = By.xpath("//a[@href=\"/catalog--noutbuki/26895412/list?hid=91013\"]");
    protected By priceFrom = By.xpath("//fieldset//span[@data-auto=\"filter-range-min\"]//input");
    protected By priceTо = By.xpath("//fieldset//span[@data-auto=\"filter-range-max\"]//input");
    protected By brandCHUWI = By.xpath("//fieldset//h4[text()=\"Бренд\"]/../../..//span[text()=\"ASUS\"]");
    protected By brandPackardBell = By.xpath("//fieldset//h4[text()=\"Бренд\"]/../../..//span[text()=\"Lenovo\"]");
    protected By listSelectedLaptops = By.xpath("//div[@data-auto=\"SerpList\"]");
    //    protected By buttonClosePopUp = By.xpath("//button[@aria-label=\"Закрыть\" and @data-auto=\"close-popup\"]");
    protected By laptopsLoader = By.xpath("//div[@data-auto=\"SerpStatic-loader\"]");
//    protected By spinner = By.xpath("//div[@data-auto='preloader'] | //span[contains(@data-auto, 'spinner')]");
    protected By spinner = By.xpath("//div[@data-auto='preloader'] | //span[contains(@data-auto='spinner')]");

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
    public void enterCatalog() {

        WebElement priceFromField;

        //зашли в каталог
        MainPage mainPage = new MainPage(chromeDriver);
        mainPage.openMainPage();

        //навелись на ноутбуки
        mainPage.moveToLaptopCatalog();

        //клик по разделу с ноутбуками
        mainPage.enterLaptopCatalog();

        //повторный выбор ноутбуков
//        waiter.isClickableWait(onlyLaptops);
//        BaseTest.chromeDriver.findElement(onlyLaptops).click();
//
//        //устанавливаем минимальный прайс
//        priceFromField = BaseTest.chromeDriver.findElement(priceFrom);
//        priceFromField.click();
//        priceFromField.sendKeys("10000");
//
//        //устанавливаем максимальный прайс и запускаем поиск
//        priceFromField = BaseTest.chromeDriver.findElement(priceTо);
//        priceFromField.click();
//        priceFromField.sendKeys("30000" + Keys.ENTER);
//
//        //выбираем бренды
//        chromeDriver.findElement(brandPackardBell).click();
//        chromeDriver.findElement(brandCHUWI).click();
//
//        //ждем загрузки лоадера
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
//
//        List<WebElement> list = chromeDriver.findElements(listSelectedLaptops);
//        Assertions.assertTrue(list.size() < 12, "Длинна списка ноутбуков не удовлетворительная(менее 12ти)");

    }

}
