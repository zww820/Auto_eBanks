package org.audience.impl;

import org.audience.dao.TestCaseDao;
import org.audience.model.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * author:Audience
 * date:2018/9/17
 * time:15:54
 */
@Repository
public class TestCaseDaoImpl implements TestCaseDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(TestCase testCase, String collectionName) {
        mongoTemplate.insert(testCase,collectionName);
    }

    @Override
    public TestCase findOne(Map<String, Object> params, String collectionName) {
        return mongoTemplate.findOne(new Query(Criteria.where("caseNo").is(params.get("caseNo"))),TestCase.class,collectionName);
    }

    @Override
    public List<TestCase> findMultiple(Map<String, Object> params, String collectionName) {
        List<TestCase> testCaseList=mongoTemplate.find(new Query(Criteria.where("caseName").lt(params.get("caseName"))),TestCase.class,collectionName);
        return testCaseList;
    }

    @Override
    public List<TestCase> findAll() {
        return mongoTemplate.findAll(TestCase.class);
    }

    @Override
    public void update(Map<String, Object> params, String collectionName) {
        Query query=new Query(Criteria.where("caseNo").is(params.get("caseNo")));

        Update update=new Update();
        update.set("sheetName",params.get("sheetName"));
        update.set("caseActual",params.get("caseActual"));
        update.set("caseData",params.get("caseData"));
        update.set("caseExpect",params.get("caseExpect"));
        update.set("caseFunction",params.get("caseFunction"));
        update.set("caseIsExec",params.get("caseIsExec"));
        update.set("caseName",params.get("caseName"));
        update.set("caseNo",params.get("caseNo"));
        update.set("casePreCondition",params.get("casePreCondition"));
        update.set("caseStep",params.get("caseStep"));
        mongoTemplate.updateFirst(query,update,TestCase.class);
    }

    @Override
    public void createCollection(String collectionName) {

    }

    @Override
    public void remove(Map<String, Object> params, String collectionName) {
        mongoTemplate.remove(new Query(Criteria.where("CaseNo").is(params.get("CaseNo"))),TestCase.class);
    }

    @Override
    public void removeAll() {
        mongoTemplate.dropCollection(TestCase.class);
    }

    @Override
    public void insertAll(List<TestCase> object) {

    }
}
