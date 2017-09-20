package am.plexonic.core.manager.dao.impl;

import am.plexonic.common.exception.DatabaseException;
import am.plexonic.core.manager.dao.IAnalyticDao;
import am.plexonic.core.manager.model.DAU;
import am.plexonic.core.manager.model.lcp.DayRange;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Analytic dao implementation
 */
@Repository
public class AnalyticDaoImpl extends BaseDao implements IAnalyticDao {

    public List<DAU> getDAU(List<Date> dates) throws DatabaseException {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("dates", dates);
            return sqlSession.selectList("db.mapper.AnalyticRequestMapper.getDAU", params);
        } catch (DataAccessException e) {
            throw new DatabaseException(e);
        }
    }

    public List<DAU> getDAUByRetention(Date dateFrom, Date dateTo) throws DatabaseException {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("dateFrom", dateFrom);
            params.put("dateTo", dateTo);
            return sqlSession.selectList("db.mapper.AnalyticRequestMapper.getDAUByRetention", params);
        } catch (DataAccessException e) {
            throw new DatabaseException(e);
        }
    }
}
