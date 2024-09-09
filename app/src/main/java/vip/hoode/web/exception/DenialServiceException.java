package vip.hoode.web.exception;

/**
 * @author mitu2
 */
public class DenialServiceException extends RuntimeException {

    public DenialServiceException(String message) {
        super(message);
    }

    public DenialServiceException() {
        super();
    }

}
