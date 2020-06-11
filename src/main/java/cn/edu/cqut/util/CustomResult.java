package cn.edu.cqut.util;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CustomResult extends CrmResult<Map<String, Object>> {

    public CustomResult() {
    }

    public CustomResult(List<JsonJ> data) {
        setJsonJ(data);
    }

    public CustomResult(JsonJ data) {
        setJsonJ(data);
    }

    public void setJsonJ(List<JsonJ> data) {
        super.setData(Lists.transform(data, JsonJ::getContent));
    }

    public void setJsonJ(JsonJ data) {
        setJsonJ(Collections.singletonList(data));
    }
}
