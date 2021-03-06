package org.audience.model;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.audience.enums.Drivers;
import org.audience.factory.AppDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Repository;

/**
 * author:Audience
 * date:2018/9/10
 * time:22:10
 */
@Repository
public class Zxkh_yyzzPage {

    @FindBy(xpath = "//div[text()='查看示例']")
    WebElement div_cksl;

    @FindBy(xpath = "//label")
    WebElement label_yyzzt;

    @FindBy(xpath = "//input[@placeholder='请输入统一社会信用代码']")
    WebElement input_xinyongdaima;

    @FindBy(xpath = "//input[@placeholder='请输入企业名称']")
    WebElement input_qiyemingcheng;

    public Zxkh_yyzzPage() throws Exception {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriverFactory.getDriverInstance(Drivers.CHROME)),this);
    }

    public WebElement getDiv_cksl() {
        return div_cksl;
    }

    public WebElement getLabel_yyzzt() {
        return label_yyzzt;
    }

    public WebElement getInput_xinyongdaima() {
        return input_xinyongdaima;
    }

    public WebElement getInput_qiyemingcheng() {
        return input_qiyemingcheng;
    }
}
