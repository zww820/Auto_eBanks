package org.audience.model;

import org.audience.annotation.AutoIncKey;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Map;

/**
 * author:Audience
 * date:2018/9/12
 * time:21:17
 */
@Document(collection = "TestCase")
public class TestCase {

    @AutoIncKey
/*    @Id
    private Long id=0L;*/
    private String sheetName;
    //测试用例编号
    private String caseNo;
    //测试用例功能点
    private String caseFunction;
    //测试用例项
    private String caseName;
    //预置条件
    private String casePreCondition;
    //步骤
    private String caseStep;
    //测试数据
    private String caseData;
    //预期结果（断言）
    private String caseExpect;
    //测试结果
    private String caseActual;
    //是否执行
    private String caseIsExec;

/*    public long getId() {
        return id;
    }*/

    public String getSheetName() {
        return sheetName;
    }

    public String getCaseActual() {
        return caseActual;
    }

    public String getCaseData() {
        return caseData;
    }

    public String getCaseExpect() {
        return caseExpect;
    }

    public String getCaseFunction() {
        return caseFunction;
    }

    public String getCaseIsExec() {
        return caseIsExec;
    }

    public String getCaseName() {
        return caseName;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public String getCasePreCondition() {
        return casePreCondition;
    }

    public String getCaseStep() {
        return caseStep;
    }
/*
    public void setId(long id) {
        this.id = id;
    }*/

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public void setCaseActual(String caseActual) {
        this.caseActual = caseActual;
    }

    public void setCaseData(String caseData) {
        this.caseData = caseData;
    }

    public void setCaseExpect(String caseExpect) {
        this.caseExpect = caseExpect;
    }

    public void setCaseFunction(String caseFunction) {
        this.caseFunction = caseFunction;
    }

    public void setCaseIsExec(String caseIsExec) {
        this.caseIsExec = caseIsExec;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public void setCasePreCondition(String casePreCondition) {
        this.casePreCondition = casePreCondition;
    }

    public void setCaseStep(String caseStep) {
        this.caseStep = caseStep;
    }

    public interface TestCaseRepository extends MongoRepository<TestCase,String>{

    }

    @Override
    public String toString(){
        return "TestCase [sheetName:"+sheetName+",caseNo:"+caseNo+",caseFunction:"+caseFunction+",caseName:"+caseName
                +",casePreCondition:"+casePreCondition+",caseStep:"+caseStep+",caseData:"+caseData+",caseExpect:"+caseExpect
                +",caseActual:"+caseActual+",caseIsExec:"+caseIsExec+"]";
    }

}
