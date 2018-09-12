package org.audience.model;

import com.gargoylesoftware.htmlunit.Page;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.audience.enums.Drivers;
import org.audience.factory.AppDriverFactory;
import org.opencv.core.MatOfDMatch;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Repository;

/**
 * author:Audience
 * date:2018/9/6
 * time:17:45
 */
@Repository
public class HomePage {

    @AndroidFindBy(accessibility = "账户总览")
    MobileElement textview_zhzl;

    @AndroidFindBy(accessibility = "转账汇款")
    MobileElement textview_zzhk;

    @AndroidFindBy(accessibility = "代发工资")
    MobileElement textview_dfgz;

    @AndroidFindBy(uiAutomator= "new UiSelector().text(\"在线开户\")")
    MobileElement textview_zxkh;

    @AndroidFindBy(accessibility = "码上收付")
    MobileElement textview_mssf;

    @AndroidFindBy(accessibility = "授权中心")
    MobileElement textview_sqzx;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='附近网点']")
    MobileElement textview_fjwd;

    @AndroidFindBy(id = "com.berchina.bcseebank:id/rb_finance")
    MobileElement radiobutton_jrfw;

    @AndroidFindBy(id = "com.berchina.bcseebank:id/rb_mine")
    MobileElement radiobutton_wd;

    @AndroidFindBy(id="com.berchina.bcseebank:id/tv_content")
    MobileElement textview_spyj;

    @AndroidFindBy(id="com.berchina.bcseebank:id/tv_content1")
    MobileElement textview_gg;

    public HomePage() throws Exception {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriverFactory.getDriverInstance(Drivers.ANDROID)),this);
    }

    public MobileElement getTextview_dfgz() {
        return textview_dfgz;
    }

    public MobileElement getTextview_fjwd() {
        return textview_fjwd;
    }

    public MobileElement getTextview_mssf() {
        return textview_mssf;
    }

    public MobileElement getTextview_sqzx() {
        return textview_sqzx;
    }

    public MobileElement getTextview_zhzl() {
        return textview_zhzl;
    }

    public MobileElement getTextview_zzhk() {
        return textview_zzhk;
    }

    public MobileElement getTextview_zxkh() {
        return textview_zxkh;
    }

    public MobileElement getRadiobutton_jrfw() {
        return radiobutton_jrfw;
    }

    public MobileElement getRadiobutton_wd() {
        return radiobutton_wd;
    }

    public MobileElement getTextview_gg() {
        return textview_gg;
    }

    public MobileElement getTextview_spyj() {
        return textview_spyj;
    }
}
