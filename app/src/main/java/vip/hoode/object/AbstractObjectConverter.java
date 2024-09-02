package vip.hoode.object;

import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author mitu2
 */
public abstract class
AbstractObjectConverter<Target extends Serializable>
        implements ObjectConverter<Target> {

    private final transient Class<Target> targetClass;

    protected AbstractObjectConverter() {
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
    public Target toTarget(String... ignoreProperties) {
        return toTarget(targetClass, ignoreProperties);
    }

    @Override
    public <T extends Serializable> T toTarget(Class<T> targetClass, String... ignoreProperties) {
        try {
            T target = targetClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(this, target, ignoreProperties);
            return target;
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 InstantiationException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void fill(Object source, String... ignoreProperties) {
        BeanUtils.copyProperties(source, this, ignoreProperties);
    }
}
