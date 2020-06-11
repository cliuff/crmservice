package cn.edu.cqut.util;

import java.util.HashMap;
import java.util.Map;

/**
 * JSON JAVA
 */
public class JsonJ {
    private final Map<String, Object> mData = new HashMap<>();

    public void set(String name, Object value) {
        mData.put(name, value);
    }

    public void delete(String name) {
        mData.remove(name);
    }

    public Map<String, Object> getContent() {
        return mData;
    }
}
