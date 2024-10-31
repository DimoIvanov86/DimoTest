package org.example.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumSetup {
    private static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> getDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Dimo"); //Update with Device Name
        capabilities.setCapability("udid", "RF8NB064K9L"); //Update with UDID of the phone in use
        capabilities.setCapability("appPackage", "com.example.dimotest");
        capabilities.setCapability("appActivity", "com.example.dimotest.MainActivity");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("automationName", "UiAutomator2");

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        return driver;
    }
}
