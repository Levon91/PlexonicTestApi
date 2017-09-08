package am.plexonic.core.manager.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Base dao
 */
public abstract class BaseDao {

    @Autowired
    protected SqlSession sqlSession;

}
