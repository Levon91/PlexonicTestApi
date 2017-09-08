package am.plexonic.common.dto.general;

/**
 * Response status
 */
public enum ResponseStatus {
    SUCCESS                 (200, "ok"),
    NO_RESPONSE             (204, "no response"),
    BAD_REQUEST             (400, "bad request"),
    FORBIDDEN               (403, "operation forbidden"),
    RESOURCE_NOT_FOUND      (404, "resource not found"),
    CONFLICT_DUPLICATE_DATA (409, "conflict: duplicate data"),
    INTERNAL_ERROR          (500, "internal error"),
    NOT_IMPLEMENTED         (501, "not implemented"),
    INVALID_PARAMETER       (101, "invalid parameter"),
    NO_DATA_FOUND           (102, "no data found");

    private final int code;
    private final String description;

    ResponseStatus(final int code, final String description) {
        this.code = code;
        this.description = description;
    }

    public static ResponseStatus valueOf(final int code) {

        for (ResponseStatus e : ResponseStatus.values()) {
            if (e.code == code) {
                return e;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description + " (" + code + ")";
    }
}
