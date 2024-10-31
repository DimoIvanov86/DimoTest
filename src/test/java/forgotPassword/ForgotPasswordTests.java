package forgotPassword;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.example.Base;
import org.example.screens.ForgotPassScreen;
import org.example.screens.LoginScreen;
import org.example.screens.SuccessScreen;
import org.example.utils.AppiumSetup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * This class represents the Forgot password tests
 */

public class ForgotPasswordTests {
    private LoginScreen loginScreen;
    private Base base;
    private ForgotPassScreen forgotPassScreen;
    private AppiumDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = AppiumSetup.getDriver();
        loginScreen = new LoginScreen(driver);
        base = new Base(driver);
        forgotPassScreen = new ForgotPassScreen(driver);
    }

    @Test
    public void forgotPassword() {
        String email = "test@example.com";
        loginScreen.verifyScreen(5);
        loginScreen.clickForgotPassword();
        forgotPassScreen.verifyScreen(5);
        forgotPassScreen.fillEmailField(email);
        forgotPassScreen.clickSendEmail();
        base.verifyToast("Email sent to test@example.com");
    }

    @Test
    public void wrongEmail() {
        String email = "test123@example.com";
        loginScreen.verifyScreen(5);
        loginScreen.clickForgotPassword();
        forgotPassScreen.verifyScreen(5);
        forgotPassScreen.fillEmailField(email);
        forgotPassScreen.clickSendEmail();
        base.verifyToast("Invalid email address");
    }

    @Test
    public void backButtonFunctionality() {
        String email = "test@example.com";
        loginScreen.verifyScreen(5);
        loginScreen.clickForgotPassword();
        forgotPassScreen.verifyScreen(5);
        forgotPassScreen.fillEmailField(email);
        forgotPassScreen.clickSendEmail();
        base.verifyToast("Email sent to test@example.com");
        forgotPassScreen.clickBack();
        loginScreen.verifyScreen(2);

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
