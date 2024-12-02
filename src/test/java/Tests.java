import helpers.SearchResult;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LaptopsAndComputers;
import pages.MainPage;

import java.util.List;

import static helpers.HomeWorkProperties.homeWorkProperties;

public class Tests extends BaseTest {

    String[] brandArr = {"ASUS"};

    private final By priceFrom = By.xpath("//fieldset//span[@data-auto=\"filter-range-min\"]//input");
    protected By priceTо = By.xpath("//fieldset//span[@data-auto=\"filter-range-max\"]//input");

    protected By brandASUS = By.xpath("//fieldset//h4[text()=\"Бренд\"]/../../..//span[text()=\"ASUS\"]");
    protected By brandPackardBell = By.xpath("//fieldset//h4[text()=\"Бренд\"]/../../..//span[text()=\"Lenovo\"]");

    protected By listSelectedLaptops = By.xpath("//div[@data-auto=\"SerpList\"]");
    protected By laptopsLoader = By.xpath("//div[@data-auto=\"SerpStatic-loader\"]");
    //    protected By spinner = By.xpath("//div[@data-auto='preloader'] | //span[contains(@data-auto, 'spinner')]");
//    protected By productLinks = By.xpath("//div[@data-auto-themename='listDetailed'//div[@data-auto='snippet-title']]");
    protected By productLinks = By.xpath("//span[@data-auto='snippet-title']");

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
        mainPage.enterCatalog();

        //навелись на ноутбуки
        mainPage.moveToLaptopCatalog();

        //клик по разделу с ноутбуками
        mainPage.enterLaptopCatalog();

        //вход в каталог только ноутбуков
        LaptopsAndComputers laptopsAndComputers = new LaptopsAndComputers(chromeDriver);
        laptopsAndComputers.enterLaptopsCatalog();

        //устанавливаем минимальный прайс
        laptopsAndComputers.setValuePrice(10000, priceFrom);

        //устанавливаем максимальный прайс и запускаем поиск
        laptopsAndComputers.setValuePrice(30000, priceTо);
        laptopsAndComputers.pressEnter(priceTо);

        //выбираем бренды
        laptopsAndComputers.setBrand(brandASUS);
//      laptopsAndComputers.setBrand(brandPackardBell);

        //ждем загрузки контента(когда исчезнет лоадер)
        laptopsAndComputers.waitContentLoader();

        List<WebElement> list = chromeDriver.findElements(productLinks);

        //проверить длину списка
        laptopsAndComputers.listSizeValidate(list);

        //проверить лист на содержимое
//        laptopsAndComputers.listContentValidate(list, brandArr);

        // передать первый элемент из LaptopsAndComputers в MainPage
        mainPage.setFirstLaptopElement(laptopsAndComputers.getFirstElement(list));

        //переход на главную страницу
        mainPage.openMainPage();

        //ищем первый элемент
        mainPage.searchFirstLaptopElement();

        //проверяем результат поиска и искомое значение
        SearchResult result = new SearchResult(chromeDriver,mainPage.getFirstElement());
        result.validateFirstElement();
        System.out.println(mainPage.getFirstElement());
    }

}
