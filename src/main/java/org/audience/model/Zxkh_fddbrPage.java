package org.audience.model;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.audience.enums.Drivers;
import org.audience.factory.AppDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * author:Audience
 * date:2018/9/12
 * time:18:11
 */
public class Zxkh_fddbrPage {

    @FindBy(xpath = "(//img)[1]")
    WebElement img_shangchuanshengfenzhengzhengmian;

    @FindBy(xpath = "(//img)[2]")
    WebElement img_shangchuanshengfenzhengfanmian;

    @FindBy(xpath = "//input[@placeholder='请输入法定代表人姓名']")
    WebElement input_xingming;

    @FindBy(xpath = "//input[@placeholder='请输入手机号码']")
    WebElement input_shoujihaoma;

    @FindBy(xpath = "//input[@placeholder='请输入身份证号码']")
    WebElement input_shenfenzhenghao;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    WebElement checkbox_feichangqi;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    WebElement checkbox_changqi;

    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    WebElement checkbox_fadingdaibiaoren;

    @FindBy(xpath = "(//input[@type='checkbox'])[4]")
    WebElement checkbox_jingbanren;

    @FindBy(xpath = "(//div[text()='证件有效期']/following-sibling::div)[1]")
    WebElement div_zhengjianyouxiaoriqi;

    public Zxkh_fddbrPage() throws Exception {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriverFactory.getDriverInstance(Drivers.CHROME)),this);
    }

    public WebElement getCheckbox_changqi() {
        return checkbox_changqi;
    }

    public WebElement getCheckbox_fadingdaibiaoren() {
        return checkbox_fadingdaibiaoren;
    }

    public WebElement getCheckbox_feichangqi() {
        return checkbox_feichangqi;
    }

    public WebElement getCheckbox_jingbanren() {
        return checkbox_jingbanren;
    }

    public WebElement getDiv_zhengjianyouxiaoriqi() {
        return div_zhengjianyouxiaoriqi;
    }

    public WebElement getImg_shangchuanshengfenzhengfanmian() {
        return img_shangchuanshengfenzhengfanmian;
    }

    public WebElement getImg_shangchuanshengfenzhengzhengmian() {
        return img_shangchuanshengfenzhengzhengmian;
    }

    public WebElement getInput_shenfenzhenghao() {
        return input_shenfenzhenghao;
    }

    public WebElement getInput_shoujihaoma() {
        return input_shoujihaoma;
    }

    public WebElement getInput_xingming() {
        return input_xingming;
    }
}

