package vip.hoode.util;

import java.util.Collection;
import java.util.stream.Stream;

/**
 * @author mitu2
 */
public class StreamUtil {

    public static <T> Stream<T> ofNullable(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return Stream.empty();
        }
        return collection.stream();
    }


}
