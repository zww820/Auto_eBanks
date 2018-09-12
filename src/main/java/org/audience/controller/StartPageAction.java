package org.audience.controller;

import org.audience.enums.Drivers;
import org.audience.model.HomePage;
import org.audience.services.StartPageService;
import org.audience.utils.Components;
import org.audience.utils.SwipeScreen;
import org.audience.factory.AppDriverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * author:Audience
 * date:2018/9/6
 * time:16:24
 */
@ContextConfiguration(locations = {"classpath*:application.xml"})
public class StartPageAction extends AbstractTestNGSpringContextTests {

    @Autowired
    private StartPageService startPageService;
    @Autowired
    private HomePage homePage;

    @Test
    public void init() throws Exception {
        SwipeScreen.swipeLeft(AppDriverFactory.getDriverInstance(Drivers.ANDROID),4);
        startPageService.click_btn_ljty();
        Assert.assertTrue(Components.isExsitAPPElement(homePage.getTextview_mssf()));
    }


}
