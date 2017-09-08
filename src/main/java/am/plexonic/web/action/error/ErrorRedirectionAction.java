package am.plexonic.web.action.error;

import am.plexonic.web.action.comon.BaseAction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Error redirect class
 */
@Component
@Scope("prototype")
public class ErrorRedirectionAction extends BaseAction {
    private static final long serialVersionUID = 1L;

    private Integer statusCode;

    @Override
    public String execute() {

        if (statusCode != null) {
            switch (statusCode) {
                case 401:
                case 403:
                case 404:
                case 500:
                case 503:

            }
        } else {
            statusCode = 500;
        }
        return SUCCESS;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

}