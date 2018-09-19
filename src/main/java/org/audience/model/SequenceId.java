package org.audience.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * author:Audience
 * date:2018/9/18
 * time:10:58
 */
@Document(collection = "sequence")
public class SequenceId {
    @Id
    private String id;
    private long seqId;

    public String getId() {
        return id;
    }

    public long getSeqId() {
        return seqId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSeqId(long seqId) {
        this.seqId = seqId;
    }
}
