package vip.hoode.object;

import java.io.Serializable;

/**
 * @author mitu2
 */
public interface ObjectConverter<Target> {

    Target toTarget(String... ignoreProperties);

    <T extends Serializable> T toTarget(Class<T> targetClass, String... ignoreProperties);

    void fill(Object source, String... ignoreProperties);

}
