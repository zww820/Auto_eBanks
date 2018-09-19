package org.audience.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.audience.dao.TestCaseDao;
import org.audience.model.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * author:Audience
 * date:2018/9/13
 * time:15:58
 */
@Component
public class ExcelUtil {
    private static Logger logger= LoggerFactory.getLogger(ExcelUtil.class);

    //单元格，最终按字符串处理
    private String cellStr=null;

    public List<TestCase> readTestCasefromxls(String filePath,TestCaseDao testCaseDao,String collectionName) {
        List<TestCase> testCaseList=new ArrayList<>();
        FileInputStream fileInputStream=null;
        Workbook workbook=null;
        try {
            fileInputStream=new FileInputStream(filePath);
            if(filePath.toLowerCase().endsWith("xlsx")){
                workbook=new XSSFWorkbook(fileInputStream);
            }else if(filePath.toLowerCase().endsWith("xls")){
                workbook= WorkbookFactory.create(filePath);
            }
            //获取excel文件的Sheet数量
            int numOfSheets=workbook.getNumberOfSheets();
            //遍历sheet
            for(int i=0;i<numOfSheets;i++){
                if(workbook.getSheetName(i).equals("修订记录")){
                    continue;
                }else {
                    Sheet sheet=workbook.getSheetAt(i);
                    for(Iterator<Row> rowIterator = sheet.iterator(); rowIterator.hasNext();){
                        Row row=rowIterator.next();
                        if(row.getRowNum()==0 || row.getRowNum()==1 || row.getRowNum()==2 || row.getRowNum()==3){
                            continue;
                        }
                        TestCase testCase=new TestCase();
                        testCase.setSheetName(workbook.getSheetName(i));
                        // 标识位，用于标记第几列
                        int j=0;
                        //遍历每一行每一列
                        for(Iterator<Cell> cellIterator=row.iterator();cellIterator.hasNext();){
                            Cell cell=cellIterator.next();//获取单元格对象
                            //单元格为空，设置为""
                            if(cell==null){
                                cellStr="";
                            }else if (cell.getCellType() == CellType.BOOLEAN){
                                cellStr=String.valueOf(cell.getBooleanCellValue());
                            }else if(cell.getCellType() == CellType.NUMERIC){
                                cellStr=cell.getNumericCellValue()+"";
                            }else {
                                cellStr=cell.getStringCellValue();
                            }
                            if (j==0){
                                testCase.setCaseNo(cellStr);
                            }else if(j==1){
                                testCase.setCaseFunction(cellStr);
                            }else if(j==2){
                                testCase.setCaseName(cellStr);
                            }else if(j==3){
                                testCase.setCasePreCondition(cellStr);
                            }else if(j==4){
                                testCase.setCaseStep(cellStr);
                            }else if(j==5){
                                testCase.setCaseData(cellStr);
                            }else if(j==6){
                                testCase.setCaseExpect(cellStr);
                            }else if(j==7){
                                testCase.setCaseActual(cellStr);
                            }else if(j==8){
                                testCase.setCaseIsExec(cellStr);
                            }
                            j++;
                        }
                        testCaseDao.insert(testCase,collectionName);
                        testCaseList.add(testCase);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null){
                try{
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            for (TestCase tc:testCaseList){
                logger.info(String.valueOf(tc));
            }
        }
        return testCaseList;
    }
}
