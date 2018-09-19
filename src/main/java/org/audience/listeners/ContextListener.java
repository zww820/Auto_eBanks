package org.audience.listeners;

import io.appium.java_client.events.api.mobile.ContextEventListener;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * author:Audience
 * date:2018/9/11
 * time:16:43
 */
public class ContextListener implements ContextEventListener {
    Logger logger= LoggerFactory.getLogger(ContextListener.class);
    @Override
    public void beforeSwitchingToContext(WebDriver webDriver, String s) {
        logger.info("准备切换到："+s);
    }

    @Override
    public void afterSwitchingToContext(WebDriver webDriver, String s) {
        logger.info("切换到："+s);
    }
}
