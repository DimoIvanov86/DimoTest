package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

public class Base {

    private final AppiumDriver<MobileElement> driver;

    public Base(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }


    public static final String titleId = "com.example.dimotest:id/title";
    public MobileElement titleElement() {
        return driver.findElement(By.id(titleId));
    }

    public static final String toastXpath = ".//hierarchy/android.widget.Toast";
    public MobileElement toastXpath() {
        return driver.findElement(By.xpath(toastXpath));
    }

    public void verifyToast(String text) {
        String toast = toastXpath().getText();
        Assert.assertEquals(toast, text);
    }

    public void assertElementsDisplayed(List<String> ids) {
        for (String id : ids) {
            MobileElement element = driver.findElement(By.id(id));
            Assert.assertTrue(element.isDisplayed(), "Element with ID " + id + " is not displayed");
        }
    }
}
