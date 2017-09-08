package am.plexonic.common.exception;

/**
 * The internal error exception.
 * Indicates that an internal error has occurred.
 */
public class InternalErrorException extends Exception {

    public InternalErrorException() {
        super();
    }

    public InternalErrorException(String message) {
        super(message);
    }

    public InternalErrorException(Throwable e) {
        super(e);
    }

    public InternalErrorException(String message, Throwable e) {
        super(message, e);
    }

}
