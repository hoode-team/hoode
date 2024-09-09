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

public class BeanCopyUtils {

    private static final ObjectMapper JSON_MAPPER;

    static {
        JSON_MAPPER = new ObjectMapper();
        JSON_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JSON_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    public static void copyProperties(Object source, Object target, boolean isDeep, String... ignoreProperties) {
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
    }

    private static SimpleFilterProvider createIgnorePropertiesProvider(String... ignoreProperties) {
        SimpleFilterProvider provider = new SimpleFilterProvider();
        provider.addFilter("ignoreProperties", SimpleBeanPropertyFilter.serializeAllExcept(new HashSet<>(Arrays.asList(ignoreProperties))));
        return provider;
    }


}
