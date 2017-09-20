package am.plexonic.core.manager.dao;

import am.plexonic.common.exception.DatabaseException;
import am.plexonic.core.manager.model.DAU;

import java.util.Date;
import java.util.List;

/**
 * Analytic dao interface
 */
public interface IAnalyticDao {

    List<DAU> getDAU(List<Date> dates) throws DatabaseException;

    List<DAU> getDAUByRetention(Date dateFrom, Date dateTo) throws DatabaseException;
}
