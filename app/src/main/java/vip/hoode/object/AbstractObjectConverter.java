package vip.hoode.object;

import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author mitu2
 */
public abstract class AbstractObjectConverter<Model extends Serializable, View extends Serializable>
        implements ObjectConverter<Model, View> {

    private final Class<Model> modelClass;
    private final Class<View> viewClass;

    protected AbstractObjectConverter() {
        this.modelClass = getActualClass(0);
        this.viewClass = getActualClass(1);
    }

    private <T> Class<T> getActualClass(int position) {
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof Class<?>) { // sanity check, should never happen
            throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
        }
        // noinspection unchecked
        return (Class<T>) ((ParameterizedType) superClass).getActualTypeArguments()[position];
    }


    @Override
    public Model toModel() {
        try {
            return toModel(modelClass.getDeclaredConstructor().newInstance());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Model toModel(Model target, String... ignoreProperties) {
        BeanUtils.copyProperties(this, target, ignoreProperties);
        return target;
    }

    @Override
    public View toView() {
        try {
            return toView(viewClass.getDeclaredConstructor().newInstance());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public View toView(View target, String... ignoreProperties) {
        BeanUtils.copyProperties(this, target, ignoreProperties);
        return target;
    }

    @Override
    public void fill(Object source, String... ignoreProperties) {
        BeanUtils.copyProperties(source, this, ignoreProperties);
    }
}
