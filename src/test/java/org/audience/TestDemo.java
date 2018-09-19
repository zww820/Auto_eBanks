package org.audience;

import org.audience.dao.TestCaseDao;
import org.audience.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * author:Audience
 * date:2018/9/13
 * time:17:02
 */
@ContextConfiguration(locations = {"classpath*:application.xml"})
public class TestDemo extends AbstractTestNGSpringContextTests {

    @Autowired
    TestCaseDao testCaseDao;

    @Test
    public void runtest(){
        testCaseDao.removeAll();
        new ExcelUtil().readTestCasefromxls("E:\\副本测试用例用例模板.xlsx",testCaseDao,"TestCase");
    }
}
