package login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.example.Base;
import org.example.screens.LoginScreen;
import org.example.screens.SuccessScreen;
import org.example.utils.AppiumSetup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * This class represents the Login tests
 */

public class LoginTests {
    private LoginScreen loginScreen;
    private Base base;
    private SuccessScreen successScreen;
    private AppiumDriver<MobileElement> driver;

    String invalidTitleOrMail = "Invalid email or password";

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = AppiumSetup.getDriver();
        loginScreen = new LoginScreen(driver);
        base = new Base(driver);
        successScreen = new SuccessScreen(driver);
    }

    @Test
    public void successfulLogin() {
        String email = "test@example.com";
        String password = "password123";
        loginScreen.verifyScreen(5);
        loginScreen.enterEmail(email);
        loginScreen.enterPassword(password);
        loginScreen.clickLogin();
        successScreen.verifyScreen(2);
        successScreen.verifySuccessText("Dimo, you have successfully logged in");
    }

    @Test
    public void wrongPassword() {
        String email = "test@example.com";
        String password = "password1234";
        loginScreen.verifyScreen(5);
        loginScreen.enterEmail(email);
        loginScreen.enterPassword(password);
        loginScreen.clickLogin();
        base.verifyToast(invalidTitleOrMail);
    }

    @Test
    public void wrongEmail() {
        String email = "test1@example.com";
        String password = "password1234";
        loginScreen.verifyScreen(5);
        loginScreen.enterEmail(email);
        loginScreen.enterPassword(password);
        loginScreen.clickLogin();
        base.verifyToast(invalidTitleOrMail);
    }

    @Test
    public void emptyFields() {
        loginScreen.verifyScreen(5);
        loginScreen.clickLogin();
        base.verifyToast(invalidTitleOrMail);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
