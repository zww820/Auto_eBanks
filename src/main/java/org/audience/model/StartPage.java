package org.audience.model;

import com.gargoylesoftware.htmlunit.Page;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.audience.enums.Drivers;
import org.audience.factory.AppDriverFactory;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Repository;

import static org.audience.factory.AppDriverFactory.*;


/**
 * author:Audience
 * date:2018/9/6
 * time:16:19
 */
@Repository
public class StartPage {

    @AndroidFindBy(id = "com.berchina.bcseebank:id/bt_start")
    MobileElement btn_ljty;

    public StartPage() throws Exception {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriverFactory.getDriverInstance(Drivers.ANDROID)),this);
    }

    public MobileElement getBtn_ljty() {
        return btn_ljty;
    }

    public void setBtn_ljty(AndroidElement btn_ljty) {
        this.btn_ljty = btn_ljty;
    }
}
