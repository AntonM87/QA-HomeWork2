import helpers.Waiter;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.LaptopsAndComputers;
import pages.MainPage;

import java.util.List;

import static helpers.HomeWorkProperties.homeWorkProperties;

public class Tests extends BaseTest {


    private final By priceFrom = By.xpath("//fieldset//span[@data-auto=\"filter-range-min\"]//input");
    protected By priceTо = By.xpath("//fieldset//span[@data-auto=\"filter-range-max\"]//input");

    protected By brandASUS = By.xpath("//fieldset//h4[text()=\"Бренд\"]/../../..//span[text()=\"ASUS\"]");
    protected By brandPackardBell = By.xpath("//fieldset//h4[text()=\"Бренд\"]/../../..//span[text()=\"Lenovo\"]");

    protected By listSelectedLaptops = By.xpath("//div[@data-auto=\"SerpList\"]");
    //    protected By buttonClosePopUp = By.xpath("//button[@aria-label=\"Закрыть\" and @data-auto=\"close-popup\"]");
    protected By laptopsLoader = By.xpath("//div[@data-auto=\"SerpStatic-loader\"]");
    //    protected By spinner = By.xpath("//div[@data-auto='preloader'] | //span[contains(@data-auto, 'spinner')]");

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
//    @ParameterizedTest(name="{displayName}:{arguments}")
//    @CsvSource({"10000,priceFrom","30000,priceTо"})
    @Test
    public void enterCatalog() {

        //зашли в каталог
        MainPage mainPage = new MainPage(chromeDriver);
        mainPage.openMainPage();

        //навелись на ноутбуки
        mainPage.moveToLaptopCatalog();

        //клик по разделу с ноутбуками
        mainPage.enterLaptopCatalog();

        //вход в каталог только ноутбуков
        LaptopsAndComputers laptopsAndComputers = new LaptopsAndComputers(chromeDriver);
        laptopsAndComputers.enterLaptopsCatalog();

//        //устанавливаем минимальный прайс
        laptopsAndComputers.setValuePrice(10000, priceFrom);

//        //устанавливаем максимальный прайс и запускаем поиск
        laptopsAndComputers.setValuePrice(30000, priceTо);
        laptopsAndComputers.pressEnter(priceTо);

        //выбираем бренды
        laptopsAndComputers.setBrand(brandASUS);
        laptopsAndComputers.setBrand(brandPackardBell);

        //ждем загрузки лоадера
        laptopsAndComputers.waitContentLoader();

//        List<WebElement> list = chromeDriver.findElements(listSelectedLaptops);
//        Assertions.assertTrue(list.size() < 12, "Длинна списка ноутбуков не удовлетворительная(менее 12ти)");

    }

}
