package am.plexonic.web.rs_client;

import am.plexonic.common.dto.dau.DAUListResponseDto;
import am.plexonic.core.manager.model.lcp.DayRange;

import java.util.List;

/**
 * Analytic request service client
 */
public interface IAnalyticServiceClient {

    DAUListResponseDto getDAU(List<Long> dates, int offset, int limit) throws Exception;

    DAUListResponseDto getDAUByRetention(Long dateFrom, DayRange retention, int offset, int limit) throws Exception;
}
