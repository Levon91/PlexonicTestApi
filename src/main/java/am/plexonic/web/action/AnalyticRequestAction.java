package am.plexonic.web.action;

import am.plexonic.common.dto.dau.DAUListResponseDto;
import am.plexonic.common.dto.general.ResponseStatus;
import am.plexonic.common.rs_utils.exception.ServerUnavailableException;
import am.plexonic.web.action.comon.BaseAction;
import am.plexonic.web.rs_client.IAnalyticServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Component
@Scope("prototype")
public final class AnalyticRequestAction extends BaseAction {

    @Autowired
    private IAnalyticServiceClient analyticServiceClient;

    private String date;

    private long dateLong;

    public String exec() throws Exception {
        try {
            DAUListResponseDto response = analyticServiceClient.getDAU(Arrays.asList(dateLong));
            if (response.getStatus() == ResponseStatus.SUCCESS) {
                session.put("dau", response);
                return SUCCESS;
            } else if (response.getStatus() == ResponseStatus.INTERNAL_ERROR) {
                setErrorMessage(response.getMessage());
                return ERROR;
            }
            if (response.getStatus() == ResponseStatus.NO_DATA_FOUND) {
                addActionError(getText("Data not found"));
            } else{
                addActionError(response.getMessage());
            }
            return INPUT;
        } catch (ServerUnavailableException e) {
            setErrorMessage("Service unavailable");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ERROR;
    }

    @Override
    public void validate() {
        if (date == null || date.isEmpty()) {
           addFieldError("date", "Empty date");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = format.parse(date);
            dateLong = parse.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getDateLong() {
        return dateLong;
    }

    public void setDateLong(long dateLong) {
        this.dateLong = dateLong;
    }
}
