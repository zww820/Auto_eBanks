package org.audience.impl;

import org.audience.model.HomePage;
import org.audience.services.HomePageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger= LoggerFactory.getLogger(HomePageServiceImpl.class);

    @Autowired
    HomePage homePage;

    @Override
    public void click_TextView_zxkh() {
        homePage.getTextview_zxkh().click();
    }
}
