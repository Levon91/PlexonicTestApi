package am.plexonic.web.action.comon;

import am.plexonic.common.exception.InternalErrorException;
import am.plexonic.common.utils.validator.CommonValidator;
import am.plexonic.core.manager.service.util.InitializerContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract class BaseAction extends ActionSupport
        implements Preparable, ApplicationAware, SessionAware, CookiesAware {
    /**
     * data of application scope
     */
    protected Map<String, Object> application;
    /**
     * data of session scope
     */
    protected Map<String, Object> session;
    /**
     * data of cookie
     */
    protected Map<String, String> cookies;

    protected String errorMessage;

    @Autowired
    protected InitializerContext initializerContext;

    protected HttpSession getHttpSession() {
        return ServletActionContext.getRequest().getSession();
    }

    protected String getSessionId() {
        return getHttpSession().getId();
    }

    protected String getErrorUrlAction() {
        return "error.action";
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }


    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }


    public void setCookiesMap(Map<String, String> cookies) {
        this.cookies = cookies;
    }

    public InitializerContext getInitializerContext() {
        return initializerContext;
    }

    public boolean hasFieldError(String fieldName) {
        Map<String, List<String>> errors = getFieldErrors();
        return errors != null && (!errors.isEmpty() && errors.containsKey(fieldName));
    }

    public String toLowerCase(String str) {
        return CommonValidator.isEmpty(str)
                ? str
                : str.toLowerCase();
    }

    public String toUpperCase(String str) {
        return CommonValidator.isEmpty(str)
                ? str
                : str.toUpperCase();
    }

    public Date getDateFromMillis(long date) {
        return new Date(date);
    }

    /**
     * If there is need to execute some code
     * before the execution of a action
     *
     * @throws InternalErrorException
     */
    public void prepare() throws InternalErrorException {
        // to be implemented later if it will be required
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
