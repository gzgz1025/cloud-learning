package com.cloud.learning;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JacksonUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String toJsonString(Object data) {
        try {
            return OBJECT_MAPPER.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            log.error("json转换异常：{}", data);
            return null;
        }
    }

    public static <T> T fromJson(String jsonData, Class<T> beanType) {
        try {
            return OBJECT_MAPPER.readValue(jsonData, beanType);
        } catch (Exception e) {
            log.error("json转换异常：{}", jsonData);
            return null;
        }
    }

    public synchronized static <T> T json2GenericObject(String jsonString, TypeReference<T> tr) {
        if (jsonString != null && !("".equals(jsonString))) {
            try {
                return (T) (tr.getType().equals(String.class) ? jsonString : OBJECT_MAPPER.readValue(jsonString, tr));
            } catch (Exception e) {
                log.warn("json error:" + e.getMessage());
            }
        }
        return null;
    }

}
