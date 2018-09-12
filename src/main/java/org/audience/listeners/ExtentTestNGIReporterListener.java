package org.audience.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.TestAttribute;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.lang3.StringUtils;
import org.audience.utils.PropertyPlaceholderConfigurer;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.util.*;

/**
 * author:Audience
 * date:2018/9/12
 * time:9:56
 */
public class ExtentTestNGIReporterListener implements IReporter {
    private static final String OUTPUT_FOLDER = PropertyPlaceholderConfigurer.getProperty("OUTPUT_FOLDER");
    private static final String FILE_NAME = PropertyPlaceholderConfigurer.getProperty("FILE_NAME");

    private ExtentReports extent;

    @Override
    public void generateReport(List<XmlSuite> list, List<ISuite> list1, String s) {

    }

    private void init() {
        File reportDir=new File(OUTPUT_FOLDER);
        if(!reportDir.exists() && !reportDir.isDirectory()){
            reportDir.mkdir();
        }
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);
        htmlReporter.config().setDocumentTitle("自动化测试报告");
        htmlReporter.config().setReportName("自动化测试报告");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
//        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
        htmlReporter.config().setCSS(".node.level-1  ul{ display:none;} .node.level-1.active ul{display:block;}");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
    }

    private void buildTestNodes(ExtentTest extentTest,IResultMap tests, Status status) {
        String[] categories=new String[0];
        if(extentTest !=null){
            List<TestAttribute> categoryList=extentTest.getModel().getCategoryContext().getAll();
            categories = new String[categoryList.size()];
            for (int index=0 ; index<categoryList.size();index++){
                categories[index] = categoryList.get(index).getName();
            }
        }

        ExtentTest test;

        if (tests.size() > 0) {
            Set<ITestResult> treeSet= new TreeSet<>(new Comparator<ITestResult>() {
                @Override
                public int compare(ITestResult o1, ITestResult o2) {
                    return o1.getStartMillis()<o2.getStartMillis()?-1:1;
                }
            });
            treeSet.addAll(tests.getAllResults());

            for (ITestResult result : tests.getAllResults()) {
                Object[] paramters=result.getParameters();
                String name="";

                for (Object param:paramters){
                    name+=param.toString();
                }

                if(name.length()>0){
                    if(name.length()>50){
                        name=name.substring(0,49)+"...";
                    }
                }else {
                    name=result.getMethod().getMethodName();
                }

                if(extentTest==null){
                    test=extent.createTest(name);
                }else {
                    test=extentTest.createNode(name).assignCategory(categories);
                }

//                test = extent.createTest(result.getMethod().getMethodName());

                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                List<String> outputlist= Reporter.getOutput(result);
                for (String output:outputlist){
                    test.debug(output);
                }

                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                }
                else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }

                test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.getModel().setEndTime(getTime(result.getEndMillis()));
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

}
