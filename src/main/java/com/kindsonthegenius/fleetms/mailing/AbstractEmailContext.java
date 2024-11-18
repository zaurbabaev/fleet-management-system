package com.kindsonthegenius.fleetms.mailing;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class AbstractEmailContext {
    String to;
    String from;
    String subject;
    String email;
    String templateLocation;
    Map<String, Object> context;

    public AbstractEmailContext() {
        this.context = new HashMap<>();
    }

    public <T> void init(T context){

    }


    public Object put(String key, Object value) {
        return key == null ? null : this.context.put(key.intern(), value);
    }


}
