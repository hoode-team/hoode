package vip.hoode.object;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author mitu2
 */
public abstract class
AbstractDeepObjectConverter<Target extends Serializable>
        implements ObjectConverter<Target> {

    private final transient Class<Target> targetClass;
    private static final ObjectMapper JSON_MAPPER;

    static {
        JSON_MAPPER = new ObjectMapper();
        JSON_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JSON_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    protected AbstractDeepObjectConverter() {
        this.targetClass = getActualClass();
    }

    private <T> Class<T> getActualClass() {
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof Class<?>) { // sanity check, should never happen
            throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
        }
        // noinspection unchecked
        return (Class<T>) ((ParameterizedType) superClass).getActualTypeArguments()[0];
    }


    @Override
    public Target toTarget() {
        return toTarget(null);
    }

    @Override
    public Target toTarget(Target target, String... ignoreProperties) {
        SimpleFilterProvider provider = new SimpleFilterProvider();
        provider.addFilter("ignoreProperties", SimpleBeanPropertyFilter.serializeAllExcept(new HashSet<>(Arrays.asList(ignoreProperties))));
        return JSON_MAPPER.setFilterProvider(provider).convertValue(this, targetClass);
    }


    @Override
    public void fill(Object source, String... ignoreProperties) {
        SimpleFilterProvider provider = new SimpleFilterProvider();
        provider.addFilter("ignoreProperties", SimpleBeanPropertyFilter.serializeAllExcept(new HashSet<>(Arrays.asList(ignoreProperties))));
        Object convertSource = JSON_MAPPER.setFilterProvider(provider).convertValue(source, this.getClass());
        BeanUtils.copyProperties(convertSource, this, ignoreProperties);
    }
}
