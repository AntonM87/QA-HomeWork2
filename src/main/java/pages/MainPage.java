package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static helpers.HomeWorkProperties.homeWorkProperties;

public class MainPage extends BasePage{

    @FindBy(xpath = "//div[@id=\"/content/header/header/catalogEntrypoint\"]//div[@data-zone-name=\"catalog\"]")
    private WebElement enterCatalog;

    @FindBy(xpath = "//ul[@role=\"tablist\"]//li//a//span[text()=\"Ноутбуки и компьютеры\"]")
    private WebElement computersLaptops;

    @FindBy(xpath = "//div[@data-apiary-widget-id=\"/content/page/fancyPage/cms/0/108133154-CatalogHeader\"]//h1[text()=\"Ноутбуки и компьютеры\"]")
    private WebElement computersLaptopsHeader;

    public MainPage(WebDriver chromeDriver) {
        super(chromeDriver);
    }

    public void openMainPage(){
        chromeDriver.get(homeWorkProperties.mainUrl());
        waiter.isClickableWait(enterCatalog);
        enterCatalog.click();
    }

    public void moveToLaptopCatalog(){
        waiter.isClickableWait(computersLaptops);
        actions.moveToElement(computersLaptops);
        computersLaptops.click();
    }

    public void enterLaptopCatalog(){
        String header;
        waiter.isClickableWait(computersLaptopsHeader);
        header = computersLaptopsHeader.getText();
        Assertions.assertEquals("Ноутбуки и компьютеры", header, "Ошибка, раздел не -> " + header);
    }
}
