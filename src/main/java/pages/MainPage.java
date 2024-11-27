package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static helpers.HomeWorkProperties.homeWorkProperties;

public class MainPage extends BasePage{

//    @FindBy(how = How.XPATH, using = "//div[@id=\"/content/header/header/catalogEntrypoint\"]//div[@data-zone-name=\"catalog\"]")
//    private WebElement enterCatalog;
//
//    @FindBy(how = How.XPATH, using = "//ul[@role=\"tablist\"]//li//a//span[text()=\"Ноутбуки и компьютеры\"]")
//    private WebElement computersLaptops;
//
//    @FindBy(how = How.XPATH, using = "//div[@data-apiary-widget-id=\"/content/page/fancyPage/cms/0/108133154-CatalogHeader\"]//h1[text()=\"Ноутбуки и компьютеры\"]")
//    private WebElement computersLaptopsHeader;

    private final By enterCatalog = By.xpath("//div[@id='/content/header/header/catalogEntrypoint']//div[@data-zone-name='catalog']");
    private final By computersLaptops = By.xpath("//ul[@role=\"tablist\"]//li//a//span[text()=\"Ноутбуки и компьютеры\"]");
    private final By computersLaptopsHeader = By.xpath("//div[@data-apiary-widget-id=\"/content/page/fancyPage/cms/0/108133154-CatalogHeader\"]//h1[text()=\"Ноутбуки и компьютеры\"]");

    public MainPage(WebDriver chromeDriver) {
        super(chromeDriver);
    }

    @Step("Открываем главную страницу яндекс маркета")
    public void openMainPage(){
        chromeDriver.get(homeWorkProperties.mainUrl());
        waiter.isClickableWait(enterCatalog);
        chromeDriver.findElement(enterCatalog).click();
    }
    @Step("Наводимся на каталог")
    public void moveToLaptopCatalog(){
        waiter.isClickableWait(computersLaptops);
        actions.moveToElement(chromeDriver.findElement(computersLaptops));
        chromeDriver.findElement(computersLaptops).click();
    }
    @Step("Входим в каталог с компьютерами")
    public void enterLaptopCatalog(){
        waiter.isClickableWait(computersLaptopsHeader);
        String header = chromeDriver.findElement(computersLaptopsHeader).getText();
        helpers.Assertions.AssertEquals("Ноутбуки и компьютеры", header, "Ошибка, раздел не -> " + header);
    }
}
