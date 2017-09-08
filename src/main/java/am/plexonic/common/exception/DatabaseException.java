package am.plexonic.common.exception;

/**
 * The database exception.
 */
public final class DatabaseException extends Exception {

    public DatabaseException() {
        super();
    }

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(Throwable e) {
        super(e);
    }

    public DatabaseException(String message, Throwable e) {
        super(message, e);
    }

}
