package org.audience.listeners;

import com.mongodb.client.model.FindOneAndUpdateOptions;
import org.audience.annotation.AutoIncKey;
import org.audience.model.SequenceId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.ReflectionUtils;

import javax.annotation.Resource;
import javax.swing.text.AbstractDocument;
import java.lang.reflect.Field;
import java.time.LocalDateTime;

/**
 * author:Audience
 * date:2018/9/18
 * time:10:32
 */
//@Component
public class SaveMongoEventListener extends AbstractMongoEventListener<Object> {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event){
        Object source=event.getSource();
        if (source != null) {
            ReflectionUtils.doWithFields(source.getClass(), new ReflectionUtils.FieldCallback() {
                public void doWith(Field field) throws
                        IllegalArgumentException,   IllegalAccessException {
                    ReflectionUtils.makeAccessible(field);
                    // 如果字段添加了我们自定义的AutoIncKey注解
                    if (field.isAnnotationPresent(AutoIncKey.class)) {
                        // 设置自增ID
                        field.set(source, getNextId(source.getClass().getSimpleName()));
                    }
                }
            });
        }
    }

    /**
     * 获取下一个自增ID
     * @author audience
     * @param collName  集合名
     * @return
     */
    private Long getNextId(String collName){
        Query query = new Query(Criteria.where("collName").is(collName));
        Update update = new Update();
        update.inc("seqId", 1);
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.upsert(true);
        options.returnNew(true);
        System.out.println("+++++++++++++++query:"+query);
        System.out.println("+++++++++++++++update:"+update);
        FindOneAndUpdateOptions oneAndUpdateOptions = new FindOneAndUpdateOptions();
        SequenceId seq = mongoTemplate.findAndModify(query, update, options, SequenceId.class);
        System.out.println("+++++++++++++++SeqId:"+seq.getSeqId());
        return seq.getSeqId();
    }
}
