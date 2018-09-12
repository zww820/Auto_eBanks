package org.audience.impl;

import org.apache.log4j.Logger;
import org.audience.model.HomePage;
import org.audience.services.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.Assert;

/**
 * author:Audience
 * date:2018/9/7
 * time:21:08
 */
@Service
public class HomePageServiceImpl implements HomePageService {

    Logger logger=Logger.getLogger(HomePageServiceImpl.class);

    @Autowired
    HomePage homePage;

    @Override
    public void click_TextView_zxkh() {
        homePage.getTextview_zxkh().click();
    }
}
