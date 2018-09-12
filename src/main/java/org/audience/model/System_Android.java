package org.audience.model;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.audience.enums.Drivers;
import org.audience.factory.AppDriverFactory;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Repository;

/**
 * author:Audience
 * date:2018/9/11
 * time:11:47
 */
@Repository
public class System_Android {

    @AndroidFindBy(id = "com.berchina.bcseebank:id/tv_photo")
    MobileElement textview_llzp;

    @AndroidFindBy(uiAutomator= "new UiSelector().text(\"temp\")")
    MobileElement textview_xc;

    @AndroidFindBy(id="com.berchina.bcseebank:id/image_view_image_select")
    MobileElement imageview_yyzz;

    @AndroidFindBy(uiAutomator= "new UiSelector().text(\"确定\")")
    MobileElement textview_qd;


    public System_Android() throws Exception {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriverFactory.getDriverInstance(Drivers.ANDROID)),this);
    }

    public MobileElement getTextview_llzp() {
        return textview_llzp;
    }

    public MobileElement getTextview_xc() {
        return textview_xc;
    }

    public MobileElement getImageview_yyzz() {
        return imageview_yyzz;
    }

    public MobileElement getTextview_qd() {
        return textview_qd;
    }
}
