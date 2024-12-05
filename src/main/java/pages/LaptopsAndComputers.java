package pages;

import helpers.Assertions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LaptopsAndComputers extends BasePage {

    private final By onlyLaptops = By.xpath("//a[@href=\"/catalog--noutbuki/26895412/list?hid=91013\"]");
    private final By spinner = By.xpath("//div[@data-auto='preloader'] | //span[contains(@data-auto,'spinner')]");
    private final By priceFrom = By.xpath("//fieldset//span[@data-auto=\"filter-range-min\"]//input");
    private final By priceTо = By.xpath("//fieldset//span[@data-auto=\"filter-range-max\"]//input");
    private final By brandASUS = By.xpath("//fieldset//h4[text()=\"Бренд\"]/../../..//span[text()=\"ASUS\"]");
    private final By brandPackardBell = By.xpath("//fieldset//h4[text()=\"Бренд\"]/../../..//span[text()=\"Lenovo\"]");
    private final By productLinks = By.xpath("//span[@data-auto='snippet-title']");
    private List<WebElement> productList;

    private List<Map<String, String>> collection = new ArrayList<>();

    @Step("Входим в каталог с ноутами")
    public void enterLaptopsCatalog() {
        waiter.isClickableWait(onlyLaptops);
        chromeDriver.findElement(onlyLaptops).click();
    }

    @Step("Устанавливаем значение {value}")
    public void setMinPrice(int value) {
        WebElement priceFromField = chromeDriver.findElement(priceFrom);
        priceFromField.click();
        priceFromField.sendKeys(String.valueOf(value));
    }
    @Step("Устанавливаем значение {value}")
    public void setMaxPrice(int value) {
        WebElement priceFromField = chromeDriver.findElement(priceTо);
        priceFromField.click();
        priceFromField.sendKeys(String.valueOf(value));
    }

    @Step("Нажимаем ENTER")
    public void pressEnter() {
        chromeDriver.findElement(priceTо).sendKeys(Keys.ENTER);
    }

    @Step("Выбор бренда {locator}")
    public void setBrandASUS() {
        chromeDriver.findElement(brandASUS).click();
    }
    //xpath спинера указан не верно ибо в списке по-прежнему только 1 элемент из 12, ублюдский яндекс маркет
    @Step("Ожидание загрузки контента в контейнер")
    public void waitContentLoader() {
        waiter.isClickableWait(spinner);
    }

    @Step("Проверка размера контейнера(>12)")
    public void listSizeValidate() {
        Assertions.AssertTrue(productList.size() >= 12, "Длинна списка ноутбуков не удовлетворительная(менее 12ти)");
        System.out.println("Длинна списка ноутбуков : " + productList.size());
    }

    @Step("Проверяем что товар соответсвует фильтру")
    public void listContentValidate(List<WebElement> list, String[] strings) {

        for (WebElement element : list) {
            System.out.println(element.findElement(By.xpath("//a")).getText() + "/n");
//            for (int j = 0; j < strings.length; j++) {
//                Assertions.AssertFalse(element.getText().contains(strings[0]) || element.getText().contains(strings[1]), "Товар отсутствует");
//                Assertions.AssertFalse(element.getText().contains(strings[0]), "Товар отсутствует");
//            }
        }
    }
    @Step("Передаем первый элемент из LaptopsAndComputers в MainPage")
    public String getFirstElement(){
        return productList.get(0).getText();
    }
    @Step("Получаем список товаров")
    public void getProductList(){
         productList = chromeDriver.findElements(productLinks);
    }
}
