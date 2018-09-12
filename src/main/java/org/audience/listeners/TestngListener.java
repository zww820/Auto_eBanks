package org.audience.listeners;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * author:Audience
 * date:2018/9/12
 * time:15:02
 */
public class TestngListener extends TestListenerAdapter{

    @Override
    public void onTestSuccess(ITestResult iTestResult){
        super.onTestSuccess(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult){
        super.onTestFailure(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult){
        super.onTestSkipped(iTestResult);
    }

    @Override
    public void onTestStart(ITestResult iTestResult){
        super.onTestStart(iTestResult);
    }

    public void onStart(ITestContext iTestContext){
        super.onStart(iTestContext);

    }
}
