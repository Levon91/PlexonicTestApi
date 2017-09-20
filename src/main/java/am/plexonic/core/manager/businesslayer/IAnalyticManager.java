package am.plexonic.core.manager.businesslayer;

import am.plexonic.common.dto.dau.DAUListResponseDto;
import am.plexonic.common.exception.InternalErrorException;
import am.plexonic.core.manager.model.lcp.DayRange;

import java.util.List;

/**
 * Analytic manager interface
 */
public interface IAnalyticManager {

    /**
     * Method wich returns daily active users
     * @param dates
     * @return DAUListResponseDto
     * @throws InternalErrorException
     */
    DAUListResponseDto getDAU(List<Long> dates) throws InternalErrorException;

    /**
     * Method wich returns daily active users by retention
     * @param dateFrom
     * @param retention
     * @return DAUListResponseDto
     * @throws InternalErrorException
     */
    DAUListResponseDto getDAUByRetention(Long dateFrom, Long retention) throws InternalErrorException;
}
