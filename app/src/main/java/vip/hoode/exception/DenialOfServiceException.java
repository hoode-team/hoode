package vip.hoode.exception;

/**
 * @author mitu2
 */
public class DenialOfServiceException extends RuntimeException {

    public DenialOfServiceException(String message) {
        super(message);
    }

    public DenialOfServiceException() {
        super();
    }

}
