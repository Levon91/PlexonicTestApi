package am.plexonic.common.rs_utils.exception;

/**
 * The server unavailable exception.
 * Indicates that there is an exception related to the server connection.
 */
public final class ServerUnavailableException extends Exception {

    public ServerUnavailableException() {
    }

    public ServerUnavailableException(String message) {
        super(message);
    }

    public ServerUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerUnavailableException(Throwable cause) {
        super(cause);
    }
}
