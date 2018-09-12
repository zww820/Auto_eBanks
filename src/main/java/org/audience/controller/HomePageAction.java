package org.audience.controller;

import io.appium.java_client.MobileCommand;
import io.appium.java_client.MobileElement;
import org.apache.log4j.Logger;
import org.audience.enums.Drivers;
import org.audience.factory.AppDriverFactory;
import org.audience.model.ZxkhPage;
import org.audience.services.HomePageService;
import org.audience.utils.Components;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * author:Audience
 * date:2018/9/7
 * time:21:11
 */
@ContextConfiguration(locations = {"classpath*:application.xml"})
public class HomePageAction extends AbstractTestNGSpringContextTests {
    Logger logger=Logger.getLogger(HomePageAction.class);

    @Autowired
    private HomePageService homePageService;
    @Autowired
    private ZxkhPage zxkhPage;

    @Test
    public void click_zxkh() throws Exception {
        homePageService.click_TextView_zxkh();
        Components.switchToLastWebView(AppDriverFactory.getDriverInstance(Drivers.CHROME));
        Assert.assertTrue(Components.isExsitWEBElement(zxkhPage.getLabel_jbh()));
    }
}
