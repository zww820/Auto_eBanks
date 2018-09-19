package org.audience.listeners;

import io.appium.java_client.events.api.general.ElementEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * author:Audience
 * date:2018/9/11
 * time:16:27
 */
public class EventListener implements ElementEventListener {
    Logger logger= LoggerFactory.getLogger(EventListener.class);

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("准备点击："+splitElement(webElement));
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("点击"+splitElement(webElement));
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver) {
        logger.info("准备改变控件："+splitElement(webElement));
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver) {
        logger.info("控件："+splitElement(webElement)+"数值已改变");
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    private String splitElement(WebElement element){
        String str=element.toString().split("->")[1];
        return str.substring(0,str.length()-1);
    }
}
