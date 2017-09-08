package am.plexonic.core.manager.dao.impl.internal.type;

import am.plexonic.core.manager.model.lcp.DayRange;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;

/**
 * Type handler
 */
public class DayRangeTypeHandler implements TypeHandler<DayRange> {
    public void setParameter(PreparedStatement ps, int i, DayRange parameter, JdbcType jdbcType) throws SQLException {
        if (parameter != null) {
            ps.setInt(i, parameter.getValue());
        } else {
            ps.setNull(i, Types.INTEGER);
        }
    }

    public DayRange getResult(ResultSet rs, String columnName) throws SQLException {
        DayRange result;
        int value = rs.getInt(columnName);
        if (rs.wasNull()) {
            result = null;
        } else {
            result = DayRange.valueOf(value);
        }
        return result;
    }

    public DayRange getResult(ResultSet rs, int columnIndex) throws SQLException {
        DayRange result;
        int value = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            result = null;
        } else {
            result = DayRange.valueOf(value);
        }
        return result;
    }

    public DayRange getResult(CallableStatement cs, int columnIndex) throws SQLException {
        DayRange result;
        int value = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            result = null;
        } else {
            result = DayRange.valueOf(value);
        }
        return result;
    }
}
