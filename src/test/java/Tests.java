import helpers.Waiter;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.HomeWorkProperties.homeWorkProperties;

public class Tests extends BaseTest {

//    private Waiter wait = new Waiter(chromeDriver);

    private WebDriverWait wait = new WebDriverWait(chromeDriver,10);

    protected By enterCatalog = By.xpath("//div[@id=\"/content/header/header/catalogEntrypoint\"]//div[@data-zone-name=\"catalog\"]");
    protected By computersLaptops = By.xpath("//ul[@role=\"tablist\"]//li//a//span[text()=\"Ноутбуки и компьютеры\"]");
    protected By computersLaptopsHeader = By.xpath("//div[@data-apiary-widget-id=\"/content/page/fancyPage/cms/0/108133154-CatalogHeader\"]//h1[text()=\"Ноутбуки и компьютеры\"]");
    protected By onlyLaptops = By.xpath("//a[@href=\"/catalog--noutbuki/26895412/list?hid=91013\"]");
    protected By priceFrom = By.xpath("//fieldset//span[@data-auto=\"filter-range-min\"]//input");
    protected By priceTо = By.xpath("//fieldset//span[@data-auto=\"filter-range-max\"]//input");
    protected By brandLenovo = By.xpath("//fieldset//h4[text()=\"Бренд\"]/../../..//span[text()=\"Lenovo\"]");
    protected By brandHP = By.xpath("//fieldset//h4[text()=\"Бренд\"]/../../..//span[text()=\"HP\"]");
    protected By listSelectedLaptops = By.xpath("//div[@id=\"/marketfrontSerpLayout\"]//div//div[@data-apiary-widget-name=\"@marketfront/SerpEntity\"]//a");
    protected By buttonClosePopUp = By.xpath("//button[@aria-label=\"Закрыть\" and @data-auto=\"close-popup\"]");
    protected By listWrapperSelectedLaptops = By.xpath("//div[@data-auto=\"SerpList\"]");

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

        String header;
        WebElement priceFromField;

        chromeDriver.get(homeWorkProperties.mainUrl());
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterCatalog));
//        BaseTest.chromeDriver.findElement(enterCatalog).click();

//        Waiter.isClickableWait(computersLaptops);
//        actions.moveToElement(BaseTest.chromeDriver.findElement(computersLaptops));
//        BaseTest.chromeDriver.findElement(computersLaptops).click();
//
//        Waiter.isClickableWait(computersLaptopsHeader);
//        header = BaseTest.chromeDriver.findElement(computersLaptopsHeader).getText();
//        Assertions.assertEquals("Ноутбуки и компьютеры", header, "Ошибка, раздел не -> " + header);
//
//        Waiter.isClickableWait(onlyLaptops);
//        BaseTest.chromeDriver.findElement(onlyLaptops).click();
//
//        //следующая страница
//        priceFromField = BaseTest.chromeDriver.findElement(priceFrom);
//        priceFromField.click();
//        priceFromField.sendKeys("10000");
//
//        priceFromField = BaseTest.chromeDriver.findElement(priceTо);
//        priceFromField.click();
//        priceFromField.sendKeys("30000" + Keys.ENTER);
//
////        if (chromeDriver.findElement(buttonClosePopUp).isEnabled()) chromeDriver.findElement(buttonClosePopUp).click();
//
//        chromeDriver.findElement(brandLenovo).click();
//        chromeDriver.findElement(brandHP).click();
//
//        Waiter.isClickableWait(listWrapperSelectedLaptops);
//        List<WebElement> list = chromeDriver.findElements(listSelectedLaptops);
//
//        Assertions.assertTrue(list.size() < 12, "Длинна списка ноутбуков не удовлетворительная(менее 12ти)");
    }

}
