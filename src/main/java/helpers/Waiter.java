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

    public boolean waitContentLoader(By locator, WebDriver driver) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        WebElement s = driver.findElement(locator);
        return s.isDisplayed();
    }

}
