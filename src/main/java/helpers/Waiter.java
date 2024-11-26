package helpers;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    private WebDriverWait wait;

    public Waiter(WebDriver driver) {
        wait = new WebDriverWait(driver, 10);
    }

    public WebElement isClickableWait(By locator) {
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /*
    у ExpectedConditions нет visibilityOfElementLocated для WebElement - проваливайся в класс и смотри, там всё описано
    есть метод visibilityOf(WebElement), но для проверки кликабильности лучше использовать elementToBeClickable(WebElement),
    т.к. он уже содержит внутри себя проверку visibilityOf
     */
    public WebElement isClickableWait(WebElement element) {
        return this.wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean waitContentLoader(By locator, WebDriver driver) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        WebElement s = driver.findElement(locator);
        return s.isDisplayed();
    }

}
