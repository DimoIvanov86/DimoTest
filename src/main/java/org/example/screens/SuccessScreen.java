package org.example.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.example.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

import static org.example.Base.titleId;


/**
 * This screen represents the Success screen
 */
public class SuccessScreen {

    private final AppiumDriver<MobileElement> driver;

    public SuccessScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private static final String successTextId = "com.example.dimotest:id/successMessage";
    public MobileElement successTextElement() {
        return driver.findElement(By.id(successTextId));
    }

    public void verifySuccessText(String text) {
        String success = successTextElement().getText();
        Assert.assertEquals(success, text);
    }

    private static final String logoutButtonId = "com.example.dimotest:id/logoutButton";
    private MobileElement logoutButtonId() {
        return driver.findElement(By.id(logoutButtonId));
    }

    public void clickLogout() {
        logoutButtonId().click();
    }

    public void verifyScreen(int timeoutInSeconds) {
        Base base = new Base(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(successTextId)));
        List<String> elementIds = Arrays.asList(
                successTextId,
                titleId,
                logoutButtonId);
        base.assertElementsDisplayed(elementIds);
    }
}
