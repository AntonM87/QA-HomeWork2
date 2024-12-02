package helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class SearchResult extends BasePage {

    private String str;
    private final By firstElementAfterSearch = By.xpath("//span[@role='link' and @tabindex='0']");

    public SearchResult(WebDriver chromeDriver, String origin){
        super(chromeDriver);
        str = origin;
    }
    @Step("Проверяем результаты поиска с первым эелементом")
    public void validateFirstElement(){
        Assertions.AssertTrue(chromeDriver.findElement(firstElementAfterSearch).getText().contains(str), "Первый элемент не соответствует поиску");
    }
}
