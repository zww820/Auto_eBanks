package org.audience.dao;

import java.util.List;
import java.util.Map;

/**
 * author:Audience
 * date:2018/9/17
 * time:22:51
 */
public interface MongoBase<T> {

    public void insert(T object,String collectionName);

    //根据条件查找一个
    public T findOne(Map<String,Object> params,String collectionName);

    //根据条件查找多个
    public List<T> findMultiple(Map<String,Object> params,String collectionName);

    //查找所有
    public List<T> findAll();

    //修改
    public void update(Map<String,Object> params,String collectionName);

    //创建集合
    public void createCollection(String collectionName);

    //根据条件删除
    public void remove(Map<String,Object> params,String collectionName);

    //清空
    public void removeAll();

    public void insertAll(List<T> object);

}
