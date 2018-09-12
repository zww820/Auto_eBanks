package org.audience.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * author:Audience
 * date:2018/9/6
 * time:9:15
 */
@Component
public class SwipeScreen {

    static Duration duration = Duration.ofSeconds(1);

    public static void swipeUp(AppiumDriver driver,int num) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction action1 = new TouchAction(driver);
        for (int i=0;i<num;i++) {
            action1.press(PointOption.point(width / 2, height * 4 / 5)).
                    waitAction(WaitOptions.waitOptions(duration)).moveTo(PointOption.point(width / 2, height / 4)).release();
            action1.perform();
        }
    }

    public static void swipeDown(AppiumDriver driver,int num)// scroll down to refresh
    {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction action1 = new TouchAction(driver);
        for (int i=0;i<num;i++) {
            action1.press(PointOption.point(width / 2, height / 4)).
                    waitAction(WaitOptions.waitOptions(duration)).moveTo(PointOption.point(width / 2, height * 3 / 4)).release();
            action1.perform();
        }
    }

    public static void swipeLeft(AppiumDriver driver,int num) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction action1 = new TouchAction(driver);
        for (int i=0;i<num;i++) {
            action1.press(PointOption.point(width - 10, height / 2)).
                    waitAction(WaitOptions.waitOptions(duration)).moveTo(PointOption.point(width / 4, height / 2)).release();
            action1.perform();
        }
    }

    public static void swipeRight(AppiumDriver driver,int num) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction action1 = new TouchAction(driver);
        for (int i=0;i<num;i++) {
            action1.press(PointOption.point(10, height / 2)).
                    waitAction(WaitOptions.waitOptions(duration)).moveTo(PointOption.point(width * 3 / 4 + 10, height / 2)).release();
            action1.perform();
        }

    }
}