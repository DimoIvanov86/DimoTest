package org.example.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.example.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

import static org.example.Base.titleId;

/**
 * This screen represents the Forgot password screen
 */

public class ForgotPassScreen {

    private final AppiumDriver<MobileElement> driver;

    public ForgotPassScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private static final String backButtonId = "com.example.dimotest:id/backButton";
    private MobileElement backButtonElement() {
        return driver.findElement(By.id(backButtonId));
    }

    public void clickBack() {
        backButtonElement().click();
    }

    private static final String emailFieldId = "com.example.dimotest:id/emailField";
    private MobileElement emailFieldElement() {
        return driver.findElement(By.id(emailFieldId));
    }

    public void fillEmailField(String email) {
        emailFieldElement().sendKeys(email);
    }

    private static final String sendButtonId = "com.example.dimotest:id/sendEmailButton";
    private MobileElement sendEmailButtonElement() {
        return driver.findElement(By.id(sendButtonId));
    }

    public void clickSendEmail() {
        sendEmailButtonElement().click();
    }

    public void verifyScreen(int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(sendButtonId)));
        Base base = new Base(driver);
        List<String> elementIds = Arrays.asList(
                emailFieldId,
                titleId,
                sendButtonId,
                backButtonId);
        base.assertElementsDisplayed(elementIds);
    }
}
