package vip.hoode.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;
import java.util.HashSet;

public final class BeanCopyUtils {


    private static final ObjectMapper JSON_MAPPER;

    static {
        JSON_MAPPER = new ObjectMapper();
        JSON_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JSON_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    private BeanCopyUtils() {

    }

    private static SimpleFilterProvider createIgnorePropertiesProvider(String... ignoreProperties) {
        SimpleFilterProvider provider = new SimpleFilterProvider();
        provider.addFilter("ignoreProperties", SimpleBeanPropertyFilter.serializeAllExcept(new HashSet<>(Arrays.asList(ignoreProperties))));
        return provider;
    }

    public static <T> T copyProperties(Object source, T target, boolean isDeep, String... ignoreProperties) {
        if (isDeep) {
            try {
                ObjectMapper filterMapper = JSON_MAPPER.setFilterProvider(createIgnorePropertiesProvider(ignoreProperties));
                String json = filterMapper.writeValueAsString(source);
                filterMapper.readerForUpdating(target).readValue(json);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            BeanUtils.copyProperties(source, target, ignoreProperties);
        }
        return target;
    }

    public static <T> T deepCopyProperties(Object source, T target, String... ignoreProperties) {
        try {
            ObjectMapper filterMapper = JSON_MAPPER.setFilterProvider(createIgnorePropertiesProvider(ignoreProperties));
            String json = filterMapper.writeValueAsString(source);
            filterMapper.readerForUpdating(target).readValue(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return target;
    }

    public static <T> T copyProperties(Object source, T target, String... ignoreProperties) {
        BeanUtils.copyProperties(source, target, ignoreProperties);
        return target;
    }


}
