package pages;

import helpers.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LaptopsAndComputers extends BasePage {

    private final By onlyLaptops = By.xpath("//a[@href=\"/catalog--noutbuki/26895412/list?hid=91013\"]");
    private final By spinner = By.xpath("//div[@data-auto='preloader'] | //span[contains(@data-auto,'spinner')]");

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

    public void waitContentLoader(){
        waiter.isClickableWait(spinner);
    }
}
