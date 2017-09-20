package am.plexonic.core.manager.businesslayer.impl;

import am.plexonic.common.dto.dau.DAUListResponseDto;
import am.plexonic.common.dto.general.ResponseStatus;
import am.plexonic.common.exception.DatabaseException;
import am.plexonic.common.exception.EntityNotFoundException;
import am.plexonic.common.exception.InternalErrorException;
import am.plexonic.common.utils.date_utils.LocalDateUtils;
import am.plexonic.core.manager.businesslayer.IAnalyticManager;
import am.plexonic.core.manager.dao.IAnalyticDao;
import am.plexonic.core.manager.model.DAU;
import am.plexonic.core.manager.model.lcp.DayRange;
import am.plexonic.core.manager.util.converter.dau.DAUConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implementation class of Analytic manager
 */
@Service
@Transactional
public class AnalyticManagerImpl implements IAnalyticManager {

    @Autowired
    private IAnalyticDao analyticDao;

    @Autowired
    private DAUConverter converter;

    @Override
    public DAUListResponseDto getDAU(List<Long> dates) throws InternalErrorException {

        DAUListResponseDto response = new DAUListResponseDto();
        List<Date> dateList = new ArrayList<>();
        try {

            for (Long date : dates) {
                Date sqlDate = new Date(date);
                dateList.add(sqlDate);
            }
            List<DAU> dau = analyticDao.getDAU(dateList);

            if (dau.isEmpty()) {
                response.setStatus(ResponseStatus.NO_DATA_FOUND);
                response.setMessage("No data found");
                return response;
            }
            response.setDtoList(converter.convert(dau));
            response.setStatus(ResponseStatus.SUCCESS);
            response.setMessage("DAU list");

        } catch (EntityNotFoundException e) {
            response.setStatus(ResponseStatus.NO_DATA_FOUND);
            response.setMessage("Entity not found");

        } catch (DatabaseException e) {
            String msg = "Failed to connect to database";
            throw new InternalErrorException(msg, e);
        }
        return response;
    }

    @Override
    public DAUListResponseDto getDAUByRetention(Long dateFrom, Long retention) throws InternalErrorException {
        DAUListResponseDto response = new DAUListResponseDto();
        try {

            Date fromDate = new Date(dateFrom);
            Date toDate = LocalDateUtils.plusDays(fromDate, retention);

            List<DAU> dau = analyticDao.getDAUByRetention(fromDate, toDate);

            if (dau.isEmpty()) {
                response.setStatus(ResponseStatus.NO_DATA_FOUND);
                response.setMessage("No data found");
                return response;
            }
            response.setDtoList(converter.convert(dau));
            response.setStatus(ResponseStatus.SUCCESS);
            response.setMessage("DAU list by retention");

        } catch (EntityNotFoundException e) {
            response.setStatus(ResponseStatus.NO_DATA_FOUND);
            response.setMessage("Entity not found");

        } catch (DatabaseException e) {
            String msg = "Failed to connect to database";
            throw new InternalErrorException(msg, e);
        }
        return response;
    }
}
