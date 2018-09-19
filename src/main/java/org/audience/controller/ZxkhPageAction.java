package org.audience.controller;

import org.apache.log4j.Logger;
import org.audience.enums.Drivers;
import org.audience.factory.AppDriverFactory;
import org.audience.model.System_Android;
import org.audience.model.ZxkhPage;
import org.audience.services.System_AndroidService;
import org.audience.services.ZxkhPageService;
import org.audience.utils.Components;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

/**
 * author:Audience
 * date:2018/9/8
 * time:16:14
 */
public class ZxkhPageAction extends AbstractTestNGSpringContextTests {
    Logger logger=Logger.getLogger(ZxkhPageAction.class);

    @Autowired
    ZxkhPageService zxkhPageService;

    @Autowired
    ZxkhPage zxkhPage;

    @Autowired
    System_AndroidService system_androidService;

    /**
     * 基本户
     */
    @Test(priority = 1)
    public void basic_account() throws Exception {
        zxkhPageService.click_i_jbh();
//        zxkhPageService.click_Input_rdty();
        zxkhPageService.click_button_xyb();
        Assert.assertTrue(Components.isExsitWEBElement(zxkhPage.getInput_qsrsjhm()));

        zxkhPageService.input_input_qsrsjhm();
        zxkhPageService.div_div_hqyzm();
        Thread.sleep(5000);
        zxkhPageService.click_button_xyb();
        Thread.sleep(5000);
//        Assert.assertTrue(Components.currentWebtitle(AppDriverFactory.getDriverInstance(Drivers.CHROME),"营业执照"));
        zxkhPageService.label_label_yyzzt();
        //上传营业执照
        AppDriverFactory.getDriverInstance(Drivers.ANDROID).context("NATIVE_APP");
        system_androidService.textview_textview_llzp();
        system_androidService.textview_textview_xc();
        system_androidService.imageview_imageview_yyzz();
        system_androidService.textview_textview_qd();

        Components.switchToLastWebView(AppDriverFactory.getDriverInstance(Drivers.CHROME));
        zxkhPageService.input_input_xinyongdaima();
        zxkhPageService.input_input_qiyemingcheng();
        Assert.assertTrue(Components.isEnabledWEBElement(zxkhPage.getButton_xyb()));
        zxkhPageService.click_button_xyb();
    }

/*    *//**
     * 一般户
     *//*
    @Test(priority = 2)
    public void click_xyb(){
        zxkhPageService.click_button_xyb();
    }*/
}
