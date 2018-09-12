package org.audience.impl;

import org.apache.log4j.Logger;
import org.audience.model.System_Android;
import org.audience.model.ZxkhPage;
import org.audience.model.Zxkh_yyzzPage;
import org.audience.services.ZxkhPageService;
import org.audience.utils.ComponentsAction;
import org.audience.utils.RandomParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * author:Audience
 * date:2018/9/8
 * time:20:39
 */
@Service
public class ZxkhPageServiceImpl implements ZxkhPageService {
    Logger logger=Logger.getLogger(ZxkhPageServiceImpl.class);

    @Autowired
    ZxkhPage zxkhPage;

    @Autowired
    Zxkh_yyzzPage zxkh_yyzzPage;

    @Autowired
    System_Android system_android;

    @Override
    public void click_label_jbh() {
        zxkhPage.getLabel_jbh().click();
    }

    @Override
    public void click_i_jbh() {
        zxkhPage.getI_jbh().click();
    }

    @Override
    public void click_i_ybh() {
        zxkhPage.getI_ybh().click();
    }

    @Override
    public void click_i_qywlyh() {
        zxkhPage.getI_qywlyh().click();
    }

    @Override
    public void click_Input_rdty() {
        zxkhPage.getInput_rdty().click();
    }

    @Override
    public void click_button_xyb() {
        zxkhPage.getButton_xyb().click();
    }

    @Override
    public void input_input_qsrsjhm() {
        ComponentsAction.H5_inputText(zxkhPage.getInput_qsrsjhm(),RandomParams.getTel());
    }

    @Override
    public void input_input_qsryzm() {

    }

    @Override
    public void div_div_hqyzm() {
        zxkhPage.getDiv_hqyzm().click();
    }

    @Override
    public void label_label_yyzzt() {
        zxkh_yyzzPage.getLabel_yyzzt().click();
    }

}
