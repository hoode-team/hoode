package vip.hoode.web;

import vip.hoode.web.exception.DenialServiceException;

/**
 * @author mitu2
 */
public abstract class HoodeWebContext {

    private HoodeWebContext() {

    }

    public static <T> T DOS() {
        throw new DenialServiceException();
    }

    public static <T> T DOS(String message) {
        throw new DenialServiceException(message);
    }

}
