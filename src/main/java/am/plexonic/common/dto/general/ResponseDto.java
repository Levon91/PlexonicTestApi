package am.plexonic.common.dto.general;

import java.io.Serializable;

/**
 * Response dto object
 */
public class ResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String message;

    private ResponseStatus status;

    public void addMessage(String message) {
        this.message = this.message == null ? message : this.message + ",\r\n" + message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(final ResponseStatus status) {
        this.status = status;
    }

}
