package am.plexonic.web.action;

import am.plexonic.web.action.comon.BaseAction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public final class AnalyticRequestViewAction extends BaseAction {

    public String view() {
        return SUCCESS;
    }

}
