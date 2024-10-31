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
 * This screen represents the Login screen
 */
public class LoginScreen {
    private final AppiumDriver<MobileElement> driver;

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private static final String emailFieldId = "com.example.dimotest:id/editTextEmail";

    private MobileElement emailFieldElement() {
        return driver.findElement(By.id(emailFieldId));
    }

    public void enterEmail(String email) {
        emailFieldElement().sendKeys(email);
    }

    private static final String passwordFieldId = "com.example.dimotest:id/editTextPassword";

    private MobileElement passwordFieldElement() {
        return driver.findElement(By.id(passwordFieldId));
    }

    public void enterPassword(String password) {
        passwordFieldElement().sendKeys(password);
    }

    private static final String loginButtonId = "com.example.dimotest:id/buttonLogin";

    private MobileElement loginButtonElement() {
        return driver.findElement(By.id(loginButtonId));
    }

    public void clickLogin() {
        loginButtonElement().click();
    }

    private static final String forgotPassButtonId = "com.example.dimotest:id/buttonForgotPassword";

    private MobileElement forgotPassButtonElement() {
        return driver.findElement(By.id(forgotPassButtonId));
    }

    public void clickForgotPassword() {
        forgotPassButtonElement().click();
    }

    public void verifyScreen(int timeoutInSeconds) {
        Base base = new Base(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginButtonId)));
        List<String> elementIds = Arrays.asList(
                loginButtonId,
                titleId,
                passwordFieldId,
                emailFieldId,
                forgotPassButtonId);
        base.assertElementsDisplayed(elementIds);
    }
}
