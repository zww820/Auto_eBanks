package org.audience.utils;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * author:Audience
 * date:2018/9/10
 * time:17:32
 */
public class ComponentsAction {
    static Logger logger= LoggerFactory.getLogger(ComponentsAction.class);

//    H5页面输入数据
    public static void H5_inputText(WebElement webElement,String text){
        webElement.clear();
        webElement.sendKeys(text);
    }

//    原生页面输入数据
    public static void Mobile_inputText(MobileElement mobileElement, String text){
        mobileElement.clear();
        mobileElement.sendKeys(text);
    }
}
