package org.audience.utils;

import io.appium.java_client.MobileElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

/**
 * author:Audience
 * date:2018/9/10
 * time:17:32
 */
public class ComponentsAction {
    static Logger logger=Logger.getLogger(ComponentsAction.class);

    public static void H5_inputText(WebElement webElement,String text){
        webElement.clear();
        webElement.sendKeys(text);
        logger.info("WebElement:"+webElement+","+"text:"+text);
    }

    public static void Mobile_inputText(MobileElement mobileElement, String text){
        mobileElement.clear();
        mobileElement.sendKeys(text);
        logger.info("MobileElement:"+mobileElement+","+"text:"+text);
    }
}
