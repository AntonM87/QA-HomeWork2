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

//    String[] brandArr = {"ASUS"};

//    protected By listSelectedLaptops = By.xpath("//div[@data-auto=\"SerpList\"]");
//    protected By laptopsLoader = By.xpath("//div[@data-auto=\"SerpStatic-loader\"]");
//    protected By spinner = By.xpath("//div[@data-auto='preloader'] | //span[contains(@data-auto, 'spinner')]");
//    protected By productLinks = By.xpath("//div[@data-auto-themename='listDetailed'//div[@data-auto='snippet-title']]");

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
        MainPage mainPage = new MainPage();
        mainPage.openMainPage();
        mainPage.enterCatalog();

        //навелись на ноутбуки
        mainPage.moveToLaptopCatalog();

        //клик по разделу с ноутбуками
        mainPage.enterLaptopCatalog();

        //вход в каталог только ноутбуков
        LaptopsAndComputers laptopsAndComputers = new LaptopsAndComputers();
        laptopsAndComputers.enterLaptopsCatalog();

        //устанавливаем минимальный прайс
        laptopsAndComputers.setMinPrice(10000);

        //устанавливаем максимальный прайс и запускаем поиск
        laptopsAndComputers.setMaxPrice(30000);
        laptopsAndComputers.pressEnter();

        //выбираем бренды
        laptopsAndComputers.setBrandASUS();
//      laptopsAndComputers.setBrand(brandPackardBell);

        //ждем загрузки контента(когда исчезнет лоадер)
        laptopsAndComputers.waitContentLoader();

        //получаем список товаров
        laptopsAndComputers.getProductList();

        //проверить длину списка
        laptopsAndComputers.listSizeValidate();

        //проверить лист на содержимое
//        laptopsAndComputers.listContentValidate(list, brandArr);

        // передать первый элемент из LaptopsAndComputers в MainPage
        mainPage.setFirstLaptopElement(laptopsAndComputers.getFirstElement());

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
