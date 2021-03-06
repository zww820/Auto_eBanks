package org.audience.impl;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.audience.factory.AppDriverFactory;
import org.audience.model.StartPage;
import org.audience.services.StartPageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author:Audience
 * date:2018/9/6
 * time:17:07
 */
@Service
public class StartPageServiceImpl implements StartPageService{
    Logger logger= LoggerFactory.getLogger(StartPageServiceImpl.class);

    @Autowired
    StartPage startpage;

    @Override
    public void click_btn_ljty() {
        startpage.getBtn_ljty().click();
    }
}
