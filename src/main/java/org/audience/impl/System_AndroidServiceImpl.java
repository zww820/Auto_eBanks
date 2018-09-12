package org.audience.impl;

import org.audience.model.System_Android;
import org.audience.services.System_AndroidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author:Audience
 * date:2018/9/11
 * time:15:59
 */
@Service
public class System_AndroidServiceImpl implements System_AndroidService{
    @Autowired
    System_Android system_android;

    @Override
    public void textview_textview_llzp() {
        system_android.getTextview_llzp().click();
    }

    @Override
    public void textview_textview_xc() {
        system_android.getTextview_xc().click();
    }

    @Override
    public void imageview_imageview_yyzz() {
        system_android.getImageview_yyzz().click();
    }

    @Override
    public void textview_textview_qd() {
        system_android.getTextview_qd().click();
    }
}
