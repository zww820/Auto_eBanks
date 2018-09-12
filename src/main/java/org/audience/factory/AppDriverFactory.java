package org.audience.factory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.events.api.Listener;
import org.audience.enums.Drivers;
import org.audience.listeners.AppiumWebDriverListener;
import org.audience.listeners.ContextListener;
import org.audience.listeners.EventListener;
import org.audience.utils.PropertyPlaceholderConfigurer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * author:Audience
 * date:2018/9/6
 * time:15:41
 */
@Component
public class AppDriverFactory {

    private static AppiumDriver appiumDriver=null;
    private static DesiredCapabilities capabilities=null;

    public static AppiumDriver getDriverInstance(Drivers driver) throws Exception{
        if(appiumDriver==null){
            synchronized (AppiumDriver.class){
                synchronized (DesiredCapabilities.class) {
                    capabilities = getCapabilities();
                    if(driver.equals(Drivers.ANDROID)){
                        appiumDriver = getAndroidDriver();
                    }else if (driver.equals(Drivers.CHROME)){
                        appiumDriver = getChomreDriver();
                    }
                }
            }
        }
//        appiumDriver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return appiumDriver;
    }

    private static DesiredCapabilities getCapabilities(){
        return new DesiredCapabilities();
    }

    private static AppiumDriver getAndroidDriver() throws Exception{
        capabilities.setCapability(CapabilityType.BROWSER_NAME,"");
        capabilities.setCapability("platformName",PropertyPlaceholderConfigurer.getProperty("platformName"));
        capabilities.setCapability("deviceName",PropertyPlaceholderConfigurer.getProperty("deviceName"));
        capabilities.setCapability("platformVersion",PropertyPlaceholderConfigurer.getProperty("platformVersion"));
        capabilities.setCapability("appActivity",PropertyPlaceholderConfigurer.getProperty("appActivity"));
        capabilities.setCapability("appPackage",PropertyPlaceholderConfigurer.getProperty("appPackage"));
//        capabilities.setCapability("appWaitActivity",PropertyPlaceholderConfigurer.getProperty("appWaitActivity"));
        capabilities.setCapability("autoGrantPermissions",PropertyPlaceholderConfigurer.getProperty("autoGrantPermissions"));
        capabilities.setCapability("sessionOverride",PropertyPlaceholderConfigurer.getProperty("sessionOverride"));
        /*ChromeOptions options=new ChromeOptions();
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);*/
        AndroidDriver androidDriver=new AndroidDriver(new URL(PropertyPlaceholderConfigurer.getProperty("url")),capabilities);
        List<Listener> listenerList=new ArrayList<>();
        listenerList.add(new AppiumWebDriverListener());
        listenerList.add(new ContextListener());
        listenerList.add(new EventListener());
        androidDriver = EventFiringWebDriverFactory.getEventFiringWebDriver(androidDriver,listenerList);
        return androidDriver;
    }

    private static AppiumDriver getChomreDriver() throws Exception{
        capabilities.setCapability(CapabilityType.BROWSER_NAME,BrowserType.CHROME);
        capabilities.setCapability("platformName",PropertyPlaceholderConfigurer.getProperty("platformName"));
        capabilities.setCapability("deviceName",PropertyPlaceholderConfigurer.getProperty("deviceName"));
        capabilities.setCapability("platformVersion",PropertyPlaceholderConfigurer.getProperty("platformVersion"));
        capabilities.setCapability("autoGrantPermissions",PropertyPlaceholderConfigurer.getProperty("autoGrantPermissions"));
        capabilities.setCapability("sessionOverride",PropertyPlaceholderConfigurer.getProperty("sessionOverride"));
        AndroidDriver androidDriver=new AndroidDriver<WebElement>(new URL(PropertyPlaceholderConfigurer.getProperty("url")),capabilities);
        List<Listener> listenerList=new ArrayList<>();
        listenerList.add(new AppiumWebDriverListener());
        listenerList.add(new ContextListener());
        listenerList.add(new EventListener());
        androidDriver = EventFiringWebDriverFactory.getEventFiringWebDriver(androidDriver,listenerList);
        return androidDriver;
    }
}
