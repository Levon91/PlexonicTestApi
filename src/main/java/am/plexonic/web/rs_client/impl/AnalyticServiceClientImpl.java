package am.plexonic.web.rs_client.impl;

import am.plexonic.common.dto.dau.DAUListResponseDto;
import am.plexonic.common.rs_utils.ServerPathProvider;
import am.plexonic.common.rs_utils.WSClientUtils;
import am.plexonic.web.rs_client.IAnalyticServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static am.plexonic.common.rs_utils.WSClientUtils.getExceptionBy;
import static am.plexonic.common.rs_utils.WSClientUtils.getServerUnavailableException;

/**
 * Implementation of IAnalyticServiceClient
 */
@Component
public final class AnalyticServiceClientImpl extends BaseServiceClient implements IAnalyticServiceClient {

    /**
     * Regular constructor.
     *
     * @param bsWSClient the client
     */
    @Autowired
    public AnalyticServiceClientImpl(Client bsWSClient) {
        super(bsWSClient);
    }

    @Override
    public DAUListResponseDto getDAU(List<Long> dates) throws Exception {
        String url = serverUrl + ServerPathProvider.TEST_API.getPath() + ServerPathProvider.DAU.getPath();
        try {

            Form form = new Form();
            for (Long date : dates) {
                form.param("dates", String.valueOf(date));
            }

            // gets response object to check its status
            Response response = client.target(url)
                    .request()
                    .accept(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));;

            if (response.getStatus() != Response.Status.OK.getStatusCode()) {
                throw getExceptionBy(response.getStatus(), "Failed to get DAU");
            }

            return response.readEntity(DAUListResponseDto.class);
        } catch (ProcessingException e) {
            System.out.println("Exception was thrown when getting DAU:");
            throw getServerUnavailableException(url, e);
        }
    }
}
