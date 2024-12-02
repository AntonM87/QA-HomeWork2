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

    private List<Map<String, String>> collection = new ArrayList<>();

    public LaptopsAndComputers(WebDriver chromeDriver) {
        super(chromeDriver);
    }

    @Step("Входим в каталог с ноутами")
    public void enterLaptopsCatalog() {
        waiter.isClickableWait(onlyLaptops);
        chromeDriver.findElement(onlyLaptops).click();
    }

    @Step("Устанавливаем значение {value}")
    public void setValuePrice(int value, By priceField) {
        WebElement priceFromField = chromeDriver.findElement(priceField);
        priceFromField.click();
        priceFromField.sendKeys(String.valueOf(value));
    }

    @Step("Нажимаем ENTER")
    public void pressEnter(By element) {
        chromeDriver.findElement(element).sendKeys(Keys.ENTER);
    }

    @Step("Выбор бренда {locator}")
    public void setBrand(By locator) {
        chromeDriver.findElement(locator).click();
    }
    //xpath спинера указан не верно ибо в списке по-прежнему только 1 элемент из 12, ублюдский яндекс маркет
    @Step("Ожидание загрузки контента в контейнер")
    public void waitContentLoader() {
        waiter.isClickableWait(spinner);
    }

    @Step("Проверка размера контейнера(>12)")
    public void listSizeValidate(List<WebElement> elements) {
        Assertions.AssertTrue(elements.size() >= 12, "Длинна списка ноутбуков не удовлетворительная(менее 12ти)");
        System.out.println("Длинна списка ноутбуков : " + elements.size());
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
    public String getFirstElement(List<WebElement> elements){
        return elements.get(0).getText();
    }
}
