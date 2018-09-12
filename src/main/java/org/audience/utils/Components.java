package org.audience.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.audience.factory.AppDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * author:Audience
 * date:2018/9/7
 * time:9:36
 */
@Component
public class Components {
    static Logger logger=Logger.getLogger(Components.class);

    private static int MAX_TIMEOUT_SECONDS=30;

    public static boolean isExsitAPPElement(MobileElement mobileElement){
        try{
            if(null == mobileElement){
                return false;
            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return true;
    }

    public static boolean isExsitWEBElement(WebElement webElement){
        try{
            if(null == webElement){
                return false;
            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return true;
    }

    public static boolean currentWebtitle(AppiumDriver appiumDriver, String title){
        try {
            if(StringUtils.isEmpty(appiumDriver.getTitle())){
                logger.info("title:"+appiumDriver.getTitle());
                return false;
            }else if(!appiumDriver.getTitle().equals(title)){
                logger.info("title:"+appiumDriver.getTitle());
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public static void switchToLastWebView(MobileDriver mobileDriver) throws Exception {
        Set<String> contextNames= mobileDriver.getContextHandles();
        List<String> webViewContextNames = contextNames
                .stream()
                .filter(contextName -> contextName.contains("WEBVIEW_"))
                .collect(Collectors.toList());
        String currentContextView = "";
        if(webViewContextNames.size()>0){
            currentContextView = (String) webViewContextNames.toArray()[webViewContextNames.size()-1];
            mobileDriver.context(currentContextView);
        }
        logger.info("All contexts:"+contextNames);
        logger.info("All webview contexts:"+webViewContextNames);
        logger.info("current context:"+mobileDriver.getContext());
    }

    public static void switchToSpecificWebView(MobileDriver mobileDriver,By selector) throws Exception {
        switchToLastWebView(mobileDriver);
        long begin=System.currentTimeMillis();
        do{
            try{
                List<WebElement> elements=mobileDriver.findElements(selector);
                if(null != elements && elements.size() > 0){
                    return;
                }
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }
            switchToLastWebView(mobileDriver);
            try{
                Thread.sleep(300);
            }catch (Exception e){
                e.printStackTrace();
            }
        }while ((System.currentTimeMillis() - begin) < MAX_TIMEOUT_SECONDS * 1000);
    }
}
