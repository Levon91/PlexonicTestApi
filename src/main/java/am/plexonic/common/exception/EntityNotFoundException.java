package am.plexonic.common.exception;

/**
 * The entity not found exception.
 * Indicates that an entity not found.
 */
public final class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(Throwable e) {
        super(e);
    }

    public EntityNotFoundException(String message, Throwable e) {
        super(message, e);
    }
}
