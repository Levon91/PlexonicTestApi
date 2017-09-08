package am.plexonic.common.dto.dau;

import java.io.Serializable;

/**
 * DAU dto object
 */
public final class DAUDto implements Serializable{
    private static final long serialVersionUID = 1L;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
