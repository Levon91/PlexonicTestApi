package am.plexonic.core.manager.model;

import java.io.Serializable;

/**
 * Daily active users model
 */
public class DAU implements Serializable{

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
