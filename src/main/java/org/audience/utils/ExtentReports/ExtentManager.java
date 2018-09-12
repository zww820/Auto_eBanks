package org.audience.utils.ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;
import org.audience.utils.PropertyPlaceholderConfigurer;

/**
 * author:Audience
 * date:2018/9/11
 * time:19:21
 */
public class ExtentManager {

    private static ExtentReports extentReports;

    public synchronized static ExtentReports getReporter(){
        if(extentReports == null){
            String workingDir = PropertyPlaceholderConfigurer.getProperty("user.dir");
            extentReports = new ExtentReports(workingDir+"\\ExtentReports\\ExtentReportResult.xml",true);
        }
        return extentReports;
    }
}
