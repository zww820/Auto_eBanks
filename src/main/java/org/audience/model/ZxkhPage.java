package org.audience.model;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.audience.enums.Drivers;
import org.audience.factory.AppDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Repository;

/**
 * author:Audience
 * date:2018/9/6
 * time:17:45
 */
 @Repository
 public class ZxkhPage{

 	@FindBy(xpath = "//div[text()='基本户']")
    WebElement label_jbh;

 	@FindBy(xpath = "//div[text()='基本户']/following-sibling::i")
    WebElement i_jbh;

 	@FindBy(xpath = "//div[text()='一般户']/following-sibling::i")
    WebElement i_ybh;

 	@FindBy(xpath = "div[text()='企业网络银行']/following-sibling::i")
    WebElement i_qywlyh;

 	@FindBy(xpath = "//input[@type='checkbox']")
    WebElement input_rdty;

 	@FindBy(xpath = "//button")
 	WebElement button_xyb;

 	@FindBy(xpath = "//input[@placeholder='请输入手机号码']")
    WebElement input_qsrsjhm;

 	@FindBy(xpath = "//input[@placeholder='请输入验证码']")
    WebElement input_qsryzm;

 	@FindBy(xpath = "//div[text()='获取验证码']")
    WebElement div_hqyzm;

    public ZxkhPage() throws Exception {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriverFactory.getDriverInstance(Drivers.CHROME)),this);
    }

    public WebElement getLabel_jbh() {
        return label_jbh;
    }

    public WebElement getInput_rdty() {
        return input_rdty;
    }

    public WebElement getButton_xyb() {
        return button_xyb;
    }

    public WebElement getI_ybh() {
        return i_ybh;
    }

    public WebElement getInput_qsrsjhm() {
        return input_qsrsjhm;
    }

    public WebElement getInput_qsryzm() {
        return input_qsryzm;
    }

    public WebElement getDiv_hqyzm() {
        return div_hqyzm;
    }

    public WebElement getI_jbh() {
        return i_jbh;
    }

    public WebElement getI_qywlyh() {
        return i_qywlyh;
    }
}