package am.plexonic.core.manager.service.rs;

import am.plexonic.common.dto.dau.DAUListResponseDto;
import am.plexonic.common.dto.general.ResponseDto;
import am.plexonic.common.dto.general.ResponseStatus;
import am.plexonic.common.exception.InternalErrorException;
import am.plexonic.common.rs_utils.PathConstants;
import am.plexonic.core.manager.businesslayer.IAnalyticManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Analytic service
 */
@Path(PathConstants.TEST_API)
@Produces(MediaType.APPLICATION_JSON)
@Component
public class AnalyticService {

    @Autowired
    private IAnalyticManager analyticManager;

    @GET
    @Path(PathConstants.AVAILABLE)
    public ResponseDto available() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.addMessage("Service available");
        responseDto.setStatus(ResponseStatus.SUCCESS);
        return responseDto;
    }

    @POST
    @Path(PathConstants.DAU)
    public DAUListResponseDto getDAU(@FormParam("dates") List<Long> dateList) {

        DAUListResponseDto response = new DAUListResponseDto();
        try {
            response = analyticManager.getDAU(dateList);
        } catch (InternalErrorException ex) {
            response.setStatus(ResponseStatus.INTERNAL_ERROR);
            String message = "Exception was thrown when getting DAU list";
            response.setMessage(message);
        }
        return response;
    }
}
