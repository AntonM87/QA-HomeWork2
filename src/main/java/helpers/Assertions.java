package helpers;

import io.qameta.allure.Step;

public class Assertions {
    @Step("Проверяем что нет ошибки: {message}")
    public static void AssertTrue(boolean expression,String message) {
        org.junit.jupiter.api.Assertions.assertTrue(expression,message);

    }
    @Step("Проверяем что значения совпадают: {str} - {expression}")
    public static void AssertEquals(String str, String expression,String message) {
        org.junit.jupiter.api.Assertions.assertEquals(str,expression,message);
    }
    @Step("Проверяем что зачения не совпадают: {str} - {expression}")
    public static void AssertFalse(boolean expression,String message) {
        org.junit.jupiter.api.Assertions.assertTrue(expression,message);
    }
}
