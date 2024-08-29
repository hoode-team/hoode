package vip.hoode.util;

import vip.hoode.exception.DenialOfServiceException;

/**
 * @author mitu2
 */
public abstract class ServiceUtil {

    private ServiceUtil() {

    }

    public static  <T> T DOS() {
        throw new DenialOfServiceException();
    }

    public static <T> T DOS(String message) {
        throw new DenialOfServiceException(message);
    }

}
